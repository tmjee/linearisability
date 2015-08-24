package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Set_SetAndGet_Test;
import com.tmjee.linearisation.meta.Meta_Set_SetAndGet_Test;
import com.tmjee.linearisation.processor.*;
import synchrobench.linkedlists.lockbased.lazyutils.LazySet;

import java.util.Set;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Set_SetAndGet_Test.class)
public class LazySet_SetAndGet_Test extends Abstract_Set_SetAndGet_Test {

    @Invariant
    public static class State extends Abstract_Set_SetAndGet_Test.AbstractState {
        volatile Set<Integer> s = new LazySet<Integer>(2);
        @Override
        protected Set<Integer> get() {
            return s;
        }
    }

    @TestUnit(name="LazySet_SetAndGet_Test")
    public static class TestUnit1 extends Abstract_Set_SetAndGet_Test.AbstractTestUnit {
        @Player public void player1(State s, IntResult2 r) { _player1(s,r); }
        @Player public void player2(State s, IntResult2 r) { _player2(s,r); }
    }

}
