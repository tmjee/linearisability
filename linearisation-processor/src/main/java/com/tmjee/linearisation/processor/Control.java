package com.tmjee.linearisation.processor;

import java.util.concurrent.CyclicBarrier;

/**
 * @author tmjee
 */
public class Control {

    private volatile boolean running;

    private final CyclicBarrier waitForStartBarrier;
    private final CyclicBarrier waitForDoneBarrier;
    private final CyclicBarrier waitForRestrideBarrier;


    public Control(int parties) {
       this.running = false;
        waitForStartBarrier = new CyclicBarrier(parties);
        waitForDoneBarrier = new CyclicBarrier(parties);
        waitForRestrideBarrier = new CyclicBarrier(parties);
    }

    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }


    public CyclicBarrier getWaitForStartBarrier() {
        return waitForStartBarrier;
    }

    public CyclicBarrier getWaitForDoneBarrier() {
        return waitForDoneBarrier;
    }

    public CyclicBarrier getWaitForRestrideBarrier() {
        return waitForRestrideBarrier;
    }

    public void resetBarriers() {
        waitForStartBarrier.reset();
        waitForDoneBarrier.reset();
        waitForRestrideBarrier.reset();
    }

}
