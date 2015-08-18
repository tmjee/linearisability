package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Player 1 try to insert an integer '1' into index 1 and then try to get back the integer at
 * index 1.
 * <p/>
 * Player 2 try to insert an integer '1' into index 2 and then try to get back the integer at
 * index 2.
 * <p/>
 * Both players are doing the operation at the same time without synchronisation
 *
 * @author tmjee
 */
//@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Player 1 and 2 got back expected values")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 get back value inserted, Player 2 did not get back value expected")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not get back value inserted, Player 2 get back value inserted")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 and 2 do not get back expected value")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/list/0000001.md")
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
                result.value1 = ((i == null) ? -1 : (i == 1 ? 1 : -1));
            }catch(Throwable t) {
                result.value1 = -2;
            }
        }

        @Player
        public void player2(State state, LongResult2 result) {
            try {
                state.list.add(2, 1);
                Integer i = state.list.get(2);
                result.value2 = ((i == null) ? -1 : (i == 1 ? 1 : -1));
            }catch(Throwable t) {
                result.value2 = -2;
            }
        }
    }

}
