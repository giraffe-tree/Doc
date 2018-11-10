# question & inspiration

## 2018/05/28

read 深入理解java虚拟机

1. JIT编译器  P241
2. spring dispatch servlet 具体执行顺序
3. spring transaction 为什么能达到事务
4. 操作数栈与局部变量表的共享区域 P243
5. spring boot 2.0 Test

## 2018/05/29

1. 框架是如何注册 bean 的
2. lombok 使用
3. 动态代理 Dynamic proxy

## 2018/05/30

1. 反射

	https://www.sczyh30.com/posts/Java/java-reflection-1/#%E4%B8%80%E3%80%81%E5%9B%9E%E9%A1%BE%EF%BC%9A%E4%BB%80%E4%B9%88%E6%98%AF%E5%8F%8D%E5%B0%84%EF%BC%9F

	http://www.importnew.com/21211.html java反射在jvm的实现

2. invoke
3. G1 CMS
4. 尝试写一个简单的mvc框架
	
	bean 注册
	aop 实现


## 2018/05/31

1. jdk 动态代理

	```System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");```  没生成文件?

2. Arduino机器人权威指南
3. jit 编译器

	https://www.cnblogs.com/insistence/p/5901457.html

4. 接口限制 65535
5. javac 编码GBK的不可映射字符

	 ```javac -encoding utf-8 Test.java```

6. 查看 javac 源码
7. 编译器插件
8. 从表及里学习jvm
	
	- https://www.douban.com/doulist/2545443/
	- 自制编程语言

## 2018/06/01

1. kotlin 

	- hello world √
	- spring boot √

2. java 语法糖
	
	- 自动拆装箱
	- 泛型
	- switch String

## 2018/06/03

1. 算法基础

	数据结构是算法的副产品或是结果

2. 计算二次函数的解
	
	递归执行?

3. java char 两个字节
4. 方法调用时,是值传递还是引用传递
5. java.lang包 不用导 
6. 句柄 指针的指针

## 2018/06/04

1. kotlin koans

	https://github.com/Kotlin/kotlin-koans
	https://try.kotlinlang.org/#/Kotlin%20Koans/Introduction/Hello,%20world!/Task.kt

## 2018/06/05

1. kotlin 编译慢  √

	org.gradle.daemon=true
	kotlin.incremental=true 

	https://droidyue.com/blog/2018/01/31/how-to-speed-up-kotlin-compilation/

## 2018/06/06

## 2018/06/07

## 2018/06/08

1. kotlin 20小时

	将对象和函数分开
	2 + 

2. codewars 刷题

## 2018/06/11

1. redis 密码验证失败,可能原因排查  √
	
	密码加单引号解决

2. mysql 事务是怎么实现的

	https://www.cnblogs.com/songjy2116/p/7881294.html

## 2018/06/12

1. kotlin 中的扩展方法并不能访问私有成员,实质上为静态函数,所以不能被子类重写

2. kotlin 展开运算符 P60 

	```listOf("args:",*args)```

## 2018/06/13

1. java8还提供了parallelStream()来启动并行流式处理，parallelStream()本质上基于java7的Fork-Join框架实现，其默认的线程数为宿主机的内核数

2.

## 2018/06/14

1. ForkJoinPool

2. Java中普通lambda表达式和方法引用本质上有什么区别？

	https://www.zhihu.com/question/51491241/answer/126232275

3. https://stackoverflow.com/tags/scala/info

1. lambda 匿名函数的区别
	
	- 匿名类中 this代表类本身,而lambda中代表的是包含类
	- 匿名类可以屏蔽包含类的变量,而lambda不能屏蔽,而且会报编译错误
	- http://dig.cs.illinois.edu/papers/lambdaRefactoring.pdf

2. lambda debug 困难

3. 默认方法和多继承

4. 二进制级兼容性, 源代码,函数行为

5. 抽象接口,必须由接口继承

6. 函数式接口只含有一个抽象方法,默认方法是非抽象方法



## 2018/06/15

1. java 中接口的静态方法

	- 竟然可以没有实现就直接调用!

2. 柯里化 
	
	- 接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数

