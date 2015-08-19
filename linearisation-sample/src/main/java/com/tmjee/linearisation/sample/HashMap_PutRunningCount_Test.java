package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id = "[1]", expectation = Expectation.ACCEPTABLE, description = "Running count for player 1 and 2 match expected result")
@Consequence(id = "[-1]", expectation = Expectation.FORBIDDEN, description = "Running count for player 1 and 2 do not match expected result")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/0000002.md")
public class HashMap_PutRunningCount_Test extends Abstract_Map_PutRunningCount_Test {

    @Invariant
    public static class State extends Abstract_Map_PutRunningCount_Test.AbstractState {
        public volatile Map<Integer, Integer> m = new HashMap<>();

        @Override
        Map<Integer, Integer> get() {
            return m;
        }
    }


    @TestUnit(name="PutRunningCountHashMapTest_TestUnit1", description = "Put and do running count (unit1)")
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
