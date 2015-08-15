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

        StringBuilder sb = new StringBuilder();
        sb.append(format("%n"));
        sb.append(format("\t%-10s%-20s%-20s%-100s%n", "Id", "Count", "Expectation", "Description"));
        sb.append(format("\t%-10s%-20s%-20s%-100s%n", "--------", "-----------------", "------------------", "---------------------------------"));
        m.forEach((k, v) -> {
            if (x.containsKey(k)) {
                Test.Consequence c = x.get(k);
                sb.append(format("\t%-10s%-,20d%-20s%-100s%n", k, v, c.expectation().name(), c.description()));
            } else {
                sb.append(format("\t%-10s%-,20d%-20s%-100s%n", k, v, Expectation.UNKNOWN.name(), "unknown"));
            }
        });
        sb.append(format("%n"));

        Logger.log(format("%nSummary of Test %s (%s) :- %s", test.name(), test.description(), sb.toString()));
    }


    protected void waitFor(List<Future<?>> tasks) {
        boolean ended = false;
        while(!ended) {
            ended = true;
            for (Future<?> future : tasks) {
                try {
                    future.get(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Logger.log(e);
                } catch (ExecutionException e) {
                    Logger.log(e);
                } catch (TimeoutException e) {
                    ended = false;
                    boolean cancelled = future.cancel(false);
                    Logger.log(format("future %s cancel=%s", future, cancelled));
                    Logger.log(e);
                }
            }
        }
    }

    protected abstract Accumulator internalRun();
}
