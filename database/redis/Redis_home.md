# Redis_home

## 数据结构

### command

1. String  -  get set del 
2. Linked List  - rpush lpush rpop lpop lrange lindex  
3. Set  - sadd srem sismember smembers  sinter sunion sdiff 
4. hash 散列  -  hget hset hgetall hdel
5. zset 既可以根据成员访问元素,又可以根据分值/分值排序访问元素

	zadd zrange [withscores]  zrem 
	zrangebyscore zset 0 -1 withscores
