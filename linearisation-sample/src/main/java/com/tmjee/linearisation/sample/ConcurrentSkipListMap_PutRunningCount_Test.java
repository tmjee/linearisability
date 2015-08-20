package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutRunningCount_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutRunningCount_Test;
import com.tmjee.linearisation.processor.*;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_PutRunningCount_Test.class)
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/0000006.md")
public class ConcurrentSkipListMap_PutRunningCount_Test extends Abstract_Map_PutRunningCount_Test {

    @Invariant
    public static class State extends Abstract_Map_PutRunningCount_Test.AbstractState {
        volatile Map<Integer, Integer> m = new ConcurrentSkipListMap<>();
        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }


    @TestUnit(name="ConcurrentSkipListMap_PutRunningCount_Test", description = "ConcurrentSkipListMap Put Running Count Test")
    public static class TestUnit1 extends Abstract_Map_PutRunningCount_Test.AbstractTestUnit {

        @Player
        public void player1(State state, LongResult1 r) {
            _player1(state, r);
        }

        @Player
        public void player2(State state, LongResult1 r) {
            _player2(state, r);
        }

        @Arbiter
        public void arbiter(State state, LongResult1 r) {
            _arbiter(state, r);
        }
    }
}
