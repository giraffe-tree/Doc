# Java 面试总结

## 基础

1.  private修饰的方法可以通过反射访问，那么private的意义是什么
2.  Java类初始化顺序
3.  局部变量使用前需要显式地赋值，否则编译通过不了，为什么这么设计
4.  String a = "ab"; String b = "a" + "b"; a == b 是否相等，为什么
5.  int a = 1; 是原子性操作吗
6.  可以用for循环直接删除ArrayList的特定元素吗？可能会出现什么问题？怎样解决
7.  注解的原理
8.  动态代理
9.  Collections.sort排序内部原理
10.  instanceof 是如何工作的
     - 这个答案会告诉你 `instanceof` 到底是怎么样的 
       - https://www.zhihu.com/question/21574535
       - 另外....R大NB !!!!!!





## JVM

1. 对方法区和永久区的理解以及它们之间的关系
2. jvm gc 复制算法是怎样实现的
3. Object object = new Object(); 初始化的顺序是什么在jvm各区域做了什么





## 多线程与并发

1. ReadWriteLock读写之间互斥吗
2. Semaphore拿到执行权的线程之间是否互斥
3. 写一个死锁
4. 新的任务提交到线程池，线程池是怎样处理
5. AQS和CAS原理, CAS底层是怎样实现原子性的
6. synchronized底层实现原理
7. volatile作用，指令重排相关
8. 进程间通信的方式有哪些
9. ReentrantLock 是可重入锁，什么是可重入锁
10. 线程怎样按顺序执行
11. 修饰类的锁和修饰方法的锁的区别
12. java线程池实现的原理
13. CyclicBarrier 





## 设计模式

1. 写一个你认为最好的单例模式
2. 写一个生产者消费者模式

## 框架

### Spring

1. AOP和IOC原理
2. Spring怎样解决循环依赖的问题
3. dispatchServlet怎样分发任务的





## 数据库

1. B树 和 B+树是解决什么样的问题的，怎样演化过来，之间区别
2. mysql给离散度低的字段建立索引会出现什么问题，具体说下原因





