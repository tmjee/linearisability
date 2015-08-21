package com.tmjee.linearisation.abstrack;

import com.tmjee.linearisation.processor.IntResult2;

import java.util.List;

/**
 * Player 1 puts (1,1) into the list and expect to get 1 back from get(1).
 * <p/>
 * Player 2 puts (2,1) into the list and expect to get 1 back from get(1)
 * <p/>
 *
 * @author tmjee
 */
public abstract class Abstract_List_SetAndGet_Test {

    public abstract static class AbstractState {
        protected abstract List<Integer> get();
    }

    public abstract static class AbstractTestUnit {

        protected void _player1(AbstractState state, IntResult2 r) {
            try {
                List<Integer> l = state.get();
                l.add(1, 1);
                Integer i = l.get(1);
                r.value1 = ((i == null) ? -1 : (i == 1 ? 1 : -1));
            }catch(Throwable t) {
                r.value1 = -2;
            }
        }

        protected void _player2(AbstractState state, IntResult2 r) {
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
