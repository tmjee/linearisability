package com.tmjee.linearisation.abstrack;


import com.tmjee.linearisation.processor.IntResult1;
import com.tmjee.linearisation.processor.IntResult2;

import java.util.Set;

/**
 * Player 1 add 1 into the set and expects the set to contains 1.
 * <p/>
 * Player 2 add 2 into the set and expects the set to contains 2.
 * <p/>
 *
 * @author tmjee
 */
public abstract class Abstract_Set_SetAndGet_Test {

    public abstract static class AbstractState {
        protected abstract Set<Integer> get();
    }

    public static class AbstractTestUnit {

        protected void _player1(AbstractState state, IntResult2 r) {
            try {
                Set<Integer> s =state.get();
                s.add(1);
                boolean i = s.contains(1);
                r.value1 = i ? 1 : -1;
            }catch(Throwable t) {
                r.value1 = -2;
            }
        }

        protected void _player2(AbstractState state, IntResult2 r) {
            try {
                Set<Integer> s = state.get();
                s.add(2);
                boolean i = s.contains(2);
                r.value2 = i ? 1 : -1;
            }catch(Throwable t) {
                r.value2 = -2;
            }
        }
    }
}
