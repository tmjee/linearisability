package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_List_SetAndGet_Test;
import com.tmjee.linearisation.meta.Meta_List_SetAndGet_Test;
import com.tmjee.linearisation.processor.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_List_SetAndGet_Test.class)
public class ArrayList_SetAndGet_Test extends Abstract_List_SetAndGet_Test {

    @Invariant
    public static class State extends Abstract_List_SetAndGet_Test.AbstractState {
        final List<Integer> list = new ArrayList<>();
        @Override
        protected List<Integer> get() {
            return list;
        }
    }


    @TestUnit(name="SetAndGetArrayListTest_Unit1", description = "Set and get array list test (unit 1)")
    public static class TestUnit1 extends Abstract_List_SetAndGet_Test.AbstractTestUnit {
        @Player
        public void player1(State state, IntResult2 result) {
            _player1(state, result);
        }

        @Player
        public void player2(State state, IntResult2 result) {
            _player2(state, result);
        }
    }

}
