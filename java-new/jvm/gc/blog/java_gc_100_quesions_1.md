# java GC 循序渐进100 问 - 1 基础与概念

## 前言

果然懒是写博客最大的阻碍. 

通过向别人清楚地解说一件事，来确认自己真的弄懂了这件事。[费曼学习法]

①②③等用来表示 参考的文献/网址

## 目标

## GC 入门

### 1. java 中的 GC 是什么

java 是一门可以自动管理内存的语言, 它运行在 jvm 之上, 所以根本上来说是 jvm 可以自动管理内存, jvm 通过gc (垃圾回收)来进行内存控制. 

### 2. 对象在什么时候可以被回收

不再使用的对象②. 一般一个对象不再被引用(可能有循环引用问题->1.3)，就代表该对象可以被回收

1. [语法垃圾](https://en.wikipedia.org/wiki/Syntactic_garbage)(程序可能无法到达的那些对象)
2. [语义垃圾](https://en.wikipedia.org/wiki/Semantic_garbage)(程序实际上将不再使用的那些对象)

### 3. 如何判断对象是否可被回收?

一般判断一个对象是否可以被回收有两种方法 

1. **引用计数法**
2. **可达性分析算法**

#### 3.1 引用计数法是什么? 有什么缺点?

很难解决循环引用的问题

#### 3.2 简述可达性分析算法

可达性分析算法通过一组 **GC ROOTS** (**一组活跃的引用**①) 作为起点 , 从这些节点向下搜索,  **标记**所有与之关联的对象 . 标记完成之后, 没有被标记的对象就称之为 **不可用对象**(垃圾回收的目标) 

可达性分析算法可以解决 循环引用的问题

#### 3.3 不安全的可达性分析, 如误报/漏报, 会造成哪些问题?

在多线程环境下，其他线程可能会更新已经访问过的对象中的引用 ④

- 误报, 损失一部分垃圾回收的对象
- 漏报, 即忘记标记了, 在标记时, 有其他线程new了新的对象, 最后回收时, jvm认为这个对象没有被标记, 于是回收了这个实际存活的对象

#### 3.4 如何"安全"地进行可达性分析?

1. 找到所有 GC ROOTS
2. 标记时 **Stop the world**, **停止**其他**非垃圾回收线程**的工作

#### 3.5 如何找到所有的 GC Roots (3.2 延伸)

GC roots 这组引用是tracing GC ①②的起点。要实现语义正确的tracing GC，就必须要能完整枚举出所有的GC roots，否则就可能会漏扫描应该存活的对象，导致GC错误回收了这些被漏扫的活对象. 

在java语言中, GC roots 这组**引用**可能包括 ①③

- 所有Java线程当前活跃的**栈帧**里指向GC堆里的对象的引用；换句话说，当前所有正在被调用的方法的引用类型的参数/局部变量/临时值。
- VM中**静态数据结构**里指向GC堆里的对象的引用，例如说HotSpot VM里的Universe里有很多这样的引用。
- **JNI handles**，包括global handles和local handles
- （看情况）所有当前被加载的**Java类**
- （看情况）Java类的引用类型静态变量
- （看情况）Java类的运行时**常量池**里的引用类型常量（String或Class类型）
- （看情况）String常量池（StringTable）里的引用

### 4. STOP THE WORLD (STW)

#### 4.1 STW 是什么?

**停止**其他**非垃圾回收线程**的工作 (停止用户线程工作)

#### 4.2 为什么 GC 需要 stw ?

根本原因在于: **jvm 需要移动对象并更新引用**, 但当应用程序线程仍在运行时，很难安全地实现这一目标。

hotspot 目前提供的所有垃圾回收器都会 stw, 不管是Part GC 还是 FULL GC

#### 4.3 如何进行  STOP THE WORLD ?

- Java 虚拟机中的 Stop-the-world 是通过**安全点**（safepoint）机制来实现的
- jvm 收到 stw 请求后, 它会等待所有线程到达 safepoint, 才允许 stw 的线程独占工作
- 安全点的初始目的并不是让其他线程停下，而是找到一个稳定的执行状态。在这个执行状态下，Java 虚拟机的堆栈不会发生变化。这么一来，垃圾回收器便能够“安全”地执行可达性分析。④

#### 4.3.2 Stop The World的四个阶段 ⑥

使用 ` -XX:+PrintSafepointStatistics` 来输出 gc stw 的情况 

```
         vmop                    [threads: total initially_running wait_to_block]    [time: spin block sync cleanup vmop] page_trap_count
1.027: no vm operation                [      19          1              2    ]      [  1093     0  1093     0     0    ]  0   
```

- Spin阶段。因为jvm在决定进入全局safepoint的时候，有的线程在安全点上，而有的线程不在安全点上，这个阶段是等待未在安全点上的用户线程进入安全点。
- Block阶段。即使进入safepoint，用户线程这时候仍然是running状态，保证用户不在继续执行，需要将用户线程阻塞。⑦这篇bog详细说明了如何将用户线程阻塞。
  - sync 等于 spin+block，这是从开始到进入安全点所耗的时间，可用于判断进入安全点耗时 
- Cleanup。这个阶段是JVM做的一些内部的清理工作。
- VM Operation. JVM执行的一些全局性工作，例如GC,代码反优化。



#### 4.4 有哪些地方可以设置安全点检测? 

我们可以在代码中加入安全点检测, 当 stw 请求发出后, 检查是否需要暂停执行

 1. 解释执行的字节码之间
  2. JNI API 调用 Java 方法, 访问对象时
  3. 阻塞的线程由于处于 Java 虚拟机线程调度器的掌控之下，因此属于安全点。
  4. JIT 生成机器码时, 即时编译器需要插入安全点检测
     - HotSpot 虚拟机的做法便是在生成代码的方法出口以及非计数循环的循环回边（back-edge）处插入安全点检测。

#### 4.5 长时间没有进入安全点对GC的影响 ?

`-Xmx50M -Xms50M -XX:+PrintGCDateStamps -XX:+PrintGC -XX:+PrintGCApplicationStoppedTime -XX:+PrintSafepointStatistics`

```java
    public static void foo() {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(String.format("foo: %dms", l2 - l1));
    }
```

`2019-10-12T23:32:23.767+0800: Total time for which application threads were stopped: 1.0933449 seconds, Stopping threads took: 1.0931842 seconds`

原因是有线程迟迟进入不到safepoint来阻塞，导致其他已经停止的线程也一直等待，VM Thread也在等待所有的Java线程都进入到safepoint阻塞才能开始GC。




## 参考

- ① R大回答为什么gc要分代, 包含 GC ROOTS 相关
  
  - https://www.zhihu.com/question/53613423/answer/135743258
  
- ② 语法垃圾与语义垃圾
  - 在[语法垃圾](https://en.wikipedia.org/wiki/Syntactic_garbage)（程序可能无法到达的那些对象）和[语义垃圾](https://en.wikipedia.org/wiki/Semantic_garbage)（程序实际上将不再使用的那些对象）之间进行区分
  -  https://en.wikipedia.org/wiki/Tracing_garbage_collection
  
- ③ 深入理解 JVM 3.2.2 可达性分析算法 P64

- ④ 极客时间 深入拆解 java 虚拟机 第11讲 垃圾回收（上）
  
  - https://time.geekbang.org/column/article/13091
  
- ⑤ Java Garbage Collect是否总是必须“停滞世界”？
  
  - https://stackoverflow.com/questions/40182392/does-java-garbage-collect-always-has-to-stop-the-world
  
- ⑥ 陈亮对于 safepoint 的回答

  - https://www.zhihu.com/question/57722838/answer/156390795
  - https://blog.csdn.net/u011918260/article/details/70047159

- ⑦ [http://blog.csdn.net/iter_zc/article/details/41892567](https://link.zhihu.com/?target=http%3A//blog.csdn.net/iter_zc/article/details/41892567) 

  

转载请注明出处

>  作者: GiraffeTree -  https://giraffetree.me/2019/10/13/java_gc_100_quesions_1/