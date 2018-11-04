# Flink MeetUp

## 总结

小小的总结一下, 今天这场 flink meetUp 想去的原因呢, 很简单 -- 在家有点无聊, 想出去走走. 然后就约了这场分享会, 定了下去上海的高铁票. 出行之时, 还出现了点小插曲. 原来以为的是10点半从家出发差不多, 结果 10点多的时候, 一看火车票时间, 10点30分, 呀, 计算失误, 来不及了... 没办法, 又定了唯一的一班 11点半的高铁, 前面一班改签都来不及改了. 

说说收获吧

### 有赞

第一个分享者来自有赞, 他们的实时平台架构大概是这样的.

![有赞实时平台架构](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/youzan_yarn.png)

他比较了一下, `Flink` 和 `SparkStructured Streaming`的区别

简单来讲,

1. 性能上, `Flink` 的延迟更低, 在吞吐量和延迟上达到了一个很好的平衡
2. sql 支持上, `Flink` 对 一个query包含多个聚合, distinct 去重 等比 `SparkStructured Streaming` 处理的更好

后面讲了 `flink` 在 `yarn `上进行部署时产生的一些问题, 我对此不太了解, 就不展开了

#### Flink 结合 spring 

这里他主要讲了, 如何在Spring 中使用 Flink, 主要是用了下图中的结构

![Flink with spring](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/youzan_spring_flink.png)

#### Flink 异步不支持 KeyedState

![Flink 异步不支持 KeyedState](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/youzan_async_keyedState.png)

#### Flink Cep

cep 即 Complex event processing

![youzan_cep](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/youzan_cep.png)

#### pdf

[【01 有赞 杨诗旻】Flink 在有赞的实践 final.pdf](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/%E3%80%9001%20%E6%9C%89%E8%B5%9E%20%E6%9D%A8%E8%AF%97%E6%97%BB%E3%80%91Flink%20%E5%9C%A8%E6%9C%89%E8%B5%9E%E7%9A%84%E5%AE%9E%E8%B7%B5%20final.pdf)

### 袋鼠云

袋鼠云主要做了一件事, 扩展了 Flink SQL, 使得 外部数据源的结构化数据/key-value 也可以参与进 流的计算中.

开源地址: [https://github.com/DTStack/flinkStreamSQL](https://github.com/DTStack/flinkStreamSQL)

#### pdf

[【02 袋鼠云 杨思枢】Flink在袋鼠云一站式大数据平台中的使用.pdf](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/%E3%80%9002%20%E8%A2%8B%E9%BC%A0%E4%BA%91%20%E6%9D%A8%E6%80%9D%E6%9E%A2%E3%80%91Flink%E5%9C%A8%E8%A2%8B%E9%BC%A0%E4%BA%91%E4%B8%80%E7%AB%99%E5%BC%8F%E5%A4%A7%E6%95%B0%E6%8D%AE%E5%B9%B3%E5%8F%B0%E4%B8%AD%E7%9A%84%E4%BD%BF%E7%94%A8.pdf)

### 汇智

主要使用 一个规则引擎来进行数据处理... 具体看 pdf, 感觉没啥新意.

[【03 汇智 谭杰河】汇智在Flink上的实践.pdf](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/%E3%80%9003%20%E6%B1%87%E6%99%BA%20%E8%B0%AD%E6%9D%B0%E6%B2%B3%E3%80%91%E6%B1%87%E6%99%BA%E5%9C%A8Flink%E4%B8%8A%E7%9A%84%E5%AE%9E%E8%B7%B5.pdf)

### rocketMQ commiter

主要讲讲这个

讲得很不错. 作者是王鑫, 一个专注于流处理的开源爱好者, 来源是 2018.11.04 flink meetup 上海站. 他的github是 [https://github.com/vesense](https://github.com/vesense).

下载地址: [Stream Processing with Apache RocketMQ and Apache Flink](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/%E3%80%9004%20RocketMQ%20%E7%8E%8B%E9%91%AB%E3%80%91Stream%20Processing%20with%20Apache%20RocketMQ%20and%20Apache%20Flink.pdf)

#### 趋势 -- 批流统一

提到了 google 开源的`apache beam`, 可以参考下这篇:[Apache Beam简介
](https://blog.csdn.net/ffjl1985/article/details/78046971), 它使用了 批流统一处理的api.

今年在杭州的阿里云栖大会上, 我听了几场flink的分享, 注意到了一个东西, 就是阿里的实时计算产品 `Blink`已经提供了批流统一处理的api, `Blink`是基于`flink`开发出来的一套产品, 我看了 `blink` 的文档 [Blink batch](https://help.aliyun.com/knowledge_detail/88090.html?spm=a2c4g.11186623.6.580.1b4f4eb0N9KqiT), 已经可以试用了.

![wangxin_batch_streaming](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/wangxin_batch_streaming.png)

#### open-messaging

open-messaging 是一套规范, 为流的应用程序提供一套统一的api标准. 简单来讲, 为了在多个MQ系统上, 都能使用同一套代码, open-messaging 也会提供一套默认实现, 比如 open-messaging 实现了批流统一, 那么 MQ 的开源者们, 如 kafka 就不必去再实现一次了. 

github: [https://github.com/openmessaging/specification/](https://github.com/openmessaging/specification/) 有兴趣可以看下.

他还提到了一点, 很多 MQ 都提供了一套 流处理的实现, 如 kafka-streams, ksql, spark-stream, rocketMQ-stream等.

#### 流处理最好的标准就是 sql

清晰明了,简单通用,可优化.

### 阿里

主要讲了 flink 的资源分配, 不过没讲啥实现的东西, 没怎么听.

[【05 阿里 砚田】提高Flink易用性.pdf](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/flink/%E3%80%9005%20%E9%98%BF%E9%87%8C%20%E7%A0%9A%E7%94%B0%E3%80%91%E6%8F%90%E9%AB%98Flink%E6%98%93%E7%94%A8%E6%80%A7.pdf)


