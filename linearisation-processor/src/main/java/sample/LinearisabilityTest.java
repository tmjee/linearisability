package sample;

import com.tmjee.linearisation.processor.*;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1]", expectation = Expectation.ACCEPTABLE, description = "result 1")
@Consequence(id="[2]", expectation = Expectation.ACCEPTABLE, description = "result 2")
@Consequence(id="[3]", expectation = Expectation.ACCEPTABLE, description = "result 3")
@Reference("ref 1")
@Reference("ref 2")
public class LinearisabilityTest {

    @Invariant
    public static class State {

    }

    @Record
    public static class Result {

    }


    @TestUnit(name="")
    public static class TestUnit1 {
        @Player
        public void player1Action(State state, Result result) {
        }

        @Player
        public void player2Action(State state, Result result) {
        }
    }
}
