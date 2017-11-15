# Quartz

## job bean 的实现

[参考](http://blog.csdn.net/x6582026/article/details/52947878)


## spring.xml

[参考1](http://blog.csdn.net/tanyongbing1988/article/details/45689987)

[参考2](https://www.cnblogs.com/liuchao102/p/6064819.html)

    ```
    <!--开启这个配置，spring才能识别@Scheduled注解-->
    <task:annotation-driven/>
    ```

## 直接存到数据库

1. 我们修改起来不方便
2. 当采用分布式部署的时候,每台服务器都有定时任务,到了时间点都会执行这个job,轻则造成运行环境效率下降,重则,数据紊乱

## 实现JOb

[Quartz学习——Spring和Quartz集成详解（三](http://blog.csdn.net/u010648555/article/details/54891264)

Spring和Quartz集成存储方式使用的是RAM方式和JDBC方式




## job 状态和并发

[quartz 官方文档翻译:Job与JobDetail介绍](http://ifeve.com/quartz-tutorial-job-jobdetail/)

**@DisallowConcurrentExecution**：将该注解加到job类上，告诉Quartz不要并发地执行同一个job定义（这里指特定的job类）的多个实例。请注意这里的用词。拿前一小节的例子来说，如果“SalesReportJob”类上有该注解，则同一时刻仅允许执行一个“SalesReportForJoe”实例，但可以并发地执行“SalesReportForMike”类的一个实例。所以该限制是针对JobDetail的，而不是job类的。但是我们认为（在设计Quartz的时候）应该将该注解放在job类上，因为job类的改变经常会导致其行为发生变化。

**@PersistJobDataAfterExecution**：将该注解加在job类上，告诉Quartz在成功执行了job类的execute方法后（没有发生任何异常），更新JobDetail中JobDataMap的数据，使得该job（即JobDetail）在下一次执行的时候，JobDataMap中是更新后的数据，而不是更新前的旧数据。和 @DisallowConcurrentExecution注解一样，尽管注解是加在job类上的，但其限制作用是针对job实例的，而不是job类的。由job类来承载注解，是因为job类的内容经常会影响其行为状态（比如，job类的execute方法需要显式地“理解”其”状态“）。

如果你使用了@PersistJobDataAfterExecution注解，我们强烈建议你同时使用@DisallowConcurrentExecution注解，因为当同一个job（JobDetail）的两个实例被并发执行时，由于竞争，JobDataMap中存储的数据很可能是不确定的。

## spring 注入 为空

http://blog.csdn.net/u012572955/article/details/51656270

要点
1. public class JobFactory extends AdaptableJobFactory
2. schedulerFactoryBean 中 加入 ```<property name="jobFactory" ref="jobFactory"></property>  ```


## 数据库引擎问题

原来使用了``` org.quartz.jobStore.driverDelegateClass:org.quartz.impl.jdbcjobstore.StdJDBCDelegate ```,在保存数据时没有问题,但是读取quartz数据却有了```Couldn't retrieve trigger: 不良的类型值 long : \x ```的问题, 因为我本地用的是postgresql,所以产生了问题

**解决:** 换成 ``` org.quartz.jobStore.driverDelegateClass:org.quartz.impl.jdbcjobstore.PostgreSQLDelegate ```

## job 传入参数的问题

[作业调度框架 Quartz 学习笔记(四) -- 接收参数和维护状态
](http://blog.csdn.net/lnara/article/details/8646155)

原理:

1. 首先要在数据库中初始化值,放入 jobDataMap
2. 在 实现了 job 的类中,读取 jobDataMap ,进行 service 操作,然后改变它,再放入jobDataMap

### job trigger的关系

一个Job可以有多个Trigger，但多个Job不能对应同一个Trigger。

[Quartz:Job和Trigger的关系](http://blog.csdn.net/alexhendar/article/details/23367123)




