# Zookeeper && Docker 

在 docker 上运行 zookeeper

## 主要步骤

###  docker pull zookeeper


### docker run --name zookeeper_local -d zookeeper

###  docker logs -f zookeeper_local

```
[root@iZbp193yy46icaga1srlt6Z ~]# docker logs -f zookeeper_local
ZooKeeper JMX enabled by default
Using config: /conf/zoo.cfg
2018-03-16 15:38:58,474 [myid:] - INFO  [main:QuorumPeerConfig@136] - Reading configuration from: /conf/zoo.cfg
2018-03-16 15:38:58,479 [myid:] - INFO  [main:DatadirCleanupManager@78] - autopurge.snapRetainCount set to 3
2018-03-16 15:38:58,479 [myid:] - INFO  [main:DatadirCleanupManager@79] - autopurge.purgeInterval set to 0
2018-03-16 15:38:58,479 [myid:] - INFO  [main:DatadirCleanupManager@101] - Purge task is not scheduled.
2018-03-16 15:38:58,479 [myid:] - WARN  [main:QuorumPeerMain@116] - Either no config or no quorum defined in config, running  in standalone mode
2018-03-16 15:38:58,491 [myid:] - INFO  [main:QuorumPeerConfig@136] - Reading configuration from: /conf/zoo.cfg
2018-03-16 15:38:58,491 [myid:] - INFO  [main:ZooKeeperServerMain@98] - Starting server
2018-03-16 15:38:58,498 [myid:] - INFO  [main:Environment@100] - Server environment:zookeeper.version=3.4.11-37e277162d567b55a07d1755f0b31c32e93c01a0, built on 11/01/2017 18:06 GMT
2018-03-16 15:38:58,498 [myid:] - INFO  [main:Environment@100] - Server environment:host.name=7f52c209f499
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.version=1.8.0_151
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.vendor=Oracle Corporation
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.home=/usr/lib/jvm/java-1.8-openjdk/jre
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.class.path=/zookeeper-3.4.11/bin/../build/classes:/zookeeper-3.4.11/bin/../build/lib/*.jar:/zookeeper-3.4.11/bin/../lib/slf4j-log4j12-1.6.1.jar:/zookeeper-3.4.11/bin/../lib/slf4j-api-1.6.1.jar:/zookeeper-3.4.11/bin/../lib/netty-3.10.5.Final.jar:/zookeeper-3.4.11/bin/../lib/log4j-1.2.16.jar:/zookeeper-3.4.11/bin/../lib/jline-0.9.94.jar:/zookeeper-3.4.11/bin/../lib/audience-annotations-0.5.0.jar:/zookeeper-3.4.11/bin/../zookeeper-3.4.11.jar:/zookeeper-3.4.11/bin/../src/java/lib/*.jar:/conf:
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.library.path=/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/server:/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64:/usr/lib/jvm/java-1.8-openjdk/jre/../lib/amd64:/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.io.tmpdir=/tmp
2018-03-16 15:38:58,499 [myid:] - INFO  [main:Environment@100] - Server environment:java.compiler=<NA>
2018-03-16 15:38:58,501 [myid:] - INFO  [main:Environment@100] - Server environment:os.name=Linux
2018-03-16 15:38:58,501 [myid:] - INFO  [main:Environment@100] - Server environment:os.arch=amd64
2018-03-16 15:38:58,501 [myid:] - INFO  [main:Environment@100] - Server environment:os.version=3.10.0-693.2.2.el7.x86_64
2018-03-16 15:38:58,502 [myid:] - INFO  [main:Environment@100] - Server environment:user.name=zookeeper
2018-03-16 15:38:58,502 [myid:] - INFO  [main:Environment@100] - Server environment:user.home=/home/zookeeper
2018-03-16 15:38:58,502 [myid:] - INFO  [main:Environment@100] - Server environment:user.dir=/zookeeper-3.4.11
2018-03-16 15:38:58,509 [myid:] - INFO  [main:ZooKeeperServer@825] - tickTime set to 2000
2018-03-16 15:38:58,509 [myid:] - INFO  [main:ZooKeeperServer@834] - minSessionTimeout set to -1
2018-03-16 15:38:58,509 [myid:] - INFO  [main:ZooKeeperServer@843] - maxSessionTimeout set to -1
2018-03-16 15:38:58,519 [myid:] - INFO  [main:ServerCnxnFactory@117] - Using org.apache.zookeeper.server.NIOServerCnxnFactory as server connection factory
2018-03-16 15:38:58,524 [myid:] - INFO  [main:NIOServerCnxnFactory@89] - binding to port 0.0.0.0/0.0.0.0:2181

```

###  使用 zk 命令行客户端连接 zk


	1. 启动一个 zookeeper 镜像, 并运行这个镜像内的 zkCli.sh 命令, 命令参数是 "-server zookeeper"
	
	2. 将我们先前启动的名为 zookeeper_local 的容器连接(link) 到我们新建的这个容器上, 并将其主机名命名为 zookeeper

docker run -it --rm --link zookeeper_local:zookeeper zookeeper zkCli.sh -server zookeeper

