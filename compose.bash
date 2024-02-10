#!/bin/bash

reset

clear

rm -rf target

mvn install

cd target

java -jar project-paja-usher-rule-1.0.jar
