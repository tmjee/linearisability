package com.tmjee.linearisation.processor;

import sample.SampleRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Linearisation {


    private static final String PREFIX = "PoolThread_";


    public void run(Arguments args) throws InterruptedException {
        AtomicInteger id = new AtomicInteger();
        ExecutorService pool = Executors.newCachedThreadPool((r)->{
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName(PREFIX+id.incrementAndGet());
            return t;
        });

        Scheduler scheduler = new Scheduler(args.userCpu());

        for (Test test : Tests.getAll().values()) {
            try {
                Runner runner = (Runner) Class.forName(test.runner()).newInstance();
                scheduler.schedule(new Scheduler.Task(){
                    @Override
                    public void run() {
                        runner.run();
                    }

                    @Override
                    int permits() {
                        return test.playerCount();
                    }
                });
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


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
    }
}
