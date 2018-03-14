# Redis

## 参考

1. Redis 实战

2. https://redis.io/commands



# 第一章 redis入门, 简介

### 总览

功能

1. 存储 键key 和五种不同类型的 值value 之间的 映射 mapping
2. 可以将存储再内存的键值对数据持久化到硬盘
3. 可以使用复制特性来扩展读性能
4. 可以使用客户端分片来扩展写性能

	分片: 一种将数据划分为多个部分的方法,对数据的划分可以基于键包含的id,散列值,或者以上两种的集合.

	通过对数据的分片,可以将数据存到多台机器中,也可以从多台机器里面取得数据

### 持久化方法

1. 时间点转储

	- 指定时间指定数量的写操作执行 
	- 通过调用两条转出到硬盘(dump-to-disk)命令中的任何一条来执行

2. 日志转储

	- 将所有修改了数据库的命令都写入一个只追加(appen-only)文件里.
	- 用户可以根据数据的重要程度,将追加写入设置为

		1. 从不同步
		2. 每秒同步一次
		3. 每写入一个命令就同步一次

### 故障转移支持

Redis 实现了主从复制特性: 

1. 执行复制的从服务器会连接上主服务器,接受主服务器发送的整个数据库的初始副本.
2. 主服务器执行的写命令,都回被发送到所有连接的从服务器去执行,实时更新从服务器的数据集



### 数据结构


结构类型|结构存储的值|结构的读写能力
----|------|----
STRING|可以是字符串、整数或者浮点数|对整个字符串或者字符串的其中一部分执行操作；对整数和浮点数执行自增（increment）或者自减（decrement）操作
LIST|一个链表，链表上的每个节点都包含了一个字符串|从链表的两端推入或者弹出元素；根据偏移量对链表进行修剪（trim）；读取单个或者多个元素；根据值查找或者移除元素
SET|包含字符串的无序收集器（unordered collection），并且被包含的每个字符串都是独一无二、各不相同的|添加、获取、移除单个元素；检查一个元素是否存在于集合中；计算交集、并集、差集；从集合里面随机获取元素
HASH|包含键值对的无序散列表|添加、获取、移除单个键值对；获取所有键值对
ZSET|字符串成员（member）与浮点数分值（score）之间的有序映射，元素的排列顺序由分值的大小决定|添加、获取、删除单个元素；根据分值范围（range）或者成员来获取元素


### String

1. GET key
2. SET key value [EX seconds] [PX milliseconds] [NX|XX]
3. DEL key [key ...]
4. MSET key value [key value ...] //summary: Set multiple keys to multiple values


```
set hello world EX 12 xx  // 设置一个值,在12秒后过期

EX seconds：设置key的过时时间，单位为秒。
PX milliseconds：设置key的过期时间，单位为毫秒。

NX：（if Not eXist）只有键key不存在的时候才会设置key的值
XX：只有键key存在的时候才会设置key的值

mset a 1 b 2
```

### Linked list

1. LPUSH key value [value ...]
  
	summary: Prepend one or multiple values to a list

2. RPUSH key value [value ...]
3. LPOP key
  
	summary: Remove and get the first element in a list

4. RPOP key


5. LRANGE key start stop

	summary: Get a range of elements from a list

	```
	lrange list 0 -1
	```

6. LINDEX key index

	summary: Get an element from a list by its index


### zset

#### zinterstore

ZINTERSTORE destination numkeys key [key ...] [WEIGHTS weight] [AGGREGATE SUM|MIN|MAX]
  
  summary: Intersect multiple sorted sets and store the resulting sorted set in a new key

```
zinterstore sum_books 2 groups:books score:goods
--> (integer) 3
zrange sum_books 0 -1 withscores
--> 1) "book:1"
2) "234"
3) "book:3"
4) "246"
5) "book:5"
6) "251"

```




### 总结

