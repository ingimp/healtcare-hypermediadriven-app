#!/bin/sh
echo "********************************************************"
echo "Starting patient-service "
echo "********************************************************"
java -jar /usr/local/patient-service/@project.build.finalName@.jar
