package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id = "[1]", expectation = Expectation.ACCEPTABLE, description = "Running count for player 1 and 2 match expected result")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/0000002.md")
public class PutRunningCountHashMapTest {

    @Invariant
    public static class State {
        public volatile Map<Integer, Integer> m = new HashMap<>();
    }


    @TestUnit(name="PutRunningCountHashMapTest_TestUnit1", description = "Put and do running count (unit1)")
    public static class TestUnit1 {

        @Player
        public void player1(State state, LongResult1 result1) {

        }

        @Player
        public void player2(State state, LongResult1 result1) {

        }

        @Arbiter
        public void arbiter(State state, LongResult1 result1) {

        }
    }
}
