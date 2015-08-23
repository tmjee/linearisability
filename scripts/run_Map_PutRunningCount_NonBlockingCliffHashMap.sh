#!/bin/bash

java -cp \
../linearisation-sample/target/linearisability-sample.jar:../linearisation-core/target/linearisation-core.jar -jar \
../linearisation-sample/target/linearisation-sample.jar \
-testClasses SbNonBlockingCliffHashMap_PutRunningCount_Test.TestUnit1
