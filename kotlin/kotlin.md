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

### 




