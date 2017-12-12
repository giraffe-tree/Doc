# JAVA 多线程



## Thread 类 

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










