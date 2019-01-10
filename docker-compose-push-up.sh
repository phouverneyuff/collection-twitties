#!/bin/bash
./gradlew clean build

docker-compose -f docker-compose.yml build --no-cache

docker-compose -f docker-compose.yml push

docker-compose -f docker-compose.yml up -d
