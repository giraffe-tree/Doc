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



