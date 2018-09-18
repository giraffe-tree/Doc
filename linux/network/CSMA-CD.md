# 以太网络传输协议 CSMA/CD 与 集线器

Carrier Sense Multiple Access with Collision Detection

具有冲突检测的载波侦听多路访问

## 集线器

集线器(hub)是一种网络共享介质.所谓的网络共享介质在同一时间点内, 仅能被一台主机使用.

为什么说它在同一时间点内只能被一台主机使用呢? 我们需要了解一下它的工作过程,它使用的是 IEEE 802.3的标准 CSMA/CD, 先不用了解这样一个复杂的名字, 看完下面三点你就明白了.

1. 集线器属于纯硬件网络底层设备，基本上不具有类似于交换机的"智能记忆"能力和"学习"能力。它也不具备交换机所具有的MAC地址表，所以它发送数据时都是没有针对性的，而是采用广播方式发送。也就是说当它要向某节点发送数据时，不是直接把数据发送到目的节点，而是把数据包发送到与集线器相连的所有节点. 这里讲的其实就是 CSMA/CD 中的 MA (Multiple access) 多路访问. 
	
	举个例子, 一个集线器连接着 A,B,C,D 四台主机, 其中 A主机 要发送数据给 D主机, 数据先通过集线器, 集线器会把数据复制多份发送到所有连接到集线器的主机( B,C,D 三台主机), 由于目标是 D 主机, 因此当 B,C 主机收到数据时, 会检查 mac地址 是否和自己的网卡地址一致, 发现不一致后会丢弃数据帧, 故这里 B,C 主机都会将数据丢弃, 而 D 主机则会将数据抓下来处理.
	
	需要注意的是, 上面例子中, A 主机 并不会发给它自己, 因为集线器传送数据时工作在半双工状态下, 也就是说, A 在发送的时候只能发不能收, 相对的来说, D 主机只能收不能发

2. 上面第一点说到, 集线器(hub)是使用广播方式发送数据的, 但很明显多个设备同时发送数据时, 需要同时广播, 这样不会冲突么? hub 是否有这样的功能使各个数据发送不受冲突呢? hub 采用的是监听使用(Carrier Sense), 冲突检查(Collision Detection). 

	怎么理解监听使用呢? 我们来讲一个例子, 例如一个主机A 想通过 集线器 给主机B 发送数据之前. 首先呢, 它会对网络介质进行监听, 确认没有人使用后, 才能发送出数据帧. 

3. 第三点就是第二点中提到的 冲突检查了, 学过并发的同学都知道, 多个线程检查一个状态值, 然后改变这个状态值, 然后是会存在同步问题的. 显然,这里也存在这样的问题. 即使主机对 hub 进行监听, 查看它的状态值(没有其他主机使用), 但还是有可能存在多个主机同时发送数据的问题. 那怎么解决这个问题呢, hub 的解决方法很简单, 如果有数据同时发过来, 直接将这些数据帧销毁. 然后 A 主机, B主机 各自随机等待一段时间, 重新发送.

### 集线器的其他功能

当然集线器除了这些功能外, 还继承了中继器的一些功能. 它会对线路传输中衰减的信号进行加强, 以完成更远距离的传输.

以上就是 CDMA/CD 协议 与 集线器.