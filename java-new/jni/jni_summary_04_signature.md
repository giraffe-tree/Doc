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

在 JVM 字节码规范中规定了

