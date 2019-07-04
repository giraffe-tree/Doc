# map

## 目标 - 用于复习检测

1. 了解 HashMap 实现
2. LinkedHashMap 实现



## 总结 - 用于巩固

### Map 接口

```java
public interface Map<K,V> 
```

### Map 实现 - HashMap

`HashMap` 可能是我们日常使用中最常用的几个工具类了.

#### 实现细节







#### 有趣的问题 - 泊松分布与 hashmap

`DEFAULT_LOAD_FACTOR` 为什么是 0.75 ?

简单的来说, 默认加载因子（0.75）在时间和空间成本之间提供了良好的权衡。

然而, jdk 注释中提供了一些有意思的参考

> ```
> Ideally, under random hashCodes, the frequency of nodes in bins follows a Poisson distribution (http://en.wikipedia.org/wiki/Poisson_distribution) with a parameter of about 0.5 on average for the default resizing threshold of 0.75, although with a large variance because of* resizing granularity. Ignoring variance, the expected occurrences of list size k are (exp(-0.5)  pow(0.5, k) /* factorial(k)).
> ```

从泊松分布来看

参考下下面Stack Overflow 上的解释: 

当一个bucket空和非空的概率为0.5, 得到这个loadfactor的值为log(2) , 大约等于 0.693

- http://www.ruanyifeng.com/blog/2015/06/poisson-distribution.html

- https://www.jianshu.com/p/64f6de3ffcc1
- https://stackoverflow.com/questions/10901752/what-is-the-significance-of-load-factor-in-hashmap



### Map 实现 - LinkedHashMap





