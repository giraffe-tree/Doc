# Kafka VS RabbitMQ

## 简单比较

RabbitMQ是一个AMQP实现，传统的messaging queue系统实现，基于Erlang。老牌MQ产品了。AMQP协议更多用在企业系统内，对数据一致性、稳定性和可靠性要求很高的场景，对性能和吞吐量还在其次。

Kafka是linkedin开源的MQ系统，主要特点是基于Pull的模式来处理消息消费，追求高吞吐量，一开始的目的就是用于日志收集和传输，0.8开始支持复制，不支持事务，适合产生大量数据的互联网服务的数据收集业务。

## 参考

####  日志：每个软件工程师都应该知道的有关实时数据的统一概念

https://github.com/oldratlee/translations/blob/master/log-what-every-software-engineer-should-know-about-real-time-datas-unifying/README.md

#### 官网 

[Apache kafka](http://kafka.apache.org/)

A distributed streaming platform .


