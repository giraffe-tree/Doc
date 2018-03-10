# Docker 容器与容器云

## 参考

1. Docker 容器与容器云  --   浙大 SEL 实验室

# 第一章 从容器到容器云

## 1.1 云计算平台

云计算是一种资源的服务模式,该模式可以实现随时随地,便捷按需地从可配置计算资源共享池中获取所需的资源(如网络,服务器,存储,应用及服务),资源能够快速供应并释放,大大减少了资源管理工作开销.

## 1.2 容器,新的革命

docker 是以 docker 容器为资源分割和调度的基本单位.

docker 可在容器内部快速自动化地部署应用,并通过操作系统内核技术 namespaces,cgroups 为容器提供资源隔离与安全保障.

### 容器技术

容器技术的生态系统覆盖了 iaas,paas 层所涉及的各类问题,包括资源调度,编排,部署,监控,配置管理,存储网络管理,安全等

1. 持续部署与测试
2. 跨云平台支持
3. 环境标准化和版本控制
4. 高资源利用率与隔离
5. 容器跨平台性和镜像
6. 易于理解且易用
7. 应用镜像仓库

# 第二章  docker 基础

## 2.2 docker 操作参数解读

|docker命令分类|子命令|
|-|-|
|环境| info,version|
| 容器生命周期管理 | create,exec,kill,pause,restart,rm,run,start,stop,unpause |
| 镜像仓库命令 | login,logout,pull,push,search |
| 镜像管理 | build,images,inport,load,rmi,save,tag,commit |
| 容器运维操作 | attach,export,inspect,port,ps,rename,stats,top,wait,cp,diff,update |
| 容器资源管理 | volume,network |
| 系统日志信息 | events,history,logs |

### docker run

docker run 命令用来基于特定的镜像,创建一个容器,并依据选项来控制该容器.

```
Usage:	docker run [OPTIONS] IMAGE [COMMAND] [ARG...]

Run a command in a new container

Options:
      --add-host list                  Add a custom host-to-IP mapping (host:ip)
  -a, --attach list                    Attach to STDIN, STDOUT or STDERR
      --blkio-weight uint16            Block IO (relative weight), between 10 and 1000, or 0 to disable (default 0)
      --blkio-weight-device list       Block IO weight (relative device weight) (default [])
      --cap-add list                   Add Linux capabilities
      --cap-drop list                  Drop Linux capabilities
      --cgroup-parent string           Optional parent cgroup for the container
      --cidfile string                 Write the container ID to the file
      --cpu-period int                 Limit CPU CFS (Completely Fair Scheduler) period
      --cpu-quota int                  Limit CPU CFS (Completely Fair Scheduler) quota
      --cpu-rt-period int              Limit CPU real-time period in microseconds
      --cpu-rt-runtime int             Limit CPU real-time runtime in microseconds
  -c, --cpu-shares int                 CPU shares (relative weight)
      --cpus decimal                   Number of CPUs
      --cpuset-cpus string             CPUs in which to allow execution (0-3, 0,1)
      --cpuset-mems string             MEMs in which to allow execution (0-3, 0,1)
  -d, --detach                         Run container in background and print container ID
      --detach-keys string             Override the key sequence for detaching a container
      --device list                    Add a host device to the container
      --device-cgroup-rule list        Add a rule to the cgroup allowed devices list
      --device-read-bps list           Limit read rate (bytes per second) from a device (default [])
      --device-read-iops list          Limit read rate (IO per second) from a device (default [])
      --device-write-bps list          Limit write rate (bytes per second) to a device (default [])
      --device-write-iops list         Limit write rate (IO per second) to a device (default [])
      --disable-content-trust          Skip image verification (default true)
      --dns list                       Set custom DNS servers
      --dns-option list                Set DNS options
      --dns-search list                Set custom DNS search domains
      --entrypoint string              Overwrite the default ENTRYPOINT of the image
  -e, --env list                       Set environment variables
      --env-file list                  Read in a file of environment variables
      --expose list                    Expose a port or a range of ports
      --group-add list                 Add additional groups to join
      --health-cmd string              Command to run to check health
      --health-interval duration       Time between running the check (ms|s|m|h) (default 0s)
      --health-retries int             Consecutive failures needed to report unhealthy
      --health-start-period duration   Start period for the container to initialize before starting health-retries countdown (ms|s|m|h)
                                       (default 0s)
      --health-timeout duration        Maximum time to allow one check to run (ms|s|m|h) (default 0s)
      --help                           Print usage
  -h, --hostname string                Container host name
      --init                           Run an init inside the container that forwards signals and reaps processes
  -i, --interactive                    Keep STDIN open even if not attached
      --ip string                      IPv4 address (e.g., 172.30.100.104)
      --ip6 string                     IPv6 address (e.g., 2001:db8::33)
      --ipc string                     IPC mode to use
      --isolation string               Container isolation technology
      --kernel-memory bytes            Kernel memory limit
  -l, --label list                     Set meta data on a container
      --label-file list                Read in a line delimited file of labels
      --link list                      Add link to another container
      --link-local-ip list             Container IPv4/IPv6 link-local addresses
      --log-driver string              Logging driver for the container
      --log-opt list                   Log driver options
      --mac-address string             Container MAC address (e.g., 92:d0:c6:0a:29:33)
  -m, --memory bytes                   Memory limit
      --memory-reservation bytes       Memory soft limit
      --memory-swap bytes              Swap limit equal to memory plus swap: '-1' to enable unlimited swap
      --memory-swappiness int          Tune container memory swappiness (0 to 100) (default -1)
      --mount mount                    Attach a filesystem mount to the container
      --name string                    Assign a name to the container
      --network string                 Connect a container to a network (default "default")
      --network-alias list             Add network-scoped alias for the container
      --no-healthcheck                 Disable any container-specified HEALTHCHECK
      --oom-kill-disable               Disable OOM Killer
      --oom-score-adj int              Tune host's OOM preferences (-1000 to 1000)
      --pid string                     PID namespace to use
      --pids-limit int                 Tune container pids limit (set -1 for unlimited)
      --privileged                     Give extended privileges to this container
  -p, --publish list                   Publish a container's port(s) to the host
  -P, --publish-all                    Publish all exposed ports to random ports
      --read-only                      Mount the container's root filesystem as read only
      --restart string                 Restart policy to apply when a container exits (default "no")
      --rm                             Automatically remove the container when it exits
      --runtime string                 Runtime to use for this container
      --security-opt list              Security Options
      --shm-size bytes                 Size of /dev/shm
      --sig-proxy                      Proxy received signals to the process (default true)
      --stop-signal string             Signal to stop a container (default "SIGTERM")
      --stop-timeout int               Timeout (in seconds) to stop a container
      --storage-opt list               Storage driver options for the container
      --sysctl map                     Sysctl options (default map[])
      --tmpfs list                     Mount a tmpfs directory
  -t, --tty                            Allocate a pseudo-TTY 伪终端; 虚拟终端机;
      --ulimit ulimit                  Ulimit options (default [])
  -u, --user string                    Username or UID (format: <name|uid>[:<group|gid>])
      --userns string                  User namespace to use
      --uts string                     UTS namespace to use
  -v, --volume list                    Bind mount a volume
      --volume-driver string           Optional volume driver for the container
      --volumes-from list              Mount volumes from the specified container(s)
  -w, --workdir string                 Working directory inside the container
```


