package com.tmjee.linearisation.abstrack;

import com.tmjee.linearisation.processor.IntResult2;

import java.util.Queue;

/**
 *  Player 1 'offered' the queue 5000 (sequential starting with zero) entries.
 *
 *  Player 2 'poll' the queue for 3000 entries. Player 2 should get 0 to 2999 as
 *  queue is FIFO.
 *
 *  Arbiter validates the size of the queue. It should be 2000 (5000 - 3000).
 *
 *  Player 1 and 2 are run concurrently while Arbiter is run only after both
 *  player 1 and 2 have ended. A barrier exists to make sure both player ended
 *  before Arbiter starts.
 *
 * @author tmjee
 */
public abstract class Abstract_Queue_OfferAndPoll_Test {

    public static abstract class AbstractState {
        protected abstract Queue<Integer> get();
    }


    public static abstract class AbstractTestUnit {

        protected void _player1(AbstractState state, IntResult2 r) {

            Queue<Integer> q = state.get();
            int a=0;
            do {
                boolean offered = q.offer(a);
                if (offered) {
                    a++;
                }
            } while(a<5000);

        }

        protected void _player2(AbstractState state, IntResult2 r) {
            Queue<Integer> q = state.get();
            int b=0;
            boolean fifoViolation = false;
            do {
                Integer i = q.poll();

                if (i != null) {
                    b++;
                    if (i!=b) {
                        fifoViolation = true;
                    }
                }
            } while(b<3000);

            r.value1 = fifoViolation ? -1 : 1;
        }

        protected void _arbiter(AbstractState state, IntResult2 r) {
            Queue<Integer> q = state.get();

            int s = q.size();
            r.value2 = (s == 2000 ? 1 : -1);
        }
    }

}
