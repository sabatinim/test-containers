#!/bin/bash

docker-compose up -d mysql
docker-compose build db_client
docker-compose run db_client schema
docker-compose run maven  mvn -f /tmp clean install
docker-compose down --remove-orphans