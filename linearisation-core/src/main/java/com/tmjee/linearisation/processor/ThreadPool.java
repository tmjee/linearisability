package com.tmjee.linearisation.processor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class ThreadPool {

    private static final String PREFIX = "Pool_Thread_";

    private final AtomicInteger id;
    private final ThreadFactory threadFactory;
    private final ExecutorService pool;


    public ThreadPool() {

        id = new AtomicInteger();

        threadFactory = (r)->{
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName(PREFIX+id.incrementAndGet());
            return t;
        };

        pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
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

    public Future<?> submit(Runnable r) {
        return pool.submit(r);
    }


    public <V> Future<V> submit(Callable<V> c) {
       return pool.submit(c);
    }

    public void shutdown(long t, TimeUnit tu) throws InterruptedException {
        pool.shutdown();
        pool.awaitTermination(t, tu);
    }

}
