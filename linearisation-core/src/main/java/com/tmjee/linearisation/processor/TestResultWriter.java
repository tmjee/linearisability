package com.tmjee.linearisation.processor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class TestResultWriter {

    private final String output;

    private Map<String, Long> m;

    public TestResultWriter(String output) {
        this.output = output;
        this.m = new ConcurrentHashMap<>();
    }

    public void writeStrideResult(Test test, Accumulator acc) {
        acc.get().forEach((k,v)->{
            m.merge(k, v, (o,n)->o+n);
        });
    }

    public void writeTestResult(Test test) {
        m.forEach((k,v)->Logger.log(format("%s=%s", k, v)));
        m.clear();
    }

    public void writeOverallSummary() {
    }
}
