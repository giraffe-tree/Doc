# Kafka Stateful Streams

## Reference



## 容错

Note, that state stores are fault-tolerant. In case of failure, Kafka Streams guarantees to fully restore all state stores prior to resuming the processing. See Fault Tolerance for further information.

## Available stateful transformations

1. aggregate
2. join
3. window 

## flatMapValues

key_a,value  -> value1, value2,

(key_a,value1),(key_a,value2)




