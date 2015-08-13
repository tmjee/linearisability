package com.tmjee.linearisation.processor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tmjee
 */
public class Control {
    /*

    private final int parties;
    private final CyclicBarrier waitForStartBarrier;
    private final CyclicBarrier waitForDoneBarrier;
    private final CyclicBarrier waitForRestrideBarrier;


    public Control(Control control) {
        this.parties = control.parties;
        this.waitForDoneBarrier = new CyclicBarrier(control.parties);
        this.waitForStartBarrier = new CyclicBarrier(control.parties);
        this.waitForRestrideBarrier = new CyclicBarrier(control.parties);
    }

    public Control(int parties) {
       this.parties = parties;
       waitForStartBarrier = new CyclicBarrier(parties);
       waitForDoneBarrier = new CyclicBarrier(parties);
       waitForRestrideBarrier = new CyclicBarrier(parties);
    }

    public void waitForStart() throws BrokenBarrierException, InterruptedException {
        waitForStartBarrier.await();
    }

    public void waitForDone() throws BrokenBarrierException, InterruptedException {
        waitForDoneBarrier.await();
    }

    public void waitForRestride() throws BrokenBarrierException, InterruptedException {
        waitForRestrideBarrier.await();
    }*/



    final int parties;
    final AtomicInteger start;
    final AtomicInteger done;
    final AtomicInteger restride;
    volatile boolean _start, _done, _restride;

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
            Thread.yield();;
        }
    }
}
