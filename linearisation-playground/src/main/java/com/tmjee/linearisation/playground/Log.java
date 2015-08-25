package com.tmjee.linearisation.playground;

import static java.lang.String.format;

/**
 * @author tmjee
 */
public class Log {
    public static void log(String msg) {
        System.out.println(format("%s - %s",Thread.currentThread(),msg));
    }
}
