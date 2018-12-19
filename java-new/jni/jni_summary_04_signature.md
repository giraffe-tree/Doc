# JNI 总结 04 Signature

## 目标

1. 什么是 Signature?
2. 怎么使用 Signature

## 什么是 Signature

在 [JNI 总结 02 Windows 纯命令行调用 DLL](https://github.com/giraffe-tree/Doc/blob/master/java-new/jni/jni_summary_02_windows.md) 中有这样一段代码, 这是使用 `javah` 命令机器生成的一段代码.

```cpp
/*
 * Class:     HelloWorld
 * Method:    Hello
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_HelloWorld_Hello
  (JNIEnv *, jclass);
```

我们可以看到代码中有一个 `Signature: ()V`, 它是什么意思呢?

### 字节码解析

源码参见: [HelloWorld.java](https://github.com/giraffe-tree/play-jni/blob/master/src/main/java/com/github/giraffetree/playjni/chapter01/HelloWorld.java)

```sh
$ ls
HelloWorld.class  HelloWorld.java  README.md
$ javap -s HelloWorld
Compiled from "HelloWorld.java"
public class HelloWorld {
  public HelloWorld();
    descriptor: ()V

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V

  static {};
    descriptor: ()V
}
```

`javap -s` 的意思是: 输出内部类型签名

我们可以看到`HelloWorld()`的方法下面有个 `descriptor: ()V`, 这个描述符就是我们刚刚说的 `signature` 了.

在 java 中的方法定义如下

```
## ref -> https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
Definition: Two of the components of a method declaration comprise the method signature—the method's name and the parameter types.
```

在 JAVA 中方法由两部分组成: 1. 方法名  2. 参数类型 , 这里我提一句, 参数类型是有顺序的, 也就是说在 JAVA 中, 相同方法名相同参数类型(顺序一致)的方法即为同一个方法.

## 怎么使用 Signature

| 标识字符 |       含义       |
| :------: | :--------------: |
|    B     |  基本类型 byte   |
|    C     |  基本类型 char   |
|    D     | 基本类型 double  |
|    F     |  基本类型 float  |
|    I     |   基本类型 int   |
|    J     |  基本类型 long   |
|    S     |  基本类型 short  |
|    Z     | 基本类型 boolean |
|    V     |       void       |
|    L     |     对象类型     |

### 示例

1. 空返回

```java
public void say(Long a, String s) {
}

// -> (Ljava/lang/Long;Ljava/lang/String;)V
```

2. 原始类型返回

```java
public short say(long a) {
        return 0;
}
// ->  (J)S
```

3. 数组参数, 及`List<String>`返回

```java
public List<String> say(Long a, int[] arr, String... strings) {
        return null;
}
// (Ljava/lang/Long;[I[Ljava/lang/String;)Ljava/util/List;
```


## 参考

1. 下面这篇文章, 通过修改字节码, 在 jvm 上实现了 同方法名/同参数类型(顺序一致), 但方法的返回值不同.

	[Java语言层面和JVM层面方法特征签名的区别 及 实例分析](https://blog.csdn.net/tjiyu/article/details/53891813)

2. scala 实现相同 方法名, 相同参数, 不同返回值

	[Scala trait same method and argument with different return types](https://stackoverflow.com/questions/17888978/scala-trait-same-method-and-argument-with-different-return-types)


