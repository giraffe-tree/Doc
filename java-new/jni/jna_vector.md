# jna 问题

## vector 能否直接映射成 java 的 list/array,或者反过来

不能, 目前只能通过 jni 解决, 通过 jna, BridJ 都无法解决 vector 数据映射的问题

## java 和 c++ 之间的 数组内存问题? 是否始终再同一块内存区域?

目前的参考资料表明

java 的对象数组是在 java heap 中

JNI提供了与Java相对应的引用类型（如：jobject、jstring、jclass、jarray、jintArray等），以便Native代码可以通过JNI函数访问到Java对象。引用所指向的Java对象通常就是存放在Java Heap，而Native代码持有的引用是存放在Native Memory中。

java 能否直接访问 native memory 中的数组?

不能

## jint array to  `int[]`

https://stackoverflow.com/questions/11686200/returning-jint-array-from-c-to-java-through-jni

## 原生数组的对象头

格式? 和普通对象一致


```java
public static void main(String[] args)
{
    test(int[].class);
    test(String[].class);
}

private static void test(Class clazz)
{
    System.out.println(clazz.getName());
    System.out.println(clazz.getSuperclass());
    for(Class face : clazz.getInterfaces())
        System.out.println(face);
}
```

https://stackoverflow.com/questions/12806739/is-an-array-a-primitive-type-or-an-object-or-something-else-entirely


## 本地方法栈

每个线程都有一个本地方法栈

### 如何将 jni 的so dll 包打入 jar 包

在平台特定位置的JAR文件中包含本机JNI库，例如在NATIVE / $ {os.arch} / $ {os.name} /libname.lib
在主类的静态初始化中创建代码以
计算当前的os.arch和os.name
使用Class.getResource（String）在预定义位置的JAR文件中查找库
如果存在，请将其提取到临时文件中，并使用System.load（File）加载。
https://stackoverflow.com/questions/2937406/how-to-bundle-a-native-library-and-a-jni-library-inside-a-jar


## 参考

- https://stackoverflow.com/questions/54766965/using-jna-to-access-a-struct-containing-a-vectorchar

- https://blog.csdn.net/pzysoft/article/details/79923121

- java 数组和 native 引用
	- https://juejin.im/post/5c19bfa0f265da6133568545
- trace class load/unload
	- `-XX:+TraceClassLoading -XX:+TraceClassUnloading`
	- `Class c1 = Class.forName("[I");`
	- https://stackoverflow.com/questions/9921081/how-to-track-when-class-is-loaded-and-destroyed-in-jvm
