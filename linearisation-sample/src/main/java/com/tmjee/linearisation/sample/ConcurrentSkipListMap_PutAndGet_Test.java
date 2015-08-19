package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.*;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author tmjee
 */
@Linearisable
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Both player 1 and 2 get back expected values")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 get back expected value while Player 2 did not")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not get back expected value but Player 2 did")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Both player 1 and player 2 did not get back expected value")
@Consequence(id="[-2,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception")
@Consequence(id="[-2,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws Exception, Player 2 results is unexpected")
@Consequence(id="[1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 2 throws Exception")
@Consequence(id="[-1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 result is unexpected, Player 2 throws exception ")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/0000004.md")
public class ConcurrentSkipListMap_PutAndGet_Test extends Abstract_Map_PutAndGet_Test {


    @Invariant
    public static class State extends Abstract_Map_PutAndGet_Test.AbstractState {
        volatile Map<Integer, Integer> m = new ConcurrentSkipListMap<>();

        @Override
        Map<Integer, Integer> get() {
            return m;
        }
    }


    @TestUnit(name="ConcurrentSkipListMap_PutAndGet_Test", description = "ConcurrentSkipListMap Put and Get Test")
    public static class TestUnit1 extends Abstract_Map_PutAndGet_Test.AbstractTestUnit {

        @Player
        protected void _player1(AbstractState state, LongResult2 r) {
            _player1(state, r);
        }

        @Player
        protected void _player2(AbstractState state, LongResult2 r) {
            _player2(state, r);
        }
    }
}
