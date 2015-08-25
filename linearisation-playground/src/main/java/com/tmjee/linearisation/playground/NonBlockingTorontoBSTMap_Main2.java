package com.tmjee.linearisation.playground;

import synchrobench.trees.lockfree.NonBlockingTorontoBSTMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.tmjee.linearisation.playground.Log.*;

/**
 * @author tmjee
 */
public class NonBlockingTorontoBSTMap_Main2 {


    public static void main(String[] args) throws Exception {

        final Map<Integer, Integer> m = new NonBlockingTorontoBSTMap<Integer,Integer>();

        m.put(1,1);
        System.out.println(m.containsKey(1));
        System.out.println(m.size());
        System.out.println(m.get(1));
        //System.out.println(m.entrySet().iterator().next().getKey().getClass());


        for (int a=0; a<300; a++) {
            m.put(a,a);
        }

        log("done inserting");

        for (int b=0; b<300; b++) {
            while (!m.containsKey(b)) {
                Thread.currentThread().yield();
            }
            log(b+" ok");
        }
    }
}
