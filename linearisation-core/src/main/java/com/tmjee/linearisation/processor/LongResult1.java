package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Record
public class LongResult1 implements RecordType {
    public volatile long value1;

    @Override
    public String toString() {
        return format("[%s]", value1);
    }

    @Override
    public void reset() { value1=0; }
}
