# Docker 搭建 java 环境

## 参考

https://my.oschina.net/huangyong/blog/372491

https://dev.aliyun.com/search.html

## 查看centos内核 版本

uname -r

## 查看java是否已经安装

yum list installed | grep java

## 搜索java 

 yum list java*

## scp

 scp -P 52134 hello-0.0.1-SNAPSHOT.jar root@192.168.2.110:/hello/package/

 scp -P 22 hello-0.0.1-SNAPSHOT.jar root@47.97.199.139:/usr/local/tomcat/webapps


### ps

ps  -ef|grep docker

docker run -d  --name snore -p 8801:8080  -v /project/2018/mar/snore:/usr/local/tomcat/webapps -v /etc/localtime:/etc/localtime:ro tomcat:8-jre8


docker run -d  --name snore -p 8801:8080  -v /data/testPackage:/usr/local/tomcat/webapps -v /etc/localtime:/etc/localtime:ro


http://blog.csdn.net/github_37600255/article/details/56484235

docker run -d -p 8801:8801 --name snore1.1 snore:1.1

docker run -d -p 8801:8801 --name snore1.1 -v /etc/localtime:/etc/localtime:ro snore:1.0
