package com.tmjee.linearisation.processor;

import java.lang.annotation.*;

/**
 * @author tmjee
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Linearisable {
    String name();
}
