

# 一文了解 HTTP/2 前世今生

## 阅读本文你会了解

1. 为什么要使用 HTTP/2
   - HTTP/1.x 有哪些缺点
2. HTTP/2 的前身是什么 ? 它做了什么改进
3. HTTP/2 是怎么工作的 ?

## why http2

想要了解一门技术, 首先要知道这门技术是为了解决什么问题而出现的.

#### `http/1.x` 的缺点

1. 队头阻塞 head-of-line blocking

   - 在使用 pipelining 时, 如果第一个请求阻塞后, 客户端要等待前一个请求接受完毕, 才能接着完成下一个请求的接受( 保证客户端有序收到 ); 其实也就是说, 在一个 tcp 连接上, 只允许有一个未完成的请求. 
   - 由于队头阻塞, 因此客户端需要使用多个 tcp 连接到服务器来实现并发, 减少延迟
   - https://liudanking.com/arch/what-is-head-of-line-blocking-http2-quic/
   - https://en.wikipedia.org/wiki/Head-of-line_blocking

2. 低效的 tcp

   - 浏览器会与一个服务器建立多个tcp连接

   - 而由于tcp 的慢启动/拥塞窗口调节, 以及 http/1.x 中浏览器会对单个域名开启 多个并发连接, 而慢启动也会并发的发生多次,  从而导致网络传输并不是最高效的

3. 臃肿的消息首部 header

https://segmentfault.com/a/1190000013519925

## HTTP/2 的前身 -- SPDY

`SPDY` 即 `speedy` , 是 google 用于改进 http 开发的一款协议

SPDY并不用于取代HTTP，它只是修改了HTTP的请求与应答在网络上传输的方式；这意味着只需增加一个SPDY传输层，现有的所有服务端应用均不用做任何修改。 

当使用SPDY的方式传输，HTTP请求会被处理、标记简化和压缩。比如，每一个SPDY端点会持续跟踪每一个在之前的请求中已经发送的HTTP报文头部，从而避免重复发送还未改变的头部。而还未发送的报文的数据部分将在被压缩后被发送。

### spdy 的目标

1. 允许许多并发HTTP请求在单个TCP会话中运行。
2. 通过压缩标头和消除不必要的标头来减少HTTP当前使用的带宽。
3. 定义易于实现且服务器效率高的协议。我们希望通过减少边缘情况和定义易于解析的消息格式来降低HTTP的复杂性。
4. 使SSL成为底层传输协议，以获得更好的安全性并与现有网络基础架构兼容。尽管SSL确实会引入延迟，但我们相信网络的长期未来取决于安全的网络连接。此外，必须使用SSL来确保不破坏现有代理之间的通信。  
5. 使服务器能够启动与客户端的通信，并尽可能将数据推送到客户端。

http://dev.chromium.org/spdy/spdy-whitepaper

### SPDY 的功能

#### 基本功能

1. 多路复用
   - 多个并发的http请求在单个tcp会话中运行
2. 实现了请求的优先级
   - 防止网络信道被非关键资源堵塞
3. http 标头压缩

#### 高级功能

1. 服务器推送
2. 服务器提示

## HTTP/2

###   HTTP/2 规范

HTTP/2 主要由两个规范组成

1. Hypertext Transfer Protocol Version 2 https://httpwg.org/specs/rfc7540.html
2. HPACK - HTTP / 2的头压缩 https://httpwg.org/specs/rfc7541.html

上面的两个文档, 可能是我能找到的最权威的规范文档了, 你可以通过这两个规范了解 `http/2` 的一切.

另外还有一些 `HTTP/2`的常见问题权威解答  https://http2.github.io/faq/

### HTTP/2 改变

1. HTTP / 2脱离了严格的请求 - 响应语义，并启用了一对多和服务器启动的推送工作流
2. 拆分了原有的 http 消息, 将 http 抽象成了 frame 

### 基本概念  Connection, Stream, Message, Frame

#### Connection

指 `tcp 连接` , 一个 tcp 连接可以携带任意数量的 双向流 `bidirectional streams`

#### **Stream** 

` Stream` 指在一个已经建立的tcp连接上的双向字节流 `A bidirectional flow of bytes` , 它可以携带 1 个或者多个 `Message` 信息

#### Message

对应 `Http/1.x` 中的 `request / response` , 一个 `Message` 对应 一个完整的 `frame` 序列

#### Frame

`Frame` 是 `HTTP/2` 中的最小通讯单元, 可以携带一种指定类型的数据 , 如 `HTTP HEADER` , `message  Payload` 等

来自不同 `Stream` 的 `Frame` 可以任意编排, 最后通过 `Frame` 中的流标识 `Stream identifier` 来进行重新组装

### HTTP/2 做了哪些事情

1. 流控制 stream 
2. 二进制帧层 binary framing layer
3. 头压缩  header compression

#### 流控制

1.  每个 stream 都有一个权重 [1 -255]
2. 每个 stream 都可以有一个依赖

流控制中允许一下操作

1.  客户端可以暂停 stream 传送, 并可以在之后恢复
2. 流控制在建立信任的基础之上实现

关于权重

流依赖性和权重表示*传输偏好*，而不是要求，因此不保证特定的处理或传输顺序。也就是说，客户端不能强制服务器使用流优先级按特定顺序处理流。虽然这看似违反直觉，但事实上它是理想的行为：如果阻止了更高优先级的资源，我们不希望阻止服务器在较低优先级资源上取得进展。

#### 二进制帧

1. headers -> metadata
2. data ->  payload

每个帧都有一个通用 header (9 字节) , 可以高效地进行编码/解码

#### HPACK 头压缩 HPACK header compression





### 如何减少网络延时

1. 对 `http` 头部字段进行压缩 HPACK 算法
   - 基于霍夫曼编码 Huffman Coding
2. HTTP/2 服务端推送
   - 为什么要用服务端推送呢?
   - 服务器直接提供浏览器渲染页面所需资源，而无须浏览器在收到、解析页面后再提起一轮请求，节约了加载时间
3. HTTP pipelining 
   - 将多个[HTTP](https://zh.wikipedia.org/wiki/HTTP)请求（request）整批提交的技术，而在发送过程中不需先等待服务器的回应。
4. 修复HTTP/1.0版本以来未修复的 [队头阻塞](https://zh.wikipedia.org/wiki/%E9%98%9F%E5%A4%B4%E9%98%BB%E5%A1%9E) 问题
5. 对数据传输采用[多路复用](https://zh.wikipedia.org/wiki/%E5%A4%9A%E8%B7%AF%E5%A4%8D%E7%94%A8)，让多个请求合并在同一 [TCP](https://zh.wikipedia.org/wiki/TCP) 连接内。



https://zh.wikipedia.org/wiki/HTTP/2

https://github.com/http2/http2-spec


https://www.cnblogs.com/confach/p/10141273.html

https://www.nginx.com/blog/7-tips-for-faster-http2-performance/

high performance browser network     https://hpbn.co/http2/








![http_pipelining](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/April/http_pipelining.jpg)




















### 参考

[1]: https://zh.wikipedia.org/wiki/SPDY	"SPDY wiki"



[^2]: spdy wiki






