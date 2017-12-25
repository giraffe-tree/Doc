# Redis

Remote Dictionary Server(远程数据服务)

## 参考

#### spring data redis quick start

http://projects.spring.io/spring-data-redis/#quick-start

#### 异步社区 redis in action

http://www.epubit.com.cn/book/onlinechapter/33966

#### spring boot + redis

https://www.cnblogs.com/ityouknow/p/5748830.html

####  homebrew 安装 redis

http://blog.csdn.net/chenshuai1993/article/details/51519384

#### redis 教程

https://www.cnblogs.com/joeblackzqq/p/6229387.html

## 比较

redis和memcache比较

1. Redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
2. Redis支持master-slave(主-从)模式应用
3. Redis支持数据持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用。
4. Redis单个value的最大限制是1GB，memcached只能保存1MB的数据。

## 命令

```
redis-server 启动
redis-cli
redis-cli -h 127.0.0.1 -p 6379 -a "mypass"
PING
```

## 基本数据结构


结构类型|结构存储的值|结构的读写能力
----|------|----
STRING|可以是字符串、整数或者浮点数|对整个字符串或者字符串的其中一部分执行操作；对整数和浮点数执行自增（increment）或者自减（decrement）操作
LIST|一个链表，链表上的每个节点都包含了一个字符串|从链表的两端推入或者弹出元素；根据偏移量对链表进行修剪（trim）；读取单个或者多个元素；根据值查找或者移除元素
SET|包含字符串的无序收集器（unordered collection），并且被包含的每个字符串都是独一无二、各不相同的|添加、获取、移除单个元素；检查一个元素是否存在于集合中；计算交集、并集、差集；从集合里面随机获取元素
HASH|包含键值对的无序散列表|添加、获取、移除单个键值对；获取所有键值对
ZSET|字符串成员（member）与浮点数分值（score）之间的有序映射，元素的排列顺序由分值的大小决定|添加、获取、删除单个元素；根据分值范围（range）或者成员来获取元素





