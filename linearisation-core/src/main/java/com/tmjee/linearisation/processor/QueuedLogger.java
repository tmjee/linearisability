package com.tmjee.linearisation.processor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class QueuedLogger {

    volatile boolean running = false;

    static AtomicInteger I = new AtomicInteger(0);

    static ExecutorService E = Executors.newSingleThreadExecutor((r)->{
        Thread t = new Thread(r);
        t.setName(format("LogRunner %s", I.incrementAndGet()));
        t.setDaemon(true);
        return t;
    });

    final BlockingQueue<Tuple> Q = new LinkedBlockingQueue<>();

    public void start() {
        E.submit(()->{
            running = true;
            while(running && !Thread.currentThread().isInterrupted()) {
                Tuple t = null;
                try {
                    t = Q.take();
                    System.out.println(t.msg);
                    if (t.t != null) {
                        t.t.printStackTrace(System.out);
                    }
                } catch (InterruptedException e) {
                    System.out.println(format("[linearisability] %s logger taker interrupted", Thread.currentThread()));
                    return;
                }
            }
        });
    }

    public void stop() throws InterruptedException {
        running = false;
        E.shutdown();
        E.awaitTermination(10, TimeUnit.SECONDS);
    }

    public void log(String msg, Throwable t) {
        try {
            Q.put(new Tuple(msg, t));
        } catch (InterruptedException e) {
            System.out.println(format("[linearisability] %s logger submitter interrupted", Thread.currentThread()));
        }
    }

    static class Tuple {
        String msg;
        Throwable t;
        Tuple(String msg, Throwable t) {
           this.msg = msg; this.t = t;
        }
    }
}