3. 模式匹配 / switch

4. 引用的透明性原则:
	
	使用相同的参数产生同样的结果

5. ```javap -v xxx.class``` 打印class文件详情

6. 如何分流?

	- spliterator 会返回集合类型而不是单纯的stream
	- 

7. java 静态接口

	静态内部

8. 并发与并行

	- 多线程的上下文切换
	- 线程间的调度和切换的成本远远小于进程

## 2018/06/18

1. transient 与序列化

2. java 泛型数组,避免对象游离(利于垃圾回收)

## 2018/06/19

1. 静态内部类和内部类

	反编译后:

	```
	class Test$NormalTest {
	    Test$NormalTest(Test var1) {
	        this.this$0 = var1;
	    }
	}
	class Test$StaticTest {
	    Test$StaticTest() {
	    }
	}
	```

2. java中的逆变与协变 covariant

	```
	List<? extends Number> list = new ArrayList<Number>();
        list.add(new Integer(1)); //error
	```

	协变就是用一个窄类型替代宽类型
	逆变则用宽类型覆盖窄类型。

	故此处用```? super Number```

	https://blog.csdn.net/u014717036/article/details/52234679

3. Java OutOfMemoryError 

	```int[] ints = new int[Integer.MAX_VALUE];```
	```java -Xmx10M Test```

4. alibaba 编码规约

	插件下载

5. ```MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;```

6. 为什么 ArrayList 中使用```Object[]```存储元素,而不是使用泛型```E[]```
	
	https://stackoverflow.com/questions/25695011/why-does-arraylist-use-object-instead-of-e-internally

	不能创建泛型数组


	```
		public class Apple<T> {
	    int capacity;
	    T[] ts;
	    @SuppressWarnings(value = "unchecked")
	    public Apple(Class<T> clazz, int capacity) {
	        this.capacity = capacity;
	        this.ts = (T[]) Array.newInstance(clazz, capacity);
	    }
	```

7. 在jvm上实现 generics

8. scala 的起源 

	https://www.artima.com/scalazine/articles/origins_of_scala.html

9. 泛型和协变的关系

10. @Contract(value="",pure=true)

	https://zhuanlan.zhihu.com/p/24778947

	https://www.jetbrains.com/help/idea/contract-annotations.html


## 2018/06/20

1. ```Class JavaLaunchHelper is implemented in both```

	```idea.no.launcher=true```


## 2018/06/21

1. mysql 正则 

	```
	SELECT * FROM report where algorithm regexp '\"xxxx\":[1-9]';
	```

## 2018/06/22

1. debian

2. dry for docker 

3. 为什么要直接 return 一个语句

	- https://segmentfault.com/q/1010000008683475
	- 会多执行2个指令
	- i_store 弹出操作数栈栈顶元素,保存到局部变量表 
	- i_load 加载局部变量表的元素到操作数栈栈顶

## 2018/06/24

1. docker attach/events 能不能查看日志

2. redis 主从配置 

	mysql 的主从配置

3. docker 隔离

	- 进程隔离 namespace
	- 文件系统隔离  mount 共享/从属/私有/不可绑定
	- 网络隔离 network namespace
	- 用户隔离 id
	- 主机域名
	- inter-Process communication 进程间通信- 信号量/消息队列/共享内存

## 2018.06.26

1. SIGINT、SIGQUIT、 SIGTERM、SIGSTOP 区别
	
	https://blog.csdn.net/pmt123456/article/details/53544295

2. 如何在关系型数据库中建立树状结构

	- 单表 parent 字段
	- 单表 path 字段
	- 两表 id,root_id,depth,is_leaf,node_id

3. 用户id

	```id -a```

4. 消息队列

	```
	ipcmk -Q
	ipcs -q
	```

## 2018.6.26

1. pid,tgid,pgid,sid 的区别

	https://www.cnblogs.com/hazir/p/linux_kernel_pid.html

## 2018.6.27

1. docker 数据备份/恢复

2. 分布式系统唯一ID生成方案
	
	- 数据库自增字段
	- uuid
	- 时间id,机器id,自增id

