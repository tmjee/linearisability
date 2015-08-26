package com.tmjee.linearisation.processor;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Linearisation {


    private static final String PREFIX = "Pool_Thread_";


    public void run(Arguments args) throws InterruptedException {
        QueuedLogger ql = new QueuedLogger();
        ql.start();

        Logger.setLogger(ql);

        System.out.println("*** here");


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


        Scheduler scheduler = new Scheduler(args.userCpu());

        Map<String, Test> allTests = args.isRunAllTests() ?
                Tests.getAll() : Tests.getByClass(args.testClasses());

        for (final Test test : allTests.values()) {
            try {
                Class<?> runnerClass =  Class.forName(test.runner().packageName+"."+test.runner().className);
                Constructor<?> c = runnerClass.getConstructor(Test.class, Arguments.class, ExecutorService.class);
                Runner runner = (Runner) c.newInstance(test, args, pool);

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

            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException |
                     NoSuchMethodException | InvocationTargetException e) {
                Logger.log(e);
            }
        }

        Logger.log("Scheduler waiting for tests to finish ...");
        scheduler.waitToEnd();
        Logger.log("Scheduler end.");

        Logger.log("Shutdown pool ...");
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        Logger.log("Pool end.");

        ql.stop();

        System.out.println("Bye");
    }
}