1. String  -  get set del 
2. Linked List  - rpush lpush rpop lpop lrange lindex  
3. Set  - sadd srem sismember smembers  sinter sunion sdiff 
4. hash 散列  -  hget hset hgetall hdel
5. zset 既可以根据成员访问元素,又可以根据分值/分值排序访问元素

	zadd zrange [withscores]  zrem 
	zrangebyscore zset 0 -1 withscores
	zscore zset key
	zincrby zset num key
	zrange zset 0 -1 withscores
	zrevrange zset start stop withscores


注意:

1. 在添加/删除/修改元素时,应当考虑事务


# 第二章 解决问题

### 投票问题

### token 存储

### 浏览记录

### 购物车

### 静态网页缓存

### 数据行缓存

# 第三章 redis 命令

## 3.1 字符串

### 自增自减

#### incr decr

1. 如果redis对一个不存在的键或者空字符串的键,进行自加自减,则会将这个原始值当做 0 来使用

整数 

```
127.0.0.1:6379> set hello 1
OK
127.0.0.1:6379> incr hello
(integer) 2
127.0.0.1:6379> get hello
"2"
```

浮点数

```
127.0.0.1:6379> set hello 1.21
OK
127.0.0.1:6379> get hello
"1.21"
127.0.0.1:6379> incr hello
(error) ERR value is not an integer or out of range
```

### incrby decrby

```
127.0.0.1:6379> set hello 1
OK
127.0.0.1:6379> incrby hello 21313
(integer) 21314
```

### incrbyfloat

```
127.0.0.1:6379> set hello 1.2
OK
127.0.0.1:6379> incrbyfloat hello 13.23   // 这个值可以是负数
"14.43"

```

## 处理子串 

### append 

将一个字符串追加到另一个字符串的末尾

```
127.0.0.1:6379> set hello world
OK
127.0.0.1:6379> get hello
"world"
127.0.0.1:6379> append hello 23232
(integer) 10
127.0.0.1:6379> get hello
"world23232"

```

### getrange

获取一个子串

GETRANGE key start end

  summary: Get a substring of the string stored at a key

```
127.0.0.1:6379> getrange hello 3 5
"orl"
127.0.0.1:6379> get hello
"1 world"
```


### setrange 

```
127.0.0.1:6379> get hello
"1 world"
127.0.0.1:6379> setrange hello 3 aaa
(integer) 7
127.0.0.1:6379> get hello
"1 waaad"
```

## 3.2 列表

TODO:

## 3.7 其他命令

### 3.7.1 排序

### 3.7.2 基本的 redis 事务

### 3.7.3 键的过期时间

# 第四章 数据安全与性能保障

主要内容:

1. 数据持久化
2. 将数据复制到其他机器
3. 处理系统故障
4. redis 事务
5. 非事务型流水线
6. 诊断性能问题

## 4.1 持久化选项

1. 快照 snotshotting 

	它可以将存在某一个时刻的所有数据都写入硬盘
	
	当数据大时,可能会带来大量数据的丢失.

2. 追加文件 append-only file (AOF)

	在执行写命令时,将执行命令复制到硬盘里面.
	
	AOF 持久化可以将丢失数据的时间窗口降低至1秒,但当 redis 不断将命令写入 AOF 文件时,文件体积不断增大.redis 重启执行还原操作的时间可能会非常长.
	
	
## TODO

## 4.6 性能

#### 性能测试
 
```
redis-benchmark -c l -q
```

2核4G

```
PING_INLINE: 21901.01 requests per second
PING_BULK: 21272.07 requests per second
SET: 20136.93 requests per second
GET: 22366.36 requests per second
INCR: 21244.96 requests per second
LPUSH: 21331.06 requests per second
RPUSH: 21312.87 requests per second
LPOP: 20924.88 requests per second
RPOP: 21649.71 requests per second
SADD: 22537.75 requests per second
HSET: 20251.11 requests per second
SPOP: 21372.09 requests per second
LPUSH (needed to benchmark LRANGE): 21710.81 requests per second
LRANGE_100 (first 100 elements): 15696.12 requests per second
LRANGE_300 (first 300 elements): 9242.14 requests per second
LRANGE_500 (first 450 elements): 7174.12 requests per second
LRANGE_600 (first 600 elements): 5779.34 requests per second
MSET (10 keys): 20521.24 requests per second
```




















