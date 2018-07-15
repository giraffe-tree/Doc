# Volatile

## volatile

volatile 的变量 单个读/写,可以看成是使用同一个锁对这些单个读写操作做了同步.

当线程获取锁时, JMM 会把该线程对应的本地内存置为无效,从而使的监视器保护的临界区代码必须从主内存中读取共享变量.

https://www.cnblogs.com/dolphin0520/p/3920373.html

《Java 中的双重检查（Double-Check）》 http://blog.csdn.net/dl88250/article/details/5439024



## yield

Java线程中的Thread.yield( )方法，译为线程让步。顾名思义，就是说当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，

让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。

## atomicInteger

在java 1.5的java.util.concurrent.atomic包下提供了一些原子操作类，即对基本数据类型的 自增（加1操作），自减（减1操作）、以及加法操作（加一个数），减法操作（减一个数）进行了封装，保证这些操作是原子性操作。atomic是利用CAS来实现原子性操作的（Compare And Swap），CAS实际上是利用处理器提供的CMPXCHG指令实现的，而处理器执行CMPXCHG指令是一个原子性操作。



