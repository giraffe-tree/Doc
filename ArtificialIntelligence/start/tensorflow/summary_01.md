# Tensorflow 总结一 : Tensorflow 中的基本概念

看了一下午 tensorflow 的视频, 晚上来总结下.

## 1. 安装

```shell
pipenv install tensorflow
```

这里我使用的是 pipenv 虚拟环境, 虽然刚刚开始使用的时候遇到了点坑, 但后面使用非常方便. 它搭建了一个轻量级的虚拟环境, 虽然我并不特别清楚其中的原理, 但我自己感觉有点像 docker, 它将命令,目录等都和本地环境隔离开来了, 使用起来十分方便.

## 2. 基本概念

### ```Tensor```

开始学 tensorflow 的时候, 常常看到下面的话
```
tensor 可以简单的被理解为多维数组, 可以表达任意维的数组
```

今天翻看了下源码中对 ```tensor``` 的解释, 引自 ```tensorflow.python.framework.ops.Tensor```

```markdown
  A `Tensor` is a symbolic handle to one of the outputs of an
  `Operation`. It does not hold the values of that operation's output,
  but instead provides a means of computing those values in a
  TensorFlow `tf.Session`.

  This class has two primary purposes:

  1. A `Tensor` can be passed as an input to another `Operation`.
     This builds a dataflow connection between operations, which
     enables TensorFlow to execute an entire `Graph` that represents a
     large, multi-step computation.

  2. After the graph has been launched in a session, the value of the
     `Tensor` can be computed by passing it to
     `tf.Session.run`.

```

我简单的翻译下:

 ```Tensor``` 是`Operation`(译者注: 算子) 的一个输出的符号引用。它不保存该操作的输出值，而是在 `tf.Session`中提供计算这些值的方法。

这个类有两个主要目的：

1. `Tensor` 可以作为输入传递给另一个`Operation`(译者注: 算子)。这将在算子之间建立数据流连接，使 `TensorFlow` 能够执行大型多步计算的整个`Graph` 。
2.  在 `session` 中启动 `graph` 之后，可以通过将它传递给`tf.Session.run`来计算`Tensor`输出的值。 

我的理解如下:

在我们实际使用`tensorflow` 的过程中, 首先我们要定义图中的所有操作, 最后才会去计算. 

1. 定义程序时, 我把它理解为一个函数, 它保存了这些数如何计算的过程, 当多个 `tensor` 有顺序的排列好时, `tensor` 就 `flow` 了
2. 在实际计算中, 我把它理解为一个 n维数组, 当成一个函数的输出, 并作为另一个函数的输入. 实际上如果觉得第一种理解能接受的话, 这种理解就没有必要了.

### Graph

在上面 `tensor` 的解释中出现了`graph` 这个词. 

`graph` 就是由一个或者多个`tensor` 组成的有向无环图. 

通俗点的讲, 它保存了一系列的计算过程, 所以有些书上将 `graph` 翻译成 **计算图** 







