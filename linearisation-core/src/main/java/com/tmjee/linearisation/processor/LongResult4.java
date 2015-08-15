package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class LongResult4 {
    public volatile long value1;
    public volatile long value2;
    public volatile long value3;
    public volatile long value4;

    @Override
    public String toString() {
        return format("[%s,%s,%s,%s]", value1, value2, value3, value4);
    }
}
