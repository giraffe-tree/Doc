# MQTT

## 参考链接

http://dataguild.org/?p=6817

https://mcxiaoke.gitbooks.io/mqtt-cn/content/mqtt/01-Introduction.html

## 第一章 mqtt 介绍

- MQTT使用的底层传输协议基础设施。
- 客户端使用它连接服务端。
- 它提供有序的、可靠的、双向字节流传输。

### 客户端 

使用MQTT的程序或设备。客户端总是通过网络连接到服务端。它可以

1. 发布应用消息给其它相关的客户端。
2. 订阅以请求接受相关的应用消息。
3. 取消订阅以移除接受应用消息的请求。
4. 从服务端断开连接。

### 服务端 Server

一个程序或设备，作为发送消息的客户端和请求订阅的客户端之间的中介。服务端

1. 接受来自客户端的网络连接。
2. 接受客户端发布的应用消息。
3. 处理客户端的订阅和取消订阅请求。
4. 转发应用消息给符合条件的已订阅客户端。

#### 通过网络连接发送的信息数据包。

MQTT规范定义了十四种不同类型的控制报文，其中一个（PUBLISH报文）用于传输应用消息。






