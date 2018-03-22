# Kafka: The Definitive Guide

kafka: 存储和持续处理大型的数据流,分布式流平台

## 参考

https://github.com/apache/kafka

http://kafka.apache.org/

## 准备


# 第一章 初识 kafka

## 1.2 kafka 登场

### 1.2.1 消息和批次

kafka 会将消息分批次写入

### 1.2.2 模式

消息模式   apache avro

数据格式的一致性

# 第三章  kafka 生产者 -- 向 kafka 写入数据

## 3.2 创建 kafka 生产者

我们从创建一个 ```ProducerRecord```对象开始

### kafka 生产者有3个必选的属性

1. bootstrap.servers  地址的格式为```host:port```
2. key.serializer
3. value.serializer

### 发送消息的三种方式

1. 发送并忘记 fire-and-forget
2. 同步发送
3. 异步发送




# 第九章  管理 kafka

## 9.1 主题操作

### 9.1.1 创建主题

cd /opt/kafka_2.12-1.0.1/bin

```
./kafka-topics.sh --create --zookeeper zookeeper:2181 \
--replication-factor 1 --partitions 1 --topic test --if-not-exists

./kafka-topics.sh  --zookeeper 你的zookeeperIP:2181 --create --replication-factor 1 --partitions 1 --topic test
```

参数解释:

1. replication-factor 副本
2. partitions 分区
3. --if-not-exists 忽略重复创建主题的错误

	 > ERROR org.apache.kafka.common.errors.TopicExistsException: Topic 'test' already exists

### 9.1.2 增加分区

1. 主题基于分区进行伸缩和复制
2. 增加分区主要是为了扩展主题容量或者降低单个分区的吞吐量.
3. 如果要在单个消费者群组内运行更多的消费者,那么主题数量也需要相应增加,因为一个分区只能由群组里的一个消费者读取

```
./kafka-topics.sh --zookeeper zookeeper:2181/kafka-cluster \
--alter --topic test --partitions 8 
```

主题不存在

> Topic test does not exist on ZK path zookeeper:2181/kafka-cluster
> ERROR java.lang.IllegalArgumentException: Topic test does not exist on ZK path zookeeper:2181/kafka-cluster

主题增加分区

> WARNING: If partitions are increased for a topic that has a key, the partition logic or ordering of the messages will be affected
Adding partitions succeeded!

### 9.1.3 删除主题

为了能够删除主题, broker 的 ```delete.topic.enable``` 参数必须设置为 true,否者删除主题的请求会被忽略.

**注意:** 删除主题会丢弃主题里的所有数据.

```
./kafka-topics.sh --zookeeper zookeeper:2181 \ 
--delete --topic test
```

删除成功

```
Topic spring is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
```

删除失败

```
Error while executing topic command : Topic s does not exist on ZK path zookeeper:2181
[2018-03-21 14:14:49,462] ERROR java.lang.IllegalArgumentException: Topic s does not exist on ZK path zookeeper:2181
```

### 9.1.4 列出 

查看 topic 列表

```
./kafka-topics.sh --list --zookeeper zookeeper:2181
```

### 9.1.5 列出主题详细信息

```
./kafka-topics.sh --zookeeper zookeeper:2181 --describe \
--topic test
```

1. ```--under-replicated-partitions``` 列出所有包含不同步副本的分区
2. ```--unavailable-partitions``` 参数是可以列出所有没有首领的分区

	> 这些分区已经处于离线状态,对于生产者和消费者来说都是不可用的

## 9.2 消费者群组

### 9.2.1 列出并描述群组

#### 列出旧版本的消费者群组

```
./kafka-consumer-groups.sh --zookeeper zookeeper:2181 --list
```

返回:

```
Note: This will only show information about consumers that use ZooKeeper (not those using the Java consumer API).
```

#### 列出新版本的消费者群组

```
./kafka-consumer-groups.sh --new-consumer --bootstrap-server \
47.97.199.139:9092 --list
```

