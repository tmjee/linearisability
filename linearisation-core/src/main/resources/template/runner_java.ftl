<#assign testClassClassName=test.testClass().className()>
<#assign testClassPackageName=test.testClass().packageName()>
<#assign runnerClassName=test.runner().className()>
<#assign runnerPackageName=test.runner().packageName()>
<#assign invariantClassName=test.invariant().className()>
<#assign invariantPackageName=test.invariant().packageName()>
<#assign recordClassName=test.record().className()>
<#assign recordPackageName=test.record().packageName()>
<#assign testMethods=test.testMethods()>
<#assign testMethodsCount=test.testsCount()>
<#assign hasArbiterMethod=(test.arbiterMethod())??>
<#assign arbiterMethod=test.arbiterMethod()!"<<< no arbiter method >>>">

/**
 * This class is generated by linearisation-processor. Please do not edit
 * as it will be overridden.
 */
package ${runnerPackageName};

import com.tmjee.linearisation.processor.*;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

import ${testClassPackageName}.*;
<#if (invariantPackageName != testClassPackageName)>
import ${invariantPackageName}.*;
</#if>
<#if (recordPackageName != testClassPackageName)>
import ${recordPackageName}.*;
</#if>
<#if (runnerPackageName != testClassPackageName)>
import ${runnerPackageName}.*;
</#if>

public class ${runnerClassName} extends Runner {

    public ${runnerClassName}(Test test, Arguments args, ExecutorService pool) {
        super(test, args, pool);
    }

    protected void runVerification() throws Throwable{
/*
        ${testClassClassName} test = new ${testClassClassName}();
        ${invariantClassName} s = new ${invariantClassName}();
        ${recordClassName} r = new ${recordClassName}();

        List<Future<?>> tasks = new ArrayList<>();

        <#list testMethods as testMethod>
        tasks.add(pool.submit(()->{
           test.${testMethod.methodName()}(s,r);
            return;
        });
        </#list>
*/
    }

    protected Accumulator internalRun() {
        Accumulator accumulator = new Accumulator();

        ${testClassClassName} test = new ${testClassClassName}();

        int strides = args.minStrides();
        Pair[] p = new Pair[strides];
        for (int a =0; a< strides; a++) {
            p[a] = new Pair(
                new ${invariantClassName}(),
                new ${recordClassName}());
        }

        AtomicReference<Holder> holder = new AtomicReference<>(new Holder(new AtomicReferenceArray<>(p)));
        AtomicReference<Control> control = new AtomicReference<>(new Control(${testMethodsCount}));
        State state = new State();

        AtomicInteger epoch = new AtomicInteger();

        List<Future<?>> tasks = new ArrayList<>();

        <#list testMethods as testMethod>
        <#assign counter=testMethod?counter>
        tasks.add(pool.submit(() -> {
            new Worker${counter}(accumulator, state, control, args, test, holder, epoch).run();
            return null;
        }));
        </#list>

        try {
            Thread.currentThread().sleep(args.time());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        state.running=false;
        waitFor(tasks);
        return accumulator;
    }


    private static abstract class BaseWorker {

        protected final Accumulator accumulator;
        protected final AtomicReference<Control> controlRef;
        protected final Arguments args;
        protected final ${testClassClassName} test;
        protected final AtomicReference<Holder> holderRef;
        protected final AtomicInteger epoch;
        protected final State state;

        public BaseWorker(Accumulator accumulator, State state, AtomicReference<Control> controlRef,
                        Arguments args, ${testClassClassName} test, AtomicReference<Holder> holderRef,
                        AtomicInteger epoch) {
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

            int diff = strides - length;
            if (diff > 0) {
               Pair[] p = new Pair[strides];
               for (int a=0; a<length; a++) {
                  p[a]=pRef.get(a);
               }
               for (int a=length; a<strides; a++) {
                  p[a] = new Pair(
                     new ${invariantClassName}(),
                     new ${recordClassName}());
               }
               holderRef.set(new Holder(new AtomicReferenceArray<>(p)));
            }
        }

        protected void accumulateStrideResult(AtomicReferenceArray<Pair> pRef) {
            int pSize = pRef.length();
            for (int a=0; a< pSize; a++) {
                Pair p = pRef.get(a);
                accumulator.record(p.r.toString());
            }
        }

        protected void runPlayer(AtomicReferenceArray<Pair> pRef) {
            int pSize = pRef.length();
            for (int a=0; a<pSize; a++) {
                Pair p = pRef.get(a);
                try {
                    runPlayerAction(p);
                } catch(Throwable t) {
                    Logger.log("error while running player's action", t);
                    return;
                }
            }
        }

        protected void runArbiter(AtomicReferenceArray<Pair> pRef) {
            // content only available when there is an @Arbiter configured
            <#if hasArbiterMethod>
            int pSize = pRef.length();
            for (int a=0; a<pSize; a++) {
                try {
                   Pair p = pRef.get(a);
                   test.${arbiterMethod.methodName()}(p.s,p.r);
                } catch(Throwable t) {
                    Logger.log("error while running actor's action", t);
                    return;
                }
            }
            </#if>
        }

        public void run() throws InterruptedException {
            boolean firstToIncrementEpoch = false;
            AtomicInteger ep = epoch;
            int currentEpoch = 0;

            while(true) {
                Holder holder = holderRef.get();
                Control control = controlRef.get();
                final boolean running = state.running;

                AtomicReferenceArray<Pair> pRef = holder.getPair();

                control.waitForStart();

                if ((!running) || Thread.currentThread().isInterrupted()) {
                    Logger.log(format("worker exit, interrupted=%s",Thread.currentThread().isInterrupted()));
                    return;
                }


                runPlayer(pRef);


                control.waitForDone();


                firstToIncrementEpoch = ep.compareAndSet(currentEpoch, currentEpoch + 1);
                if (firstToIncrementEpoch) {
                    runArbiter(pRef);
                    accumulateStrideResult(pRef);
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


    <#list testMethods as testMethod>
    <#assign counter=testMethod?counter>
    private static class Worker${counter} extends BaseWorker {
        public Worker${counter}(Accumulator accumulator, State state, AtomicReference<Control> control,
                                Arguments args, ${testClassClassName} test, AtomicReference<Holder> holderRef,
                                AtomicInteger epoch) {
            super(accumulator, state, control, args, test, holderRef, epoch);
        }

        @Override
        protected void runPlayerAction(Pair p) {
            test.${testMethod.methodName()}(p.s, p.r);
        }
    }
    </#list>



    private static class Holder {
        AtomicReferenceArray<Pair> pRef;

        Holder(AtomicReferenceArray<Pair> pRef) {
             this.pRef = pRef;
        }

        public AtomicReferenceArray<Pair> getPair() { return pRef; }
    }

    private static class Pair {
        private final ${invariantClassName} s;
        private final ${recordClassName} r;

        public Pair(${invariantClassName} s, ${recordClassName} r) {
            this.s = s;
            this.r = r;
        }
    }
}
