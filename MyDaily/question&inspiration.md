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
         ```
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


## 2018.11.11

1. 每天做一件有挑战性的事情 ?

## 2018.11.13

1. ```npm install mqtt --save``` 
	
	- 这里的 `--save` 是什么意思

npm install 在安装 npm 包时，有两种命令参数可以把它们的信息写入 package.json 文件，一个是npm install--save另一个是 npm install –save-dev，他们表面上的区别是--save 会把依赖包名称添加到 package.json 文件 dependencies 键下，--save-dev 则添加到 package.json 文件 devDependencies 键下

2. electron  jQuery is not defined
	
	- https://stackoverflow.com/questions/32621988/electron-jquery-is-not-defined

## 2018.11.14

1. 100年后, 我丧失了记忆回到了这里.

2. Creating src/theme.config (LESS config) src/theme.config

	- win10 `gulp install` 卡住不动
	- https://github.com/Semantic-Org/Semantic-UI/issues/6641
	- https://nodejs.org/download/release/v10.11.0/

## 2018.11.15

1. Quasar
	
	- 轻量级线程

2. 单线程的 coroutine 1对多 是相对容易实现的

	- go goroutine 的多对多,感觉实现起来很复杂, 还有很多 work-steal 的东西.

3. idea 内存占用与实际不符 ?

4. Unsafe 
	
	- http://www.docjar.com/html/api/sun/misc/Unsafe.java.html

5. `FutureTask`  -> `Unsafe`  -> `ConcurrentMap`


## 2018.11.16

1. 了解一下 `&` 运算符的新语法, 来自 `Map.Entry`
	
```java
public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
        return (Comparator<Map.Entry<K, V>> & Serializable)
            (c1, c2) -> c1.getValue().compareTo(c2.getValue());
    }
```

相当于

```java
return (Comparator<Map.Entry<K, V>>) (Serializable)
(c1, c2) -> c1.getKey().compareTo(c2.getKey());
```

2. `>>>` 移位符号, 优先级比 `+` , `-`低

3. `docker logs -f --tail 2000 tomcat2 |  grep -E ".*2018-11-16.*update.*"`

	- `grep -E "regexp expression"` 正则匹配

## 2018.11.17

1. webStorm `v-bind is not bound`

	- https://blog.csdn.net/sinat_35512245/article/details/53956560


## 2018.11.19

1. search commit code in git 

	- https://stackoverflow.com/questions/2928584/how-to-grep-search-committed-code-in-the-git-history/2928721#2928721

2. cas

	- http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/oop.inline.hpp

## 2018.11.20

1. ```gcc test.cpp -lstdc++ -o main```

	- 会输出 `main.exe`
	- `-lstdc++` 使用 `c++` 

2. jni

	`javah  -d com/github/giraffetree/springjni/utils/jni com.github.giraffetree.springjni.utils.jni.WinAPI`
	 - https://segmentfault.com/a/1190000010066701
	 - https://zhuanlan.zhihu.com/p/25554150
	 - https://zhuanlan.zhihu.com/p/25048760
	 - https://zh.wikipedia.org/wiki/Java%E6%9C%AC%E5%9C%B0%E6%8E%A5%E5%8F%A3

	 - http://notes.maxwi.com/2017/04/19/java-jni-cpp-hello/

## 2018.11.21

1. Variable Handles

	- jdk 9 中将 `sun.misc.Unsafe` 的实现替换为 `java.lang.invoke.VarHandle`
	- http://openjdk.java.net/jeps/193

2. 并发 random 包 
	
	- ThreadLocalRandom

3. 解决 cas 中 ABA 问题

	- AtomicStampedReference

4. cas, synchronized 优劣

	- https://www.jianshu.com/p/736c532869a3

5. `jmh` 基准测试

6. concurrentHashMap

	- http://www.importnew.com/28263.html

7. idea + vs

	- https://www.cnblogs.com/lucychen/p/9771236.html
	- https://www.cnblogs.com/lucychen/p/9783418.html

## 2018.11.22

1. C++ 

	1. 下面的注释加上会报错, 我把注释移到了 for(;;) 的上一行
	```for(;;) // 我是注释
	{
		...
	}
	```

2. 编码问题
	
	我加上了编译选项 /utf-8 


## 2018.11.26

1. `GOROOT` 是什么作用

2. golang 在 windows 上编译 linux 的程序

	```
set GOARCH=amd64
set GOOS=linux
go build
	```

3. `jni.h` 竟然和 netscape 公司有关...惊了. 

4. `C++`获取时间

	```
	// linux 
	#include <sys/time.h>
	// win
	#include <time.h>
	```

5. 计算机怎么处理 乘法 ?

6. `System.arraycopy`

	- 线程不安全

7. c++ `vector` to `double[]`

	 - https://stackoverflow.com/questions/2923272/how-to-convert-vector-to-array

8. jni 控制台输出

	- C++ 有自己的缓存区, java也有自己的缓存区, 由于缓存区不同所导致
	- https://blog.csdn.net/hnlylyb/article/details/80708880


9. jni 库加载路径

	- https://upload-images.jianshu.io/upload_images/1915271-ba2274d50c038375.png

10. jni 泛型的关系

## 2018.11.27

1. 在 jni 中避免内存泄漏

	- https://www.ibm.com/developerworks/cn/java/j-lo-jnileak/

2. jni 局部引用, 全局引用和弱全局引用

	- https://blog.csdn.net/xyang81/article/details/44657385

3. redis 5.0 docker 部署

	```
	docker run --name redis -p 6379:6379 --privileged=true -d -v /data/projects/redis/redis.conf:/usr/local/etc/redis/redis.conf -v /data/projects/redis/data:/data --restart always --sysctl net.core.somaxconn=1024 redis redis-server /usr/local/etc/redis/redis.conf
	```

## 2018.11.29

1. 现实不就是一个大型创造游戏么..
	
	- 假如我们是被创造出来的..所谓的物理就是这个世界的法则
	- 站在更高的格局上, 宇宙是什么?

2. 一个巨大的游戏
	
	- 每个人都能开发游戏

3. `CopyOnWriteArrayList`

4. byte & 0xff

```
byte value = 0xfe; // corresponds to -2 (signed) and 254 (unsigned)
int result = value & 0xff;
```

(The point is that conversion to int happens before the & operator is applied.)

## 2018.11.30

1. java 回调

	- https://cloud.tencent.com/developer/article/1110576
	- CompletableFuture 
	- CountDownLatch
	- https://juejin.im/post/5abc9e59f265da239f077460
	- 含义:
	- http://www.jcodecraeer.com/a/chengxusheji/java/2017/1226/9011.html

2. OSS 授权某个文件

	- https://help.aliyun.com/knowledge_detail/58905.html

## 2018.12.1

1. 算法任务

	- `CompletableFuture`
	- 异常处理 jni,future

2. coder -> algorithm or

	- https://www.zhihu.com/question/51039416


## 2018.12.3

1. 如何中断 `CompletableFuture` 的链路

	- How to interrupt underlying execution of CompletableFuture
	- https://stackoverflow.com/questions/29013831/how-to-interrupt-underlying-execution-of-completablefuture
	- Canceling a CompletableFuture chain
	- https://stackoverflow.com/questions/25417881/canceling-a-completablefuture-chain

2. 

```
@Valid AlgorithmConfigVO algorithmConfigVO,
            BindingResult bindingResult
