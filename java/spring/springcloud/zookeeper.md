# Zookeeper

[参考](https://www.cnblogs.com/wuxl360/p/5817471.html)
[官方文档](http://zookeeper.apache.org/doc/trunk/)

ZooKeeper是一种为分布式应用所设计的高可用、高性能且一致的开源协调服务，它提供了一项基本服务：分布式锁服务。由于ZooKeeper的开源特性，后来我们的开发者在分布式锁的基础上，摸索了出了其他的使用方法：配置维护、组服务、分布式消息队列、分布式通知/协调等。

## design goal

1. 高性能: 使它可以在大型的分布式系统使用
2. 可靠性: 使它免受单点失败的干扰
3. 严格的顺序访问: 使得复杂的同步原语可以在客户端上实现

## 数据模型和分级的命名空间  Nodes and ephemeral nodes

## Znode

the data stored at each node is usually small
(in the byte to kilobyte range.)

1. version number for data changes  每次数据更新时都会增加
2. ACL changes (Access Control List)
3. timestamps

每个Znode节点的读写都是原子性的(读取所有数据/写入替换所有数据)

### ephemeral nodes

只要创建znode的会话处于活动状态，就会存在这些znode。

当会话终止时,ephemeral nodes 会被删除

## conditional updates and watches

用户可以监视一个Znode

当Znode 改变时,监视会被触发并移除(?),用户会收到一个Znode改变的消息包

当客户和zookeeper服务器的连接错误时,客户会得到一个本地的通知(tbd)

## guarantees

1. 顺序的一致性,客户端的更新将按照发送的顺序进行应用。
2. 原子性
3. single system image ,无论客户端连接到那个服务器,都会看到相同的服务视图
4. reliability 可靠性,一旦更新已经被应用，它将一直持续下去，直到客户端覆盖更新。
5. timeliness 时效性, 客户端的视图在一定时间范围内保证是最新的

## simple Api

- create
- delete
- exists
- get data
- set data
- get children
- sync : waits for data to be propagated 等待数据传输

## implementation

为了可恢复,更新会被记录到磁盘,并在写入内存数据库之前,将其序列化到磁盘

根据协议规定,所有的写请求都会转发到一个服务器(leader),剩下的zookeeper服务器被称为followers,它们接受来自leader的消息建议,并同意消息传输










