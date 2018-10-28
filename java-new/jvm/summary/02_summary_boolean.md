# JVM 总结 2: jvm 是如何处理 boolean 的

## 参考

64 位jvm对 `long/double` 读写为原子操作
	
	https://www.zhihu.com/question/38816432

awk
	
	- https://blog.csdn.net/jiaobuchong/article/details/83037467

## 结论

Java语言规范中，boolean类型的只有两种 true和false（false是默认值）；

Java虚拟机规范中，boolean类型要转换为int类型，true => 1，false => 0；

## Foo

```
public class Foo {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.println("Hello, Java!");
        if (flag == true) System.out.println("Hello, JVM!");
    }
}
```

## boolean 数组

使用 byte 数组实现, 存储时将进行掩码操作.




