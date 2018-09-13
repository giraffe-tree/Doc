# Nginx 负载均衡 和 健康检查

## 简介

从 nginx 下载, 到模块安装

## 关于为什么不使用 ngx_http_upstream_module

测试过 ngx_http_upstream_module 这个模块, 在应用稳定的情况下做做负载均衡还可以. 但一旦某一服务出现异常, 异常的发现和服务重启之后的恢复都比较缓慢.

## 使用版本

```sh
[root@chen]# nginx -v
nginx version: nginx/1.14.0
```

## 步骤

### 下载 nginx

从 nginx 官网下载最新稳定版:

```sh
wget http://nginx.org/download/nginx-1.14.0.tar.gz
```

我是下载到本地 ```/opt/nginx``` 中

```sh
tar -zxvf nginx-1.14.0.tar.gz
```

目录如下:

```sh
└── opt
	└── nginx
	    ├── nginx-1.14.0
	    └── nginx-1.14.0.tar.gz
```

### 下载 nginx-upstream-fair

下载并解压缩, 删除原压缩包

```sh
cd nginx-1.14.0
wget https://files.cnblogs.com/files/ztlsir/nginx-upstream-fair-master.zip
unzip nginx-upstream-fair-master.zip
rm nginx-upstream-fair-master.zip
```

### 下载 nginx_upstream_check_module

在 nginx-1.14.0 文件夹下

```sh
wget https://github.com/yaoweibin/nginx_upstream_check_module/archive/master.zip
unzip master.zip
rm master.zip
```

### 补丁

还是在 nginx-1.14.0 文件夹下

```sh
patch -p1 < ./nginx_upstream_check_module-master/upstream_fair.patch
patch -p1 < ./nginx_upstream_check_module-master/check_1.12.1+.patch
```

注意: 这里不能使用 ```check_1.14.0+.patch```

我在第一次安装的时候使用了 ```check_1.14.0+.patch``` , 报错如下: 

```
[root@chen]# patch -p1 < ./nginx_upstream_check_module-master/check_1.14.0+.patch
can't find file to patch at input line 4
Perhaps you used the wrong -p or --strip option?
The text leading up to this was:
--------------------------
|diff -burN nginx-1.14.0.orig/src/http/modules/ngx_http_upstream_hash_module.c nginx-1.14.0/src/http/modules/ngx_http_upstream_hash_module.c
|--- nginx-1.14.0.orig/src/http/modules/ngx_http_upstream_hash_module.c	2018-06-28 21:30:48.891580738 +0000
|+++ nginx-1.14.0/src/http/modules/ngx_http_upstream_hash_module.c	2018-06-28 21:40:41.801180483 +0000
```

没有仔细研究过 nginx , 但使用 ```check_1.12.1+.patch```的时候, 成功了

```sh
[root@chen]# patch -p1 < ./nginx_upstream_check_module-master/check_1.12.1+.patch
patching file src/http/modules/ngx_http_upstream_hash_module.c
Hunk #3 succeeded at 565 (offset 16 lines).
patching file src/http/modules/ngx_http_upstream_ip_hash_module.c
patching file src/http/modules/ngx_http_upstream_least_conn_module.c
patching file src/http/ngx_http_upstream_round_robin.c
patching file src/http/ngx_http_upstream_round_robin.h
```

### 配置安装

还是在 nginx-1.14.0 文件夹下

```sh
./configure --prefix=/usr/local/nginx --with-http_stub_status_module --with-http_ssl_module --with-http_gzip_static_module --with-pcre --add-module=./nginx_upstream_check_module-master --add-module=./nginx-upstream-fair-master
```

如果模块路径和我的不一致, 请修改路径.

这里如果输出以下内容, 基本上前面的步骤都对了 

```
adding module in ./nginx_upstream_check_module-master
checking for ngx_http_upstream_check_module ... found
 + ngx_http_upstream_check_module was configured
adding module in ./nginx-upstream-fair-master
 + ngx_http_upstream_fair_module was configured
```

最后

```sh
sudo make && sudo make install
```

最后如果没有 error 提示, 就算安装成功了.

## 测试

最后我测试了下健康检查的功能

为了方便, 我直接修改的 nginx.conf (默认安装目录在 /usr/local/nginx/conf/nginx.conf )

```
upstream backend {
    server 127.0.0.1:8081;
    server 127.0.0.1:8082;
    check interval=3000 rise=2 fall=5 timeout=1000 type=http;
	check_http_send "GET /status.html HTTP/1.1\r\nHost: 127.0.0.1\r\n\r\n";
	check_http_expect_alive http_2xx http_3xx ;
}

server {
        listen       80;
        server_name  localhost;

        location /abc/ {
            proxy_pass http://backend/;
        }
}

```

搭建了两个 web 服务器, 在8081和8082中轮询.

关掉一个后 nginx 的 error.log 会有日志输出

```
2018/09/11 19:46:04 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:07 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:10 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:13 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:16 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:16 [error] 18107#0: disable check peer: 127.0.0.1:8081
```

重新连接后会有:

```
2018/09/11 19:46:37 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:41 [error] 18107#0: send() failed (111: Connection refused)
2018/09/11 19:46:44 [error] 18107#0: recv() failed (104: Connection reset by peer)
2018/09/11 19:46:51 [error] 18107#0: enable check peer: 127.0.0.1:8081 
```




