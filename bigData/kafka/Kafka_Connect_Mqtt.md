# Kafka Connect Mqtt

## Reference

### 官方文档

http://kafka.apache.org/documentation/#connect

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

## 你需要做的

自定义的任务实现类,不需要我们知道消息是如何写进kafka以及如何保存偏移量,只需要将需要的记录列表读出,并将其返回就可以了.


## 基本配置

1. bootstrap.servers
2. key.converter
3. value.converter
4. offset.storage.file.filename  (standalone mode)

### 分布式 connect 配置

1. group.id
2. config.storage.topic
3. offset.storage.topic
4. status.storage.topic

### 查看默认配置


```
cat connect-distributed.properties | grep -v "#"
```

output:

```
bootstrap.servers=localhost:9092

group.id=connect-cluster

key.converter=org.apache.kafka.connect.json.JsonConverter
value.converter=org.apache.kafka.connect.json.JsonConverter
key.converter.schemas.enable=true
value.converter.schemas.enable=true

internal.key.converter=org.apache.kafka.connect.json.JsonConverter
internal.value.converter=org.apache.kafka.connect.json.JsonConverter
internal.key.converter.schemas.enable=false
internal.value.converter.schemas.enable=false

offset.storage.topic=connect-offsets
offset.storage.replication.factor=1

config.storage.topic=connect-configs
config.storage.replication.factor=1

status.storage.topic=connect-status
status.storage.replication.factor=1

offset.flush.interval.ms=10000

```

### 配置 plugins

```
plugin.path=/data/k1
```

### NoClassDefFoundError 

libs needs to be added to CLASSPATH:

	kafka-connect-mqtt-{project.version}.jar
	org.eclipse.paho.client.mqttv3-1.0.2.jar

	if used with ssl there are more.. (./gradlew copyRuntimeLibs copies all runtime libs to ./build/output/lib)