// 跟顺序有关, 在 bindingResult 前加入参数, 会导致错误?
```

3. `CompletableFuture.applyToEitherAsync`

	- 哪个先返回, 就用哪个


## 2018.12.4

1. `The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone.`

	- `set global time_zone='+8:00'`

2. 在构造函数中初始化


## 2018.12.5

1. spring 初始化 bean 单线程? 如何实现的?

## 2018.12.6

1. 多态在 JVM 中是如何实现的?

2. `page` 可以用 `iterator`???

`public interface Page<T> extends Slice<T>`

`public interface Slice<T> extends Iterable<T>`

3. 数据库访问 callback ?

4. hive 查看 docker 内部层次

	- https://github.com/wagoodman/dive

## 2018.12.07

1. 频繁GC (Allocation Failure)

2. MetaSpaceSize 

	- `GC (Metadata GC Threshold)` 后紧接着一次 `Full GC (Metadata GC Threshold)`
	- 默认 `-XX:MetaspaceSize 为21810376B` 大约20.8M, 其实是根据不同平台而异的, 大约`10~20M`不等
	- [JVM参数 MetaspaceSize 的误解](https://mp.weixin.qq.com/s/jqfppqqd98DfAJHZhFbmxA)
		- 设置分配的类元数据空间的大小，该类元数据空间将在首次超过垃圾收集时触发垃圾收集。垃圾收集的阈值取决于使用的元数据量而增加或减少。
		- https://stackoverflow.com/questions/47426407/java8-metaspacesize-flag-not-working
	- 无论-XX:MetaspaceSize和-XX:MaxMetaspaceSize两个参数如何设置，都会从20.8M开始，随着类加载越来越多不断扩容调整，上限是-XX:MaxMetaspaceSize，默认是几乎无穷大(硬件内存上限)。


3. jstat

	- https://docs.oracle.com/javase/8/docs/technotes/tools/unix/jstat.html

4. GC overhead limit exceeded
	
	- Gc 超过限制

## 2018.12.08

1.  <Java Reference Objects>

	- http://www.kdgregory.com/index.php?page=java.refobj

2. `String` `@stable` field

-XX:+PrintStringTableStatistic

3. Heap:

	- PSYoungGen
	- ParOldGen
	- Metaspace

4. BearyChat cool chat ???

## 2018.12.10

1. 线程池和轻量级线程 区别 优劣?

	- 使用协程的好处?

2. 对就是那个少年

3. JNI 多线程

	- https://blog.csdn.net/booirror/article/details/37778283


## 2018.12.11

1. `@Nullable`可为空, `@NotNull` 不可为空

2. CMS 

	- Concurrent Mark Sweep

3. ExecutorService

```java
public ExecutorService getThreadPool() {
        BasicThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
                .namingPattern("processor-%d").daemon(true).build();
        return new ThreadPoolExecutor(5, 20, 100L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(2048),
                basicThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
```

4. `git add -u` 添加 tracked file

`git reset --hard` 清除暂存区和工作区的内容

`git mv readme readme.md` git 重命名

`git log -n4 --oneline` 当前分支的历史

`git log --all --graph` 图像化的 git

`gitk -all` 图形化界面 

5. 享元模式

	- 享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。
	- JAVA 字符串缓存池

## 2018.12.12

1. `.so`,`.dll`

	- http://gernotklingler.com/blog/creating-using-shared-libraries-different-compilers-different-operating-systems/

2. C++ “std::string has not been declared” error
	
	- https://stackoverflow.com/questions/17040098/c-stdstring-has-not-been-declared-error
	- gcc用法以及静态/动态链接
	- https://www.jianshu.com/p/31b33e5c48d7 
	- linux jni
	- https://www.jianshu.com/p/e175d5417e05

3. jni 使用问题

	- 编译版本问题, C++ 代码在不同 VS 下表现不一致
	- Release/Debug 版本速度差异巨大, 30ms/5s
	- Release x64 x86 别搞错  Can't load IA 32-bit .dll on a AMD 64-bit platform
	- 文件编码问题 C/C++ -> 命令行 -> 其他选项 -> /utf-8 
	- 预编译头问题  C/C++ -> 预编译头 -> 不使用预编译头

4. winscp transfer file to local Windows

5. Dockerfile 详解

	- https://yeasy.gitbooks.io/docker_practice/image/build.html

6. AUFS 

	- advanced multi-layered unification filesystem，高级多层统一文件系统

7. Dockerfile 中的VOLUME 和 -v

8. `java [-options] -jar jarfile [args...]`

	- https://stackoverflow.com/questions/5045608/proper-usage-of-java-d-command-line-parameters

9. `undefined symbol: _Z11fullanalyseRSt6vectorIdSaIdEEiiiiii`

	- 乱码问题
	- `git config --global gui.encoding utf-8`

	- https://stackoverflow.com/questions/12573816/what-is-an-undefined-reference-unresolved-external-symbol-error-and-how-do-i-fix
	- https://stackoverflow.com/questions/28082675/undefined-reference-when-using-a-function-included-in-a-header-file

## 2018.12.13

1.  com.zaxxer.hikari.pool.PoolBase - Failed to validate connection com.mysql.jdbc.JDBC4Connection@5fde3a5e (No operations allowed after connection closed.
	
	- http://cmsblogs.com/?p=2522
	- https://stackoverflow.com/questions/41008350/no-operations-allowed-after-connection-closed-errors-in-slick-hikaricp

2. `cout’ is not a member of ‘std`

	-  `#include <iostream>`

3. `error: ‘>>’ should be ‘> >’ within a nested template argument list`
	
	- `vector<pair<string, int>> word;`  ->  `vector<pair<string, int> > word;`
	- https://blog.csdn.net/u011630575/article/details/45557573

## 2018.12.14

1. 今天使用 idea 碰到了一个很诡异的现象, 有以下几点
	
	- 右击项目主目录没有 maven 选项
	- 右击 pom 文件, 使用 maven reimport, 显示已经 import 成功
	- 但是 External Libraries 中只有 jdk-8 , 没有其他导入的包
	- 项目中的 spring 代码 都是没有 import 的状态 
	- 重新打开项目, 重新 import 没有用
	- 最诡异的是在 右边侧边栏有个 maven projects -> plugins -> spring-boot -> spring-boot:run 还能运行起来?? WTF ???

	- 最后怎么解决的呢?
	- 右边侧边栏有个 maven projects 的一个maven 的管理界面, 我点击了下载 source code
	- 然后 主目录右击 有 maven 选项了,  External Libraries 也有其他的库了
	- 估计是某个奇怪的原因引起了某个奇怪的bug? 内存占用太大?
	- 然后点击 下载 source code 的时候, 发现 external library 还没导入, 就修复了这个问题.

2. 洛伦兹变换是观测者在不同惯性参照系之间对物理量进行测量时所进行的转换关系，在数学上表现为一套方程组。洛伦兹变换因其创立者——荷兰物理学家亨德里克·洛伦兹而得名。洛伦兹变换最初用来调和19世纪建立起来的经典电动力学同牛顿力学之间的矛盾，后来成为狭义相对论中的基本方程组。

	- https://zh.wikipedia.org/wiki/%E6%B4%9B%E4%BC%A6%E5%85%B9%E5%8F%98%E6%8D%A2
	- 那么帅气的么?

	- 迈克耳孙-莫雷实验 -> 洛伦兹变换

3. 以 `0.1c` 运动, 增加 0.5% 的质量?

4. `MQClientException: No route info of this topic, PushTopic`

	- 原因: rocket 不会自动添加 topic
	- 解决办法: autoCreateTopicEnable=true

5. redis 
	
	- requirepass
	- 路径: /usr/local/etc/redis/redis.conf

## 2018.12.15

1. redis streams 使用

	- 命令介绍
	- https://redis.io/topics/streams-intro
	- java 使用
	- https://www.javacodegeeks.com/2018/05/a-first-look-at-redis-streams-and-how-to-use-them-with-java.html

## 2018.12.17

1. unchecked generics array creation for varargs parameter

	- https://stackoverflow.com/questions/21132692/java-unchecked-unchecked-generic-array-creation-for-varargs-parameter
	- java doesn't allow a generic array creation

2. redis stream 数据结构

	- http://xiaorui.cc/2018/06/07/%E6%B5%85%E5%85%A5%E6%B5%85%E5%87%BAredis5-0%E7%9A%84streams%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84/

3. `\xac\xed\x00\x05t\x00\x05`

	- https://blog.csdn.net/yunhaibin/article/details/9001198
	
4. 星系都大致在一个平面上

	- 有角动量的方向上旋转
	- 没有角动量的方向 -> 因为引力聚集

5. vs format code

	- ctrl+k,ctrl+f

6. idea - Settings- Copyright - Copyright Profiles

```
Copyright 2018-2019 the original author or authors.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 2018.12.18

1. grep 输出到文件

	- 有时输出不了...加上下面的参数
	- `grep --line-buffered`


2. https://www.wolframalpha.com/

	- awesome compute !!!!
	- 计算搜索

3. redis commit 事务取消

4. `concurrentLinkedList`

	- 实现起来好像会很难..

5. 链表
	
	- leetcode
	- 单链表反转  206
	- 链表中环的检测  141
	- 两个有序链表 合并  21
	- 删除链表倒数 第 n 个点  19
	- 求链表的中间节点  876

## 2018.12.20

1. 想要获取更好的结果, 就要首先获取更多的信息

2. jni 多线程调用 static 方法

	- 看了下jdk , native 方法有些是 static 的, Object/ Thread 中
	- 有些是 非static 的, Unsafe 包
	- 通过 ++ 多线程测试 jni native 方法

3. stack

	- 20,155,232,844,224,682,496

4. 为什么要用 stack
	
	- 函数调用要符合先进后出的顺序


## 2018.12.24

1. markdown toc

```
## toc 配置
autolink="true"

## 快捷键配置
{ 
	"keys": ["ctrl+shift+j"], 
	"command": "markdowntoc_insert" 
},
{ 
	"keys": ["ctrl+shift+k"], 
	"command": "markdowntoc_update" 
}
```

## 2018.12.26

1. disruptor

2. cas 无锁队列

3. Talk is cheap. Show me the code.

## 2018.12.27

1. idea 条件断点 新技能!!

2. lombok 

	- JSR 269 Pluggable Annotation Processing API

3. mysql 中如何修改一个字段的类型

	This is how I would do it:
	1) Create a new datetime column  新建新的一列
	ALTER TABLE mytable ADD COLUMN mydatetime DATETIME;
	2) Update this column using the timestamp values   
	UPDATE mytable SET mydatetime=FROM_UNIXTIME(UNIX_TIMESTAMP(mytimestamp));
	3) After a few integrity checks, delete the timestamp column
	ALTER TABLE mytable DROP COLUMN mytimestamp;
	This should be safe enough for you, as you can keep the original timestamp column as long as you want.

4. 好像有些版本的mysql 中 timestamp 是可以为 负的..

	- 不过涉及到生日/过去时间的还是用 datetime 比较好

## 2018.12.29

1. spring boot hikari connect 未关闭

2. Bytecode provider name : javassist

## 2019.1.1

1. java `int a = 1+2;`

	- 编译之后是怎么样的?
	- 字节码中仅有一个数字 3
	- 标注检查-常量叠加

## 2019.1.2

1. 运行时编译/编译时运行

	- 字节码解释运行时, 直接生成机器码 JIT - C1 C2
	- 编译期优化
	- 编译器生成代码 lombok JSR269(Java Specification Requests) 
	- https://zh.wikipedia.org/wiki/JCP
	- https://juejin.im/entry/5a390ba76fb9a0451e3fed7c

## 2019.1.3

1. mysql 定时0点弹出 update catalog

	- https://stackoverflow.com/questions/26638238/strange-mysql-popup-mysql-installer-is-running-community-mode

2. 字节码优化

```java
public class Hello{
	// 整个 a 被优化成 4
    int a = (1+1)*2;
    // 括号中的内容会被优化成 3 
    int b = (2+1)*a+1;
}
```

相当于在编译时做了一部分计算

3. bitmap

	- 用户标签应该如何设计, 有什么优劣
	- https://www.zhihu.com/question/20245628?sort=created

4. 用 clojure 自动生成 repository ?

	- 玩玩?

5.  在 docker 中配置 rocketMQ brokerIp 的问题

	- https://medium.com/@prinswu/rocketmq-with-docker-compose-%E7%9C%9F%E7%9A%84%E5%BE%88%E5%A4%9A%E5%9D%91-d1bd41e26090


## 2019.1.4

1. 深入浅出 Java CMS

	- https://mp.weixin.qq.com/s/eGwLVk474cJWyVoP97gWGg

2. ZGC 

	- https://www.zhihu.com/question/287945354/answer/458761494

3. Copying 复制算法

	- 是如何实现的

4. 并发GC根本上要跟应用玩追赶游戏：应用一边在分配，GC一边在收集，如果GC收集的速度能跟得上应用分配的速度，那就一切都很完美；一旦GC开始跟不上了，垃圾就会渐渐堆积起来，最终到可用空间彻底耗尽的时候，应用的分配请求就只能暂时等一等了，等GC追赶上来.所以，对于一个并发GC来说，能够尽快回收出越多空间，就能够应付越高的应用内存分配速率，从而更好地保持GC以完美的并发模式工作。

## 2019.1.5

1. 局部final变量和局部变量的字节码文件完全一致, 局部final变量的不变性, 仅仅由编译期在编译期间保证.

## 2019.1.8

1. 泛型 instanceof

2. mysql varchar(50) -> 指限定最多50个字符(不是字节)


## 2019.1.9

1. hibernate 二级缓存

2. deeplearning4j 了解一下?

	https://deeplearning4j.org/docs/latest/deeplearning4j-quickstart

## 2019.1.10

1. 运行时修改日志等级

2. 抽象问题的能力

## 2019.1.11

1. hibernate 复杂sql的几种写法

	1. `nativeQuery`
	2. 自定义 `Repository` autowired `SessionFactory`
	3. `extend JpaSpecificationExecutor<T>`
	4. `queryDsl`

## 2019.1.14

1. `spring boot messagesource` 国际化

2. `Validated` + `ExceptionHandler`

```java
@RestControllerAdvice
public class ProcessExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseTO missingServletRequestParameter(MissingServletRequestParameterException ex) {
        return ResponseTO.error(ErrorEnum.BUSINESS_PARAM_INVALID, "参数 - " + ex.getParameterName() + " 未找到");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseTO methodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseTO.error(ErrorEnum.BUSINESS_PARAM_INVALID, "参数 - " + ex.getName() + " 类型错误");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseTO httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return ResponseTO.error(ErrorEnum.SERVER_METHOD_NOT_SUPPORT,"不支持 HTTP 方法: "+ex.getMethod());
    }

    @ExceptionHandler(BindException.class)
    public ResponseTO bindExceptionHandler(BindException bindException) {
        FieldError fieldError = bindException.getFieldError();
        return ResponseTO.error(ErrorEnum.BUSINESS_PARAM_INVALID, Objects.requireNonNull(fieldError).getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseTO exceptionHandler() {
        return ResponseTO.error(ErrorEnum.SERVER_ERROR);
    }
}
```

https://stackoverflow.com/questions/14483223/custom-binding-error-message-with-collections-of-beans-in-spring-mvc

```java
@Autowired
private MessageSource messageSource;
DefaultMessageCodesResolver
class DefaultBindingErrorProcessor implements BindingErrorProcessor
```

3. `ExceptionHandler 中抛出异常`

## 2019.1.15

1. `javax.validation.constraints` 自定义限定

	- https://stackoverflow.com/questions/6294587/java-string-validation-using-enum-values-and-annotation

2. `annotation`中的限制

```
// https://stackoverflow.com/questions/49609447/how-to-set-integer-array-in-java-annotation
Invalid type Integer[] for the annotation attribute permissions;
only primitive type, String, Class, annotation, enumeration are permitted or one-dimensional arrays thereof
```

3. `LongValidator`

```java
public class LongValidator implements ConstraintValidator<ValidateLong, Long> {

    private List<Long> valueList;
    @Override
    public void initialize(ValidateLong constraintAnnotation) {
        valueList = new ArrayList<>();
        for (Long val : constraintAnnotation.acceptedValues()) {
            valueList.add(val);
        }
    }
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return valueList.contains(value);
    }
}
```

4. 注解 与 泛型
	
    - 注解不能使用泛型
	- https://stackoverflow.com/questions/7594582/annotation-attributes-with-type-parameters


## 2019.1.16

1. list to map

	- `lsit.stream().collect(Collectors.toMap(User::getId, Function.identity()))`
	- https://stackoverflow.com/questions/20363719/java-8-listv-into-mapk-v
	- `Map<String, Choice> result = choices.stream().collect(Collectors.toMap(Choice::getName, c -> c));`


2. `Date` to `LocalDate`

```java
Instant instant = from.toInstant();
ZoneId zoneId = ZoneId.systemDefault();

// atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
LocalDate localDate = instant.atZone(zoneId).toLocalDate();
```

3. MIT 课程 
   - https://ocw.mit.edu/courses/most-visited-courses/
   - youtube 量子力学
   - https://www.youtube.com/watch?v=lZ3bPUKo5zc&list=PLUl4u3cNGP61-9PEhRognw5vryrSEVLPr


## 2019.1.18

1. docker deploy in idea

## 2019.1.22

1. jvm 调参 -> 神经网络调参

2. OSS policy 生成器 

	- http://gosspublic.alicdn.com/ram-policy-editor/index.html?

## 2019.1.24

1. java 语法检查, 不检查import, 在编译之前

2. sql injection in jpa 

	- https://stackoverflow.com/questions/3441193/are-sql-injection-attacks-possible-in-jpa

## 2019.1.25

1. 在 querydsl-jpa 中使用 mysql 内置函数/自定义函数

	- 对 jpa 进行自定义
	- https://stackoverflow.com/questions/7005354/jpa-criteria-api-group-concat-usage
	- http://www.voidcn.com/article/p-nzsfettl-btk.html
	- https://github.com/querydsl/querydsl/issues/2377#issuecomment-457435922

2. query-jpa 中不允许join中使用子查询
	
	- query-jpa 使用 JPQL 规范, 因此受到了 JPQL 的限制, 不能再 join 中使用 子查询
	- https://stackoverflow.com/questions/6942108/jpql-querydsl-join-subquery-and-get-aliased-column
	- 相应的解决方案时, 可以在 `on` 语句中加入限定条件, 但这可能表达能力有限

## 2019.1.27

1. showing-a-spring-transaction-in-log
	
	- https://stackoverflow.com/questions/1965454/showing-a-spring-transaction-in-log

2. jpa 中即使我先删除, 再插入, 最后sql执行也会变成, 先插入后删除, why?

3. 在事务中, 异步处理

4. mysql 事务中 read-view 中的数据在之前改变会不会导致事务失败回滚?

	- https://www.cnblogs.com/Allen-win/p/8283102.html

## 2019.1.28

1. springboot jpa open-in-view 

	- https://stackoverflow.com/questions/30549489/what-is-this-spring-jpa-open-in-view-true-property-in-spring-boot

## 2019.1.29

1.  `proxy_connect_timeout 5;`

	- 没有这句话就访问错误? 什么原因呢

2. postman

	- http://blog.getpostman.com/2016/11/09/generate-spotify-playlists-using-a-postman-collection/?_ga=2.85510809.1465144954.1548898127-1896016304.1548898127

## 2019.2.10

1. jpa how to rollback?

2. itextpdf

	- https://mp.weixin.qq.com/s?__biz=MzI2NDU3OTg5Nw==&mid=2247483859&idx=1&sn=f21c3238f9c3356271f2fb353881c402&chksm=eaab3f85dddcb693ac39255db31654d4ae545d235dc161aa0f3eb2834c97492b7af920b82e6c&scene=21#wechat_redirect
	- 全:https://www.cnblogs.com/liaojie970/p/7132475.html
	- 画坐标线: https://blog.csdn.net/qq_37480159/article/details/76020485
	https://stackoverflow.com/questions/27607006/how-to-add-paragraph-into-a-rectangle-using-itext
	- https://itextpdf.com/en/resources/books/itext-7-jump-start-tutorial-java/chapter-1

	- https://stackoverflow.com/questions/27607006/how-to-add-paragraph-into-a-rectangle-using-itext


## 2019.2.13

1. `win` 命令行分析 内存占用情况?
2. `@RetryTransaction`
   - https://stackoverflow.com/questions/2332768/how-to-avoid-mysql-deadlock-found-when-trying-to-get-lock-try-restarting-trans

## 2019.2.15

1. 有向图判环

## 2019.2.17

1. mysql ` Authentication plugin 'caching_sha2_password' cannot be loaded: dlopen(/usr/...`

   - 在用 docker 启动 mysql 时遇到的, 远程连接不上

2. `java -cp C:\Users\Administrator\.m2\repository\org\clojure\clojure\1.10.0\clojure-1.10.0.jar learnclojure.clj`

3. https://api.aliyun.com/#/

   - 配置文件 `/etc/mysql/conf.d/mysql.cnf`

   - > [mysqld]
     >
     > default_authentication_plugin=mysql_native_password

4. kafka 

	- `Caused by: org.apache.kafka.streams.errors.StreamsException: task [0_3] Abort sending since an error caught with a previous record (xxx) to topic dockerUpCtrl due to org.apache.kafka.common.errors.TimeoutException: Expiring 223 record(s) for dockerUpCtrl-0: 30106 ms has passed since batch creation plus linger time.`
	- https://stackoverflow.com/questions/46750420/kafka-producer-error-expiring-10-records-for-topicxxxxxx-6686-ms-has-passed
	- https://blog.csdn.net/jiecxy/article/details/53369173#commentBox

	1. 检查网络 ping, telnet
	2. 吞吐量不够? 增大 `batch.size`, `request.timeout.ms`
	3. 发现另外一个问题, 记录在重复消费?
	4. 查看 offset, zoopkeeper 查看, 1.1 版本的
	5. 使用 `kafka-consumer-groups.sh --bootstrap-server 10.xx.xx.xx:9092 --group groupName --describe`
	6. 打算重置 offset, ` --reset-offsets --to-latest --all-topics --execute`
	7. 重置完之后, 查看了 LAG=0
	8. 当时没有数据进入, 但是消费者重启后, 仍然在消费, LAG变了 -> 重复消费了
	9. 由于我用的1.1.0 版本 offset 过期的缘故, 并且由于我的消费者配置中 `auto.offset.reset = earliest`, ` enable.auto.commit=false` 导致了程序一启动就去重复消费数据, 且 offset 未提交, 而消费者如果未找到有效偏移量, 则根据auto.offset.reset参数重置偏移量.


5. kafka producer oom

	- https://blog.csdn.net/szwandcj/article/details/77460939
	- 根据 `batch.size` 和 `linger.ms`, 满足 `batch.size` 和 `linger.ms` 之一，producer便开始发送消息。
	- `batch.size` 单位:字节, 默认 16384Bytes

6. kafka producer config

	- http://atbug.com/kafka-producer-config/

7. kafka 1.1.0 reset offset

	- https://cwiki.apache.org/confluence/display/KAFKA/KIP-122%3A+Add+Reset+Consumer+Group+Offsets+tooling
	- https://stackoverflow.com/questions/50741783/why-does-kafka-streams-reprocess-the-messages-produced-after-broker-restart/52571074#52571074
	- https://stackoverflow.com/questions/39131465/how-does-an-offset-expire-for-an-apache-kafka-consumer-group
	- https://issues.apache.org/jira/browse/KAFKA-4682
	- 我自己测试了一下应该是由于我用的1.1.0 版本 offset 过期的缘故, 并且由于我的消费者配置中 `auto.offset.reset = earliest`, ` enable.auto.commit=false` 导致了程序一启动就去重复消费数据, 且 offset 未提交, 而消费者如果未找到有效偏移量, 则根据auto.offset.reset参数重置偏移量.
	- 其中还碰到一个 `timeoutException`, 



## 2019.2.19

1. `1KiB = 1024B` ,`1KB=1000B/1024B`

2. ` df -hl ` 磁盘占用

3. idea 运行时编译


4. 

```
CREATE TABLE `t_desk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ddd` varchar(45) DEFAULT NULL,
  `key` bigint(20) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4
```

```
insert into t_desc (key,value) values (1, "hello");
```

会产生语法错误, 原因在于 key 为关键字

5. jpa 的问题

	1. 支持的sql语法有限


## 2019.2.20 

1. `http://mysql.taobao.org/monthly/`



## 2019.2.22

1. vim 缩进 tab, insert 界面中 `ctrl+d` , tab insert 界面 `ctrl+t`

2. 事务传播特性 7 种

  - 嵌套事务

3. springboot 事务管理 默认事务隔离

4. `@Transaction` 在方法内部调用无法开启事务

  `AopContext.currentProxy()` 获取当前类的代理对象, 再调用增强后的方法


5. `CompletableFuture` 中异常没有报出, 没有报错, 但实际已经 NPE 了

6. `winscp` linux 传文件到 win

## 2019.2.25

1. `top` + `P` -> cpu 排序

2. `B+ tree` 删除节点?

3. `B+ tree` 叶子节点分裂
	- 节点递增, 就不会引起叶子节点分裂

## 2019.2.26

1. `getconf PAGE_SIZE`

2. 数据库中的 `B+ tree` 的叶子节点间是单链表还是双向链表 ?

	1. `B+tree` 叶子节点是有序的
	2. 比如我想查询一个排序好的结果, 要支持正序/倒序, 那应该用单链表还是双向链表呢? 那就只能是双向链表了

## 2019.2.27

1. `docker run -p 3306:3306 --name mymysql -v $PWD/conf:/etc/mysql/conf.d -v $PWD/logs:/logs -v $PWD/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=xxx -d mysql:5.7`

2. mysql 索引的 `B+ tree` 到底是 `几叉树` ?

	- 在默认`innodb_page_size` 16KB 下
	- int 1203 
	- bigint 928

## 2019.3.1

1. `DATE_SUB(t.time, INTERVAL 1 DAY) `
	
	- timstamp(3) 可以使用


## 2019.3.4

1. 缓存过期

	- MVCC 实现

## 2019.3.5

1. 画 jpg/png 时的中文字体显示问题

	- docker 启动
	- 将字体包挂载到 `/usr/share/fonts/` 目录下
	- 如: `-v /project/test/font/apple_hei_simple.ttf:/usr/share/fonts/apple_hei_simple.ttf`
	- 如何判断已经可以使用字体包
	- ```java
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilies = ge.getAvailableFontFamilyNames();
        for (String s : fontFamilies) {
        	// 这里会将所有可用的字体包名称打印出来
            System.out.println(s);
        }
    ```
    - 

2. 手动回滚

	- `TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();`

3. update `@Modifying`

4.  mysql 5.6.4 以后, 增加了` fractional seconds precision ` (FSP)
   - `TIMESTAMP` 4个字节 + 小数秒
   - `DATETIME` 5个字节 + 小数秒
   -  1/2 位小数 -> 1字节  3/4位小数 -> 2字节 ...
   - https://dev.mysql.com/doc/internals/en/date-and-time-data-type-representation.html

5. `internals` mysql 内部文档 (很多内容已经很老了)

   - https://dev.mysql.com/doc/internals/en/innodb-fil-header.html


6. `fsync`
   - https://www.cnblogs.com/bhlsheji/p/5222271.html
   - 数据库应用一般会在调用write()保存关键交易数据的同一时候也调用fsync().这样更能保证数据的安全可靠.


## 2019.3.6

## 2019.3.7

1. java map to stream

	- https://stackoverflow.com/questions/35486826/transform-and-filter-a-java-map-with-streams

## 2019.3.8


1. collectors to map

	- https://colorpanda.iteye.com/blog/2319688



## 2019.3.10

1. windows 进程间通讯
   - 命名管道 named-pipe
   - 共享内存  shared-memory
2. Unix 进程间通讯
   - 使用 unix 域套接字文件 `--protocal=socket`
   - `mysql` 默认使用的域套接字文件时 `/tmp/mysql.sock`

3. Mysql 查看表结构/建表语句

```
show create table t1\G
```

4. mysql 查看默认引擎

   - ```mysqld --verbose --help | grep engine```

5. 查看系统变量和状态变量

   - `show variables like '%connection%';`
   - `show status like "%thread%";`

6. mysql 中的`utf8` 为 `utf8mb3` 是 经过阉割后的`utf8` , 正宗的是 `utf8mb4` 使用的是4个字节, 可以放入 emoji 表情这类的.

   - `show charset;`

7. mysql `show collation;` 表示的是字符集的比较规则

   - `_ci` case insensitive 不区分大小写
   - `_cs` case sensitive 区分大小写
   - `show variables like '%collation%';` 
   - 对于 mysql 中的**同一张表的不同列也可以有不同的字符集/比较规则**

8. 客户端到服务器/服务器到客户端 实际上也伴随着多次字符集的转换

   - 使用操作系统的字符集请求字符串.
   - 从 `character_set_client` ->  `character_set_connection`
   - `character_set_connection` 转为表交互的字符类型 `c`
   - 操作表返回结果
   - `c` ->  `character_set_connection` 
   - `character_set_connection` -> `character_set_results`
   - 使用操作系统的字符集

9. 字符集/比较规则的选用会影响唯一键的判定
  - ```
    CREATE TABLE `t7_for_uni` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
      PRIMARY KEY (`id`),
      UNIQUE KEY `name_UNIQUE` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    ```

   - `alter table t7_for_uni modify name varchar(20) character set utf8mb4 COLLATE utf8mb4_bin ;`

   - `alter table t7_for_uni modify name varchar(20) character set utf8mb4 COLLATE utf8mb4_general_ci ;`

## 2019.3.11

1. `git checkout -b dev`

	- 新建分支, 切换分支

## 2019.3.12

1. windows 10 + docker + git bash  -> run jupyter

	- `winpty docker run -it -v /${PWD}:/tf/notebooks/ --name jupyter -p 8888:8888  tensorflow/tensorflow:nightly-jupyter`
	- https://stackoverflow.com/questions/50608301/docker-mounted-volume-adds-c-to-end-of-windows-path-when-translating-from-linux


## 2019.3.13

1. cmd 修改编码 `CHCP 65001`

	- cmd 修改环境变量  `set LESSCHARSET=utf-8`

## 2019.3.14

1. tensorflow session graph operation tensor 概念/原理内核
   - https://blog.csdn.net/u013510838/article/details/84111031

## 2019.3.17

1. python import absolute path
   - https://stackoverflow.com/questions/67631/how-to-import-a-module-given-the-full-path
2. 函数计算中导入 tensorflow
   - `import sys`
   - `sys.path.insert(0,'/home/dev/code/other/')`
   - `import tensorflow as tf`



## 2019.3.18

1. 列出目录下所有文件

	- `ls -lR| grep "^-" | wc -l`


## 2019.3.19

1. 使用 `go` 调用 `c++`


## 2019.3.20

1. 获取jar/class运行路径

	- https://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file

2. idea 生成 jni header 的工具
	
	 - ![](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/Mar/generate_jni_header_file.jpg)

3. 函数计算的实现方式

	```
		"java.net.URLClassLoader.findClass(URLClassLoader.java:381)",
		"java.lang.ClassLoader.loadClass(ClassLoader.java:424)",
		"java.lang.ClassLoader.loadClass(ClassLoader.java:357)",
		"java.lang.Class.forName0(Native Method)",
		"java.lang.Class.forName(Class.java:348)"
	```

4. maven 打包包含 `.so` 库文件

	- 使用 maven-resources-plugin
	- https://my.oschina.net/u/2377110/blog/1584204

5. 在 jar 包中使用 so 库文件

	- 只能通过解压缩 jar 中的 so 文件 到本地目录, 然后再去加载
	- https://blog.csdn.net/Revivedsun/article/details/86562934
	- https://stackoverflow.com/questions/4113317/load-library-from-jar  

## 2019.3.22

1. java debug 原理

	- 暴露端口
	- todo

## 2019.3.25

1. coursera

  - 在线学习
  - fast.ai
  - deeplearning.ai

2. mysql docker

  - `docker run -p 3306:3306 --name mymysql -v $PWD/conf:/etc/mysql/conf.d -v $PWD/logs:/logs -v $PWD/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7`

## 2019.3.27

1. commit 标准化 提交

	- https://segmentfault.com/a/1190000009048911

## 2019.3.29

1. https://stackoverflow.com/questions/8696653/dynamically-load-a-function-from-a-dll

2. https://stackoverflow.com/questions/36873742/calling-a-shared-library-from-c

1. keras 中文文档
   - https://keras-zh.readthedocs.io/
2. fashion mnist
   - 数据集
3. <https://stackoverflow.com/questions/42153747/why-does-0-1-0-2-get-0-3-in-google-go>

## 2019.4.1

1. vim 去掉自动注释

	```
	关闭自动注释
	:set fo-=r 
	关闭自动缩进（这个对C/C++代码好像无效）
	:set noautoindent
	关闭C语言缩进 
	:set nocindent
	```

2. vim 取消搜索字体高亮

	- `:noh`

3. rename 用法
	
	- `rename [options] expression replacement file...`
	- `-v -> explain what is being done`
	- 比如，有一批文件，都是以log开头的，log001.txt,  log002.txt ..
	- 一直到log100.txt 现在想要把这批文件的log全部替换为history
	- `rename  log history log*`

4. `c++`怎么那么多后缀??

	- https://stackoverflow.com/questions/5171502/c-vs-cc-vs-cpp-vs-hpp-vs-h-vs-cxx
	- https://stackoverflow.com/questions/1545080/c-code-file-extension-cc-vs-cpp

5. 升级 gcc 版本至 8.3.0

	- https://blog.csdn.net/liwenkai2002/article/details/88064940
	- `yum -y install bzip2`

6. 用日志组件打印 gc log

	- 输出 gc 到file
	- https://stackoverflow.com/questions/1161647/how-to-redirect-verbose-garbage-collection-output-to-a-file
	-   `-Xloggc:garbage-collection.log`

7. 多个 `.so` 组合成一个 `.so`

	- 确实是不能实现的, 只有 source/object file 可以直接编译生成 .so
	- https://stackoverflow.com/questions/915128/merge-multiple-so-shared-libraries

8. kotlin coroutine 

	- kotlin 协程如何实现的?

## 2019.4.2

1. mysql 索引及数据, 数据及索引

## 2019.4.3

1. 修改表的数据结构时

	- 表锁
	- 底层数据结构变化
	- 如何减少对用户的影响呢?

2. aliyun 北京峰会
	- https://yunqi.youku.com/2019/beijing/review
	
3. LeNet、AlexNet、GoogLeNet、*VGG*、ResNet 
   - deeplearning 发展史

## 2019.4.4

1. 新增索引

	- `ALTER TABLE user ADD UNIQUE KEY `uniq_email`(`email`(200)) USING BTREE;`

## 2018.4.8

1. golang 中的 slice 和 java 的 arraylist 之间的差别

2. `time.Now()` 和 `time.Now().Local()` 之间的差别

3. 这是什么 feature 来着??

```golang
type NullTime struct {
	time.Time
	Valid bool
}
```

4. docker 已知问题 
	
	- `kernel:unregister_netdevice: waiting for lo to become free. Usage count = 1`
	- https://github.com/moby/moby/issues/5618

5. `docker run -p 3306:3306 --name mymysql -v $PWD/conf:/etc/mysql/conf.d -v $PWD/logs:/logs -v $PWD/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=xxxxx -d mysql:5.7`


6. hikariPool 问题

	- `HikariPool-1 - Thread starvation or clock leap detected (housekeeper delta=49s880ms724µs141ns)`


## 2019.4.9

1. linux 创建link

	- `ln -s 源文件 目标文件`  soft link 相当于快捷方式, 会创建快捷方式
	- `ln 源文件 目标文件` hard link , 在内部实现中, 源文件和目标文件实际指向同一个文件, 最终生成的目标文件的 inode 和源文件一致, 所以hard link 所用到的数据很少

2. `#/bin/bash`

	- https://stackoverflow.com/questions/8967902/why-do-you-need-to-put-bin-bash-at-the-beginning-of-a-script-file

3. linux 中的文件`metadata`和`data`是分开存储的么?

	- 是的
	- `mv` 为什么比 `cp` 快? 
	- https://unix.stackexchange.com/questions/454318/why-is-mv-so-much-faster-than-cp-how-do-i-recover-from-an-incorrect-mv-command

## 2019.4.10

1. 安装nginx后, 无法访问外网 80 端口

  - ```
    firewall-cmd --zone=public --add-port=80/tcp --permanent
    firewall-cmd --reload
    ```
  ```
  
  ```

2. 在使用npm安装模块时-g --save --save-dev有什么区别

	- https://blog.csdn.net/jigetage/article/details/80993563

4. graphql-java 文档

	- https://www.graphql-java.com/documentation/v11/schema/

5. serverless 中 lambda/函数计算 所使用的 cpu 核数

	- 内存与cpu的关系
	- https://stackoverflow.com/questions/34135359/whats-the-maximum-number-of-virtual-processor-cores-available-in-aws-lambda
	- https://www.jeremydaly.com/15-key-takeaways-from-the-serverless-talk-at-aws-startup-day/
	- https://engineering.opsgenie.com/how-does-proportional-cpu-allocation-work-with-aws-lambda-41cd44da3cac


## 2019.4.11

1. 数据库连接中
	
	- session 和 connection 的关系
	- hibernate
		- 在 hibernate 中, 每次http请求都会建立一个 db session
	- 参考 session和transaction的关系: https://developer.jboss.org/wiki/SessionsAndTransactions

2. mybatis

	- annotation with dynamic sql 
	- https://www.jianshu.com/p/03642b807688

	```
	@Update("<script>
	update user
	<set>
	  <if test="name != null">userName=#{name},</if>
	  <if test="address != null">userAddress=#{address},</if>
	  <if test="age != null">userAge=#{age},</if>
	</set>
	where id=#{id}
	</script>")
	```


3. mybatis 乱码

	- `jdbc:mysql://localhost:3306/blog?useSSL=false&useUnicode=true&amp&characterEncoding=utf-8`
	- 这里的 `useUnicode`, `characterEncoding` 指的是哪里的编码

4. 在 notebooks中安装 dlib

	- https://github.com/ageitgey/face_recognition/issues/703

## 2019.4.14


1. Redis缓存和MySQL数据一致性 怎么解决

	- https://zhuanlan.zhihu.com/p/58536781

2. tolearn 数学公式作图

3. 人工智能解数学题

## 2019.4.16

1. add volume to an existing docker container
	- https://stackoverflow.com/questions/28302178/how-can-i-add-a-volume-to-an-existing-docker-container

2. sql ` where name in ("xx")` 和 `where name ="xx"` 有什么区别 
	
	- 在mysql,oracle 中, 优化器会将其优化为 `where name ="xx"`, 所以没有差别
	- https://stackoverflow.com/questions/37828398/performance-differences-between-equal-and-in-with-one-value

## 2019.4.17

1. dns 查询与刷新

	- mac
		- `nslookup xxx`
		- `dscacheutil -flushcache`
	- win
		- `ipconfig /flushdns`

2. 查看进程的pid及详细信息

	- `pgrep java| xargs ps -u --pid`

3. 如何用阿里云的dns, 不经过备案直接解析到你的网站

	- 使用 `.me` 等域名
		- 在阿里云上, `.com/.net/.cn/.xin/.top/.xyz/.vip/.club/.shop/.wang/.ren` 等域名注册成功后必须进行域名实名认证，否则域名无法进行DNS解析
		- 可以使用 `godaddy` 注册
	- 使用港澳台或者国外的服务器
		- 使用 `A` 记录指向你的 港澳台或者国外的服务器 `ip`, 否则即使第一步 `dns` 解析成功, 通过外部访问你的**国内阿里云服务器**时, 阿里云会检测你的网站地址是否备案, 如果未备案, 在一定访问次数之后会直接屏蔽掉, 让你备案之后再访问. 

4. 使用 `http://netlify.com` 托管

	- `netlify` 绑定你的域名, 然后通过阿里云的 `dns` 解析, 速度贼快
	- 结合 3 中, 可以使用未备案的域名访问, netlify 中托管的网站, 并且通过国内的dns解析(阿里云dns)

5. nginx https

	- 阿里云上申请证书
	- `https://common-buy.aliyun.com/?spm=5176.2020520163.cas.1.1ba9Yij4Yij4E0&commodityCode=cas#/buy`
	- 开始Nginx的SSL模块
		- `https://www.cnblogs.com/ghjbk/p/6744131.html`
	- 跳转
		- `https://www.cnblogs.com/yun007/p/3739182.html`

6. nginx http -> https

```
server {
listen       80;
server_name  giraffetree.me;

rewrite ^(.*)$  https://$host$1 permanent;  
return 301 https://www.$server_name$request_uri;

location / {
        root   /root/web/http/;
        index  index.html;
    }
}
```


7. http code 301 307 区别??
	
	- 待研究
	- https://stackoverflow.com/questions/14484473/301-redirect-vs-307-redirect

8. nginx 使用 http2

	- `the "http2" parameter requires ngx_http_v2_module`
		- https://www.daozhao.com/8285.html
	- 什么是 HTTP/2
		- https://www.cnblogs.com/Jacck/p/7806922.html
	- 安装 HTTP/2
		- `./configure --prefix=/usr/local/nginx --with-http_ssl_module --with-http_v2_module`
	- 配置完
		- chrome 访问 http2 不开启?
			- 检查 是否支持 http2
				- `echo | openssl s_client -alpn h2 -connect giraffetree.me:443 | grep ALPN`
				- `echo | openssl s_client -nextprotoneg h2 -connect giraffetree.me:443`
			- openssl 版本低么?
				- `openssl version` -> `OpenSSL 1.0.2k-fips  26 Jan 2017`
				- https://www.openssl.org/source/openssl-1.0.2r.tar.gz
				- 更换 yum 源
					- https://www.cnblogs.com/xjh713/p/7458437.html
					 - 还是这个版本
					- `./configure --prefix=/usr/local/nginx --with-http_v2_module --with-http_ssl_module --with-openssl=/root/env/openssl/openssl-1.0.2r`
					- `make`
					- `cp /usr/local/nginx/sbin/nginx /usr/local/nginx/sbin/nginx.bak`
					- `cp ./objs/nginx /usr/local/nginx/sbin/`
					- `/usr/local/nginx/sbin/nginx -V`
					- `rm /usr/bin/nginx`
					- `ln /usr/local/nginx/sbin/nginx /usr/bin/nginx`
					- 该方法无效
				- https://serverfault.com/questions/820471/why-chrome-browser-doesnt-recognize-my-nginx-http2-server
					- 就是这里的原因 `You are using older TLS ciphers`, 我使用的 `ssl_ciphers` 已经不被 chrome 允许
					- 更换一个 ssl_ciphers 就可以了 比如: `ssl_ciphers AESGCM:HIGH:!aNULL:!MD5;`


## 2019.4.18

1. 检查服务器

	- cat /proc/cpuinfo
	- df -h

## 2019.4.19

1. 查看指定内容行数

	- `grep -c search_content  filename`

2. cdn

	- cdn 原理
		- https://linux.cn/thread-17631-1-1.html
	- 查询 dns / 服务器ip
		- `dig giraffetree.me`
	- google cloud cdn 为什么不生效
		- 响应缺少必要的 Cache-Control 标头。
			- https://cloud.google.com/cdn/docs/troubleshooting-steps
		- nginx 配置 CACHE-CONTROL

## 2019.04.22

1. 检查文件夹大小, 磁盘占用

	- `du -sh *`

2. quic 协议
	
	- 什么是 quic
		- https://drive.google.com/file/d/1EuQtUan7MdSCVrdO3MjZA9HxmZNhh98P/view
		- 什么是 RTT round-trip time
			- https://www.zhihu.com/question/39244840

	- 如何开启 quic
		- https://liudanking.com/beautiful-life/%E6%9C%AC%E7%AB%99%E5%BC%80%E5%90%AF%E6%94%AF%E6%8C%81-quic-%E7%9A%84%E6%96%B9%E6%B3%95%E4%B8%8E%E9%85%8D%E7%BD%AE/

3. spring boot http/2

	- todo

## 2019.04.23

1. 信息论

2. 查看nginx 进程

	- `ps -ef | grep nginx`

3. 检查txt `nslookup --type=txt giraffetree.me`


## 2019.4.24


1. 压缩文件夹

	- `zip -r test.zip ./tmp/*`

2. 跳过 10 行
	- `tail -n +10  xxx.log`
	- 组合使用 跳过 n 行, 搜索内容
	- `tail -n +10 xxx.log | grep "abc" | head -n 1`

3. 查找搜索内容行号
	
	- `grep -c "abc" xxx.log | head -n 1`

4. 查找某一字符串在文件中的第一行, 所在的行号

	- `grep -n "2570" 0419_night.log | cut -f1 -d: | head -n 1`

## 2019.04.26

1.  a goal is a dream with a deadline

2. SqL中使用   ESCAPE   关键字定义转义符
	
	- hibernate 使用 "!"

## 2019.04.29

1. 国际化

```java
// accept-language resolver
public class SmartLocaleResolver extends AcceptHeaderLocaleResolver {

    private final static Logger LOGGER = LoggerFactory.getLogger(SmartLocaleResolver.class);

    private final static List<Locale> LOCALES = Arrays.asList(new Locale("en"),
            new Locale("zh"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (StringUtils.isBlank(request.getHeader("Accept-Language"))) {
            return Locale.getDefault();
        }
        List<Locale.LanguageRange> list;
        try {
            list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
        } catch (IllegalArgumentException e) {
            LOGGER.warn("locale transfer error - {}", e.getMessage());
            return Locale.getDefault();
        }
        return Locale.lookup(list, LOCALES);
    }
}

// spring boot config
@Configuration
public class I18nConfig {
    @Bean
    public LocaleResolver localeResolver() {
        return new SmartLocaleResolver();
    }
}

// in a http request
Locale locale = LocaleContextHolder.getLocale();
String language = locale.getLanguage();
```

## 2019.4.30

1. spring boot messageSource with yml

	- https://qiita.com/felis/items/431f40c8a7f515f04d38#fnref5

## 2019.5.5

1. 高并发下的幂等性

	- https://cloud.tencent.com/developer/article/1162207

2. golang string to time.time

## 2019.5.6

1. ABNF 扩充巴科斯范式(BNF: Backus-Naur Form )

	- ` ` 空格  分隔元素
	- `/` 选择 
	-  值范围 `%x30-37`  即16进制 0-7
	- 序列组合 `()` 将规则组合, 视为单个元素
	- 不定量重复 `m*n`
		- `*` 元素标识 0个或更多元素 如: `*(header-field CRLF)`
		- `1*` 表示一个或更多元素 `2*4` 表示 2-4个元素
	- 可选序列 `[]`

2. 使用 ABNF 表示的 http 协议

```
HTTP-message =
start‑line 
*( header‑field  CRLF ) 
CRLF 
[ message‑body ]
```

	- ABNF for HTTP/1.1
	- https://www.tech-invite.com/fo-abnf/tinv-fo-abnf-http.html#message-body

## 2019.05.07

1. http keepalive 和 tcp 的 keepalive 有什么关联?

2. 什么是 tcp 连接?

## 2019.05.07

1. java `import static` 意义

2. `JPA` 规范要看下

## 2019.05.09

1. `Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080));`

	- http proxy

2. `GOARCH=amd64 GOOS=linux go build xxx.go`

3. `IDEA Error:java: Compilation failed: internal java compiler error`

	- File-->Setting...-->Build,Execution,Deployment-->Compiler-->Java Compiler target bytecode version

## 2019.05.11

1. java10 -> reified generics

	- https://www.zhihu.com/question/20928981
	- 玩玩看?

2. go http2  serverPush

	- https://blog.golang.org/h2push

3. SSA static single assignment

	- https://zh.wikipedia.org/wiki/%E9%9D%99%E6%80%81%E5%8D%95%E8%B5%8B%E5%80%BC%E5%BD%A2%E5%BC%8F

## 2019.05.12

1. linux 内核版本

	- `cat /proc/version`
	- `uname -r`

2. tcp 拥塞控制算法 BBR

	- https://www.cnblogs.com/x_wukong/p/7752558.html

3. socket 上使用 tcp , 如何让在有限的资源内处理更多的请求

	1. 使用多进程的方式,  使用 fork 创建子进程
	2. 使用多线程的方式,  使用 pthread_create 创建一个线程 - C10K
	3. IO 多路复用,单线程维护多个socket, 轮询调用 select 函数来监听文件描述符集合是否有变化
	4. IO 多路复用, 使用 epoll 通过注册callback 函数, 当某个文件描述符发送变化时, 主动通知
	5. 在第4步的基础上, 提高进程所能打开的最大文件描述符的个数, 增大 socket 上限

4. linux 上使用 epoll, 那 windows 上对应的机制是什么? 

	- iocp, 但原理还是有点不一致的地方

5. https
	
	- server -> client (之后缩写为 s -> c)
	1. c -> s 这是我的 随机数
	2. s -> c 这是我的 随机数 + ca证书
	3. client 证书校验 
	4. client 产生 pre-master 随机数
	5. c -> s 随机数通过 ca证书(public key)加密
	6. s server 的随机数+ client 随机数+ pre-master -> 算出 对称秘钥
	7. c server 的随机数+ client 随机数+ pre-master -> 算出 对称秘钥
	8. c -> s 以后我们就用对称加密了 change cipher spec
	9. c -> s  encrypted handshake message
	10. s -> c 好的以后就用对称加密了
	11. s -> c encrypted handshake message
	12. 使用对称加密进行通讯

6. 为什么 https 以这种方式工作

	- 对称加密效率高, 但解决不了密钥传输的问题
	- 非对称加密效率低, 但可以解决密钥传输问题

7. python ctypes.py_object

	- `self._elements = (ctypes.py_object() * size)()`
	- https://stackoverflow.com/questions/50889988/the-attribute-of-ctypes-py-object

8. python int cache

	- `[-5,256]`
	- https://stackoverflow.com/questions/15171695/whats-with-the-integer-cache-inside-python
	- 虽然顺序一致, 但根据语句的位置不同, 执行出来的结果可能也不同

## 2019.05.13

1. nginx proxy_pass 的作用

2. 做个视频记录 - 动漫女主

	- 哈哈, 要不要来个挑战
	- 没错, 用 thr Loneliest Girl 做 bgm
	- 

3. 网站访问速度优化三部曲

	1. 提升带宽
	2. 减少传输内容 - 对内容进行压缩
	3. 使用 cdn 减少源服务器压力

4. 自动生成 robots.txt 文件

	- http://tool.chinaz.com/robots/

5. 阿里云服务器安装 logtail

	- wget http://logtail-release-cn-hangzhou.oss-cn-hangzhou.aliyuncs.com/linux64/logtail.sh -O logtail.sh;chmod 755 logtail.sh
	- wget http://logtail-release-ap-southeast-1.oss-ap-southeast-1-internal.aliyuncs.com/linux64/logtail.sh -O logtail.sh; chmod 755 logtail.sh; ./logtail.sh install ap-southeast-1

## 2019.5.14

1. java jdk 11

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.0</version>
    <configuration>
        <release>11</release>
    </configuration>
</plugin>
```

2. wireshark

	- 过滤 ip
	- `ip.dst == x.x.x.x`, `ip.src == x.x.x.x`, `ip.addr == x.x.x.x`
	- `(ip.src==192.168.2.25)||(ip.dst==192.168.2.25)`
	- https://stackoverflow.com/questions/4043406/how-to-filter-by-ip-address-in-wireshark

3. localdatetime 毫秒显示 

	- `LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS"))`


4. win10 idea 更换 openJdk11, switch boot jdk -> 解决输入法光标不匹配问题

	- 升级到最新版本的idea也解决了这个问题

## 2019.05.15

1. go 创建文件夹

```golang
// 判断文件夹是否存在
func PathExists(path string) (bool, error) {
    _, err := os.Stat(path)
    if err == nil {
        return true, nil
    }
    if os.IsNotExist(err) {
        return false, nil
    }
    return false, err
}
err := os.Mkdir(_dir, os.ModePerm)
```

2. executorService 优雅关闭

3. go to js

	- https://github.com/gopherjs/gopherjs

4. 反转链表启发

	- 最重要的是链表中不能丢失指针, 一旦指针, 链表后面的数据就都没有了, 感觉这是重要的原则

## 2019.5.16

1. maven pacakge main class  -> 不包含依赖

	- 下面的配置文件主要解决 
	1. maven 打包 main class 的问题
	2. maven 编译时, java 字节码版本不对的问题(在用idea时, 自动会将 java compile bytecode 版本置为 1.5) 

```xml
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <configuration>
                <archive>
                    <manifest>
                        <addClasspath>true</addClasspath>
                        <mainClass>me.giraffetree.java.logstoredemo.mqtt.SubMsg</mainClass>
                        <classpathPrefix>libs/</classpathPrefix>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>3.1.1</version>
            <executions>
                <execution>
                    <id>copy-dependencies</id>
                    <phase>package</phase>
                    <goals>
                        <goal>copy-dependencies</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>
                            ${project.build.directory}/libs
                        </outputDirectory>
                    </configuration>
                </execution>
            </executions>
        </plugin>

    </plugins>
</build>
```

2. package main class -> 包含依赖

	- https://stackoverflow.com/questions/574594/how-can-i-create-an-executable-jar-with-dependencies-using-maven
	- `mvn clean compile assembly:single`

```xml
<plugin>
  <artifactId>maven-assembly-plugin</artifactId>
  <configuration>
    <archive>
      <manifest>
        <mainClass>fully.qualified.MainClass</mainClass>
      </manifest>
    </archive>
    <descriptorRefs>
      <descriptorRef>jar-with-dependencies</descriptorRef>
    </descriptorRefs>
  </configuration>
  <executions>
    <execution>
      <id>make-assembly</id> <!-- this is used for inheritance merges -->
      <phase>package</phase> <!-- bind to the packaging phase -->
      <goals>
        <goal>single</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```


3. jvm 关闭/hook

	- https://blog.csdn.net/dd864140130/article/details/49155179


## 2019.05.17

1. 使用 cnpm 代替 npm

## 2019.05.19

1. 进程间通讯 IPC 

   - Linux 管道

   - https://blog.csdn.net/LEON1741/article/details/77934508

## 2019.05.21

1. mqtt distributed 如何处理?

2. 逃逸分析?

	- `System.currentTimeMillis()` vs `new Date().getTime()`
	- https://stackoverflow.com/questions/36196460/what-is-faster-system-currenttimemillis-or-date-gettime

3. `System.nanoTime()` 和 `System.currentTimeMillis()`

	- https://stackoverflow.com/questions/19052316/why-is-system-nanotime-way-slower-in-performance-than-system-currenttimemill

4. why string class is final ?

	- 为什么将类声明为 final => 不允许继承, 不能扩展
	- https://stackoverflow.com/questions/5181578/what-is-the-point-of-final-class-in-java
	- https://stackoverflow.com/questions/218744/good-reasons-to-prohibit-inheritance-in-java

## 2019.5.22

1. grep 过滤注释和空白行

	- `grep "^\s*[^# \t].*$"`

2. 查看端口占用

	- `lsof -i:1883`

3. protobuf 原理

4. openResty

## 2019.5.23

1. kafka streams enable.auto.commit can't config
	
	- https://stackoverflow.com/questions/47710291/enable-auto-commit-value-is-not-configuring-to-true


## 2019.5.24

1. pwa

2. flutter desktop

```
flutter channel master
flutter upgrade
```

## 2019.5.27

1. win7 安装 docker

	- https://docs.docker.com/toolbox/toolbox_install_windows/
	- https://www.jianshu.com/p/48e546fd3c8f
	- https://github.com/boot2docker/boot2docker

2. cpuz 检查cpu/内存参数
	
	- https://zh.wikipedia.org/wiki/DDR4_SDRAM
	- cpu: 指令集,电压,速度,缓存等
	- 主板
	- 内存条: 内存频率,DDR4(Double-Data-Rate Fourth Generation Synchronous Dynamic Random Access Memory，简称为DDR4 SDRAM)第四代双倍数据率同步动态随机存取存储器
	- 显卡


3. win7 docker 的一些问题

	- docker toolbox mount file on windows
		-  bad mount mode specified 
			- https://stackoverflow.com/questions/33312662/docker-toolbox-mount-file-on-windows
		- https://stackoverflow.com/questions/50540721/docker-toolbox-error-response-from-daemon-invalid-mode-root-docker
	 	- `docker run -v /d/2019/May/docker/ecghospital/ecg-hospital-1.0.0.jar://data/ecg-hospital.jar ecghospital:1.2`
	 		- Error: Unable to access jarfile /data/ecg-hospital.jar
	 		- 挂载问题, 虽然没有解决问题
	 		- http://support.divio.com/local-development/docker/how-to-use-a-directory-outside-cusers-with-docker-toolboxdocker-for-windows
	 		- https://www.cnblogs.com/hangj/p/6502608.html
	 - 尝试远程连接 docker daemon
	 	- 远程服务器修改
	 		- 生成证书
	 		- https://www.jianshu.com/p/7ba1a93e6de4
		 	- `vim /usr/lib/systemd/system/docker.service` 修改文件中的 ExecStart
		 		- `ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock \
				--tlsverify \
				--tlscacert=/etc/docker/ca.pem \
				--tlscert=/etc/docker/server-cert.pem \
				--tlskey=/etc/docker/server-key.pem \
				-H tcp://0.0.0.0:2376`
		 	- `systemctl daemon-reload`
		 	- `systemctl restart docker`
		 	- 修改`~/.bashrc`
		 		- `alias docker='docker --tlsverify --tlscacert=/root/2019/May/cert/client/ca.pem --tlscert=/root/2019/May/cert/client/cert.pem --tlskey=/root/2019/May/cert/client/key.pem -H tcp://127.0.0.1:2375'`
		 	- 尝试 `docker version` 
		- 客户端修改
			- `docker --tlsverify --tlscacert=client/ca.pem --tlscert=client/cert.pem --tlskey=client/key.pem -H tcp://127.0.0.1:2375 version`
			- 为了简化, 这里设定 `DOCKER_CERT_PATH` 为 `D:\environment\docker.cert\client`


## 2019.5.28

1. TOTP标准算法
	
	- 两步验证
	- https://www.jianshu.com/p/a7b900e8e50a

2.  brotli 压缩算法

	- 比 gzip 好一点

3. apache flink 无敌教程

	- zh.ververica.com


## 2019.5.29

1. this cannot be referenced from a static context

	- https://stackoverflow.com/questions/13373779/non-static-class-cannot-be-referenced-from-a-static-context/13373837
	- 在一个类 A 内部建立一个 class B, 由于没有 B 不是静态类, 所以需要实例化一个 A , 才能实例化 B , 但静态内部类就没有这个限制 

2. redis 序列化问题

3. sublime package install 被墙

	- https://packagecontrol.io/ 添加这个网址到 pac.txt 中

4. sublime 文本对比
	
	- 这里我用来对比导出 sql
	- 下载插件 sublimerge

5. `pthread_create failed: Resource temporarily unavailable`
	
	- 执行任何命令均有类似如下报错
		- `man: fork failed: Cannot allocate memory`

	- 可能的解决方案
		- https://github.com/moby/moby/issues/9868
		- 已解决 https://blog.csdn.net/onlyellow/article/details/51917757
		- docker ce 中类似的问题
			- https://success.docker.com/article/how-to-reserve-resource-temporarily-unavailable-errors-due-to-tasksmax-setting

	- 一些用到的命令
		- `ps -elfT | wc -l`
		- `cat /proc/{pid}/limits`
		- `echo "kernel.pid_max=65530" >> /etc/sysctl.conf`
		- `cat /etc/security/limits.conf`
		- `systemctl status docker`
		- `cat /proc/version`
	- pid_max thread_max 的区别
		- https://unix.stackexchange.com/questions/136854/understanding-the-difference-between-pid-max-ulimit-u-and-thread-max

	- 总结
		- 表面上看起来的原因是 pthread_create 失败, 并且我提高了系统的 pid_max 后恢复了正常
		- 但我没搞懂, 我提高进程上限, 和 线程创建失败有什么关系?

6. jwt
	
	- 基本使用
		- https://www.cnblogs.com/cjsblog/p/9277677.html
		- http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html
	- online debug
		- https://jwt.io/
	- 总结
		- 感觉 jwt 和函数计算不能再般配了 =.=

## 2019.5.31

1. 何谓以直报怨?

	- 

2. java cannot referenced from a static context
	
	- You need to declare the generic type in the method signature:
	- `public static <E> BTNode<E> treeCopy(BTNode<E> source)`
	- https://stackoverflow.com/questions/4209080/using-generic-types-in-a-static-context
	- 这个方法独立于类的, 参数 E 独立于类中的标识

## 2019.6.1

1. rsync 同步文件 =.=

	- `rsync -run ./_site/* root@xxxxxx:/xx/xx/xx`

## 2019.6.2

1. 动态追踪

	- https://openresty.org/posts/dynamic-tracing/
	- SystemTap
	- flame graph 
	- 要不要去玩玩 =.=

2. SystemTap

	- SystemTap使用技巧
		- https://segmentfault.com/a/1190000010774974


## 2019.6.3

1. IM 消息如何存储

	- 阿里云 tablestore
		- im架构
			- https://yq.aliyun.com/articles/66461
		- tablestore 进阶之旅
			- https://yq.aliyun.com/topic/121?spm=a2c4g.11186623.2.7.249863eeaLmqbH

## 2019.6.4

1. v2ray NB!!!

	- v2ray 原理
		- 伪装成 https 流量 =.=
		- https://fbol.org/?p=440

2. http 协议 header 大小写问题
	
	- http 协议本身不区分大小写, 但是标准规定的请求和响应的 Header 字段名是首字母大写这种格式
	- 因为有些实现对于标准的 Header 字段并没有兼容大小写，所以流行的实现都会把你设置的 Header 转成首字母大写的格式来保证兼容性。
	- 比如 `Content-Type` 和 `Content-type`, 尽量写成第一种的格式, 避免出现不兼容现象(暗示 IE) hah
		- https://stackoverflow.com/questions/5258977/are-http-headers-case-sensitive
		- https://www.v2ex.com/t/385522

3. electron 练手项目 - oss browser

	- https://github.com/aliyun/oss-browser


## 2019.6.5

1. tablestore lsm tree

	- Log-Structured Merge Tree
	- https://www.cnblogs.com/bonelee/p/6244810.html

## 2019.6.9

1. 什么是我想要的?


2. 自然对数 e 是什么?

	- e的x方是怎么画出来的?


2. resize png example

	- https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/june/d.png?x-oss-process=image/resize,w_28

## 2019.6.12 

1. jar 包版本冲突

```xml
<dependency>
    <groupId>com.aliyun.openservices</groupId>
    <artifactId>tablestore</artifactId>
    <version>5.0.0</version>
    <classifier>jar-with-dependencies</classifier>
    <exclusions>
        <exclusion>
            <groupId>com.google.protobuf</groupId>
            <artifactId>protobuf-java</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```


## 2019.6.14

1. java static 静态块加载顺序

	- 静态块初始化

2. 机器人推理小说
	
	- 场景 => 推理嫌疑人

## 2019.6.16

1. 复旦数学系 课程安排
	
	- https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/course/math/introduce/%E5%A4%8D%E6%97%A6%E6%95%B0%E5%AD%A6%E7%B3%BB%E9%80%89%E8%AF%BE%E6%8C%87%E5%8D%97.docx
	- 分析, 占大多数, 包括数学分析AI,AII,III, 常微分方程, 复变函数, 实变函数, 概率论, 泛函分析, 数理方程, ; 
	- 代数, 包括高等代数I,II, 抽象代数I,II
	- 几何/拓扑: 解析几何, 微分几何, 拓扑I,II
	- 应用: 数学模型, 微分方程数值解, 基础力学

	- 专业必修课 28 学分
		- 数学分析
		- 高等代数
		- 解析几何
		- 抽象代数1
		- 拓扑1 (内容包含欧式空间拓扑)
	- 限定必修课 27 学分
		- 从下面12门课程中选9门
			- 常微分方程  依赖数学分析1,2,少许数学分析3
			- 复变函数 
			- 实变函数
			- 泛函分析 依赖实变函数
			- 概率论
			- 拓扑2
			- 微分几何
			- 基础力学
			- 数理方程
			- 抽象代数2
			- 数学模型
			- 微分方程数值解

## 2019.6.18

1. mysql `The server time zone value...` 错误

	- 更改时区
		- `show variables like '%time_zone%';`
		- `set global time_zone='+08:00';`

2. nginx 

	- 把 http 协议转为 HTTP2
		- why?how?what?

3. 真实?

	- 真实的好么?

## 2019.6.19

1. git tag 使用

	- 为当前commit添加标签
		- `git tag <tag-name>`
	- 获取 tag 的 commit-id
		- `git show <tag名>`
	- 回滚到该 commit
		- `git reset --hard <commit-id>`


2. `@JsonProperty` 修改 requestBody 中的传参名

	- https://stackoverflow.com/questions/38635472/how-to-rename-json-objectsvariables-name-in-spring-boot


## 2019.6.20

1. Instantiating a generic class in Java

	- https://stackoverflow.com/questions/1090458/instantiating-a-generic-class-in-java
	- https://stackoverflow.com/questions/1090458/instantiating-a-generic-class-in-java

2. go 写文件

	- https://juejin.im/entry/5ba3759cf265da0af93afb8a
	- 追加写

```golang
func tracefile(str_content string)  {
    fd,_:=os.OpenFile("a.txt",os.O_RDWR|os.O_CREATE|os.O_APPEND,0644)
    fd_time:=time.Now().Format("2006-01-02 15:04:05");
    fd_content:=strings.Join([]string{"======",fd_time,"=====",str_content,"\n"},"")
    buf:=[]byte(fd_content)
    fd.Write(buf)
    fd.Close()
}
```

## 2019.6.21


1. `@Version`

	- `import javax.persistence.*;` 可以
	- `@org.springframework.data.annotation.Version` 不行? why?

## 2019.6.23

1. eslint

	- ECMAScript/JavaScript 语法规则和代码风格的检查工具

2. vscode js 插件

	- eslint 语法检查
	- beautify 按F1 beautify file 格式化代码
	- es6 code snippets 代码提示
	- live server 静态网页preview

3. vscode 调试当前文件

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "node",
            "request": "launch",
            "name": "启动程序",
            "program": "${workspaceFolder}/${relativeFile}"//${relativeFile} 从当前打开的文件夹到当前打开的文件的路径
        }
    ]
}
```

## 2019.6.24

1. nginx 热部署

	- http://www.zsythink.net/archives/3260
		- `kill -USR2 8874`
		- `kill -WINCH 8874` 
			- 这步不会关闭旧的nginx master 主进程
			- 原因是为了之后的新进程出错, 可以及时回滚

2. nginx 日志分隔

	1. 将日志 `mv` 走
	2. `nginx -s reopen`

3. `execve() failed while executing new binary process "nginx"` 
	
	- `kill -USR2 nginx主进程pid` 时发生错误
	- 遇到这个问题的原因是由于没有通过绝对路径启动 nginx, 导致向 nginx 进程发送更新的信号时, nginx 进程无法找到新的二进制程序

4. 查看 docker 容器进程id

	- `docker top container-id`
	- `docker inspect container-id | grep Pid` // 注意 `Pid` 首字母大写

5. java try finally 
	
```java
    public static int test() {
        int a = 3;
        int b = 1;
        try {
            a = a + 1;
            return a / b;
        } catch (Exception e) {
            return 0;
        } finally {
            b = b - 1;
            a += 10;
        }
    }
    // out: 4
