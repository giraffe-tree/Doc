# Kafka Streams

## 参考

http://orchome.com/335

http://kafka.apache.org/10/documentation/streams/tutorial

https://blog.csdn.net/lizhitao/article/details/39499283

http://www.cnblogs.com/huxi2b/default.html

## 命令

### 创建主题

```
bin/kafka-topics.sh --zookeeper 47.97.199.139:2181 \
--create --topic streams-input1 --partitions 2 \
--replication-factor 2
```

```
bin/kafka-topics.sh --zookeeper 47.97.199.139:2181 \
--create --topic streams-output1 --partitions 2 \
--replication-factor 2
```


#### 检查是否创建成功

```
bin/kafka-topics.sh --zookeeper 47.97.199.139:2181 \
--list
```

# kafka stream demo

## maven

```
mvn archetype:generate \
    -DarchetypeGroupId=org.apache.kafka \
    -DarchetypeArtifactId=streams-quickstart-java \
    -DarchetypeVersion=1.0.1 \
    -DgroupId=streams.examples \
    -DartifactId=streams.examples \
    -Dversion=0.1 \
    -Dpackage=myapps
```

#### 最新

```
StreamsBuilder builder = new StreamsBuilder();  // when using the DSL
Topology topology = builder.build();
StreamsConfig config = new StreamsConfig(new HashMap<>());

KafkaStreams streams = new KafkaStreams(topology, config);
```

# 使用 kafka streams

## 1. KafkaStreams 的产生

```
StreamsBuilder builder = ...;  // when using the DSL
Topology topology = builder.build();

StreamsConfig config = ...;

KafkaStreams streams = new KafkaStreams(topology, config);
```

## 2. 开始关闭

```
KafkaStreams.start()
KafkaStreams.close()
```

```
Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
```

> After an application is stopped, Kafka Streams will migrate any tasks that had been running in this instance to available remaining instances.


## 3. 配置

#### reference

http://kafka.apache.org/11/documentation/streams/developer-guide/config-streams

### 必须设置

#### application.id

#### bootstrap.servers

### 可选配置 

### 对性能影响较小的属性

| 属性名 | 默认值 | 作用 |
| ---- | :---: | :---:|
|application.server | "" | | 
| buffered.records.per.partition |1000 | The maximum number of records to buffer per partition.| 
|	commit.interval.ms	|30000 ms|用于保存任务的位置（源主题中的偏移量）的频率。|
|metric.reporters		|	空列表|	A list of classes to use as metrics reporters.|
|	metrics.num.samples	|	The number of samples maintained to compute metrics.| 2|
|metrics.recording.level|INFO	|The highest recording level for metrics|
|metrics.sample.window.ms	|30000 ms|The window of time a metrics sample is computed over|
|partition.grouper	|DefaultPartitionGrouper|	Partition grouper class that implements the PartitionGrouper interface.|
|poll.ms	|100 ms|	The amount of time in milliseconds to block waiting for input.|
|state.cleanup.delay.ms	|6000000 ms|The amount of time in milliseconds to wait before deleting state when a partition has migrated.|
|windowstore.changelog.additional.retention.ms|1 day|Added to a windows maintainMs to ensure data is not deleted from the log prematurely. Allows for clock drift.|

### 对性能有一定影响的属性

| 属性名 | 默认值 | 作用 |
| ---- | :---: | :---:|
|cache.max.bytes.buffering	 |10485760 bytes|Maximum number of memory bytes to be used for record caches across all threads.| 
|client.id |""|An ID string to pass to the server when making requests. (This setting is passed to the consumer/producer clients used internally by Kafka Streams.)| 
|default.deserialization.exception.handler | DefaultProductionExceptionHandler |Exception handling class that implements the DeserializationExceptionHandler interface. 还有一种是  LogAndContinueExceptionHandler| 
|default.production.exception.handler	 | DefaultProductionExceptionHandler |Exception handling class that implements the ProductionExceptionHandler interface| 
|key.serde|Serdes.ByteArray().getClass().getName()| Default serializer/deserializer class for record keys| 
|num.standby.replicas		 |0|The number of standby replicas for each task.| 
|num.stream.threads		 |1|The number of threads to execute stream processing.| 
|timestamp.extractor|FailOnInvalidTimestamp|Timestamp extractor class that implements the TimestampExtractor interface.| 
|value.serde		|Serdes.ByteArray().getClass().getName()|Default serializer/deserializer class for record values, implements the Serde interface (see also key.serde)| 


### 对性能影响较大的属性

| 属性名 | 默认值 | 作用 |
| ---- | :---: | :---:|
| replication.factor	 | 1| The replication factor for changelog topics and repartition topics created by the application. Increase the replication factor to 3 to ensure that the internal Kafka Streams topic can tolerate up to 2 broker failures	| 
|state.dir	| /var/lib/kafka-streams |Directory location for state stores.|


#### Kafka consumers and producer configuration parameters

```
Properties streamsSettings = new Properties();
// Example of a "normal" setting for Kafka Streams
streamsSettings.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-broker-01:9092");
// Customize the Kafka consumer settings of your Streams application
streamsSettings.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 60000);
StreamsConfig config = new StreamsConfig(streamsSettings);
```

### Recommended configuration parameters for resiliency


|Parameter Name|Corresponding Client	| Default value| Consider setting to|
| ---- |:--:|:--:|:--:|
|acks	|Producer	|acks=1	|acks=all|
|replication.factor|	Streams|	1|	3|
|min.insync.replicas|	Broker|	1|	2|

## Streams DSL







	