### docker start/stop/restart

```docker run``` 命令可以新建一个容器来运行,而对于已经存在的容器,可以通过 ```docker start/stop/restart```来启动,停止,重启.

docker start 可以使用 -i 来开启交互模式,时钟保持输入流开放.

docker stop/restart 使用 -t 选项来设定容器停止前的等待时间.

### docker registry 

docker registry 是存储容器镜像的仓库,用户可以通过 docker client 与 docker registry 进行通信,由此完成镜像的搜索,下载,上传等操作.

### docker pull

主要用于从 docker registry 中拉取 image/repository .

docker 不仅可以从官方的dockerHub 中的镜像库中拉取,也可以从私有服务器中获取镜像资源.

### docker push

### docker images 

可以列出主机上的镜像

### docker rmi / docker rm 

docker rmi 用于删除镜像

docker rm 用于删除容器

它们可以同时删除多个镜像/容器

如果已经由基于镜像 a 的容器 b 启动,则要先删除 容器 b ,才能删除镜像 a

### docker 运维操作

### docker attach

它可以连接到正在运行的容器,观察该容器的运行情况,或者与容器主进程进行交互

```	docker attach [OPTIONS] CONTAINER```


### docker inspect 

用来查看镜像和容器的详细信息,可以通过 --format 指定输出模板格式.

```
Usage:  docker inspect [OPTIONS] NAME|ID [NAME|ID...] [flags]
```

### docker ps

CONTAINER ID   容器id
IMAGE          镜像     
COMMAND        
CREATED             
STATUS              
PORTS               
NAMES

```
Usage:	docker ps [OPTIONS]

List containers

Options:
  -a, --all             Show all containers (default shows just running)
  -f, --filter filter   Filter output based on conditions provided
      --format string   Pretty-print containers using a Go template
  -n, --last int        Show n last created containers (includes all states) (default -1)
  -l, --latest          Show the latest created container (includes all states)
      --no-trunc        Don't truncate output
  -q, --quiet           Only display numeric IDs
  -s, --size            Display total file sizes
```

### docker commit

可以将一个容器固化为一个新的镜像.

### events,history,logs 

events   打印实时的系统实践
histtory   打印指定镜像的历史版本信息
logs     打印出容器中进程的运行日志


```
docker events [OPTIONS]
docker history [OPTIONS] IMAGE
docker logs [OPTIONS] CONTAINER
```



