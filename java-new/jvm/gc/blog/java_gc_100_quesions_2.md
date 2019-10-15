# java GC 循序渐进100 问 - 2. 算法与实现

## 前言

本节会分类介绍下**垃圾回收算法**, **垃圾回收器**的优点和缺点

先在脑中有个大致的框架

## 本节自测问题

1. **GC 回收算法有哪些 ?  有什么优点/缺点**
- 提示: 一共 3个算法 + 一个思想
  
2. **这些算法对应的回收器实现有哪些 ?**
- 新生代 / 老年代 / all
  
3.  **Parallel Scavenge 与 Parallel New 的区别**
- 至少 3点  (参见: 其他问题)
  
4. **CMS 的4个阶段**

5. **CMS 的缺点**
- 至少 3 点
  
6. **G1GC 的特点**
- 至少 3 点
7. **吞吐量优先/延迟优先下, 分别选用哪个(些) 垃圾回收器?**
8. **其他问题**
   - 为什么 Parallel Scanvenge 不能和 CMS 一起用 ?
   - Parallel Scanvenge 和 ParNew(Parallel New) 的区别
   - Parallel 和 Concurrent 用在垃圾回收器中分别是什么含义:



## GC 算法

| 回收算法                                   | 优点                                       | 缺点                                       |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| Mark-Sweep 标记清除                        | 不需要移动对象, 简单高效                   | 会产生内存碎片                             |
| Copying 复制                               | 简单高效, 没有内存碎片                     | 内存使用率低, 可能会产生内存频繁复制的情况 |
| Mark-Compact 标记整理                      | 简单高效, 没有内存碎片, 内存使用率高       | 仍需要移动对象                             |
| Generational Collection 分代收集算法(思想) | 分区回收, 基于大多数对象生命周期较短的假设 | 对长时间存活对象的场景效果不佳             |

## 垃圾回收器

### 新生代回收器

| 回收器名          | 回收算法 | 特点                                                         |
| ----------------- | -------- | ------------------------------------------------------------ |
| Serial            | Copying  | 单线程回收器                                                 |
| Parallel New      | Copying  | Parallel New 可以看成 Serial 的多线程版本, 可以和 CMS 一起使用 |
| Parallel Scavenge | Copying  | 1. Parallel Scavenge 和 Parallel New 类似，但更加注重吞吐率。2. Parallel Scavenge 不能与 CMS 一起使用。3.Parallel Scavenge 有自适应调节策略`+XX:UseAdaptiveSizePolicy`, 调节新生代大小, eden/survivor 比例, 晋升老年代年龄等 |

### 老年代回收器

| 回收器名                      | 回收算法     | 特点                                     |
| ----------------------------- | ------------ | ---------------------------------------- |
| Serial Old                    | Mark-Compact | 单线程                                   |
| Parallel Old                  | Mark-Compact | 多线程回收                               |
| CMS - concurrent mark & sweep | Mark-SWEEP   | 并发低延迟,CPU占用高,  在 java9 中被弃用 |

### 其他回收器

| 回收器名 | 回收算法               | 特点                                                         |
| -------- | ---------------------- | ------------------------------------------------------------ |
| G1       | Copying & Mark-Compact | 1. 分区,  优先回收死亡对象较多的区域 2. 不需要其他收集器配合就能独立管理整个堆  3. 高并发, 低延迟, 可预测停顿时间 |
| ZGC      | Mark-Compact           | 1. 可变分区大小, 低延迟, 通过LVB 实现低延迟                  |

### Parallel Scavenge 

Parallel Scavenge收集器提供了两个参数用于精确控制吞吐量，分别是控制最大垃圾收集停顿时间的`-XX:MaxGCPauseMillis`参数以及直接设置吞吐量大小的`-XX:GCTimeRatio`参数。

- `MaxGCPauseMillis` 参数允许的值是一个大于0的毫秒数，收集器将尽可能地保证内存回收花费的时间不超过设定值
- `GCTimeRatio`参数的值应当是一个大于0且小于100的整数

### CMS

#### CMS 的 4个阶段

- 初始标记 STW
  - 标记gc roots直接关联到的对象
- 并发标记
  - gc tracing
- 重新标记 STW
  - 修正并发标记阶段因为用户程序继续运行而导致的标记变动
  - 时长远远比并发标记的时间短
- 并发清除
  - 与用户线程一起运行

