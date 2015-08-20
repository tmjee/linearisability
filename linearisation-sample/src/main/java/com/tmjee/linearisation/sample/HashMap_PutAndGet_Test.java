package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutAndGet_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutAndGet_Test;
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
@Linearisable
@Meta(Meta_Map_PutAndGet_Test.class)
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/0000001.md")
public class HashMap_PutAndGet_Test extends Abstract_Map_PutAndGet_Test {

    @Invariant
    public static class State extends Abstract_Map_PutAndGet_Test.AbstractState {
       public volatile Map<Integer, Integer> m = new HashMap<>();

        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }

    @TestUnit(name="PutAndGetHashMap_TestUnit_1", description = "Put and get hash map (unit1)")
    public static class TestUnit1 extends Abstract_Map_PutAndGet_Test.AbstractTestUnit {
        @Player
        public void player1(State state, LongResult2 r) {
            _player1(state, r);
        }

        @Player
        public void player2(State state, LongResult2 r) {
            _player2(state, r);
        }
    }
}
