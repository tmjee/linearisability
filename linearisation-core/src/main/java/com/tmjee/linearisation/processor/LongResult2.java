package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Record
public class LongResult2 {
    public volatile long value1;
    public volatile long value2;

    @Override
    public String toString() {
        return format("[%s,%s]", value1, value2);
    }
}
