# Goroutines

## 参考

1. 主要讲解了 MPG 之间的关系
	
	- https://www.cnblogs.com/sunsky303/p/9115530.html
	- M指的是Machine，一个M直接关联了一个内核线程。
	- P指的是processor，代表了M所需的上下文环境，也是处理用户级代码逻辑的处理器。
	- G指的是Goroutine，其实本质上也是一种轻量级的线程。

2. CSP 
	
	- 并发之痛 Thread，Goroutine，Actor
	- http://jolestar.com/parallel-programming-model-thread-goroutine-actor/
	- Communicating Sequential Processes

## 为什么要有 Goroutines

### 线程

多线程会产生什么问题呢?

1. 多线程情况下会有静态条件的问题, 即某个资源被多个线程使用
2. 如果线程之间的任务有依赖关系, 这就需要一个协调器来帮助保证处理的顺序, 这就使得协调器变得十分复杂

需要多少线程呢?

1. 线程切换的成本较高（内存，调度）不可能大规模创建
2. 需要多少线程很难去人为的控制

### 线程池

线程池一定程度上控制了线程的数量，实现了线程复用，降低了线程的使用成本。但还是没有解决数量的问题，线程池初始化的时候还是要设置一个最小和最大线程数，以及任务队列的长度，自管理只是在设定范围内的动态调整。另外不同的任务可能有不同的并发需求，为了避免互相影响可能需要多个线程池，最后导致的结果就是Java的系统里充斥了大量的线程池。

### 线程是一直处于运行状态

1. 异步回调的方案, 如 NodeJS
2. GreenThread/Coroutine/Fiber方案 这种方案其实和上面的方案本质上区别不大，关键在于回调上下文的保存以及执行机制。为了解决回调方法带来的难题，这种方案的思路是写代码的时候还是按顺序写，但遇到IO等阻塞调用时，将当前的代码片段暂停，保存上下文，让出当前线程。等IO事件回来，然后再找个线程让当前代码片段恢复上下文继续执行，写代码的时候感觉好像是同步的，仿佛在同一个线程完成的，但实际上系统可能切换了线程，但对程序无感。

Continuation 这个概念不熟悉FP编程的人可能不太熟悉，不过这里可以简单的顾名思义，可以理解为让我们的程序可以暂停，然后下次调用继续（contine）从上次暂停的地方开始的一种机制。相当于程序调用多了一种入口。
Coroutine 是Continuation的一种实现，一般表现为语言层面的组件或者类库。主要提供yield，resume机制。

### Goroutine

Goroutine其实就是前面GreenThread系列解决方案的一种演进和实现。

首先，它内置了Coroutine机制。因为要用户态的调度，必须有可以让代码片段可以暂停/继续的机制。
其次，它内置了一个调度器，实现了Coroutine的多线程并行调度，同时通过对网络等库的封装，对用户屏蔽了调度细节。
最后，提供了Channel机制，用于Goroutine之间通信，实现CSP并发模型（Communicating Sequential Processes）。因为Go的Channel是通过语法关键词提供的，对用户屏蔽了许多细节。其实Go的Channel和Java中的SynchronousQueue是一样的机制，如果有buffer其实就是ArrayBlockQueue。

Go通过Goroutine的调度解决了CPU利用率的问题。但遇到其他的瓶颈资源如何处理？比如带锁的共享资源，比如数据库连接等。互联网在线应用场景下，如果每个请求都扔到一个Goroutine里，当资源出现瓶颈的时候，会导致大量的Goroutine阻塞，最后用户请求超时。这时候就需要用Goroutine池来进行控流，同时问题又来了：池子里设置多少个Goroutine合适？

### Actor

### Actor & Goroutine

```
Don’t communicate by sharing memory, share memory by communicating
不要通过共享内存进行通信，通过通信共享内存
```

### Goroutine or lock

使用锁的情景：

- 访问共享数据结构中的缓存信息
- 保存应用程序上下文和状态信息数据

使用通道的情景：

- 与异步操作的结果进行交互
- 分发任务
- 传递数据所有权




