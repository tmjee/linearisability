package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_BulkPutRemove_Test;
import com.tmjee.linearisation.meta.Meta_Map_BulkPutRemove_Test;
import com.tmjee.linearisation.processor.*;
import synchrobench.hashtables.lockfree.NonBlockingFriendlyHashMap;

import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_BulkPutRemove_Test.class)
public class SbNonBlockingFriendlyHashMap_BulkPutRemove_Test {
    @Invariant
    public static class State {
        final NonBlockingFriendlyHashMap<Integer, Integer> m = new NonBlockingFriendlyHashMap<>();
    }

    @TestUnit(name="SbNonBlockingFriendlyHashMap_BulkPutRemove_Test")
    public static class TestUnit1 {

        @Player
        public void player1(State state, IntResult1 r) {
            NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
            try {
                for (int a = 0; a < 300; a++) {
                    m.putIfAbsent(a, a);
                }
            }catch(Exception e) {
                Logger.log("Player 1 experienced exception", e);
            }
        }

        @Player
        public void player2(State state, IntResult1 r) {
            try {
                NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
                for (int b = 0; b < 100; b++) {
                    while (!m.containsKey(b)) {
                        Thread.currentThread().yield();
                    }
                    m.remove(b);
                }
            }catch(Exception e) {
                Logger.log("Player 2 experienced exception", e);
            }
        }

        @Arbiter
        public void arbiter(State state, IntResult1 r) {
            NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
            int size = m.size();
            r.value1 = (size == 200 ? 1 : -1);
        }
    }
}
