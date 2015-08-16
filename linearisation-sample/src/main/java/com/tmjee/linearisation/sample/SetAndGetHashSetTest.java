package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE,
        description = "Player 1 retrieved value added, Player 2 retrieved value added.")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN,
        description = "Player 1 retrieved value added, Player 2 did not retrieved value added")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN,
        description = "Player 1 did not retrieved value added, Player 2 retrieved value added")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN,
        description = "Player 1 did not retrieved value added, Player 2 did not retrieved value added")
public class SetAndGetHashSetTest {

    @Invariant
    public static class State {
        public volatile Set<Integer> set = new HashSet<>();
    }


    @TestUnit(name="SetAndGetArrayListTest_Unit1", description = "Set and get hashset test (unit 1)")
    public static class TestUnit1 {
        @Player
        public void player1(State state, LongResult2 result) {
            try {
                state.set.add(1);
                boolean i = state.set.contains(1);
                result.value1 = i ? 1 : -1;
            }catch(Throwable t) {
                result.value1 = -2;
            }
        }

        @Player
        public void player2(State state, LongResult2 result) {
            try {
                state.set.add(2);
                boolean i = state.set.contains(2);
                result.value2 = i ? 1 : -1;
            }catch(Throwable t) {
                result.value2 = -2;
            }
        }
    }
}


