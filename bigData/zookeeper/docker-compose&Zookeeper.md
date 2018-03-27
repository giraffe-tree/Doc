# docker-compose Zookeeper

## 参考

https://segmentfault.com/a/1190000006907443

http://haofly.net/kafka/

https://docs.spring.io/spring-kafka/reference/html/_introduction.html

## 搭建 zookeeper 集群

#### docker-compose.yml

```
version: '2'
services:
    zoo1:
        image: zookeeper
        restart: always
        container_name: zoo1
        ports:
            - "2181:2181"
        environment:
            ZOO_MY_ID: 1
            ZOO_SERVERS: server.1=zoo1:2888:3888 server.2=zoo2:2888:3888 server.3=zoo3:2888:3888

    zoo2:
        image: zookeeper
        restart: always
        container_name: zoo2
        ports:
            - "2182:2181"
        environment:
            ZOO_MY_ID: 2
            ZOO_SERVERS: server.1=zoo1:2888:3888 server.2=zoo2:2888:3888 server.3=zoo3:2888:3888

    zoo3:
        image: zookeeper
        restart: always
        container_name: zoo3
        ports:
            - "2183:2181"
        environment:
            ZOO_MY_ID: 3
            ZOO_SERVERS: server.1=zoo1:2888:3888 server.2=zoo2:2888:3888 server.3=zoo3:2888:3888
```

#### docker-compose

```
COMPOSE_PROJECT_NAME=zk_test docker-compose up -d
COMPOSE_PROJECT_NAME=zk_test docker-compose stop
```

```
telnet localhost 2183
```

## 搭建 kafka 集群

```
version: '2'
services:
  zookeeper:
    image: zookeeper
    container_name: zookeeper_single
    ports:
      - "2181:2181"
  kafka1:
    image: wurstmeister/kafka
    build: .
    container_name: kafka1
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ADVERTISED_HOST_NAME: 47.97.199.139
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_PORT: 9092
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
  kafka2:
	image: wurstmeister/kafka
	build: .
	container_name: kafka2
	ports:
	  - "9093:9092"
	environment:
	  KAFKA_BROKER_ID: 2
	  KAFKA_ADVERTISED_HOST_NAME: 47.97.199.139
	  KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
	  KAFKA_ADVERTISED_PORT: 9093
	volumes:
	  - /var/run/docker.sock:/var/run/docker.sock
  kafka3:
	image: wurstmeister/kafka
	build: .
	container_name: kafka3
	ports:
	  - "9094:9092"
	environment:
	  KAFKA_BROKER_ID: 3
	  KAFKA_ADVERTISED_HOST_NAME: 47.97.199.139
	  KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
	  KAFKA_ADVERTISED_PORT: 9094
	volumes:
	  - /var/run/docker.sock:/var/run/docker.sock

```

启动:

```
COMPOSE_PROJECT_NAME=zkafka docker-compose up -d
```


### 消费者

```
bin/kafka-console-consumer.sh --zookeeper 47.97.199.139:2181 \
--topic hello --from-beginning
```







