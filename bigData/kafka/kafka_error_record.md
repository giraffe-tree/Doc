# kafka 错误 记录


### topic LEADER_NOT_AVAILABLE

```
2018-03-31 18:00:42.360  WARN 71050 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Error while fetching metadata with correlation id 3 : {streams-input2=LEADER_NOT_AVAILABLE}
```

#### 原因

找不到主题副本的 leader ,即主题未创建

#### 解决

创建主题

### 