3. 中文 string 的长度
	

## 2018.6.28

1. mysql 表的限制

	https://dev.mysql.com/doc/refman/5.7/en/general-tablespaces.html

2. awesome-mysql

	http://shlomi-noach.github.io/awesome-mysql/ 

## 2018.7.1

1. 如何模拟IP

2. vim 括号自动补全

	https://www.cnblogs.com/songdechiu/p/5844073.html
	
3. vim 向左光标移到上一行末尾

	```set whichwrap+=<,>,[,]```


## 2018.7.2

1. ASTQueryTranslatorFactory 作用
	
	为什么加载慢

2. 两个 list 进行 join

 	```
​	macList.stream().map(...).collect(Collectors.toMap(...));
 	```

## 2018.7.3

1. believe in miracles


## 2018.7.4

1. You can't specify target table 'xxx' for update in FROM clause

	- 不能先select出同一表中的某些值，再update这个表
	- 使用中间表过渡
	- https://blog.csdn.net/qq_29672495/article/details/72668008

2. 镜像的占用少? √

3. Nginx 高并发调优

	https://www.cnblogs.com/shirly1981/p/5613955.html


## 2018.7.5

## 2018.7.6

1. ddos 如何防护

2. 只有5.6之后的版本才能使用CURRENT_TIMESTAMP作为DATETIME的默认值。 

	- ALTER TABLE t_user ADD update_time TTMESTAMP DEFAULT CURRENT_TIMESTAMP
	- https://www.cnblogs.com/JiangLe/p/6956865.html
	- explicit_defaults_for_timestamp

## 2018.7.8

1. thread 的可重入性

	https://www.cnblogs.com/cielosun/p/6684775.html

## 2018.7.9

1. mysql 备份


## 2018.7.10

1. ThreadPoolExecutor

	https://blog.csdn.net/qq_25806863/article/details/71126867

2. RejectedExecutionException

	https://www.cnblogs.com/waytobestcoder/p/5323130.html

3.  4种拒绝策略 AbortPolicy

4. JVM初始分配的内存由-Xms指定，默认是物理内存的1/64；JVM最大分配的内存由-Xmx指 定，默认是物理内存的1/4。默认空余堆内存小于 40%时，JVM就会增大堆直到-Xmx的最大限制


## 2018.7.11

1. kafka streams 运行, 却不消费数据

	消费者崩溃
	https://www.cnblogs.com/rainwang/p/7496147.html

2. SSH,SSL,SASL等协议


3. mysql中日期类型DATETIME和TIMESTAMP的区别

	- https://blog.csdn.net/u013399093/article/details/52294619
	- DATETIME的日期范围是1001——9999年，TIMESTAMP的时间范围是1970——2038年。
	- DATETIME使用8字节的存储空间，TIMESTAMP的存储空间为4字节
	- datetime 5字节
	
4. http://matt33.com/archives/

	kafka 解析

## 2018.7.12

1. entering strict repository configuration mode!

2. is not eligible for getting processed by

3. spring boot 2.0 redis 配置

4.  缓存结果与事务

5. hibernate 使用数据库默认值

## 2018.7.13

1.kafka 接入 Flink

	ksql 和 flink 的比较
	https://www.cnblogs.com/huxi2b/p/9154130.html
	
	ksql 入门
	https://mp.weixin.qq.com/s?__biz=MzA3MjQ1NDYzOQ==&mid=2660384703&idx=1&sn=80f47463b8bc107c59991d7282786280&chksm=8478873fb30f0e297b6df551d07bb50bea4c8e58023e6a0b330ba8c9417d1a220f07d11112af&mpshare=1&scene=23&srcid=0716NnZA0f9z2ULV0g9VZNiS#rd

2. kylin 

3. 数据库通过设计冗余字段来加快检索, 但很多冗余字段会降低表的扩展性

4. 协程 与 异步无阻塞

	quasar
	vert.x


## 2018.7.16

1. @Cacheable  value 值的意义

2. redis 为单个键值对设置过期时间

3. redis 缓存事务回滚

## 2018.7.17

1. redis 列表缓存

2. redis set TTL

