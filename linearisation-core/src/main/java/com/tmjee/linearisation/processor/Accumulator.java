package com.tmjee.linearisation.processor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tmjee
 */
public class Accumulator {

    private final Map<String, Long> occurrances;

    public Accumulator() {
        this.occurrances = new ConcurrentHashMap<>();
    }

    public void record(String key) {
        occurrances.compute(key, (k,oldV)->((oldV == null) ? 1L : (oldV + 1L)));
    }

    public void record(Accumulator accumulator) {
        Map<String, Long> m = accumulator.get();
        m.forEach((k,v)->{
            occurrances.merge(k, v, (oldV, newV)->oldV+newV);
        });
    }

    public Map<String, Long> get() {
        return Collections.unmodifiableMap(new HashMap<>(occurrances));
    }

}
