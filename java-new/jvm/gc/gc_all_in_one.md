# JAVA GC

## 问题

目标:

通过向别人清楚地解说一件事，来确认自己真的弄懂了这件事。[费曼学习法]

### GC 入门

1. java 中的 GC 是什么? 
	- java 是一门可以自动管理内存的语言, 它运行在 jvm 之上, 所以根本上来说是 jvm 可以自动管理内存, jvm 通过gc来进行内存控制. 
2. 对象在什么时候可以被回收
	- 不再使用的对象. 一般一个对象不再被引用，就代表该对象可以被回收
3. 如何判断对象是否可被回收?
	- 引用计数法是什么? 有什么缺点
	- 简述可达性分析算法, 它有什么缺点?
		- 误报, 损失一部分垃圾回收的对象
		- 漏报, 即忘记标记了, 在标记时, 有其他线程new了新的对象, 最后回收时, jvm认为这个对象没有被标记, 于是回收了这个实际存活的对象
	- todo: 强引用/软引用/弱引用/虚引用 test
4. 如何解决可达性分析的缺点? 如何"安全"地进行可达性分析
	- Stop the world, 停止其他非垃圾回收线程的工作

4. 如何找到所有的 GC Roots
	- GC roots这组引用是tracing GC的起点。要实现语义正确的tracing GC，就必须要能完整枚举出所有的GC roots，否则就可能会漏扫描应该存活的对象，导致GC错误回收了这些被漏扫的活对象
	- https://www.zhihu.com/question/53613423/answer/135743258

5. 如何进行 stop the world (STW)
	- Java 虚拟机中的 Stop-the-world 是通过安全点（safepoint）机制来实现的
	- jvm 收到 stw 请求后, 它会等待所有线程到达 safepoint, 才允许 stw 的线程独占工作
	- 安全点的初始目的并不是让其他线程停下，而是找到一个稳定的执行状态。在这个执行状态下，Java 虚拟机的堆栈不会发生变化。这么一来，垃圾回收器便能够“安全”地执行可达性分析。
6. safepoint 如何设置
	- 解释执行字节码, 字节码之间均可设置 safepoint
	- jni 本地代码
	- jit 机器码
		- 在可接受的性能开销以及内存开销之内，避免机器码长时间不进入安全点的情况，间接地减少垃圾回收的暂停时间。
	- 阻塞线程
7. 现代JVM中的Safe Region和Safe Point到底是如何定义和划分的?
	- R大回答: https://www.zhihu.com/question/29268019

8. GC 的分类, full gc 和 minor gc 分别会回收哪些jvm中的哪些区域
	- https://juejin.im/post/5b8d2a5551882542ba1ddcf8
	- Partial GC(局部 GC): 并不收集整个 GC 堆的模式
		- Young GC: 只收集young gen的GC，Young GC还有种说法就叫做 "Minor GC"
		- Old GC: 只收集old gen的GC。只有垃圾收集器CMS的concurrent collection 是这个模式
		- Mixed GC: 收集整个young gen 以及部分old gen的GC。只有垃圾收集器 G1有这个模式
	- Full GC: 收集整个堆，包括 新生代，老年代，永久代(在 JDK 1.8及以后，永久代被移除，换为metaspace 元空间)等所有部分的模式
8. 为什么要分代
	1. 基于大部分对象存活时间短的假设
		- 使用 copying 算法高效, 可以降低单次gc时间, 提高gc的吞吐量
	2. 就Azul的Pauless到C4的发展历程来看，选择实现分代的最大好处是，GC能够应付的应用内存分配速率（allocation rate）可以得到巨大的提升
		- R 大 java gc 为什么要分代: https://www.zhihu.com/question/53613423
		- 并发GC根本上要跟应用玩追赶游戏：应用一边在分配，GC一边在收集，如果GC收集的速度能跟得上应用分配的速度，那就一切都很完美；一旦GC开始跟不上了，垃圾就会渐渐堆积起来，最终到可用空间彻底耗尽的时候，应用的分配请求就只能暂时等一等了，等GC追赶上来。
		所以，对于一个并发GC来说，能够尽快回收出越多空间，就能够应付越高的应用内存分配速率，从而更好地保持GC以完美的并发模式工作。
		虽然并不是所有应用中的对象生命周期都完美吻合weak generational hypothesis的假设，但这个假设在很大范围内还是适用的，因而也可以帮助并发GC改善性能。

### stop the world

1. does-java-garbage-collect-always-has-to-stop-the-world / GC 为什么需要停止所有应用线程
	- yes
	- 根本原因在于: jvm 需要移动对象并更新引用
		- https://stackoverflow.com/questions/40182392/does-java-garbage-collect-always-has-to-stop-the-world
2. 为什么 compact 需要 stop the word
	- Compacting means moving objects. Moving objects means pointers need to be updated. This is very difficult or costly to achieve safely when applications threads are still running.
3. minor GC 会 stop the world 么?
	- 当然, hotspot 目前提供的所有垃圾回收器都会 stw, 不管是新生代还是老年代


### GC 算法与实现

1. 常见回收算法有哪些, 有什么优点和缺点
2. 为什么要使用分代回收
3. 回收器有哪些, 分别有什么特点

### GC 优化策略

1. 如何降低 Minor GC 频率, 降低 Minor GC 频率有什么好处?
2. 如何降低 Full GC 的频率

oracle 标准版GC调优指南

	- serial GC -> parllel gc -> cms/g1gc
	- 如果推荐的收集器没有达到期望的性能，请首先尝试调整堆和分代大小以满足期望的目标。如果性能仍然不足，请尝试使用其他收集器：使用并发收集器减少暂停时间，并使用并行收集器增加多处理器硬件上的总体吞吐量。
		- https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/collectors.html#sthref27


### Minor GC (young gc)



2. 讲讲 new 一个对象, 到 young gc 的整个过程
	- TLAB -> Eden -> YoungGC -> S0 -> S1 ...
3. Minor GC 如何避免全堆扫描
	- card table 机制是怎么样的? 如何记录卡表



### CMS

1. 简单描述下 CMS 是怎样运作的?
2. 



## 参考:

1. 极客时间-深入拆解java虚拟机-垃圾回收
	- 关于: 可达性分析, stw, tlab, 卡表, 
	- https://time.geekbang.org/column/article/13091
	- https://time.geekbang.org/column/article/13137
2. 关于引用计数/标记清除(可达性分析)的区别, 循环引用带来的影响
	- R大blog: https://www.iteye.com/blog/rednaxelafx-174865
	- https://time.geekbang.org/column/article/13091
3. minor 与 full gc 
	- https://juejin.im/post/5b8d2a5551882542ba1ddcf8
4. gc 为什么要分代, GC roots 概念
	- R大回答: https://www.zhihu.com/question/53613423/answer/135743258
5. 比喻: 清洁工人清洁公路垃圾
6. G1 GC
	- http://ifeve.com/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3g1%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E5%99%A8/
	- https://yq.aliyun.com/articles/444436



