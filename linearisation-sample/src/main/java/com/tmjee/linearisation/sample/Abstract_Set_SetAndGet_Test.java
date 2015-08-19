package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.LongResult2;

import java.util.Set;

/**
 * @author tmjee
 */
public class Abstract_Set_SetAndGet_Test {

    public abstract static class AbstractState {
        abstract Set<Integer> get();
    }

    public static class AbstractTestUnit {

        protected void _player1(AbstractState state, LongResult2 r) {
            try {
                Set<Integer> s =state.get();
                s.add(1);
                boolean i = s.contains(1);
                r.value1 = i ? 1 : -1;
            }catch(Throwable t) {
                r.value1 = -2;
            }
        }

        protected void _player2(AbstractState state, LongResult2 r) {
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
