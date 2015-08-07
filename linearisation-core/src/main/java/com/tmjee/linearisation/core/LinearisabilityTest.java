package com.tmjee.linearisation.core;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Invariant;
import com.tmjee.linearisation.processor.Linearisable;
import com.tmjee.linearisation.processor.Player;

/**
 * @author tmjee
 */
@Linearisable
public class LinearisabilityTest {

    @Invariant
    public static class State {

    }

    @Consequence
    public static class Result {

    }


    @Player
    public void player1Action(State state, Result result) {

    }


    @Player
    public void player2Action(State state, Result result) {

    }
}
