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

行为化参数：一种软件开发模式，感觉有点像策略模式，就是通过对象传递的，使用的是匿名内部类，然后使用lambda表达式简化代码量。

Lambda 像是一种表达式语言(Expression Lauguage)，通过编译器，然后生成代码。（这个理解有待考证）

-> 的前面部分是方法传入的参数
-> 的后面部分是方法体

```
 (Apple a) -> a.getWeight() < 200 
 
```


## 第三章 Lambda 表达式

Lambda 表达式是一种匿名函数，可以简洁地传递代码

有一些通用的接口，已经定义在java.util.function包中

- predicate
- consumer
- supplier
- function

为了避免装箱，还提供了
- intPredicate
- IntToLongFunction

```
		List<Apple> apples = new Apple().getApples();
		//plan A  写一个实现 comparator 接口的类
		//如：class AppleComparator implements Comparator<Apple>{...}
		apples.sort(new AppleComparator());
		
		//plan B 调用匿名内部类
		//实现comparator 的 compare 方法
		
		//plan C Lambda 表达式
		apples.sort((a1,a2)->a1.getWeight()-a2.getWeight());
		apples.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));
		apples.sort(Comparator.comparing((a)->a.getWeight()));

		//plan D 使用方法引用
		apples.sort(Comparator.comparing(Apple::getWeight));

		//逆序 reversed 是对之前的顺序进行完全的反转
		apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getName));
		
```

### 函数式接口

Java8 允许接口中含有非抽象方法，这种在接口中使用default修饰的非抽象方法称为默认方法，默认方法也不会影响函数式接口的特性。我们依然可以认为它是一个函数式接口。

A default method cannot override a method from java.lang.Object 







