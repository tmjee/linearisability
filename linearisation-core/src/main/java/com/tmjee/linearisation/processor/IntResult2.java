package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
@Record
public class IntResult2 implements RecordType {

    public volatile int value1;
    public volatile int value2;


    @Override
    public String toString() {
        return format("[%s,%s]", value1, value2);
    }

    @Override
    public void reset() { value1 = 0; value2 = 0; }
}
