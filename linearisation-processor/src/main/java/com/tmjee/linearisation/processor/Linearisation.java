package com.tmjee.linearisation.processor;

import sample.SampleRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Linearisation {


    private static final String PREFIX = "PoolThread_";


    public void run(Arguments args) throws InterruptedException {
        AtomicInteger id = new AtomicInteger();
        ThreadFactory threadFactory = (r)->{
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName(PREFIX+id.incrementAndGet());
            return t;
        };

        ExecutorService pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t != null) {
                    t.printStackTrace();
                }
            }
        };




        TestResultWriter writer = new TestResultWriter(args.output());

        Scheduler scheduler = new Scheduler(args.userCpu());

        for (Test test : Tests.getAll().values()) {
            try {
                Class<?> runnerClass =  Class.forName(test.runner().packageName+"."+test.runner().className);
                Constructor<?> c = runnerClass.getConstructor(Arguments.class, ExecutorService.class, TestResultWriter.class);
                Runner runner = (Runner) c.newInstance(args, pool, writer);

                scheduler.schedule(new Scheduler.Task(){
                    @Override
                    public void run() {
                        runner.run();
                    }

                    @Override
                    int permits() {
                        return test.testsCount();
                    }
                });
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

/*
        scheduler.schedule(new Scheduler.Task() {
            @Override
            int permits() {
                return 2;
            }

            @Override
            public void run() {
                SampleRunner runner = new SampleRunner(args, pool);
                runner.run();
            }
        });
 */
        System.out.println("waiting");
        scheduler.waitToEnd();
        System.out.println("end");
    }
}
