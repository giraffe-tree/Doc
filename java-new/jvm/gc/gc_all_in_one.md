# JAVA GC

## 问题

目标:

通过向别人清楚地解说一件事，来确认自己真的弄懂了这件事。[费曼学习法]

### GC 入门

1. java 中的 GC 是什么? 
2. 对象在什么时候可以被回收
3. GC 的分类, full gc 和 minor gc 分别会回收哪些jvm中的哪些区域
	- https://juejin.im/post/5b8d2a5551882542ba1ddcf8


### GC 算法与实现

1. 常见回收算法有哪些, 有什么优点和缺点
2. 为什么要使用分代回收
3. 回收器有哪些, 分别有什么特点

### GC 优化策略

1. 如何降低 Minor GC 频率, 降低 Minor GC 频率有什么好处?
2. 如何降低 Full GC 的频率

### Minor GC 

1. 讲讲 new 一个对象, 到 young gc 的整个过程
	- TLAB -> Eden -> YoungGC -> S0 -> S1 ...
2. Minor GC 如何避免全堆扫描
	- card table 机制是怎么样的? 如何记录卡表



### CMS

1. 简单描述下 CMS 是怎样运作的?
2. 



## 参考:

1. 极客时间-深入拆解java虚拟机-垃圾回收
	- 关于: tlab, 卡表, 
	- https://time.geekbang.org/column/article/13137
2. 关于引用计数/标记清除(可达性分析)的区别, 循环引用带来的影响
	- R大blog: https://www.iteye.com/blog/rednaxelafx-174865
	- https://time.geekbang.org/column/article/13091
3. minor 与 full gc 
	- https://juejin.im/post/5b8d2a5551882542ba1ddcf8
4. gc 为什么要分代, GC roots 概念
	- R大回答: https://www.zhihu.com/question/53613423/answer/135743258






