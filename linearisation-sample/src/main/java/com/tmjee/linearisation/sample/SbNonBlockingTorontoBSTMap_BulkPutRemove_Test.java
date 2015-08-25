package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_BulkPutRemove_Test;
import com.tmjee.linearisation.meta.Meta_Map_BulkPutRemove_Test;
import com.tmjee.linearisation.processor.*;

import java.util.Map;

import synchrobench.trees.lockfree.NonBlockingTorontoBSTMap;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_BulkPutRemove_Test.class)
public class SbNonBlockingTorontoBSTMap_BulkPutRemove_Test extends Abstract_Map_BulkPutRemove_Test {

    @Invariant
    public static class State extends Abstract_Map_BulkPutRemove_Test.AbstractState {
        final Map<Integer,Integer> m = new NonBlockingTorontoBSTMap<>();
        @Override protected Map<Integer, Integer> get() { return m; }
    }

    @TestUnit(name="SbNonBlockingTorontoBSTMap_BulkPutRemove_Test")
    public static class TestUnit1 extends Abstract_Map_BulkPutRemove_Test.AbstractTestUnit {
        @Player public void player1(State s, IntResult1 r) { _player1(s,r);}
        @Player public void player2(State s, IntResult1 r) { _player2(s,r);}
        @Arbiter public void arbiter(State s, IntResult1 r) { _arbiter(s,r);}
    }
}