```

6. JS 中 `12.toString()` 为什么不能用

	- 12.toString() 会被解析成 12.（数字字面量） 和 toString()。所以正常的写法是12..toString()才是正常的

7. IIFE

	- Immediately Invoked Function Expression
	- 立即调用函数表达式
		- https://developer.mozilla.org/zh-CN/docs/Glossary/%E7%AB%8B%E5%8D%B3%E6%89%A7%E8%A1%8C%E5%87%BD%E6%95%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F


## 2019.6.26

1. js puzzlers

	- http://javascript-puzzlers.herokuapp.com/

2. js gc
	
	- js 内存泄漏问题
		- http://www.ruanyifeng.com/blog/2017/04/memory-leak.html

3. 任何足够先进的技术都和魔法无异

	- 你不知道的JS 上卷 P74
	- 致命魔术

4. 创作共享协议

	- CC BY 4.0
		- https://creativecommons.org/licenses/by/4.0/deed.zh

5. 本地文件存储/读取

	- 批量存储
	- 倒序读取

6. 昨天我踢了下我的电脑, 然后死机了, 估计内存条没插稳...然后重启之后发现 git 命令执行时出现了一系列的错误
	
	- 文件夹A: `git log` => `fatal: your current branch appears to be broken`, `git status` 正常
		- https://www.jianshu.com/p/3f528a36bfad
		- https://stackoverflow.com/questions/33012869/broken-branch-in-git-fatal-your-current-branch-appears-to-be-broken
	- 文件夹B: `git status` => `error: bad signature fatal: index file corrupt`, `git log` 正常
		1. 删除或重命名 `.git/index` 文件 
		2. 重建 `.git/index` : `git read-tree` 或者直接 `git reset`
		- https://www.clarencep.com/2017/10/23/a-note-to-git-error-bad-signature-index-file-corrupt/
		- 本地看起来正常了, `git commit/log/status` 都是对的
		- git push 错误
			- `cannot lock ref 'refs/remotes/origin/master': unable to resolve reference 'refs/remotes/origin/master': reference broken` 改了之后, 本地正常, 但是 `git push` 时错误了
				- https://stackoverflow.com/questions/2998832/git-pull-fails-unable-to-resolve-reference-unable-to-update-local-ref
				- 尝试`git gc --prune=now`
					- `error: bad ref for .git/logs/refs/remotes/origin/master`
					- `fatal: bad object refs/remotes/origin/master`
					- `error: failed to run repack`
					- 结论: 无效
			- `git status` => ` but the upstream is gone.`
			- `git branch -a` => `warning: ignoring broken ref refs/remotes/origin/master * master`
			- 检查发现 `.git/refs/remotes/origin/master` 文件内容全是 `0000000000...` (16进制)
				- 将 `.git/logs/refs/remotes/origin/master` 中最新的一次commit对应的 hashcode 拷过去(一般是最后一行)
				- 终于正常了...
		- 注意点: 
			1. 修改 `.git/logs/refs/remotes/origin/master` 时要注意编码问题, 我用记事本打开存就可以, 但是用sublime存就不行, 猜测是编码问题

## 2019.6.28

1. vim 粘贴时缩进错误问题

	- `:set paste` 在命令模式, 进入粘贴模式
	- `:set nopaste` 退出粘贴模式


## 2019.6.29

1. class object 谁先出来的?

	 - 什么是 class
	 	- 构造对象的模板
	 - 为什么要有 class
	 	- 抽象
	 - class 对象和一般的对象有什么区别?

## 2019.7.2

1. 滑动窗口问题

	- https://juejin.im/post/5bd921b6e51d45681675134e

2. 内容发布
	- 尝试下?
	- https://ghost.org/

3. 大量删除导致慢查询

	- https://tech.youzan.com/-ci-da-liang-shan-chu-dao-zhi-mysqlman-cha-de-fen-xi/

## 2019.7.3

1. java 8 spliterator

	- https://www.cnblogs.com/nevermorewang/p/9368431.html

## 2019.7.8

1. settings.xml

	- 阿里云镜像

```xml
     <mirror>
      <id>nexus-aliyun</id>
      <mirrorOf>central</mirrorOf>
      <name>Nexus aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
     </mirror>
