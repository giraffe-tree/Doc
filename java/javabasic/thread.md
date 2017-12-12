# Thread

[java 并发编程 http://www.cnblogs.com/dolphin0520/category/602384.html](http://www.cnblogs.com/dolphin0520/category/602384.html)

## 一个对象的同步

synchronized, wait, notify 是任何对象都具有的同步工具

首先就要明确monitor的概念，Java中的每个对象都有一个监视器，来监测并发代码的重入。在非多线程编码时该监视器不发挥作用，反之如果在synchronized 范围内，监视器发挥作用。


```
public class Thread implements Runnable {
    /* Make sure registerNatives is the first thing <clinit> does. */
    private static native void registerNatives();
    
    ...
    
    }
```

虽然Java是跨平台的，但是JDK中还有很多native方法，使用这些方法时，注意平台的差异性。

### 创建线程

```
 private void init(ThreadGroup g, Runnable target, String name,
                      long stackSize, AccessControlContext acc,
                      boolean inheritThreadLocals) {
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        }

        this.name = name;

        Thread parent = currentThread();
        SecurityManager security = System.getSecurityManager();
        if (g == null) {
            /* Determine if it's an applet or not */

            /* If there is a security manager, ask the security manager
               what to do. */
            if (security != null) {
                g = security.getThreadGroup();
            }

            /* If the security doesn't have a strong opinion of the matter
               use the parent thread group. */
            if (g == null) {
                g = parent.getThreadGroup();
            }
        }

        /* checkAccess regardless of whether or not threadgroup is
           explicitly passed in. */
        g.checkAccess();

        /*
         * Do we have the required permissions?
         */
        if (security != null) {
            if (isCCLOverridden(getClass())) {
                security.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
            }
        }

        g.addUnstarted();

        this.group = g;
        this.daemon = parent.isDaemon();
        this.priority = parent.getPriority();
        if (security == null || isCCLOverridden(parent.getClass()))
            this.contextClassLoader = parent.getContextClassLoader();
        else
            this.contextClassLoader = parent.contextClassLoader;
        this.inheritedAccessControlContext =
                acc != null ? acc : AccessController.getContext();
        this.target = target;
        setPriority(priority);
        if (inheritThreadLocals && parent.inheritableThreadLocals != null)
            this.inheritableThreadLocals =
                ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);
        /* Stash the specified stack size in case the VM cares */
        this.stackSize = stackSize;

        /* Set thread ID */
        tid = nextThreadID();
    }

```

- public Thread( );
- public Thread(Runnable target);
- public Thread(String name);
- public Thread(Runnable target, String name);
- public Thread(ThreadGroup group, Runnable target);
- public Thread(ThreadGroup group, String name);
- public Thread(ThreadGroup group, Runnable target, String name);
- public Thread(ThreadGroup group, Runnable target, String name, long stackSize);

#### sleep 挂起线程

```
public static void sleep(long millis);
public static void sleep(long millis, int nanos);

```

#### 终止线程

```
publicvoid interrupt( );
```

#### thread.join

 thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。


### 线程的状态

线程也同样要经历开始（等待）、运行、挂起和停止四种不同的状态。

 - NEW
 - RUNNABLE
 - BLOCKED
 - WAITING
 - TIMED_WAITING
 - TERMINATED

#### 得到线程状态

```
public final native boolean isAlive();

public boolean isInterrupted() {
        return isInterrupted(false);
    }

public final boolean isDaemon() {
        return daemon;
    }

public final String getName() {
        return name;
    }

public State getState() {
        // get current thread state
        return sun.misc.VM.toThreadState(threadStatus);
    }

```

#### thread.join

 thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。

join() 方法，它能够使调用该方法的线程在此之前执行完毕。



#### volatile

多线程的内存模型：main memory（主存）、working memory（线程栈），在处理数据时，线程会把值从主存load到本地栈，完成操作后再save回去

volatile关键词的作用：每次针对该变量的操作都激发一次load and save. 在线程安全的情况下加volatile会牺牲性能。

## 创建

1. 实现runnable 接口

2. 继承thread 类

```
   /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see     #start()
     * @see     #stop()
     * @see     #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
```

当使用 ```runnable```接口的实现类继承 ```thread``` 类时, 会执行  ```runnable```接口的实现类的```run```方法.

3.使用Callable和Future接口创建线程。

具体是创建Callable接口的实现类，并实现call()方法。并使用FutureTask类来包装Callable实现类的对象，且以此FutureTask对象作为Thread对象的target来创建线程。

```
/**
 * A task that returns a result and may throw an exception.
 * Implementors define a single method with no arguments called
 * {@code call}.
 *
 * <p>The {@code Callable} interface is similar to {@link
 * java.lang.Runnable}, in that both are designed for classes whose
 * instances are potentially executed by another thread.  A
 * {@code Runnable}, however, does not return a result and cannot
 * throw a checked exception.
 *
 * <p>The {@link Executors} class contains utility methods to
 * convert from other common forms to {@code Callable} classes.
 *
 * @see Executor
 * @since 1.5
 * @author Doug Lea
 * @param <V> the result type of method {@code call}
 */
@FunctionalInterface
public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
}

```

```
public class FutureTask<V> implements RunnableFuture<V> { ... }

public interface RunnableFuture<V> extends Runnable, Future<V> {
    /**
     * Sets this Future to the result of its computation
     * unless it has been cancelled.
     */
    void run();
}
```



#### join()

join —— 让一个线程等待另一个线程完成才继续执行。如A线程线程执行体中调用B线程的join()方法，则A线程被阻塞，知道B线程执行完为止，A才能得以继续执行。

#### sleep



#### 后台线程（Daemon Thread）

后台线程主要是为其他线程（相对可以称之为前台线程）提供服务，或“守护线程”。如JVM中的垃圾回收线程。

后台线程的生命周期与前台线程生命周期有一定关联。主要体现在：当所有的前台线程都进入死亡状态时，后台线程会自动死亡

调用Thread对象的setDaemon(true)方法可以将指定的线程设置为后台线程。

main线程默认是前台线程，前台线程创建中创建的子线程默认是前台线程，后台线程中创建的线程默认是后台线程。调用setDeamon(true)方法将前台线程设置为后台线程时，需要在start()方法调用之前。前天线程都死亡后，JVM通知后台线程死亡，但从接收指令到作出响应，需要一定的时间。

每个线程默认的优先级都与创建它的线程的优先级相同

#### yied

Thread.yield()静态方法，只需要了解它的作用就是让这个线程从运行状态变成就绪状态，并从就绪队列中取一条优先级比此线程高的线程运行就好了。

上一篇博文中已经讲到了yield()的基本作用，同时，yield()方法还与线程优先级有关，当某个线程调用yiled()方法从运行状态转换到就绪状态后，CPU从就绪状态线程队列中只会选择与该线程优先级相同或优先级更高的线程去执行。

### synchronized和lock的区别:

Lock 的锁定是通过代码实现的，而 synchronized 是在 JVM 层面上实现的。

synchronized 在锁定时如果方法块抛出异常，JVM 会自动将锁释放掉，不会因为出了异常没有释放锁造成线程死锁。但是 Lock 的话就享受不到 JVM 带来自动的功能，出现异常时必须在 finally 将锁释放掉，否则将会引起死锁。

在资源竞争不是很激烈的情况下，偶尔会有同步的情形下，synchronized是很合适的。原因在于，编译程序通常会尽可能的进行优化synchronize，另外可读性非常好，不管用没用过5.0多线程包的程序员都能理解。

#### ReentrantLock:

ReentrantLock提供了多样化的同步，比如有时间限制的同步，可以被Interrupt的同步（synchronized的同步是不能Interrupt的）等。在资源竞争不激烈的情形下，性能稍微比synchronized差点点。但是当同步非常激烈的时候，synchronized的性能一下子能下降好几十倍。而ReentrantLock确还能维持常态。

#### Atomic:

和上面的类似，不激烈情况下，性能比synchronized略逊，而激烈的时候，也能维持常态。激烈的时候，Atomic的性能会优于ReentrantLock一倍左右。但是其有一个缺点，就是只能同步一个值，一段代码中只能出现一个Atomic的变量，多于一个同步无效。因为他不能在多个Atomic之间同步。

## LOCK

```
public interface Lock {
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
    void unlock();
    Condition newCondition();
}
```


-　tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false，也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。
- tryLock(long time, TimeUnit unit)方法和tryLock()方法是类似的，只不过区别在于这个方法在拿不到锁时会等待一定的时间，在时间期限之内如果还拿不到锁，就返回false。如果如果一开始拿到锁或者在等待期间内拿到了锁，则返回true。

#### lockInterruptibly TODO:???

单独调用interrupt()方法不能中断正在运行过程中的线程，只能中断阻塞过程中的线程。

#### ReadWriteLock

假如某一时刻，线程A执行到了method1，此时线程A获取了这个对象的锁，而由于method2也是synchronized方法，假如synchronized不具备可重入性，此时线程A需要重新申请锁。但是这就会造成一个问题，因为线程A已经持有了该对象的锁，而又在申请获取该对象的锁，这样就会线程A一直等待永远不会获取到的锁。

由于synchronized和Lock都具备可重入性 ,所以不会产生这个问题

### 公平锁

　在ReentrantLock中定义了2个静态内部类，一个是NotFairSync，一个是FairSync，分别用来实现非公平锁和公平锁。
　
- isFair()        //判断锁是否是公平锁
- isLocked()    //判断锁是否被任何线程获取了
- isHeldByCurrentThread()   //判断锁是否被当前线程获取了
- hasQueuedThreads()   //判断是否有线程在等待该锁

### wait()/notify()/notifyAll()线程通信

TODO: ???


## Volatile

如果一个变量在多个CPU中都存在缓存（一般在多线程编程时才会出现），那么就可能存在缓存不一致的问题。

为了解决缓存不一致性问题，通常来说有以下2种解决方法：

1. 通过在总线加LOCK#锁的方式
2. 通过缓存一致性协议

    - 所以就出现了缓存一致性协议。最出名的就是Intel 的MESI协议，MESI协议保证了每个缓存中使用的共享变量的副本是一致的。它核心的思想是：当CPU写数据时，如果发现操作的变量是共享变量，即在其他CPU中也存在该变量的副本，会发出信号通知其他CPU将该变量的缓存行置为无效状态，因此当其他CPU需要读取这个变量时，发现自己缓存中缓存该变量的缓存行是无效的，那么它就会从内存重新读取。

### 并发编程中的三个概念

1. 原子性

    - 原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。

Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，可以通过synchronized和Lock来实现。由于synchronized和Lock能够保证任一时刻只有一个线程执行该代码块，那么自然就不存在原子性问题了，从而保证了原子性。


2. 可见性

    - 可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。

对于可见性，Java提供了volatile关键字来保证可见性。

　　当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。

另外，通过synchronized和Lock也能够保证可见性，synchronized和Lock能保证同一时刻只有一个线程获取锁然后执行同步代码，并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见性。


3.有序性

    - 即程序执行的顺序按照代码的先后顺序执行。
    - ，处理器为了提高程序运行效率，可能会对输入代码进行优化，它不保证程序中各个语句的执行先后顺序同代码中的顺序一致，但是它会保证程序最终执行结果和代码顺序执行的结果是一致的。
    - 因为处理器在进行重排序时是会考虑指令之间的数据依赖性，如果一个指令Instruction 2必须用到Instruction 1的结果，那么处理器会保证Instruction 1会在Instruction 2之前执行

在Java内存模型中，允许编译器和处理器对指令进行重排序，但是重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。

在Java里面，可以通过volatile关键字来保证一定的“有序性”。另外可以通过synchronized和Lock来保证有序性，很显然，synchronized和Lock保证每个时刻是有一个线程执行同步代码，相当于是让线程顺序执行同步代码，自然就保证了有序性。

Java内存模型具备一些先天的“有序性”，即不需要通过任何手段就能够得到保证的有序性，这个通常也称为 happens-before 原则。如果两个操作的执行次序无法从happens-before原则推导出来，那么它们就不能保证它们的有序性，虚拟机可以随意地对它们进行重排序。

### 深入剖析volatile关键字

　　一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：

1. 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。

2. 禁止进行指令重排序。

#### 深入理解jvm 原理

>　观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令

1. 它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成
2. 它会强制将对缓存的修改操作立即写入主存
3. 如果是写操作，它会导致其他CPU中对应的缓存行无效。

需要注意的是 在一个变量上加上 volatile 可以保证可见性, 并在一定程度上保证有序性, 但是无法保证操作的原子性


#### CAS 算法

```
要实现无锁（lock-free）的非阻塞算法有多种实现方法，其中CAS（比较与交换，Compare and swap）是一种有名的无锁算法。CAS, CPU指令，在大多数处理器架构，包括IA32、Space中采用的都是CAS指令，CAS的语义是“我认为V的值应该为A，如果是，那么将V的值更新为B，否则不修改并告诉V的值实际为多少”，CAS是项乐观锁技术，当多个线程尝试使用CAS同时更新同一个变量时，只有其中一个线程能更新变量的值，而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次尝试。CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
```



