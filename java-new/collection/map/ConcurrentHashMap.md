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


1. 


## final V putVal(K key, V value, boolean onlyIfAbsent) 

```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
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
        addCount(1L, binCount);
        return null;
    }
```

### 注意

put方法会返回如下:

> the previous value associated with key, or null if there was no mapping for key

### 1. 空检查

`ConcurrentHashMap` 不允许空key或者空value

```java
if (key == null || value == null) throw new NullPointerException();
```

### 2. spread(hash(key))




