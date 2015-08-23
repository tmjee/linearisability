package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Set_SetAndGet_Test;
import com.tmjee.linearisation.meta.Meta_Set_SetAndGet_Test;
import com.tmjee.linearisation.processor.*;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Set_SetAndGet_Test.class)
public class ConcurrentSkipListSet_SetAndGet_Test extends Abstract_Set_SetAndGet_Test {


    @Invariant
    public static class State extends Abstract_Set_SetAndGet_Test.AbstractState {
        final Set<Integer> s = new ConcurrentSkipListSet();
        @Override protected Set<Integer> get() {
            return s;
        }
    }


    @TestUnit(name = "ConcurrentSkipListSet_SetAndGet_Test", description = "ConcurrentSkipListSet Set and Get Test")
    public static class TestUnit1 extends Abstract_Set_SetAndGet_Test.AbstractTestUnit {

        @Player
        public void player1(State state, IntResult2 r) {
            _player1(state, r);
        }

        @Player
        public  void player2(State state, IntResult2 r) {
            _player2(state, r);
        }
    }
}
