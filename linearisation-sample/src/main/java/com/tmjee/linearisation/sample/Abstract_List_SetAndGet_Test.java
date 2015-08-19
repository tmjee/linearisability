package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.processor.LongResult2;

import java.util.List;

/**
 * @author tmjee
 */
public abstract class Abstract_List_SetAndGet_Test {

    public abstract static class AbstractState {
        abstract List<Integer> get();
    }

    public abstract static class AbstractTestUnit {

        protected void _player1(AbstractState state, LongResult2 r) {
            try {
                List<Integer> l = state.get();
                l.add(1, 1);
                Integer i = l.get(1);
                r.value1 = ((i == null) ? -1 : (i == 1 ? 1 : -1));
            }catch(Throwable t) {
                r.value1 = -2;
            }
        }

        protected void _player2(AbstractState state, LongResult2 r) {
            try {
                List<Integer> l = state.get();
                l.add(2, 1);
                Integer i = l.get(2);
                r.value2 = ((i == null) ? -1 : (i == 1 ? 1 : -1));
            }catch(Throwable t) {
                r.value2 = -2;
            }
        }
    }
}
