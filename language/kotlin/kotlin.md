# Kotlin

1..1

## 参考

https://try.kotlinlang.org/#/Kotlin%20Koans/Introduction/Java%20to%20Kotlin%20conversion/Task.kt

## 痛点

### 重载问题

在平常写一些工具类的时候, 我们经常会为一种方法,提供多种参数形式的输入,也就是我们常说的重载. 原理就是我们为一个需要多参数输入的方法,提供一些默认的参数,让我们更加方便简单的使用它.扩展的来说 Spring Boot 的默认大于配置也是这种思想.


![Apache Commons ArrayUtils 重载](https://github.com/giraffe-tree/Doc/blob/master/img/kotlin/ArrayUtilsOverload.png)

对于这些方法,在kotlin中我们可以这样定义

```
fun indexOf(a: DoubleArray, b: Double, c: Int = 0, d: Double=1.0) {
    // xxxx
}
```

对于这些方法,我们可以使用指定默认值来减少函数的书写.

## 函数

### 扩展方法/属性

扩展函数不存在重写,因为它们会被当做java中的静态函数处理

### 局部函数

在函数内嵌套函数  -> 或者说是内部类(非静态)

它可以直接访问外部类的属性

### 集合类

```
    val list = listOf(1, 2, 3, 4, 5)
    println(list)
    val set = setOf(1, 2, 3, 4)
    println(set)
    // 中缀调用
    val mapOf = mapOf(1 to "123",2 to "dsadsa")
    println(mapOf)
```

### 展开数组 ```*```

```kotlin
    val array = arrayOf(1, 2, 3)
    val listOf = listOf(*array)
    println(listOf)
```

### 中缀表达式

```kotlin
public infix fun <A, B> A.to(that: B): kotlin.Pair<A, B> { /* compiled code */ }
```

### 解构声明

```kotlin
val list = listOf(1, 2, 3, 4)
    for ((index, element) in list.withIndex()) {
        println("$index : $element")
    }
```

### 三重引号 不需要转义符号

但可以使用 ```$变量名```

```kotlin
val s =	 "dsada.asdasda.eqwe-da.sdsae.-"
val s1 = """dasd/das/x.dsa.eweq.xsad/q.e-/ds.d/="""
println(s.split("."))
println(s1.split("/"))
```

## 类/接口

### 接口的默认方法

```kotlin
interface Eat {
    fun eat(food: String)
    fun want(food: String) = println("i want to eat $food ...")
}
// 使用冒号: 代替 implements
class People : Eat {
    // 必须加上 override 否则将不能通过编译 
    override fun eat(food: String) {
        println("people eat $food....")
    }
}
```

1. java中实现含有相同方法名的,包含默认实现的接口

	- 当所有接口都实现了默认方法,报错: ```类 Test从类型 Walk 和 Run 中继承了run() 的不相关默认值```
	- 当至少一个接口没有实现默认方法,报错: Test不是抽象的, 并且未覆盖Walk中的抽象方法run()
	- 编译不通过强制我们去实现它

2.  可以调用java8中的默认方法

### final 修饰符

要么为继承做好设计并记录文档, 要么禁止继承加上 final 关键字

1. final 修饰的类无法被继承
2. final 修饰的方法无法被重写

|修饰符|评注|
|:---:|:---:|
|final|默认,不能被重写|
|open|可以被重写|
|abstract|必须被重写|
|override|重写父类或接口中的成员|

### 可见性修饰符

|修饰符|评注|
|:---:|:---:|
|public|默认,所有地方可见|
|internal|模块中可见|
|protected|子类中可见|
|private|当前类中可见|

扩展函数不能访问private/protected 的函数

在java中 protected 成员除了可以被子类访问,还可以被包只的其他类使用.
而kotlin中 protected 成员只能被子类访问

但kotlin调用java的代码时,protected的java成员是可以被访问到的

#### java/kotlin 可见性的区别

1. kotlin 中没有包私有的可见性
2. java中外部类能访问内部类的私有变量,而kotlin不行



