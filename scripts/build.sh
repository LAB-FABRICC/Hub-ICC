#!/usr/bin/env bash

cd batch;

## build project
#mvn clean install;
docker run -it --rm --name hub-icc -v "/tmp/hub-icc/.m2:/root/.m2" -v "$(pwd)":/usr/src/3-jdk-11-slim -w /usr/src/3-jdk-11-slim maven:3-jdk-11-slim mvn clean install

## generate rdf file
#mvn  spring-boot:run
docker run -it --rm --name hub-icc -v "/tmp/hub-icc/.m2:/root/.m2" -v "$(pwd)":/usr/src/3-jdk-11-slim -w /usr/src/3-jdk-11-slim maven:3-jdk-11-slim mvn spring-boot:run

cd ..;
