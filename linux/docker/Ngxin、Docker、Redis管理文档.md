# Ngxin、Docker、Redis管理文档

## Nginx

Nginx是一个高性能的HTTP和反向代理服务器，安装在linux上作为服务运行。

配置目录 /etc/nginx/

常用命令 ：

	service nginx start/restart/status/stop  
	nginx –t   加载配置文件
	nginx –s reload 重启nginx

nginx 日志目录不同服务器位置不同 

例如心电  /var/logs/nginx  （具体位置看下nginx的配置文件就可以了）

查看日志就是用linux 指令 tail 或者其他指令

如：tail -f -n 100 access.log

## Docker

Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。安装在linux上作为服务运行。为软件提供完整的运行环境，省去配置环境的过程，项目中的tomcat就是运行在docker内的。

使用例子：

打包好的docker 应用是一个个镜像，通过pull命令下载镜像，比方使用java8的tomcat通过命令docke pull tomcat:8-jre8下载，下载好的镜像通过命令create/run 创建成实例运行的同时取一个名称，创建成实例之后，就可以针对实例名称通过stop/start/restart操作了。

Create命令创建实例但不运行，run命令创建实例并运行。

docker run -d -p 89:8080 -v /data/testPackage:/usr/local/tomcat/webapps -v /etc/localtime:/etc/localtime:ro --name test tomcat/8-jre8

创建一个tomcat:8-jre8镜像的实例

--name test表示取名test

-d 表示在后台运行

-p 89:8080 表示把容器内的8080端口映射到外部的89端口，tomcat默认是8080

-v /var/www/webapps:/usr/local/tomcat/webapps 表示把容器内的tomcat默认路径映射到外部的webapps路径，这样方便我们在外部发布webapp

-v /etc/localtime:/etc/localtime:ro 

映射时间目录到内部，解决tomcat时间不同步问题，:ro表示本次目录映射是只读的

这样就创建完了实例，然后通过docker start 

test来运行这个实例，tomcat就跑起来了

docker ps 查看当前运行的实例

docker stop test停止实例test

docker restart test重启实例test

docker logs –f –tail 100 test 查看实例test的日志，显示最近的100行

docker rm test删除实例test

## redis 

Redis基于内存亦可持久化的日志型、Key-Value数据库

注意：体温的redis 是安装在docker内的镜像，操作指令参照docker命令

心电是作为独立的linux服务运行的

安装目录：/usr/redis/

启动redis： 

在redis安装目录下运行  ./redis-server &  （& 是以后台程序方式运行redis）

或者  ./redis-server +redis配置文件（位置不同机器自己搜索）

停止：redis-cli -h 127.0.0.1 -p 6379 shutdown

或者直接杀进程
