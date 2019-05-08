# 用最快的速度搭建一个 HTTP2 网站

## 前言

啊啊啊, 前些天刚刚写了篇 如何搭建一个博客网站, 结果过了两天, 我的网站就崩了… 我#?!@#??? 那天 Google Cloud 的服务器突然宕机了 `The zone xxx does not have enough resources available `. google 了老半天, 啥都没用, 说是 GCP 的bug. 都是几年前的回答, 一点用都没. 关键是我还没备份, 妈耶, 我的数据啊!! 我在想要不就等它自己恢复吧, 到时候我把数据快照一下, 也不怕之后再宕机了. 结果, 我等啊等等啊等, 一天, 两天…一星期. 不行了, 自己重新搭吧.

100% 速度

## 搭建

重新买了台阿里云的国外服务器 -.- 开始~

### Nginx 安装

#### 依赖安装

```shell
# GCC编译器 
yum install -y gcc

# Nginx的HTTP模块要用它来解析正则表达式。
yum install -y pcre pcre-devel 

# gzip格式的压缩会用到它。
yum install -y zlib zlib-devel

# OpenSSL库
yum install -y openssl openssl-devel
```

#### Nginx模块安装

根据你自己的情况, 如果你是第一次安装`nginx`

```shell
wget http://nginx.org/download/nginx-1.14.1.tar.gz
tar -zxvf nginx-1.14.1.tar.gz
cd nginx-1.14.1
./configure --prefix=/usr/local/nginx --with-http_ssl_module --with-http_v2_module
make
make install
```

如果想要升级之前的`nginx`, 重新安装 `ssl, http2` 模块

```shell
wget http://nginx.org/download/nginx-1.14.1.tar.gz
tar -zxvf nginx-1.14.1.tar.gz
cd nginx-1.14.1
./configure --prefix=/usr/local/nginx --with-http_ssl_module --with-http_v2_module
make
# 备份
cp /usr/local/nginx/sbin/nginx /usr/local/nginx/sbin/nginx.bak
cp ./objs/nginx /usr/local/nginx/sbin/
## 查看当前nginx 版本信息及编译选项
/usr/local/nginx/sbin/nginx -V
rm /usr/bin/nginx
# 加入常用命令
ln /usr/local/nginx/sbin/nginx /usr/bin/nginx
```

#### 配置

1. `/usr/local/nginx/conf/nginx.conf` 中加入 `include /usr/local/nginx/conf/conf.d/*.conf;` , 加入位置如下, 只要加入这行就行, 用`#` 的注释我这边删除了

```nginx
# 参考
http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;

    include /usr/local/nginx/conf/conf.d/*.conf;
    
    server {
        listen       80;

# .....略
```

2. 在`/usr/local/nginx/conf/` 目录下建立文件夹 `conf.d`, 新建两个文件 `xxx.443.conf` ,`xxx.80.conf`, 名字随便取.
   - 阿里云上可以免费申请`SSL` 证书 https://www.aliyun.com/product/cas
   - 证书申请后, 把证书放到`ssl_certificate`指定位置就可以了

```nginx
# xxx.443.conf 的内容如下, 域名设定成自己的哦
server {
        listen  443 ssl http2;
        server_name giraffetree.me;
        
    	# ssl 证书
        ssl_certificate      /usr/local/nginx/conf/conf.d/cert/giraffetree.me.pem;
        ssl_certificate_key  /usr/local/nginx/conf/conf.d/cert/giraffetree.me.key;
    ssl_session_timeout  5m;
    # 下面这行不写会导致浏览器报出 ERR_SSL_PROTOCOL_ERROR 错误
	ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
	ssl_ciphers 'ECDHE-RSA-AES256-GCM-SHA384:ECDHE-RSA-AES128-GCM-SHA256:DHE-RSA-AES256-GCM-SHA384:DHE-RSA-AES128-GCM-SHA256:ECDHE-RSA-AES256-SHA384:ECDHE-RSA-AES128-SHA256:ECDHE-RSA-AES256-SHA:ECDHE-RSA-AES128-SHA:DHE-RSA-AES256-SHA256:DHE-RSA-AES128-SHA256:DHE-RSA-AES256-SHA:DHE-RSA-AES128-SHA:ECDHE-RSA-DES-CBC3-SHA:EDH-RSA-DES-CBC3-SHA:AES256-GCM-SHA384:AES128-GCM-SHA256:AES256-SHA256:AES128-SHA256:AES256-SHA:AES128-SHA:DES-CBC3-SHA:HIGH:!aNULL:!eNULL:!EXPORT:!CAMELLIA:!DES:!MD5:!PSK:!RC4';
	ssl_prefer_server_ciphers  on;	

	location / {
	    root /root/data/web;
	    index index.html;
	}
}
```

```nginx
# xxx.80.conf 的内容如下, 域名设定成自己的哦
server {
	listen 80;
	server_name giraffetree.me;
	add_header Strict-Transport-Security max-age=600;
	return 307 https://giraffetree.me$request_uri;
}
```

```shell
# /usr/local/nginx/conf/conf.d 下的 目录结构
./
├── cert
│   ├── giraffetree.me.key
│   └── giraffetree.me.pem
├── giraffetree.me.443.conf
└── giraffetree.me.80.conf

```

#### 检查配置, 并启动

```shell
# 检查配置有没有问题
nginx -t
# 第一次启动
nginx
# 重新加载配置文件, 重启
nginx -s reload
```

访问如: [giraffetree.me](https://giraffetree.me)

#### 检查 http2 是否启动

下载 chrome 的扩展程序 `HTTP/2 and SPDY indicator`, 会有一个闪电标志, 亮了就代表配置成功啦! 

## 最后

创建快照策略, 选择磁盘 .  选择珍爱生命, 每天备份  -.-



 =.= 有什么疑问欢迎提问

**邮箱:** giraffetree1@gmail.com

**github:** [github.com/giraffe-tree](https://github.com/giraffe-tree)

