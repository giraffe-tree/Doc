# 阿里云上的 serverless 实践

## TODO

### 异步如何保证事务 在同一个 数据库连接 session 中


### dynamoDB 和 tablestore

都是基于 google 的 bigtable 论文做的



## 其他

### faas vs baas

Faas/baas

fuction as a service
backend as a service

### 无状态 stateless

函数计算并不是无状态的, 可以用 rds 维护这个这个状态

把状态存到共享的机器中, 当服务挂掉之后也可以自动重试

### 依赖包过大问题

官方提供的解决方案是, 在同一个vpc下, 通过nas挂载, 将nas挂载到对应函数上执行的一个目录上.

### 持久化问题

在全局变量中初始化一次数据库连接，后面的同一个执行环境多次调用都会复用这个的.
简单来说, 需要使用一个

使用阿里云的rds

### 流控问题

上游服务不能压垮下游服务

### 宕机快照迁移

宕机事件触发 -> 快照 -> 迁移

### 函数间调用问题

通过api接口解决

### idea 调试

https://blog.csdn.net/xstardust/article/details/84989300

### 函数冷启动问题

https://yq.aliyun.com/articles/672416

### python tensorflow

1. nas 上传tensorflow 依赖
2. 使用 fun 工具 https://yq.aliyun.com/articles/688062

### 权限

NoPermissionError: You are not authorized to do this action. Resource: acsram:xxxxxxxxxx:role/ Action: ram:GetRole

授权 AliyunRAMFullAccess 已解决, 但为什么要那么高的权限呢?

https://github.com/aliyun/fun/blob/84b0a928a4579cc8bccc948d24f526f35500b189/docs/usage/faq-zh.md

### 日志如何记录

test log-server 中

### 调用其他服务的函数

使用api接口

1. config
2. InvokeFunctionRequest, 如果使用http trigger 则使用 httpInvokeFunctionRequest
3. FunctionComputeClient

### 异步请求过多问题

如果是异步请求, 函数计算会按照最大并发度, 通过队列来做削峰填谷

### 上传代码包不一致/不完整 -- 如何保证上传的文件是完整的

在代码上传前/代码上传后/创建容器前做checksum 校验

### 底层数据库模块如何架构

很难去抽象一些数据库操作  -> 使用 graphQL

### 定制镜像

阿里云函数计算目前 不能定制镜像

