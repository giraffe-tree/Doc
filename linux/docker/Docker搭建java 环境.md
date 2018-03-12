# Docker 搭建 java 环境

## 参考

https://my.oschina.net/huangyong/blog/372491

## 查看centos内核 版本

uname -r

## 查看java是否已经安装

yum list installed | grep java

## 搜索java 

 yum list java*

## scp

 scp -P 52134 hello-0.0.1-SNAPSHOT.jar root@192.168.2.110:/hello/package/

