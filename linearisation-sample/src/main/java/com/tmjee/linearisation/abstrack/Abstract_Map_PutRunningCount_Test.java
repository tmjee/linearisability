package com.tmjee.linearisation.abstrack;

import com.tmjee.linearisation.processor.LongResult1;

import java.util.Map;

/**
 * Player 1 puts 1000 entries into the map from (0,0) till (999,999)
 * <p/>
 * Player 2 puts 2000 entries into the map from (1000,1000) till (2999,2999)
 * <p/>
 * Arbiter expects to see a size of 3000 (1000 from player 1 and 2000 from
 * player 2).
 * <p/>
 *
 * @author tmjee
 */
public abstract class Abstract_Map_PutRunningCount_Test {

    public static abstract class AbstractState {
        protected abstract Map<Integer, Integer> get();
    }

    public static abstract class AbstractTestUnit {

        protected void _player1(AbstractState state, LongResult1 r) {
            try {
                Map<Integer, Integer> m = state.get();
                for (int a = 0; a < 100; a++) {
                    m.put(a, a);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        protected void _player2(AbstractState state, LongResult1 r) {
            try {
                Map<Integer, Integer> m = state.get();
                for (int b = 100; b < 300; b++) {
                    m.put(b, b);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        protected void _arbiter(AbstractState state, LongResult1 r) {
            Map<Integer, Integer> m = state.get();
            int size = m.size();
            r.value1 = ((size == 300)?1:-1);
        }

    }
}
