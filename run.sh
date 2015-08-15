#!/bin/bash

#
# This will run the tests
#

java -cp \
./linearisation-processor/target/linearisability-processor.jar:\
./linearisation-core/target/linearisation-core.jar -jar \
./linearisation-core/target/linearisation-core.jar

