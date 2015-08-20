package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;

/**
 * @author tmjee
 */
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Player 1 and 2 got back expected values")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 get back value inserted, Player 2 did not get back value expected")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not get back value inserted, Player 2 get back value inserted")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 and 2 do not get back expected value")
@Consequence(id="[-2,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 and 2 thrown exception")
@Consequence(id="[-2,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception")
@Consequence(id="[-2,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception, Player 2 get back unexpected value")
@Consequence(id="[1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 2 throws exception")
@Consequence(id="[-1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 gets back unexpected result, Player 2 throws exception")
public class Meta_List_SetAndGet_Test {
}