3. 阿里云教学直播 
	
	https://yq.aliyun.com/webinar

4. 了解 mysql workbench 表的option

5. 表情使用 utfmb4 来进行存储，注意它与 utf-8 编码的区别

	utf8mb4是utf8的超集，emoji表情以及部分不常见汉字在utf8下会表现为乱码，故需要升级至utf8mb4。

6. 多线程/事务

	ExecutorService 执行失败回滚/放入队列

7. spring jpa 自定义查询

	https://blog.csdn.net/zhu562002124/article/details/75097682

## 2018.7.19

1. hibernate 复杂sql

2. redis CacheEvict 清除多个缓存
	​	
	https://www.cnblogs.com/ClassNotFoundException/p/6523274.html
	```@caching()```
	好像做不到很方便的删除,能不能做个插件regex查询所有键,然后删除

```java
@Caching(evict = {
            @CacheEvict(value="cacheName",key="#info.id+'_baojia'",beforeInvocation=true),
            @CacheEvict(value="cacheName2",key="#info.id+'_fenlei'",beforeInvocation=true) })
```

3. HTTP OPTIONS 作用

4. mysql 根据时间段 分组

	```
	SELECT date_format(created_time,'%Y-%m') as created_date,count(*) FROM user
	group by date_format(created_time,'%Y-%m')
	```

## 2018.7.20

1. 权限认证使用interceptor

2. spring 读取文件

3. request.getRemoteHost()


## 2018.7.22

1. tar.gz 是什么

2. Linux中profile、bashrc、bash_profile之间的区别和联系

	https://blog.csdn.net/m0_37739193/article/details/72638074


## 2018.7.23

1. mysql lock
	
	```
	LOCK TABLES `version_docker` WRITE;
	UNLOCK TABLES;
	```


2. 鸟哥的Linux私房菜 - 服务器架设篇(第三版)

	 http://cn.linux.vbird.org/linux_server/


3. man xxx 查看手册

4. 找一台新的主机 查看 docker 的配置

5. docker busybox 

	BusyBox 是一个集成了三百多个最常用Linux命令和工具的软件。

6. /etc/resolv.conf

	DNS客户机配置文件
	nameserver    //定义DNS服务器的IP地址


## 2018.7.23.5

1. confd 远程修改配置文件

2. what is etcd?

## 2018.7.25.5

1. mac 层 mac 地址和网关是什么关系?

2. ARP 协议和网关

3. 局域网内可以使用本地的地址 mac 进行沟通

4. 路由表 , 路由表 OSPF , BGP

5. ```yum makecache```

## 2018.7.27

1. 方便的权限控制

	- 使用 aop 进行权限控制
	- 使用 注解 的方式

## 2018.7.28

1. CNN

	卷及神经网络

2. array  


## 2018.7.30

1. default,static 接口的继承与实现 -> todo:文章

2. 静态类和内部类的区别

3. annotation aliasfor 获取不到

	https://www.jianshu.com/p/f43a01513a79
	```AccessAuth accessAuth2 = AnnotationUtils.getAnnotation(accessAuth, AccessAuth.class);```

## 2018.7.31

1. enum 类 使用 equals 和 == 的结果都是一样的

2. 数据库查询出的列表是null,还是一个空的list

## 2018.8.1

1. spring 不传null值

	spring.jackson.serialization-inclusion=NON_NULL

## 2018.8.2

1. JSESSIONID 什么意思

2. group by 效率怎么样?

3. java stream 中使用 stream 会有什么问题?


## 2018.8.9

1. π 为什么是无理数

2. 什么是超越数?

同π一样，e也会在意想不到的地方出现，例如：“将一个数分成若干等份，要使各等份乘积最大，怎么分？”要解决这个问题便要同e打交道。答案是：使等分的各份尽可能接近e值。如，把10分成10÷e≈3.7份，但3.7份不好分，所以分成4份，每份为10÷4=2.5，这时2.5^4=39.0625乘积最大，如分成3或5份，乘积都小于39。e就是这样神奇的出现了。

3. 超越数有什么用?

4. 圆 和 直线是什么关系

