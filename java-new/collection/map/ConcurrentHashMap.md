# `ConcurrentHashMap`

## 参考

### 基础知识

1. 数组, 链表, 红黑树
2. Unsafe 包 CAS 操作
3. `volatile` 关键字

### 《Java源码分析》：ConcurrentHashMap JDK1.8

https://blog.csdn.net/u010412719/article/details/52145145

### 红黑树

https://www.sohu.com/a/201923614_466939

## 基本数据结构

数组 + 链表/红黑树 

### 数据结构

```java
transient volatile Node<K,V>[] table;
```

使用 `Node` 数组来存储数据, `Node`及它的下一个节点/子节点会组成一个链表或者红黑树

### 目的

1. 减少并发`put`时的冲突, 只对数组中的单个值加锁, 即减少锁影响的范围

2. 

## 构造方法

这里分析两个主要的构造方法

### `ConcurrentHashMap(int initialCapacity)`

```java
	public ConcurrentHashMap(int initialCapacity) {
        if (initialCapacity < 0)
        	// 初始化容量为负时, 抛出异常
            throw new IllegalArgumentException();
        // `MAXIMUM_CAPACITY = 1 << 30` , 2的30次
        // 这里 cap 的最大值为 `(1 << 31) -1`
        int cap = ((initialCapacity >= (MAXIMUM_CAPACITY >>> 1)) ?
                   MAXIMUM_CAPACITY :
                   tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));

        // 初始时, sizeCtl 为未来初始化之后的 table.length()
        // table 字段参见 数据结构标签下的 table 
        // 在 initTable()时, 会将 sizeCtl 作为 table 的长度 n, 并将 sizeCtl 置为 `n - (n >>> 2)`, 即 0.75 倍的表长度 
        // 在之后的操作中, sizeCtl 会作为 table 扩容的阈值, 在 put 操作后进行扩容.
        this.sizeCtl = cap;
    }
```

### `ConcurrentHashMap(int initialCapacity,float loadFactor, int concurrencyLevel)`

参数 `loadFactor` 描述的是 数据的密集程度, 一般来讲范围为 `(0,1)`. 如果你用大于 1 的 `loadFactor`, 那在之后的 `put`操作中, 可能需要重新扩容.

```java
    public ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
        if (!(loadFactor > 0.0f) || initialCapacity < 0 || concurrencyLevel <= 0)
            // 检查参数, 否则抛出异常
            throw new IllegalArgumentException();
        if (initialCapacity < concurrencyLevel)   // Use at least as many bins
            initialCapacity = concurrencyLevel;   // as estimated threads
        long size = (long)(1.0 + (long)initialCapacity / loadFactor);
        int cap = (size >= (long)MAXIMUM_CAPACITY) ?
            MAXIMUM_CAPACITY : tableSizeFor((int)size);
        // 与`ConcurrentHashMap(int initialCapacity)`相同的是, sizeCtl 也会作为 table 的长度
        this.sizeCtl = cap;
    }
```

`new ConcurrentHashMap(initialCapacity)` 其实就相当于 `new ConcurrentHashMap(initialCapacity, 0.66666667F, 1)`, 即 `loadFactor`为三分之二.


## `initTable()`

```java
	/**
     * Initializes table, using the size recorded in sizeCtl.
     */
    private final Node<K,V>[] initTable() {
        Node<K,V>[] tab; int sc;
        while ((tab = table) == null || tab.length == 0) {
            if ((sc = sizeCtl) < 0)
            	// 当有其他线程已经在初始化时, 让出cpu时间
                Thread.yield(); // lost initialization race; just spin
            	// cas 替换 sizeCtl 的值, -1 代表有一个线程正在初始化
            else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) {
                try {
                    if ((tab = table) == null || tab.length == 0) {
                    	// DEFAULT_CAPACITY 默认为 16
                        int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                        @SuppressWarnings("unchecked")
                        Node<K,V>[] nt = (Node<K,V>[])new Node<?,?>[n];
                        table = tab = nt;
                        // 
                        sc = n - (n >>> 2);
                    }
                } finally {
                    sizeCtl = sc;
                }
                // 个人
                break;
            }
        }
        return tab;
    }
```

