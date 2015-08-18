package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Player 1 insert an integer '1' into a {@link HashMap} with key '1' and then
 * try to retrieve the value inserted.
 * <p/>
 * Player 2 insert an integer '1' into a {@link HashMap} with key 2' and then
 * try to retrieve the value inserted.
 * <p/>
 * Both players are doing the operation at the same time without synchronisation
 *
 * @author tmjee
 */
//@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Both player 1 and 2 get back expected values")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 get back expected value while Player 2 did not")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not get back expected value but Player 2 did")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Both player 1 and player 2 did not get back expected value")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/0000001.md")
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
                r.value1 = (i == null ? -1 : (i != 1 ? -1 : 1));
            }catch(Throwable t) {
                r.value1 = -2;
            }
        }

        @Player
        public void player2(State state, LongResult2 r) {
            try {
                state.m.put(2, 1);
                Integer i = state.m.get(2);
                r.value2 = (i == null ? -1 : (i != 1 ? -1 : 1));
            }catch(Throwable t) {
                r.value2 = -2;
            }
        }
    }
}
