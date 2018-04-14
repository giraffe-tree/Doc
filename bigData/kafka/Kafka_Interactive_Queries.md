# Kafka Interactive Queries

## Reference

http://kafka.apache.org/11/documentation/streams/developer-guide/interactive-queries.html

### 错误

http://kafka.apache.org/11/documentation/streams/developer-guide/interactive-queries.html#streams-developer-guide-interactive-queries-local-key-value-stores

```
groupedByWord.count(Materialized.<String, String, KeyValueStore<Bytes, byte[]>as("CountsKeyValueStore"));
```

修改为

```
kStream1.groupBy((key, value) -> value,Serialized.with(stringSerde,stringSerde))
        .count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("CountsKeyValueStore"));
```


## 
