# Tensorflow 总结六 : 过拟合 over fitting

## 如何避免过拟合

避免过拟合的方法有很多：early stopping、数据集扩增（Data augmentation）、正则化（Regularization）包括L1、L2（L2 regularization也叫weight decay），dropout。

## 正则化

为了避免过拟合问题, 一种非常常用的方法是正则化.

### 为什么要使用正则化

不管是L1,还是L2, 正则化的基本思想就是限制权重的大小, 使得模型不能任意拟合训练数据中的随机噪声.

https://www.cnblogs.com/alexanderkun/p/6922428.html

### L1 和 L2 的区别

1. L1 正则会让参数变得更加稀疏, 可以达到类似特征选取的作用. 
2. L2 正则公式可导, 在计算损失函数的偏导数时, 更加方便.

另外也可以将L1和L2混合使用

	- 参考中讲了L1和L2的区别, 不过都大同小异
	- https://www.cnblogs.com/lyr2015/p/8718104.html