### sizeCtl

1. `sizeCtl`, 它是一个 `transient`, `volatile` 变量, `transient` 代表它不做序列化, `volatile`保证了并发时的可见性, 即这个变量在某个线程中被修改,其他线程立即可见被修改的值, 具体可以查看 JVM 内存模型.

2. 数值代表的含义, `sizeCtl` 为0时, 代表`ConcurrntHashMap`并未被初始化.`sizeCtl`大于0时, 代表下一个需要 `resize`扩表的容量.


```java
	/**
     * Table initialization and resizing control.  When negative, the
     * table is being initialized or resized: -1 for initialization,
     * else -(1 + the number of active resizing threads).  Otherwise,
     * when table is null, holds the initial table size to use upon
     * creation, or 0 for default. After initialization, holds the
     * next element count value upon which to resize the table.
     */
    private transient volatile int sizeCtl;
```

### CAS

我们看到在 `initTable()` 中使用了 `U.compareAndSwapInt`, 它是 Unsafe 包的一个 native 方法

下面这段源码来自: [openjdk:unsafe.cpp](http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/prims/unsafe.cpp)

```c++
UNSAFE_ENTRY(jboolean, Unsafe_CompareAndSwapObject(JNIEnv *env, jobject unsafe, jobject obj, jlong offset, jobject e_h, jobject x_h))
  UnsafeWrapper("Unsafe_CompareAndSwapObject");
  oop x = JNIHandles::resolve(x_h);
  oop e = JNIHandles::resolve(e_h);
  oop p = JNIHandles::resolve(obj);
  HeapWord* addr = (HeapWord *)index_oop_from_field_offset_long(p, offset);
  oop res = oopDesc::atomic_compare_exchange_oop(x, addr, e, true);
  jboolean success  = (res == e);
  if (success)
    update_barrier_set((void*)addr, x);
  return success;
UNSAFE_END
```

下面这段源码来自: [openjdk:oop.inline.hpp](http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/oop.inline.hpp)

```c++
inline oop oopDesc::atomic_compare_exchange_oop(oop exchange_value,
                                                volatile HeapWord *dest,
                                                oop compare_value,
                                                bool prebarrier) {
// UseCompressedOops 是否使用压缩指针
// 通常64位JVM消耗的内存会比32位的大1.5倍，这是因为对象指针在64位架构下，长度会翻倍（更宽的寻址）。
// 对于那些将要从32位平台移植到64位的应用来说，平白无辜多了1/2的内存占用，这是开发者不愿意看到的。
// 幸运的是，从JDK 1.6 update14开始，64 bit JVM正式支持了 -XX:+UseCompressedOops 这个可以压缩指针，起到节约内存占用的新参数。
// 引自: http://www.iteye.com/topic/470404
  if (UseCompressedOops) {
    if (prebarrier) {
      update_barrier_set_pre((narrowOop*)dest, exchange_value);
    }
    // encode exchange and compare value from oop to T
    narrowOop val = encode_heap_oop(exchange_value);
    narrowOop cmp = encode_heap_oop(compare_value);

    narrowOop old = (narrowOop) Atomic::cmpxchg(val, (narrowOop*)dest, cmp);
    // decode old from T to oop
    return decode_heap_oop(old);
  } else {
    if (prebarrier) {
      update_barrier_set_pre((oop*)dest, exchange_value);
    }
    return (oop)Atomic::cmpxchg_ptr(exchange_value, (oop*)dest, compare_value);
  }
}
```



## final V putVal(K key, V value, boolean onlyIfAbsent) 

