package com.tmjee.linearisation.processor;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author tmjee
 */
public abstract class Runner {

    protected final Arguments args;
    protected final ExecutorService pool;

    public Runner(Arguments args, ExecutorService pool) {
        this.args = args;
        this.pool = pool;
    }

    public void run() {
        for (int a=0; a< args.iterations(); a++) {
            internalRun();
        }
    }


    protected void waitFor(List<Future> tasks) {
        for (Future future : tasks) {
            try {
                future.get(1, TimeUnit.SECONDS);
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
