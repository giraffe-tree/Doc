# map

## 目标 - 用于复习检测

1. 了解 HashMap 实现
   1. `hashMap` 中的 `hash` 方法有什么特别之处
2. LinkedHashMap 实现



## 总结 - 用于巩固

### Map 接口

```java
public interface Map<K,V> 
```

### Map 实现 - HashMap

`HashMap` 可能是我们日常使用中最常用的几个工具类了.

#### 实现细节

这篇文章应该是我见过的讲 hashmap 比较好的文章了, 分析到位, 条理清晰 [Java-HashMap工作原理及实现](https://yikun.github.io/2015/04/01/Java-HashMap工作原理及实现/)

**讲过细节部分的我这里就不再赘述, 下面总结一些主要的**

1. `HashMap` 整体上采用 数组 + 链表 (转红黑树) 的方式来排列元素

2. `hashMap` 中的 `hash` 方法有什么特别之处

   - `(key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)` 将一些高位特征放入低位上, 以减少 hash 碰撞

   - 实际 hash 转为 数组的 index 采用 `index = (n - 1) & hash`

   - 上面的那篇文章中举了一个很好的例子, 但 hashmap 的 capicity 为 n=16 时

     > n-1 = 15 (0x1111)，其实散列真正生效的只是低4bit的有效位，当然容易碰撞了

3. `put(key,value)` 的大致流程

   1.  第一次`put`时, 会初始化数组 `Node<K,V>[] tab`
   2.  根据 `key.hash` 转为 tab 数组的下标, 如果该位置为空, 则直接新建 `Node` 插入
   3. 如果该位置对应的`Node` 不为空, 则检查该`Node` 的键是否与 key 相等, 如果相等, 则跳到第6步
   4. 如果该`Node` 的键与 key 不相等, 则检查是否为 `TreeNode` , 如果是则通过 `putTreeVal` 插入, 然后跳到第6步
   5. 如果不是 `TreeNode` 则遍历该链表, 直到找到该 `Node`或者到链表尾部, 到达尾部则直接插入, 并且检查是否达到`TREEIFY_THRESHOLD`, 如果是则 红黑树化
   6. 如果允许修改原有值, 则修改
   7. modcount++ , size++
   8. 且如果 size>=threshold(下一次扩容的阈值) 则进行扩容(resize)

4. `resize`  扩容的实现

   - 把bucket扩充为2倍，之后重新计算index，把节点再放到新的bucket中
     - 这种方式的好处是可以用再次计算hash

   

**文章中没有涉及到的部分**

1. 除了外层的 `hash` 方法之外 , 用于存储数据的 Node 还有一个 `hash` 属性

   - 它会在初始化时, 被放入 `Node` 中, 目的是减少之后的 hash 运算

   - `Node`也有一个自己的 `hashCode` 方法 `Objects.hashCode(key) ^ Objects.hashCode(value);`
2. `instanceof` 看到 put 方法中有用到 `instanceof`, 突然对这个东西到底是怎么 work 的有点感兴趣
   - 在网上查了点资料, 看这篇就够了 https://www.zhihu.com/question/21574535
     - 当年刚刚学java时, 看这篇看到一半就看不下去了, 只是觉得 R大 NB!!!!!!!! 今天又看了一遍, 感觉底层上的实现比想象中要复杂的多, 最后还是那句话 R大 NB!!!!!!!!， hah
3. 



#### TreeNode

了解 `TreeNode` 先了解一点,  `TreeNode` 的实现, 占了 整个 `HashMap` 的 `1/4`(大约1800 行到 2400行) , 不要小看它哦

1. `TreeNode` 

   - `TreeNode`  占用的空间比普通的 node 要大, 所以我们应该仅在合适的时候再使用它(平衡时间和空间)

     - > Because TreeNodes are about twice the size of regular nodes, we use them only when bins contain enough nodes to warrant use (see TREEIFY_THRESHOLD).

2. `static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> `

   - 很奇怪的一件事, `TreeNode` 虽然继承了 `LinkedHashMap.Entry` , 但完全没有用到它的两个属性`before`, `after`





#### 有趣的问题 - 泊松分布与 hashmap

`DEFAULT_LOAD_FACTOR` 为什么是 0.75 ?

简单的来说, 默认加载因子（0.75）在时间和空间成本之间提供了良好的权衡。

然而, jdk 注释中提供了一些有意思的参考

> Ideally, under random hashCodes, the frequency of nodes in bins follows a Poisson distribution (http://en.wikipedia.org/wiki/Poisson_distribution) with a parameter of about 0.5 on average for the default resizing threshold of 0.75, although with a large variance because of* resizing granularity. Ignoring variance, the expected occurrences of list size k are (exp(-0.5)  pow(0.5, k) /* factorial(k)).

- http://www.ruanyifeng.com/blog/2015/06/poisson-distribution.html

- https://www.jianshu.com/p/64f6de3ffcc1
- https://stackoverflow.com/questions/10901752/what-is-the-significance-of-load-factor-in-hashmap







