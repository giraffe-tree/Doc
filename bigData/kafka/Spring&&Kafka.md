# Spring + Kafka

## 参考

[docker kafka命令](http://blog.csdn.net/u011537073/article/details/70767064)

https://docs.spring.io/spring-kafka/docs/2.0.0.M2/reference/htmlsingle/#spring-kafka-intro-new

## spring 对 kafka 的支持

1. KafkaListenerErrorHandler
2. ListenableFuture  ListenableFutureCallback 设置回调
3. SendResult  -- ProducerRecord and RecordMetadata
4. MessageListenerContainer @KafkaListener batch 
5. KafkaMessageListenerContainer receives all message from all topics/partitions on a single thread
6. 


```
@KafkaListener(id = "bar", topicPartitions =
        { @TopicPartition(topic = "topic1", partitions = { "0", "1" }),
          @TopicPartition(topic = "topic2", partitions = "0",
             partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
        })
public void listen(ConsumerRecord<?, ?> record) {
    ...
}
```