```

2. 统计单个字符出现的次数
	
	- 比如这里我统计 `test.log` 中出现 `,` 的个数
	- `cat test.log | tr -cd ',' | wc -c`


## 2019.7.9

1. Apache/tomcat

	- Apache是一个HTTP服务器，而Tomcat或者Jetty是一个HTTP服务器+Servlet容器。HTTP服务器与Servlet容器的功能界限是：你可以把HTTP服务器想象成前台的接待，负责网络通信和解析请求，而Servlet容器是业务部门，负责处理业务请求。

2. 看源码时需要注意的

	- 看源码很容易迷失在细节里无法自拔：），所以要抓住主线，分析源码之前看看它的主要功能有哪些，比如对于Tomcat、Jetty来说，主线就是启停、请求处理过程和类加载。 另外还是需要把源码跑起来，打断点调试。

3. Java 的基础知识包括 Java 基本语法、面向对象设计的概念（封装、继承、多态、接口、抽象类等）、Java 集合的使用、Java I/O 体系、异常处理、基本的多线程并发编程（包括线程同步、原子类、线程池、并发容器的使用和原理）、Java 网络编程（I/O 模型 BIO、NIO、AIO 的原理和相应的 Java API）、Java 注解以及 Java 反射的原理等。

	- 此外你还需要了解一些 JVM 的基本知识，比如 JVM 的类加载机制、JVM 内存模型、JVM 内存空间分布、JVM 内存和本地内存的区别以及 JVM GC 的原理等。

4. 阿里云容器镜像服务
	
	- https://cr.console.aliyun.com

## 7.10

1. http://google.github.io/styleguide/javaguide.html

2. vscode go
	
	- 下载依赖
		- 使用 mod
		- goproxy
	- 调试 
		- https://segmentfault.com/a/1190000018671207

3. golang module
	
	- 搞了一个上午, 然后下午莫名其妙就可以了... 什么鬼
		- 上午的时候爆出一堆乱七八糟的错误, 快疯了....
	- 总结一下
		1. 环境变量两个环境变量 GOPROXY="https://goproxy.io", GO111MODULE="on"
		2. 并检查下 环境变量 %GOPATH%/bin 是否已经加进 PATH
		3. tools 要 clone 过去
		4. 
 	- http://ddrv.cn/a/292541
		- 好像不能用 vscode 内部自动的 go get
		- 安装了之后还是报错
	- 光标在保存之后跳到行首, 解决不了 88了 -> 用 goland

## 07.11

1. docker log 日志过大问题
	
	- Docker容器日志管理最佳实践
		- https://www.cnblogs.com/operationhome/p/10907591.html
	- `--log-opt max-file=3 --log-opt max-size=50m`

2. cookie 在 springboot 中的使用

	- https://attacomsian.com/blog/cookies-spring-boot


## 07.12

1. 待了解数据库分库

	- 读写分离

2. 全部已读

	- tablestore
		- 列数据库
	- https://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=2651961184&idx=1&sn=d0add7f47d928febbd1ebd32239f05ce&chksm=bd2d02bc8a5a8baa704268891880e2560969fc1c3ed8cc45325db4313d8b43eb6db641cb469b&scene=21#wechat_redirect
	- last_ack_id

3. 读扩散/写扩散
	
	- 架构师之路公众号
		- https://mp.weixin.qq.com/s/V1hGa6D9aGrP6PiCWEmc0w
		- 《系统通知，究竟是推送还是拉取？》
		- 《状态同步，究竟是推送还是拉取？》
		- 《网页消息，究竟是推送还是拉取？》
		- 《群已读回执，究竟是推送还是拉取？》
		- 《群消息，究竟存一份还是多份？》
		- 《feed流，究竟什么是读扩散？》
		- 《feed流，究竟什么是写扩散？》
	- 架构不(只)是设计出来的，更是演进出来的.
	- 钉钉IM服务
		- https://yq.aliyun.com/articles/66461
		- 写扩散
			- 微信朋友圈
		- 为了支持多终端，在应用服务器中会为每个终端持有一个session，每个session持有一个当前最新消息的ID，当被通知有新消息时，会去存储系统读取当前消息之后的所有消息，
	- 千万级feed流
		- https://yq.aliyun.com/articles/224132
		- 推模式,写扩散
		- 推模式之后可以使用算法, 加入.....
	- Feed流系统设计总纲
		- https://yq.aliyun.com/articles/706808
	- 头条/微博热门类
		- 非Timeline的feeds流的架构设计
			- https://www.itcodemonkey.com/article/6731.html
			- 

4. lisp, c,c++,java,js,golang,erlang,python,clojure,



## 07.14

1. FunctionalInterface 做了什么

2. jvm 不能识别 docker 内存限制

	- http://developer.51cto.com/art/201808/581473.htm

3. 查看 jvm 状态

	- jvisualvm

4. 常用配置

	- `-Xmx50m -XX:+PrintGCDateStamps`
	- `-XX:+HeapDumpOnOutOfMemoryError`


## 07.15

1. 阿里云ACP认证 

	- https://edu.aliyun.com/certification/acp01

## 07.16

1. win+R  =>  Regedit

	- HKCU/Software/Microsoft/Windows/CurrentVersion/Policies/Explorer/
	- 把DisableThumbnails的值从1改为0
	- 文件夹选项 始终显示图标从不显示缩略图

2. 查看字节码
	- 包含私有方法
	- `javap -c -p AliyunSTSUtils.class`

3. springboot @value 静态变量赋值
	- 使用 setter 方法
		- https://blog.csdn.net/mononoke111/article/details/81088472

4. 为什么要使用接口

	- 这是面向对象设计的精髓，将系统中经常变化的部分和稳定的部分隔离，有助于增加复用性，并降低系统耦合度。
	- 高内聚/低耦合

5. 适配器模式
	
	- 参考:
		- https://blog.csdn.net/qq_36582604/article/details/82261858
	- 优点
		- 适配器模式可以让两个没有任何关系得类在一起运行，只要适配器这个角色能够搞定他就成。
	 	- 增加了类的透明性。我们访问的Target目标角色，但是具体的实现都委托给了源角色，而这些对高层次模块时透明的，也是它不需要关心的。
	- tomcat 中 CoyoteAdapter 使用了适配器模式
		- CoyoteAdapter 负责将 Tomcat Request 转成 ServletRequest，再调用容器的 Service 方法。

6. Servlet规范规定了对HTTP Body的读写是阻塞的 why?

## 07.18

1. why full gc

	- 测试下 https://www.jianshu.com/p/945881f5d439

2. 微信的写扩散

	- Quorum 机制
	- https://blog.csdn.net/tb3039450/article/details/80249664

## 07.19

1. 图数据库的原理

2. union all 使用

3. executor service 中加入 shutdownHook ?

## 07.22

1. GCLocker Initiated GC 是什么

	- https://www.jianshu.com/p/ecc57a81f73c
	- https://bugs.openjdk.java.net/browse/JDK-8048556

```
23264.262: [GC (Allocation Failure) [PSYoungGen: 271547K->1874K(291840K)] 486793K->254558K(601600K), 0.0133121 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 
23264.275: [Full GC (Ergonomics) [PSYoungGen: 1874K->0K(291840K)] [ParOldGen: 252683K->47508K(308224K)] 254558K->47508K(600064K), [Metaspace: 74380K->74380K(1118208K)], 0.0837050 secs] [Times: user=0.12 sys=0.00, real=0.09 secs] 
```

```
35147.160: [GC (GCLocker Initiated GC) [PSYoungGen: 83426K->2615K(86528K)] 274007K->227491K(345088K), 0.0065559 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
35147.167: [Full GC (Ergonomics) [PSYoungGen: 2615K->0K(86528K)] [ParOldGen: 224875K->47873K(262656K)] 227491K->47873K(349184K), [Metaspace: 76851K->76851K(1120256K)], 0.0874253 secs] [Times: user=0.13 sys=0.00, real=0.08 secs] 
```

2. 什么是 cuda

3. 计算能力

	- MFLOPS（megaFLOPS）等於每秒一佰万（=10^6）次的浮点运算，
	- GFLOPS（gigaFLOPS）等於每秒拾亿（=10^9）次的浮点运算，
	- TFLOPS（teraFLOPS）等於每秒万亿（=10^12）次的浮点运算，
	- PFLOPS（petaFLOPS）等於每秒千万亿（=10^15）次的浮点运算，
	- EFLOPS（exaFLOPS）等於每秒百亿亿（=10^18）次的浮点运算。

	- gpu 性能对比
		- https://zhuanlan.zhihu.com/p/51380356
		- https://pic4.zhimg.com/v2-83ee652c2cecd7b05154bb7b174defcf_r.jpg

4. CUDA
	
	- cuda 介绍
		- https://zhuanlan.zhihu.com/p/34587739
	- nvprof 优化 cuda 性能

5. 语音识别
	- http://kaldi-asr.org/doc/

6. tomcat 
	
	- 通用的/统一的接口
		- 组合模式
	- 监听器
		- 观察者模式
	- 基类实现
		- 模板设计模式
	- 其他
		- 开闭原则
		- 接口分离原则
	- 问题
		- 组合模式和模板设计模式的区别?

7. jmx

	- tomcat 将组件注册到mbean server，用JMX管起来


## 7.23

1. 好友表为什么使用 union all

	- 小数据量的话无所谓。如果数据量大，union all 效率更高。union all 可以充分利用索引。
	- union
		- 去重且排序
	- union all
		- 不去重不排序
	- 故从效率上说，UNION ALL 要比UNION快很多，所以，如果可以确认合并的两个结果集中不包含重复数据且不需要排序时的话，那么就使用UNION ALL。
		- https://juejin.im/post/5c131ee4e51d45404123d572

2. sql explain
	- 怎么使用

3. docker-proxy

	- 这个进程是做什么的?

4. Dockerfile 最佳实践

	- https://blog.docker.com/2019/07/intro-guide-to-dockerfile-best-practices/



## 07.23 晚

1. jetty

	1. Acceptor就是不停的调accept函数，接收新的连接
	2. Selector不停的调select函数，查询某个Channel上是否有数据可读
	3. 同一个浏览器发过来的请求会重用TCP连接，也就是用同一个Channel
		- Channel是非阻塞的，连接器里维护了这些Channel实例，过了一段时间超时到了channel还没数据到来，表面用户长时间没有操作浏览器，这时Tomcat才关闭这个channel。

## 07.24

1. spring 的缺点, 由于使用组合, 两个 service 之前不能相互调用

## 07.25

1. jpa save 时使用的 `@Version` 字段不会更新, 所以需要使用 `saveAndFlush`

2. `redis-cli -a 'xx' KEYS "Device_1000*" | xargs redis-cli DEL`


## 7.29

1. 剪视频 =.=
	
	- 初学者选择免费剪辑软件（无成本，操作简单）
		- windows系统：Movie Maker、达芬奇15免费版
		- mac系统：iMovie、达芬奇15免费版
	-进阶用户（达芬奇15免费版：调色功能强大）
		- windows系统：Premiere & Aft（更加高级的视频效果）
		- mac系统：Final Cut Pro & Motion
	- 无版权音乐
		- bensound.com 
		- freemusicarchive.org 
		- jamendo.com

2. 绿里奇迹




## 07.30

1. jvm 锁消除

	- 深入理解java虚拟机 `StringBuilder` 第400页

## 07.31

1. gc 日志

	- `-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+HeapDumpOnOutOfMemoryError`
	- `-Xmx1536m -Xms1536m -XX:+PrintGCDetails -XX:+PrintGCDateStamps   -Xloggc:garbage-collection.log -XX:+HeapDumpOnOutOfMemoryError`
	- `-Xmx1536m -Xms1536m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+HeapDumpOnOutOfMemoryError`


2. shell

```sh
#!/bin/sh

while [[ true ]]; do
	jstat -gc 20284
	sleep 2
done
```


## 08.01

1. 在吞吐量方面：LZ4 > Snappy > zstd 和 GZIP；而在压缩比方面，zstd > LZ4 > GZIP > Snappy。

2. spel # vs $
	
	- `${...}` 是属性占位符语法。它只能用于取消引用属性。
	- `#{...}` 是SpEL语法，它更强大，更复杂。它还可以处理属性占位符，还有更多
		- `"#{'${property}'}"`
	- https://stackoverflow.com/questions/5322632/spring-expression-language-spel-with-value-dollar-vs-hash-vs

3. kafka

	- 新加入的 group 从加入开始的时间点(offset)开始消费

4. kafka 可视化

	- https://hub.docker.com/r/hlebalbau/kafka-manager

5. 

```Dockerfile
version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    container_name: zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka:2.12-2.2.1
    container_name: kafka
    # build: .
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 192.168.2.112
      # KAFKA_CREATE_TOPICS: "test:1:1"
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: 'true'
      KAFKA_MESSAGE_MAX_BYTES: 4000
    # volumes:
    #   - /var/run/docker.sock:/var/run/docker.sock
```

```
# 这里注意 ZH_HOSTS 由于docker 容器之间网络隔离的原因, 不能使用 localhost
# 更换 ip 及端口

docker run -d  -p 9001:9000 --name manager \
-e ZK_HOSTS="192.168.2.112:2181" \
hlebalbau/kafka-manager:stable \
-Dpidfile.path=/dev/null
```

## 08.02

1. windows 上的 docker 是怎么运行起来的?

	- 

## 08.05

1. kafka 使用过程中, 已知的问题
	- 如果选择自动创建 topic, 会导致创建时有一段时间的消息不能收到

2. exactly once 的实现
	- 目前绝大部分的消息队列提供的服务质量都是 at least once
	- 消息队列本身很难保证消息不重复
	- At least once + 幂等消费 = Exactly once。
	- 为什么大部分消息队列都选择只提供 At least once 的服务质量
	- 最重要的原因是消息队列即使做到了Exactly once级别，consumer也还是要做幂等。
		- 因为在consumer从消息队列取消息这里，如果consumer消费成功，但是ack失败，consumer还是会取到重复的消息，所以消息队列花大力气做成Exactly once并不能解决业务侧消息重复的问题。
		- 也有可能, 实际发送到消息队列, 但是由于网络超时原因 producer 端没有收到回调,直接回滚, 导致实际消息发出, 但业务操作失败, 如果不是幂等消费可能会产生错误 

3. mq topic

	- 权限控制
		- 每个程序仅允许在有限的 topic 上发送消息
		- 发送方应当可以控制哪些 customer 可以订阅消息 ?

4. 哪些需要使用消息队列, 哪些不需要使用

	- 并发量大的
	- 自身服务, 数据库性能有限, 并且没有做限流控制的

## 08.06

1. kafka rebalance 问题

	- 通过流处理框架可以解决么?

2. 积分系统设计

	- 看起来像是 京东阅读的 积分解决方案
		- https://my.oschina.net/funcy/blog/1975523
		- 缺点是: 比较难回滚 


## 08.07

1. 事务自增锁

	- 自增锁会因为事务而降低 tps 么

2. `UnexpectedRollbackException: Transaction silently rolled back because it has been marked as rollback-only`

	- spring 事务传播方式

3. mysql 5.6 版本

	- 不稳定排序的问题
		- 优化器在遇到order by xxx limit x,x 时，会做一个优化，使用优先队列(堆排序)，来进行排序，这样的好处在于在排序过程中，仅保留需要的n条数据即可。
		- https://www.jianshu.com/p/1e8a19738ae4

## 08.08

1. 寻找为什么依靠荷尔蒙的证据, 心理学依据

2. 好想法接连不断, 得以实现的却寥寥无几
	
	- 加油实现呀

3. kotlin blade

	- 用 kotlin 实现一个 blade

4. redis docker 启动

	- `docker run -d -p 6379:6379 --name redis redis:5 redis-server --appendonly yes --requirepass "123456"`

5. redis 文档

	- http://redisdoc.com/

6. 回家搭一个 redis 集群

7. spring data redis 

	- srandmember 会返回重复的元素
		- https://blog.csdn.net/MitKey/article/details/56278310

8. redis 一次添加多个元素的事务性如何保证

	- 多线程使用 redis 时的事务问题

## 08.09

1. 感觉百度翻译的没有google翻译地道 =.=

2.  xss 设置线程堆栈大小


## 08.11

1. 一下两种方式的区别

	- 反向代理 https + web 服务器 http
	- 反向代理 https + web 服务器 https

2. 在 docker 中使用 apr

3. `DirectByteBuffer` 用于实现堆外内存分配, 我们可以通过该类实现堆外内存的创建、使用和销毁。
	
	- DirectByteBuffer是通过虚引用(Phantom Reference)来实现堆外内存的释放的。
		- 其实虚引用主要被用来 跟踪对象被垃圾回收的状态，通过查看引用队列中是否包含对象所对应的虚引用来判断它是否 即将被垃圾回收，从而采取行动。
	- Cleaner是PhantomReference的子类, cleaner 是如何实现回收 堆外资源的呢? todo
		- 
	- `-XX:MaxDirectMemorySize` 指定最大的堆外内存大小，当使用达到了阈值的时候将调用System.gc()来做一次full gc，以此来回收掉没有被使用的堆外内存。
	- 使用堆外内存的原因
		- 在某些场景下可以提升程序I/O操纵的性能。少去了将数据从堆内内存拷贝到堆外内存的步骤。
		- 对垃圾回收停顿的改善, 减少堆内存, 减少gc时间, 对这点不是特别明白? todo
	- 考虑 虚拟内存 对 堆外内存的影响
	- https://www.jianshu.com/p/007052ee3773

## 08.12

1. 消息队列如何实现解耦

	- 在软件的正常功能开发中，并不需要去刻意的寻找消息队列的使用场景，而是当出现性能瓶颈时，去查看业务逻辑是否存在可以异步处理的耗时操作，如果存在的话便可以引入消息队列来解决。否则盲目的使用消息队列可能会增加维护和开发的成本却无法得到可观的性能提升，那就得不偿失了
	- 使用消息队列, 在不降低可维护性的基础上, 对业务进行解耦

2. kafka 空消费者组延时rebalance

	- 0.11 版本,为了缩短多consumer首次rebalance的时间，增加了“group.initial.rebalance.delay.ms”用于设置group开启rebalance的延时时间

3. kafka 消息格式演变 todo:read

	- https://blog.csdn.net/u013256816/article/details/80300225

4. kafka record header

	- kafka improvement proposals
		- https://cwiki.apache.org/confluence/display/KAFKA/KIP-82+-+Add+Record+Headers
	- kafka headers 的实际应用
		- 例子中, 都是使用 拦截器 对 header 进行 身份验证/签名/跟踪/自定义压缩
		- https://cwiki.apache.org/confluence/display/KAFKA/A+Case+for+Kafka+Headers

5. kafka consumer 错误 - FetchSessionHandler

	- 使用 拉取会话（Fetch Session） 的意义
		- http://zqhxuyuan.github.io/2019/03/07/2019-03-07-KafkaConsumer-IncrementalFetch/

	- `Node 1001 was unable to process the fetch request with (sessionId=2088729181, epoch=1094): INVALID_FETCH_SESSION_EPOCH.`
	- 可能有帮助的
		- https://stackoverflow.com/questions/54823733/kafka-invalid-fetch-session-epoch
		- https://cwiki.apache.org/confluence/display/KAFKA/KIP-227%3A+Introduce+Incremental+FetchRequests+to+Increase+Partition+Scalability
		- https://issues.apache.org/jira/browse/KAFKA-8052

## 08.13

1. nio, nio.2

	- 异步最大的特点是，应用程序不需要自己去触发数据从内核空间到用户空间的拷贝。

2. 一切都是政治敏感的世界真是恐怖, 想起了文革啊

3. 绝对公平的世界, 会损害人

4. 这话题的压抑感让人觉得在审判

5. tomcat heapByteBuffer 来接受网络数据

	- HeapByteBuffer来接收网络数据，需要把数据从内核先拷贝到一个临时的本地内存，再从临时本地内存拷贝到 JVM 堆，而不是直接从内核拷贝到 JVM 堆上。这是为什么呢？这是因为数据从内核拷贝到 JVM 堆的过程中，JVM 可能会发生 GC，GC 过程中对象可能会被移动，也就是说 JVM 堆上的字节数组可能会被移动，这样的话 Buffer 地址就失效了。如果这中间经过本地内存中转，从本地内存到 JVM 堆的拷贝过程中 JVM 可以保证不做 GC。
	- 为什么不 GC 原因在于 jvm 要处于 safepoint 才能 gc

## 08.15

1. docker 容器中 fontconfig 缺失问题

	- https://blog.zjyl1994.com/post/alpine-fontconfig/

2. 公司环境

	- 技术氛围
		- 技术输出
		- 分享

3. Set 'exposeProxy' property on Advised to 'true' to make it available.
	
	 - `((XXXService) AopContext.currentProxy()).callXXXMethod()`
	 - `@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)` 放在 SpringApplication 上
	 - `proxyTargetClass` 是否要创建cglib代理
	 	- todo: why use cglib ?
	 - `exposeProxy` 打开开关, 以便 AopContext 可以获取到代理

## 08.16

1. copy-on-write

	- https://juejin.im/post/5bd96bcaf265da396b72f855
	- fork 做了什么?
		- 子进程的是父进程的副本。
	- exec
		- 将子进程从父进程复制过来的数据替换掉
	- COW copy-on-write
		- fork创建出的子进程，与父进程共享内存空间(直接引用父进程的物理空间)。
		- 当父子进程中有更改相应段的行为发生时，再为子进程相应的段分配物理空间。
		- 而如果是因为exec，由于两者执行的代码不同，子进程的代码段也会分配单独的物理空间。
	- COW 的好处
		- COW技术可减少分配和复制大量资源时带来的瞬间延时。
		- COW技术可减少不必要的资源分配。比如fork进程时，并不是所有的页面都需要复制，父进程的代码段和只读数据段都不被允许修改，所以无需复制。
	- Copy On Write技术缺点是什么？
		- 如果在fork()之后，父子进程都还需要继续进行写操作，那么会产生大量的分页错误(页异常中断page-fault)，这样就得不偿失。

	- 其他应用
		- 文件系统, 用于保证文件的完整性
			- btrfs b-tree-file-system
			- https://www.ibm.com/developerworks/cn/linux/l-cn-btrfs/
		- CopyOnWriteArrayList
			- 在 add 时会复制整个 array , 所以很耗费性能
			- tomcat 的事件监听器
				- `private final List<LifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<>();`

2. MappedByteBuffer

	- 缺页中断：当程序试图访问已映射在虚拟地址空间中但未被加载至物理内存的一个分页时，由MMC发出的中断。如果操作系统判断此次访问是有效的，则尝试将相关的页从虚拟内存文件中载入物理内存
	- MMU：CPU的内存管理单元。
	- https://www.jianshu.com/p/f90866dcbffc
	- 用户空间上还有一个共享库和 mmap 映射区，Linux 提供了内存映射函数 mmap， 它可将文件内容映射到这个内存区域，用户通过读写这段内存，从而实现对文件的读取和修改，无需通过 read/write 系统调用来读写文件，**省去了用户空间和内核空间之间的数据拷贝**，Java 的 MappedByteBuffer 就是通过它来实现的


3. 微博点赞功能实现

	- https://www.zhihu.com/question/63947513
		- redis 计数器
		- 对一致性的要求不是那么高
		- http://blog.cydu.net/weidesign/2012/08/30/weibo-counter-service-design-1/
		- http://blog.cydu.net/weidesign/2012/09/09/weibo-counter-service-design-2/
			- redis 计数器相关的优化
	- 微博缓存架构
		- https://juejin.im/entry/5b166320f265da6e61788a25

4. redis rdb 和 aof

	- https://redis.io/topics/persistence
	- redis 设计与实现 
		- http://redisbook.com/

5. 工程师文化
	
	- 在公司内, 如何建立沟通
	- https://mp.weixin.qq.com/s?__biz=MzAwMDU1MTE1OQ==&mid=401460975&idx=1&sn=8e39520929d2b06c20739d54baf7c2f3&3rd=MzA3MDU4NTYzMw==&scene=6#rd

6. chubby 分布式锁
	
	 - https://catkang.github.io/2017/09/29/chubby.html


## 2019.8.28

1. windows - tomcat apr

	- Apache Portable Runtime (APR)
		- https://tomcat.apache.org/native-doc/
	- 

2. gc 日志

	- `java -jar -Xmn640m -Xms2048m -Xmx2048m -XX:SurvivorRatio=8 -XX:PermSize=128m -XX:MaxPermSize=128m -XX:+UseParallelOldGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/www/logs -Xnoclassgc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:/var/www/logs/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=2m Xxx.jar`

3. jni cookbook
	
	- jni 教程 服气, 强无敌
	- http://jnicookbook.owsiak.org/contents/

4. TCP_DEFER_ACCEPT

	- tcp 的一个server端参数
	- 当收到 3 次握手的最后一个 ack 时, 不立刻进行 accept, 而是进入一个定时器, 如果在一段时间内没有收到数据则自动关闭, 等到数据来时才接受这个链接端口
	- 需要注意的是, 有些操作系统不支持这个参数
	- tomcat apr 设置这个参数后，当 TCP 客户端有新的连接请求到达时，TCP 服务端先不建立连接，而是再等等，直到客户端有请求数据发过来时再建立连接。

5. epoll 有什么用? 它的原理是什么?

	- todo

6. Java NIO中，关于DirectBuffer，HeapBuffer

	- https://www.zhihu.com/question/57374068

7. NIO本质还是同步，数据从用户空间和内核空间之间的拷贝还是阻塞的。

8. tls 通讯建议使用 apr

9. mmap是将文件映射到用户进程的虚拟地址空间

## 2019.8.19

1. redis 

	- 如何保证持久化
		- https://blog.csdn.net/shangyuanlang/article/details/81297970
			- rdb 定义快照周期, rdb 可以更快的重启
			- 如何开启 aof , aof 日志自动压缩, aof 完全持久化
			- master-slave 灾难模拟
	- 如何迁移数据
		- 需要有 master-slave 集群
	- 实战
		- todo

2. jetty 中的 eat what you kill
	
	- 充分利用cpu缓存, 生产者消费者
	- 将 I/O 事件检测和业务处理这两种工作分开的思路也有缺点。当 Selector 检测读就绪事件时，数据已经被拷贝到内核中的缓存了，同时 CPU 的缓存中也有这些数据了，我们知道 CPU 本身的缓存比内存快多了，这时当应用程序去读取这些数据时，如果用另一个线程去读，很有可能这个读线程使用另一个 CPU 核，而不是之前那个检测数据就绪的 CPU 核，这样 CPU 缓存中的数据就用不上了，并且线程切换也需要开销。
	- 因此 Jetty 的 Connector 做了一个大胆尝试，那就是用把 I/O 事件的生产和消费放到同一个线程来处理
	- ManagedSelector 
	- todo: 还不是很了解 
	- https://webtide.com/eat-what-you-kill/

3. 池化的本质就是用内存换 CPU；而零拷贝就是不做无用功，减少资源浪费

4. 拿锁的过程本身就是个系统调用，如果锁没拿到线程会阻塞，又会发生线程上下文切换，尤其是大量线程同时竞争一把锁时，会浪费大量的系统资源

5. 什么是状态机?


## 2019.8.20

1. zookeeper 有 standalone, quorum 两种模式

	- 可以端会和其中一个 zookeeper 节点建立session
		- 节点与客户端 timeout , 节点会关闭这个session
		- 客户端与连接的 zookeeper 节点出错, 会尝试与其他节点连接
	- quorum 模式中
		- follower 读 leader 读写
		- follower 会转发 写请求

2. 类加载

	- Java 的类加载，就是把字节码格式“.class”文件加载到 JVM 的方法区，并在 JVM 的堆区建立一个java.lang.Class对象的实例，用来封装 Java 类相关的数据和方法。
	- JVM 并不是在启动时就把所有的“.class”文件都加载一遍，而是程序在运行过程中用到了这个类才去加载。
	- loadclass方法负责把字节码格式.class 文件加载到JVM的方法区
	- defineclass负责在JVM的堆区建立一个java.lang.Class 对象实例
	- tomcat 与 双亲委托
		- tomcat 的类加载器先用 extclassloader 加载类
			- ext让父加载器bootstrap去加载，防止优先加载应用中同名的类
		- 那我用appclassloader，最终也能达到bootstrap加载器去加载类的效果，那为什么不直接调用appclassloader加载？		
			- appclassloader会加载PATH目录下的类，这样就达不到优先加载web应用目录下类的目的了
			- https://stackoverflow.com/questions/37202725/why-cant-i-load-my-class-by-extclassloader

		- tomcat 使用的是 `WebappClassLoader` 继承了 `WebappClassLoaderBase`
		- Tomcat类加载器加载顺序是：ExtClassLoader - 本地目录下加载 - 父加载器加载（sharedclassloader）

3. 分析内存泄漏

	-  `jmap -dump:live,format=b,file=heap-dump.bin <pid>`生成heapdump，然后用mat分析


4. HotSpot VM默认不会JIT编译字节码大小超过8000字节的方法

    - `-XX:+DontCompileHugeMethods`
	- `-XX:HugeMethodLimit=8000`

## 2019.8.22

1. 在缓存生成前, 可能会有很多请求直接去访问数据库, 导致数据库压力过大
	- 解决方法是: 在应用提供服务前, 先对这些接口进行缓存预热

2. rocketMQ 如何做到低延迟高稳定

	- http://jm.taobao.org/2017/01/26/20170126/
	- 包含 GC,锁, 内存

3. jni `vector<int>` 转 `int[] `

	- result 为 `vector<int>`
	- `		jintArray intJavaArray = env->NewIntArray(result.Rpeaks.size());
		env->SetIntArrayRegion(intJavaArray, 0, result.Rpeaks.size(), (jint *)&result[0]);`

4. jni 内存泄漏

	- https://www.ibm.com/developerworks/cn/java/j-lo-jnileak/index.html
	- Local Reference 和局部变量有着本质的区别。
		- todo: 验证下 local reference 是否会回收
	- 理解 Local Reference 表的存在是理解 JNI Local Reference 的关键。
		- 在 native method 执行完毕切换回 Java 程序时，所有 JNI Local Reference 被删除，生命期结束（调用 JNI function 可以提前结束其生命期）。

## 2019.8.23

1. 原码 -> 补码

	- 原码 -> 补码
		- 0/正数: 原码 = 补码
		- 负数:  除第一位外取反+1 
	- 补码 -> 原码
		- 0/正数: 原码 = 补码
		- 负数: 补码-1, 然后除第一位外取反

2. java 基本数据类型数组的 length 是函数还是属性

	- 属性
	- array 数组都是对象, 继承了 Object

3. hibernate 清除缓存
	- `private EntityManager entityManager; entityManager.clear();` 
	- https://blog.csdn.net/u012643122/article/details/47433559

## 2019.8.26

1. docker 日志过多

	- 分割日志的方法

## 2019.8.27

1. CMS, G1 https://yq.aliyun.com/articles/444436

## 2019.8.29

1. 使用 redis  incr 和 expire 进行一定时间内计数
	- 可以使用这个方案解决流量控制的问题

2. redis zset 内部实现

	- 使用 `zincrby key incrment member ` O(log(N)) 可以实现一定数据量内的计数问题
		- 当然使用 `incr/decr/HINCRBY` 效率更高 O(1), 但你可能需要自己实现排序
	- 使用 `zrevrange key start end withscores` O(log(N)+M) 可以解决排序问题
	- 都是原子操作

## 2019.8.30

1. `/etc/init.d/rc.local` 中为什么有一句 `touch /var/lock/subsys/local`
	
	- 防止脚本重复执行
	- https://blog.csdn.net/sinat_16791487/article/details/76696753

2. 做一档程序员的节目??
	
	- 来点好玩的?
	- 程序员 vedio?

3. `不兼容的类型: java.util.List<java.lang.String>无法转换为java.util.Collection<java.io.Serializable>`

	- why?

## 2019.9.2

1. java 能力测试

	- https://developer.aliyun.com/article/714279

## 2019.9.3

1. 关于 docker 日志迁移
	
	- 由于之前的 docker 日志并没有做日志分割, 导致日志文件越来越大
	- 方法: 
		- `cd /var/lib/docker/containers/{container_id}/`
		- `mv {container_id}-json.log old.log` 之前的`old.log`在容器重启前还会继续存入日志, 不会影响现在的服务
		- `docker restart xxx` 重启之后, 日志会重定向到新的 `{container_id}-json.log` 
		- 这个故事的后续是, dockerd 进程仍然引用了这个文件, 当我rm后, 它实际并未删除
		- 接下来就是 接下来就是如何删除 已经deleted文件的故事了....

2. mysql 5.6/5.7 的 `count(*)` 差异

	- https://yq.aliyun.com/articles/177835

3. 查看系统应该 deleted 但是没有删除的文件

	- 如何清理 docker containers 目录下的文件
		- 已经被删除, 但没有释放磁盘
	- `lsof -w |grep deleted` 其中 `-w` 为忽略错误
	- `cat /dev/null > /proc/{pid}/fd/{xx}`
	- https://unix.stackexchange.com/questions/34140/tell-fs-to-free-space-from-deleted-files-now
	- https://mp.weixin.qq.com/s/oCK0chpOmJcCnPdMhcketw

4. 优雅地清理 docker 日志

	- https://stackoverflow.com/questions/42510002/how-to-clear-the-logs-properly-for-a-docker-container

5. Garbage-First (G1) 垃圾优先回收器

	- G1 将堆拆成一系列的分区 heap region
	- 新生代 
		- 复制算法 
		- 预测时间动态地改变新生代大小? how? why? 
	- 老生代
		- 混合回收
	- 问题
		- 老生代中, 什么是 mixed GC
		- 列车算法?
	- heap region 参数
		- `G1HeapRegionSize` 1M 到 32M, 2次幂对齐

6. java 8 默认gc

	- https://stackoverflow.com/questions/33206313/default-garbage-collector-for-java-8
	- Java 7 - Parallel GC  
	- Java 8 - Parallel GC `-XX:+UseParallelGC`
	- Java 9 - G1 GC  `-XX:+UseG1GC`
	- Java 10 - G1 GC
	- Java 11 - may be ZGC?

7. 指定 `Metaspace` `-XX:MetaspaceSize=96M`

	- https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html#BABFAFAE
	- 设置分配的类元数据空间的大小，该空间将在第一次超出时触发垃圾回收。根据使用的元数据量，增加或减少垃圾收集的阈值。默认大小取决于平台。
	
## 2019.9.5

1. spring `BeanUtils.copyProperties()`

	- `xxxMethod.setAccessible(true)` why
	- 实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
		- todo: test
	- 关于反射中能用到的工具
		- http://gityuan.com/2015/07/18/java-reflection/

2. oracle java

	- 故障排除指南
		- https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/ 

3. 发现 kafka, zookeeper 默认都是用G1GC 启动的 =.= 

	- `-XX:+UseG1GC -XX:MaxGCPauseMillis=20  -XX:InitiatingHeapOccupancyPercent=35 -XX:+ExplicitGCInvokesConcurren`

4. final 字段编译出来的字节码, 和普通变量编译出来的字节码有什么不同么?

5. 查看 linux 内核版本

	- `cat /proc/version`

6. 解压

```
unzip filename. zip.
tar -zxvf filename. tar.gz.
tar -Jxvf filename. tar.xz.
tar -Zxvf filename. tar.Z.
tar --help.
tar -xvf filename. tar.gz tar -xvf filename.
```

7.  后台启动 frp `nohup ./frps -c ./frps.ini &`

8. 服务器上的 nginx 有点问题, 用域名映射不行 =.= 

	- todo: why

9. hibernate 与 mybatis

	- hibernate 不方便的地方
		- 在写一些sql不被jpa支持, 只能用 nativeQuery
		- 在写 join 的时候, 很难进行 orm , 导致后面花费很多时间在对象映射上


## 2019.9.5 night

1. kafka 生产参数配置示例

	- `-Xmx6g -Xms6g -XX:MetaspaceSize=96M -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX：InitiatingHeapOccupancyPercent=50`

2. How to know region size used of G1 garbage collector?

	- https://stackoverflow.com/questions/46786601/how-to-know-region-size-used-of-g1-garbage-collector

```
<4GB -  1MB
 <8GB -  2MB
<16GB -  4MB
<32GB -  8MB
<64GB - 16MB
64GB+ - 32MB
```

3. KB / KiB，MB / MiB，GB / GiB，… 的区别是什么？

	- KiB是kilo binary byte的缩写，指的是千位二进制字节

```
1KB = 1,000 Byte
1MB = 1,000 KB
1GB = 1,000,000 KB

1KiB = 1,024Byte
1MiB = 1,024KiB
1GiB = 1,024MiB = 1,048,576 KiB
```

4. JDK7 中的 `LinkedTransferQueue` 通过追加字节的方式, 来优化出队入队性能, 还是第一次听过

5. synchronized 实现同步的基础, 每一个对象都可以作为锁

	- 普通同步方法, 当前实例对象
	- 静态同步方法, 当前 class
	- 同步方法块, 括号中的对象

6. 偏向锁 -> 轻量级锁 -> 重量级锁

	- 偏向锁和轻量级锁的区别
	- 什么是自旋? 
		- 感觉像是一直循环, 不会阻塞

7. 同步模型

	- 共享内存 java
	- 消息传递 golang

8. java object header

	- https://stackoverflow.com/questions/26357186/what-is-in-java-object-header

9. `-XX:+PrintCommandLineFlags`

	- `-XX:-BytecodeVerificationLocal -XX:-BytecodeVerificationRemote -XX:+HeapDumpOnOutOfMemoryError -XX:InitialHeapSize=1073741824 -XX:+ManagementServer -XX:MaxHeapSize=1073741824 -XX:MetaspaceSize=100663296 -XX:+PrintCommandLineFlags -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:TieredStopAtLevel=1 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseG1GC -XX:-UseLargePagesIndividualAllocation `
	- todo: 查查这些参数什么意思...

10. `-XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1LogLevel=finest `

11. `GCTimeRatio` 设置为 19 ,则gc时长占比 5%

## 2019.9.6


1. `Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: Transaction marked as rollbackOnly`

	- 看起来像是, 一个事务已经被标记为回滚, 但是又被提交了

2. `bigdecimal` 字段范围 2位小数

	- `new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)`
	- 参考: https://stackoverflow.com/questions/11319445/java-to-jackson-json-serialization-money-fields

```java
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 转为下划线的样式  objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        // 默认将所有date类型转换成 timestamp
        objectMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, new MoneySerializer());
        objectMapper.registerModule(module);

        return objectMapper;
    }

    public class MoneySerializer extends JsonSerializer<BigDecimal> {
        @Override
        public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(value.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        }
    }
```

3. kafka client 收到 `INVALID_FETCH_SESSION_EPOCH`

	- 好吧, 之前遇到过这个问题=.=

4. hibernate 操作数据库时的异常

	- https://blog.csdn.net/wj123446/article/details/77873661


## 2019.9.7

1. https 中 url 会被加密么

	- https://stackoverflow.com/questions/499591/are-https-urls-encrypted
	- 是的, SSL连接位于TCP层和HTTP层之间。客户端和服务器首先建立安全的加密TCP连接（通过SSL / TLS协议），然后客户端将通过该加密的TCP连接发送HTTP请求（GET，POST，DELETE ...）。


## 2019.9.9

1. `lscpu` 查看 cpu 核心数

## 2019.9.10

1. springboot 查看所有 param

	- https://stackoverflow.com/questions/42823730/spring-boot-how-to-get-all-request-params-in-a-map-in-spring-restcontroller


2. `BigDecimal`

	- `toString`
		- 有必要时使用科学计数法
	- `toEngineeringString`
		- 有必要时使用工程计数法。工程记数法是一种工程计算中经常使用的记录数字的方法，与科学技术法类似，但要求10的幂必须是3的倍数
	- `toPlainString`
		- 不使用任何指数
	- https://www.cnblogs.com/happy520/p/7090199.html

3. G1 对象分配

	- 普通的分配对象要加全局锁, 但是这样会导致分配效率低下
	- 所以为了满足
		- 避免使用全局锁
		- 满足不同用户线程(mutator)之间能并行分配
	- 于是就有了 TLAB thread local allocation buffer 线程本地分配缓冲区
	- 首先 TLAB 空间分配时, 还是需要锁的, G1 中使用的是 CAS 分配
	- 在 TLAB 内部分配对象空间是无锁的
		- bump (up) the pointer 指针加法 
		- 如果加法后空余内存指针的值仍小于或等于指向末尾的指针，则代表分配成功。否则，TLAB 已经没有足够的空间来满足本次新建操作。这个时候，便需要当前线程重新申请新的 TLAB。


4. 搭建一个图片分享服务器

5. 家用 nas 内网穿透, 不经过服务器

	- https://github.com/fatedier/frp/blob/master/README_zh.md#%E7%82%B9%E5%AF%B9%E7%82%B9%E5%86%85%E7%BD%91%E7%A9%BF%E9%80%8F
	- xtcp

## 2019.9.11

1. G1

	- java 逃逸分析是什么?
		- https://www.cayun.me/java/Java%E9%80%83%E9%80%B8%E5%88%86%E6%9E%90/
	- G1 GC 下的字符串排重
		- `-XX:+UseStringDeduplication`
        - `-XX:StringDeduplicationAgeThreshold=6`
        - `-XX:+PrintStringDeduplicationStatistics`
        - https://blog.gceasy.io/2018/07/17/disappointing-story-on-memory-optimization/
    - `-XX:+PrintAdaptiveSizePolicy` // 打印 G1 Ergonomics 相关信息
    - G1 调优指南
    	- https://docs.oracle.com/javase/9/gctuning/garbage-first-garbage-collector-tuning.htm#JSGCT-GUID-0BB3B742-A985-4D5E-A9C5-433A127FE0F6

2. 为什么String类要缓存 hash?

	- 性能

3. 为什么要用 31 来计算散列码 hashCode
	- `31 * i == (i<<5)-i`
	- 现代VM 可以自动完成这类优化

4. 使用 hashCode 来攻击应用程序

	- 有一些应用的 http 请求中 header/param 是通过 `Map<String,Object>` 来存的, 其实很容易通过构造相同的 hashCode String 来进行 ddos 攻击
	- https://dzone.com/articles/what-is-wrong-with-hashcode-in-javalangstring

5. jdk1.8中，string是标准的不可变类，但其hash值没有用final修饰，其hash值计算是在第一次调用hashcode方法时计算，但方法没有加锁，变量也没用volatile关键字修饰就无法保证其可见性。当有多个线程调用的时候，hash值可能会被计算多次，虽然结果是一样的，但jdk的作者为什么不将其优化一下呢？

	- 作者回复: 这些“优化”在通用场景可能变成持续的成本，volatile read是有明显开销的；
	- 虽然会浪费一些 cpu 资源, 但是它是安全的
	- https://stackoverflow.com/questions/41704185/is-javas-string-hashcode-function-thread-safe-if-its-cache-setter-does-not-us

如果冲突并不多见，read才是更普遍的，简单的cache是更高效的
	- 我比较同意作者的观点, 脱离实际的优化都是瞎扯淡=.=
	- 来源: https://time.geekbang.org/column/article/7349

6. java 类型卸载

	- G1 中的类型卸载
		- `-XX:+ClassUnloadingWithConcurrentMark`
		- 在并发标记阶段结束后，JVM 即进行类型卸载。
	- https://time.geekbang.org/column/article/10651

7. card table是remembered set的一种实现

## 2019.9.12

1. 数据库事务乐观锁

	- hibernate + springboot 如何实现 `@Version`

2. swagger + nginx 无法正常使用

	- https://blog.csdn.net/zixiangli/article/details/90030185
	- `proxy_set_header Host $host; # 指定host`

3. kafka 广播导致不能用?

## 2019.9.16

1. redis 单线程

	- jetty eat what you kill

2. 再谈 copy on write (COW, 写时复制) 的思想

	- COW 不仅仅是一种技术, 也是一种思想, 读多写少, 保证并发安全
	- 不可变对象的写操作往往都是使用 Copy-on-Write 方法解决的
		- 王宝令 https://time.geekbang.org/column/article/93154
		- Java 里 String 这个类在实现 replace() 方法的时候，并没有更改原字符串里面 value[] 数组的内容，而是创建了一个新字符串，这种方法在解决不可变对象的修改问题时经常用到
	- docker images
	- git 文件储存
		- git 增量存储
		- https://stackoverflow.com/questions/8198105/how-does-git-store-files
	- 使用 Copy-on-Write 更多地体现的是一种延时策略，只有在真正需要复制的时候才复制，而不是提前复制好
		- 王宝令 https://time.geekbang.org/column/article/93154

	- redis 使用 cow 实现快照持久化
		- 钱文品 <<redis 深度历险>>
	- java CopyOnWriteArrayList 
	- 实际项目中:
		- 维护很少修改的 路由表
	- 以至于 Java 中的基本数据类型 String、Integer、Long 等都是基于 Copy-on-Write 方案实现的。	

3. 通过避免共享解决并发问题

	- Immutability 模式、Copy-on-Write 模式和线程本地存储模式本质上都是为了避免共享
		- 王宝令 https://time.geekbang.org/column/article/96736

4. 活锁

	- 例子
		- 所谓的“活锁”，可以类比现实世界里的例子。路人甲从左手边出门，路人乙从右手边进门，两人为了不相撞，互相谦让，路人甲让路走右手边，路人乙也让路走左手边，结果是两人又相撞了。
		- 这种情况，基本上谦让几次就解决了，因为人会交流啊。可是如果这种情况发生在编程世界了，就有可能会一直没完没了地“谦让”下去，成为没有发生阻塞但依然执行不下去的“活锁”。
	- 解决: 随机等待


5. 栈帧 与 栈 , stackOverFlow, 栈溢出

	- 每个线程都有自己独立的调用栈 (里面与很多栈帧)
	- 因为每调用一个方法就会在栈上创建一个栈帧，方法调用结束后就会弹出该栈帧，而栈的大小不是无限的，所以递归调用次数过多的话就会导致栈溢出。

6. docker cp

	- `docker cp <containerId>:/file/path/within/container /host/path/target`
		- 例如: 
			- `docker cp eddb38febacc:/data .`
			- `docker cp eddb38febacc:/data C:\Users\pc\Desktop\data\`
	- https://stackoverflow.com/questions/22049212/copying-files-from-docker-container-to-host

7. docker 启动带有 bloom filter 的 redis

	- `docker run -p 6379:6379 -v E:\local\path\data:/data --name redisbloom redislabs/rebloom:2.0.3 redis-server /data/redis.conf --loadmodule /usr/lib/redis/modules/redisbloom.so`

## 2019.9.17

1. lettuce 集成进 spring boot

	- 如果用原生的 spring data redis 会导致有很多 redis 命令无法使用
		- https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#_supported_commands
	- lua 实现 cas
		- eval https://redis.io/commands/eval
			- 例如 `eval "return redis.call('set','foo','bar')" 0`
		- lua dubuger https://redis.io/topics/ldb
	- lua + redis 使用指南
		- https://www.redisgreen.net/blog/intro-to-lua-for-redis-programmers/
	- 使用 lua 脚本


2. 中间件性能挑战赛
	
	- 初赛要求实现一个简化、高效的本地 kv 存储引擎，复赛在初赛的基础上增加了计算存储分离的架构，计算节点需要通过网络传输将数据递交给存储节点存储。
	- https://www.cnkirito.moe/taurusdb-race/#more

3. 容器如何限定内存, cpu, 磁盘

4. srping data redis 如何扩展命令

	- 比如: 使用redis插件中的命令:布隆过滤器, 一些额外的监控命令, spring data redis 中无法支持的命令 
	- 最简单通用的方法 lua

5. 记录日志请求参数

	- 使用 aop 拦截器
		- 在请求来的时候, 进行日志记录

6. 安装windows 包管理器 

	- 在 PowerShell 中输入下面内容，保证允许本地脚本的执行：
		- `set-executionpolicy remotesigned -scope currentuser`
	- 然后执行下面语句进行安装：
		- `iex (new-object net.webclient).downloadstring('https://get.scoop.sh')`

## 2019.9.18

1. 今天一篇文章

2. 为什么要重写 hashCode 和 equals 方法

	- 在使用 hashMap 时, hashMap 使用 equals 来判断两个 key 是否相等, 使用 hashCode 来分区
	- 现在有个两个对象(不同的内存位置) A,B, 我们将这两个元素作为 hashMap 的 key
		- 如果只重写 equals 可能会导致两个元素分别放置在两个不同的 bucket 中, 放置了两次
		- 如果只重写 hashCode 可能会导致两个元素在同一个bucket中, 且仍然被放置了两次
			- hashCode 决定了一个元素该被放入哪个 bucket
		- https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java

3. stream split partition stream

	-  `Map<Boolean, List<Object>> collect = mget.stream().collect(Collectors.partitioningBy(Objects::nonNull));`

4. how java stream works


5. stream duplicate key 怎么处理

	- collectors.toMap

## 2019.09.19

1. js 跨域问题

	- https://juejin.im/post/5ab218b1518825555c1d8a11
	- Access-Control-Allow-Origin 跨域设置多域名
		- 不能设置, 只能通过判断 origin 来进行操作
		- https://www.jianshu.com/p/b587dd1b7086

## 2019.09.20

1. springboot 如何判断当前事务是否已经回滚

	- 不同事务等级会产生什么样的影响 ?
		- https://juejin.im/post/5b00c52ef265da0b95276091
	- How do I get transaction info in Spring whether transaction is committed or rollback in a declarative transaction management?
		- https://stackoverflow.com/questions/13395794/how-do-i-get-transaction-info-in-spring-whether-transaction-is-committed-or-roll


2. java 后端开发中可能遇到的 幻/Phantom 

	- 幻读
		- 使用 sql 说明幻读

3. http
	-`HttpClient httpClient = HttpClientBuilder.create().build();`

4. mysql 行格式

	- compact 
	- compressed
	- default
	- dynamic
	- fixed
	- redundant


## 2019.09.22

1. 费曼学习法

	- 通过向别人清楚地解说一件事，来确认自己真的弄懂了这件事。
	- 第一步 - 选择一个你想要理解的概念
		- 选择一个你想要理解的概念, 然后拿出一张白纸, 把这个概念写在白纸的最上边.

	- 第二步 - 设想一种场景，你正要向别人传授这个概念
		- 在白纸上写下你对这个概念的解释, 就好像你正在教导一位新接触这个概念的学生一样. 当你这样做的时候, 你会更清楚地意识到关于这个概念你理解了多少, 以及是否还存在理解不清的地方.

	- 第三步 - 如果你感觉卡壳了, 就回顾一下学习资料
		- 无论何时你感觉卡壳了, 都要回到原始的学习资料并重新学习让你感到卡壳的那部分, 直到你领会得足够顺畅, 顺畅到可以在纸上解释这个部分为止.

	- 第四步 - 为了让你的讲解通俗易懂，简化语言表达
		- 最终的目的, 是用你自己的语言, 而不是学习资料中的语言来解释概念. 如果你的解释很冗长或者令人迷惑, 那就说明你对概念的理解可能并没有你自己想象得那么顺畅 -- 你要努力简化语言表达, 或者与已有的知识建立一种类比关系, 以便更好地理解它。
	- https://www.zhihu.com/question/20576786

2. gc 可视化工具

	- gcviewer
		- https://github.com/chewiebug/GCViewer
		- `java -jar gcviewer.jar`
	- gceasy.io
		- 统计gc时长, 百分比
		- https://www.gceasy.io/

3. 获取 jvm pid

	- https://stackoverflow.com/questions/35842/how-can-a-java-program-get-its-own-process-id
	- `ManagementFactory.getRuntimeMXBean().getName()`

4. jvm eden 与 survivor 的比例

	-  默认情况下，Java 虚拟机采取的是一种动态分配的策略（对应 Java 虚拟机参数 -XX:+UsePSAdaptiveSurvivorSizePolicy），根据生成对象的速率，以及 Survivor 区的使用情况动态调整 Eden 区和 Survivor 区的比例。

5. hotspot card table 的实现

	- 如果想要保证每个可能有指向新生代对象引用的卡都被标记为脏卡，那么 Java 虚拟机需要截获每个引用型实例变量的写操作，并作出对应的写标识位操作。
	- 这个操作在解释执行器中比较容易实现。但是在即时编译器生成的机器码中，则需要插入额外的逻辑。这也就是所谓的写屏障（write barrier)
	- 虚共享 false sharing 问题 两个线程同时更新卡表的问题
	- `-XX:+UseCondCardMark`，来尽量减少写卡表的操作

6. why ?

```
class ObjectOf64Bytes {
    long placeholder0;
    long placeholder1;
    long placeholder2;
    long placeholder3;
    long placeholder4;
    long placeholder5;
}
```

7. `-Xmn` : the size of the heap for the young generation

8. switch 语法糖
	
	- `javac Test.java`
	- `javap -v Test`
	- 所以 switch 底层是怎么实现的?

```java
// Test.java
public class Test{
  public static void main(String[] args){
    String s = "alpha";
    switch (s) {
	case "alpha": // fall through
	case "beta":  System.out.println("ab"); break;
	case "Ea":    System.out.println("e"); break;
	case "FB":    System.out.println("f"); break;
    }
  }
}

```

```java
// 反编译之后的
public class Test {
    public Test() {
    }

    public static void main(String[] var0) {
        String var1 = "alpha";
        byte var3 = -1;
        switch(var1.hashCode()) {
        case 2236:
            if (var1.equals("FB")) {
                var3 = 3;
            } else if (var1.equals("Ea")) {
                var3 = 2;
            }
            break;
        case 3020272:
            if (var1.equals("beta")) {
                var3 = 1;
            }
            break;
        case 92909918:
            if (var1.equals("alpha")) {
                var3 = 0;
            }
        }

        switch(var3) {
        case 0:
        case 1:
            System.out.println("ab");
            break;
        case 2:
            System.out.println("e");
            break;
        case 3:
            System.out.println("f");
        }
    }
}
```

## 2019.9.23 晚

1. GPGC Generational Pauseless GC  -> C4GC 
	- Continuous concurrent compaction collector
	- marking, relocation, remapping
	- https://blog.csdn.net/uftjtt/article/details/80269936
	- 消除了重标记可能引起的重标记无限循环，也就消除了在标记阶段出现OOM错误的风险。

2. 无安全点检测的计数循环带来的长暂停

	- 多线程等待另一个线程进入安全点

3. jvm 参数配置

	- `-XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintHeapAtGC`
	- `-XX:+PrintGCDateStamps -XX:+PrintGC -XX:+PrintGCApplicationStoppedTime -XX:+PrintSafepointStatistics -XX:+PrintGCApplicationStoppedTime -XX:+UseCountedLoopSafepoints`
	- `-XX:+PrintGC -Xmn100M -XX:PretenureSizeThreshold=10000 -XX:+PrintHeapAtGC，-XX:-UsePSAdaptiveSurvivorSizePolicy or -XX:SurvivorRatio=N`


4. 常用jvm工具

	- 查看运行时 jvm 参数
		- `jinfo -flags {pid}`
		- `Non-default VM flags: -XX:+UseParallelGC ...
		Command line: -XX:+PrintHeapAtGC -Dspring.output.ansi.enabled=always ...`
	- 查看运行时java堆状态
		- `jstat -gc {pid} {毫秒数} {执行几次}`
		- ` S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
		10752.0 10752.0 10590.2  0.0   91648.0  11082.3   114176.0   10595.5   30848.0 29365.7 4224.0 3940.3      4    0.043   1      0.033    0.076`

5. 长时间循环导致的安全点延迟

	- https://stackoverflow.com/questions/48627532/jvm-safepoint-pauses-but-only-when-code-is-in-method-and-its-not-the-gc-engag
	- `-XX:+UseCountedLoopSafepoints`
	- 参数含义
		- https://juejin.im/post/5d1b1fc46fb9a07ef7108d82
	- JVM认为比较短的循环，所以不会放置Safepoint，比如用int作为index的循环。与其对应的是Uncounted loop。

6. todo read

	- 现代JVM中的Safe Region和Safe Point到底是如何定义和划分的?
		- https://www.zhihu.com/question/29268019
	- Safepoints: Meaning, Side Effects and Overheads
		- http://psy-lob-saw.blogspot.com/2016/02/wait-for-it-counteduncounted-loops.html

## 2019.9.24

1. mq 消息发送过快, 导致事务未提交? 有可能么?
	- mq 的消息是否应该放在事务中

2. 想了老半天多个第三方支付系统, 重复支付的问题, 感觉好麻烦, 没有好的解决方案
	- 最后直接放弃解决, 只记录日志, 方便追溯 =.= 豁然开朗, MD想太多了
	- 简单的才是好的 =.= yeah

## 2019.9.25

1. 超越经典概念 - 量子

	- 观察的结果, 在观察之前不一定存在
	- 观察的过程改变了现实存在

2. 自由意志 free will =我的意识能够产生相对于外界的随机

	- 人的智慧是经典的
		- 大脑=神经元, 电压控制

3. 量子计算比经典计算更加快
	- 规模 N -> 2^N 的经典系统

4. 猜想: 物理里面有一些定理/断言, 无法被实验证明 
	- 哥德尔不完全

5. 万物万事量子生 it from qubit
	- 不同物质对应不同的量子态
	- 引力也可从量子信息中涌现出来 emerge
	- 通过量子态模拟万物: 光, 电, 引力

6. ocean base 使用 paxos 

	- 兼容 mysql
	- 分布式数据库

7. 一个bug倒下去, 还有千万个bug站起来

8. 李氏代换

	- 任何基类可以出现的地方, 子类一定可以出现

9. 迪米特法则

	- 一个对象应当对其他对象有尽可能少的了解

10. 分布式事务

	- 坑TT
	- 就下个单而已, 事情怎么那么多
		- https://juejin.im/post/5cdfe4a16fb9a07ef63facc3
11. 库存
	
	- 好像不太适合用 乐观锁做, 只要不小于0就可以

## 2019.9.27

1. docker  Error starting userland proxy: /forwards/expose/port returned unexpected status: 500
	- 重启 docker service 后正常

2. unsafe 与 类加载器


## 2019.9.29

1. Starting without optional epoll library

	- 如何处理

2. 

## 2019.10.8

1. log4j2 配置

	- https://howtodoinjava.com/log4j2/log4j-2-xml-configuration-example/

2. 门面模式

	- 自测: 举个例子
	- https://www.cnblogs.com/java-my-life/archive/2012/05/02/2478101.html
	- 优点举例:
		- 选择性地暴露方法, 层次感
			- 使用门面模式来隐藏内部实现，对外提供服务。
		- 松耦合

3. 状态模式

	- 状态模式允许一个对象在其内部状态改变时改变它的行为，对象看起来就像是改变了它的类。
	- 通过状态子类或者 switch 语句实现

4. 单例模式

	- 使用 ConcurrentHashMap putIfAbsent 完成单例模式
	- 单例模式涉及一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

5. 如何进行消息队列中的消息链路追踪?


## 2019.10.09

1. Concurrent and Parallel difference
	- https://joearms.github.io/published/2013-04-05-concurrent-and-parallel-programming.html?spm=a2c4e.10696291.0.0.a1a819a4lQXE3E

2. 压测/监测工具 jmeter/gcviewer

3. 设置大堆

	- 主要是会引起gc停顿时间过长
	- 吞吐量会上去

4. 逃逸分析
	- 逃逸分析是 一种确定指针动态范围的静态分析，它可以分析在程序的哪些地方可以访问到指针
		- 进行逃逸分析
			- Java 虚拟机中的逃逸分析针对的是新建对象
			- 在 Java 虚拟机的即时编译语境下，逃逸分析将判断新建的对象是否逃逸。即时编译器判断对象是否逃逸的依据，一是对象是否被存入堆中（静态字段或者堆中对象的实例字段），二是对象是否被传入未知代码中。由于 Java 虚拟机的即时编译器是以方法为单位的, 对于方法中未被内联的方法调用，即时编译器会将其当成未知代码，
		- 逃逸分析之后可以进行的优化
			- 锁消除
				- `synchronized (new Object()) {}`
				- `synchronized (escapedObject) {}` 则不然。由于其他线程可能会对逃逸了的对象escapedObject进行加锁操作，从而构造了两个线程之间的 happens-before 关系。因此即时编译器至少需要为这段代码生成一条刷新缓存的内存屏障指令。
			- 栈上分配
				- 如果逃逸分析能够证明某些新建的对象不逃逸，那么 Java 虚拟机完全可以将其分配至栈上，并且在 new 语句所在的方法退出时，通过弹出当前方法的栈桢来自动回收所分配的内存空间。这样一来，我们便无须借助垃圾回收器来处理不再被引用的对象。
				- 由于实现起来需要更改大量假设了“对象只能堆分配”的代码，因此 HotSpot 虚拟机并没有采用栈上分配，而是使用了标量替换这么一项技术。
			- 标量替换
				- 标量替换这项优化技术，可以看成将原本对对象的字段的访问，替换为一个个局部变量的访问
		- https://time.geekbang.org/column/article/18048
		- https://zh.wikipedia.org/wiki/逃逸分析
	- 逃逸分析的基本行为就是分析对象动态作用域：当一个对象在方法中被定义后，它可能被外部方法所引用，例如作为调用参数传递到其他地方中，称为方法逃逸。
		- https://www.hollischuang.com/archives/2583
	- 例子: 演示逃逸分析的作用
		- http://www.hollischuang.com/archives/2398
		- https://stackoverflow.com/questions/771430/escape-analysis-in-java


5. 在Java虚拟机中，对象是在Java堆中分配内存的，这是一个普遍的常识。但是，有一种特殊情况，那就是如果经过逃逸分析后发现，一个对象并没有逃逸出方法的话，那么就可能被优化成栈上分配。这样就无需在堆上分配内存，也无须进行垃圾回收了。

	- 标量替换

6. 通过 jps 查看 java pid


7. spring boot 2 `logging.register-shutdown-hook`
	
	- sl4j2 logback
	- 为了避免在这种情况下中断工作线程，可以将关闭钩子插入JVM运行时，以在启动JVM关闭后正确停止LoggerContext。
	- https://stackoverflow.com/questions/45693107/define-logback-shutdown-hook-in-spring-boot/45693867

8. `logging.file.max-history` not work

	- https://github.com/spring-projects/spring-boot/issues/12596

## 2019.10.10

1. jdk 13 新特性

	- Dynamic CDS Archives
		- 核心类在 jvm 间共享
	- ZGC: Uncommit Unused Memory
		- 向 os 返还 未使用内存
	- Reimplement the Legacy Socket API
	- Switch Expressions (Preview)
		- 引入 yield
	- Text Blocks (Preview)
		- 可以使用 `""" text content """`, `"""` 包裹文本
	- https://docs.oracle.com/en/java/javase/13/migrate/index.html#JSMIG-GUID-4B3D2D73-359C-4ADA-937E-BAEA79CFDF0F

2. 人们常常认为他们站在了潮头, 就掌控了整个潮流, 但他们也只不过是被潮流推着前进罢了

3. java 中的局部变量在哪里分配的?

	- 基本数据类型/局部对象的引用 -> stack frame 栈帧上

4. 对象一般会分配在堆上
	
	- 对象和对象引用是一个东西么?
		- no no no
	1. 首先需要注意的是对象和对象引用是不同的东西
		- Note: Object and Object references are different things.
	2. 使用 new 关键字产生的对象, 都是放在 heap 中的
	3. 所有
		- All the class variable primitive or object references (which is just a pointer to location where object is stored i.e. heap) are also stored in heap. (todo: 存疑)
	4. 类, 静态变量, 静态对象引用都会存在 matespace (java8之后)
		- Classes loaded by classloader and static variables and static object references are stored in a special location in heap which permanent generation.
		- 这句话有点问题, 实际上永生代属于非堆区域
		- todo: 存疑
		- https://stackoverflow.com/questions/41358895/permgen-is-part-of-heap-or-not
	5. 局部基本数据类型, 局部对象引用, 方法参数 存在栈(栈帧)中
	6. 局部函数(方法)存在栈中, 静态函数(方法)存在 metaspace 中
		- todo: 存疑
		- Local Functions (methods) are stored in stack but Static functions(methods) goes in permanent storage.
	7. 类信息 -> metaspace
		- All the information related to a class like name of the class, Object arrays asscociated with the class, internal objects used by JVM (like java/lang/Object) and optimization information goes into the Permanent Generation area.
		- todo: 存疑
	- https://stackoverflow.com/questions/13624462/where-does-class-object-reference-variable-get-stored-in-java-in-heap-or-stac/44153495#44153495


5. java 新建对象有哪几种方式

6. java 值传递和引用传递

7. permGen 和 metaspace 的区别

	1. metaspace 的大小的自动增长, 而 permGen 不会
		- Metaspace by default auto increases its size while PermGen always has a fixed maximum size
	2. metaspace 能够 load/unload类(gc), 而 permGen 不能 unload
	3. 他们都会造成 Classloader leaks
		- MetaSpace is based on native memory, so you know...
	- https://stackoverflow.com/questions/27131165/what-is-the-difference-between-permgen-and-metaspace
	- metaspace gc
		- https://stackoverflow.com/questions/24074164/what-is-the-use-of-metaspace-in-java-8


8. 方法内联

	- 在 JIT 编译过程中遇到方法调用时，将目标方法的方法体纳入编译范围之中，并取代原方法调用的优化手段。

9. Classloader leaks 类加载器泄漏 举例

10. python/golang 的 gc 是如何完成的?

	- todo

11. java @HotSpotIntrinsicCandidate

	- 通过本地 cpu 指令优化执行速度

12. JIT 编译器  字段访问相关优化

	- 字段缓存
	- 存储优化, 去冗余
	- 死代码消除

13. java 多级包名编译运行

	- `javac -d . xxxx.java`
	- https://blog.csdn.net/u011035397/article/details/101941977

14. jnaerator  

	- 错误 `Bad token [Invalid65533@1,1]:"TOK65533"`

15. jna 大法好 =.=

16. Compressed Ordinary Object Pointers (oops)

	- Java SE 6u23和更高版本默认情况下支持并启用压缩的oops。在Java SE 7中，-Xmx未指定时，对于64位JVM进程以及-Xmx小于32 GB的值， 默认使用压缩的oop 

17. invokedynamic 
	
	- 反射和 methodHandle 有什么区别?
		- reflection 和 methodHandle 都是在模拟方法的调用
		- 反射模拟的是 java 代码层面的方法调用
		- methodHandle 模拟的是 字节码层面的方法调用 -> 为 jvm 上的所有语言服务
		- 深入理解 jvm P263
	- 问题: 如何访问 grandFather 的方法
		- 深入理解 jvm P268


18. MethodHandles.lookup().findSpecial 

	- 在 jdk 1.7 和 1.8 的表现实现不一致
		- https://blog.csdn.net/weixin_34252686/article/details/91657059
	- findSpecial()得到的MethodHandle的具体语义在JSR 292的设计过程中有被调整过。
		- 只能找到父类
		- https://www.zhihu.com/question/40427344

19. Why is super.super.method(); not allowed in Java?
	
	- 它违反了封装。您不应该能够绕过父类的行为。
	- https://stackoverflow.com/questions/586363/why-is-super-super-method-not-allowed-in-java


## 2019.10.11


1. vs studio 生成 dll 和 lib

	- 属性->链接器->输入->模块定义文件
	- source.def 

```def
LIBRARY JNA
EXPORTS 
	max @1
```

2. vs studio format 格式化代码

	- `ctrl+K`  -> `ctrl+F`

3. 如何处理过期订单

	- todo

4. jna invalid memory access

	1. 传参为 null 导致的?
	2. 检查 type mapping
		- https://stackoverflow.com/questions/38057959/jna-exception-in-thread-main-java-lang-error-invalid-memory-accessunknown-so

5. jna 中 `int arr[10];` 与 `int* arr` 所映射的java对象不同

	- https://stackoverflow.com/questions/7598685/jna-arrays-and-pointer
	- 使用 pointer 来表示 float array
		- https://stackoverflow.com/questions/24092495/passing-array-from-java-to-dll-function-with-jna

6. java 数组可能不连续?


## 2019.10.12

1. 我竟然在java中遇到了值传递和引用传递的问题?

	- https://java-native-access.github.io/jna/5.3.0/javadoc/overview-summary.html
	- https://www.zhihu.com/question/31203609/answer/576030121
	- 值传递（pass by value）是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。
	- 引用传递（pass by reference）是指在调用函数时将实际参数的地址直接传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。

2. InputStream -> byteArray 字节数组

```java
InputStream is;
// apache commons io
byte[] bytes = IOUtils.toByteArray(is);
```

3. HotSpot不支持在栈上新建对象。 C2里的逃逸分析是静态分析，和TLAB没什么关系。它和标量替换一起使用，能够完全不分配对象，仅在寄存器中维护这个对象的字段。

	- https://time.geekbang.org/column/article/13137 评论

## 2019.10.14

1. CMS GC 的7个阶段
	- https://www.iteye.com/blog/zhanjia-2435266

2. jvm 基础面试

	- https://www.zhihu.com/question/35164211

3. linux java 进程被 killed
	
	- 建立swap区
	- https://stackoverflow.com/questions/37071106/spring-boot-application-quits-unexpectedly-with-killed

## 2019.10.15

1. 手动System.gc()与JVM自动gc有什么根本上的区别么？

	- https://www.iteye.com/blog/rednaxelafx-1042471

2. java 8 default method 与 强制转换

	- https://www.iteye.com/blog/rednaxelafx-2033089

```java
interface IFoo {  
  default void bar(int i) {  
    System.out.println("IFoo.bar(int)");  
  }  
}  
  
public class Foo implements IFoo {  
  public static void main(String[] args) {  
    Foo foo = new Foo();  
    foo.bar(42);  // (1) invokevirtual Foo.bar(int)void  
  
    IFoo ifoo = foo;  
    ifoo.bar(42); // (2) invokeinterface IFoo.bar(int)void  
  }  
  
  public void bar(long l) {  
    System.out.println("Foo.bar(long)");  
  }  
}  
```

3. java 8 使用接口来做静态工具类

	- https://www.iteye.com/blog/rednaxelafx-2033104

4. JVM 异常退出日志

	- 深入分析 java web 技术内幕 P230
	- EXCEPTION_ACCESS_VIOLATION
	- SIGSEGV 
		- JNI 
	- EXCEPTION_STACK_OVERFLOW


5. 热点分析工具分析当前系统执行的热点代码

	- Oprofiler

6. 请教下，识jvm堆栈中一个数据类型是否为为引用类型，目前虚拟机实现中是如何做的？

	- https://www.iteye.com/blog/rednaxelafx-1044951

7. hotspot

	- 在特定位置记录下 OopMap
		- OopMap 与 gc 的关系? 
	- https://www.iteye.com/blog/rednaxelafx-1044951
	- JNI 使用句柄表
		- 但这也就意味着调用JNI方法会有句柄的包装/拆包装的开销，是导致JNI方法的调用比较慢的原因之一。

8. 高级语言虚拟机 

	- https://hllvm-group.iteye.com/

9. 为啥别读 hotspot vm 源码
	
	- https://www.slideshare.net/RednaxelaFX/hotspot-vm20120303

10. 新建对象

	- 在 Java 程序中，我们拥有多种新建对象的方式。除了最为常见的 new 语句之外，我们还可以通过反射机制、Object.clone 方法、反序列化以及 Unsafe.allocateInstance 方法来新建对象。
	- new
	- 反射
	- Object.clone
	- 反序列化
	- Unsafe.allocateInstance 

11. 反射性能优化
	
	- https://www.iteye.com/blog/rednaxelafx-548536
	- java6, native版的反射调用则无法被有效内联，因而调用开销无法随程序的运行而降低。 
	- 相比之下JDK 7里新的MethodHandle则更有潜力，在其功能完全实现后能达到比普通反射调用方法更高的性能。


## 2019.10.16

1. Java8的DateTimeFormatter是线程安全的，而SimpleDateFormat并不是线程安全。

	- https://blog.csdn.net/fragrant_no1/article/details/83991685
	- 使用 threadLocal 解决 simpleDateFormat 的线程安全问题

2. ConcurrentSkipListMap ConcurrentHashMap

3. `void getBool(boolean x);`

	- `x` 为 true 时, 输出 255
	- https://stackoverflow.com/questions/55225896/jna-maps-java-boolean-to-1-integer

4. debug jni with visual stduio

	- 

## 2019.10.17

1. visual studio 2019 + idea jni debug

	- idea
		- 启动 java 程序
		- 执行到断点
	- cmd
		- jps 找到 java 进程 pid
	- visual studio
		- `ctrl + alt + P` 调出 `附加到进程` 窗口  
		- 指定 java 进程 pid
2. 工作须知

	- 社会保险缴纳基数 
		- 最低缴纳基数 杭州 3321
	- 社保缴费比例 18.5%
	- 公积金基数 
	- 公积金缴存比例 5% -12%

3. todo:
	- 查询社保缴纳基数
	- 查询公积金缴纳基数
	- 住房公积金管理条例
		- https://duxiaofa.baidu.com/detail?searchType=statute&from=aladdin_28231&originquery=%E4%BD%8F%E6%88%BF%E5%85%AC%E7%A7%AF%E9%87%91%E7%AE%A1%E7%90%86%E6%9D%A1%E4%BE%8B2019&count=47&cid=acca82ae0f06858211e5d6505941bdec_law

4. java

	- 1. java 代码是怎么样运行的
	- 为什么java要在虚拟机里运行
		- java 作为一门高级程序语言, 它的语法比较复杂, 抽象程度高, 在硬件上直接运行并不现实
		- write once , run everywhere
			- 可移植性
		- 提供托管环境, 帮我们处理复杂的内存逻辑
			- 垃圾回收, 内存管理; 数组越界/动态类型/安全权限的检查 
	- jvm 怎么样运行 字节码的
		- java 代码 -> class 字节码
		- 加载, 链接, 初始化 -> 方法区
		- 实际运行时，虚拟机会执行方法区内的代码。
			1. 解释执行, 逐条解释翻译成机器码
			2. jit 即时编译, 编译成机器码后执行 
	- java 的运行效率
		- 理论上讲，即时编译后的 Java 程序的执行效率，是可能超过 C++ 程序的。这是因为与静态编译相比，即时编译拥有程序的运行时信息，并且能够根据这个信息做出相应的优化。
		- 为了提高运行效率，标准 JDK 中的 HotSpot 虚拟机采用的是一种混合执行的策略。它会解释执行 Java 字节码，然后会将其中反复执行的热点代码，以方法为单位进行即时编译，翻译成机器码后直接运行在底层硬件之上。
	- 2. 基本数据类型
	- 在 Java 虚拟机规范中，boolean 类型则被映射成 int 类型


5. 虚方法是用来实现面向对象语言多态性的。对于一个虚方法调用，尽管它有很多个目标方法，但在实际运行过程中它可能只调用其中的一个。

	- 这个信息便可以被即时编译器所利用，来规避虚方法调用的开销，从而达到比静态编译的 C++ 程序更高的性能。

6. hotspot vm 内置的 jit compiler

	- C1,C2,Graal(java 10引入)

7. 栈计算

	- Java 虚拟机的算数运算几乎全部依赖于操作数栈。也就是说，我们需要将堆中的 boolean、byte、char 以及 short 加载到操作数栈上，而后将栈上的值当成 int 类型来运算。
	- 主要是变长数组不好控制，所以就选择浪费一些空间，以便访问时直接通过下标来计算地址。
	- 比如 一个 boolean 放在 栈上用于计算时会被映射成 int(4个字节), 但是放到 堆中只有 1 个字节 

8. unsafe 

	- https://stackoverflow.com/questions/13003871/how-do-i-get-the-instance-of-sun-misc-unsafe

```java
Field f =Unsafe.class.getDeclaredField("theUnsafe");
f.setAccessible(true);
unsafe = (Unsafe) f.get(null);
```

9. jvm 中 对象 会按照字(32位/64位)对齐
	
	- 所以在 64 位的系统上, 对象都是 8字节的倍数
	- 对齐后最小的 java 对象是 16字节,因为该对象具有12个字节的标头，并填充为8个字节的倍数。
	- 当我们将int原始类型（仅消耗4个字节）与 需要16个字节的Integer对象
	- `ObjectSizeCalculator.getObjectSize`
	- https://www.baeldung.com/java-size-of-object
	- https://stackoverflow.com/questions/52353/in-java-what-is-the-best-way-to-determine-the-size-of-an-object
	- 源代码
		- http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/markOop.hpp

```
32 bits:
--------
hash:25 ------------>| age:4    biased_lock:1 lock:2 (normal object)
JavaThread*:23 epoch:2 age:4    biased_lock:1 lock:2 (biased object)
size:32 ------------------------------------------>| (CMS free block)
PromotedObject*:29 ---------->| promo_bits:3 ----->| (CMS promoted object)

64 bits:
--------
unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2 (normal object)
JavaThread*:54 epoch:2 unused:1   age:4    biased_lock:1 lock:2 (biased object)
PromotedObject*:61 --------------------->| promo_bits:3 ----->| (CMS promoted object)
size:64 ----------------------------------------------------->| (CMS free block)

unused:25 hash:31 -->| cms_free:1 age:4    biased_lock:1 lock:2 (COOPs && normal object)
JavaThread*:54 epoch:2 cms_free:1 age:4    biased_lock:1 lock:2 (COOPs && biased object)
narrowOop:32 unused:24 cms_free:1 unused:4 promo_bits:3 ----->| (COOPs && CMS promoted object)
unused:21 size:35 -->| cms_free:1 unused:7 ------------------>| (COOPs && CMS free block)
```

10. java 对象头
	- 在 64位 vm上 (hotspot)
	- 对象头 = 标记信息(mark word 64位) + class 指针信息(一般来讲是一个字长也就是 64位)
	- `-XX:+UseCompressedOops`
	- https://stackoverflow.com/questions/26357186/what-is-in-java-object-header

11. "oop" stands for ordinary object pointer

## 2019.10.18

1. 将其他变量重新赋值到本地变量

	- ```.copying to locals produces the smallest bytecode, and for low-level code it's nice to write code that's a little closer to the machine```
	- https://stackoverflow.com/questions/2785964/in-arrayblockingqueue-why-copy-final-member-field-into-local-final-variable

2. springboot nio 的线程数为 10 

	- 似乎是循环调用每个线程

3. xmx, xss, xmn

	- xmx 最大堆
	- xss 设置线程堆栈大小
	- xmn young generation size

4. `-XX:+NewRatio`

	- NewRatio是老一代与年轻一代的比率（例如，值2表示老一代的最大大小将是年轻一代的最大大小的两倍，即，年轻一代最多可以得到堆的1/3）。


5. `UseAdaptiveSizePolicy` 导致 S0C,S1C, EC 变化

	- `-Xmx1024m -Xms1024m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:NewRatio=1 -XX:+HeapDumpOnOutOfMemoryError -XX:MetaspaceSize=96M`

6. java 虚拟机规范

	- https://docs.oracle.com/javase/specs/index.html



## 2019.10.20

1. 为什么minor gc比full gc/major gc快？

	- 如果把mark、sweep、compact、copying这几种动作的耗时放在一起看，大致有这样的关系：
	- compaction >= copying > marking > sweeping
	- 还有 marking + sweeping > copying
	- 在分代式假设中，年轻代中的对象在minor GC时的存活率应该很低，这样用copying算法就是最合算的，因为其时间开销与活对象的大小成正比，如果没多少活对象，它就非常快
	- https://www.zhihu.com/question/35172533
	- https://hllvm-group.iteye.com/group/topic/38223#post-248757
		- 把GC之外的代码（主要是应用程序的逻辑）叫做mutator，把GC的代码叫做collector。
		- 如果有一个分代式的，或者增量式的collector，那它在工作的时候就只会观察到整个对象图的一部分；它观察不到的部分就有可能与mutator产生不一致，于是需要mutator配合：它与mutator之间需要额外的同步。Mutator在改变对象图中的引用关系时必须执行一些额外代码，让collector记录下这些变化。有两种做法，一种是 write barrier，一种是 read barrier。
		- mark-sweep：mark阶段与活对象的数量成正比，sweep阶段与整堆大小成正比
		- mark-compact：mark阶段与活对象的数量成正比，compact阶段与活对象的大小成正比
		- copying：与活对象大小成正比

2. young gc 的过程

	- 什么时候进行 copying 的?

3. java 8 hotspot metaspace 达到什么条件会触发 full gc 

4. google V8 引擎用的也是 mark-compact

5. 并发垃圾收集器（CMS）为什么没有采用标记整理-算法来实现，而是采用的标记-清除算法？

	- CMS没有使用read barrier，只用了write barrier。这样，如果它要选用mark-compact为基本算法的话，就只有mark阶段可以并发执行（其中root scanning阶段仍然需要暂停mutator，这是initial marking；后面的concurrent marking才可以跟mutator并发执行），然后整个compact阶段都要暂停mutator。回想最初提到的：compact阶段的时间开销与活对象的大小成正比，这对年老代来说就不划算了。
	- R大完美解答 
		- https://hllvm-group.iteye.com/group/topic/38223#post-248757
		- 现实中我们仍然可以看到以mark-compact为基础算法的增量式/并发式年老代GC。例如Google V8里的年老代GC就可以把marking阶段拆分为非并发的initial marking和增量式的incremental marking；但真正比较耗时的compact阶段仍然需要完全暂停mutator。它要降低暂停时间就只能想办法在年老代内进一步选择其中一部分来做compaction，而不是整个年老代一口气做compaction。这在V8里也已经有实现，叫做incremental compaction。再继续朝这方向发展的话最终会变成region-based collector，那就跟G1类似了。

6. cms 论文

	- `A Generational Mostly-concurrent Garbage Collector` By `Tony Printezis and David Detlefs`
	- http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.22.8915
	- pdf下载
		- https://sites.cs.ucsb.edu/~ckrintz/racelab/gc/papers/detlefs-generational.pdf

7. 高级语言虚拟机 论坛

	- https://hllvm-group.iteye.com/

8. HotSpot除了CMS和G1之外的GC所用的write barrier的思路源自Urs Hölzle的论文： A Fast Write Barrier for Generational Garbage Collectors。除了card size不同之外，实现细节跟当时在Self VM上用的一模一样。

	- http://hoelzle.org/publications/write-barrier.pdf
	- https://hllvm-group.iteye.com/group/topic/41086?page=4

## 2019.10.21

1. jps 命令

	- jps [-q] [-mlvV] [<hostid>]
	- `-q`：只输出进程 ID
	- `-m`：输出传入 main 方法的参数
	- `-l`：输出完全的包名，应用主类名，jar的完全路径名
	- `-v`：输出jvm参数
	- `-V`：输出通过flag文件传递到JVM中的参数
	- 获取远程服务器 jps 信息
		- 需要启动 启动 jstatd 服务器
		- https://www.jianshu.com/p/d39b2e208e72

2. vs2019 当前不会命中断点还未为文档加载任何符号

3. RSet记录了其他Region中的对象引用本Region中对象的关系，属于points-into结构（谁引用了我的对象）。而Card Table则是一种points-out（我引用了谁的对象）的结构，每个Card 覆盖一定范围的Heap（一般为512Bytes）。

	- G1的RSet是在Card Table的基础上实现的：每个Region会记录下别的Region有指向自己的指针，并标记这些指针分别在哪些Card的范围内。 这个RSet其实是一个Hash Table，Key是别的Region的起始地址，Value是一个集合，里面的元素是Card Table的Index。每个Region都有一个对应的Rset。
	- https://zhuanlan.zhihu.com/p/52841787

4. method signature 是什么

5. jconsole - VM 概要 可以做什么

	- 查看 垃圾收集器 种类 
		- 例如:
			- 垃圾收集器: 名称 = 'PS MarkSweep', 收集 = 2, 总花费时间 = 0.073 秒
			- 垃圾收集器: 名称 = 'PS Scavenge', 收集 = 6, 总花费时间 = 0.085 秒
	- 查看 metaspace 卸载类的数量
	- JIT 编译器的名称, 编译时间

6. java native memory track

	1. add `-XX:NativeMemoryTracking=summary` to VM options
	2. `jcmd <PID> VM.native_memory`
	- https://stackoverflow.com/questions/2756798/java-native-memory-usage

7. navtive memory track 
	
	- 启用NMT将导致JVM性能下降5-10％，并且NMT的内存使用量将2个机器字作为malloc标头添加到所有malloc内存中。NMT还会跟踪NMT内存使用情况。

	- https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr007.html

8. Are native Java methods equivalent to static Java methods?

	- java 本地方法是否等同于 静态方法
	- https://stackoverflow.com/questions/15253914/are-native-java-methods-equivalent-to-static-java-methods
	- 是否需要在 静态本地方法中传入 class 类型
		- 如果您的静态java方法引用任何其他静态成员，则您的JVM将需要有效的类指针。 
		- https://stackoverflow.com/questions/29831703/jni-invoking-static-methods-is-the-class-object-necessary

9. Initializing Servlet 'dispatcherServlet'

	- 延迟加载

## 2019.10.22

1. 使用 服务器打游戏

	- 好像没啥用, 要用显卡的

2. 在 win10 上用 vs 2013 编译的 dll 在 windows server 2012 上无法运行

	- 在 windows server 2012 上使用 vs 2019 编译成功, 然后运行 ok
	- 具体原因不了解, 查看了 dll 依赖表, 检查了 windows server 2012 目录, 发现 dll 均存在, 但无法运行
	- 但是反过来, 2012 上编译的, 可以再 win10上使用


3. java classpath的作用

	- `.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar`


4. 使用JNI技术，不仅可以实现Java访问C函数，也可以实现C语言调用Java代码。 而JNA只能实现Java访问C函数，作为一个Java框架，自然不能实现C语言调用Java代码。此时，你还是需要使用JNI技术。

5. 如何 ignore 已经 push 的文件

	- https://stackoverflow.com/questions/1139762/ignore-files-that-have-already-been-committed-to-a-git-repository

## 2019.10.24


1. file batch write 文件批量写

	- 内存映射文件?

2. 如何提升大量小文件的写效率

	- 将多文件转为单个大文件
	- 大文件使用批量顺序写,提升效率

3. 文件写性能测试

	- https://blog.csdn.net/yiifaa/article/details/78128363

4. golang 常用 

	- int to string `strconv.Itoa`
	- byte[] to string/json 
		- `err = json.Unmarshal(body, &httpRes)`
	- `date :=time.Now().Format("20060102150405")`


5. golang 包管理工具 glide https://glide.sh/

	- 使用 12.3 版本
		- 在 win10 上 13.3 版本会出错

6. 阿里云 api 调试

	- https://api.aliyun.com

7. go 应用程序部署

```Dockerfile
FROM alpine:latest 
#元镜像，使用了镜像大小体积只有5MB的alpine镜像
WORKDIR / 
#设置程序在容器内的工作路径
ADD  app /
ENTRYPOINT ["./app"]
```


## 2019.10.25

1. 在一个 springboot jar 中, 启动非默认 main 方法

	- `java -cp aolang-1.0.0.jar -Dloader.main=me.giraffetree.xxx.xxx org.springframework.boot.loader.PropertiesLauncher`
		- https://www.baeldung.com/spring-boot-main-class
		- https://stackoverflow.com/questions/50367647/run-non-main-class-of-spring-boot-application-through-command-line

2. 自己在整 dll 兼容性的时候想到 jdk 中很多 dll

	- 这不是要麻烦死...全是兼容问题
	- windows server 2012 上java 调用 dll失败 
		- 装一个 vc 运行库
		- https://support.microsoft.com/en-us/help/2977003/the-latest-supported-visual-c-downloads
	- 工具
		- depends walker

3. mysql 强制使用 tcp 通讯, 而不是使用 socket

	- https://serverfault.com/questions/337818/how-to-force-mysql-to-connect-by-tcp-instead-of-a-unix-socket
	- `mysql --protocol=TCP -u root -p`

## 2019.10.28


1. dll 和 lib 的区别

	- lib是一个二进制文件，与dll类似，供其他程序调用。lib与dll的区别是：dll是运行时需要的，lib是编译时需要的。
	- 共有两种库：
	　　- 一种是LIB包含了函数所在的DLL文件和文件中函数位置的信息（入口），代码由运行时加载在进程空间中的DLL提供，称为动态链接 库dynamic link library。
	　　- 一种是LIB包含函数代码本身，在编译时直接将代码加入程序当中，称为静态链接库static link library。
	- 共有两种链接方式
	　　- 动态链接使用动态链接库，允许可执行模块（.dll文件或.exe文件）仅包含在运行时定 位DLL函数的可执行代码所需的信息。
	　　- 静态链接使用静态链接库，链接器从静态链接库LIB获取所有被引用函数，并将库同代码一起放到可执行文件 中。

2. chrome 恐龙游戏

	- chrome://dino

3. gc 中的 evacuated (copied/moved)

4. g1gc log 解读

	- https://www.jianshu.com/p/5d4e319582f7
	- https://www.redhat.com/en/blog/collecting-and-reading-g1-garbage-collector-logs-part-2#

5. gc log 可视化

	- https://github.com/HubSpot/gc_log_visualizer

6. SATB Snapshot-at-the-beginning 
	
	- mark的过程就是遍历heap标记live object，采用的是三色标记算法，这三种颜色为white(表示还未访问到)、gray(访问到但是它用到的引用还没有完全扫描)、black(访问到而且其用到的引用已经完全扫描完)，整个三色标记算法就是从GC roots出发遍历heap，针对可达对象先标记white为gray，然后再标记gray为black；遍历完成之后所有可达对象都是black的，所有white都是可以回收的
	- https://juejin.im/post/5c95b78df265da60e21bfeda

7. [HotSpot VM]关于增量更新与SATB的一点理解
	
	- 
	- https://hllvm-group.iteye.com/group/topic/44529

8. 中村成洋 徹底解剖「G1GC」 アルゴリズム編

	- https://github.com/authorNari/g1gc-impl-book
	- http://www.narihiro.info/g1gc-impl-book/
	- openjdk7 下载
		- https://blog.csdn.net/qq_23091073/article/details/83178848
	- 编译帮助文档
		- http://hg.openjdk.java.net/jdk7/jdk7/raw-file/tip/README-builds.html

9. `-XX:+TraceClassLoading` 可以看到类加载过程


10. java 多态性

	- 桥接方法实现多态
		- https://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html
		- https://blog.csdn.net/jiaobuchong/article/details/83722193


## 2019.10.30

1. serializable
	
	- 允许实现readObject和writeObject方法来覆盖java中的默认序列
	- https://www.hollischuang.com/archives/1140

2. hollis java 文章

	- https://www.hollischuang.com/archives/category/java

3. 异步异常
	
	- jvm specification
		- https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html#jvms-2.10
	- how to cause async exception
		- https://stackoverflow.com/questions/51375732/synchronous-and-asynchronous-exceptions-in-java

4. 反编译出来的什么鬼....

```java
public class ThrowTest {
    public int test() {
        try {
            return 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } finally {
            int a = 10000;
        }
    }
}
// 反编译出来的...
public class ThrowTest {
    public ThrowTest() {
    }

    public int test() {
        boolean var7 = false;

        byte var1;
        try {
            var7 = true;
            var1 = 0;
            var7 = false;
        } catch (ArrayIndexOutOfBoundsException var8) {
            throw var8;
        } finally {
            if (var7) {
                boolean var4 = true;
            }
        }

        boolean var2 = true;
        return var1;
    }
}
// javap -v xxx
public int test();
descriptor: ()I
flags: ACC_PUBLIC
Code:
  stack=1, locals=5, args_size=1
     0: iconst_0
     1: istore_1
     2: sipush        10000
     5: istore_2
     6: iload_1
     7: ireturn
     8: astore_1
     9: aload_1
    10: athrow
    11: astore_3
    12: sipush        10000
    15: istore        4
    17: aload_3
    18: athrow
  Exception table:
     from    to  target type
         0     2     8   Class java/lang/ArrayIndexOutOfBoundsException
         0     2    11   any
         8    12    11   any
  LineNumberTable:
    line 11: 0
    line 15: 2
    line 11: 6
    line 12: 8
    line 13: 9
    line 15: 11
    line 16: 17
  LocalVariableTable:
    Start  Length  Slot  Name   Signature
        9       2     1     e   Ljava/lang/ArrayIndexOutOfBoundsException;
        0      19     0  this   Lme/giraffetree/playg1/exception/ThrowTest;
  StackMapTable: number_of_entries = 2
    frame_type = 72 /* same_locals_1_stack_item */
      stack = [ class java/lang/ArrayIndexOutOfBoundsException ]
    frame_type = 66 /* same_locals_1_stack_item */
      stack = [ class java/lang/Throwable ]



```

5. 如果finally有return语句，catch内throw的异常会被忽略，这个从jvm层面怎么解释呢？

	- return

6. 栈轨迹 跟 弹出方法栈帧 是两个概念。你可以直接新建一个异常，然后不抛出，直接打印调用栈。这个时候是不会弹出当前栈帧的。


7. 事务传播行为

	- Propagation.REQUIRED
		- 代表当前方法支持当前的事务，且与调用者处于同一事务上下文中，回滚统一回滚（如果当前方法是被其他方法调用的时候，且调用者本身即有事务），如果没有事务，则自己新建事务，
	- Propagation.SUPPORTS
		- 代表当前方法支持当前的事务，且与调用者处于同一事务上下文中，回滚统一回滚（如果当前方法是被其他方法调用的时候，且调用者本身即有事务），如果没有事务，则该方法在非事务的上下文中执行
	- Propagation.MANDATORY
		- 代表当前方法支持当前的事务，且与调用者处于同一事务上下文中，回滚统一回滚（如果当前方法是被其他方法调用的时候，且调用者本身即有事务）,如果没有事务，则抛出异常
	- Propagation.REQUIRES_NEW
		- 创建一个新的事务上下文，如果当前方法的调用者已经有了事务，则挂起调用者的事务，这两个事务不处于同一上下文，如果各自发生异常，各自回滚
	- Propagation.NOT_SUPPORTED
		- 该方法以非事务的状态执行，如果调用该方法的调用者有事务则先挂起调用者的事务
	- Propagation.NEVER
		- 该方法以非事务的状态执行，如果调用者存在事务，则抛出异常
	- Propagation.NESTED
		- 如果当前上下文中存在事务，则以嵌套事务执行该方法，也就说，这部分方法是外部方法的一部分，调用者回滚，则该方法回滚，但如果该方法自己发生异常，则自己回滚，不会影响外部事务，如果不存在事务，则与PROPAGATION_REQUIRED一样
	- https://www.cnblogs.com/ll409546297/p/11076258.html
	- 代码验证
		 -https://juejin.im/entry/5a8fe57e5188255de201062b

8. try-with-resources
	
	- addSuppressed 避免原异常消失的问题
	- https://www.cnblogs.com/langtianya/p/5139465.html


9. 理解注解中的@Inherited

	- 如果一个子类想获取到父类上的注解信息，那么必须在父类上使用的注解上面 加上@Inherit关键字
	- https://www.iteye.com/blog/latty-2371766

10. springboot + spring security + oauth2.0

	- oauth 流程
		- http://www.ruanyifeng.com/blog/2019/04/oauth_design.html
	- 思维导图
		- https://www.processon.com/view/link/5db9367ee4b0e433945466da
	- spring boot oauth
		- https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/htmlsingle/#do-i-need-to-stand-up-my-own-authorization-server
	- spring security
		- https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#core-services-password-encoding


## 2019.10.31

1. java 反射全链路解析
	- 包含java和c++部分
	- https://www.jianshu.com/p/b6cb4c694951

2. 获取数组 class

	- `Test[].class`

3. 反射调用 R 大回答

	- https://www.iteye.com/blog/rednaxelafx-548536

4. native 代码消耗比 java 代码消耗大

	- 这是HotSpot的优化方式带来的性能特性，同时也是许多虚拟机的共同点：跨越native边界会对优化有阻碍作用，它就像个黑箱一样让虚拟机难以分析也将其内联，于是运行时间长了之后反而是托管版本的代码更快些。

5. typeProfile
	
	- optimizing compiler to guess at future types at the same point in the program.
	- https://wiki.openjdk.java.net/display/HotSpot/TypeProfile

6. 百度搜索资源平台

	- https://ziyuan.baidu.com/dashboard/index

7. sitemap 生成

	- https://www.xml-sitemaps.com/

8. 最常用的分布式 dns

9. google 规范网址
	- nginx 增加 header 
	- https://support.google.com/webmasters/answer/139066?hl=zh-Hans
	- jekyll url 中指定

## 2019.11.1

1. 为 每个 invokevirual 记录一个 type profile 

	- https://stackoverflow.com/questions/21679998/does-it-matter-for-runtime-performance-if-a-method-is-called-by-its-explicit-typ

2. openjdk11  `-XX:+PrintGCDateStamps` 无效

	- `-Xlog:gc*:/opt/myapp/gc.log:time`

3. java 视频

	- bilibili 做 java gc 视频

4. 内联规则

	- 即时编译器不会无限制地进行方法内联。下面我便列举即时编译器的部分内联规则。（其他的特殊规则，如自动拆箱总会被内联、Throwable 类的方法不能被其他类中的方法所内联，你可以直接参考JDK 的源代码。）
		- http://hg.openjdk.java.net/jdk/jdk/file/da387726a4f5/src/hotspot/share/opto/bytecodeInfo.cpp#l197
	- 内联详解
		- 包含内联信息来自哪里
		- https://wiki.openjdk.java.net/display/HotSpot/Server+Compiler+Inlining+Messages
	- `-XX:+PrintInlining`
	- `-XX:+PrintGC -Dsun.reflect.noInflation=true  -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining`

5. C2 编译器 

	- C2 IR Graph and Nodes
		- https://wiki.openjdk.java.net/display/HotSpot/C2+IR+Graph+and+Nodes
	- `PrintIdeal`
		- Error: VM option 'PrintIdeal' is notproduct and is available only in debug version of VM.

6. CallerSensitive
	
	- 调用方敏感方法根据其直接调用方的类来改变其行为。它通过调用该sun.reflect.Reflection.getCallerClass方法来发现其调用者的类。
	- 为了堵住漏洞用的。曾经有黑客通过构造双重反射来提升权限
		- https://stackoverflow.com/questions/22626808/what-does-the-sun-reflect-callersensitive-annotation-mean
		- https://www.jianshu.com/p/aec1745196d8

7. 远程连接工具

	- teamviewer
	- xshell
	- xftp

8. Method 类中有个 isBridge 方法

	- true if and only if this method is a bridge method as defined by the Java Language Specification.
	- `public boolean isBridge() {return (getModifiers() & Modifier.BRIDGE) != 0;}`


9. java 实例化对象

	- new
	- 反射 newInstance
	- clone
		- jvm 内部实现, 并不会调用构造器, 直接复制byte数组
		- https://www.zhihu.com/question/63667745/answer/224396818
	- 序列化/反序列化
	- 参考
		- https://stackoverflow.com/questions/3707612/cloning-vs-instantiating-a-new-class
		- 

10. apache commons

	- 深克隆/拷贝（deep clone/copy）： SerializationUtils
	- 浅克隆/拷贝（shallow clone/copy）：BeanUtils


11. jvm 中的 array 是怎么实现的?

12. 通过复制 构造函数代替 clone
	- ```public Person(Person original) {
    this.id = original.id + 1;
    this.name = new String(original.name);
    this.city = new City(original.city);
}```
	- https://dzone.com/articles/java-cloning-copy-constructor-vs-cloning
	- 优势
		- 不需要实现接口/抛出异常
		- 不需要类型转换
		- 可以修改 final 字段
		- 可以加入初始化逻辑
		- 不需要父类做任何事情

13. 柯里化

	- 柯里化（英語：Currying），又译为卡瑞化或加里化，是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，并且返回接受余下的参数而且返回结果的新函数的技术。

## 2109.11.2

1. openjdk7

	- 下载
		- gitee.com 下载 openjdk7 压缩包

## 2019.11.4

1. openjdk win build

	- https://github.com/ojdkbuild/ojdkbuild


## 2019.11.5

1. 人的皮肤需要呼吸么
	
	- 可以

2. jsr 292 invokedynamic

	- https://www.zhihu.com/question/40427344

3. java 实现 柯里化

	- MethodHandle.bindTo

4. invokeExact, invoke, invokeWithArguments

	- https://stackoverflow.com/questions/16005824/some-basic-questions-about-methodhandle-api


5. 使用 methodHandle 的步骤
	- Creating the lookup
		- 创建提供对公共方法的访问的查找
			- `MethodHandles.Lookup publicLookup = MethodHandles.publicLookup()`;
		- 还可以访问私有/protected 方法
			- MethodHandles.Lookup publicLookup = MethodHandles.lookup();
	- Creating the method type
	- Finding the method handle
	- Invoking the method handle
	- https://www.baeldung.com/java-method-handles


6. methodHandle 和 classloader

7. 面向对象编程
 
	- 柯里化 currying 咖喱化hah
	- 抽象了类似行为的方法(函数)
	- 我们就写一个类，但是通过构造函数，把一份代码，构造出了行为稍微有点不同的两个实例供我们使用，这时候名词来了，不能进行实例化微调化的类，叫做静态类，函数们的行为是固定的。不能实例化的类，其实只是函数们的一个集合归纳，只是对函数进行了整理，功能的强大和编码的自由灵活度是不够的。能够进行实例化，变化出各种行为各自不大一样的实例的类，我们一般就把它们叫做类了，因为最常见。
	- https://www.zhihu.com/question/27468564/answer/101951302

8. 阿里面经

	- https://developer.aliyun.com/article/717121?spm=a1z389.11499242.0.0.65452413ilSCX3&utm_content=g_1000084478

9. invokeExact 实现

	- -XX:+ShowHiddenFrames 打印被 Java 虚拟机隐藏了的栈信息时

10. 关闭逃逸分析

	- -XX:-DoEscapeAnalysis


11. shijie 

	- Invokedynamic 和 MethodHandle的缘由
		- https://zhuanlan.zhihu.com/p/26389041
	- JSR292: InvokeDynamic和MethodHandle的优化
		- https://zhuanlan.zhihu.com/p/30936412

12. GPU jvm? 好像有点吊? 

	- 榨干机器硬件性能: JVM＆GPU
	- https://zhuanlan.zhihu.com/p/36284998


## 2019.11.5 晚上

1. 美团 高性能队列 disruptor

	- https://tech.meituan.com/2016/11/18/disruptor.html
	- log4j2 也使用了里面的技术

2. get java object size

	- jol java object layout
		- `ClassLayout.parseInstance(object).toPrintable();`
	- 参考
		- https://stackoverflow.com/questions/52353/in-java-what-is-the-best-way-to-determine-the-size-of-an-object
		- https://shipilev.net/blog/2014/heapdump-is-a-lie/
	- jol samples
		- http://hg.openjdk.java.net/code-tools/jol/file/tip/jol-samples/src/main/java/org/openjdk/jol/samples/
	- `-XX:-UseCompressedOops -XX:-RestrictContended`
	- jol NB!!!!
	- java9 中运行 jol
		- https://stackoverflow.com/questions/46583083/how-to-run-jol-on-java-9

## 2019.11.6


1. asm 检测 java 字节码
	
	- asm 教程
	- http://web.cs.ucla.edu/~msb/cs239-tutorial/

2. asm 的应用

	- groovy, kotlin 的编译器中
	- 测试工具 Cobertura, JaCoCo  字节码注入实现的监控工具
	- lambda 表达式的适配器类, 通过 asm 动态生成

3. 访问者模式

	- 一种将数据操作和数据结构分离的设计模式
	- 应用
		- asm 使用
		- https://time.geekbang.org/column/article/12423
	- https://www.jianshu.com/p/1f1049d0a0f4

4. jvm 中的重排序

	- 即时编译器的重排序
		- 编译器在不改变单线程语义的前提下, 重新安排语句的执行顺序
	- 处理器的乱序执行
		- 现代处理器采用指令并行计数, ILP , 多条指令重叠执行, 如果不存在数据依赖, cpu 会改变对应的机器指令的执行顺序
	- 内存系统的重排序。
		- 读写缓存

5. happens-before 

	- 如果操作 X happens-before 操作 Y，那么 X 的执行结果对于 Y 可见。

6. java 内存模型 JMM

	- https://static001.infoq.cn/resource/ebook/6a/ee/6a9197c0714178e7c50c47e821a571ee.pdf
	- JMM 决定了一个线程对共享变量的写入何时对另一个线程可见
		- JMM 定义了线程和主内存的抽象关系
		- https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/blog/2019/11/JMM/e9270c21022143366f07e86f809369b.png
	- 屏障类型
		- 读写
		- 读读
		- 写写
		- 写读
			- 将处理器写缓冲区的数据全部刷新到内存
	- happens-before  JSR 133
		- 单线程中
		- 监视器锁规则: 对一个监视器的解锁, happens-before 于随后对这个 monitor 的加锁
		- volatile: 对volatile的写操作 happens-before 于后续 对 volatile 的读
		- 传递性
	- JSR 133 cookbook
		- http://gee.cs.oswego.edu/dl/jmm/cookbook.html


7. volatile 单例模式

	- 问题出在 new 操作上，我们以为的 new 操作应该是：
		- 分配一块内存 M；在内存 M 上初始化 Singleton 对象；然后 M 的地址赋值给 instance 变量。
	- 但是实际上优化后的执行路径却是这样的：
		- 分配一块内存 M；将 M 的地址赋值给 instance 变量；最后在内存 M 上初始化 Singleton 对象。
	- 所谓的单例模式, 就是安全发布的问题


8. jcstress 

	- 多线程测试
	- 测试单例模式, 为什么能单例


## 2019.11.7

1. String hashCode reorder 问题
	
	- 参考:
		- 讨论
			- https://stackoverflow.com/questions/12554570/instructions-reordering-in-java-jvm
		- 原始blog
			- http://jeremymanson.blogspot.com/2008/12/benign-data-races-in-java.html
	- 使用局部变量, 减少了多次读取可能竞争的变量, 性能可能更好


2. 双重检查锁 不工作的原因

	- http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html

3. Synchronization and the Java Memory Model

	- Doug lea 并发大神, 没听过? 去看看jdk concurrent 包的 author?
	- http://gee.cs.oswego.edu/dl/cpj/jmm.html


4. as-if-serial semantics 串行语义

	- 不管怎么重排序, 单线程执行的结果不能改变

5. If anyone can point me to the right direction, I would really appreciate it.

	- 如果有人能指出正确的方向，我将不胜感激。

6. 单例模式
	
	- 懒汉式
		- 双重锁
		- 静态内部类
	- 饿汉式
		- 静态变量
	- https://www.iteye.com/blog/qindongliang-2426430

7. 双重检查锁定

	- https://stackoverflow.com/questions/29883403/double-checked-locking-without-volatile
	- http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
	- 美团 https://tech.meituan.com/2014/09/23/java-memory-reordering.html

8. 如何重现双重检查锁中, 不加 volatile 时获取实例为 null 的情况

9. jvm cpu profiler
	
	- JProfiler
	- https://tech.meituan.com/2019/10/10/jvm-cpu-profiler.html


## 2019.11.8


1. java 对象头详解

	- https://www.jianshu.com/p/3d38cba67f8b
	- https://stackoverflow.com/questions/26357186/what-is-in-java-object-header
	- http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/markOop.hpp

|------------------------------------------------------------------------------|--------------------|
|                                  Mark Word (64 bits)                         |       State        |
|------------------------------------------------------------------------------|--------------------|
| unused:25 | identity_hashcode:31 | unused:1 | age:4 | biased_lock:1 | lock:2 |       Normal       |
|------------------------------------------------------------------------------|--------------------|
| thread:54 |       epoch:2        | unused:1 | age:4 | biased_lock:1 | lock:2 |       Biased       |
|------------------------------------------------------------------------------|--------------------|
|                       ptr_to_lock_record:62                         | lock:2 | Lightweight Locked |
|------------------------------------------------------------------------------|--------------------|
|                     ptr_to_heavyweight_monitor:62                   | lock:2 | Heavyweight Locked |
|------------------------------------------------------------------------------|--------------------|
|                                                                     | lock:2 |    Marked for GC   |
|------------------------------------------------------------------------------|--------------------|


- biased_lock
	- 对象是否启用偏向锁标记，只占1个二进制位。为1时表示对象启用偏向锁，为0时表示对象没有偏向锁。
- age
	- 4位的Java对象年龄。在GC中，如果对象在Survivor区复制一次，年龄增加1。当对象达到设定的阈值时，将会晋升到老年代。默认情况下，并行GC的年龄阈值为15，并发GC的年龄阈值为6。由于age只有4位，所以最大值为15，这就是-XX:MaxTenuringThreshold选项最大值为15的原因。
- identity_hashcode
	- 25位的对象标识Hash码，采用延迟加载技术。调用方法System.identityHashCode()计算，并会将结果写到该对象头中。当对象被锁定时，该值会移动到管程Monitor中。
- thread
	- 持有偏向锁的线程ID。
- epoch
	- 偏向年龄
- ptr_to_lock_record
	- 指向栈中锁记录的指针。
- ptr_to_heavyweight_monitor
	- 指向管程Monitor的指针。


2. 撤销偏向锁问题导致GC 时间变长

	- https://www.zhihu.com/question/57722838
	- synchronized 指南
		- 轻量级锁加锁过程
		- 偏向锁获取过程
		- https://www.cnblogs.com/paddix/p/5405678.html

3. wait/notify

	- Synchronized的语义底层是通过一个monitor的对象来完成，其实wait/notify等方法也依赖于monitor对象，这就是为什么只有在同步的块或者方法中才能调用wait/notify等方法，否则会抛出java.lang.IllegalMonitorStateException的异常的原因。
	- wait
		- Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object.
	- notify
		- `void notify()`
			- Wakes up a single thread that is waiting on this object's monitor.
		- `void notifyAll()`
			- Wakes up all threads that are waiting on this object's monitor.
	- 参考:
		- https://www.cnblogs.com/paddix/p/5381958.html

4. java hashcode 必须为 25bit ? 

	- 32位 对象头中的 hash 为 25 bit
	- 64为 对象头中的 hash 为 31 bit
	- 以内存计算的HashCode的方式“为“identity hash code”
	- 存储在对象头中的hashcode 都是 identity hash code 所以不会溢出
	- 参考
		- https://juejin.im/post/5c3aa2726fb9a04a0c2ead0b

5. 调用 Object.hashCode() 会关闭该对象的偏向锁
	
	- https://blogs.oracle.com/dave/biased-locking-in-hotspot

6. 20次, 40次在哪里记录的?


## 2019.11.13


1. spring boot 常用配置

	- redis
	- mysql
	- 接口统一返回格式 
		- `Date` -> timestamp
		- BigDecimal -> 取两位
		- JacksonConfig
	- logging
	- Error 处理
		- ProcessExceptionHandler
		- ErrorController
	- inteceptor
	- filter
	- ExecutorService
	- 自定义http参数名
		- 转换 @ParamName
	- swagger

## 2019.11.13晚

1. null 是对象么
	
	- null is special 
	- null 是一种特殊的类型
	- 如果Object为null，它将支持java.lang.Object诸如的方法equals()。但是，事实并非如此-对null的任何方法调用都会导致NullPointerException。
	- null 没有名称, 也不能强制转换
		- https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.1


## 2019.11.14

1. linux oom killer

	- http://senlinzhan.github.io/2017/07/03/oom-killer/

2. Can't find dependent libraries

	- 注意依赖顺序, 以倒序load
	- https://stackoverflow.com/questions/1087054/jni-dependent-libraries

3. docker id 如何避免不重复

	- 


## 2019.11.15

1. 编译 openjdk
	
	- 环境: win10 + vs2019
	- 步骤
		- vs2019 安装
		- cygwin 安装
			- binuitls  2.29-1
			- cpio 2.11-3
			- m4 1.4.18-1
			- make 4.2.1-2
			- procps-ng 3.3.15-1
			- unzip 6.0-17 
			- zip 3.0-12
		- openjdk7 openjdk8
			- https://github.com/ojdkbuild/ojdkbuild
		- freetype 2.7
			- https://download.savannah.gnu.org/releases/freetype/
		- 
	- 参考
		- Win10下编译OpenJDK8
			- https://www.cnblogs.com/jpfss/p/11641045.html
		- WINDOWS7平台下编译OpenJDK8和Visual Studio 单步调试HotSpot JVM
			- https://www.javatt.com/p/50071
		- clion + centos7 远程调试
			- 作者在 windows 下编译遇到一堆错误....然后放弃哈哈
			- https://www.cnblogs.com/jhxxb/p/11094578.html
		- vscode调试OpenJDK
			- https://zhuanlan.zhihu.com/p/50220757
		- openjdk build readme
			- https://hg.openjdk.java.net/jdk8u/jdk8u/raw-file/945f4ae40e43/README-builds.html
		- ubuntu 上编译 java
			- https://my.oschina.net/liebrother/blog/3115104
		- debug 到 JVM 
			- https://my.oschina.net/liebrother/blog/3116034


2. jpa更新操作，数据库更新了，但是查询的还是旧的数据

	- flush
	- `entityManager.clear();`
	- https://blog.csdn.net/chenjianhuideyueding/article/details/88426271

3. nginx 同端口转发不同host


4. windows 连接 ubuntu

	- 一次成功 yeah!
	- https://askubuntu.com/questions/592537/can-i-access-ubuntu-from-windows-remotely/592544#592544



## 2019.11.18

1. nginx 只在启动时查找有哪些配置文件, 如果在之后新增了配置文件, 仅仅使用 `nginx -s reload` 将不起作用, 需要将 nginx 完全重启后, 才能使用

	- nginx 完全重启
		- `nginx -s quit`
		- `nginx`

2. jmeter 使用 

	- 不要使用GUI运行压力测试，GUI仅用于压力测试的创建和调试；执行压力测试请不要使用GUI。使用下面的命令来执行测试：
	- `jmeter -n -t [jmx file] -l [results file] -e -o [Path to web report folder]`
	- GUI 使用步骤
		1.创建线程组
		2. 配置文件
			- http 请求默认值 协议地址端口
			- http 信息头管理器 
		3. 采样器 - 构造http请求
			- 采样器 - http 请求
		4. 添加断言
			- 响应断言
		5. 添加查看结果树
		6. 添加汇总报告

	- https://www.cnblogs.com/stulzq/p/8971531.html


3. java native memory usage
	- 添加到命令行： `-XX:NativeMemoryTracking=summary`
	- 然后启动 `jcmd <PID> VM.native_memory`
	- https://stackoverflow.com/questions/2756798/java-native-memory-usage

4. 堆外内存泄漏分析
	
	- NMT, pmap, 系统工具
	- https://mp.weixin.qq.com/s/73whP7E3SIB5mn_TLrqT_w

5. pmap

	- 查看进程地址空间

```
chen:~# pmap --help

Usage:
 pmap [options] PID [PID ...]

Options:
 -x, --extended              show details
 -X                          show even more details
            WARNING: format changes according to /proc/PID/smaps
 -XX                         show everything the kernel provides
 -c, --read-rc               read the default rc
 -C, --read-rc-from=<file>   read the rc from file
 -n, --create-rc             create new default rc
 -N, --create-rc-to=<file>   create new rc to file
            NOTE: pid arguments are not allowed with -n, -N
 -d, --device                show the device format
 -q, --quiet                 do not display header and footer
 -p, --show-path             show path in the mapping
 -A, --range=<low>[,<high>]  limit results to the given range

 -h, --help     display this help and exit
 -V, --version  output version information and exit
```


6.  arthas
	
	- 教程
		- https://alibaba.github.io/arthas/arthas-tutorials?language=cn
	- 启动
		- `docker exec -it  ${containerId} /bin/bash -c "wget https://alibaba.github.io/arthas/arthas-boot.jar && java -jar arthas-boot.jar"`
		- `docker exec -it async-aiqi /bin/bash -c "java -jar arthas-boot.jar"`
	- 常用命令
		- dashboard
		- 
	- 项目地址
		- https://alibaba.github.io/arthas/

7. 浏览器中在线 docker 虚拟机环境

	- https://www.katacoda.com/


## 2019.11.19

1. jni 的额外开销
	
	- 概述
		- 进入C函数时, 对引用参数句柄化
		- 调整参数位置
		- C函数返回时, 清理线程私有句柄块
	- https://stackoverflow.com/questions/24746776/what-does-a-jvm-have-to-do-when-calling-a-native-method

2. 常用的 java 工具

	- arthas NB
	- jmeter
	- jstat
	- jcmd
	- jvisualvm
	- jps
	- jconsole
	- jstack

3. how-to-debug-leak-in-native-memory-on-jvm
	- https://stackoverflow.com/questions/38153381/how-to-debug-leak-in-native-memory-on-jvm

4. 观察 jni global reference 引起的 memory leak

	- `jstack {pid} | grep JNI`
	- 案例
		 - http://blog.2baxb.me/archives/918


## 2019.11.20

1. top 命令显示中各个名称的含义
	- VIRT：virtual memory usage 虚拟内存
		- 1、进程“需要的”虚拟内存大小，包括进程使用的库、代码、数据等
		- 2、假如进程申请100m的内存，但实际只使用了10m，那么它会增长100m，而不是实际的使用量
	- RES：resident memory usage 常驻内存
	- SHR：shared memory 共享内存
		- 计算某个进程所占的物理内存大小公式：RES – SHR
	- 操作:
		- f 进入行列定义
	- 参考
		- https://javawind.net/p131


2. why epoll not start ?

	- `2019-11-20 18:37:18.424  INFO 7 --- [nio-7900-exec-4] io.lettuce.core.EpollProvider            : Starting without optional epoll library`
	- `2019-11-20 18:37:18.426  INFO 7 --- [nio-7900-exec-4] io.lettuce.core.KqueueProvider           : Starting without optional kqueue library`

## 2019.11.21

1. java 外部gc

	- `jcmd {pid} GC.run`
	- 查看支持的命令
		- `jcmd {pid} help` 
	- jcmd 命令介绍
		 -https://www.jianshu.com/p/388e35d8a09b

2. windows 进程内存查看

	- VMmap
		- https://blog.csdn.net/weixin_42263483/article/details/86351590

## 2019.11.22

1. 星轨拍摄技巧

	- https://asingleboat.top/?p=291

2. 验证想法: 使用 debug jdk 用 vs 附加到进程


3.  NoClassDefFoundError Could not initialize class

	- JVM在加载类的时候，会初始化类里的静态变量，或执行静态块，如果这个时候抛出了异常，该类就会加载失败，那么以后任何使用到这个类的地方，都会抛出NoClassDefFoundError异常


## 2019.11.25

1. ReqestContextHolder 如何实现的?

	- `ThreadLocal<RequestAttributes>`

2. PDB files
	
	- Program Database File，程序数据库文件
	- public Symbol Files (PDB)

3. mysql group by day and count

	- `SELECT year(created_time), month(created_time), day(created_time), count(*) FROM ecg_aiqi.xxx group by  year(created_time), month(created_time), day(created_time);`


4. RequestContextHolder

	- `HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        `
       - https://www.cnblogs.com/Terry-Wu/p/9439126.html

5. ojdkbuild 使用 windows 构建

	- 参考:
		- https://github.com/ojdkbuild/ojdkbuild/wiki/HowToBuild
	- `git clone https://github.com/ojdkbuild/ojdkbuild`
	- `cd ojdkbuild`
	- `git checkout java-1.8.0-openjdk-debug-1.8.0.232-1.b09`
	- `git submodule update --init`

6. How to import the openjdk9 source code to visual studio 2017 after compilation in Windows 10l?

	- https://stackoverflow.com/questions/51808317/how-to-import-the-openjdk9-source-code-to-visual-studio-2017-after-compilation-i

	- To build VS Project Creator run the following command from the openjdk9 top directory:
		- `make hotspot-ide-project`
	- In my case, the generated VS project files are located in:
		- `.../openjdk9/build/windows-x86_64-normal-server-slowdebug/ide/hotspot-visualstudio`

7. 查看 .so 包中的函数

	- 

8. `java.lang.UnsatisfiedLinkError: Error looking up function 'effeXXX': /root/.cache/JNA/temp/jna1120004268870969086.tmp: undefined symbol: effeXXX`

	- https://www.oschina.net/question/1791496_2192639

## 2019.12.02

1. 二维码是如何识别的?

## 2019.12.03

1. js button on image

	- https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_button_on_image

2. js download file 

	- https://stackoverflow.com/questions/54626186/how-to-download-file-with-javascript

## 2019.12.04

1. log4j2 如何实现的

	- 如何高速写日志

2. 部分标记清除算法

	- https://www.bbsmax.com/A/A2dmkqo7Je/

3. 现代 jvm 的 垃圾回收中还有 引用计数么

	- https://www.zhihu.com/question/30896688

4. Java使用JNI调用C写的库时，使用malloc分配的内存是由谁来管理？

	- https://www.zhihu.com/question/28250278/answer/40071228

## 2019.12.05

1. 单实例 mysql 更新行的 极限速度

2. logstash 是做什么用的
	
	- Logstash是一个开源数据收集引擎，具有实时管道功能。Logstash可以动态地将来自不同数据源的数据统一起来，并将数据标准化到你所选择的目的地。
	- https://www.cnblogs.com/cjsblog/p/9459781.html

3. log 使用

	- `SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".`
	- `log4j:WARN No appenders could be found for logger`
		- pom 中添加 log4j-slf4j-impl 依赖, 注意 scope

```xml
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.10</version>
        </dependency>

        <!-- 日志 -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.12.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.12.1</version>
        </dependency>
        <dependency>
            <groupId>com.lmax</groupId>
            <artifactId>disruptor</artifactId>
            <version>3.4.2</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.29</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j-impl</artifactId>
            <version>2.12.1</version>
        </dependency>
```

4. 如何优雅地关闭 log4j2

	- https://stackoverflow.com/questions/25877102/how-to-properly-shutdown-log4j2

5. log4j2 routing

	- 分别记录不同用户的日志
	- https://stackoverflow.com/questions/17827923/how-to-write-different-logs-in-different-files-with-log4j2-mdc-in-xml

6. ERROR appender RollingRandomAccessFile has no parameter that matches element Filters

	- https://stackoverflow.com/questions/28276619/log4j2s-failoverappender-error-appender-failover-has-no-parameter-that-matches 
	- https://issues.apache.org/jira/browse/LOG4J2-878


## 2019.12.06


1. `Multiple default routes. Route Route(type=dynamic - type=Route default) will be ignored`

	- Route 的属性 key 没有指定

2. AI 识别人的笑话?

3. Log4j2 - Unable to invoke factory method in class org.apache.logging.log4j.core.appender.RollingFile
	
	- 这个异常是由于RollingFile使用到了${ctx:xxx}，而该变量值是null，导致无法创建对应的RollingFile文件到磁盘。
	- https://blog.csdn.net/lewky_liu/article/details/85644047

4. electron 部署应用

5.  Starting Servlet Engine: Apache Tomcat/9.0.13
2019-12-06 19:28:19.210  INFO 7 --- [           main] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path


## 2019.12.09

1. Major GC和Full GC的区别是什么？触发条件呢？
	
	- major GC 可能指 老年代 GC , 也可能指 full gc
	- https://www.zhihu.com/question/41922036/answer/93079526

2. 中村成洋

	- g1gc 算法
		- https://tatsu-zine.com/books/g1gc
		- https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/blog/2019/12/%E5%BE%B9%E5%BA%95%E8%A7%A3%E5%89%96%E3%80%8CG1GC%E3%80%8D%E3%82%A2%E3%83%AB%E3%82%B4%E3%83%AA%E3%82%BA%E3%83%A0%E7%B7%A8-1.0.0.pdf
	- g1gc 实现
		- https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/blog/2019/12/g1gc-impl-20120914.pdf
	- 论文 g1gc
		- http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.63.6386
	- 论文笔记
		- https://www.jianshu.com/p/b1609c81cd5f
	- 历史 gc , 高级语言虚拟机讨论组
		- https://hllvm-group.iteye.com/group/topic/41086

<<<<<<< Updated upstream
## 2019.12.10

1. flutter get started

	- https://flutterchina.club/get-started/codelab/
	- https://flutter.dev/docs

2. pdf translator


## 2019.12.12

1. Segmentation fault

	- 带有c ++的JNI在cout，printf和方法调用上不断崩溃
	- https://stackoverflow.com/questions/36959657/jni-with-c-keeps-crashing-on-cout-printf-and-method-calls

2. openjdk 调试


	-  CentOS7 上编译，Windows 上使用 Clion 远程调试
		- https://www.cnblogs.com/jhxxb/p/11094578.html
		- 实际上, 从远程机子上同步代码到本地花了我8小时 (我同步了一段时间, 然后晚上就去睡觉了, 结果第二天起来还没同步完...)
		- 后面我同步完成, 重新编译了下远程代码... 结果又开始无休止的同步, 只能byebye了
	- JAVA虚拟机学习笔记（一）Windows10下编译OpenJDK8
		- https://www.cnblogs.com/lighten/p/5906359.html
		- https://www.jianshu.com/p/e85f93cc74cb
		- 上面两篇结合着看
			- cygwin
				- E:\environment\cygwin\install\bin
			- openjdk 8 src 
				- E:\environment\openjdk\openjdk-8u40-src-b25-10_feb_2015\openjdk
				- 其他
					- C:\openjdk\jdk\make\CreateJars.gmk 未修改
					- C:\openjdk\common\autoconf\generated-configure.sh
						注释了7246-7254
			- bootstrap jdk
				- E:\environment\jdk7\jdk-7u80-windows-x64.exe\jdk7\bin
			- freetype
				- https://download.savannah.gnu.org/releases/freetype/
				- E:\environment\freetype\ft28\freetype-2.8
				- output:
					- E:\environment\freetype\ft28\freetype-2.8\objs\vc2010\x64\freetype28MT.dll
					- E:\environment\freetype\ft28\freetype-2.8\objs\vc2010\x64\freetype28MT.lib
			- configure 时的报错
				- openjdk\common\autoconf\generated-configure.sh 提示 版本过低
					- 注释 7246-7254 行
				- Your path contains Windows tools (C:\Windows\system32) before your unix (cygwin or msys) tools.
					- export PATH=/cygdrive/e/environment/cygwin/install/bin:$PATH
				- Target CPU mismatch. We are building for x86_64 but CL is for ""; expected "x64".
					- https://blog.csdn.net/quantum7/article/details/93052571
					-  找到 openjdk\common\autoconf\generated-configure.sh 对应代码行, 注释

		- 参考
			- 32位
				- https://hllvm-group.iteye.com/group/topic/41271
			- 包含vs2010 安装
				- https://blog.csdn.net/tangyongzhe/article/details/53576097
			- freetype binary 下载
				- https://github.com/ubawurinna/freetype-windows-binaries/releases 


## 2019.12.13

1. 在G1 GC之前，所有HotSpot VM的GC堆布局都继承自1984年David Ungar在Berkeley Smalltalk里所实现的Generation Scavenging。参考论文：Generation Scavenging: A Non-disruptive High Performance Storage Reclamation Algorithm

	- https://hllvm-group.iteye.com/group/topic/39376

2. 尝试编译 openjdk11
	
	- 参考
		- windows10下编译调试openjdk11
			- https://www.jianshu.com/p/10a83eead822
	- 环境
		-  

3. git clone openjdk

	- 之前用 mercurial clone 的, clone 了一下午还没好...
	- 然后用 git clone 开了vpn还是蛮快的, 但是openjdk太大了(我clone了一半就已经几百兆了), clone 了两次到一半都因为网络问题断连了, 然后要重新clone...
	- 最后使用 `--depth 1` 终于成功了

```

$ git clone --depth 1 https://github.com/xxx/xxxxxxx.git
$ git remote set-branches origin 'remote_branch_name'
$ git fetch --depth 1 origin remote_branch_name
$ git checkout remote_branch_name
```

```
## 如果你头铁网速快....可以直接...
## git clone --branch jdk-11+28 https://gitee.com/lexihc/openjdk.git
## 使用国内的
## git clone --depth 1 https://gitee.com/lexihc/openjdk.git
git clone --depth 1 https://github.com/unofficial-openjdk/openjdk.git
cd openjdk
git remote set-branches origin jdk8u/jdk8u
git fetch --depth 1 origin jdk8u/jdk8u
git checkout jdk8u/jdk8u
```

```
// git 换行符 https://www.jianshu.com/p/f13ef9e538e0
// 提交时转换为LF，检出时转换为CRLF
git config --global core.autocrlf true   
```


	- 然后用 git clone  下来的代码有换行符问题, 命令执行不下去

4. this computer does not support Intel Virtualization Technology (VT-x) or it is being exclusively used

langtools\src\share\classes\com\sun\tools\javac\parser\JavacParser.java

## 2019.12.15

1. 程序员必须掌握哪些算法？
	
	- https://www.zhihu.com/question/23148377
	- 算法
		- 排序算法：快速排序、归并排序、计数排序
		- 搜索算法：回溯、递归、剪枝技巧
		- 图论：最短路、最小生成树、网络流建模
		- 动态规划：背包问题、最长子序列、计数问题
		- 基础技巧：分治、倍增、二分、贪心
	- 数据结构
		- 数组与链表：单 / 双向链表、跳舞链
		- 栈与队列
		- 树与图：最近公共祖先、并查集
		- 哈希表
		- 堆：大 / 小根堆、可并堆
		- 字符串：字典树、后缀树

## 2019.12.16

1. configure crlf 问题

	- https://stackoverflow.com/questions/11616835/r-command-not-found-bashrc-bash-profile

```
vim .bashrc
:set ff=unix
:wq!
```

2. Could not succesfully extract the envionment variables needed for the VS setup. Cannot continueconfigure: Try setting --with-tools-dir to the VC/bin directory within the VS installation
	- https://www.codetd.com/article/2901356

3. this computer does not support Intel Virtualization Technology (VT-x) or it is being exclusively used

	- android sdk 安装时候的问题

## 2019.12.17

1. 分词器

	- ik_max_word
		- 会将文本做最细粒度的拆分，比如会将“中华人民共和国人民大会堂”拆分为“中华人民共和国、中华人民、中华、华人、人民共和国、人民、共和国、大会堂、大会、会堂等词语。
	- ik_smart
		- 会做最粗粒度的拆分，比如会将“中华人民共和国人民大会堂”拆分为中华人民共和国、人民大会堂。
	- 最佳实践是：索引时用ik_max_word，在搜索时用ik_smart。


## 2019.12.19

1. openjdk8 centos
	
	- `./configure --with-boot-jdk=/opt/jdk1.7.0_80/ -with-target-bits=64 --with-jvm-variants=server --with-debug-level=slowdebug`
	- `make all CONF=linux-x86_64-normal-server-slowdebug ZIP_DEBUGINFO_FILES=0 ENABLE_FULL_DEBUG_SYMBOLS=1`
	- `cd ./build/linux-x86_64-normal-server-slowdebug/jdk/bin/`
	- `./java -version`
	- `gdb -args ./java -Xms10m -Xmx20m -XX:-UseCompressedOops -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1LogLevel=finest -XX:+PrintGCDetails GCTest`


```
show args
b G1ParScanThreadState.cpp:210
b G1ParScanThreadState::copy_to_survivor_space
r
c
i locals
```

```
javac GCTest.java
java GCTest
gdbserver :1234 ./java -Xms10m -Xmx20m -XX:-UseCompressedOops -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1LogLevel=finest -XX:+PrintGCDetails GCTest
```

可喜可贺!!!终于可以调试hotspot vm 了, TT 
整了不下三次, 今天终于调通了啊啊啊啊


## 2019.12.24

1. openjdk7 b147 下载
	
	- 下载地址: http://download.java.net/openjdk/jdk7/promoted/b147/openjdk-7-fcs-src-b147-27_jun_2011.zip
	- https://www.jianshu.com/p/d509d78a613a

2. jdk6 下载
	- https://www.oracle.com/technetwork/java/javase/archive-139210.html


## 2019.12.25

1. JAVA 中的 句柄

	- 即指向对象的引用

2. C++ 中的虚函数调用

	- C++编译阶段，没办法知道一个基类的指针或引用所指对象的类型，所以没办法通过这个指针判断调用的虚函数到底是谁的，所以只能通过查找虚函数表来找到函数的入口地址。

3. 虚函数和纯虚函数的区别

	- 首先：强调一个概念
		- 定义一个函数为虚函数，不代表函数为不被实现的函数。
		- 定义他为虚函数是为了允许用基类的指针来调用子类的这个函数。
		- 定义一个函数为纯虚函数，才代表函数没有被实现。
		- 抽象类的定义：  称带有纯虚函数的类为抽象类。
	- 总结
		1. 纯虚函数声明如下： virtual void funtion1()=0; 纯虚函数一定没有定义，纯虚函数用来规范派生类的行为，即接口。包含纯虚函数的类是抽象类，抽象类不能定义实例，但可以声明指向实现该抽象类的具体类的指针或引用。
		2. 虚函数声明如下：virtual ReturnType FunctionName(Parameter)；虚函数必须实现，如果不实现，编译器将报错，错误提示为：`error LNK****: unresolved external symbol "public: virtual void __thiscall ClassName::virtualFunctionName(void)`
		3. 对于虚函数来说，父类和子类都有各自的版本。由多态方式调用的时候动态绑定。
		4. 实现了纯虚函数的子类，该纯虚函数在子类中就编程了虚函数，子类的子类即孙子类可以覆盖该虚函数，由多态方式调用的时候动态绑定。
		5. 虚函数是C++中用于实现多态(polymorphism)的机制。核心理念就是通过基类访问派生类定义的函数。
		6. 在有动态分配堆上内存的时候，析构函数必须是虚函数，但没有必要是纯虚的。
		7. 友元不是成员函数，只有成员函数才可以是虚拟的，因此友元不能是虚拟函数。但可以通过让友元函数调用虚拟成员函数来解决友元的虚拟问题。
		8. 析构函数应当是虚函数，将调用相应对象类型的析构函数，因此，如果指针指向的是子类对象，将调用子类的析构函数，然后自动调用基类的析构函数。
	- 析构函数(destructor) 与构造函数相反，当对象结束其生命周期，如对象所在的函数已调用完毕时，系统自动执行析构函数。析构函数往往用来做“清理善后” 的工作（例如在建立对象时用new开辟了一片内存空间，delete会自动调用析构函数后释放内存）。
	- https://blog.csdn.net/hackbuteer1/article/details/7558868

4. C++ 中 volatile
	- 易变性
	- 不可优化性
	- 顺序性: 能够保证Volatile变量间的顺序性，编译器不会进行乱序优化
	- Java的Volatile有很极大的增强，Java Volatile变量的操作，附带了Acquire与Release语义。所谓的Acquire与Release语义，可参考文章：Acquire and Release Semantics。(这一点，后续有必要的话，可以写一篇文章专门讨论)。Java Volatile所支持的Acquire、Release语义，如下:
		1. 对于Java Volatile变量的写操作，带有Release语义，所有Volatile变量写操作之前的针对其他任何变量的读写操作，都不会被编译器、CPU优化后，乱序到Volatile变量的写操作之后执行。
		2. 对于Java Volatile变量的读操作，带有Acquire语义，所有Volatile变量读操作之后的针对其他任何变量的读写操作，都不会被编译器、CPU优化后，乱序到Volatile变量的读操作之前进行。
	- http://hedengcheng.com/?p=725

5. mysql 相关博客

	- 何登成 http://hedengcheng.com/

6. double check 的历史 论文

	- https://www.aristeia.com/Papers/DDJ_Jul_Aug_2004_revised.pdf

7. C++ 内联函数

	- C++ 内联函数是通常与类一起使用。如果一个函数是内联的，那么在编译时，编译器会把该函数的代码副本放置在每个调用该函数的地方。
	- 对内联函数进行任何修改，都需要重新编译函数的所有客户端，因为编译器需要重新更换一次所有的代码，否则将会继续使用旧的函数。
	- 引入内联函数的目的是为了解决程序中函数调用的效率问题, 空间换时间
	- https://www.runoob.com/cplusplus/cpp-inline-functions.html

8. JVM_ENTRY 和 JVM_END 的含义
	
	- 就是一个方法的模板, 定义了一些 JVM 内部接口通用的操作
	- https://juejin.im/post/5b4b08e06fb9a04fb900c276
	- `#define JNI_END } }`

9. javaw 
	
	- 像是在后台启动

10. openjdk8 中废弃了 gamma launcher

	- https://hllvm-group.iteye.com/group/topic/39731?page=2

## 2019.12.26

1. C++中的friend class 用法总结

	- C++中的friend关键字其实做这样的事情：在一个类中指明其他的类（或者）函数能够直接访问该类中的private和protected成员。
	- https://blog.csdn.net/weixin_38293850/article/details/80191242
	- friend function
		- C++中的友元机制允许类的非公有成员被一个类或者函数访问，友元按类型分为三种：普通非类成员函数作为友元,类的成员函数作为友元，类作为友元。
	- https://blog.csdn.net/weixin_38293850/article/details/80191242

2. C++ union

	- 共用体，也叫联合体，在一个“联合”内可以定义多种不同的数据类型， 一个被说明为该“联合”类型的变量中，允许装入该“联合”所定义的任何一种数据，这些数据共享同一段内存，以达到节省空间的目的。union变量所占用的内存长度等于最长的成员的内存长度。

3. C++ 常量成员函数 const

	- `int day() const;`
	- 在函数声明的(空)参数表后面出现的 const , 它指明这些函数不会修改 类成员 的状态
	- <C++程序设计语言> 第10章类 P205

4. java 对象引用持有 指向对象的指针, 对象持有指向 类的指针

5. HSDB

	- 使用 HSDB 调试 hotspot
	- GUI
		- `java -cp .;%JAVA_HOME%/lib/sa-jdi.jar sun.jvm.hotspot.HSDB`
	- `java -cp .;%JAVA_HOME%/lib/sa-jdi.jar sun.jvm.hotspot.CLHSDB`
	- 使用介绍 https://www.jianshu.com/p/a28ae76ac3b4
	- https://www.iteye.com/blog/rednaxelafx-1847971

6. jdb
	- java 调试器
	- https://docs.oracle.com/javase/7/docs/technotes/tools/windows/jdb.html
	- idea 如何使用 jdb 的
		- `E:\environment\java\bin\java.exe -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:53998,suspend=y,server=n -javaagent:C:\Users\pc\.IntelliJIdea2019.1\system\captureAgent\debugger-agent.jar -Dfile.encoding=UTF-8 -classpath "E:\environment\java\jre\lib\charsets.jar;E:\environment\java\jre\lib\deploy.jar;...;" me.giraffetree.java.jiujiu.utils.Test`

7. javaagent

	- Javaagent 是什么？
		- Javaagent是java命令的一个参数。参数 javaagent 可以用于指定一个 jar 包，并且对该 java 包有2个要求：
			- 这个 jar 包的 MANIFEST.MF 文件必须指定 Premain-Class 项。
			- Premain-Class 指定的那个类必须实现 premain() 方法。
		- premain 方法，从字面上理解，就是运行在 main 函数之前的的类。当Java 虚拟机启动时，在执行 main 函数之前，JVM 会先运行-javaagent所指定 jar 包内 Premain-Class 这个类的 premain 方法 。

8. JVM启动后动态Instrument

	- 上面介绍的Instrumentation是在 JDK 1.5中提供的，开发者只能在main加载之前添加手脚，在 Java SE 6 的 Instrumentation 当中，提供了一个新的代理操作方法：agentmain，可以在 main 函数开始运行之后再运行。
	- https://www.cnblogs.com/rickiyang/p/11368932.html#3898086050

9.  instrument原理

	- instrument的底层实现依赖于JVMTI(JVM Tool Interface)，它是JVM暴露出来的一些供用户扩展的接口集合，JVMTI是基于事件驱动的，JVM每执行到一定的逻辑就会调用一些事件的回调接口（如果有的话），这些接口可以供开发者去扩展自己的逻辑。JVMTIAgent是一个利用JVMTI暴露出来的接口提供了代理启动时加载(agent on load)、代理通过attach形式加载(agent on attach)和代理卸载(agent on unload)功能的动态库。而instrument agent可以理解为一类JVMTIAgent动态库，别名是JPLISAgent(Java Programming Language Instrumentation Services Agent)，也就是专门为java语言编写的插桩服务提供支持的代理。


## 2019.12.29

1. clion live template 

	- `cout << $content$ << endl;`


## 2019.12.31

1. jpa GenerationType

	- TABLE：使用一个特定的数据库表格来保存主键。
	- SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
	- IDENTITY：主键由数据库自动生成（主要是自动增长型）

2. Cannot initialize variable with an rvalue of type void*

```C++
    int a = 123;
    int *p = &a;
    // int *q = &p; // 报错 Cannot initialize a variable of type 'int *' with an rvalue of type 'int **'
    // 应该写成下面的格式
    int **q = &p;
```

3. `int *p;`

	- 声明一个变量 p，它的类型必须满足 `*p` 属于 int
	- 等同于 `int* p = &var;`
	- 其实是个 `int*` 类型的变量
	- `*p` 属于 int 类型


## 2020.1.2

1. 定时发布微博类(写扩散模型), 可以先加入到用户的时间线上, 等到达时间时, 用户就可以自动获取到了

	- 如果取消怎么办?
		- 删除
	- 感觉如果是这样的话, 还是不要加入为好

## 2019.1.3

1. 算法 algorithms第四版答案
	
	- https://algs4.cs.princeton.edu/15uf/

2. 动态连通性问题
	

3. 可视化算法

	- https://visualgo.net/en

4. 原地排序

	- 对一个长度为 n 的数组进行排序, 只使用 常数级的额外存储空间

5. java 打印参数 

	- `java -XX:+PrintFlagsFinal -version | grep Inline`


## 2019.1.6

1. 数据库 JOIN 的实现 
	- https://www.infoq.cn/article/6XGx92FyQ45cMXpj2mgZ


## 2019.1.7


1. 桶排序的实现
	
	- 数组加链表
	- https://www.cs.usfca.edu/~galles/visualization/BucketSort.html
	- 优化
		- 常见的优化方法是先将存储桶中未排序的元素放回原始数组中，然后对整个数组进行插入排序；因为插入排序的运行时基于每个元素距其最终位置的距离，所以比较的数量保持相对较小，并且通过将列表连续存储在内存中可以更好地利用内存层次结构。


2. Math 四舍五入, 向上取整, 向下取整
	  

```java
// 四舍五入
long round = Math.round(1.499);
long round2 = Math.round(1.5);
System.out.println(round);
System.out.println(round2);

// 向上取整
int s = (int)Math.ceil(1.1);
System.out.println(s);

// 向下取整
System.out.println((int)Math.floor(1.6));	
```

3. 正则 规则一览

	- http://c.runoob.com/front-end/854


## 2020.1.8

1. linux mysql 配置文件 `/etc/my.cnf`

2. mysql 5.6 函数 `length('str')`

	- 并不是按照字符来计算长度的,而是通过字节 
	- `char_length('str')` 计算的才是字符

