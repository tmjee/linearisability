package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class Logger {

    public static void log(String msg) {
        System.out.println(format("[linearisability] %s -> %s", Thread.currentThread(), msg));
    }

    public static void log(String msg, Throwable t) {
        log(msg);
        log(t);
    }

    public static void log(Throwable t) {
        System.out.println(format("[linearisability] %s exception ", Thread.currentThread()));
        t.printStackTrace(System.out);
    }
}
