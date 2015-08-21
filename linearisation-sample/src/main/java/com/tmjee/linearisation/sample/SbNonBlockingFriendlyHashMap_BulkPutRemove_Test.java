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
public class SbNonBlockingFriendlyHashMap_BulkPutRemove_Test extends Abstract_Map_BulkPutRemove_Test {
    @Invariant
    public static class State extends Abstract_Map_BulkPutRemove_Test.AbstractState {
       final Map<Integer,Integer> m = new NonBlockingFriendlyHashMap<>();
        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }

    @TestUnit(name="SbNonBlockingFriendlyHashMap_BulkPutRemove_Test")
    public static class TestUnit1 extends Abstract_Map_BulkPutRemove_Test.AbstractTestUnit {
       @Player public void player1(State s, IntResult1 r) { _player1(s,r);}
        @Player public void player2(State s, IntResult1 r) { _player2(s, r);}
        @Arbiter public void arbier(State s, IntResult1 r) { _arbiter(s,r);}
    }
}
