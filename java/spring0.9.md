# spring 0.9 源码笔记

## 基本概念

### Java Bean

*参考：*

- [Spring 学习之bean的理解](http://www.cnblogs.com/shinubi/p/4182027.html)

1. 解析xml, 获取各种元素
2. 通过Java反射把各个bean的实例创建起来
3. 还是通过Java反射调用方法


### Spring 依赖注入

**参考：**

- **[IoC容器和Dependency Injection模式————中文译文](http://insights.thoughtworkers.org/injection/)**


**所谓依赖注入，就是把底层类作为参数传入上层类，实现上层类对下层类的“控制”。**

只要修改底层类，上层类能直接得到底层类的变化。
可以通过三种方式实现依赖注入

1. 构造函数
2. setter函数
3. 接口注入

**但是由于采用了依赖注入，在我们初始化过程中不可避免地要写大量的 new**

- 于是采用了IOC容器就解决了这个问题

### Spring IOC

Inversion of Control，即控制反转的思想最核心的地方在于，资源不由使用资源的双方管理，而由不使用资源的第三方管理，这可以带来很多好处。

- 实际中，它先从最上层开始往下找依赖关系，到达最底层之后再往上一步一步new。

> - 第一，资源集中管理，实现资源的可配置和易管理。
> - 第二，降低了使用资源双方的依赖程度，也就是我们说的耦合度,解耦


IOC 容器，可以对代码进行初始化，你只要维护一个config，可以是一段xml，也可以是一段代码，我们就不用去写一大段的初始化代码了，就是要将**组件的配置与使用分离开**

这也解释了spring为什么那么流行，就是因为**spring把对象之间的依赖关系转而用配置文件来管理。Spring把这些依赖关系放入IOC容器中管理。**

为什么IOC容器它能对代码进行初始化呢？因为IOC容器就是一些被bean包裹的对象加上bean之间的关系，spring通过把对象包裹在bean中，达到管理这些对象及做一系列额外操作的目的。

所谓的bean就是一个特殊的数据结构，用来增强对象的。


## Spring框架的架构


- 参照 **spring官方文档** 和 **《深入分析JavaWeb》**

Springd的核心组件有三个 **Core ,Context 和 Bean**

###Spring的设计理念

如果从这三个核心组件中找出最核心的那个，那么非Bean莫属。
因为Spring就是面向Bean编程，bean在spring中就像object在面向对象编程一样重要

我们通过包装对象，形成bean，现在bean是有了，但如何知道bean之间的关系呢？这就要讲到context了。

context就是一个bean关系的集合，spring通过context来发现每个bean之间的关系。这些bean的关系加上bean本身就是一个IOC容器。

有了context，就知道了bean和bean之间的关系，但我们常常需要一些工具去发现，建立，维护这些关系，这就需要core了。它就是一个维护IOC的工具。

### Bean

spring bean 的创建是典型的工厂模式，它的顶级接口是BeanFactory





### Context


### Core



## 源码分析

### BeanFactory



### Context




#Q：
1. **spring 是如何为我们调用的接口，找到实现类的？**

> -  1. 管理实例对象
> -  2. 需要知道各个接口分别与那个实现类关联，可以将这些关系放在一个合适的配置类中，比如xml文件。









