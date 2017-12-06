# XDiamond

## 发布

1. 将```mvn package```将项目打成war包
2. 将项目放入tomcat 的webApps文件夹下
3. 修改conf文件夹下的server.xml,更改host标签[参考](https://www.cnblogs.com/hihtml5/p/5741179.html)/或者复制webApps
4. 启动tomcat 使用dev环境```JAVA_OPTS="$JAVA_OPTS  -Dspring.profiles.active=product"```



## 数据库

### 为什么要用数据库

- 典型的多读少写（类似传统的web服务）
- 数据库的灾备很成熟，master-master或者master-slave都可以
- 基于数据库比较容易做权限控制（不只是web界面的权限，还要防止恶意读写配置）

以下为表名,以及它们的作用

- config :

- dependency : 记录项目之间的依赖
- profile:
- project:

- group :id+组名
- group_roles :组和角色关联
- role:角色
- role_permissions:角色权限关联
- permission:权限
- user:用户
- user_groups:用户组关联
- user_roles: 用户角色关联

### tomcat 启动参数配置

## 权限

使用```shiro```做的权限控制

Group里的用户有access等级，分别为：owner, master, developer, reporter, guest。 只有owner/master的用户才可以查看修改product环境下的配置。

项目的profile都有access级别。

项目都有一个ownerGroup，据用户在ownerGroup里的access，则可以访问相应级别的profile。

在数据库中的```user_groups```中有```access```一列,其中

```
guest = 10;
reporter = 20;
developer = 30;
master = 40;
owner = 50;
```



## 缓存 Ehcache

## 服务端 server

### 部署参考

#### linux 环境下

在tomcat的bin文件夹下查找```setenv.sh```,如果没有新建一个```setenv.sh```文件(一般如果你没有部署过环境就没有),并在文件中加入以下的语句:

```
JAVA_OPTS="$JAVA_OPTS -Dxdiamond.server.host=10.6.5.41 -Dspring.profiles.active=product -Dxdiamond.project.secretkey=b8ylj4r0OcBMgdNU"

```

然后将项目的war包放在tomcat的webApps文件下就可以了.

#### windows 环境下

在tomcat的bin文件夹下找到```catalina.bat```文件,在最开头加上以下语句:

```
set "JAVA_OPTS=%JAVA_OPTS% -Dspring.profiles.active=product"
```


## 客户端

### 如何在自己的项目中集成



### Client的启动流程

通常情况下，XDiamond配置中心不需要配置为集群。因为Client会在本地缓存一份配置到home目录下。

- 如果连接上则获取最新的配置，然后原子保存最新的配置到home/.xdiamond目录下
-如果连接Xdiamond Server失败，则会尝试从本地home/.xdiamond目录下读取最后保存的配置
所以，Client除了是第一次启动之外，都可以正常启动。

例子中```xdiamond-client-example```运行```io.github.xdiamond.example.ClientExampleMain```默认是获取product环境的配置
