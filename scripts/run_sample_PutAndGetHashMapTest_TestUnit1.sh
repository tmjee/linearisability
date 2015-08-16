#!/bin/bash

#
# This will run the PutAndGetHashMapTest.TestUnit1
#

java -cp \
../linearisation-sample/target/linearisability-sample.jar:../linearisation-core/target/linearisation-core.jar -jar \
../linearisation-sample/target/linearisation-sample.jar \
-testClasses PutAndGetHashMapTest.TestUnit1 

