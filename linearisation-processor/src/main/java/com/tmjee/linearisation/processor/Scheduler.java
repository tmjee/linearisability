package com.tmjee.linearisation.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Scheduler {

    private final String PREFIX = "SchedulerThread_";
    private final AtomicInteger id;

    private final int totalPermits;

    private final ExecutorService executorService;
    private final Semaphore semaphore;

    public Scheduler(int totalPermits) {
        this.totalPermits = totalPermits;
        id = new AtomicInteger();
        semaphore = new Semaphore(totalPermits);
        executorService = Executors.newCachedThreadPool((r)->{
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setPriority(Thread.MAX_PRIORITY);
            t.setName(PREFIX+id.incrementAndGet());
            return t;
        });
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



    public static abstract class Task implements Runnable {
        abstract int permits();
    }
}
