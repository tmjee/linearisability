package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutAndGet_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutAndGet_Test;
import com.tmjee.linearisation.processor.*;
import synchrobench.trees.lockbased.stanfordutils.SnapHashMap;

import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_PutAndGet_Test.class)
public class SbSnapHashMap_PutAndGet_Test extends Abstract_Map_PutAndGet_Test {

    @Invariant
    public static class State extends Abstract_Map_PutAndGet_Test.AbstractState {
        final Map<Integer, Integer> m = new SnapHashMap<>();
        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }

    @TestUnit(name="SbSnapHashMap_PutAndGet_Test")
    public static class TestUnit1 extends Abstract_Map_PutAndGet_Test.AbstractTestUnit {
        @Player  public void player1(State s, IntResult2 r) { _player1(s,r); }
        @Player  public void player2(State s, IntResult2 r) { _player2(s,r); }
    }
}
