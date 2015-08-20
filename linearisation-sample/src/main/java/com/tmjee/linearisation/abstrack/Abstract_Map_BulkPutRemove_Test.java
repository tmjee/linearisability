package com.tmjee.linearisation.abstrack;

import com.tmjee.linearisation.processor.IntResult1;

import java.util.Map;

/**
 * @author tmjee
 */
public abstract class Abstract_Map_BulkPutRemove_Test {

    public static abstract class AbstractState {
        protected abstract Map<Integer, Integer> get();
    }



    public static abstract class AbstractTestUnit {

        protected void _player1(AbstractState state, IntResult1 r) {
            try {
                Map<Integer, Integer> m = state.get();
                for (int a = 0; a < 300; a++) {
                    m.put(a, a);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        protected void _player2(AbstractState state, IntResult1 r) {
            try {
                Map<Integer, Integer> m = state.get();
                for (int b = 0; b < 100; b++) {
                    while (!m.containsKey(b)) {
                        Thread.currentThread().yield();
                    }
                    m.remove(b);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        protected void _arbiter(AbstractState state, IntResult1 r) {
            Map<Integer, Integer> m = state.get();
            int size = m.size();
            r.value1 = (size == 200 ? 1 : -1);
        }
    }
}
