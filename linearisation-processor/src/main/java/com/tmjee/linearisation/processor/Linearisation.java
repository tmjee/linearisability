package com.tmjee.linearisation.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Linearisation {


    private static final String PREFIX = "Pool_Thread_";


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


        TestResultWriter writer = new TestResultWriter(args.output());

        Scheduler scheduler = new Scheduler(args.userCpu());

        for (Test test : Tests.getAll().values()) {
            try {
                Class<?> runnerClass =  Class.forName(test.runner().packageName+"."+test.runner().className);
                Constructor<?> c = runnerClass.getConstructor(Test.class, Arguments.class, ExecutorService.class, TestResultWriter.class);
                Runner runner = (Runner) c.newInstance(test, args, pool, writer);

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

        Logger.log("Scheduler waiting for tests to finish ...");
        scheduler.waitToEnd();
        Logger.log("Scheduler end.");
        writer.writeSummary();
        Logger.log("Bye !");
    }
}
