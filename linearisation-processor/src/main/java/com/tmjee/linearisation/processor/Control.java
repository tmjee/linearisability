package com.tmjee.linearisation.processor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tmjee
 */
public class Control {

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
    }
}
