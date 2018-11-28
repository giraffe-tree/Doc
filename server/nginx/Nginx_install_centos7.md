# Nginx install for centos7

## 依赖环境

1.GCC编译器
首先检查GCC是否安装，命令：gcc -v ,如果显示有相关版本信息，则说明已经安装好，没有就安装：

```yum install -y gcc```

2.PCRE库

Nginx的HTTP模块要用它来解析正则表达式。

```
yum install -y pcre pcre-devel 
```

pcre-devel是使用PCRE做二次开发时所需要的开发库。类似的你可以想到安装LAMP时安装的php-devel。

3.zlib库

gzip格式的压缩会用到它。

```yum install -y zlib zlib-devel```

4.OpenSSL库

```yum install -y openssl openssl-devel``` 

## nginx 安装

```
wget http://nginx.org/download/nginx-1.14.1.tar.gz
tar -zxvf nginx-1.14.1.tar.gz
cd nginx-1.14.1
./configure
make
make install
```