```
[root@iZbp193yy46icaga1srlt6Z ~]# docker run -it --rm --link zookeeper_local:zookeeper zookeeper zkCli.sh -server zookeeper
Connecting to zookeeper
2018-03-16 15:51:39,355 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.11-37e277162d567b55a07d1755f0b31c32e93c01a0, built on 11/01/2017 18:06 GMT
2018-03-16 15:51:39,358 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=b3ed9035f3f5
2018-03-16 15:51:39,358 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.8.0_151
2018-03-16 15:51:39,361 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Oracle Corporation
2018-03-16 15:51:39,361 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/usr/lib/jvm/java-1.8-openjdk/jre
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/zookeeper-3.4.11/bin/../build/classes:/zookeeper-3.4.11/bin/../build/lib/*.jar:/zookeeper-3.4.11/bin/../lib/slf4j-log4j12-1.6.1.jar:/zookeeper-3.4.11/bin/../lib/slf4j-api-1.6.1.jar:/zookeeper-3.4.11/bin/../lib/netty-3.10.5.Final.jar:/zookeeper-3.4.11/bin/../lib/log4j-1.2.16.jar:/zookeeper-3.4.11/bin/../lib/jline-0.9.94.jar:/zookeeper-3.4.11/bin/../lib/audience-annotations-0.5.0.jar:/zookeeper-3.4.11/bin/../zookeeper-3.4.11.jar:/zookeeper-3.4.11/bin/../src/java/lib/*.jar:/conf:
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/server:/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64:/usr/lib/jvm/java-1.8-openjdk/jre/../lib/amd64:/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/tmp
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Linux
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=amd64
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=3.10.0-693.2.2.el7.x86_64
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=root
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/root
2018-03-16 15:51:39,362 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/zookeeper-3.4.11
2018-03-16 15:51:39,364 [myid:] - INFO  [main:ZooKeeper@441] - Initiating client connection, connectString=zookeeper sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@3eb07fd3
Welcome to ZooKeeper!
2018-03-16 15:51:39,388 [myid:] - INFO  [main-SendThread(zookeeper:2181):ClientCnxn$SendThread@1035] - Opening socket connection to server zookeeper/172.17.0.3:2181. Will not attempt to authenticate using SASL (unknown error)
JLine support is enabled
2018-03-16 15:51:39,469 [myid:] - INFO  [main-SendThread(zookeeper:2181):ClientCnxn$SendThread@877] - Socket connection established to zookeeper/172.17.0.3:2181, initiating session
[zk: zookeeper(CONNECTING) 0] 2018-03-16 15:51:39,506 [myid:] - INFO  [main-SendThread(zookeeper:2181):ClientCnxn$SendThread@1302] - Session establishment complete on server zookeeper/172.17.0.3:2181, sessionid = 0x100554d0c0a0000, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null

```



原始 zookeeper 中的日志

```
2018-03-16 15:51:39,472 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:NIOServerCnxnFactory@215] - Accepted socket connection from /172.17.0.4:58208
2018-03-16 15:51:39,488 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@938] - Client attempting to establish new session at /172.17.0.4:58208
2018-03-16 15:51:39,491 [myid:] - INFO  [SyncThread:0:FileTxnLog@209] - Creating new log file: log.1
2018-03-16 15:51:39,504 [myid:] - INFO  [SyncThread:0:ZooKeeperServer@683] - Established session 0x100554d0c0a0000 with negotiated timeout 30000 for client /172.17.0.4:58208

```

使用:

```docker exec -it 容器id zkCli.sh```打开 zookeeper 客户端

日志:

```
[root@iZbp193yy46icaga1srlt6Z ~]# docker exec -it zookeeper_local zkCli.sh
Connecting to localhost:2181
2018-03-16 16:08:31,347 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.11-37e277162d567b55a07d1755f0b31c32e93c01a0, built on 11/01/2017 18:06 GMT
2018-03-16 16:08:31,351 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=7f52c209f499
2018-03-16 16:08:31,351 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.8.0_151
2018-03-16 16:08:31,353 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Oracle Corporation
2018-03-16 16:08:31,353 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/usr/lib/jvm/java-1.8-openjdk/jre
2018-03-16 16:08:31,353 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/zookeeper-3.4.11/bin/../build/classes:/zookeeper-3.4.11/bin/../build/lib/*.jar:/zookeeper-3.4.11/bin/../lib/slf4j-log4j12-1.6.1.jar:/zookeeper-3.4.11/bin/../lib/slf4j-api-1.6.1.jar:/zookeeper-3.4.11/bin/../lib/netty-3.10.5.Final.jar:/zookeeper-3.4.11/bin/../lib/log4j-1.2.16.jar:/zookeeper-3.4.11/bin/../lib/jline-0.9.94.jar:/zookeeper-3.4.11/bin/../lib/audience-annotations-0.5.0.jar:/zookeeper-3.4.11/bin/../zookeeper-3.4.11.jar:/zookeeper-3.4.11/bin/../src/java/lib/*.jar:/conf:
2018-03-16 16:08:31,353 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/server:/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64:/usr/lib/jvm/java-1.8-openjdk/jre/../lib/amd64:/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/tmp
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Linux
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=amd64
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=3.10.0-693.2.2.el7.x86_64
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=root
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/root
2018-03-16 16:08:31,354 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/zookeeper-3.4.11
2018-03-16 16:08:31,355 [myid:] - INFO  [main:ZooKeeper@441] - Initiating client connection, connectString=localhost:2181 sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@3eb07fd3
Welcome to ZooKeeper!
2018-03-16 16:08:31,377 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1035] - Opening socket connection to server localhost/127.0.0.1:2181. Will not attempt to authenticate using SASL (unknown error)
JLine support is enabled
2018-03-16 16:08:31,453 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@877] - Socket connection established to localhost/127.0.0.1:2181, initiating session
2018-03-16 16:08:31,465 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1302] - Session establishment complete on server localhost/127.0.0.1:2181, sessionid = 0x100554d0c0a0001, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null
[zk: localhost:2181(CONNECTED) 0] 
```



