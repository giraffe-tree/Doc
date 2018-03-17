# Zookeeper && Docker 

在 docker 上运行 zookeeper

## 参考

https://github.com/31z4/zookeeper-docker



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

## 配置

$ docker run --name zookeeper1.0 --restart always -d -v $(pwd)/zoo.cfg:/conf/zoo.cfg zookeeper


## docker and kafka

参考: 

[基于docker部署的微服务架构（五）： docker环境下的zookeeper和kafka部署](https://www.jianshu.com/p/263164fdcac7)

zookeeper

```
docker run -d --name zookeeper --publish 2181:2181 \
--volume /etc/localtime:/etc/localtime \
zookeeper:latest
```

kafka

```
docker run -d --name kafka --publish 9092:9092 \
--link zookeeper \
--env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
--env KAFKA_ADVERTISED_HOST_NAME=47.97.199.139 \
--env KAFKA_ADVERTISED_PORT=9092 \
--volume /etc/localtime:/etc/localtime \
wurstmeister/kafka:latest
```

logs:

```
[root@iZbp193yy46icaga1srlt6Z 1.0]# docker logs kafka
[2018-03-17 15:14:32,899] INFO KafkaConfig values: 
	advertised.host.name = null
	advertised.listeners = PLAINTEXT://47.97.199.139:9092
	advertised.port = null
	alter.config.policy.class.name = null
	authorizer.class.name = 
	auto.create.topics.enable = true
	auto.leader.rebalance.enable = true
	background.threads = 10
	broker.id = -1
	broker.id.generation.enable = true
	broker.rack = null
	compression.type = producer
	connections.max.idle.ms = 600000
	controlled.shutdown.enable = true
	controlled.shutdown.max.retries = 3
	controlled.shutdown.retry.backoff.ms = 5000
	controller.socket.timeout.ms = 30000
	create.topic.policy.class.name = null
	default.replication.factor = 1
	delete.records.purgatory.purge.interval.requests = 1
	delete.topic.enable = true
	fetch.purgatory.purge.interval.requests = 1000
	group.initial.rebalance.delay.ms = 0
	group.max.session.timeout.ms = 300000
	group.min.session.timeout.ms = 6000
	host.name = 
	inter.broker.listener.name = null
	inter.broker.protocol.version = 1.0-IV0
	leader.imbalance.check.interval.seconds = 300
	leader.imbalance.per.broker.percentage = 10
	listener.security.protocol.map = PLAINTEXT:PLAINTEXT,SSL:SSL,SASL_PLAINTEXT:SASL_PLAINTEXT,SASL_SSL:SASL_SSL
	listeners = PLAINTEXT://:9092
	log.cleaner.backoff.ms = 15000
	log.cleaner.dedupe.buffer.size = 134217728
	log.cleaner.delete.retention.ms = 86400000
	log.cleaner.enable = true
	log.cleaner.io.buffer.load.factor = 0.9
	log.cleaner.io.buffer.size = 524288
	log.cleaner.io.max.bytes.per.second = 1.7976931348623157E308
	log.cleaner.min.cleanable.ratio = 0.5
	log.cleaner.min.compaction.lag.ms = 0
	log.cleaner.threads = 1
	log.cleanup.policy = [delete]
	log.dir = /tmp/kafka-logs
	log.dirs = /kafka/kafka-logs-5664a8b9deaa
	log.flush.interval.messages = 9223372036854775807
	log.flush.interval.ms = null
	log.flush.offset.checkpoint.interval.ms = 60000
	log.flush.scheduler.interval.ms = 9223372036854775807
	log.flush.start.offset.checkpoint.interval.ms = 60000
	log.index.interval.bytes = 4096
	log.index.size.max.bytes = 10485760
	log.message.format.version = 1.0-IV0
	log.message.timestamp.difference.max.ms = 9223372036854775807
	log.message.timestamp.type = CreateTime
	log.preallocate = false
	log.retention.bytes = -1
	log.retention.check.interval.ms = 300000
	log.retention.hours = 168
	log.retention.minutes = null
	log.retention.ms = null
	log.roll.hours = 168
	log.roll.jitter.hours = 0
	log.roll.jitter.ms = null
	log.roll.ms = null
	log.segment.bytes = 1073741824
	log.segment.delete.delay.ms = 60000
	max.connections.per.ip = 2147483647
	max.connections.per.ip.overrides = 
	message.max.bytes = 1000012
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	min.insync.replicas = 1
	num.io.threads = 8
	num.network.threads = 3
	num.partitions = 1
	num.recovery.threads.per.data.dir = 1
	num.replica.fetchers = 1
	offset.metadata.max.bytes = 4096
	offsets.commit.required.acks = -1
	offsets.commit.timeout.ms = 5000
	offsets.load.buffer.size = 5242880
	offsets.retention.check.interval.ms = 600000
	offsets.retention.minutes = 1440
	offsets.topic.compression.codec = 0
	offsets.topic.num.partitions = 50
	offsets.topic.replication.factor = 1
	offsets.topic.segment.bytes = 104857600
	port = 9092
	principal.builder.class = null
	producer.purgatory.purge.interval.requests = 1000
	queued.max.request.bytes = -1
	queued.max.requests = 500
	quota.consumer.default = 9223372036854775807
	quota.producer.default = 9223372036854775807
	quota.window.num = 11
	quota.window.size.seconds = 1
	replica.fetch.backoff.ms = 1000
	replica.fetch.max.bytes = 1048576
	replica.fetch.min.bytes = 1
	replica.fetch.response.max.bytes = 10485760
	replica.fetch.wait.max.ms = 500
	replica.high.watermark.checkpoint.interval.ms = 5000
	replica.lag.time.max.ms = 10000
	replica.socket.receive.buffer.bytes = 65536
	replica.socket.timeout.ms = 30000
	replication.quota.window.num = 11
	replication.quota.window.size.seconds = 1
	request.timeout.ms = 30000
	reserved.broker.max.id = 1000
	sasl.enabled.mechanisms = [GSSAPI]
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.principal.to.local.rules = [DEFAULT]
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.mechanism.inter.broker.protocol = GSSAPI
	security.inter.broker.protocol = PLAINTEXT
	socket.receive.buffer.bytes = 102400
	socket.request.max.bytes = 104857600
	socket.send.buffer.bytes = 102400
	ssl.cipher.suites = null
	ssl.client.auth = none
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.abort.timed.out.transaction.cleanup.interval.ms = 60000
	transaction.max.timeout.ms = 900000
	transaction.remove.expired.transaction.cleanup.interval.ms = 3600000
	transaction.state.log.load.buffer.size = 5242880
	transaction.state.log.min.isr = 1
	transaction.state.log.num.partitions = 50
	transaction.state.log.replication.factor = 1
	transaction.state.log.segment.bytes = 104857600
	transactional.id.expiration.ms = 604800000
	unclean.leader.election.enable = false
	zookeeper.connect = zookeeper:2181
	zookeeper.connection.timeout.ms = 6000
	zookeeper.session.timeout.ms = 6000
	zookeeper.set.acl = false
	zookeeper.sync.time.ms = 2000
 (kafka.server.KafkaConfig)
[2018-03-17 15:14:32,980] INFO starting (kafka.server.KafkaServer)
[2018-03-17 15:14:32,982] INFO Connecting to zookeeper on zookeeper:2181 (kafka.server.KafkaServer)
[2018-03-17 15:14:32,997] INFO Starting ZkClient event thread. (org.I0Itec.zkclient.ZkEventThread)
[2018-03-17 15:14:33,005] INFO Client environment:zookeeper.version=3.4.10-39d3a4f269333c922ed3db283be479f9deacaa0f, built on 03/23/2017 10:13 GMT (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,005] INFO Client environment:host.name=5664a8b9deaa (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.version=1.8.0_162 (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.vendor=Oracle Corporation (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.home=/opt/jdk1.8.0_162/jre (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.class.path=:/opt/kafka/bin/../libs/aopalliance-repackaged-2.5.0-b32.jar:/opt/kafka/bin/../libs/argparse4j-0.7.0.jar:/opt/kafka/bin/../libs/commons-lang3-3.5.jar:/opt/kafka/bin/../libs/connect-api-1.0.1.jar:/opt/kafka/bin/../libs/connect-file-1.0.1.jar:/opt/kafka/bin/../libs/connect-json-1.0.1.jar:/opt/kafka/bin/../libs/connect-runtime-1.0.1.jar:/opt/kafka/bin/../libs/connect-transforms-1.0.1.jar:/opt/kafka/bin/../libs/guava-20.0.jar:/opt/kafka/bin/../libs/hk2-api-2.5.0-b32.jar:/opt/kafka/bin/../libs/hk2-locator-2.5.0-b32.jar:/opt/kafka/bin/../libs/hk2-utils-2.5.0-b32.jar:/opt/kafka/bin/../libs/jackson-annotations-2.9.1.jar:/opt/kafka/bin/../libs/jackson-core-2.9.1.jar:/opt/kafka/bin/../libs/jackson-databind-2.9.1.jar:/opt/kafka/bin/../libs/jackson-jaxrs-base-2.9.1.jar:/opt/kafka/bin/../libs/jackson-jaxrs-json-provider-2.9.1.jar:/opt/kafka/bin/../libs/jackson-module-jaxb-annotations-2.9.1.jar:/opt/kafka/bin/../libs/javassist-3.20.0-GA.jar:/opt/kafka/bin/../libs/javassist-3.21.0-GA.jar:/opt/kafka/bin/../libs/javax.annotation-api-1.2.jar:/opt/kafka/bin/../libs/javax.inject-1.jar:/opt/kafka/bin/../libs/javax.inject-2.5.0-b32.jar:/opt/kafka/bin/../libs/javax.servlet-api-3.1.0.jar:/opt/kafka/bin/../libs/javax.ws.rs-api-2.0.1.jar:/opt/kafka/bin/../libs/jersey-client-2.25.1.jar:/opt/kafka/bin/../libs/jersey-common-2.25.1.jar:/opt/kafka/bin/../libs/jersey-container-servlet-2.25.1.jar:/opt/kafka/bin/../libs/jersey-container-servlet-core-2.25.1.jar:/opt/kafka/bin/../libs/jersey-guava-2.25.1.jar:/opt/kafka/bin/../libs/jersey-media-jaxb-2.25.1.jar:/opt/kafka/bin/../libs/jersey-server-2.25.1.jar:/opt/kafka/bin/../libs/jetty-continuation-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-http-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-io-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-security-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-server-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-servlet-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-servlets-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-util-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jopt-simple-5.0.4.jar:/opt/kafka/bin/../libs/kafka-clients-1.0.1.jar:/opt/kafka/bin/../libs/kafka-log4j-appender-1.0.1.jar:/opt/kafka/bin/../libs/kafka-streams-1.0.1.jar:/opt/kafka/bin/../libs/kafka-streams-examples-1.0.1.jar:/opt/kafka/bin/../libs/kafka-tools-1.0.1.jar:/opt/kafka/bin/../libs/kafka_2.12-1.0.1-sources.jar:/opt/kafka/bin/../libs/kafka_2.12-1.0.1-test-sources.jar:/opt/kafka/bin/../libs/kafka_2.12-1.0.1.jar:/opt/kafka/bin/../libs/log4j-1.2.17.jar:/opt/kafka/bin/../libs/lz4-java-1.4.jar:/opt/kafka/bin/../libs/maven-artifact-3.5.0.jar:/opt/kafka/bin/../libs/metrics-core-2.2.0.jar:/opt/kafka/bin/../libs/osgi-resource-locator-1.0.1.jar:/opt/kafka/bin/../libs/plexus-utils-3.0.24.jar:/opt/kafka/bin/../libs/reflections-0.9.11.jar:/opt/kafka/bin/../libs/rocksdbjni-5.7.3.jar:/opt/kafka/bin/../libs/scala-library-2.12.4.jar:/opt/kafka/bin/../libs/slf4j-api-1.7.25.jar:/opt/kafka/bin/../libs/slf4j-log4j12-1.7.25.jar:/opt/kafka/bin/../libs/snappy-java-1.1.4.jar:/opt/kafka/bin/../libs/validation-api-1.1.0.Final.jar:/opt/kafka/bin/../libs/zkclient-0.10.jar:/opt/kafka/bin/../libs/zookeeper-3.4.10.jar (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.io.tmpdir=/tmp (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.compiler=<NA> (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:os.name=Linux (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:os.arch=amd64 (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:os.version=3.10.0-693.2.2.el7.x86_64 (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:user.name=root (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:user.home=/root (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:user.dir=/ (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,007] INFO Initiating client connection, connectString=zookeeper:2181 sessionTimeout=6000 watcher=org.I0Itec.zkclient.ZkClient@1534f01b (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,019] INFO Waiting for keeper state SyncConnected (org.I0Itec.zkclient.ZkClient)
[2018-03-17 15:14:33,021] INFO Opening socket connection to server zookeeper/172.17.0.3:2181. Will not attempt to authenticate using SASL (unknown error) (org.apache.zookeeper.ClientCnxn)
[2018-03-17 15:14:33,025] INFO Socket connection established to zookeeper/172.17.0.3:2181, initiating session (org.apache.zookeeper.ClientCnxn)
[2018-03-17 15:14:33,052] INFO Session establishment complete on server zookeeper/172.17.0.3:2181, sessionid = 0x1005a5835910000, negotiated timeout = 6000 (org.apache.zookeeper.ClientCnxn)
[2018-03-17 15:14:33,054] INFO zookeeper state changed (SyncConnected) (org.I0Itec.zkclient.ZkClient)
[2018-03-17 15:14:33,319] INFO Cluster ID = UrLJwUl-Q929kzGXc6KZhg (kafka.server.KafkaServer)
[2018-03-17 15:14:33,327] WARN No meta.properties file under dir /kafka/kafka-logs-5664a8b9deaa/meta.properties (kafka.server.BrokerMetadataCheckpoint)
[2018-03-17 15:14:33,364] INFO [ThrottledRequestReaper-Fetch]: Starting (kafka.server.ClientQuotaManager$ThrottledRequestReaper)
[2018-03-17 15:14:33,365] INFO [ThrottledRequestReaper-Produce]: Starting (kafka.server.ClientQuotaManager$ThrottledRequestReaper)
[2018-03-17 15:14:33,366] INFO [ThrottledRequestReaper-Request]: Starting (kafka.server.ClientQuotaManager$ThrottledRequestReaper)
[2018-03-17 15:14:33,403] INFO Log directory '/kafka/kafka-logs-5664a8b9deaa' not found, creating it. (kafka.log.LogManager)
[2018-03-17 15:14:33,423] INFO Loading logs. (kafka.log.LogManager)
[2018-03-17 15:14:33,440] INFO Logs loading complete in 16 ms. (kafka.log.LogManager)
[2018-03-17 15:14:33,553] INFO Starting log cleanup with a period of 300000 ms. (kafka.log.LogManager)
[2018-03-17 15:14:33,558] INFO Starting log flusher with a default period of 9223372036854775807 ms. (kafka.log.LogManager)
[2018-03-17 15:14:33,916] INFO Awaiting socket connections on 0.0.0.0:9092. (kafka.network.Acceptor)
[2018-03-17 15:14:33,924] INFO [SocketServer brokerId=1001] Started 1 acceptor threads (kafka.network.SocketServer)
[2018-03-17 15:14:33,949] INFO [ExpirationReaper-1001-Produce]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:33,951] INFO [ExpirationReaper-1001-Fetch]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:33,953] INFO [ExpirationReaper-1001-DeleteRecords]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:33,975] INFO [LogDirFailureHandler]: Starting (kafka.server.ReplicaManager$LogDirFailureHandler)
[2018-03-17 15:14:34,011] INFO [ExpirationReaper-1001-topic]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:34,015] INFO [ExpirationReaper-1001-Heartbeat]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:34,021] INFO Creating /controller (is it secure? false) (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,023] INFO [ExpirationReaper-1001-Rebalance]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:34,034] INFO Result of znode creation is: OK (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,036] INFO [GroupCoordinator 1001]: Starting up. (kafka.coordinator.group.GroupCoordinator)
[2018-03-17 15:14:34,037] INFO [GroupCoordinator 1001]: Startup complete. (kafka.coordinator.group.GroupCoordinator)
[2018-03-17 15:14:34,043] INFO [GroupMetadataManager brokerId=1001] Removed 0 expired offsets in 2 milliseconds. (kafka.coordinator.group.GroupMetadataManager)
[2018-03-17 15:14:34,059] INFO [ProducerId Manager 1001]: Acquired new producerId block (brokerId:1001,blockStartProducerId:0,blockEndProducerId:999) by writing to Zk with path version 1 (kafka.coordinator.transaction.ProducerIdManager)
[2018-03-17 15:14:34,091] INFO [TransactionCoordinator id=1001] Starting up. (kafka.coordinator.transaction.TransactionCoordinator)
[2018-03-17 15:14:34,095] INFO [TransactionCoordinator id=1001] Startup complete. (kafka.coordinator.transaction.TransactionCoordinator)
[2018-03-17 15:14:34,105] INFO [Transaction Marker Channel Manager 1001]: Starting (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2018-03-17 15:14:34,189] INFO Creating /brokers/ids/1001 (is it secure? false) (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,206] INFO Result of znode creation is: OK (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,207] INFO Registered broker 1001 at path /brokers/ids/1001 with addresses: EndPoint(47.97.199.139,9092,ListenerName(PLAINTEXT),PLAINTEXT) (kafka.utils.ZkUtils)
[2018-03-17 15:14:34,211] WARN No meta.properties file under dir /kafka/kafka-logs-5664a8b9deaa/meta.properties (kafka.server.BrokerMetadataCheckpoint)
[2018-03-17 15:14:34,240] INFO Kafka version : 1.0.1 (org.apache.kafka.common.utils.AppInfoParser)
[2018-03-17 15:14:34,240] INFO Kafka commitId : c0518aa65f25317e (org.apache.kafka.common.utils.AppInfoParser)
[2018-03-17 15:14:34,241] INFO [KafkaServer id=1001] started (kafka.server.KafkaServer)
[root@iZbp193yy46icaga1srlt6Z 1.0]# docker logs -f kafka
[2018-03-17 15:14:32,899] INFO KafkaConfig values: 
	advertised.host.name = null
	advertised.listeners = PLAINTEXT://47.97.199.139:9092
	advertised.port = null
	alter.config.policy.class.name = null
	authorizer.class.name = 
	auto.create.topics.enable = true
	auto.leader.rebalance.enable = true
	background.threads = 10
	broker.id = -1
	broker.id.generation.enable = true
	broker.rack = null
	compression.type = producer
	connections.max.idle.ms = 600000
	controlled.shutdown.enable = true
	controlled.shutdown.max.retries = 3
	controlled.shutdown.retry.backoff.ms = 5000
	controller.socket.timeout.ms = 30000
	create.topic.policy.class.name = null
	default.replication.factor = 1
	delete.records.purgatory.purge.interval.requests = 1
	delete.topic.enable = true
	fetch.purgatory.purge.interval.requests = 1000
	group.initial.rebalance.delay.ms = 0
	group.max.session.timeout.ms = 300000
	group.min.session.timeout.ms = 6000
	host.name = 
	inter.broker.listener.name = null
	inter.broker.protocol.version = 1.0-IV0
	leader.imbalance.check.interval.seconds = 300
	leader.imbalance.per.broker.percentage = 10
	listener.security.protocol.map = PLAINTEXT:PLAINTEXT,SSL:SSL,SASL_PLAINTEXT:SASL_PLAINTEXT,SASL_SSL:SASL_SSL
	listeners = PLAINTEXT://:9092
	log.cleaner.backoff.ms = 15000
	log.cleaner.dedupe.buffer.size = 134217728
	log.cleaner.delete.retention.ms = 86400000
	log.cleaner.enable = true
	log.cleaner.io.buffer.load.factor = 0.9
	log.cleaner.io.buffer.size = 524288
	log.cleaner.io.max.bytes.per.second = 1.7976931348623157E308
	log.cleaner.min.cleanable.ratio = 0.5
	log.cleaner.min.compaction.lag.ms = 0
	log.cleaner.threads = 1
	log.cleanup.policy = [delete]
	log.dir = /tmp/kafka-logs
	log.dirs = /kafka/kafka-logs-5664a8b9deaa
	log.flush.interval.messages = 9223372036854775807
	log.flush.interval.ms = null
	log.flush.offset.checkpoint.interval.ms = 60000
	log.flush.scheduler.interval.ms = 9223372036854775807
	log.flush.start.offset.checkpoint.interval.ms = 60000
	log.index.interval.bytes = 4096
	log.index.size.max.bytes = 10485760
	log.message.format.version = 1.0-IV0
	log.message.timestamp.difference.max.ms = 9223372036854775807
	log.message.timestamp.type = CreateTime
	log.preallocate = false
	log.retention.bytes = -1
	log.retention.check.interval.ms = 300000
	log.retention.hours = 168
	log.retention.minutes = null
	log.retention.ms = null
	log.roll.hours = 168
	log.roll.jitter.hours = 0
	log.roll.jitter.ms = null
	log.roll.ms = null
	log.segment.bytes = 1073741824
	log.segment.delete.delay.ms = 60000
	max.connections.per.ip = 2147483647
	max.connections.per.ip.overrides = 
	message.max.bytes = 1000012
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	min.insync.replicas = 1
	num.io.threads = 8
	num.network.threads = 3
	num.partitions = 1
	num.recovery.threads.per.data.dir = 1
	num.replica.fetchers = 1
	offset.metadata.max.bytes = 4096
	offsets.commit.required.acks = -1
	offsets.commit.timeout.ms = 5000
	offsets.load.buffer.size = 5242880
	offsets.retention.check.interval.ms = 600000
	offsets.retention.minutes = 1440
	offsets.topic.compression.codec = 0
	offsets.topic.num.partitions = 50
	offsets.topic.replication.factor = 1
	offsets.topic.segment.bytes = 104857600
	port = 9092
	principal.builder.class = null
	producer.purgatory.purge.interval.requests = 1000
	queued.max.request.bytes = -1
	queued.max.requests = 500
	quota.consumer.default = 9223372036854775807
	quota.producer.default = 9223372036854775807
	quota.window.num = 11
	quota.window.size.seconds = 1
	replica.fetch.backoff.ms = 1000
	replica.fetch.max.bytes = 1048576
	replica.fetch.min.bytes = 1
	replica.fetch.response.max.bytes = 10485760
	replica.fetch.wait.max.ms = 500
	replica.high.watermark.checkpoint.interval.ms = 5000
	replica.lag.time.max.ms = 10000
	replica.socket.receive.buffer.bytes = 65536
	replica.socket.timeout.ms = 30000
	replication.quota.window.num = 11
	replication.quota.window.size.seconds = 1
	request.timeout.ms = 30000
	reserved.broker.max.id = 1000
	sasl.enabled.mechanisms = [GSSAPI]
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.principal.to.local.rules = [DEFAULT]
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.mechanism.inter.broker.protocol = GSSAPI
	security.inter.broker.protocol = PLAINTEXT
	socket.receive.buffer.bytes = 102400
	socket.request.max.bytes = 104857600
	socket.send.buffer.bytes = 102400
	ssl.cipher.suites = null
	ssl.client.auth = none
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.abort.timed.out.transaction.cleanup.interval.ms = 60000
	transaction.max.timeout.ms = 900000
	transaction.remove.expired.transaction.cleanup.interval.ms = 3600000
	transaction.state.log.load.buffer.size = 5242880
	transaction.state.log.min.isr = 1
	transaction.state.log.num.partitions = 50
	transaction.state.log.replication.factor = 1
	transaction.state.log.segment.bytes = 104857600
	transactional.id.expiration.ms = 604800000
	unclean.leader.election.enable = false
	zookeeper.connect = zookeeper:2181
	zookeeper.connection.timeout.ms = 6000
	zookeeper.session.timeout.ms = 6000
	zookeeper.set.acl = false
	zookeeper.sync.time.ms = 2000
 (kafka.server.KafkaConfig)
[2018-03-17 15:14:32,980] INFO starting (kafka.server.KafkaServer)
[2018-03-17 15:14:32,982] INFO Connecting to zookeeper on zookeeper:2181 (kafka.server.KafkaServer)
[2018-03-17 15:14:32,997] INFO Starting ZkClient event thread. (org.I0Itec.zkclient.ZkEventThread)
[2018-03-17 15:14:33,005] INFO Client environment:zookeeper.version=3.4.10-39d3a4f269333c922ed3db283be479f9deacaa0f, built on 03/23/2017 10:13 GMT (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,005] INFO Client environment:host.name=5664a8b9deaa (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.version=1.8.0_162 (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.vendor=Oracle Corporation (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.home=/opt/jdk1.8.0_162/jre (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.class.path=:/opt/kafka/bin/../libs/aopalliance-repackaged-2.5.0-b32.jar:/opt/kafka/bin/../libs/argparse4j-0.7.0.jar:/opt/kafka/bin/../libs/commons-lang3-3.5.jar:/opt/kafka/bin/../libs/connect-api-1.0.1.jar:/opt/kafka/bin/../libs/connect-file-1.0.1.jar:/opt/kafka/bin/../libs/connect-json-1.0.1.jar:/opt/kafka/bin/../libs/connect-runtime-1.0.1.jar:/opt/kafka/bin/../libs/connect-transforms-1.0.1.jar:/opt/kafka/bin/../libs/guava-20.0.jar:/opt/kafka/bin/../libs/hk2-api-2.5.0-b32.jar:/opt/kafka/bin/../libs/hk2-locator-2.5.0-b32.jar:/opt/kafka/bin/../libs/hk2-utils-2.5.0-b32.jar:/opt/kafka/bin/../libs/jackson-annotations-2.9.1.jar:/opt/kafka/bin/../libs/jackson-core-2.9.1.jar:/opt/kafka/bin/../libs/jackson-databind-2.9.1.jar:/opt/kafka/bin/../libs/jackson-jaxrs-base-2.9.1.jar:/opt/kafka/bin/../libs/jackson-jaxrs-json-provider-2.9.1.jar:/opt/kafka/bin/../libs/jackson-module-jaxb-annotations-2.9.1.jar:/opt/kafka/bin/../libs/javassist-3.20.0-GA.jar:/opt/kafka/bin/../libs/javassist-3.21.0-GA.jar:/opt/kafka/bin/../libs/javax.annotation-api-1.2.jar:/opt/kafka/bin/../libs/javax.inject-1.jar:/opt/kafka/bin/../libs/javax.inject-2.5.0-b32.jar:/opt/kafka/bin/../libs/javax.servlet-api-3.1.0.jar:/opt/kafka/bin/../libs/javax.ws.rs-api-2.0.1.jar:/opt/kafka/bin/../libs/jersey-client-2.25.1.jar:/opt/kafka/bin/../libs/jersey-common-2.25.1.jar:/opt/kafka/bin/../libs/jersey-container-servlet-2.25.1.jar:/opt/kafka/bin/../libs/jersey-container-servlet-core-2.25.1.jar:/opt/kafka/bin/../libs/jersey-guava-2.25.1.jar:/opt/kafka/bin/../libs/jersey-media-jaxb-2.25.1.jar:/opt/kafka/bin/../libs/jersey-server-2.25.1.jar:/opt/kafka/bin/../libs/jetty-continuation-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-http-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-io-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-security-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-server-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-servlet-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-servlets-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jetty-util-9.2.22.v20170606.jar:/opt/kafka/bin/../libs/jopt-simple-5.0.4.jar:/opt/kafka/bin/../libs/kafka-clients-1.0.1.jar:/opt/kafka/bin/../libs/kafka-log4j-appender-1.0.1.jar:/opt/kafka/bin/../libs/kafka-streams-1.0.1.jar:/opt/kafka/bin/../libs/kafka-streams-examples-1.0.1.jar:/opt/kafka/bin/../libs/kafka-tools-1.0.1.jar:/opt/kafka/bin/../libs/kafka_2.12-1.0.1-sources.jar:/opt/kafka/bin/../libs/kafka_2.12-1.0.1-test-sources.jar:/opt/kafka/bin/../libs/kafka_2.12-1.0.1.jar:/opt/kafka/bin/../libs/log4j-1.2.17.jar:/opt/kafka/bin/../libs/lz4-java-1.4.jar:/opt/kafka/bin/../libs/maven-artifact-3.5.0.jar:/opt/kafka/bin/../libs/metrics-core-2.2.0.jar:/opt/kafka/bin/../libs/osgi-resource-locator-1.0.1.jar:/opt/kafka/bin/../libs/plexus-utils-3.0.24.jar:/opt/kafka/bin/../libs/reflections-0.9.11.jar:/opt/kafka/bin/../libs/rocksdbjni-5.7.3.jar:/opt/kafka/bin/../libs/scala-library-2.12.4.jar:/opt/kafka/bin/../libs/slf4j-api-1.7.25.jar:/opt/kafka/bin/../libs/slf4j-log4j12-1.7.25.jar:/opt/kafka/bin/../libs/snappy-java-1.1.4.jar:/opt/kafka/bin/../libs/validation-api-1.1.0.Final.jar:/opt/kafka/bin/../libs/zkclient-0.10.jar:/opt/kafka/bin/../libs/zookeeper-3.4.10.jar (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.io.tmpdir=/tmp (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:java.compiler=<NA> (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:os.name=Linux (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:os.arch=amd64 (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:os.version=3.10.0-693.2.2.el7.x86_64 (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:user.name=root (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:user.home=/root (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,006] INFO Client environment:user.dir=/ (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,007] INFO Initiating client connection, connectString=zookeeper:2181 sessionTimeout=6000 watcher=org.I0Itec.zkclient.ZkClient@1534f01b (org.apache.zookeeper.ZooKeeper)
[2018-03-17 15:14:33,019] INFO Waiting for keeper state SyncConnected (org.I0Itec.zkclient.ZkClient)
[2018-03-17 15:14:33,021] INFO Opening socket connection to server zookeeper/172.17.0.3:2181. Will not attempt to authenticate using SASL (unknown error) (org.apache.zookeeper.ClientCnxn)
[2018-03-17 15:14:33,025] INFO Socket connection established to zookeeper/172.17.0.3:2181, initiating session (org.apache.zookeeper.ClientCnxn)
[2018-03-17 15:14:33,052] INFO Session establishment complete on server zookeeper/172.17.0.3:2181, sessionid = 0x1005a5835910000, negotiated timeout = 6000 (org.apache.zookeeper.ClientCnxn)
[2018-03-17 15:14:33,054] INFO zookeeper state changed (SyncConnected) (org.I0Itec.zkclient.ZkClient)
[2018-03-17 15:14:33,319] INFO Cluster ID = UrLJwUl-Q929kzGXc6KZhg (kafka.server.KafkaServer)
[2018-03-17 15:14:33,327] WARN No meta.properties file under dir /kafka/kafka-logs-5664a8b9deaa/meta.properties (kafka.server.BrokerMetadataCheckpoint)
[2018-03-17 15:14:33,364] INFO [ThrottledRequestReaper-Fetch]: Starting (kafka.server.ClientQuotaManager$ThrottledRequestReaper)
[2018-03-17 15:14:33,365] INFO [ThrottledRequestReaper-Produce]: Starting (kafka.server.ClientQuotaManager$ThrottledRequestReaper)
[2018-03-17 15:14:33,366] INFO [ThrottledRequestReaper-Request]: Starting (kafka.server.ClientQuotaManager$ThrottledRequestReaper)
[2018-03-17 15:14:33,403] INFO Log directory '/kafka/kafka-logs-5664a8b9deaa' not found, creating it. (kafka.log.LogManager)
[2018-03-17 15:14:33,423] INFO Loading logs. (kafka.log.LogManager)
[2018-03-17 15:14:33,440] INFO Logs loading complete in 16 ms. (kafka.log.LogManager)
[2018-03-17 15:14:33,553] INFO Starting log cleanup with a period of 300000 ms. (kafka.log.LogManager)
[2018-03-17 15:14:33,558] INFO Starting log flusher with a default period of 9223372036854775807 ms. (kafka.log.LogManager)
[2018-03-17 15:14:33,916] INFO Awaiting socket connections on 0.0.0.0:9092. (kafka.network.Acceptor)
[2018-03-17 15:14:33,924] INFO [SocketServer brokerId=1001] Started 1 acceptor threads (kafka.network.SocketServer)
[2018-03-17 15:14:33,949] INFO [ExpirationReaper-1001-Produce]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:33,951] INFO [ExpirationReaper-1001-Fetch]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:33,953] INFO [ExpirationReaper-1001-DeleteRecords]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:33,975] INFO [LogDirFailureHandler]: Starting (kafka.server.ReplicaManager$LogDirFailureHandler)
[2018-03-17 15:14:34,011] INFO [ExpirationReaper-1001-topic]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:34,015] INFO [ExpirationReaper-1001-Heartbeat]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:34,021] INFO Creating /controller (is it secure? false) (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,023] INFO [ExpirationReaper-1001-Rebalance]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2018-03-17 15:14:34,034] INFO Result of znode creation is: OK (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,036] INFO [GroupCoordinator 1001]: Starting up. (kafka.coordinator.group.GroupCoordinator)
[2018-03-17 15:14:34,037] INFO [GroupCoordinator 1001]: Startup complete. (kafka.coordinator.group.GroupCoordinator)
[2018-03-17 15:14:34,043] INFO [GroupMetadataManager brokerId=1001] Removed 0 expired offsets in 2 milliseconds. (kafka.coordinator.group.GroupMetadataManager)
[2018-03-17 15:14:34,059] INFO [ProducerId Manager 1001]: Acquired new producerId block (brokerId:1001,blockStartProducerId:0,blockEndProducerId:999) by writing to Zk with path version 1 (kafka.coordinator.transaction.ProducerIdManager)
[2018-03-17 15:14:34,091] INFO [TransactionCoordinator id=1001] Starting up. (kafka.coordinator.transaction.TransactionCoordinator)
[2018-03-17 15:14:34,095] INFO [TransactionCoordinator id=1001] Startup complete. (kafka.coordinator.transaction.TransactionCoordinator)
[2018-03-17 15:14:34,105] INFO [Transaction Marker Channel Manager 1001]: Starting (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2018-03-17 15:14:34,189] INFO Creating /brokers/ids/1001 (is it secure? false) (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,206] INFO Result of znode creation is: OK (kafka.utils.ZKCheckedEphemeral)
[2018-03-17 15:14:34,207] INFO Registered broker 1001 at path /brokers/ids/1001 with addresses: EndPoint(47.97.199.139,9092,ListenerName(PLAINTEXT),PLAINTEXT) (kafka.utils.ZkUtils)
[2018-03-17 15:14:34,211] WARN No meta.properties file under dir /kafka/kafka-logs-5664a8b9deaa/meta.properties (kafka.server.BrokerMetadataCheckpoint)
[2018-03-17 15:14:34,240] INFO Kafka version : 1.0.1 (org.apache.kafka.common.utils.AppInfoParser)
[2018-03-17 15:14:34,240] INFO Kafka commitId : c0518aa65f25317e (org.apache.kafka.common.utils.AppInfoParser)
[2018-03-17 15:14:34,241] INFO [KafkaServer id=1001] started (kafka.server.KafkaServer)
```