## 2018.8.10

1. 通过设计冗余字段, 来加快查询

2. stream 中 map(Integer::toString)

## 2018.8.20

1. Specified key was too long; max key length is 767 bytes

	mysql 索引字段那过长

## 2018.8.29

1. 阿里redis开发规范 https://yq.aliyun.com/articles/531067

## 2018.9.5

1. spring boot http nio 线程池如何分配

2. org.springframework.cache.support.NullValue  能否改成 ```{}```

3. cache redis transactionAware 

4. 方法级别的cache
	
	https://my.oschina.net/wnjustdoit/blog/644311
	设置有效时间和自动刷新缓存
	https://www.jianshu.com/p/e53c1b60c6e1
	重写 RedisCacheManager
	 https://www.cnblogs.com/nyvi/p/8613065.html


## 2018.9.6

1. null 对象如何缓存

2. traceroute

	欺骗服务器, 达到获取所有路径信息

3. import static 静态引入

	如: import static ...Math.*
	就可以直接使用 cos(), sin() 这些函数了
	但要注意的是会污染命名空间, 需要谨慎使用.

## 2018.9.7

1. hprof 文件
	
	检查内存泄漏

2. jvisualvm 的使用


## 2018.9.10

1. hikari - Thread starvation or clock leap detected

2. git tag 如何使用

## 2018.9.11

1. 如何检查 hibernate 已经使用事务
	
	spring 事务如何实现

2. idea debug 命令 解释

3. 127.0.0.1 到底是什么
	
	127.0.0.1 是绑定在 loopback 接口上的地址

4. KeyValueRepository redis 使用
	
	其实就是 redisRepository 使用

5. pouch 运维 docker 容器

## 2018.9.12

1. ddl, dml

	- DDL（data definition language）数据库定义语言: 在创建表的时候用到的一些sql，比如说：CREATE、ALTER、DROP等
	- DML（data manipulation language）数据操纵语言：增删改查
	- DCL（Data Control Language）数据库控制语言：用来设置或更改数据库用户或角色权限的语句，包括（grant,deny,revoke等）语句

2. Docker ADD vs VOLUME
	
	https://stackoverflow.com/questions/27735706/docker-add-vs-volume

## 2018.9.13

1. jpa stream

	http://knes1.github.io/blog/2015/2015-10-19-streaming-mysql-results-using-java8-streams-and-spring-data.html

2. spring 自动做了 url 加解码的工作

3. one stream -> two stream

4. jpa 异步查询

	https://docs.spring.io/spring-data/jpa/docs/2.0.10.RELEASE/reference/html/#repositories.query-async

5. slf4j 和 logback 等 关系

6. JpaBaseConfiguration$JpaWebConfiguration$JpaWebMvcConfiguration - spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning

7. docker build 指定 Dockerfile

	```docker build -t project:1.1 -f Dockerfile-dev .```

8. spring-data-jpa-2.0.9

	saveall

## 2018.9.14

1. springboot 快速开发配置指南

	docker

2. redis 16 个db


## 2018.9.16

1. CIDR

2. MTU mac 头部14字节, 尾部4字节 -- 一共 1518字节

3. NAT(network address transfer) 将私有 ip 送上internet

4. DHCP

## 2018.9.17

1. wireshark 网络分析就这么简单

2. 100.64.0.0 Shared Address Space	保留地址,私有ip

3. dns文件 /etc/resolv.conf

	特权端口文件: /etc/services

## 2018.9.20

1. ```godoc -http=:8888```

	只想说..这也太6了吧

## 2018.9.21

1. mysql 浮点数

	如 ```float(7,4)```

2. jpa底层 对 date 类型做了什么操作?

	转成 sql.timestamp

## 2018.9.24

1. java 中是值传递,而不是引用传递

	go 中是怎么样的?

2. 怎么查看 go 的源码

3. https://sketch2code.azurewebsites.net/

	sketch2code 微软开源

## 2018.9.26

1. 超级好用的 markdown 编辑器 -- typora

2. github 每日趋势 https://github.com/trending

