# 一分钟搞定 centos7 环境下 openresty 安装  

## 环境

一台新申请的阿里云 CentOS7 的服务器

## 安装

1. 安装工具包

	- 需要使用 `yum-config-manager` 这个工具
	- 安装这个工具 `yum -y install yum-utils`

2. 添加仓库地址并安装

	- `yum-config-manager --add-repo https://openresty.org/yum/cn/centos/OpenResty.repo`
	- `yum install openresty`

3. 添加 resty 命令行工具

	- `yum install openresty-resty`

		
## 简单使用

### helloworld

打印一个 helloworld 庆祝一下 hah

```
resty -e "ngx.say('hello world')"
```

### resty 和 openresty

#### `/usr/bin/openresty` 是什么?

这是一个二进制执行文件.

####  `/usr/bin/resty` 是什么?

它是一个 perl 脚本, 可以当做 openresty 的一个客户端

```
[root@centos7 ~]# which resty
/usr/bin/resty

[root@centos7 ~]# head -n 5 /usr/bin/resty 
#!/usr/bin/env perl

```

#### openresty 和 nginx 有什么关联?

openresty 本质上是启动了一个 nginx 服务

查看目录, 你会发现所谓的 openresty 就是 nginx

```
[root@centos7 bin]# pwd
/usr/local/openresty/bin
[root@centos7 bin]# ll
total 36
lrwxrwxrwx 1 root root    37 Jun  1 21:40 openresty -> /usr/local/openresty/nginx/sbin/nginx
-rwxr-xr-x 1 root root 34219 May 17 07:47 resty
```

启动

```
# 启动 openresty
openresty
```

这里相当于启动了一个 openresty

```
# 查看 nginx 进程
ps -ef | grep nginx
```

可以看到本质上, 在后台启动了一个 nginx 服务器, 监听了 80 端口. 可以使用 `curl localhost:80` 进行访问

```
# 关闭服务
openstry -s quit
```


### 配置

#### 再来写一个 http helloworld

写一个 nginx.conf 文件, 它的位置是 `/root/resty/conf/nginx.conf`

```nginx
events {
    worker_connections 1024;
}

http {
    server {
        listen 8080;
        location / {
            content_by_lua '
                ngx.say("hello, world")
            ';
        }
    }
}
```

来, 测试一下吧 =.=

```
[root@centos7 conf]# openresty -c /root/resty/conf/nginx.conf 
[root@centos7 conf]# curl localhost:8080
hello, world
[root@centos7 conf]# curl -i localhost:8080
HTTP/1.1 200 OK
Server: openresty/1.15.8.1
Date: Sat, 01 Jun 2019 14:16:29 GMT
Content-Type: text/plain
Transfer-Encoding: chunked
Connection: keep-alive

hello, world
```

### 其他模块

#### restydoc

```
yum install restydoc
```

使用方法

```
restydoc -s ngx.say
restydoc -s proxy_pass
```

