#!/bin/bash

MYSQL_ROOT_PASSWORD=Hello1!
DB_TEST_NAME=TestDB

QUERY=docker exec -it mysql-server -U root -P $MYSQL_ROOT_PASSWORD -Q

docker-compose up -d
docker ps
sleep 20
docker exec -i mysql-server mysql -uroot -p$MYSQL_ROOT_PASSWORD $DB_TEST_NAME <sql/dummy.sql
