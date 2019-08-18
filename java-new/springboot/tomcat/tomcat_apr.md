# tomcat apr

## 简介

### apr 是什么?

https://tomcat.apache.org/native-doc/

The Apache Tomcat Native Library is an optional component for use with Apache Tomcat that allows Tomcat to use certain native resources for performance, compatibility, etc.

Specifically, the Apache Tomcat Native Library gives Tomcat access to the Apache Portable Runtime (APR) library's network connection (socket) implementation and random-number generator. See the Apache Tomcat documentation for more information on how to configure Tomcat to use the APR connector.

Features of the APR connector:

Non-blocking I/O for Keep-Alive requests (between requests)
Uses OpenSSL for TLS/SSL capabilities (if supported by linked APR library)
FIPS 140-2 support for TLS/SSL (if supported by linked OpenSSL library)

### apr 和 java 实现的 nio 有什么区别?

Tomcat 支持的连接器有 NIO、NIO.2 和 APR。 跟 NioEndpoint 一样，AprEndpoint 也实现了非阻塞 I/O，它们的区别是：NioEndpoint 通过调用 Java 的 NIO API 来实现非阻塞 I/O，而 AprEndpoint 是通过 JNI 调用 APR 本地库而实现非阻塞 I/O 的。

这是因为在某些场景下，比如需要频繁与操作系统进行交互，Socket 网络通信就是这样一个场景，特别是如果你的 Web 应用使用了 TLS 来加密传输，我们知道 TLS 协议在握手过程中有多次网络交互，在这种情况下 Java 跟 C 语言程序相比还是有一定的差距，而这正是 APR 的强项。

- 来自: https://time.geekbang.org/column/article/101201

#### 细节区别

1. APR  调用了 linux 的 epoll API 来实现 Poller 查询 socket 状态
2. AprEndpoint 可以配置一个叫 deferAccept 的参数
	- 来延迟连接, 减少IO等待, 不需要用 selector 一直查询数据是否到达, 提高一定性能
3. Tomcat 中的 AprEndpoint 就是通过 DirectByteBuffer 来接收数据的，而 NioEndpoint 和 Nio2Endpoint 是通过 HeapByteBuffer 来接收数据的。

	- 如果使用 NioEndpoint/Nio2Endpoint 则在分配缓存时, 使用的是 HeapByteBuffer , 但是如果用HeapByteBuffer来接收网络数据，需要把数据从内核先拷贝到一个临时的本地内存，再从临时本地内存拷贝到 JVM 堆而不是直接从内核拷贝到 JVM 堆上	
		- 想想看这里是为什么?
		- 整个 java 应用程序(进程), 从 jvm 的角度来看分为两块: JVM 内存, 以及 JVM内存以外的本地内存
			- jni 调用的 C 程序代码运行的过程中使用的就是本地内存
		- 当 tomcat 的 endPpint 组件接受网络数据时, 预先在 jvm 内存中 分配了一块 Buffer, Java 通过 JNI 调用把这块 Buffer 的地址传给 C 代码，C 代码通过操作系统 API 读取 Socket 并把数据填充到这块 Buffer
			- 这里的 C 代码使用到了 本地内存
	- 如果使用 apr , 则直接使用 DirectByteBuffer, 这个 DirectByteBuffer 所使用 的 `byte[]` 直接指向 本地内存, 相当于比 使用 java nio 的方式, 少了一次 从 本地内存 到 jvm 内存的拷贝, 所以 apr 速度比较快
	- 为什么 NioEndpoint/Nio2Endpoint 不使用 DirectByteBuffer , 则是因为本地内存不好管理=.=
	- HeapByteBuffer 为什么不直接从 内核 拷贝到 jvm 内存呢?
		- 因为数据从内核拷贝到 JVM 堆的过程中，JVM 可能会发生 GC，GC 过程中对象可能会被移动，也就是说 JVM 堆上的字节数组可能会被移动，这样的话 Buffer 地址就失效了。
		- 如果这中间经过本地内存中转，从本地内存到 JVM 堆的拷贝过程中 JVM 可以保证不做 GC。
		- 这里涉及到 GC 时 safepoint 的问题 =.= todo解决
			-  https://www.zhihu.com/question/57374068

4. sendfile 的差异

	- 传统方式
		- 读取文件时，首先是内核把文件内容读取到内核缓冲区。
		- 如果使用 HeapByteBuffer，文件数据从内核到 JVM 堆内存需要经过本地内存中转。
		- 同样在将文件内容推入网络时，从 JVM 堆到内核缓冲区需要经过本地内存中转。
		- 最后还需要把文件从内核缓冲区拷贝到网卡缓冲区。
		- 总计要经历6次 copy
			- 1.文件 -> 2.内核缓冲 -> 3.java 本地内存缓冲 -> 4.jvm 堆 -> 5.java 本地内存缓冲  -> 6.内核缓冲 -> 7.网卡
	- apr 方式
		- 使用操作一同 sendfile 特性解决
			1. 将文件内容读取到内核缓冲区。
			2. 把数据直接从内核缓冲区传递给网卡
		- 避免的内核态与用户态的切换




## 安装

### windows 

地址: https://tomcat.apache.org/download-native.cgi  下载 windows 版本

### linux

`yum install apr-devel openssl-devel`



