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