```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
                // 初始化表
                // 尽管 table 为volatile 变量, 但仍有可能有多个线程进入 initTable() 方法
                tab = initTable();

            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                // 通过 hash 就算出 value 所要存的数组索引 index 的位置
                // 如果 table[index] 为空, 则 compareAndSwapObject 插入值
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            // 
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            // 当前桶的大小, 能到这一步, 桶大小至少为 1
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                // 如果为元素 e 的key相同, 则根据是否 onlyIfAbsent, 进行插入, 有旧值, 就返回旧值,否则返回 null. 
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                // 循环, 直到 e.next 为空, 这是为了添加到链表尾部.
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        // 检查扩容
        addCount(1L, binCount)

```
private final void addCount(long x, int check) {
        CounterCell[] as; long b, s;
        if ((as = counterCells) != null ||
            !U.compareAndSwapLong(this, BASECOUNT, b = baseCount, s = b + x)) {
            CounterCell a; long v; int m;
            boolean uncontended = true;
            if (as == null || (m = as.length - 1) < 0 ||
                (a = as[ThreadLocalRandom.getProbe() & m]) == null ||
                !(uncontended =
                  U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))) {
                fullAddCount(x, uncontended);
                return;
            }
            if (check <= 1)
                return;
            s = sumCount();
        }
        if (check >= 0) {
            Node<K,V>[] tab, nt; int n, sc;
            while (s >= (long)(sc = sizeCtl) && (tab = table) != null &&
                   (n = tab.length) < MAXIMUM_CAPACITY) {
                int rs = resizeStamp(n);
                if (sc < 0) {
                    if ((sc >>> RESIZE_STAMP_SHIFT) != rs || sc == rs + 1 ||
                        sc == rs + MAX_RESIZERS || (nt = nextTable) == null ||
                        transferIndex <= 0)
                        break;
                    if (U.compareAndSwapInt(this, SIZECTL, sc, sc + 1))
                        transfer(tab, nt);
                }
                else if (U.compareAndSwapInt(this, SIZECTL, sc,
                                             (rs << RESIZE_STAMP_SHIFT) + 2))
                    transfer(tab, null);
                s = sumCount();
            }
        }
    }
```

        return null;
    }
```

### 注意

put方法会返回如下:

> the previous value associated with key, or null if there was no mapping for key

put 方法返回相同 key 先前的值, 如果是首次插入, 则返回 null

### 1. 空检查

`ConcurrentHashMap` 不允许空key或者空value

```java
if (key == null || value == null) throw new NullPointerException();
```

### 2. spread(hash(key))

### 3. binCount

桶大小

### 4. casTabAt

```java
static final <K,V> boolean casTabAt(Node<K,V>[] tab, int i,
                                        Node<K,V> c, Node<K,V> v) {
        return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
    }
```

### 5. treeifyBin(tab, i)

### 6. addCount(1L, binCount)

```java
private final void addCount(long x, int check) {
        CounterCell[] as; long b, s;
        // baseCount更新失败，则使用counterCells
        if ((as = counterCells) != null ||
            !U.compareAndSwapLong(this, BASECOUNT, b = baseCount, s = b + x)) {
            CounterCell a; long v; int m;
            boolean uncontended = true;
            if (as == null || (m = as.length - 1) < 0 ||
                (a = as[ThreadLocalRandom.getProbe() & m]) == null ||
                !(uncontended =
                  U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))) {
                fullAddCount(x, uncontended);
                return;
            }
            if (check <= 1)
                return;
            s = sumCount();
        }
        if (check >= 0) {
            Node<K,V>[] tab, nt; int n, sc;
            while (s >= (long)(sc = sizeCtl) && (tab = table) != null &&
                   (n = tab.length) < MAXIMUM_CAPACITY) {
                int rs = resizeStamp(n);
                if (sc < 0) {
                    if ((sc >>> RESIZE_STAMP_SHIFT) != rs || sc == rs + 1 ||
                        sc == rs + MAX_RESIZERS || (nt = nextTable) == null ||
                        transferIndex <= 0)
                        break;
                    if (U.compareAndSwapInt(this, SIZECTL, sc, sc + 1))
                        transfer(tab, nt);
                }
                else if (U.compareAndSwapInt(this, SIZECTL, sc,
                                             (rs << RESIZE_STAMP_SHIFT) + 2))
                    transfer(tab, null);
                s = sumCount();
            }
        }
    }
```




