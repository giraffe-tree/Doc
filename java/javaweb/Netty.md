# Netty

本篇关于 netty 的介绍,主要基于 **Netty in action**

## 关于资源

源码地址(来自于netty in action中文版译者):[《Netty 实战》 Netty In Action 中文版](https://github.com/ReactivePlatform/netty-in-action-cn). 代码质量很高,注释十分详细,可以  ```git clone ```下来自己运行.



## 第一章 netty 介绍

netty 是一个 ```NIO client-server``` 框架,使用 netty 可以快速开发网络应用,例如服务器和客户端协议.netty 完全基于 NIO 实现的,所以整个 netty 都是异步的.

本章主要介绍,阻塞和非阻塞的网络 api/jdk 接口, netty 的基础构件: channel, 回调, future, 事件, channelHandler

## 第二章  你的第一款 netty 应用程序

### 2.1 开发环境

### 2.2 netty 客户端/服务器概览

### 2.3 编写 echo 服务器

一个 nettyuwuqi 都需要以下两部分

1. 一个 channelHandler : 该组件实现了服务器对从客户端接受的数据的处理
2. 引导: 配置服务器的启动代码,绑定监听端口

```
<dependency>
    <groupId>io.netty</groupId>
    <artifactId>netty-all</artifactId>
    <version>4.1.19.Final</version>
</dependency>
```

#### 2.3.1 channelHandler 和业务逻辑

























