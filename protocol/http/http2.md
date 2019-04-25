

# http2

## why http2

想要了解一门技术, 首先要知道这门技术是为了解决什么问题而出现的.



## 前身 -- SPDY

`SPDY` 即 `speedy` 

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
   - ??

#### 高级功能

1. 服务器推送
2. 服务器提示

## HTTP/2

###   HTTP/2 规范

HTTP/2 主要由两个规范组成

1. Hypertext Transfer Protocol Version 2 https://httpwg.org/specs/rfc7540.html
2. HPACK - HTTP / 2的头压缩 https://httpwg.org/specs/rfc7541.html

上面的两个文档, 可能是我能找到的最权威的规范文档了, 你可以通过这两个规范了解 `http/2` 的一切.



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



































### 参考

[1]: https://zh.wikipedia.org/wiki/SPDY	"SPDY wiki"



[^2]: spdy wiki






