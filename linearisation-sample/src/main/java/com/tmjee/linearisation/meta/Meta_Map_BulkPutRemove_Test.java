package com.tmjee.linearisation.meta;

import com.tmjee.linearisation.processor.Consequence;
import com.tmjee.linearisation.processor.Expectation;
import com.tmjee.linearisation.processor.Reference;

/**
 * @author tmjee
 */
@Consequence(id="[1]",expectation = Expectation.ACCEPTABLE, description = "size after bulk insert and delete is good")
@Consequence(id="[-1]", expectation = Expectation.FORBIDDEN, description = "size after bulk insert and delete is not good")
@Reference("https://github.com/tmjee/linearisability/blob/master/docs/results/map/BulkPutRemove_Test.md")
public class Meta_Map_BulkPutRemove_Test {
}