返回

```
The --new-consumer option is deprecated and will be removed in a future major release.The new consumer is used by default if the --bootstrap-server option is provided.
Note: This will not show information about old Zookeeper-based consumers.
```

#### 使用 describe

```
./kafka-consumer-groups.sh --new-consumer --bootstrap-server \
47.97.199.139:9092 --describe
```
返回

```
Missing required argument "[group]"
```

再试一次

```
./kafka-consumer-groups.sh --zookeeper zookeeper:2181 \
--describe --group testgroup
```

返回

```
Note: This will only show information about consumers that use ZooKeeper (not those using the Java consumer API).

Error: The consumer group 'testgroup' does not exist.
```

### 9.2.2 删除群组

只有旧版本的消费者客户端才支持删除群组操作.

删除群组操作姜葱 zookeeper 上移除整个群组,包括所有已保存的偏移量

在执行该操作之前,必须关闭所有的消费者,如果不先执行这一步,可能会导致消费者出现不可预测的行为,因为群组的元数据已经从 zookeeper 上移除了

```
./kafka-consumer-groups.sh --zookeeper zookeeper:2181 \
--delete --group testgroup
```

返回

```
Note: This will only show information about consumers that use ZooKeeper (not those using the Java consumer API).

Error: Delete for group 'testgroup' failed because group does not exist.
```

再试一次

```
./kafka-consumer-groups.sh --zookeeper zookeeper:2181 \
--delete --group testgroup --topic test
```

返回

```
Note: This will only show information about consumers that use ZooKeeper (not those using the Java consumer API).

Error: Delete for group 'testgroup' topic 'test' failed because group does not exist.
```

### 9.2.3 偏移量管理

#### 导出偏移量

在当前目录生成 偏移量的文件

```
kafka-run-class.sh kafka.tools.ExportZkOffsets \
--zkconnect zookeeper:2181 --group testgroup \
--output-file offsets
```

#### 导入偏移量

在导入偏移量之前,必须先关闭所有消费者,如果消费者群组处于活跃状态,它们不会读取新的偏移量,反而有可能将导入的偏移量覆盖.

```
kafka-run-class.sh kafka.tools.ImportZkOffsets \
--zkconnect zookeeper:2181 \
--input-file offsets
```

导入 offsets 文件

## 9.3 动态配置变更

### 9.3.1 覆盖主题的默认配置

### 9.3.2 覆盖客户端的默认配置

### 9.3.3 列出被覆盖的配置

### 9.3.4 移除被覆盖的配置

## 9.4 分区管理

[kafka 为什么要进行分区分段 -- https://www.zhihu.com/question/28925721](https://www.zhihu.com/question/28925721)

[kafka的log存储解析——topic的分区partition分段segment以及索引等](https://www.cnblogs.com/dorothychai/p/6181058.html)

### 9.4.1 分区选举

### 9.4.2 修改分区副本

#### 什么时候需要修改分区副本

1. 主题分区在整个集群里的不均衡分布造成了集群负载的不均衡
2. broker 离线造成分区不同步
3. 新加入的 broker 需要从集群那里获得负载


### 9.4.3 修改复制系数


### 9.4.4 转储日志片段

### 9.4.5 副本验证

```
./kafka-replica-verification.sh --broker-list localhost:9092 \
--topic-while-list 't*'
```

## 9.5 消费和生产

我们可以使用两个工具

1. kafka-console-consumer.sh
2. kafka-console-producer.sh

### 消费

```
$ ./kafka-console-consumer.sh --zookeeper zookeeper:2181 \
> --topic chen
Using the ConsoleConsumer with old consumer is deprecated and will be removed in a future major release. Consider using the new consumer by passing [bootstrap-server] instead of [zookeeper].
```

```
./kafka-console-consumer.sh  --broker-list \
localhost:9092 --topic chen
```

--new-consumer

## 9.7 不安全的操作

# 第十章 监控 kafka










