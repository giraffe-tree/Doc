# kafka 错误 记录


### topic LEADER_NOT_AVAILABLE

```
2018-03-31 18:00:42.360  WARN 71050 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Error while fetching metadata with correlation id 3 : {streams-input2=LEADER_NOT_AVAILABLE}
```

#### 原因

1. 找不到主题副本的 leader 
2. 新的 broker 加入集群, 部分副本会移动到新的 broker 上,导致客户端上的元数据过期, 将之前的请求发到了错误的 broker 上. 当它收到错误时,会先刷新元数据,再去尝试重发请求.

#### 解决

1. 创建主题

### non-subscribed topic regex pattern 

#### 原因 

可能是在一个程序中用了多个相同配置的streams , clientId/groupid等等相同导致

#### 解决

更换配置或者只是用一个streams


### DataException: Invalid type for STRING: class [B

```
org.apache.kafka.connect.errors.DataException: Invalid type for STRING: class [B
	at org.apache.kafka.connect.json.JsonConverter.convertToJson(JsonConverter.java:659)
	at org.apache.kafka.connect.json.JsonConverter.convertToJsonWithEnvelope(JsonConverter.java:537)
	at org.apache.kafka.connect.json.JsonConverter.fromConnectData(JsonConverter.java:290)
	at org.apache.kafka.connect.runtime.WorkerSourceTask.sendRecords(WorkerSourceTask.java:220)
	at org.apache.kafka.connect.runtime.WorkerSourceTask.execute(WorkerSourceTask.java:187)
	at org.apache.kafka.connect.runtime.WorkerTask.doRun(WorkerTask.java:170)
	at org.apache.kafka.connect.runtime.WorkerTask.run(WorkerTask.java:214)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)

```

#### 原因 

数据格式转换错误

mqtt 数据格式 转换成 kafka 数据格式出错

#### 解决

将```Schema.STRING_SCHEMA, message.getPayload() ``` 改成 ```Schema.BYTES_SCHEMA, message.getPayload()``` 后解决.


### The group member's supported protocols are incompatible with those of existing members or first group member tried to join with empty protocol type or empty protocol list.

#### 可能的原因

可能有2个消费者在消费这个topic，只能有1个消费。

http://orchome.com/482

### replication factor 与 broker 数不匹配

```
Could not create internal topics: Found only 2 brokers,  but replication factor is 3. Decrease replication factor for internal topics via StreamsConfig parameter "replication.factor" or add more brokers to your cluster.
```


