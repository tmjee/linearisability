package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.Set;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Player 1 retrieved value added, Player 2 retrieved value added.")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 retrieved value added, Player 2 did not retrieved value added")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not retrieved value added, Player 2 retrieved value added")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not retrieved value added, Player 2 did not retrieved value added")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/set/0000002.md")
public class ConcurrentSkipListSet_SetAndGet_Test extends Abstract_Set_SetAndGet_Test {


    @Invariant
    public static class State extends Abstract_Set_SetAndGet_Test.AbstractState {
        volatile Set<Integer> s;
        @Override
        Set<Integer> get() {
            return s;
        }
    }


    @TestUnit(name = "ConcurrentSkipListSet_SetAndGet_Test", description = "ConcurrentSkipListSet Set and Get Test")
    public static class TestUnit1 extends Abstract_Set_SetAndGet_Test.AbstractTestUnit {

        @Player
        public void player1(State state, LongResult2 r) {
            _player1(state, r);
        }

        @Player
        public  void player2(State state, LongResult2 r) {
            _player2(state, r);
        }
    }
}
