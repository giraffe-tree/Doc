# Redis

Remote Dictionary Server(远程数据服务)

## 比较

redis和memcache比较

1. Redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
2. Redis支持master-slave(主-从)模式应用
3. Redis支持数据持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用。
4. Redis单个value的最大限制是1GB，memcached只能保存1MB的数据。

## 基本数据结构


结构类型|结构存储的值|结构的读写能力
----|------|----
STRING|可以是字符串、整数或者浮点数|对整个字符串或者字符串的其中一部分执行操作；对整数和浮点数执行自增（increment）或者自减（decrement）操作
LIST|一个链表，链表上的每个节点都包含了一个字符串|从链表的两端推入或者弹出元素；根据偏移量对链表进行修剪（trim）；读取单个或者多个元素；根据值查找或者移除元素
SET|包含字符串的无序收集器（unordered collection），并且被包含的每个字符串都是独一无二、各不相同的|添加、获取、移除单个元素；检查一个元素是否存在于集合中；计算交集、并集、差集；从集合里面随机获取元素
HASH|包含键值对的无序散列表|添加、获取、移除单个键值对；获取所有键值对
ZSET|字符串成员（member）与浮点数分值（score）之间的有序映射，元素的排列顺序由分值的大小决定|添加、获取、删除单个元素；根据分值范围（range）或者成员来获取元素

### string

最基本的数据类型,可以包含任何数据,图片,一个键最大能存储512MB

#### GET SET

使用 Redis 的 SET 和 GET 命令,进行添加,获取

### Hash

hash 是一个键值对集合,每个hash可以存储 **2的32次方减1** 个键值对

#### HMSET HGET HGETALL

```
HMSET myhash field1 "Hello" field2 "World"
HGETALL myhash
HGET myhash field1
HGET myhash field2
```

### List

列表,最多可以存储 **2的32次方减1** 个元素

#### list 命令

1. 添加 lpush/rpush list element
2. 查看长度 llen list
3. 查看元素 lrange start end
4. 删除元素  lpop/rpop list 并返回

### set

集合内元素唯一

1. 添加 sadd set member 添加成功则返回1
2. 查看元素 smembers set

### zset

1. zset 指有序集合(sorted set)
2. 每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
3. zset的成员是唯一的,但分数(score)却可以重复。

#### zset 命令

1. 添加 zadd zset score member
2. 查看  zrangebyscore zset 0 1000

## Redis 命令

### help 命令

```
help @list
help @set

```


### 远程服务

```
redis-cli -h 127.0.0.1 -p 6379 -a password
```

### config 命令

CONFIG GET CONFIG_SETTING_NAME

```
CONFIG GET *
```

### key 命令

```
exists name
```

## 参考

#### spring data redis quick start

http://projects.spring.io/spring-data-redis/#quick-start

#### 异步社区 redis in action

http://www.epubit.com.cn/book/onlinechapter/33966

#### spring boot + redis

https://www.cnblogs.com/ityouknow/p/5748830.html












