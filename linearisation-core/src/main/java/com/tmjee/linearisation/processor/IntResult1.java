package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Record
public class IntResult1 {
    public volatile int value1;

    @Override
    public String toString() {
        return format("[%s]", value1);
    }
}
