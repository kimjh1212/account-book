#!/bin/bash

# command to create and run two component images
docker-compose -f docker-compose.yml up -d
# make sure ports are open
nc -z localhost 22181
nc -z localhost 29092

docker exec -i -t account-book-kafka bash /bin/zookeeper-server-start -daemon
docker exec -i -t account-book-kafka bash /bin/kafka-server-start -daemon

SET_TOPIC=account-book-transaction-log.1
CURRENT_TOPICS=`docker exec -i -t account-book-kafka bash /bin/kafka-topics --list --bootstrap-server=localhost:29092`

if [[ $CURRENT_TOPICS == *$SET_TOPIC* ]]; then
    echo "Topic already exists. no creation request."
else
    docker exec -i -t account-book-kafka bash /bin/kafka-topics --create --topic $SET_TOPIC --bootstrap-server=localhost:29092
fi
