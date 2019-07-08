# Java dump 文件生成与分析

## 参考

https://yq.aliyun.com/articles/701587

## 分析问题

`jmap` 可以每几分钟运行一次，通过对比，观察哪些类的占用内存增长比较多。

### heap

```jmap -heap <pid>```

打印一个堆的摘要信息，包括使用的GC算法、堆配置信息和各内存区域内存使用信息。

### histo:live

`jmap -histo:live <pid>`

其中包括每个Java类、对象数量、内存大小(单位：字节)、完全限定的类名。打印的虚拟机内部的类名称将会带有一个`*`前缀。如果指定了live子选项，则只计算活动的对象

#### 什么是 live 活跃对象

live选项强制JVM在将堆内容转储到文件之前**执行 Full GC**

参考:

- https://stackoverflow.com/questions/55496429/what-are-live-objects-in-java-heap-heap-dump-with-jmap

### clstats

`jmap -clstats pid`

打印类加载器信息

### finalizerinfo

`jmap -finalizerinfo <pid>`

### dump[:dump-options]

`jmap -dump:format=b,file=mem.dat pid`

以hprof二进制格式转储Java堆到指定filename的文件中。live子选项是可选的。如果指定了live子选项，堆中只有活动的对象会被转储。想要浏览heap dump，你可以使用jhat(Java堆分析工具)读取生成的文件。

通过 `jhat -port 7000 mem.dat` 可以将mem.dat的内容以web的方式暴露到网络，访问http://ip-server:7000查看。


## 其他

### `jmap -heap pid` =>  Doesn't appear to be a HotSpot VM (could not find symbol "gHotSpotVMTypes" in remote process)

这个问题没有找到原因, 看起来像是jdk实现不同导致的

### Can't attach to the process: ptrace(PTRACE_ATTACH, ..) failed for 1: Operation not permitted

`docker run --cap-add=SYS_PTRACE ...`

