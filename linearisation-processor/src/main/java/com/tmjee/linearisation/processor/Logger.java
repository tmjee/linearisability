package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class Logger {

    public static void log(String msg) {
        System.out.println(format("[linearisability] %s -> %s", Thread.currentThread(), msg));
    }
}
