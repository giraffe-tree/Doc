# JAVA 是解释执行的么

首先说结论: 一般情况下, java 解释执行和编译执行两种都有.

有以下几种情况

## 一般

java 代码编译成字节码, 然后 jvm 执行字节码 (解释执行), 并且在运行时会使用 JIT 即时编译器 (编译执行).

我们可以看一下java的命令

```sh
$ java -version
java version "1.8.0_191"
Java(TM) SE Runtime Environment (build 1.8.0_191-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.191-b12, mixed mode)

$ java -X
    -Xmixed           混合模式执行 (默认)
    -Xint             仅解释模式执行
```

从上面可以看到, 我使用的是 jdk 1.8, 默认使用混合模式， 解释和执行都有.

```sh
$ ./java -version
java version "11.0.1" 2018-10-16 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.1+13-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.1+13-LTS, mixed mode)

$ ./java -X
    -Xcomp            在首次调用时强制编译方法
    -Xmixed           混合模式执行（默认值）
    -Xint             仅解释模式执行
```

openjdk 11 多出了一个 `-Xcomp`的参数, 关于 `-Xcomp`和`-Xbatch` 可以查看[java-vm-tuning-xbatch-and-xcomp on stackoverflow](https://stackoverflow.com/questions/3369791/java-vm-tuning-xbatch-and-xcomp), 使用`-Xcomp`的效果可能不一定比 JIT编译器 编译的效果好, 或者这样说 JIT编译器在运行时收集了更多的信息, 所以理论上编译优化的效果更好.

另外关于, JIT just-in-time Compiler, jdk 1.8 内置了两个 JIT Compiler -- C1, C2, C1 适合于对启动速度敏感的应用, C2 适合于长时间的服务端运行.

## AOT

AOT 即 Ahead-of-time-compilation , 官方解释为 `Compile Java classes to native code prior to launching the virtual machine.`, 在jvm启动以前, 将字节码编译成本地机器码. jdk 9 以后新增了 `jaotc`工具 (可以理解为`java -> aot -> c`), 可以把某个类/模块编译成 AOT 库.

参考:[JEP 295: Ahead-of-Time Compilation](http://openjdk.java.net/jeps/295)

## 关于 java 的 `Write once, run anywhere`

以下这段总结自 `极客时间的专栏|java核心技术36讲`中 Woj 的评论.

java 的跨平台特性和JVM 的存在密不可分, 只要我们将 jre 安装在 win/linux 环境中, java 字节码就可以直接在上面运行. 所以并不是说 java 语言可以跨平台, 而是在不同平台都有可以让java语言运行的环境而已, 所以才有了java一次编写, 到处运行这样的效果.

java 程序的编译运行过程如下:

> .java 文件 -> 编译成 .class 字节码 -> 运行 -> JIT 编译成目标机器码

java 的 `编写一次, 到处执行` 的关键就是 JVM, JVM 为java提供了各种不同平台上的虚拟机制, 因此实现了`到处运行`的效果,. 需要强调的一点是, java 字节码设计充分考虑了 JIT 这一即时编译的方式, 可以将字节码直接转为高性能的本地机器码, 这同样也是虚拟机的一部分.


