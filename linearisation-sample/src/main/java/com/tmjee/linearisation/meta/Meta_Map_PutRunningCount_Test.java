package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;

/**
 * @author tmjee
 */
@Consequence(id = "[1]", expectation = Expectation.ACCEPTABLE, description = "Running count for player 1 and 2 match expected result")
@Consequence(id = "[-1]", expectation = Expectation.FORBIDDEN, description = "Running count for player 1 and 2 do not match expected result")
public class Meta_Map_PutRunningCount_Test {
}
