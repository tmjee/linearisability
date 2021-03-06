package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_List_SetAndGet_Test;
import com.tmjee.linearisation.meta.Meta_List_SetAndGet_Test;
import com.tmjee.linearisation.processor.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_List_SetAndGet_Test.class)
public class CopyOnWriteArrayList_SetAndGet_Test extends Abstract_List_SetAndGet_Test {

    @Invariant
    public static class State extends Abstract_List_SetAndGet_Test.AbstractState {
        final List<Integer> l = new CopyOnWriteArrayList<>();
        @Override
        protected List<Integer> get() {
            return l;
        }
    }


    @TestUnit(name="CopyOnWriteArrayList_SetAndGet_Test", description = "CopyOnWriteArrayList Set and get test")
    public static class TestUnit1 extends CopyOnWriteArrayList_SetAndGet_Test.AbstractTestUnit {

        @Player
        public void player1(State state, IntResult2 r) {
            _player1(state, r);
        }

        @Player
        public void player2(State state, IntResult2 r) { _player2(state, r); }
    }
}
