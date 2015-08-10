package sample;

import com.tmjee.linearisation.processor.Arguments;
import com.tmjee.linearisation.processor.Control;
import com.tmjee.linearisation.processor.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author tmjee
 */
public class SampleRunner extends Runner {

    public SampleRunner(Arguments args, ExecutorService pool) {
        super(args, pool);
    }


    protected void internalRun() {
        LinearisabilityTest.TestUnit1 test = new LinearisabilityTest.TestUnit1();

        int strides = args.minStrides();
        Pair[] p = new Pair[strides];
        for (int a =0; a< strides; a++) {
            p[a] = new Pair(
                    new LinearisabilityTest.State(),
                    new LinearisabilityTest.Result());
        }

        Holder holder = new Holder(new AtomicReferenceArray<>(p));

        Control control = new Control(2);
        control.setRunning(true);

        AtomicInteger epoch = new AtomicInteger();
        List<Future> tasks = new ArrayList<>();
        tasks.add(pool.submit(() -> {
            new Runner1(control, args, test, new AtomicReference<Holder>(holder), epoch).run();
            return null;
        }));
        tasks.add(pool.submit(()->{
            new Runner2(control, args, test, new AtomicReference<Holder>(holder), epoch).run();
            return null;
        }));
        try {
            Thread.currentThread().sleep(args.time());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        control.setRunning(false);
        waitFor(tasks);
    }



    private static abstract class BaseRunner {

        protected final Control control;
        protected final Arguments args;
        protected final LinearisabilityTest.TestUnit1 test;
        protected final AtomicReference<Holder> holderRef;
        protected final AtomicInteger epoch;

        public BaseRunner(Control control, Arguments args, LinearisabilityTest.TestUnit1 test, AtomicReference<Holder> holderRef, AtomicInteger epoch) {
            this.control = control;
            this.args = args;
            this.test = test;
            this.holderRef = holderRef;
            this.epoch = epoch;
        }

        protected void restride() {
            // TODO: record stats

            Holder holder = holderRef.get();
            AtomicReferenceArray<Pair> pRef = holder.getPair();

            int length = pRef.length();
            int strides = Math.max(args.minStrides(), Math.min(length * 2, args.maxStrides()));

            Pair[] p = new Pair[strides];
            for (int a =0; a< strides; a++) {
                p[a] = new Pair(
                        new LinearisabilityTest.State(),
                        new LinearisabilityTest.Result());
            }

            holderRef.set(new Holder(new AtomicReferenceArray<>(p)));
        }

        public void run() throws BrokenBarrierException, InterruptedException {
            boolean firstToIncrementEpoch = false;
            AtomicInteger ep = epoch;
            int currentEpoch = 0;
            while(true) {
                Holder holder = holderRef.get();
                if (!control.isRunning()) {
                    return;
                }

                AtomicReferenceArray<Pair> pRef = holder.getPair();
                int pSize = pRef.length();

                control.getWaitForStartBarrier().await();

                for (int a = 0; a < pSize; a++) {
                    Pair p = pRef.get(a);

                    runPlayerAction(p);
                }

                control.getWaitForDoneBarrier().await();

                firstToIncrementEpoch = ep.compareAndSet(currentEpoch, currentEpoch + 1);
                if (firstToIncrementEpoch) {
                    restride();
                }
                currentEpoch++;

                control.getWaitForRestrideBarrier().await();

                if (firstToIncrementEpoch) {
                    control.resetBarriers();
                }
            }
        }

        protected abstract void runPlayerAction(Pair p);
    }


    private static class Runner2 extends BaseRunner {
        public Runner2(Control control, Arguments args, LinearisabilityTest.TestUnit1 test, AtomicReference<Holder> holderRef,
                       AtomicInteger epoch) {
            super(control, args, test, holderRef, epoch);
        }

        @Override
        protected void runPlayerAction(Pair p) {
            test.player2Action(p.s, p.r);
        }
    }


    private static class Runner1 extends BaseRunner {

        public Runner1(Control control, Arguments args, LinearisabilityTest.TestUnit1 test, AtomicReference<Holder> holderRef,
                       AtomicInteger epoch) {
            super(control, args, test, holderRef, epoch);
        }

        @Override
        protected void runPlayerAction(Pair p) {
            test.player1Action(p.s, p.r);
        }

    }


    private static class Holder {
        AtomicReferenceArray<Pair> pRef;

        Holder(AtomicReferenceArray<Pair> pRef) {
            this.pRef = pRef;
        }

        public AtomicReferenceArray<Pair> getPair() { return pRef; }
    }

    private static class Pair {
        private final LinearisabilityTest.State s;
        private final LinearisabilityTest.Result r;

        public Pair(LinearisabilityTest.State s, LinearisabilityTest.Result r) {
            this.s = s;
            this.r = r;
        }
    }

}
