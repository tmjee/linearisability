package com.tmjee.linearisation.processor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Scheduler {

    private final String PREFIX = "Scheduler_Thread_";
    private final AtomicInteger id;

    private final int totalPermits;

    private final ExecutorService executorService;
    private final Semaphore semaphore;

    public Scheduler(int totalPermits) {
        this.totalPermits = totalPermits;
        id = new AtomicInteger();
        semaphore = new Semaphore(totalPermits);
        ThreadFactory threadFactory = (r) -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setPriority(Thread.MAX_PRIORITY);
            t.setName(PREFIX + id.incrementAndGet());
            return t;
        };


        executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                threadFactory){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t != null) {
                    t.printStackTrace();
                }
            }
        };
    }

    public void schedule(Task task) throws InterruptedException {
        int taskPermits = Math.min(totalPermits, task.permits());
        semaphore.acquire(taskPermits);
        executorService.submit(() -> {
            try {
                task.run();
            } finally {
                semaphore.release(taskPermits);
            }
        });
    }


    public void waitToEnd() throws InterruptedException {
       executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }


    /**
     * @author tmjee
     */
    public static abstract class Task implements Runnable {
        abstract int permits();
    }
}
