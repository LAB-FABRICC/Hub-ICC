#!/usr/bin/env bash

cd batch;

## build project
mvn clean install;

## generate rdf file
mvn  spring-boot:run

mv target/generated.rdf ../generatedOwl/generated.rdf

cd ..;
