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


## 第四章 流与集合

### 流和集合的区别

TODO：
流： 从支持数据处理操作的源生成的元素序列
流的目的在于表达计算，而集合讲的数据
集合中是以特定的时间、空间复杂度来存储和访问元素

### 流只能遍历一次

比如：

```
		Stream<String> stream1 = dishes.stream().map(Dish::getName);
		stream1.forEach(System.out::println);
		stream1.forEach(System.out::println);
```

会产生以下问题：

```
java.lang.IllegalStateException: stream has already been operated upon or closed
```

流只能消费一次，当流遍历一次后需要重新从原始的数据源获得一个流

### 内部迭代

当你使用外部迭代，就是显式地使用foreach，就需要我们自己进行并行实现和数据表示

而java 需要一个没有迭代器的接口，且需要进行简单的并行问题，于是就有了 Stream

stream是使用内部迭代的，内部迭代可以自动选择一种适合你硬件的数据表示和并行实现,你不需要进行显式地管理数据集合的迭代了

### 流操作

- filter
- map
- limit
- sorted
- distinct

### 终端操作

- forEach
- count
- collect 可以进行转换，
	- 例如：转换成List:  ```collect(Collectors.toList());```


## 第五章 使用流

### 对流进行筛选、切片

- filter
- distinct  返回不重复的元素
- skip  跳过前面的几个元素
- limit  限制输出

### 提取转换liu

- map
- flatmap

### 查找流中的元素

- findFirst
- findAny
- allMatch
- noneMatch
- anyMatch

### 归约

- reduce

可以用来计算 总和，最大值，最小值

无状态操作：

> 例如map，filter等不会知道这个操作之前发生了什么 

有状态操作

> 例如reduce,sorted，skip，limit，distinct等需要将一定的数据放入缓存才能工作

### 原始类型流特化

- IntStream
- LongStream
- DoubleStream

为什么要存在这些原始类型流呢？
> 为了效率，因为装箱的复杂，int和integer的效率差异

#### 原始类型流 -> Stream

> intStream.boxed()

#### Stream -> 原始类型流

> stream.mapToInt(...)


### iterate 与 generate

**generate**

```
Stream.generate(Math::random).limit(10).forEach(System.out::println);
```

**iterate**

```
Stream.iterate(new int[]{0,1}, t->new int[]{t[1],t[0]+t[1]}).skip(10).limit(10).forEach(t->System.out.println(t[0]+"  "+t[1]));
```

## 第6章 用流收集数据

### 收集器










## 第12章 时间和日期函数

### LocalDate 

1. 获取现在的日期
	> 	LocalDate today = LocalDate.now();

2. 返回指定的日期
	>  LocalDate birthday = LocalDate.of(2009, 07, 20);
	> LocalDate parse = LocalDate.parse("2017-07-20");


3. 获取日期加减后的日期,可以加减一个月

```
LocalDate testMin = today.minus(1, ChronoUnit.MONTHS)
		.minus(1,ChronoUnit.DAYS).plus(1, ChronoUnit.YEARS);
LocalDate finalDate   = LocalDate.now().plus(Period.ofMonths(2));

```

4. 判断是否是闰年
	>  boolean leapYear = LocalDate.now().isLeapYear();

5. 返回一个日期是星期几，在一个月中的第几天
	> 	DayOfWeek dayOfWeek = testMin.getDayOfWeek();


6. 判断日期之间的前后关系，是否是同一天
	>  boolean isAfter = testMin.isAfter(today);


### LocalTime

1. 获取现在的时间
	> LocalTime now = LocalTime.now();

2. 解析字符串，转化为时间
	> int hour = LocalTime.parse("15:02").getHour();


3. 创建时间
	>  LocalTime nowTime = LocalTime.of(15, 02);

4. 对时间进行加减
	> LocalTime nextHour = LocalTime.now().plus(1, ChronoUnit.HOURS);

5. 检查时间的前后关系
	> boolean isBefore = LocalTime.now().isBefore(LocalTime.now());


### LocalDateTime

普通方法同LocalDate,LocalTime

#### 日期格式化

字符串转日期

```
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

LocalDateTime localDateTime = LocalDateTime.parse("2017.07.20 15:27:44", dateTimeFormatter);
```

日期转字符串

```
DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yy-MM-dd");
String today = LocalDateTime.now().format(dateTimeFormatter2);

```


计算两个时间的间隔

> long between = ChronoUnit.DAYS.between(initialDate, finalDate);

#### localdate 转 date

1）使用ZonedDateTime将LocalDate转换为Instant。
2）使用from（）方法从Instant对象获取Date的实例

```
		ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());
```


#### date 转 localdate

1）将java.util.Date转换为ZonedDateTime。
2）使用它的toLocalDate（）方法从ZonedDateTime获取LocalDate。


```
 		Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
```

#### localdatetime -> timestamp

```
Timestamp.valueOf(LocalDateTime.now()).getTime()
```

## 其他参考

#### 深入理解Java 8 Lambda（语言篇——lambda，方法引用，目标类型和默认方法）

http://www.cnblogs.com/figure9/p/java-8-lambdas-insideout-language-features.html



















