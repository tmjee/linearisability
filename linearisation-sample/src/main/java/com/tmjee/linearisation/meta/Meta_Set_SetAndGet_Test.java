package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;

/**
 * @author tmjee
 */
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "Player 1 retrieved value added, Player 2 retrieved value added.")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 retrieved value added, Player 2 did not retrieved value added")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not retrieved value added, Player 2 retrieved value added")
@Consequence(id="[-1,-1]", expectation = Expectation.FORBIDDEN, description = "Player 1 did not retrieved value added, Player 2 did not retrieved value added")
@Consequence(id="[1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 2 throws exception")
@Consequence(id="[-1,-2]", expectation = Expectation.FORBIDDEN, description = "Player 1 result is incorrect, Player 2 throws exception")
@Consequence(id="[-2,1]", expectation = Expectation.FORBIDDEN, description = "Player 1 throws exception")
@Consequence(id="[-2,-1]", expectation = Expectation.FORBIDDEN, description = "Player 2 throws exception, Player 2 result is incorrect")
public class Meta_Set_SetAndGet_Test {
}
