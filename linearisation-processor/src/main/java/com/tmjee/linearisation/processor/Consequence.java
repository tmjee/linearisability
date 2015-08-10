package com.tmjee.linearisation.processor;

import java.lang.annotation.*;

/**
 * @author tmjee
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Repeatable(Consequences.class)
public @interface Consequence {
    String id();
    Expectation expectation();
    String description();
}
