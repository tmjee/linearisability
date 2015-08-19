package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.LongResult1;

import java.util.Map;

/**
 * @author tmjee
 */
public abstract class Abstract_Map_PutRunningCount_Test {

    public static abstract class AbstractState {
        abstract Map<Integer, Integer> get();
    }

    public static abstract class AbstractTestUnit {

        protected void _player1(AbstractState state, LongResult1 r) {
            Map<Integer, Integer> m = state.get();
            for (int a=0; a<100; a++) {
                m.put(a,a);
            }
        }

        protected void _player2(AbstractState state, LongResult1 r) {
            Map<Integer, Integer> m = state.get();
            for(int b=100; b<200; b++) {
                m.put(b, b);
            }
        }

        protected void _arbiter(AbstractState state, LongResult1 r) {
            Map<Integer, Integer> m = state.get();
            int size = m.size();
            r.value1 = ((size == 100)?1:-1);
        }

    }
}
