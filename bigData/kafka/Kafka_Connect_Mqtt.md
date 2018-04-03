# Kafka Connect Mqtt

## Reference

### 官方文档

http://kafka.apache.org/documentation/#connect

https://www.confluent.io/blog/building-real-time-streaming-etl-pipeline-20-minutes/

https://community.mapr.com/community/exchange/blog/2017/05/29/building-kafka-connect-connectors-between-data-systems-and-kafka

https://gerardnico.com/dit/kafka/connect/connector

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
2. config.storage.topic  connect-configs  1 partition 3 replicated
3. offset.storage.topic   connect-offsets    3 partition   3 replicated
4. status.storage.topic   connect-status    3 partition   3  replicated



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

将需要的jar包加入: docker容器中的地址 - ```/opt/kafka_2.12-1.0.1/libs```


## 管理

### GET /connectors 

- return a list of active connectors

### POST /connectors 

- create a new connector; the request body should be a JSON object containing a string name field and an object config field with the connector configuration parameters

send: 

```
{
  "name":"mqtt-connector",
  "config":{
    "connector.class":"com.evokly.kafka.connect.mqtt.MqttSourceConnector",
    "tasks.max": "5",
    "key.converter": "org.apache.kafka.connect.json.JsonConverter",
    "value.converter": "org.apache.kafka.connect.json.JsonConverter",
    "mqtt.topic": "hello",
    "kafka.topic": "hello",
    "mqtt.user": "xxx",
    "mqtt.password": "xxx",
    "message_processor_class": "com.evokly.kafka.connect.mqtt.sample.DumbProcessor"
  }
}
```

### GET /connectors/{name} 

- get information about a specific connector


```
{
    "name": "mqtt-connector",
    "config": {
        "connector.class": "com.evokly.kafka.connect.mqtt.MqttSourceConnector",
        "tasks.max": "5",
        "name": "mqtt-connector",
        "topic": "hello",
        "value.converter": "org.apache.kafka.connect.json.JsonConverter",
        "key.converter": "org.apache.kafka.connect.json.JsonConverter",
        "mqtt.topic": "hello"
    },
    "tasks": [
        {
            "connector": "mqtt-connector",
            "task": 0
        }
    ],
    "type": "source"
}
```

### GET /connectors/{name}/config 

- get the configuration parameters for a specific connector

### PUT /connectors/{name}/config 

- update the configuration parameters for a specific connector

### GET /connectors/{name}/status 

- get current status of the connector, including if it is running, failed, paused, etc., which worker it is assigned to, error information if it has failed, and the state of all its tasks

```
{
    "name": "mqtt-connector",
    "connector": {
        "state": "RUNNING",
        "worker_id": "172.21.0.3:8083"
    },
    "tasks": [
        {
            "state": "RUNNING",
            "id": 0,
            "worker_id": "172.21.0.3:8083"
        }
    ],
    "type": "source"
}
```

### GET /connectors/{name}/tasks 

- get a list of tasks currently running for a connector

### GET /connectors/{name}/tasks/{taskid}/status 

- get current status of the task, including if 
it is running, failed, paused, etc., which worker it is assigned to, and error information if it has failed

```
{
    "state": "RUNNING",
    "id": 0,
    "worker_id": "172.21.0.3:8083"
}
```

### PUT /connectors/{name}/pause 

- pause the connector and its tasks, which stops message processing until the connector is resumed

### PUT /connectors/{name}/resume 

- resume a paused connector (or do nothing if the connector is not paused)

### POST /connectors/{name}/restart 

- restart a connector (typically because it has failed)

### POST /connectors/{name}/tasks/{taskId}/restart 

- restart an individual task (typically because it has failed)

### DELETE /connectors/{name} 

- delete a connector, halting all tasks and deleting its configuration
Kafka Connect also provides a REST API for getting information about connector plugins:

### GET /connector-plugins

- return a list of connector plugins installed in the Kafka Connect cluster. Note that the API only checks for connectors on the worker that handles the request, which means you may see inconsistent results, especially during a rolling upgrade if you add new connector jars

### PUT /connector-plugins/{connector-type}/config/validate 

- validate the provided configuration values against the configuration definition. This API performs per config validation, returns suggested values and error messages during validation.

