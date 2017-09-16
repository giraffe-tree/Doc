# Java 8

参考：《Java 8 in action》

## 第一章 为什么关心 Java 8 

java8 中给我们带来了很多的改变：

- Stream Api 支持处理数据的并行操作（需要两点：1.不共享的可变数据 2.向方法传递代码的能力）
- 可以向方法传递代码  也就是说行为参数化
- 接口可以支持实现默认方法


我们可以直接调用Apple中的isGreenApple方法判断

```
List<Apple> list1 =apples.parallelStream()
	.filter(Apple::isGreenApple ).collect(Collectors.toList());

```

我们也可以自定义 filterApples的

``` 
for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				apples.add(apple);
			}
}

``` 

来进行判断

```
List<Apple> list3 = filterApples(apples, 
	(Apple a) -> a.getWeight() < 200 || "green".equals(a.getColor()));

```

也可以通过将list转为stream进行过滤操作

```
List<Apple> list4 =apples.stream()
	.filter((Apple a) -> a.getWeight() < 200 ).collect(Collectors.toList());

```


**编程语言，要不改变，要不衰亡。** 或者我想在后面加一句，人也是一样。

## 第二章 通过行为参数化传递代码















