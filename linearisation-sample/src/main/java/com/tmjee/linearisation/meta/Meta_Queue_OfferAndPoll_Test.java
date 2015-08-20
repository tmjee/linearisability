package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;

/**
 * @author tmjee
 */
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "FIFO observed, size is good")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "FIFO not observed, size is good")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "FIFO observed, size is not good")
public class Meta_Queue_OfferAndPoll_Test {
}