3. 图床工具 picgo

	https://github.com/Molunerfinn/PicGo
	好像还不如直接传到 OSS ...

## 2018.9.27

1. 编写文档 https://docsify.js.org

2. 让机器学习去找算法 

4. tidb 兼容 mysql 

5. ansible 配置管理工具

## 2018.10.6

1. go method 中传递方法或者值? 区别? 优势?

2. go time format 中使用的时间为 ```2006-01-02 15:04:05```

3. go 类型断言可检查值的动态类型, 然而动态类型是什么呢?

## 2018.10.8

1. tensorflow for go 

	https://blog.csdn.net/qiansg123/article/details/80129848

2. want 
	
	- bilibili 微积分的本质
	- 深度学习 ppt
	- https://www.slideshare.net/tw_dsconf/ss-62245351?qid=108adce3-2c3d-4758-a830-95d0a57e46bc&v=&b=&from_search=3
	- 配合...
	- https://blog.csdn.net/qq_32690999/article/details/78904546#%E8%AE%AD%E7%BB%83%E9%9B%86%E4%B8%8A%E6%95%88%E6%9E%9C%E5%A5%BD%E7%9A%84%E5%9F%BA%E7%A1%80%E4%B8%8A%E6%B5%8B%E8%AF%95%E9%9B%86%E4%B8%8A%E6%95%88%E6%9E%9C%E5%B7%AE

3. 感觉 csp 模式, 很适合 deep learning 中向前传递函数/值

4. Keras:基于Python的深度学习库

	- 用户友好：Keras是为人类而不是天顶星人设计的API。
	- 中文文档
	- https://keras-cn.readthedocs.io/en/latest/
	- 简易和快速的原型设计（keras具有高度模块化，极简，和可扩充特性）
	- 支持CNN和RNN，或二者的结合
	- 无缝CPU和GPU切换

## 2018.10.10

1. go 熟悉 FLAG 写一个程序, 全自动自动 git

	其实用 sh 脚本也行

2. 如果说人这种动物不够智能呢?

	- 什么叫智能?
	- 怎么才能叫真正的智能?

3. 圆 和 直线是什么关系

4. 感觉 golang 中的 chan 很适合做深度学习

5. 以字典做base, 做阅读理解?

6. 以机器学习来帮助人们学习/记忆?

7. 人的记忆, 或者说理解一样东西, 需要一个长时间的 `处理`? ,过了一段时间才能理解它

8. git  回退
	
	git reset --hard/soft


## 2018.10.11

1. 李宏毅 DL/ML 

	- http://speech.ee.ntu.edu.tw/~tlkagk/talk.html
	- https://www.bilibili.com/video/av9770302
	- https://www.youtube.com/channel/UC2ggjtuuWvxrHHHiaDH1dlQ/playlists


## 2018.10.12

1. 在写代码/看文章时, 你的手会做出一些无意识的操作?

