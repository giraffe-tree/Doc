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

### eureka 首页详解


Eureka server和client之间每隔30秒会进行一次心跳通信，告诉server，client还活着。由此引出两个名词： 

- Renews threshold：server期望在每分钟中收到的心跳次数 
- Renews (last min)：上一分钟内收到的心跳次数。

[参考](http://blog.csdn.net/zzp448561636/article/details/70198878)


#### spring.profiles.default

这个东西在 spirngboot 中貌似不能用了,一直不起作用,搞了老半天


## Eureka client

spring cloud 的 Eureka  从1.3到1.4变更很大,这里用的是1.4的

[spring-cloud-netflix/single/spring-cloud-netflix](http://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html)

[官方1.4文档参考](http://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.4.0.RELEASE/single/spring-cloud-netflix.html#netflix-eureka-client-starter)

```
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		<version>1.4.0.RELEASE</version>
	</dependency>
```


> By having spring-cloud-starter-netflix-eureka-client on the classpath your application will automatically register with the Eureka Server. Configuration is required to locate the Eureka server.
> 通过在类路径中使用spring-cloud-starter-netflix-eureka-client，您的应用程序将自动向Eureka服务器注册。当然,要找到Eureka服务器则需要配置



### 警告信息

> EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.

在一定的时间内 server 收到的心跳偏少就会出现这条提示


### eureka 安全认证问题

[官方文档参考](http://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.4.0.RELEASE/single/spring-cloud-netflix.html#_authenticating_with_the_eureka_server)

但是文档中并不详细,看的不怎么明白

[Securing Eureka in Spring cloud](https://stackoverflow.com/questions/28974752/securing-eureka-in-spring-cloud)


### Eureka’s Health Checks 健康检查









