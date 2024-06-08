#!/bin/bash

set -e

set -x

reset

clear

docker-compose pull 

docker-compose down --remove-orphans

docker-compose up --build -d

## firefox http://localhost:8888 &

## docker run --rm -it -p $localPort:8000 -v ${PWD}:/docs titom73/mkdocs
