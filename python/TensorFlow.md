# TensorFlow

## 资料参考


- [如何理解神经网络里面的反向传播算法](https://www.zhihu.com/question/24827633)
- [CNN(卷积神经网络)、RNN(循环神经网络)、DNN(深度神经网络)的内部网络结构有什么区别？](https://www.zhihu.com/question/34681168)
- 


## Goals

1. 理解 TF 图形计算方法
2. 扩展 TF 的内置函数
3. 学习如何去创建最适合深度模型的结构模型



## 1. 基本使用

- 使用图 (graph) 来表示计算任务.
- 在被称之为 会话 (Session) 的上下文 (context) 中执行图.
- 使用 tensor 表示数据.每个 Tensor 是一个类型化的多维数组
- 通过 变量 (Variable) 维护状态.
- 使用 feed 和 fetch 可以为任意的操作(arbitrary operation) 赋值或者从其中获取数据.


### 加快机器学习

stochastic gradient descent
随机梯度下降

1. 批量放入
2. 传统
 
   ``` 
   W +=-Learning_rate * dx
   ```
    
3. momentum 动量更新

   ``` 
   m = b1*m - learning_rate *dx
   W +=m
   ```
    
4. Adagrad

   ``` 
   v += dx^2
    W += -learning_rate *dx/根号v 
    ```
    
5. RMSProp

    ```
    v = b1*v+(1-b1)*dx^2
    W +=-learning_rate *dx/根号v
    ```
    
6. Adam

    ```
    m = b1*m - (1-b1) *dx
    v = b1*v+(1-b1)*dx^2
    W +=-learning_rate *dx/根号v
    ``` 
    
### 优化器 Optimizer


**GradientDescentOptimizer** 

AdagradOptimizer 
AdagradDAOptimizer 

**MomentumOptimizer** 考虑本步的 learning_rate 也考虑上一步的 learning_rate


**AdamOptimizer** 

FtrlOptimizer 

**RMSPropOptimizer** , AlphaGo 的学习策略

### tensorboard


### 





















