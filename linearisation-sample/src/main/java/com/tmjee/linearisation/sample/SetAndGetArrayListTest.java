package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "result 1")
@Consequence(id="[2]", expectation = Expectation.ACCEPTABLE, description = "result 2")
@Consequence(id="[3]", expectation = Expectation.ACCEPTABLE, description = "result 3")
public class SetAndGetArrayListTest {

    @Invariant
    public static class State {
        public volatile List<Integer> list = new ArrayList<>();
    }


    @TestUnit(name="SetAndGetArrayListTest_Unit1", description = "Set and get array list test (unit 1)")
    public static class TestUnit1 {
        @Player
        public void player1(State state, LongResult2 result) {
            try {
                state.list.add(1, 1);
                Integer i = state.list.get(1);
                result.value1 = (i == null) ? -1 : i;
            }catch(Throwable t) {
                result.value1 = -2;
            }
        }

        @Player
        public void player2(State state, LongResult2 result) {
            try {
                state.list.add(1, 2);
                Integer i = state.list.get(1);
                result.value2 = (i == null) ? -1 : i;
            }catch(Throwable t) {
                result.value2 = -2;
            }
        }
    }

}
