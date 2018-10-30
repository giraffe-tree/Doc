# Tensorflow 总结三 : 什么是深层神经网络

## 定义

use a cascade of multiple layers of nonlinear processing units for feature extraction and transformation. Each successive layer uses the output from the previous layer as input.

使用级联的多层非线性处理单元, 用于特征的提取与转换. 每个连续层 都是用之前层的输出作为它的输入.

## 激活函数

### 为什么不能使用线性函数

- Neural networks have to implement complex mapping functions hence they need activation functions that are non-linear in order to bring in the much needed non-linearity property that enables them to approximate any function. A neuron without an activation function is equivalent to a neuron with a linear activation function given by.
- https://www.quora.com/Why-do-neural-networks-need-an-activation-function
- https://blog.csdn.net/qq_33801122/article/details/80239229

简单来说, 神经网络需要引入非线性的元素, 使其能够逼近任意函数.没有激活函数, 或者使用任意的线性函数, 都相当于线性函数.

比如: `y=Wx+b`, `W`,`b`这两个参数由计算机去模拟, 而你中间加了一个线性函数`z=Ux+c`, 它们组合之后, 相当于`z=U(Wx+b)+c`,即`z=UWx+Ub+c`, 对于这个式子和第一个式子, 对于计算机来说并没有区别, 计算机都是将值带进去拟合, 最终的结果并没有差别.

### 激活函数的作用是什么?

激活函数，并不是去激活什么，而是指 **如何把“激活的神经元的特征”通过函数把特征保留并映射出来**（保留特征，去除一些数据中是的冗余），这是神经网络能解决非线性问题关键

   我的理解是, 激活函数会将输出改变, 将一部分的信息隐藏, 将一部分的信息提取, 如果提取的是有用的信息, 将它反映到测试中, 并在下次学习时强化.

## 偏置项

### 为什么要有偏置项
	
	- https://www.jianshu.com/p/3c9c67b6b5dc


### 偏置项一般为常数, 比如: 1
	
	- 计算机可以通过调参, 来使偏置项输出发生变化

## 损失函数



