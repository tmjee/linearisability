package com.tmjee.linearisation.sample;

import com.tmjee.linearisation.abstrack.Abstract_Set_SetAndGet_Test;
import com.tmjee.linearisation.processor.Invariant;
import synchrobench.hashtables.sequential.SequentialHashIntSet;

import java.util.Set;

/**
 * @author tmjee
 */
public class SbSequentialHashIntSet_SetAndGet_Test extends Abstract_Set_SetAndGet_Test{
/*
    @Invariant
    public static class State extends Abstract_Set_SetAndGet_Test.AbstractState {
        final Set<Integer> s = new SequentialHashIntSet();
        @Override protected Set<Integer> get() { return s; }
    }
    */
}
