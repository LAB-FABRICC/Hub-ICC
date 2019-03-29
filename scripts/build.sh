#!/usr/bin/env bash

cd batch;

## build project
mvn clean install;

## generate rdf file
cd target/classes;
java net.scub.hubicc.batch.RDFMain;