package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;
import com.tmjee.linearisation.processor.Reference;

/**
 * @author tmjee
 */
@Consequence(id = "[1]", expectation = Expectation.ACCEPTABLE, description = "Running count for player 1 and 2 match expected result")
@Consequence(id = "[-1]", expectation = Expectation.FORBIDDEN, description = "Running count for player 1 and 2 do not match expected result")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/PutRunningCount_Test.md")
public class Meta_Map_PutRunningCount_Test {
}
