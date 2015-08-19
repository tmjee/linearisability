package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Player 1 and 2 got back expected values")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 get back value inserted, Player 2 did not get back value expected")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not get back value inserted, Player 2 get back value inserted")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 and 2 do not get back expected value")
@Consequence(id="[-2,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 and 2 thrown exception")
@Consequence(id="[-2,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception")
@Consequence(id="[-2,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception, Player 2 get back unexpected value")
@Consequence(id="[1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 2 throws exception")
@Consequence(id="[-1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 gets back unexpected result, Player 2 throws exception")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/list/0000001.md")
public class ArrayList_SetAndGet_Test extends Abstract_List_SetAndGet_Test {

    @Invariant
    public static class State extends Abstract_List_SetAndGet_Test.AbstractState {
        public volatile List<Integer> list = new ArrayList<>();

        @Override
        List<Integer> get() {
            return list;
        }
    }


    @TestUnit(name="SetAndGetArrayListTest_Unit1", description = "Set and get array list test (unit 1)")
    public static class TestUnit1 extends Abstract_List_SetAndGet_Test.AbstractTestUnit {
        @Player
        public void player1(State state, LongResult2 result) {
            _player1(state, result);
        }

        @Player
        public void player2(State state, LongResult2 result) {
            _player2(state, result);
        }
    }

}
