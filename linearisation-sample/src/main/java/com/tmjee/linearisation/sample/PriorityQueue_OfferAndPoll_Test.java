package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test;
import com.tmjee.linearisation.meta.Meta_Queue_OfferAndPoll_Test;
import com.tmjee.linearisation.processor.*;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Queue_OfferAndPoll_Test.class)
public class PriorityQueue_OfferAndPoll_Test extends Abstract_Queue_OfferAndPoll_Test {


    @Invariant
    public static class State extends Abstract_Queue_OfferAndPoll_Test.AbstractState {
        final Queue<Integer> q = new PriorityQueue<>();
        @Override
        protected Queue<Integer> get() {
            return q;
        }
    }

    @TestUnit(name="PriorityQueue_OfferAndPoll_Test", description = "PriorityQueue Offer and Poll Test")
    public static class TestUnit1 extends Abstract_Queue_OfferAndPoll_Test.AbstractTestUnit {

        @Player
        public void player1(State state, IntResult2 r) {
            _player1(state, r);
        }

        @Player
        public void player2(State state, IntResult2 r) {
            _player2(state, r);
        }

        @Arbiter
        public void arbiter(State state, IntResult2 r) {
            _arbiter(state, r);
        }
    }

}
