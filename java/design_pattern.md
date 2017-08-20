# **设计模式**

### 模板方法模式

*定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义该算法中的某些特定步骤。*

**模板方法模式和策略模式有点像，而它其中又有些区别：**
> 1. 模板方法模式意图与策略模式意图不一样，模板方法模式工作是定义一个算法的大纲，而由其子类定义其中某些步骤的内容。 

> 2. 模板方法模式对算法有更多的控制权，而且不会重复代码。不依赖任何对象，整个算法自己搞定。

参考：
> [设计模式之模板方法模式](https://zhuanlan.zhihu.com/p/25025808)


### 策略模式

*定义一系列的算法，把每一个算法封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。*

- 环境(Context)角色：持有一个Strategy的引用。
- 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
- 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。


*参考：*
> [JAVA与模式之策略模式](http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html)


### 代理模式

#### 静态代理

*为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个对象不适合或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。*

proxy,它的目的在于保持接口不变，而改变接口定义的方法的行为。

在访问一个对象的时候进行log记录，检查参数等

对代理模式而言，一个主题类与一个代理类一一对应，这是静态代理模式的特点。


#### 动态代理

多个主题类对应一个代理类，共享“前处理，后处理”功能，动态调用所需主题，大大减小了程序规模，这就是动态代理模式的特点。

*InvocationHandler 接口*
> Object **invoke**(Object proxy, Method method, Object[] args) throws Throwable

> - **proxy**:   指代我们所代理的那个真实对象
- **method**: 指代的是我们所要调用真实对象的某个方法的Method对象
- **args**:   指代的是调用真实对象某个方法时接受的参数

> 每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。

*Proxy 类*
> Proxy provides static methods for creating dynamic proxy classes and instances, and it is also the superclass of all dynamic proxy classes created by those methods. 

**作用：**用来动态创建一个代理对象的类

*Proxy 的 newProxyInstance 方法*
> public static Object **newProxyInstance**(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler h)  throws IllegalArgumentException

> 得到一个动态的代理对象，其接收三个参数

> - **loader:**代理对象的ClassLoader，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
- **interfaces:**代理对象的Interface的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
- **h:**一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上




*public final class $Proxy0 extends Proxy implements Subject*

参考：
> *[代理模式](https://zhuanlan.zhihu.com/p/26141688)*

> *[动态代理](https://zhuanlan.zhihu.com/p/26193963)*

> *[java的动态代理机制](http://www.cnblogs.com/xiaoluo501395377/p/3383130.html)*









