# Redis

## 参考

1. Redis 实战

2. https://redis.io/commands



##  简介

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

## Command 

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


