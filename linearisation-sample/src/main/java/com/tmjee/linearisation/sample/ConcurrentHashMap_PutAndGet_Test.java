package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Map_PutAndGet_Test;
import com.tmjee.linearisation.meta.Meta_Map_PutAndGet_Test;
import com.tmjee.linearisation.processor.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Map_PutAndGet_Test.class)
public class ConcurrentHashMap_PutAndGet_Test extends Abstract_Map_PutAndGet_Test {

    @Invariant
    public static class State extends Abstract_Map_PutAndGet_Test.AbstractState {
        final Map<Integer, Integer> m = new ConcurrentHashMap<>();
        @Override
        protected Map<Integer, Integer> get() {
            return m;
        }
    }

    @TestUnit(name = "ConcurrentHashMap_PutAndGet_Test", description = "ConcurrentHashMap Put and get Test")
    public static class TestUnit1 extends Abstract_Map_PutAndGet_Test.AbstractTestUnit {

        @Player
        public void player1(State state, IntResult2 r) {
            _player1(state, r);
        }

        @Player
        public void player2(State state, IntResult2 r) {
            _player2(state,r);
        }
    }
}
