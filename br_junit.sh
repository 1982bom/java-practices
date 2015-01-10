#!/bin/sh

JUNIT_CP=/usr/share/java/junit.jar
SRC=$1
CLASS=${1%.java}

javac -classpath $JUNIT_CP:. $SRC
java -classpath $JUNIT_CP:. junit.textui.TestRunner $CLASS
