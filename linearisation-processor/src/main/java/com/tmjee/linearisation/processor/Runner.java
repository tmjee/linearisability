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
            try {
                Logger.log("iteration #" + a);
                internalRun();
            }catch(Throwable t) {
                Logger.log(t);
            }
        }
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

    protected abstract void internalRun();
}
