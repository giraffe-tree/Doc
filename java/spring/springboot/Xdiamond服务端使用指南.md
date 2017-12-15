# Xdiamond服务端使用指南

## 项目来源

[https://github.com/hengyunabc/xdiamond](https://github.com/hengyunabc/xdiamond)

## 部署参考

#### linux 环境下

在tomcat的bin文件夹下查找```setenv.sh```,如果没有新建一个```setenv.sh```文件,并在文件中加入以下的语句:

```
JAVA_OPTS="$JAVA_OPTS -Dxdiamond.server.host=你的ip地址 -Dspring.profiles.active=product"
```

需要注意的是:这里使用的是product环境,使用的是mysql数据库;而如果使用的是dev环境,使用的是内嵌的H2数据库

然后将项目的war包放在tomcat的webApps文件下就可以了.

#### windows 环境下

在tomcat的bin文件夹下找到```catalina.bat```文件,在最开头加上以下语句:

```
set "JAVA_OPTS=%JAVA_OPTS% -Dspring.profiles.active=product"
```

## 数据库

若为product环境, 默认使用的是MySQL数据库,其地址为: 10.6.5.41:3306/xdiamond

如需修改,请修改 ```src/main/resources/config/application.product.properties```,并重新打包

## 登录

#### admin登录名/密码

用户名: admin
密码: hengtian@123

## 使用

当有项目需要从配置中心读取配置时

**首先要先在配置中心注册**

步骤如下:

1. 登录
2. 点击左侧 **项目管理**
3. 点击 **新建Project**
4. 将要注册项目的groupId,artifactId,version,description输入,选则 项目所在的人员组(可以在组管理中添加成员)

    - 还有两个默认选项
    - bPublic 指是否对其他成员可见,默认可见
    - bAllowDependency 指是否允许被其他项目依赖, 默认允许
    - 需要注意的是,我们需要同样在客户端的配置文件(如:xdiamond.yml)中设置好groupId,artifactId,version等,为了实现客户端project和服务端project的关联

5. 项目建立完成后,点击该项目的 **查看profile**, 进入之后会看到 base,dev,product,test 4个,分别指不同环境下的配置

    - base profile里放公共的配置，比如某个服务的端口号。所有的非base profile都会继承base profile里的Config
    - 对于product 会有一个默认生成的secretKey,如果客户端需要读取product的环境配置,则需要这个密钥,并配置在```xdiamond.client.secretKey```中

6. 点击 **查看config** 就可以查看已有的配置,并且会有配置的来源说明

    - 通过 **Add Config**即可添加当前环境下的配置

**当注册完以后,需要在客户端配置**

请参考另外一份文档: *Xdiamond客户端使用*

示例 ```xdianmond.yml```:

```
xdiamond:
  client:
    groupid: com.xxxxx
    artifactid: xxxxDemo
    version: 0.0.1-SNAPSHOT
    profile: dev
    secretkey: 123456
  server:
    host: localhost
    port: 5678
```

这里的 groupId,artifactId,version需要和服务端的 groupId,artifactId,version 一一对应,其中profile为你要获取的分支的配置(如dev,product,test等)

服务端如果在本地部署,则host为localhost,如果在其他机器上部署,请修改为它的ip

但是不管在哪部署,服务端的端口号默认为5678

