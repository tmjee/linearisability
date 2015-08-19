#!/bin/bash

#
# This will run all the tests
#

java -cp \
../linearisation-sample/target/linearisability-sample.jar:../linearisation-core/target/linearisation-core.jar -jar \
../linearisation-sample/target/linearisation-sample.jar

