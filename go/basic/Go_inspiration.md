# Go inspiration

## 初始化/赋值

```
type Man struct {
	height float64
	weight float64
	money  int
}

// 第一种 new(T) 返回的是 Man 对象的指针
man1 := new(Man)
// 第二种 m 中的是 Man 对象的值
var man2 Man 
// 第三种 同第二种, 也是值
man3 := Man{186, 66, 1000}
```

现在有一个方法

```
// 接口
type read interface {
	read()
}
// 方法
func (m *Man) read() {
	fmt.Println("read with 值 man")
}
// 函数
func readBook(r read) {
	r.read()
}
```

由于方法中需要的是指针,故以下为正确调用

```
readBook(man1)
readBook(&man2)
readBook(&man3)
```

## 封装，继承和多态

OO 语言最重要的三个方面分别是：封装，继承和多态，在 Go 中它们是怎样表现的呢？

### 封装

封装（数据隐藏）：和别的 OO 语言有 4 个或更多的访问层次相比，Go 把它简化为了 2 层（参见 4.2 节的可见性规则）:

1）包范围内的：通过标识符首字母小写，对象 只在它所在的包内可见

2）可导出的：通过标识符首字母大写，对象 对所在包以外也可见

类型只拥有自己所在包中定义的方法。


### 继承

继承：用组合实现：内嵌一个（或多个）包含想要的行为（字段和方法）的类型；多重继承可以通过内嵌多个类型实现

### 多态

多态：用接口实现：某个类型的实例可以赋给它所实现的任意接口类型的变量。类型和接口是松耦合的，并且多重继承可以通过实现多个接口实现。Go 接口不是 Java 和 C# 接口的变体，而且接口间是不相关的，并且是大规模编程和可适应的演进型设计的关键。

## goroutines

Go 更倾向于其他的方式，在诸多比较合适的范式中，有个被称作 Communicating Sequential Processes（顺序通信处理）（CSP, C. Hoare 发明的）还有一个叫做 message passing-model（消息传递）（已经运用在了其他语言中，比如 Erlang）。



