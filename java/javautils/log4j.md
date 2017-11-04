# Log4j

[Log4j](http://blog.csdn.net/zqbx7/article/details/54576337)

http://blog.csdn.net/promaster/article/details/41282259



```
log4j.rootCategory=INFO, stdout , R

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[QC] %p [%t] %C.%M(%L) | %m%n

log4j.appender.R=org.apache.log4j.DailyRollingFileAppender
log4j.appender.R.File=D:\\Tomcat 5.5\\logs\\qc.log
log4j.appender.R.layout=org.apache.log4j.PatternLayout
1log4j.appender.R.layout.ConversionPattern=%d-[TS] %p %t %c - %m%n

log4j.logger.com.neusoft=DEBUG
log4j.logger.com.opensymphony.oscache=ERROR
log4j.logger.net.sf.navigator=ERROR
log4j.logger.org.apache.commons=ERROR
log4j.logger.org.apache.struts=WARN
log4j.logger.org.displaytag=ERROR
log4j.logger.org.springframework=DEBUG
log4j.logger.com.ibatis.db=WARN
log4j.logger.org.apache.velocity=FATAL

log4j.logger.com.canoo.webtest=WARN

log4j.logger.org.hibernate.ps.PreparedStatementCache=WARN
log4j.logger.org.hibernate=DEBUG
log4j.logger.org.logicalcobwebs=WARN

log4j.rootCategory=INFO, stdout , R

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[QC] %p [%t] %C.%M(%L) | %m%n

log4j.appender.R=org.apache.log4j.DailyRollingFileAppender
log4j.appender.R.File=D:\\Tomcat 5.5\\logs\\qc.log
log4j.appender.R.layout=org.apache.log4j.PatternLayout
1log4j.appender.R.layout.ConversionPattern=%d-[TS] %p %t %c - %m%n

log4j.logger.com.neusoft=DEBUG
log4j.logger.com.opensymphony.oscache=ERROR
log4j.logger.net.sf.navigator=ERROR
log4j.logger.org.apache.commons=ERROR
log4j.logger.org.apache.struts=WARN
log4j.logger.org.displaytag=ERROR
log4j.logger.org.springframework=DEBUG
log4j.logger.com.ibatis.db=WARN
log4j.logger.org.apache.velocity=FATAL

log4j.logger.com.canoo.webtest=WARN

log4j.logger.org.hibernate.ps.PreparedStatementCache=WARN
log4j.logger.org.hibernate=DEBUG
log4j.logger.org.logicalcobwebs=WARN
```





# Slf4j

[使用Slf4j而不是log4j](http://www.oschina.net/translate/why-use-sl4j-over-log4j-for-logging)

### BUG  不加入 commons-logging 会报错

```
java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory

```

解决：加入jar包依赖

```
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.6.1</version>
</dependency>
<dependency>
    <groupId>commons-logging</groupId>
    <artifactId>commons-logging</artifactId>
    <version>1.1.3</version>
</dependency>
```



