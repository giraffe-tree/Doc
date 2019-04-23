# Nginx 安装

## 1. 下载

目前(2018/9/11), nginx 最新稳定版为 1.14.0

```
cd /opt
mkdir nginx 
wget http://nginx.org/download/nginx-1.14.0.tar.gz

```

```
yum install -y gcc
yum install -y pcre
yum install -y zlib
yum -y install pcre-devel
yum -y install openssl openssl-devel

```


```
tar -zxvf nginx-1.14.0.tar.gz
```

```
cd nginx-1.14.0
./configure
make
make install
```

## 安装完成

nginx 将会安装在 ```/usr/local/nginx/```

```
/usr/local/nginx/sbin/nginx -t
```

return

```
nginx: the configuration file /usr/local/nginx/conf/nginx.conf syntax is ok
nginx: configuration file /usr/local/nginx/conf/nginx.conf test is successful
```
