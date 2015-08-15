package com.tmjee.linearisation.processor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Control2 {

    final int parties;
    final AtomicInteger start;
    final AtomicInteger done;
    final AtomicInteger restride;
    volatile boolean _start, _done, _restride;

    public Control2(Control2 control) {
        this.parties = control.parties;
        start = new AtomicInteger(parties);
        done = new AtomicInteger(parties);
        restride = new AtomicInteger(parties);
    }


    public Control2(int parties) {
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
            Thread.yield();;
        }
    }
}
