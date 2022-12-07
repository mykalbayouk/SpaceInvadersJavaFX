#!/bin/bash

OPTS="-q -e" # quiet and produce execution error messages
JFX="-Dprism.order=sw" # specify the software renderer
CLASS="-Dexec.mainClass="
DRIVER="cs1302.game.OmegaDriver"
set -ex
mvn $OPTS clean
mvn $OPTS compile
mvn $OPTS exec:java $JFX $CLASS$DRIVER
