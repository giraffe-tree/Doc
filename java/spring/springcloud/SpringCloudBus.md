# Spring Cloud Bus

## 简单介绍

Spring Cloud Bus 将分布式系统的节点和消息代理连接起来,你可以通过Spring Cloud Bus进行应用程序之间的交互,可以称它为 **消息总线**

## 须知

1. 要使用spring cloud bus 必须先安装rabbitMQ, kafka等消息队列.
2. 本文示例使用的是rabbitMQ , 基于应用层协议AMQP
3. 本文示例基于Spring Cloud,所以需要对 Spring Cloud 有一定的了解
4. 本文主要的目的: 用Spring Cloud Bus实现通知各个微服务,更改它们的配置文件,甚至完成一定意义上的热更新.

## 下载安装 RabbitMQ

参见:

- [RabbitMQ 官网](http://www.rabbitmq.com/)
- [windows下 安装 rabbitMQ 及操作常用命令](https://www.cnblogs.com/ericli-ericli/p/5902270.html)

## 具体步骤

0. 首先需要一个spring cloud config 的服务端和客户端,并且都连在eureka的服务中心上

1. 在spring cloud config的服务端上 pom文件中加入

    ```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
    ```

2. 配置rabbitMQ 地址

    ```
        spring.rabbitmq.host=localhost
        spring.rabbitmq.port=5672
        spring.rabbitmq.username=guest
        spring.rabbitmq.password=guest
    ```

3. 更改远程git仓库中的配置信息,用post方式访问 ```/bus/refresh```,实现服务重启更新

    **第三步过程如下:**

    1. 提交代码触发post请求给bus/refresh
    2. server端接收到请求并发送给Spring Cloud Bus
    3. Spring Cloud bus接到消息并通知给其它客户端
    4. 其它客户端接收到通知，请求Server端获取最新配置
    5. 全部客户端均获取到最新的配置

### 另一种方式

可以在spring cloud config的客户端上加入上述```具体步骤```中配置,可以实现在客户端用post方式访问 ```/bus/refresh```,通知config 服务端,完成所有该服务客户端的更新.

但是这种做法,打破了微服务的职责单一性。微服务本身是业务模块，它本不应该承担配置刷新的职责。所以推荐在config 服务端中配置上述的属性

## 自动更新

如果你觉得采用post请求方式访问```/bus/refresh```的方法不方便,可以利用git上的webhook工具进行自动的更新

比如github上:

    1. 选择你想要监控的config的repository
    2. 进入```settings```
    3. 点击左边第四个选项```Webooks```
    4. 你可以选择 ```add webhook```
    5. 添加```/bus/refresh```的请求
    6. 选择需要响应的事件,比如```push```


