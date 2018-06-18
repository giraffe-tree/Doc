# Collection

## 集合类的父接口

所谓的集合类就是一个容器库,以一定规则用来存放一系列对象。jdk将一些我们常用的容器进行了抽象,一步一步划分出了一颗基于父接口的庞大的‘集合树’。而这颗集合树的顶层就是我们现在讲的
```Collection```接口和它继承的```Iterable```接口.

## Iterable

为了更好的理解,我从最顶层的```java.lang.Iterable```接口开始讲起.

在jdk8以前,```java.lang.Iterable```只有一个方法: ```Iterator<T> iterator();``` , 它返回了一个迭代器对象.

而在java 8的时候,新加了两个默认方法:

1. ```default void forEach(Consumer<? super T> action){...}```
2. ```default Spliterator<T> spliterator(){...}```


	https://blog.csdn.net/jiangmingzhi23/article/details/78927552

