# Eureka

## Eureka 概述

Eureka是一个提供服务注册和服务发现的服务系统.主要用于AWS云中定位服务，以实现中间层服务器的负载平衡和故障转移。


## 服务端

### 最简启动 Eureka

1. 打开```https://start.spring.io/```, 新建一个springboot项目,添加```Web,Eureka server```的依赖,导入IDE
2. 在springboot 项目的Application启动类上加上注解```@EnableEurekaServer```

```
@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaDemoApplication.class, args);
    }
}
```

3. 启动```SpringEurekaDemoApplication.class```

显示以下显示时,说明你已经启动成功了

```
Tomcat started on port(s): 8080 (http)
Started SpringEurekaDemoApplication in 14.685 seconds (JVM running for 16.037)
```

然后你可以打开页面:```http://localhost:8080```,出现```spring eureka```页面即成功

不过你可能会遇到一些报错的信息,如:

```
java.net.ConnectException: Connection refused: connect
Cannot execute request on any known server
There was a problem with the instance info replicator
```

不要担心,我们之后会解决.


### 简单配置

为了便于修改配置, 我们这里将修改```src/main/resources```目录下```applicaiton.properties```文件的后缀,将文件名改为```application.yml```,

然后修改```application.yml```文件

1. 添加端口号

```
server:
  port: 8888
```

2. 添加 eureka配置

- registerWithEureka: 是否将自己注册到eureka 服务器上,默认为true
- fetchRegistry: 是否从服务器上抓取注册信息,默认为true

```
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

3. 再次启动```SpringEurekaDemoApplication.class```

你会发现log中输出```Started Eureka Server```,而且之前的错误信息都不见了.这是因为它不能从自身抓取注册信息

4. 打开 ```http://localhost:8888```,你会看到页面

5. 再次修改```application.yml```,将```registerWithEureka```改为```true```,其他不变

```
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: true
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

6. 再次打开 ```http://localhost:8888```,你会发现Instances currently registered with Eureka下多了一个application

这是因为eureka把自己注册到服务器上了

### 更多的了解

#### Environment 和 Data center

增加配置:```eureka.environment```和```eureka.datacenter```

```
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: true
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
  environment: dev
  datacenter: datacenter
```

打开```http://localhost:8888```,你会发现左上角system status中environment 和 data center的值改变了,之前使用的是默认值test和default

#### 右上角的信息解释

last 1000 since startup  最近一千次注册信息

- Current time   当前时间
- Uptime   持续时间
- Lease expiration enabled   是否启动到期去除注册信息
- Renews threshold    预估收到的心跳量
- Renews (last min)     上一分钟收到的心跳量


#### applcation 名称

增加配置```spring.application.name```

```
spring:
  application:
    name: spring-eureka
```

打开页面,它会改变```Instances currently registered with Eureka```下的application的名称,并且将其全部大写

#### ceneral info

在页面中,```Instances currently registered with Eureka```下,有```ceneral info```

它的意思是:eureka服务中心的状态信息

#### instance info

在页面中最底部有``` instance info```

它的意思是: 当前这个eureka服务实例的状态信息:IP地址和状态




