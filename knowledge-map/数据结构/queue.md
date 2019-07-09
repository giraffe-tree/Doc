# queue

## 目标 - 用于复习检测

1. 了解 queue 和 deque 的区别
2. java 标准库中的实现(不涉及并发)

	- PriorityQueue
	  - 大致原理: 内部数据结构, 如何实现最小堆
	  - 画出 add 元素的示意图, 从 6 添加到 1
	  - 画出 poll 元素的示意图, 从 1 到 6
	  - modcount 的作用
	- ArrayDeque
	    - 大致原理: 内部数据结构
	    - 扩容原理
	- LinkedList
	    - 大致原理: 内部数据结构
3. 扩展知识点
   - `System.arraycopy` 为什么快?

## 总结 - 用于巩固

###  queue 和 deque 的区别

queue (队列) 一般来讲是一个先入先出（FIFO）的数据结构

deque是双端队列，是可以在两端扩展和收缩的连续容器。一般deque的实现是基于某种形式的动态数组，允许单个元素用随机获取

### queue 接口

```java
public interface Queue<E> extends Collection<E>
```

| 接口    | return  | 作用         | 备注                                   |
| ------- | ------- | ------------ | -------------------------------------- |
| add     | Boolean | 添加元素     | 队列满时, 抛出异常(不同实现可能不一致) |
| offer   | Boolean | 添加元素     |                                        |
| remove  | E       | 删除队首元素 | 队列空时, 抛出 NoSuchElementException  |
| poll    | E       | 删除队首元素 | 队列空时, 返回null                     |
| element | E       | 查看队首元素 | 队列空时, 抛出 NoSuchElementException  |
| peek    | E       | 查看队首元素 | 队列空时, 返回null                     |

### queue 的实现 - PriorityQueue

`PriorityQueue` (优先队列) : **一个基于数组的, 自动扩容的优先队列**

#### 实现细节总结

1. 队列中的元素需要实现比较器或者指定一个**比较器**

   - 如果两种都没有, 则会抛出异常 ClassCastException

2. 实现 offer 中如果为 null , 会抛出 NullPointerException

   - 如果仅仅从添加元素来看, 只要实现了支持 null 比较的比较器, 也是可以的
   - 但从删除队首元素来看, null 的元素会导致一些异常, 需要一些其他处理
   - 可能实现者综合考虑下来, 还是选择不能添加 null 元素

3. 内部使用 **`Object[]` 数组**实现, 实际上是一个最小堆(2叉树), 堆顶的元素最小

4. 自动扩容, **默认容量 11**

   - 低于 64 时, `oldCapcity*2+2` ; 大于等于64时 `oldCapcity + (oldCapcity>>1)`
   - 简单的来说, 低于 64 时, 2倍扩容, 高于64时, 1.5 倍扩容
   - 数据迁移使用 `System.arraycopy` 实现

5. 方法比较 `add = offer`,  `remove` 比 `poll` 多抛出一个异常

6. 添加元素使用到了 2分法, 从而保证了该树的每一颗子树的根节点都是该子树中最小的点

   - 简单的来说, 添加元素是从下往上交换元素, **时间复杂度为 `log n`**
   - 与之对应的, 删除队首元素, 是从上往下交换元素, 时间复杂度也是 `log n `

7. 在 `add/offer/remove/poll` 时会修改 `modcount` 

   - 当`modcount` 改变时, 表明当前容器已经被修改
   - 该字段主要用于迭代器, 当内容被修改时, 快速失败(fast-fail)
   	- 参考:  https://stackoverflow.com/questions/1668901/java-modcount-arraylist
   - 当`PriorityQueue`的迭代器时, 每次调用 `next()`, 都会检查迭代器新建时的 `expectedModCount` 和当前的`modcount` 是不是一致, 否则抛出 `ConcurrentModificationException`
   - 示例代码如下

   > ```java
   >     public static void testPriorityQueue() {
   >         PriorityQueue<Integer> queue = new PriorityQueue<>(128);
   >         Iterator<Integer> iterator = queue.iterator();
   >         queue.add(1);
   >         // throw ConcurrentModificationException
   >         iterator.next();
   >     }
   > ```



