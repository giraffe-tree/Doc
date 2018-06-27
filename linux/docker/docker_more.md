# docker more

## 单主机多容器间通讯

```
docker run --link
```

## namespace


## cgroups

Control groups

简单的来讲就是:把任务放到一个组里统一控制.

内核附加在程序上的一系列钩子(hook),通过程序运行时对资源的调度出发响应的钩子,以达到资源追踪和限制的目的.

### 功能

1. 资源限制
2. 优先级分配 CPU/磁盘io
3. 资源统计,cpu使用时长,内存用量
4. 任务控制,挂起/恢复

### 术语

1. task

2. cgroup

3. subsystem 子系统,资源控制系统,一个子系统可以附加到多个层级

4. hierarchy 层级,一个层级可以有多个 subsystem

### docker是怎么使用cgroups的

```
tree /sys/fs/cgroup/cpu/docker/
```

### cgroups 的实现方式

本质上就是给任务挂上钩子 hook

#### cgroups 如何判断资源超出限额

docker 默认开启OOM control,超出内存最大限额,进程就会收到oom信号,并结束

## docker daemon

### docker daemon 工作路径

```/var/lib/docker```



