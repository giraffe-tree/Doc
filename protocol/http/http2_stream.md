# HTTP/2 Stream

## Stream basics

### Stream state

```
                             +--------+
                     send PP |        | recv PP
                    ,--------|  idle  |--------.
                   /         |        |         \
                  v          +--------+          v
           +----------+          |           +----------+
           |          |          | send H /  |          |
    ,------| reserved |          | recv H    | reserved |------.
    |      | (local)  |          |           | (remote) |      |
    |      +----------+          v           +----------+      |
    |          |             +--------+             |          |
    |          |     recv ES |        | send ES     |          |
    |   send H |     ,-------|  open  |-------.     | recv H   |
    |          |    /        |        |        \    |          |
    |          v   v         +--------+         v   v          |
    |      +----------+          |           +----------+      |
    |      |   half   |          |           |   half   |      |
    |      |  closed  |          | send R /  |  closed  |      |
    |      | (remote) |          | recv R    | (local)  |      |
    |      +----------+          |           +----------+      |
    |           |                |                 |           |
    |           | send ES /      |       recv ES / |           |
    |           | send R /       v        send R / |           |
    |           | recv R     +--------+   recv R   |           |
    | send R /  `----------->|        |<-----------'  send R / |
    | recv R                 | closed |               recv R   |
    `----------------------->|        |<----------------------'
                             +--------+

       send:   endpoint sends this frame
       recv:   endpoint receives this frame

       H:  HEADERS frame (with implied CONTINUATIONs)
       PP: PUSH_PROMISE frame (with implied CONTINUATIONs)
       ES: END_STREAM flag
       R:  RST_STREAM frame

```

### Stream identifier

1. 由客户端发起的流必须使用奇数编号的流标识符; 
2. 那些由服务器发起的必须使用偶数编号的流标识符。
3. 流标识符零（`0x0`）用于连接控制消息; 零流标识符不能用于建立新流
4. 新建立的流标识符必须大于 已经打开/保留的所有流的标识符
5. 流标识符无法重用, 长期连接可能导致耗尽标识符, 无法建立新的流标识符的服务器会发送 `GOAWAY` , 强制客户端为新流打开新的连接

### Stream concurrency

使用[SETTINGS](https://httpwg.org/specs/rfc7540.html#SETTINGS)帧内的[SETTINGS_MAX_CONCURRENT_STREAMS](https://httpwg.org/specs/rfc7540.html#SETTINGS_MAX_CONCURRENT_STREAMS)参数

处于“打开”状态或处于“半封闭”状态之一的流计入允许端点打开的最大流数

## Flow Control

使用 stream 在同一个 tcp 连接上进行多路复用,  容易导致流的阻塞

通过 `Flow Control` 流控制, 确保在同一个 tcp 连接上, 流之间不会相互干扰

`HTTP/2` 中通过使用 `WINDOW_UPDATE` frame 来进行流控制

### 流控制原则

1. 流控制基于[WINDOW_UPDATE](https://httpwg.org/specs/rfc7540.html#WINDOW_UPDATE)帧。由接收者准备在流上接收多少个字节
2. 流量控制是定向的, 由接受者控制; 发送者必须遵守接受者事假的流量控制
3. 流控制窗口的初始值为 65535个字节
4. 帧的类型, 决定了这个帧是否收到流量控制的影响, 按照文档中的描述, 只有[DATA](https://httpwg.org/specs/rfc7540.html#DATA)帧受流量控制

## 流优先级

1. 通过 `HEADERS FRAME`中的优先级, 给新的流分配优先级
2. 通过 `PRIORITY FREME`用于更改流的优先级

### 流依赖

### 流的权重

权重范围: 1 - 256 (包含256)

权重越大, 所分配的资源越多

### 优先级调整

### 优先级状态管理



## 错误处理

HTTP/2 frame 允许两类错误

1. 使整个连接不可用 -- 连接错误
2. 单个流中的错误  -- 流错误

### 连接错误

遇到连接错误的端点要发送 `GOAWAY`, 包含对方接受的最后一个流的流标识符, 发送 `GOAWAY` 后, 端点必须关闭 `tcp` 连接

### 流错误

检测要流错误, 端点会发送 `RST_STREAM` , 包含发生错误的流的流标识符













































