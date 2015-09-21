package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Record
public class IntResult4 implements RecordType {
    public volatile int value1;
    public volatile int value2;
    public volatile int value3;
    public volatile int value4;

    @Override
    public String toString() {
        return format("[%s,%s,%s,%s]", value1, value2, value3, value4);
    }

    @Override
    public void reset() { value1=0; value2=0; value3=0; value4=0; }
}
