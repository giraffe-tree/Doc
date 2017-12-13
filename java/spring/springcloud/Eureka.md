# Eureka  -- Service registration and discovery

Eureka是基于REST（Representational State Transfer，代表性状态传输）的服务，主要用于AWS云中定位服务，以实现中间层服务器的负载平衡和故障转移。

java -jar eureka-server1-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1

```
配置defaultZone相互注册。注意：这里的url需要使用对方的hostname，即http://peer1:1111/eureka/中，需要使用peer1，而不能使用localhost或者127.0.0.1,否则Eureka注册中心会认为另外一个注册中心是unavailable的。这里的原因笔者认为是通过hostname来进行判断的，并没有深入了解。不过如果不这样使用，的确会出现问题。
```

```
命令行(cmd)运行:ipconfig /flushdns     #清除DNS缓存内容。
ps:ipconfig /displaydns    //显示DNS缓存内容
```


```
spring:
  application:
    name: eureka-server1
  profiles: peer1
server:
  port: 8801

eureka:
  instance:
    hostname: peer1
  client:
    register-with-eureka: true
    fetch-registry: true
    serviceUrl:
      defaultZone: http://eureka.didispace.com/eureka/

#      defaultZone: http://peer2:8002/eureka/
```
