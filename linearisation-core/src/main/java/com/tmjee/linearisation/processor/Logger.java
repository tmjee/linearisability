package com.tmjee.linearisation.processor;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class Logger {

    static volatile QueuedLogger Q;

    public static void setLogger(QueuedLogger l) {
       Q = l;
    }


    public static void log(String msg) {
        String m  = format("[linearisability] %s -> %s", Thread.currentThread(), msg);
        if (Q != null) {
            Q.log(m, null);
        } else {
            System.out.println(m);
        }
    }

    public static void log(String msg, Throwable t) {
        log(msg);
        log(t);
    }

    public static void log(Throwable t) {
        String m = format("[linearisability] %s exception ", Thread.currentThread());
        if (Q != null) {
            Q.log(m, t);
        } else {
            System.out.println(m);
            t.printStackTrace(System.out);
        }
    }
}
