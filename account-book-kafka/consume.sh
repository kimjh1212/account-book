#!/bin/bash

# make sure ports are open
nc -z localhost 22181
nc -z localhost 29092

docker exec -i -t account-book-kafka bash /bin/kafka-console-consumer --topic account-book-transaction-log.1 --bootstrap-server localhost:9092 --from-beginning