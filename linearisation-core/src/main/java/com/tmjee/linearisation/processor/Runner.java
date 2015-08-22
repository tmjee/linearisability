package com.tmjee.linearisation.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public abstract class Runner {

    protected final Arguments args;
    protected final ExecutorService pool;
    protected final Test test;

    public Runner(Test test, Arguments args, ExecutorService pool) {
        this.test = test;
        this.args = args;
        this.pool = pool;
    }

    public void run() {
        Logger.log(format("Running test %s - %s", test.name(), test.description()));


        try {
            runVerification();
            Logger.log("verification run ok");
        } catch(Throwable t) {
            Logger.log("verification of test failed");
            Logger.log(t);
            return;
        }



        Accumulator totalAccumulator = new Accumulator();
        for (int a=0; a< args.iterations(); a++) {
            try {
                Logger.log("iteration #" + a);
                Accumulator accumulator = internalRun();
                totalAccumulator.record(accumulator);
            }catch(Throwable t) {
                Logger.log(t);
            }
        }
        dump(totalAccumulator);
    }

    private void dump(Accumulator accumulator) {
        Map<String, Long> m = accumulator.get();

        Map<String, Test.Consequence> x = new HashMap<>();
        test.consequences().forEach((c)->{
            x.put(c.id(), c);
        });


        // references
        StringBuilder sb = new StringBuilder();
        List<String> refs = test.references();
        if (!refs.isEmpty()) {
            sb.append(format("%n\tReferences:"));
            for (String ref : refs) {
                sb.append(format("%n\t\t- %s", ref));
            }
            sb.append(format("%n"));
        }

        // test results
        sb.append(format("%n"));
        sb.append(format("\t%-10s%-20s%-20s%-100s%n", "Id", "Count", "Expectation", "Description"));
        sb.append(format("\t%-10s%-20s%-20s%-100s%n", "--------", "-----------------", "------------------", "---------------------------------"));
        m.forEach((k, v) -> {
            if (x.containsKey(k)) {
                Test.Consequence c = x.get(k);
                sb.append(format("\t%-10s%-,20d%-20s%-100s%n", k, v, c.expectation().name(), c.description()));
                x.remove(k);
            } else {
                sb.append(format("\t%-10s%-,20d%-20s%-100s%n", k, v, Expectation.UNKNOWN.name(), "unknown"));
            }
        });


        // result in consequence but not found in actual run
        if (!x.isEmpty()) { // we found such cases
            x.forEach((k, v)->sb.append(format("\t%-10s%-,20d%-20s%-100s%n", k, 0L, v.expectation().name(), v.description())));
        }

        sb.append(format("%n"));

        Logger.log(format("%n%n\tSummary of Test %s (%s) :- %n%s", test.name(), test.description(), sb.toString()));
    }


    protected void waitFor(List<Future<?>> tasks) {
        boolean ended = false;
        while(!ended) {
            ended = true;
            for (Future<?> future : tasks) {
                try {
                    future.get(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Logger.log(e);
                } catch (ExecutionException e) {
                    Logger.log(e);
                } catch (TimeoutException e) {
                    ended = false;
                    boolean cancelled = future.cancel(true);
                    Logger.log(format("future %s cancel=%s", future, cancelled));
                    Logger.log(e);
                }
            }
        }
    }

    protected abstract Accumulator internalRun();
    protected abstract void runVerification() throws Throwable;
}
