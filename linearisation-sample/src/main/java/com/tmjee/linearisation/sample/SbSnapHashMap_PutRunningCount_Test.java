package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutRunningCount_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutRunningCount_Test;
import com.tmjee.linearisation.processor.*;
import synchrobench.trees.lockbased.stanfordutils.SnapHashMap;

import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_PutRunningCount_Test.class)
public class SbSnapHashMap_PutRunningCount_Test extends Abstract_Map_PutRunningCount_Test {
    @Invariant
    public static class State extends Abstract_Map_PutRunningCount_Test.AbstractState {
        final Map<Integer, Integer> m = new SnapHashMap<>();
        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }

    @TestUnit(name="SbSnapHashMap_PutRunningCount_Test")
    public static class TestUnit1 extends Abstract_Map_PutRunningCount_Test.AbstractTestUnit {
        @Player  public void player1(State s, IntResult1 r) { _player1(s,r);}
        @Player  public void player2(State s, IntResult1 r) { _player2(s,r);}
        @Player  public void arbiter(State s, IntResult1 r) { _arbiter(s,r);}
    }
}
