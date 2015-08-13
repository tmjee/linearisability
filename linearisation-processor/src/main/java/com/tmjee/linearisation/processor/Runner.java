package com.tmjee.linearisation.processor;

import java.util.List;
import java.util.concurrent.*;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public abstract class Runner {

    protected final Arguments args;
    protected final ExecutorService pool;
    protected final TestResultWriter writer;
    protected final Test test;

    public Runner(Test test, Arguments args, ExecutorService pool, TestResultWriter writer) {
        this.test = test;
        this.args = args;
        this.pool = pool;
        this.writer = writer;
    }

    public void run() {
        Logger.log(format("Running test %s - %s", test.name(), test.description()));
        for (int a=0; a< args.iterations(); a++) {
            Logger.log("iteration #" + a);
            internalRun();
        }
    }


    protected void waitFor(List<Future<?>> tasks) {
        for (Future<?> future : tasks) {
            try {
                future.get(1, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void internalRun();
}
