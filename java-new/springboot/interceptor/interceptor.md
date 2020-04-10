# interceptor 原理

## 应用

### 实现请求时长统计

可以使用拦截器 加上 ```threadLocalMap```  完成

### 存放用户信息

在代码中对web api作一个切面，存放一些如用户名等用户信息，在连接点方法结束后，再显式调用 `threadLocal.remove()`

## 参考

1. threadLocal 讲解

	- https://www.cnblogs.com/twoheads/p/9646415.html

2. AOP 实现 接口请求处理耗时监控

	- http://www.gxitsky.com/2019/11/30/springboot-app-47-aop-api-resp-time-watch/
	- 一种是 threadLocal + interceport
	- 另一种 AOP 环绕, 加强方法


