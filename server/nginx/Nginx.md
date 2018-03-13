# Nginx

## 参考 

深入理解 Nginx 模块开发与架构解析  --  陶辉

https://nginx.weebly.com/

http://nginx.taohui.org.cn/

# 第一章 研究 Nginx 前的准备工作

## 1.2  why we choose Nginx

1. 更快 
2. 高扩展性
3. 高可靠性
4. 低内存消耗  10000个HTTP Keep-Alive 连接仅消耗 2.5M 内存,这是 nginx 支持高并发连接的基础.
5. 单机支持10万以上的并发连接
6. 热部署 

	- master 管理进程与 worker 工作进程的分离设计,使得 nginx 能够提供热部署功能
	- 它支持不停止服务就更新配置项,更换日志文件等功能

7. 最自由的 BSD 许可协议

## 1.3 准备工作

### 查看内核版本

```uname -a```

> Linux iZbp193yy46icaga1srlt6Z 3.10.0-693.2.2.el7.x86_64 #1 SMP Tue Sep 12 22:26:13 UTC 2017 x86_64 x86_64 x86_64 GNU/Linux

### 内核参数优化

```/etc/sysctl.conf```

### nginx 配置地址

nginx的配置文件在  ```/etc/nginx/nginx.conf```

自定义的配置文件放在 ```/etc/nginx/conf.d```

项目文件存放在 ```/usr/share/nginx/html/```

日志文件存放在 ```/var/log/nginx/```

还有一些其他的安装文件都在 ```/etc/nginx```

### nginx 启动

#### 默认启动

nginx

#### 另行制定配置文件启动

-c

#### 另行制定安装目录的启动方式

-p

#### 另行制定全局配置的启动方式

-g 

#### 测试配置文件是否有错误

nginx -t 

使用 -q 参数可以不把 error 级别以下的信息输出到屏幕

nginx -t -q

### nginx 版本

nginx -v

nginx -V 

### 快速地停止服务

nginx -s stop ???

### 查看 nginx 进程

ps -ef | grep nginx

#### kill it

root      4362  4164  0 22:29 pts/1    00:00:00 grep --color=auto nginx

kill -s SIGINT 4362   ---> 无效??

### 查看帮助

```nginx -h``` 或者 ```nginx -?```

```
Usage: nginx [-?hvVtTq] [-s signal] [-c filename] [-p prefix] [-g directives]

Options:
  -?,-h         : this help
  -v            : show version and exit
  -V            : show version and configure options then exit
  -t            : test configuration and exit
  -T            : test configuration, dump it and exit
  -q            : suppress non-error messages during configuration testing
  -s signal     : send signal to a master process: stop, quit, reopen, reload
  -p prefix     : set prefix path (default: /usr/share/nginx/)
  -c filename   : set configuration file (default: /etc/nginx/nginx.conf)
  -g directives : set global directives out of configuration file
```

# 第二章 nginx 的配置

## 运行中的 nginx 进程间的关系


部署 nginx 时,都是使用一个 master 进程来管理多个 worker 进程,一般情况下, worker 进程的数量与服务器上的 cpu 核心数相等.

worker 进程之间通过共享内存,院子操作等一些进程间通信机制来实现负载均衡.

### 为什么要在产品环境下按照 master-worker 方式配置同时启动多个进程?

1. master 进程不会对用户请求提供服务,只用于管理 worker 进程.

2. 多个 worker 进程处理互联网请求,可以提高服务的健壮性.当一个 worker 进程出错,其他 worker 进程仍然可以正常提供服务.

3. apache 的每个进程,在一个时刻只处理一个请求. 当一台服务器拥有几百个工作进程后,大量的进程间切换,将带来无谓的系统资源消耗.

4. nginx中一个 worker 进程可以同时处理的请求数,只受限于内存大小. 不同 worker 进程之间处理并发请求时,几乎没有同步锁的限制, worker 进程通常不会进入睡眠状态.当 nginx 上的进程数与 cpu 核心数相等时,进程间切换的代价最小.

### nginx.conf

