package sample;

import com.tmjee.linearisation.processor.*;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

import static java.lang.String.format;


/**
 * @author tmjee
 */
public class SampleRunner extends Runner {

    public SampleRunner(Test test, Arguments args, ExecutorService pool) {
        super(test, args, pool);
    }


    protected Accumulator internalRun() {
        Accumulator accumulator = new Accumulator();

        LinearisabilityTest.TestUnit1 test = new LinearisabilityTest.TestUnit1();

        int strides = args.minStrides();
        Pair[] p = new Pair[strides];
        for (int a =0; a< strides; a++) {
            p[a] = new Pair(
                    new LinearisabilityTest.State(),
                    new LinearisabilityTest.Result());
        }

        AtomicReference<Holder> holder = new AtomicReference<>(new Holder(new AtomicReferenceArray<>(p)));
        AtomicReference<Control> control = new AtomicReference<>(new Control(2));
        State state = new State();

        AtomicInteger epoch = new AtomicInteger();
        List<Future<?>> tasks = new ArrayList<>();
        tasks.add(pool.submit(() -> {
            new Worker1(accumulator, state, control, args, test, holder, epoch).run();
            return null;
        }));
        tasks.add(pool.submit(()->{
            new Worker2(accumulator, state, control, args, test, holder, epoch).run();
            return null;
        }));
        try {
            Thread.currentThread().sleep(args.time());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state.running = false;
        waitFor(tasks);

        return accumulator;
    }



    private static abstract class BaseWorker {

        protected final Accumulator accumulator;
        protected final AtomicReference<Control> controlRef;
        protected final Arguments args;
        protected final LinearisabilityTest.TestUnit1 test;
        protected final AtomicReference<Holder> holderRef;
        protected final AtomicInteger epoch;
        protected final State state;

        public BaseWorker(Accumulator accumulator, State state, AtomicReference<Control> controlRef, Arguments args, LinearisabilityTest.TestUnit1 test,
                          AtomicReference<Holder> holderRef, AtomicInteger epoch) {
            this.accumulator = accumulator;
            this.controlRef = controlRef;
            this.args = args;
            this.test = test;
            this.holderRef = holderRef;
            this.epoch = epoch;
            this.state = state;
        }


        protected void resetControl() {
            controlRef.set(new Control(controlRef.get()));
        }

        protected void restride() {

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
            long total = 0;
            while(true) {

                Holder holder = holderRef.get();
                Control control = controlRef.get();
                final boolean running = state.running;

                if (!running) {
                    Logger.log("exited "+total);
                    return;
                }

                AtomicReferenceArray<Pair> pRef = holder.getPair();
                int pSize = pRef.length();

                control.waitForStart();

                for (int a = 0; a < pSize; a++) {
                    Pair p = pRef.get(a);

                    runPlayerAction(p);
                }

                control.waitForDone();

                for (int a=0; a< pSize; a++) {
                    Pair p = pRef.get(a);
                    accumulator.record(p.r.toString());
                }

                firstToIncrementEpoch = ep.compareAndSet(currentEpoch, currentEpoch + 1);
                if (firstToIncrementEpoch) {
                    restride();
                    resetControl();
                }
                currentEpoch++;


                while (currentEpoch != ep.get()) {
                    Thread.yield();
                }

                control.waitForRestride();
            }
        }

        protected abstract void runPlayerAction(Pair p);
    }


    private static class Worker2 extends BaseWorker {
        public Worker2(Accumulator accumulator, State state, AtomicReference<Control> controlRef, Arguments args, LinearisabilityTest.TestUnit1 test, AtomicReference<Holder> holderRef,
                       AtomicInteger epoch) {
            super(accumulator, state, controlRef, args, test, holderRef, epoch);
        }

        @Override
        protected void runPlayerAction(Pair p) {
            test.player2Action(p.s, p.r);
        }
    }


    private static class Worker1 extends BaseWorker {

        public Worker1(Accumulator accumulator, State state, AtomicReference<Control> controlRef, Arguments args, LinearisabilityTest.TestUnit1 test, AtomicReference<Holder> holderRef,
                       AtomicInteger epoch) {
            super(accumulator, state, controlRef, args, test, holderRef, epoch);
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
