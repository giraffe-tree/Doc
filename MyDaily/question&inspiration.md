# question & inspiration

## 2018/05/28

read 深入理解java虚拟机

1. JIT编译器  P241
2. spring dispatch servlet 具体执行顺序
3. spring transaction 为什么能达到事务
4. 操作数栈与局部变量表的共享区域 P243
5. spring boot 2.0 Test

## 2018/05/29

1. 框架是如何注册 bean 的
2. lombok 使用
3. 动态代理 Dynamic proxy

## 2018/05/30

1. 反射

	https://www.sczyh30.com/posts/Java/java-reflection-1/#%E4%B8%80%E3%80%81%E5%9B%9E%E9%A1%BE%EF%BC%9A%E4%BB%80%E4%B9%88%E6%98%AF%E5%8F%8D%E5%B0%84%EF%BC%9F

	http://www.importnew.com/21211.html java反射在jvm的实现

2. invoke
3. G1 CMS
4. 尝试写一个简单的mvc框架
	
	bean 注册
	aop 实现


## 2018/05/31

1. jdk 动态代理

	```System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");```  没生成文件?

2. Arduino机器人权威指南
3. jit 编译器

	https://www.cnblogs.com/insistence/p/5901457.html

4. 接口限制 65535
5. javac 编码GBK的不可映射字符

	 ```javac -encoding utf-8 Test.java```

6. 查看 javac 源码
7. 编译器插件
8. 从表及里学习jvm
	
	- https://www.douban.com/doulist/2545443/
	- 自制编程语言

## 2018/06/01

1. kotlin 

	- hello world √
	- spring boot √

2. java 语法糖
	
	- 自动拆装箱
	- 泛型
	- switch String

## 2018/06/03

1. 算法基础

	数据结构是算法的副产品或是结果

2. 计算二次函数的解
	
	递归执行?

3. java char 两个字节
4. 方法调用时,是值传递还是引用传递
5. java.lang包 不用导 
6. 句柄 指针的指针

## 2018/06/04

1. kotlin koans

	https://github.com/Kotlin/kotlin-koans
	https://try.kotlinlang.org/#/Kotlin%20Koans/Introduction/Hello,%20world!/Task.kt

## 2018/06/05

1. kotlin 编译慢  √

	org.gradle.daemon=true
	kotlin.incremental=true 

	https://droidyue.com/blog/2018/01/31/how-to-speed-up-kotlin-compilation/

## 2018/06/06

## 2018/06/07

## 2018/06/08

1. kotlin 20小时

	将对象和函数分开
	2 + 

2. codewars 刷题

## 2018/06/11

1. redis 密码验证失败,可能原因排查  √
	
	密码加单引号解决

2. mysql 事务是怎么实现的

	https://www.cnblogs.com/songjy2116/p/7881294.html

## 2018/06/12

1. kotlin 中的扩展方法并不能访问私有成员,实质上为静态函数,所以不能被子类重写

2. kotlin 展开运算符 P60 

	```listOf("args:",*args)```

## 2018/06/13

1. java8还提供了parallelStream()来启动并行流式处理，parallelStream()本质上基于java7的Fork-Join框架实现，其默认的线程数为宿主机的内核数

2.

## 2018/06/14

1. ForkJoinPool

2. Java中普通lambda表达式和方法引用本质上有什么区别？

	https://www.zhihu.com/question/51491241/answer/126232275

3. https://stackoverflow.com/tags/scala/info

1. lambda 匿名函数的区别
	
	- 匿名类中 this代表类本身,而lambda中代表的是包含类
	- 匿名类可以屏蔽包含类的变量,而lambda不能屏蔽,而且会报编译错误
	- http://dig.cs.illinois.edu/papers/lambdaRefactoring.pdf

2. lambda debug 困难

3. 默认方法和多继承

4. 二进制级兼容性, 源代码,函数行为

5. 抽象接口,必须由接口继承

6. 函数式接口只含有一个抽象方法,默认方法是非抽象方法



## 2018/06/15

1. java 中接口的静态方法

	- 竟然可以没有实现就直接调用!

2. 柯里化 
	
	- 接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数

3. 模式匹配 / switch

4. 引用的透明性原则:
	
	使用相同的参数产生同样的结果

5. ```javap -v xxx.class``` 打印class文件详情

6. 如何分流?

	- spliterator 会返回集合类型而不是单纯的stream
	- 

7. java 静态接口

	静态内部

8. 并发与并行

	- 多线程的上下文切换
	- 线程间的调度和切换的成本远远小于进程

## 2018/06/18

1. transient 与序列化

2. java 泛型数组,避免对象游离(利于垃圾回收)

## 2018/06/19

1. 静态内部类和内部类

	反编译后:

	```
	class Test$NormalTest {
	    Test$NormalTest(Test var1) {
	        this.this$0 = var1;
	    }
	}
	class Test$StaticTest {
	    Test$StaticTest() {
	    }
	}
	```

2. java中的逆变与协变 covariant

	```
	List<? extends Number> list = new ArrayList<Number>();
        list.add(new Integer(1)); //error
	```

	协变就是用一个窄类型替代宽类型
	逆变则用宽类型覆盖窄类型。

	故此处用```? super Number```

	https://blog.csdn.net/u014717036/article/details/52234679

3. Java OutOfMemoryError 

	```int[] ints = new int[Integer.MAX_VALUE];```
	```java -Xmx10M Test```

4. alibaba 编码规约

	插件下载

5. ```MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;```

6. 为什么 ArrayList 中使用```Object[]```存储元素,而不是使用泛型```E[]```
	
	https://stackoverflow.com/questions/25695011/why-does-arraylist-use-object-instead-of-e-internally

	不能创建泛型数组


	```
		public class Apple<T> {
	    int capacity;
	    T[] ts;
	    @SuppressWarnings(value = "unchecked")
	    public Apple(Class<T> clazz, int capacity) {
	        this.capacity = capacity;
	        this.ts = (T[]) Array.newInstance(clazz, capacity);
	    }
	```

7. 在jvm上实现 generics

8. scala 的起源 

	https://www.artima.com/scalazine/articles/origins_of_scala.html

9. 泛型和协变的关系

10. @Contract(value="",pure=true)

	https://zhuanlan.zhihu.com/p/24778947

	https://www.jetbrains.com/help/idea/contract-annotations.html


## 2018/06/20

1. ```Class JavaLaunchHelper is implemented in both```

	```idea.no.launcher=true```


## 2018/06/21

1. mysql 正则 

	```
	SELECT * FROM report where algorithm regexp '\"xxxx\":[1-9]';
	```

2. 




