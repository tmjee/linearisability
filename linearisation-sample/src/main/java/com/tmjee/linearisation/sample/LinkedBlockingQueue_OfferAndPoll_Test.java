package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Queue_OfferAndPoll_Test;
import com.tmjee.linearisation.meta.Meta_Queue_OfferAndPoll_Test;
import com.tmjee.linearisation.processor.*;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tmjee
 */
@Linearisable
@Meta(Meta_Queue_OfferAndPoll_Test.class)
public class LinkedBlockingQueue_OfferAndPoll_Test extends Abstract_Queue_OfferAndPoll_Test {

    @Invariant
    public static class State extends Abstract_Queue_OfferAndPoll_Test.AbstractState {
        volatile Queue<Integer> q = new LinkedBlockingQueue<>();
        @Override
        protected Queue<Integer> get() {
            return q;
        }
    }

    @TestUnit(name="LinkedBlockingQueue_OfferAndPoll_Test")
    public static class TestUnit1 extends Abstract_Queue_OfferAndPoll_Test.AbstractTestUnit {
        @Player public void player1(State s, IntResult2 r) { _player1(s,r); }
        @Player public void player2(State s, IntResult2 r) { _player2(s, r); }
        @Arbiter public void arbiter(State s, IntResult2 r) { _arbiter(s,r);}
    }
}
