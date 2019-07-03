# queue

## 目标 - 用于复习检测

1. 了解 queue 和 deque 的区别
2. java 标准库中的实现(不涉及并发)

	- PriorityQueue
	  - 大致原理: 内部数据结构, 如何实现最小堆
	  - 画出 add 元素的示意图, 从 6 添加到 1
	  - 画出 poll 元素的示意图
	  - modcount 的作用
	- LinkedList
	- ArrayDeque
3. 扩展知识点
   - `System.arraycopy` 是如何实现的?

## 总结 - 用于巩固

###  queue 和 deque 的区别

queue (队列) 一般来讲是一个先入先出（FIFO）的数据结构

deque是双端队列，是可以在两端扩展和收缩的连续容器。一般deque的实现是基于某种形式的动态数组，允许单个元素用随机获取

### queue 接口

```java
public interface Queue<E> extends Collection<E>
```

| 接口    | return  | 作用         | 备注                                  |
| ------- | ------- | ------------ | ------------------------------------- |
| add     | Boolean | 添加元素     | 队列满时, 抛出异常                    |
| offer   | Boolean | 添加元素     |                                       |
| remove  | E       | 删除队首元素 | 队列空时, 抛出 NoSuchElementException |
| poll    | E       | 删除队首元素 | 队列空时, 返回null                    |
| element | E       | 查看队首元素 | 队列空时, 抛出 NoSuchElementException |
| peek    | E       | 查看队首元素 | 队列空时, 返回null                    |

### queue 的实现 - PriorityQueue

java中的队列实现: `PriorityQueue` (优先队列)

#### 实现细节总结

1. 队列中的元素需要实现比较器或者指定一个比较器

   - 如果两种都没有, 则会抛出异常 ClassCastException

2. 实现 offer 中如果为 null , 会抛出 NullPointerException

   - 如果仅仅从添加元素来看, 只要实现了支持 null 比较的比较器, 也是可以的
   - 但从删除队首元素来看, null 的元素会导致一些异常, 需要一些其他处理
   - 可能实现者综合考虑下来, 还是选择不能添加 null 元素

3. 内部使用 `Object[]` 数组实现, 实际上是一个最小堆(2叉树), 堆顶的元素最小

4. 自动扩容, 默认容量 11

   - 低于 64 时, `oldCapcity*2+2` ; 大于等于64时 `oldCapcity + (oldCapcity>>1)`
   - 简单的来说, 低于 64 时, 2倍扩容, 高于64时, 1.5 倍扩容
   - 数据迁移使用 `System.arraycopy` 实现

5. 方法比较 `add = offer`,  `remove` 比 `poll` 多抛出一个异常

6. 添加元素使用到了 2分法, 从而保证了该树的每一颗子树的根节点都是该子树中最小的点

   - 简单的来说, 添加元素是从下往上交换元素, 时间复杂度为 `logn`
   - 与之对应的, 删除队首元素, 是从上往下交换元素, 时间复杂度也是 `logn `

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
|addFirst|void|添加元素|队列满时, 抛出异常|
|addLast|void|添加元素|队列满时, 抛出异常|
|offerFirst|boolean|添加元素||
|offerLast|boolean|添加元素||
|removeFirst|E|删除队首元素|队列空时, 抛出 NoSuchElementException|
|removeLast|E|删除队尾元素|队列空时, 抛出 NoSuchElementException|
|pollFirst|E|删除队首元素|队列空时, 返回null|
|pollLast|E|删除队尾元素|队列空时, 返回null|
|push|void|添加元素||
|pop|E|删除元素||
|descendingIterator|Iterator<E>|反向迭代|这个比较好玩 =.=|

### deque 实现 - ArrayDeque












