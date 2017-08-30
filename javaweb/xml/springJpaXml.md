# Spring Jpa Xml 配置详解

[Spring Jpa Xml 配置详解](http://www.cnblogs.com/liuyitian/p/4062748.html)

[spring生成EntityManagerFactory的三种方式](http://www.cnblogs.com/beiyeren/archive/2013/01/23/2873210.html)

<ref bean ="b"/> 是寻找全局中的 bean;

- ref元素是用在property中，来设置需要引用的容器管理的其它Bean。


```
<!-- Jpa 事务管理器  -->
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory"/>
    </bean>

<!-- 指定Jpa持久化实现厂商类,这里以Hibernate为例 -->
        <property name="jpaVendorAdapter" ref="hibernateJpaVendorAdapter"/>
```

```
log4j.rootLogger=DEBUG, Console

#Console
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.layout=org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n

log4j.logger.java.sql.ResultSet=INFO
log4j.logger.org.apache=INFO
log4j.logger.java.sql.Connection=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```







