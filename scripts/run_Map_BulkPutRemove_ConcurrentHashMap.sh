#!/usr/bin/env bash

java -cp \
../linearisation-sample/target/linearisability-sample.jar:../linearisation-core/target/linearisation-core.jar -jar \
../linearisation-sample/target/linearisation-sample.jar \
-testClasses ConcurrentHashMap_BulkPutRemove_Test.TestUnit1
