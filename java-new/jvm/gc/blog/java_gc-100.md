# GC

## G1

### 知识点

- G1（Garbage First）是一个横跨新生代和老年代的垃圾回收器。
  - 它已经打乱了前面所说的堆结构，直接将堆分成极其多个区域。每个区域都可以充当 Eden 区、Survivor 区或者老年代中的一个。
- 可预测的停顿
  - 在指定长度时间 M 毫秒内, 消耗在垃圾收集上的时间不能超过 N 毫秒
- 整体来看是 mark-compact 不会产生内存碎片

缺点

- 问题在于, region 不可能是孤立的
- 使用 rememberd set 来避免全对扫描
  - 一个 region 有一个对应的 remembered set
  - 写屏障更新 rset 引用
- G1 的主要优点是 低延迟, 吞吐量还得看 Parllel Old / CMS

#### G1 运作的阶段

- 初始标记 stw
- 并发标记 
- 最终标记 stw
- 筛选回收 live data counting and evacuation (stw? 待验证)

