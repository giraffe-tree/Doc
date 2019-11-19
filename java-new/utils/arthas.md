# arthas

## 概述

arthas NB 就是了哈哈[滑稽]

- 进阶命令
	- https://alibaba.github.io/arthas/advanced-use.html

## 常用命令

- thread 一目了然的了解系统的状态，哪些线程比较占cpu？他们到底在做什么？
	- `thread -n 3`
	- 查找线程是否有阻塞
		- `thread -b`
	- 查看5秒内的CPU使用率top n线程栈
		- `thread -n 3 -i 5000`
- mc Memory Compiler/内存编译器，编译.java文件生成.class。
- redefine 加载外部的.class文件，redefine jvm已加载的类。
- stack
	- 查看方法 test.arthas.TestStack#doGet 的调用堆栈：
	- stack test.arthas.TestStack doGet
- Trace 观察方法执行的时候哪个子调用比较慢:
	- `trace test.arthas.TestStack doGet`
	- `trace me.giraffetree.demo.controller.CoreController testMethodName`
- watch 
	- 观察方法 test.arthas.TestWatch#doGet 执行的入参，仅当方法抛出异常时才输出。
		- `watch test.arthas.TestWatch doGet {params[0], throwExp} -e`
	- 观察方法超时
		- `watch com.example.demo.arthas.user.UserController * '{params, returnObj}' '#cost<100'`
- monitor
	- 监控某个特殊方法的调用统计数据，包括总调用次数，平均rt，成功率等信息，每隔5秒输出一次。 
	- ` monitor -c 5 org.apache.dubbo.demo.provider.DemoServiceImpl sayHello`
- Time Tunnel(tt)
	- 记录方法调用信息，支持事后查看方法调用的参数，返回值，抛出的异常等信息，仿佛穿越时空隧道回到调用现场一般。
	- `tt -t me.giraffetree.demo.controller.CoreController testMethodName`
- classloader
	- 了解当前系统中有多少类加载器，以及每个加载器加载的类数量，帮助您判断是否有类加载器泄露。
- 
- sysprop
	- sysprop 可以打印所有的System Properties信息。
	- 也可以指定单个key： sysprop java.version
	- 也可以通过grep来过滤： sysprop | grep user
	- 可以设置新的value： sysprop testKey testValue
- sysenv
	- sysenv 命令可以获取到环境变量。和sysprop命令类似。
- jvm
	- jvm 命令会打印出JVM的各种详细信息。
- dashboard
	- dashboard 命令可以查看当前系统的实时数据面板
- keymap
	- 快捷键
- history
	- 历史命令
- sc 查找已经加载的类
	- 例如 `sc -d me.giraffetree.service.AlgorithmService`
	- `-d` 可以打印类加载信息
- sm 命令则是查找类的具体函数
	- 通过-d参数可以打印函数的具体属性
- jad 反编译代码
	- 通过--source-only参数可以只打印出在反编译的源代码
- Ognl 可以动态执行代码
	- 可以看到每个方法执行的 参数
	- OGNL特殊用法请参考：https://github.com/alibaba/arthas/issues/71
	- OGNL表达式官方指南：https://commons.apache.org/proper/commons-ognl/language-guide.html
	- 静态函数
		- `ognl '@java.lang.System@out.println("hello ognl")'`
	- 获取静态类的静态字段
		- `ognl -c 1be6f5c3 @com.example.demo.arthas.user.UserController@logger`
		- 控制展开层数
			- `-c` 为 classloader 的 hashcode
			- `ognl -c 1be6f5c3 -x 2 @com.example.demo.arthas.user.UserController@logger`
			- `ognl -c 49c2faae -x 2 @com.example.demo.service.AlgorithmService@LOGGER`
- 案例: 热更新代码
	- 通过jad/mc/redefine 命令实现动态更新代码的功能。
- 案例: 动态更新应用Logger Level
	- Arthas 进阶 10/19
- 案例: 获取Spring Context
- 案例: 排查HTTP请求返回401
- 案例: 理解Spring Boot应用的ClassLoader结构 15/19
- reset
	- Arthas在 watch/trace 等命令时，实际上是修改了应用的字节码，插入增强的代码。显式执行 reset 命令，可以清除掉这些增强代码。
- exit/quit
	- 退出, 仍运行
- stop
	- 彻底退出Arthas

## docker

### 即使使用

docker exec -it async-aiqi /bin/bash -c "java -jar arthas-boot.jar"
docker exec -it  ${containerId} /bin/bash -c "wget https://alibaba.github.io/arthas/arthas-boot.jar && java -jar arthas-boot.jar"


### 镜像

把Arthas安装到基础镜像里
可以很简单把Arthas安装到你的Docker镜像里。

```Dockerfile
FROM openjdk:8-jdk-alpine

# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas
```







