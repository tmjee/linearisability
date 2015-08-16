package com.tmjee.linearisation.processor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Control {

    private final int parties;
    private final AtomicInteger start;
    private final AtomicInteger done;
    private final AtomicInteger restride;
    private volatile boolean _start, _done, _restride;

    public Control(Control control) {
        this.parties = control.parties;
        start = new AtomicInteger(parties);
        done = new AtomicInteger(parties);
        restride = new AtomicInteger(parties);
    }


    public Control(int parties) {
        this.parties =  parties;
        start = new AtomicInteger(parties);
        done = new AtomicInteger(parties);
        restride = new AtomicInteger(parties);
    }

    public void waitForStart() {
        if (start.decrementAndGet() == 0) {
            _start = true;
        }
        while(!_start) {
            Thread.yield();
        }
    }

    public void waitForDone() {
        if (done.decrementAndGet() == 0) {
            _done = true;
        }
        while(!_done) {
            Thread.yield();
        }
    }

    public void waitForRestride() {
        if (restride.decrementAndGet() == 0) {
            _restride = true;
        }
        while(!_restride) {
            Thread.yield();
        }
    }
}
