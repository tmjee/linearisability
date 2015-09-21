package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutRunningCount_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutRunningCount_Test;
import com.tmjee.linearisation.processor.*;
import synchrobench.hashtables.lockfree.NonBlockingFriendlyHashMap;

import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_PutRunningCount_Test.class)
public class SbNonBlockingFriendlyHashMap_PutRunningCount_Test extends Abstract_Map_PutRunningCount_Test{

    @Invariant
    public static class State {
        final NonBlockingFriendlyHashMap<Integer,Integer> m = new NonBlockingFriendlyHashMap<>();
    }

    @TestUnit(name="SbNonBlockingFriendlyHashMap_PutRunningCount_Test")
    public static class TestUnit1 {
        @Player
        public void player1(State state, IntResult1 r) {
            try {
                NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
                for (int a = 0; a < 100; a++) {
                    m.put(a, a);
                }
            }catch(Exception e) {
                Logger.log("Player 1 experience exception", e);
            }
        }

        @Player
        public void player2(State state, IntResult1 r) {
            try {
                NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
                for (int b = 100; b < 300; b++) {
                    m.put(b, b);
                }
            } catch(Exception e) {
                Logger.log("Player 2 experience exception", e);
            }
        }

        @Player
        public void arbiter(State state, IntResult1 r) {
            NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
            int size = m.size();
            r.value1 = ((size == 300)?1:-1);
        }
    }
}
