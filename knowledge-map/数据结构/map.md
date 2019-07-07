# map

## 目标 - 用于复习检测

看看下面几个问题, 有哪些不了解的吧 =.= 

1. 了解 HashMap 实现
   
   1. `hashMap` 中 `static final hash(Object key)` 方法 (不是 `hashcode()` 方法 ) 有什么特别之处
   2. `put` 方法的原理, 流程 (这个问题包含了 hashmap 的数据结构)
   3. `put` 过程中, 哪些时候会导致 `resize` 扩容
   
2. 对比提升

   1. `hashmap` 和 `hashtable` 的差异

   2.  `HashMap`，`LinkedHashMap` 和 `TreeMap` 之间的区别

## 总结 - 用于巩固

### Map 接口

```java
public interface Map<K,V> 
```

### Map 实现 - HashMap

`HashMap` 可能是我们日常使用中最常用的几个工具类之一了.

#### 实现细节

这篇文章应该是我见过的讲 hashmap 比较好的文章了, 分析到位, 条理清晰 [Java-HashMap工作原理及实现](https://yikun.github.io/2015/04/01/Java-HashMap工作原理及实现/)

**讲过细节部分的我这里就不再赘述, 下面总结一些主要的**

1. `HashMap` 整体上采用 数组(bins) + 链表 (转红黑树) 的方式来排列元素

2. `hashMap` 中的 `static final hash(Object key)` 方法 (不是 `hashcode` 方法哦 ) 有什么特别之处

   - `(key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)` 将一些高位特征放入低位上, 以减少 hash 碰撞

   - 实际 hash 转为 数组的 index 采用 `index = (n - 1) & hash`

   - 上面的那篇文章中举了一个很好的例子, 但 hashmap 的 capicity 为 n=16 时

     > n-1 = 15 (0x1111)，其实散列真正生效的只是低4bit的有效位，当然容易碰撞了

3. `put(key,value)` 的大致流程

   1.  **第一次`put`时**, 会**初始化**数组 `Node<K,V>[] tab`
   2.  根据 `key.hash` 转为 tab 数组的下标, 如果该位置为空, 则直接新建 `Node` 插入
   3. 如果该位置对应的`Node` 不为空, 则检查该`Node` 的键是否与 key 相等, 如果相等, 则跳到第6步
   4. 如果该`Node` 的键与 key 不相等, 则检查是否为 `TreeNode` , 如果是则通过 `putTreeVal` 插入, 然后跳到第6步
   5. 如果不是 `TreeNode` 则遍历该链表, 直到找到该 `Node`或者到链表尾部, 到达尾部则直接插入, 并且检查是否达到`TREEIFY_THRESHOLD`, 如果是则 红黑树化
   6. 如果允许修改原有值, 则修改
   7. `modcount++` , `size++`, 这里所谓的 `size` 就是当前 map 存储的元素个数
   8. 且如果 `size`>= `threshold` (下一次扩容的阈值 `capacity * load factor`) 则进行扩容(resize)

4. `put` 方法可以接受 `null` 的 key , 并且它的 `hash` 为 0, 永远存在第一个 bin 中 

5. `resize`  扩容的实现

   - 把bucket扩充为2倍，之后重新计算index，把节点再放到新的bucket中
     - 为什么是两倍呢 (开放式问题)
       - 大部分原因是 权衡之后的, 也是为了一部分的实现简单, 高效
       - 快速确定哈希码进入的存储区 `int bucket = hashcode & (size-1);`
       - 更加容易理解的确定性
         - 参考 https://stackoverflow.com/questions/5040753/why-arraylist-grows-at-a-rate-of-1-5-but-for-hashmap-its-2?noredirect=1&lq=1
   - resize 的过程中, 即使一个 bin 中的元素, 被分为 2 个bin, 每个 bin 中的顺序还是不变的
   - resize 只会使 capacity 增加

   

**文章中没有涉及到的部分**

1. 除了外层的 `hash` 方法之外 , 用于存储数据的 Node 还有一个 `hash` 属性

   - 它会在初始化时, 被放入 `Node` 中, 目的是减少之后的 hash 运算

   - `Node`也有一个自己的 `hashCode` 方法 `Objects.hashCode(key) ^ Objects.hashCode(value);`

2. `instanceof` 看到 put 方法中有用到 `instanceof`, 突然对这个东西到底是怎么 work 的有点感兴趣

   - 在网上查了点资料, 看这篇就够了 https://www.zhihu.com/question/21574535
     - 当年刚刚学java时, 看这篇看到一半就看不下去了, 只是觉得 R大 NB!!!!!!!! 今天又看了一遍, 感觉底层上的实现比想象中要复杂的多, 最后还是那句话 R大 NB!!!!!!!!， hah
     - 目前我将它理解为类似于强制转换, 只不过返回不一样

3. `put` 过程中, 哪些时候会导致 `resize`

   1.  第一次 `put` 元素时
   2. 尝试树化,  却发现数组长度小于 `MIN_TREEIFY_CAPACITY`  (=64) 时
   3. 添加元素后, 发现 `size > threshold` , `size` 为 `map` 中 key  的个数, `threshold` 是下一次扩容的阈值

4. 单个 bin 红黑树化需要两个条件

   1. `binCount >= TREEIFY_THRESHOLD - 1` 当前 bin 中的元素大于 `(8-1=7)` 个 (`TREEIFY_THRESHOLD` 默认值为 8 )
   2. 当前 `tab.length >= MIN_TREEIFY_CAPACITY`, `MIN_TREEIFY_CAPACITY` 为 64, 当不满足这个条件时, 会进行 `resize` 扩容, 而不是树化

   - 并且需要知道的是, 所有的树化, 都在实际放入元素之后进行

5.  内部类 `KeySet`  -  `final class KeySet extends AbstractSet<K>`

   - `KeySet` 是 `HashMap` 的一个内部类
     - 它实现了 `Set` 接口, 但实际上都是在调用外部类 `HashMap` 或者其内部类的属性/方法/构造器
       - 除了一个`foreach` , 它每隔一个 `bin` 检查一次 `modcount`
     - `KeySet` 有一个 `iterator`  - `KeyIterator`
       -  `final class KeyIterator extends HashIterator`
       - 它是每取一个 `Node` 检查一次 `modcount`
   - 感觉 `HashMap` 是一个内部类使用的范例呀 =.=
   - 另外 `values()` , `entrySet()` 方法的实现和 `KeySet` 很类似, 都是使用了一个 继承 `HashIterator` 的迭代器, 只不过 `values()` 返回了 `value` , `entrySet()` 返回了 `Node`

6. `remove` 方法没有实现减小容量 =.= 



#### TreeNode

了解 `TreeNode` 先了解一点,  `TreeNode` 的实现, 占了 整个 `HashMap` 的 `1/4`(大约1800 行到 2400行) , 不要小看它哦

1. `TreeNode` 是一个红黑树

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

### 其他参考

#### 为什么 arraylist 以 1.5 倍递增, 而 hashmap 以 2倍 增加

https://stackoverflow.com/questions/5040753/why-arraylist-grows-at-a-rate-of-1-5-but-for-hashmap-its-2?noredirect=1&lq=1

#### hashmap 和 hashtable 的差异

1. `Hashtable`是[同步的](https://stackoverflow.com/questions/1085709/what-does-synchronized-mean)，而`HashMap`不是。这`HashMap`对非线程应用程序更有利，因为非同步对象通常比同步对象执行得更好。如果同步成为问题，您也可以查看[`ConcurrentHashMap`](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html)。或者 `Collections.synchronizedMap(myMap);` (当然它的效率没有 `ConcurrentHashMap` 高)
2. `Hashtable`不允许`null`键或值。 `HashMap`允许一个`null`键和任意数量的`null`值。
3. HashMap的子类之一是[`LinkedHashMap`](http://java.sun.com/javase/7/docs/api/java/util/LinkedHashMap.html)，所以如果您想要可预测的迭代顺序（默认情况下是插入顺序），您可以轻松地换出`HashMap`for `LinkedHashMap`。如果你使用的话，这并不容易基于`Hashtable` 实现。

复制的 google 翻译, 懒得打字了 hah

参考: 

- https://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable

#### 一种初始化 hashmap 的方法

双括号会创建一个匿名内部类

```java
HashMap<String, String> h = new HashMap<String, String>() {{
    put("a","b");
}};
System.out.println(h.getClass() == HashMap.class);  // false
```

虽然我认为这种方法很蠢....

参考:

- https://stackoverflow.com/questions/6802483/how-to-directly-initialize-a-hashmap-in-a-literal-way
- http://wiki.c2.com/?DoubleBraceInitialization

#### `HashMap`，`LinkedHashMap` 和 `TreeMap` 之间的区别

这三个类都实现了`Map`接口，并提供了大部分相同的功能。最重要的区别是条目的迭代顺序：

- `HashMap`绝对不保证迭代顺序。当添加新元素时，它甚至可以（并且将）完全改变。
- `TreeMap`将根据其`compareTo()`方法（或外部提供的`Comparator`）按键的“自然排序”进行迭代。此外，它实现了[`SortedMap`](http://java.sun.com/javase/6/docs/api/java/util/SortedMap.html)接口，该接口包含依赖于此排序顺序的方法。
  - `put/get` 的时间复杂度为 `O(log(n)) `
- `LinkedHashMap` 将按照条目放入地图的顺序进行迭代

参考:

- https://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap

#### 值与键的双向映射

想起来我之前用枚举类的时候, 想用 `value`  查找 `key`, 只能用遍历的故事...TT

```java
    public static void testBidiMap() {
        BiMap<Integer, String> bimap = HashBiMap.create();
        bimap.put(1, "一");
        bimap.put(2, "二");
        Integer num = bimap.inverse().get("一");
        System.out.println(num);
    }
```

记得加入 [guava](https://github.com/google/guava) 依赖啊

参考: 

- https://stackoverflow.com/questions/1383797/java-hashmap-how-to-get-key-from-value

#### Stack Overflow 上 高赞的 hashmap 题目

https://stackoverflow.com/search?q=hashmap