#### CMS 的缺点

1. 对CPU资源敏感, 在cpu不足4个时, 对用户线程影响大
2. cms 在并发清除的过程中, 仍然有新的垃圾不断产生 (这部分垃圾被称为浮动垃圾 floating garbage), 所以需要事先预留一定区域(相当于浪费一部分内存), 否则如果垃圾回收时, 内存不足会导致 concurrent mode failure, 并使用 serial old 来回收垃圾了.
3. mark-sweep 的算法容易导致内存碎片产生
   - `-XX:+UseCMSCompactAtFullCollection` 在 fullGC的时候开启内存碎片整理, 但这个过程无法并发
   - `-XX:CMSFullGCsBeforeCompaction` 设置执行多少次不压缩的 full gc 之后, 进行一次 compact

### 选优

- 吞吐量优先
  - Parallel Scavenge + Parallel Old 
    -  `-XX:+UseParallelOldGC`
  - Parallel New(ParNew) + CMS  (cpu敏感,较低延迟)
    - `-XX:+UseConcMarkSweepGC`
    - cms 在并发模式回收失败的情况下, 会使用 serial old GC
- 低延迟
  - G1GC
    - `-XX:+UseG1GC`
  - ZGC

下图来自于 ①

![img](asset/java_gc_100_quesions_2/collectors.jpg)



## 其他问题

#### 为什么 Parallel Scanvenge 不能和 CMS 一起用?

R大回答: https://hllvm-group.iteye.com/group/topic/37095#post-242695

> 这些XXXGeneration都在HotSpot VM的“分代式GC框架( Generational GC framework )”内。本来HotSpot VM鼓励开发者尽量在这个框架内开发GC，但后来有个开发就是不愿意被这框架憋着，自己硬写了个没有使用已有框架的新并行GC，并拉拢性能测试团队用这个并行GC来跑分，成绩也还不错，于是这个GC就放进HotSpot VM里了。这就是我们现在看到的ParallelScavenge。 

#### Parallel Scanvenge 和 ParNew(Parallel New) 的区别

R大回答: https://hllvm-group.iteye.com/group/topic/37095#post-242695

> 1、PS以前是广度优先顺序来遍历对象图的，JDK6的时候改为默认用深度优先顺序遍历，并留有一个UseDepthFirstScavengeOrder参数来选择是用深度还是广度优先。在JDK6u18之后这个参数被去掉，PS变为只用深度优先遍历。ParNew则是一直都只用广度优先顺序来遍历 
> 2、PS完整实现了adaptive size policy，而ParNew及“分代式GC框架”内的其它GC都没有实现**完**（倒不是不能实现，就是麻烦+没人力资源去做）。所以千万千万别在用ParNew+CMS的组合下用UseAdaptiveSizePolicy，请只在使用UseParallelGC或UseParallelOldGC的时候用它。 
> 3、由于在“分代式GC框架”内，ParNew可以跟CMS搭配使用，而ParallelScavenge不能。当时ParNew GC被从Exact VM移植到HotSpot VM的最大原因就是为了跟CMS搭配使用。 
> 4、在PS成为主要的throughput GC之后，它还实现了针对NUMA的优化；而ParNew一直没有得到NUMA优化的实现。 

#### Parallel 和 Concurrent 用在垃圾回收器中分别是什么含义:

Parallel 多条垃圾回收线程同时工作, 但用户线程处于等待状态

- 如 ParNew Old

Concurrent 指用户线程与垃圾回收线程同时执行

- 如 CMS

来自②深入理解 jvm 周志明 3.5.2 ParNew 收集器 P78

## 参考

- ① Our Collectors -  Jon Masamitsu's Weblog
  
  - https://blogs.oracle.com/jonthecollector/our-collectors
  
- ② 深入理解 jvm 周志明

- ③ zgc

  - > 与标记对象的传统算法相比，ZGC在指针上做标记，在访问指针时加入Load Barrier（读屏障），比如当对象正被GC移动，指针上的颜色就会不对，这个屏障就会先把指针更新为有效地址再返回，也就是，永远只有单个对象读取时有概率被减速，而不存在为了保持应用与GC一致而粗暴整体的Stop The World。

  - https://www.jianshu.com/p/60d9e125dcf3



转载请注明出处

>  作者: GiraffeTree -  https://giraffetree.me/2019/10/13/java_gc_100_quesions_2/

