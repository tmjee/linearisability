package com.tmjee.linearisation.abstrack;

import com.tmjee.linearisation.processor.IntResult1;
import com.tmjee.linearisation.processor.Logger;

import java.util.Map;

/**
 * Player 1 put (0,0) till (299,299) into the map
 * <p/>
 * Player 2 remove (0,0) till (99,00) from the map.
 * <p/>
 * Arbiter makes sure the size is 200 (300 - 100)
 *
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
                Logger.log("Player 1 experienced exception", e);
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
                Logger.log("Player 2 experienced exception", e);
            }
        }

        protected void _arbiter(AbstractState state, IntResult1 r) {
            Map<Integer, Integer> m = state.get();
            int size = m.size();
            r.value1 = (size == 200 ? 1 : -1);
        }
    }
}
