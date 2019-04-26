# HTTP/1.1 pipelining - http/1.1 流水线

## 前提

1. `http pipelining` 建立在 http 持久连接的基础上[1]

## 什么是 http/1.1 流水线

可以并发地进行TCP连接上的每个HTTP请求，而无需等待先前请求的响应返回。回复将以**相同的顺序**返回。

## why http/1.1 流水线

默认情况下http协议中每个传输层连接只能承载一个http请求和响应，然后结束。[3]

通过使用 http/1.1 流水线, 将多个http请求同时提交, 可以大幅缩短页面的加载时间

### 比较

**没有流水线操作的HTTP / 1.1：**在下一个请求发出之前，必须响应TCP连接上的每个HTTP请求。

**带有流水线的HTTP / 1.1：**可以并发地进行TCP连接上的每个HTTP请求，而无需等待先前请求的响应返回。服务器回复将以**相同的顺序**返回。

**HTTP / 2多路复用：**可以立即进行TCP连接上的每个HTTP请求，而无需等待先前的响应返回。回复可以按任何顺序返回, 从而避免行头阻塞

## 问题

### 队头堵塞问题 head of line blocking

`HTTP/1.1`通过`pipelining` 管道技术实现一次性发送多个请求，以期提高吞吐和性能。然而，这种技术在接收响应时，要求必须按照发送请求的顺序返回。如果，第一个请求被堵塞了，则后面的请求即使处理完毕了，也需要等待. [4]

## 参考

[1]: https://www.w3.org/Protocols/rfc2616/rfc2616-sec8.html#sec8.1.2.2	"w3c  rfc2616"
[2]: https://stackoverflow.com/questions/19619124/http-pipelining-request-text-example	"http pipelining test"
[3]: https://blog.csdn.net/dongzhiquan/article/details/6114040
[4]: https://liudanking.com/arch/what-is-head-of-line-blocking-http2-quic/