2. git 代码恢复

	- git reset --hard 之后, add 过的文件可以通过 ``` git fsck --lost-found```找到
	- 但是没有add 过的文件就真的找不到了
	- 参考:(关于git reset --hard这个命令的惨痛教训)[https://www.cnblogs.com/hope-markup/p/6683522.html]

3. 张成空间是包含这组向量的最小子空间

4. 自建神经元?
	
	类似于人体细胞的分化/分裂

## 2018.10.13

1. 神经元像元素一样被重组, 再次组成一个网络/生命



## 2018.10.15

1. java 虚方法
	
	- 实现面向对象语言多态性的

2. 安装 python, pipenv,想运行 ```https://github.com/eriklindernoren/ML-From-Scratch``` 中的demo
	
	- 遇到了以下问题
	- 环境依赖错误,同```https://github.com/eriklindernoren/ML-From-Scratch/issues/45```
	- pipenv 使用, 环境, 依赖
	- pip 安装过慢, ```read time out```异常, 换源```https://www.cnblogs.com/sunnydou/p/5801760.html```
	- matplotlib 错误, solve:```https://stackoverflow.com/questions/21784641/installation-issue-with-matplotlib-python```
	- 经过以上步骤, 基本在mac 上跑通, 但在另外一台 win7 上还遇到了一些问题
	- 

3. 在 win10上 安装了最新 18.1 的 pipenv, 结果出现了一大堆问题

    - https://github.com/pypa/pipenv/issues/2924
    - 好像2中 win7 的问题, 也是因为这里的bug
    - 然后 pip 使用时, 出现了```ModuleNotFoundError: No module named 'pip'```的问题
    - ```
         python -m ensurepip
         python -m pip install --upgrade pip
         python -m pip install --upgrade pip==18.0```
    - 最后吐槽一句, 作为一个第一天使用 pipenv 的新手来说, 真的算不上一次很好的体验.


## 2018.10.16

1. 关于在Git中, 是否要上传 Pipfile.lock
	
	- https://github.com/pypa/pipenv/issues/598
	- 虽然开发者们最后认为应该上传```Pipfile.lock```, 但我自己感觉还是为了平台的无关性, 不上传比较好, 为了避免出现一些奇怪的问题.

## 2018.10.18

1. 测试 springboot 服务器性能

## 2018.10.23

1. radio, checkbox 点击优化

	- https://stackoverflow.com/questions/19412204/how-do-you-make-the-radio-button-text-to-be-clickable-too
	- https://stackoverflow.com/questions/6293588/how-to-create-an-html-checkbox-with-a-clickable-label

## 2018.10.24

1. sun.misc.Unsafe 

	- 仿佛打开了新世界的大门...

2. asmtools
	
	- http://hg.openjdk.java.net/code-tools/asmtools/archive/tip.zip
	- https://blog.csdn.net/hengyunabc/article/details/81122760


## 2018.10.25

1. JVM会统计每个方法被调用了多少次，超过多少次，那就是热点方法。(还有个循环回边计数器，用来编译热循环的。)默认的分层编译应该是达到两千调C1，达到一万五调C2。

2. 如何了解 jvm 即时编译, 输出?

3. jvm 中指定了操作数栈的字长为 32 bit, 并不依赖于平台.

	- https://stackoverflow.com/questions/31766491/jvm-word-size-and-operand-stack
	- https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-2.html#jvms-2.6.2
	- At any point in time, an operand stack has an associated depth, where a value of type long or double contributes two units to the depth and a value of any other type contributes one unit.
	- https://www.zhihu.com/question/29833675


## 2018.10.26

1. stack=2, locals=1, args_size=1 含义

## 2018.10.30

1. java stream 延拓

	- branch
	- peek/map 先处理全部的, 再用 to 处理每个的

	- 运算延拓

## 2018.10.31

1. AtomicBoolean

## 2018.11.1 

1. map initialCapacity 为 11

## 2018.11.2

1. `@Transactional`这个 Spring 注解可以用在 `private`方法上么

	- https://stackoverflow.com/questions/4396284/does-spring-transactional-attribute-work-on-a-private-method

2. https://flink-china.org/doc/index.html

	- flink 官网上线

## 2018.11.5

1. `Call to 'super()' must be first statement in constructor body`

	- 可以在 super() 中调用函数
	- 这看起来像是多此一举?
	- https://stackoverflow.com/questions/1168345/why-do-this-and-super-have-to-be-the-first-statement-in-a-constructor

2. 什么时候使用 volatile

	- volatile 只保证 可见性, 不能保证原子性

## 2018.11.6

1. Comparison method violates its general contract!

	- https://blog.csdn.net/ghsau/article/details/42012365

2. `-XX:+UseCondCardMark`


## 2018.11.08

1. redis 哨兵, 检查服务器是否在线

2. `top -c -p $(pgrep -d',' -f string_to_match_in_cmd_line)`

	- 用于查询指定内容

3. `docker run -v /2018/nov/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis -d -p 6379:6379 redis redis-server /usr/local/etc/redis/redis.conf`
	
	- docker for redis

4. want:

	1. redis 数据结构
	2. 如何保证 kafka 只消费一次
	3. jvm 参考 github 笔记




## 2018.11.09

1. hash(key) -> 分配一个线程

	- 线程死亡后, 切换执行?
	- 类似于 go channel





