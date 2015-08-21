#!/usr/bin/env bash
java -cp \
../linearisation-sample/target/linearisability-sample.jar:../linearisation-core/target/linearisation-core.jar -jar \
../linearisation-sample/target/linearisation-sample.jar \
-testClasses PriorityQueue_OfferAndPoll_Test.TestUnit1

