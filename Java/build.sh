#!/bin/sh

if [ $1 == "clean" ]
then
    rm -rf out/com
    tree out/
fi
find . -name "*.java" -print | xargs javac -d out/
rmic -classpath out/ -d out/ com.maddy.rmi.RemoteCalculator
tree out/
