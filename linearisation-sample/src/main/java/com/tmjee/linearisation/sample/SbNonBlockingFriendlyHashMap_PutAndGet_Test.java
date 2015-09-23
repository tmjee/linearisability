package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutAndGet_Test;
import com.tmjee.linearisation.abstrack.Abstract_Map_PutRunningCount_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutAndGet_Test;
import com.tmjee.linearisation.processor.*;
import synchrobench.hashtables.lockfree.NonBlockingFriendlyHashMap;

import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_PutAndGet_Test.class)
public class SbNonBlockingFriendlyHashMap_PutAndGet_Test {

    @Invariant
    public static class State {
        final NonBlockingFriendlyHashMap<Integer,Integer> m = new NonBlockingFriendlyHashMap<>();
    }

    @TestUnit(name="SbNonBlockingFriendlyHashMap_PutAndGet_Test")
    public static class TestUnit1 {
        @Player
        public void player1(State state, IntResult2 r) {
            try {
                final NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
                m.putIfAbsent(1, 1);
                Integer i = m.get(1);
                r.value1 = (i == null ? -1 : (i != 1 ? -1 : 1));
            } catch (Throwable t) {
                Logger.log("Player 1 experienced exception", t);
                r.value1 = -2;
            }
        }

        @Player
        public void player2(State state, IntResult2 r) {
            try {
                final NonBlockingFriendlyHashMap<Integer, Integer> m = state.m;
                m.putIfAbsent(2, 1);
                Integer i = m.get(2);
                r.value2 = (i == null ? -1 : (i != 1 ? -1 : 1));
            } catch (Throwable t) {
                Logger.log("Player 2 experienced exception", t);
                r.value2 = -2;
            }
        }
    }
}
