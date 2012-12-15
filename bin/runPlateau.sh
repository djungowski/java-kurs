#!/bin/bash
set -x
javac PlateauUntestable.java

echo "Expected 2,1"
java -Dvalues=1,2,2 PlateauUntestable

echo "Expected 2,3"
java -Dvalues=1,2,1,3,3 PlateauUntestable

echo "Expected 1,1"
java -Dvalues=1,2,1,3 PlateauUntestable

echo "Expected 1,2"
java -Dvalues=1,2,3 PlateauUntestable

echo "Expected 0,0"
java -Dvalues=3,2,1 PlateauUntestable
