package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Set_SetAndGet_Test;
import com.tmjee.linearisation.meta.Meta_Set_SetAndGet_Test;
import com.tmjee.linearisation.processor.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Player 1 try to add an integer '1' into a {@link HashSet} and then try to check if
 * the {@link HashSet} contains an integer '1'.
 * <p/>
 * Player 2 try to add an integer '2' into a {@link HashSet} and then try to check if
 * the {@link HashSet} contains an integer '2'.
 * <p/>
 * Both players are doing the operation at the same time without synchronisation
 *
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Set_SetAndGet_Test.class)
public class HashSet_SetAndGet_Test extends Abstract_Set_SetAndGet_Test {

    @Invariant
    public static class State extends Abstract_Set_SetAndGet_Test.AbstractState {
        public volatile Set<Integer> s = new HashSet<>();

        @Override
        protected Set<Integer> get() {
            return s;
        }
    }


    @TestUnit(name="SetAndGetHashSetTest_Unit1", description = "Set and get hashset test (unit 1)")
    public static class TestUnit1 extends Abstract_Set_SetAndGet_Test.AbstractTestUnit {
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


