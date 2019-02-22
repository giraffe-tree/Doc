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

	- Full GC (Metadata GC Threshold)
	- `-XX:MetaspaceSize=256m`
	- `-XX:MaxMetaspaceSize=256m`
	- [JVM参数MetaspaceSize的误解](https://blog.csdn.net/u011381576/article/details/79635867)

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
 
2. ` df -hl `

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




## 2019.2.22

1. vim 缩进 tab, insert 界面中 `ctrl+d` , tab insert 界面 `ctrl+t`

2. 事务传播特性 7 种

	- 嵌套事务

3. springboot 事务管理 默认事务隔离

4. `@Transaction` 在方法内部调用无法开启事务

	`AopContext.currentProxy()` 获取当前类的代理对象, 再调用增强后的方法

5. `CompletableFuture` 中异常没有报出, 没有报错, 但实际已经 NPE 了

6. `winscp` linux 传文件到 win


