package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutAndGet_Test;
import com.tmjee.linearisation.processor.IntResult2;
import com.tmjee.linearisation.processor.Invariant;
import com.tmjee.linearisation.processor.Player;
import com.tmjee.linearisation.processor.TestUnit;
import synchrobench.trees.lockfree.NonBlockingTorontoBSTMap;

import java.util.Map;

/**
 * @author tmjee
 */
public class SbNonBlockingTorontoBSTMap_PutAndGet_Test extends Abstract_Map_PutAndGet_Test {

    @Invariant
    public static class State extends Abstract_Map_PutAndGet_Test.AbstractState {
        final Map<Integer,Integer> m = new NonBlockingTorontoBSTMap();
        @Override protected Map<Integer, Integer> get() { return m; }
    }

    @TestUnit(name="SbNonBlockingTorontoBSTMap_PutAndGet_Test")
    public static class TestUnit1 extends Abstract_Map_PutAndGet_Test.AbstractTestUnit {
        @Player public void player1(State s, IntResult2 r) { _player1(s,r);}
        @Player public void player2(State s, IntResult2 r) { _player2(s,r);}
    }
}
