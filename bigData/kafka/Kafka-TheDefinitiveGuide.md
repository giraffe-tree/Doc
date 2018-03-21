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