### deque 接口

```java
public interface Deque<E> extends Queue<E>
```

因为方法太多, 这里仅列出一部分


| 接口    | return  | 作用         | 备注                                  |
| ------- | ------- | ------------ | ------------------------------------- |
|addFirst|void|添加元素|队列满时, 抛出异常 (不同实现可能不一致)|
|addLast|void| 添加元素     |队列满时, 抛出异常 (不同实现可能不一致)|
|offerFirst|boolean|添加元素||
|offerLast|boolean|添加元素||
|removeFirst|E|删除队首元素|队列空时, 抛出 NoSuchElementException|
|removeLast|E|删除队尾元素|队列空时, 抛出 NoSuchElementException|
|pollFirst|E|删除队首元素|队列空时, 返回null|
|pollLast|E|删除队尾元素|队列空时, 返回null|
|push|void|添加元素|可以作为 stack 使用|
|pop|E|删除元素||
|descendingIterator|Iterator<E>|反向迭代|这个比较好玩 =.=|

### deque 实现 - ArrayDeque

`ArrayDeque` : **自动扩容的, 基于数组的双端队列**

#### ArrayDeque 实现细节

1. 内部使用数组`Obejct[]`实现 

    - 使用 `head`,`tail` 两个指针标识实际数据的开始和结尾

2. 关于运行效率, jdk文档中有提到

    - 当`ArrayDeque` 作为 `stack`时, 会比需要同步的 `java.util.Stack` 运行的更快
    - 当`ArrayDeque` 作为 `queue` 时, 它比`java.util.LinkedList` 运行的更快

3. `fast-fail` 迭代器

    - 迭代器使用 `tail` 或 `head` 的 数组 `index` 值是否修改, 来进行`fast-fail`判断 , 顾不能保证没有并发修改

    - 另外在源码注释中也有提到,  `fast-fail` 不能保证一定没有并发修改, 只应该用于及时发现错误

    - `Fail-fast iterators throw {@code ConcurrentModificationException} on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be used only to detect bugs`

4. 容量与自动扩容

    - 初始容量默认: 16
    - 最小容量: 8
    - 容量始终为 2 的指数次方, 如:16,32,64,128...
    - 始终扩容到原先的 2倍
    - 数据迁移使用 `System.arraycopy` 实现, 扩容后, head会指向数组的第一个元素

5. 不允许添加 null 元素
6. 其他思考

    - 为什么容量要为 2的指数次方
        - 我想的是: 在计算实际 size 时, 能够更快 `size=(tail - head) & (elements.length - 1);`
            - `ArrayDeque `并没有一个 size 作为变量存储下来
        - 在实现上, 扩容更加方便, 由于扩容消耗很大, 尽量减少扩容的次数可能是一个很好的选择, 虽然这可能导致内存占用比较多
        - 其他理由嘛, 好吧, 暂时没想到

### deque 实现 - LinkedList

`LinkedList` : 双向链表, 实现了 `List`/`Deque` 接口

#### LinkedList 实现细节

1. 使用 `first`, `last` 两个指针指向第一个/最后一个元素, 用于存储数据的Node, 有 `prev`, `next` 两个指针
2. `LinkedList` 也使用 `modCount` 来实现 `fast-fail`

LinkedList 比较简单 =.=

### 为什么使用`System.arraycopy` 

`system.arraycopy` 使用本地实现, 它会**直接复制内存块**, 理论上比 for 循环复制要快

参考:

- https://stackoverflow.com/questions/18638743/is-it-better-to-use-system-arraycopy-than-a-for-loop-for-copying-arrays



## 其他

### java 版本号

`java version "1.8.0_191"`