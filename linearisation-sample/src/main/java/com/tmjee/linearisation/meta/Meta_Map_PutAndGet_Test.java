package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;

/**
 * @author tmjee
 */
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Both player 1 and 2 get back expected values")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 get back expected value while Player 2 did not")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not get back expected value but Player 2 did")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Both player 1 and player 2 did not get back expected value")
@Consequence(id="[-2,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception")
@Consequence(id="[-2,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws Exception, Player 2 results is unexpected")
@Consequence(id="[1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 2 throws Exception")
@Consequence(id="[-1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 result is unexpected, Player 2 throws exception ")
public class Meta_Map_PutAndGet_Test {
}
