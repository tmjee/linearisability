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

    public void writeTestResult(Accumulator acc) {
        System.out.println(acc.get().keySet().size());
        acc.get().forEach((k,v)->{
            m.merge(k, 1L, (o,n)->o+n);
        });
    }

    public void writeSummary() {
        m.forEach((k,v)->Logger.log(format("%s=%s", k, v)));
    }
}