```
# For more information on configuration, see:
#   * Official English Documentation: http://nginx.org/en/docs/
#   * Official Russian Documentation: http://nginx.org/ru/docs/

user nginx;
worker_processes auto;
error_log /var/log/nginx/error.log;
pid /run/nginx.pid;

# Load dynamic modules. See /usr/share/nginx/README.dynamic.
include /usr/share/nginx/modules/*.conf;

events {
    worker_connections 1024;
}

http {
    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile            on;
    tcp_nopush          on;
    tcp_nodelay         on;
    keepalive_timeout   65;
    types_hash_max_size 2048;

    include             /etc/nginx/mime.types;
    default_type        application/octet-stream;

    # Load modular configuration files from the /etc/nginx/conf.d directory.
    # See http://nginx.org/en/docs/ngx_core_module.html#include
    # for more information.
    include /etc/nginx/conf.d/*.conf;

    server {
        listen       80 default_server;
        listen       [::]:80 default_server;
        server_name  _;
        root         /usr/share/nginx/html;

        # Load configuration files for the default server block.
        include /etc/nginx/default.d/*.conf;

        location / {
        }

        error_page 404 /404.html;
            location = /40x.html {
        }

        error_page 500 502 503 504 /50x.html;
            location = /50x.html {
        }
    }

# Settings for a TLS enabled server.
#
#    server {
#        listen       443 ssl http2 default_server;
#        listen       [::]:443 ssl http2 default_server;
#        server_name  _;
#        root         /usr/share/nginx/html;
#
#        ssl_certificate "/etc/pki/nginx/server.crt";
#        ssl_certificate_key "/etc/pki/nginx/private/server.key";
#        ssl_session_cache shared:SSL:1m;
#        ssl_session_timeout  10m;
#        ssl_ciphers HIGH:!aNULL:!MD5;
#        ssl_prefer_server_ciphers on;
#
#        # Load configuration files for the default server block.
#        include /etc/nginx/default.d/*.conf;
#
#        location / {
#        }
#
#        error_page 404 /404.html;
#            location = /40x.html {
#        }
#
#        error_page 500 502 503 504 /50x.html;
#            location = /50x.html {
#        }
#    }

}

```

## 2.3 Nginx 服务的基本配置

nginx 在运行时,至少要加载几个核心模块和一个事件类模块

这些模块在运行时所支持的配置项,即为基本配置

按照用户使用时的预期功能分成以下4类

1. 用于调试/定位问题的配置项
2. 正常运行的必备配置项
3. 优化性能的配置项
4. 事件类配置项

### 2.3.1 用于调试/定位问题的配置项

#### 1. 是否以守护进程方式运行 nginx

默认: 

```
daemon on;  
# daemon off;
```

#### 2. 以 master/worker 方式工作

默认:

```
master_process on;
```

#### 3. error 日志设置

语法: ```error_log /path/file level;```

```
# error_log logs/error.log error;
error_log /var/log/nginx/error.log;
```

日志的输出级别: 

```
debug
info
notice
warn
error
crit
alert
emerg
```

#### 4. 是否处理几个特殊的调试点

语法:```debug_point [stop|abort]```

#### 5. 仅对指定客户端输出 debug 级别的日志

语法:```debug_connection [IP|CIDR]```

```
events {
	debug_onnection 10.224.66.14;
	debug_onnection 10.224.66.1;

}
```

在使用 debug_connection 之前,确保在指定 configure 时已经加入 ```--with-debug```


#### 6. 限制 coredump 核心转储文件大小

```worker_rlimit_core size;```

限制记录出错的文件的大小

#### 7. 指定 coredump 文件生成位置

```working_directory path;```

worker进程的工作目录

### 2.3.2 正常运行的配置

#### 1. 定义环境变量

```env VAR=VALUE```

这个配置项,可以让用户直接设置操作系统上的环境变量

```
env TESTPATH=/tmp/
```

#### 2. 嵌入其他配置文件

```include /path/file```


```
include mime.types
include vhost/*.conf
```

#### 3. pid 文件的路径

```pid path/file```

默认:

```pid logs/nginx.pid```


#### 4. Nginx Worker 进程运行的用户及用户组

```user username [groupname]```

```
username nobody nobody
```

#### 5. 指定 nginx worker 进程可以打开的最大句柄描述符个数

worker_rlimit_sigpending limit;

设置每个用户发往 nginx 的信号队列大小.


### 2.3.3 优化性能的配置

#### 1. Nginx worker 进程个数

```worker_processes number;```

默认:

```
worker_processes 1;
```

多 worker 进程可以充分多核系统架构,但若 worker 进程的数量多于 cpu 内核数,那么会增大进程间切换带来的消耗(Linux 是抢占式内核).

#### 2. Nginx 进程绑定到指定 cpu 内核

```worker_cpu_affinity cpumask```

```
worker_processes 4;
worker_cpu_affinity 1000 0100 0010 0001;
```

#### 3. ssl 硬件加速

```ssl_engine device```

#### 4. 系统调用 gettimeofday 频率

```timer_resolution t```

#### 5. Nginx worker 进程优先级设置

```worker_priority nice;```

默认:

```
worker_prority 0;
```

nice 的值为 -20 ~ 19 , -20 为最高优先级

### 2.3.4 事件类配置项











