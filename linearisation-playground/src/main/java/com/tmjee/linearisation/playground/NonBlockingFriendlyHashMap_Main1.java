package com.tmjee.linearisation.playground;

import synchrobench.hashtables.lockfree.NonBlockingFriendlyHashMap;

import java.util.Map;

/**
 * @author tmjee
 */
public class NonBlockingFriendlyHashMap_Main1 {


    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> m = new NonBlockingFriendlyHashMap<>();

        for (int a=0; a<100; a++) {
            m.put(a,a);
        }

        for (int a=0;a <100;a++) {
            System.out.println(m.get(a));
        }


    }
}
