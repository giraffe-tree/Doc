# Kafka Connect Mqtt

## Reference

### 官方文档

http://kafka.apache.org/documentation/#connect

https://www.confluent.io/blog/building-real-time-streaming-etl-pipeline-20-minutes/

https://community.mapr.com/community/exchange/blog/2017/05/29/building-kafka-connect-connectors-between-data-systems-and-kafka

### Stream Reactor  较新,收费

[github.com/Landoop/stream-reactor](https://github.com/Landoop/stream-reactor)

 [Kafka connect MQTT source to write data from MQTT to Kafka.](https://lenses.stream/connectors/source/mqtt.html)

[Kafka connect MQTT sink to write data from Kafka to MQTT.](https://lenses.stream/connectors/sink/mqtt.html)


### Mqtt to Apache Kafka Connect

**We use ->**  [github.com/evokly/kafka-connect-mqtt](https://github.com/evokly/kafka-connect-mqtt)

#### 编译

build project: ```./gradlew clean jar``` - output ```./build/libs```

#### 加入 maven 仓库

```
mvn install:install-file -Dfile=kafka-connect-mqtt-1.1-SNAPSHOT.jar -DgroupId=com.github.evokly -DartifactId=kafka-connect-mqtt -Dversion=1.0 -Dpackaging=jar
```

#### 引入

```
<dependency>
    <groupId>com.github.evokly</groupId>
    <artifactId>kafka-connect-mqtt</artifactId>
    <version>1.0</version>
</dependency>
```


# 使用

## 基本配置

1. bootstrap.servers
2. key.converter
3. value.converter
4. offset.storage.file.filename  (standalone mode)

### 分布式 connect 配置

1. group.id
2. config.storage.topic  connect-configs  1 partition 3 replicated
3. offset.storage.topic   connect-offsets    3 partition   3 replicated
4. status.storage.topic   connect-status    3 partition   3  replicated














