package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_BulkPutRemove_Test;
import com.tmjee.linearisation.meta.Meta_Map_BulkPutRemove_Test;
import com.tmjee.linearisation.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_BulkPutRemove_Test.class)
public class HashMap_BulkPutRemove_Test extends Abstract_Map_BulkPutRemove_Test {

    @Invariant
    public static class State extends Abstract_Map_BulkPutRemove_Test.AbstractState {
        final Map<Integer, Integer> m = new HashMap<>();
        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }

    @TestUnit(name="HashMap_BulkPutRemove_Test", description = "HashMap Bulk Put Remove Test")
    public static class TestUnit1 extends Abstract_Map_BulkPutRemove_Test.AbstractTestUnit {

        @Player
        public void player1(State state, IntResult1 r) {
           _player1(state, r);
        }

        @Player
        public void player2(State state, IntResult1 r) {
            _player2(state, r);
        }

        @Arbiter
        public void arbiter(State state, IntResult1 r) {
            _arbiter(state, r);
        }
    }
}
