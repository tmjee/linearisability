package com.tmjee.linearisation.processor;

/**
 * @author tmjee
 */
public enum Expectation {
    /**
     * May be present as the valid result; may be absent if tests haven't been able to reach to that outcome.
     */
    ACCEPTABLE,

    /**
     * Same as ACCEPTABLE, but this outcome will be highlighted in reports.
     */
    ACCEPTABLE_INTERESTING,

    /**
     * Same as ACCEPTABLE, but only for outcomes which are formally acceptable, but may be surprising to end users.
     */
    ACCEPTABLE_SPEC,

    /**
     * Should always be absent.
     */
    FORBIDDEN,

    /**
     * Internal: no grading.
     */
    UNKNOWN,
}
