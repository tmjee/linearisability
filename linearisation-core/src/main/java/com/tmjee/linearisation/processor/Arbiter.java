package com.tmjee.linearisation.processor;

import java.lang.annotation.*;

/**
 * @author tmjee
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Arbiter {
}
