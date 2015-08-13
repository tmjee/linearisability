package com.tmjee.linearisation.processor;

import java.util.Map;

/**
 * @author tmjee
 */
public class TestResultWriter {

    private final String output;

    public TestResultWriter(String output) {
        this.output = output;
    }


    public void writeTestResult(Accumulator acc) {
        /*Map<String, Long> r = acc.get();
        for (Map.Entry<String, Long> e : r.entrySet()) {
            System.out.println(e.getKey()+"="+e.getValue());
        }*/
    }
}
