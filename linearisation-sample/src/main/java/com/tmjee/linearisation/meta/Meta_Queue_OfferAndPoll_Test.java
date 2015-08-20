package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;
import com.tmjee.linearisation.processor.Reference;

/**
 * @author tmjee
 */
@Consequence(id="[1,1]", expectation = Expectation.ACCEPTABLE, description = "FIFO observed, size is good")
@Consequence(id="[-1,1]", expectation = Expectation.FORBIDDEN, description = "FIFO not observed, size is good")
@Consequence(id="[1,-1]", expectation = Expectation.FORBIDDEN, description = "FIFO observed, size is not good")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md")
public class Meta_Queue_OfferAndPoll_Test {
}
