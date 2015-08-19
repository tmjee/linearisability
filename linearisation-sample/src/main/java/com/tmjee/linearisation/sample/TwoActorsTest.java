package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Both player 1 and 2 executed respective test method")
@Consequence(id="[0,0]", expectation = Expectation.FORBIDDEN, description = "Both player 1 and 2 do not execute respective test method")
@Consequence(id="[1,0]", expectation = Expectation.FORBIDDEN, description="Player 2 did not execute it's test method")
@Consequence(id="[0,1]", expectation = Expectation.FORBIDDEN, description="Player 1 did not execute it's test method")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/misc/0000001.md")
public class TwoActorsTest {

    @Invariant
    public static class State {
    }

    @Record
    public static class Result {
        volatile int x = 0;
        volatile int y = 0;

        @Override
        public String toString() {
            return format("[%s,%s]", x, y);
        }
    }


    @TestUnit(name="TwoActorTest", description = "Set value to two actors")
    public static class TestUnit1 {
        @Player
        public void player1Action(State state, Result result) {
            result.x=1;
        }

        @Player
        public void player2Action(State state, Result result) {
            result.y=1;
        }
    }
}

