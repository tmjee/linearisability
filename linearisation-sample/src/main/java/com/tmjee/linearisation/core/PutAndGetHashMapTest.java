package com.tmjee.linearisation.core;

import com.tmjee.linearisation.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1,2]", expectation = Expectation.ACCEPTABLE, description = "result 1")
@Consequence(id="[2,1]", expectation = Expectation.ACCEPTABLE, description = "result 2")
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "result 2")
@Consequence(id="[2,2]", expectation = Expectation.ACCEPTABLE, description = "result 2")
@Consequence(id="[-1,1]", expectation = Expectation.ACCEPTABLE_INTERESTING, description = "result 3")
public class PutAndGetHashMapTest {

    @Invariant
    public static class State {
       public volatile Map<Integer, Integer> m = new HashMap<>();
    }

    @TestUnit(name="PutAndGetHashMap_TestUnit_1", description = "Put and get hash map (unit1)")
    public static class TestUnit1 {
        @Player
        public void player1(State state, LongResult2 r) {
            try {
                state.m.put(1, 1);
                Integer i = state.m.get(1);
                r.value1 = (i == null ? -1 : i);
            }catch(Throwable t) {
                r.value1 = -2;
            }
        }

        @Player
        public void player2(State state, LongResult2 r) {
            try {
                state.m.put(1, 2);
                Integer i = state.m.get(1);
                r.value2 = (i == null ? -1 : i);
            }catch(Throwable t) {
                r.value2 = -2;
            }
        }
    }
}
