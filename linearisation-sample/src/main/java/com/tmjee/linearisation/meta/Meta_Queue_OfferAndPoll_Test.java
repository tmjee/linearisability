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
@Consequence(id="[0,1]", expectation = Expectation.FORBIDDEN, description = "Exception observed, size is good")
@Consequence(id="[0,-1]", expectation = Expectation.FORBIDDEN, description = "Exception observed, size is not good")
@Consequence(id="[0,0]", expectation = Expectation.FORBIDDEN, description = "Exception observed")
@Consequence(id="[1,0]", expectation = Expectation.FORBIDDEN, description = "FIFO observed, exception observed")
@Consequence(id="[-1,0]", expectation = Expectation.FORBIDDEN, description = "FIFO not observed, exception observed")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/queue/OfferAndPoll_Test.md")
public class Meta_Queue_OfferAndPoll_Test {
}
