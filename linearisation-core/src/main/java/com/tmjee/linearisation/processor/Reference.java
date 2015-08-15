package com.tmjee.linearisation.processor;

import java.lang.annotation.*;

/**
 * @author tmjee
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(References.class)
public @interface Reference {
    String value();
}
