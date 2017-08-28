# TCP


## tcp为什么是三次握手

*参考*

[tcp为什么是三次握手](https://www.zhihu.com/question/24853633)

为了防止已失效的连接请求报文段突然又传送到了服务端，因而产生错误

网络中存在延迟的重复分组

> 1)client端首先发送一个SYN包告诉Server端我的初始序列号是X。
>
> 2)Server端收到SYN包后回复给client一个ACK确认包，告诉client说我收到了。
>
> 3)接着Server端也需要告诉client端自己的初始序列号，于是Server也发送一个SYN包告诉client我的初始序列号是Y。
>
> 4)Client收到后，回复Server一个ACK确认包说我知道了。

### Server发送SYN包是作为发起连接的SYN包，还是作为响应发起者的SYN包呢？怎么区分？比较容易引起混淆

Server的ACK确认包和接下来的SYN包可以合成一个SYN ACK包一起发送的，没必要分别单独发送，这样省了一次交互同时也解决了问题[1]. 这样TCP建立一个连接，三次握手在进行最少次交互的情况下完成了Peer两端的资源分配和初始化序列号的交换。


### TCP如何断开连接

[tcp 三次握手](https://www.zhihu.com/search?type=content&q=tcp+%E4%B8%89%E6%AC%A1%E6%8F%A1%E6%89%8B)

由于TCP是全双工的，需要Peer两端分别各自拆除自己通向Peer对端的方向的通信信道。这样需要四次挥手来分别拆除通信信道，就比较清晰明了了。

> 1）Client发送一个FIN包来告诉Server我已经没数据需要发给Server了。
>
> 1）Server收到后回复一个ACK确认包说我知道了。
>
> 3）然后server在自己也没数据发送给client后，Server也发送一个FIN包给Client告诉Client我也已经没数据发给client了。
>
> 4）Client收到后，就会回复一个ACK确认包说我知道了。
到此，四次挥手，这个TCP连接就可以完全拆除了。


### TCP连接的初始化序列号能否固定

如果初始化序列号（缩写为ISN：Inital Sequence Number）可以固定，我们来看看会出现什么问题。假设ISN固定是1，Client和Server建立好一条TCP连接后，Client连续给Server发了10个包，这10个包不知怎么被链路上的路由器缓存了(路由器会毫无先兆地缓存或者丢弃任何的数据包)，这个时候碰巧Client挂掉了，然后Client用同样的端口号重新连上Server，Client又连续给Server发了几个包，假设这个时候Client的序列号变成了5。接着，之前被路由器缓存的10个数据包全部被路由到Server端了，Server给Client回复确认号10，这个时候，Client整个都不好了，这是什么情况？我的序列号才到5，你怎么给我的确认号是10了，整个都乱了。
RFC793中，建议ISN和一个假的时钟绑在一起，这个时钟会在每4微秒对ISN做加一操作，直到超过2^32，又从0开始，这需要4小时才会产生ISN的回绕问题，这几乎可以保证每个新连接的ISN不会和旧的连接的ISN产生冲突。这种递增方式的ISN，很容易让攻击者猜测到TCP连接的ISN，现在的实现大多是在一个基准值的基础上进行随机的。



###  初始化连接的SYN超时问题

Client发送SYN包给Server后挂了，Server回给Client的SYN-ACK一直没收到Client的ACK确认，这个时候这个连接既没建立起来，也不能算失败。这就需要一个超时时间让Server将这个连接断开，否则这个连接就会一直占用Server的SYN连接队列中的一个位置，大量这样的连接就会将Server的SYN连接队列耗尽，让正常的连接无法得到处理。目前，Linux下默认会进行5次重发SYN-ACK包，重试的间隔时间从1s开始，下次的重试间隔时间是前一次的双倍，5次的重试时间间隔为1s, 2s, 4s, 8s, 16s，总共31s，第5次发出后还要等32s都知道第5次也超时了，所以，总共需要 1s + 2s + 4s+ 8s+ 16s + 32s = 63s，TCP才会把断开这个连接。由于，SYN超时需要63秒，那么就给攻击者一个攻击服务器的机会，攻击者在短时间内发送大量的SYN包给Server(俗称 SYN flood 攻击)，用于耗尽Server的SYN队列。对于应对SYN 过多的问题，linux提供了几个TCP参数：tcp_syncookies、tcp_synack_retries、tcp_max_syn_backlog、tcp_abort_on_overflow 来调整应对。


### TCP的Peer两端同时断开连接






