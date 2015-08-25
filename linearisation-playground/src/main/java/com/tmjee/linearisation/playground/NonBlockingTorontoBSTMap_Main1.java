package com.tmjee.linearisation.playground;

import synchrobench.trees.lockfree.NonBlockingTorontoBSTMap;

import java.util.Map;

import static com.tmjee.linearisation.playground.Log.*;
/**
 * @author tmjee
 */
public class NonBlockingTorontoBSTMap_Main1 {


    public static void main(String[] args) throws Exception {

        final Map<Integer, Integer> m = new NonBlockingTorontoBSTMap();
        //final NonBlockingTorontoBSTMap<Integer, Integer> m = new NonBlockingTorontoBSTMap();


        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                for (int a=0; a<300; a++) {
                    m.put(a,a);
                }
                log("done");
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                for (int b=0; b<300; b++) {
                    log(""+b);
                    while (!m.containsKey(b)) {
                        Thread.currentThread().yield();
                    }
                    log(b+" ok");
                }
                log("done");
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
