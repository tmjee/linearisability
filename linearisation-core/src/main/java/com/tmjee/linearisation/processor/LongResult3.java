package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Record
public class LongResult3 implements RecordType {
    public volatile long value1;
    public volatile long value2;
    public volatile long value3;

    @Override
    public String toString() {
        return format("[%s,%s,%s]", value1, value2, value3);
    }

    @Override
    public void reset() { value1=0; value2=0; value3=0; }
}
