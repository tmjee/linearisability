package com.tmjee.linearisation.core;

import com.tmjee.linearisation.processor.*;

import static java.lang.String.format;

/**
 * @author tmjee
 */
//@Linearisable
@Consequence(id="[1]", expectation = Expectation.ACCEPTABLE, description = "result 1")
@Consequence(id="[2]", expectation = Expectation.ACCEPTABLE, description = "result 2")
@Consequence(id="[3]", expectation = Expectation.ACCEPTABLE, description = "result 3")
@Reference("ref 1")
@Reference("ref 2")
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

