#!/bin/bash

reset

clear

rm -rf target

mvn install

cd target

java -jar article-magick-api-1.0.jar
