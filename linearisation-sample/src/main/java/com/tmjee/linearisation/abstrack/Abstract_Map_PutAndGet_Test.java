package com.tmjee.linearisation.abstrack;


import com.tmjee.linearisation.processor.IntResult2;
import com.tmjee.linearisation.processor.Logger;

import java.util.Map;

/**
 * Player 1 puts (1,1) into the map and expects to get 1 back from get(1).
 * <p/>
 * Player 2 puts (2,1) into the map and expects to get 1 back from get(2).
 * </p>
 *
 * @author tmjee
 */
public abstract class Abstract_Map_PutAndGet_Test {


    public static abstract class AbstractState {
        protected abstract Map<Integer, Integer> get();
    }


    public static abstract class AbstractTestUnit {

        protected void _player1(AbstractState state, IntResult2 r) {
            try {
                final Map<Integer, Integer> m = state.get();
                m.put(1, 1);
                Integer i = m.get(1);
                r.value1 = (i == null ? -1 : (i != 1 ? -1 : 1));
            } catch (Throwable t) {
                Logger.log("Player 1 experienced exception", t);
                r.value1 = -2;
            }
        }

        protected void _player2(AbstractState state, IntResult2 r) {
            try {
                final Map<Integer, Integer> m = state.get();
                m.put(2, 1);
                Integer i = m.get(2);
                r.value2 = (i == null ? -1 : (i != 1 ? -1 : 1));
            } catch (Throwable t) {
                Logger.log("Player 2 experienced exception", t);
                r.value2 = -2;
            }
        }
    }
}
