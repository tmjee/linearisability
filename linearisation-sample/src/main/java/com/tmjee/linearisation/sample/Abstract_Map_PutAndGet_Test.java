package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.LongResult2;

import java.util.Map;

/**
 * @author tmjee
 */
public class Abstract_Map_PutAndGet_Test {


    public static abstract class AbstractState {
        abstract Map<Integer, Integer> get();
    }


    public static class AbstractTestUnit {

        protected void _player1(AbstractState state, LongResult2 r) {
            try {
                final Map<Integer, Integer> m = state.get();
                m.put(1, 1);
                Integer i = m.get(1);
                r.value1 = (i == null ? -1 : (i != 1 ? -1 : 1));
            } catch (Throwable t) {
                r.value1 = -2;
            }
        }

        protected void _player2(AbstractState state, LongResult2 r) {
            try {
                final Map<Integer, Integer> m = state.get();
                m.put(2, 1);
                Integer i = m.get(2);
                r.value2 = (i == null ? -1 : (i != 1 ? -1 : 1));
            } catch (Throwable t) {
                r.value2 = -2;
            }
        }
    }
}
