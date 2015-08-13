package com.tmjee.linearisation.processor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tmjee
 */
public class Accumulator {

    private Map<String, Long> occurrances;

    public Accumulator() {
        this.occurrances = new HashMap<>();
    }

    public void record(String key) {
        occurrances.compute(key, (k,oldV)->((oldV == null) ? 1L : (oldV + 1L)));
    }

    public Map<String, Long> get() {
        return Collections.unmodifiableMap(new HashMap<>(occurrances));
    }

}
