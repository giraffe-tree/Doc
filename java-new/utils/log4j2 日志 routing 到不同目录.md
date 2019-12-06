# log4j2 不同类别输出到不同目录

## 概述

本文主要介绍 log4j2 使用 marker, routing, filter 来输出不同格式/不同目录/指定年月日分隔的日志, 基本上看下配置文件实操一下就明白怎么做了.

使用框架的是 Slf4j + log4j2 + lombok

源码地址 [boom-java](https://github.com/giraffe-tree/boom-java/blob/master/src/main/java/me/giraffetree/java/boomjava/utils/log/Log4j2Test.java)

来源于公司中记录 mqtt 日志的项目

## 内容

使用后得到的日志文件目录如下

![](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/blog/2019/12/log4j2_log_tree.jpg)

### maven 依赖

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

### java 代码

```java
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GiraffeTree
 * @date 2019/12/5
 */
@Slf4j
public class Log4j2Test {

    private final static Marker BOY = MarkerFactory.getMarker("boy");
    private final static Marker GIRL = MarkerFactory.getMarker("girl");
    private final static Marker OTHER = MarkerFactory.getMarker("other");

    public static void main(String[] args) {

        testRouting(1000, 3);

    }

    public static void addRandomLog() {
        int num = ThreadLocalRandom.current().nextInt(0, 1000);
        if (num < 950) {
            ThreadContext.put("logFileName", "David");
            log.info("current: {}", num);
        } else {
            log.error("current: {}", num);
        }
    }

    public static void testRouting(int loopCount, int userSize) {
        long l1 = System.currentTimeMillis();
        int count = loopCount;
        while (count > 0) {
            writeMultipleUsersLog(userSize);
            count--;
        }

        long l2 = System.currentTimeMillis();
        System.out.println(String.format("size:%d loopCount:%d cost: %dms", userSize, loopCount, l2 - l1));
    }

    public static void writeMultipleUsersLog(int size) {
        for (int i = 0; i < size; i++) {
            String userName = "user" + i;
            ThreadContext.put("logFileName", userName);
            int num = ThreadLocalRandom.current().nextInt(0, 1200);
            if (num < 500) {
                log.info(BOY, "current: {}", num);
            } else if (num < 1000) {
                log.info(GIRL, "current: {}", num);
            } else {
                log.info(OTHER, "current: {}", num);
            }
        }
    }

}
```

### xml 配置文件

文件路径 `resources/log4j2.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>

    <Properties>
        <!-- 日志输出级别 -->
        <Property name="LOG_INFO_LEVEL" value="info"/>
        <!-- error级别日志 -->
        <Property name="LOG_ERROR_LEVEL" value="error"/>
        <!-- 在当前目录下创建名为log目录做日志存放的目录 -->
        <Property name="LOG_HOME" value="./log"/>
        <!-- 档案日志存放目录 -->
        <Property name="LOG_ARCHIVE_NAME" value="archive"/>
        <!-- 模块名称， 影响日志配置名，日志文件名，根据自己项目进行配置 -->
        <Property name="LOG_MODULE_NAME" value="boom-java"/>
        <!-- 日志文件大小，超过这个大小将被压缩 -->
        <Property name="LOG_MAX_SIZE" value="1 MB"/>
        <!-- 保留多少天以内的日志 -->
        <Property name="LOG_DAYS" value="15"/>
        <!--输出日志的格式：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度， %msg：日志消息，%n是换行符 -->
        <Property name="LOG_PATTERN" value="%d [%t] %-5level %logger{0} - %msg%n"/>

        <!-- mqtt log -->
        <Property name="MQTT_LOG_PATTERN" value="%msg%n"/>

        <!--interval属性用来指定多久滚动一次-->
        <Property name="TIME_BASED_INTERVAL" value="1"/>
    </Properties>

    <Appenders>
        <!-- 控制台输出 -->
        <Console name="STDOUT" target="SYSTEM_OUT">
            <!--输出日志的格式-->
            <PatternLayout pattern="${LOG_PATTERN}"/>
            <!--控制台只输出level及其以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
            <ThresholdFilter level="${LOG_INFO_LEVEL}" onMatch="ACCEPT" onMismatch="DENY"/>
        </Console>

        <!-- 这个会打印出所有的info级别以上，error级别一下的日志，每次大小超过size或者满足TimeBasedTriggeringPolicy，则日志会自动存入按年月日建立的文件夹下面并进行压缩，作为存档-->
        <!--异步日志会自动批量刷新，所以将immediateFlush属性设置为false-->
        <Routing name="BoyRoutingAppender">
            <Routes pattern="${ctx:logFileName}">
                <Route>
                    <RollingRandomAccessFile name="RollingRandomAccessFileInfo2"
                                             fileName="${LOG_HOME}/${date:yyyy}/${date:MM}/${date:dd}/boy/${ctx:logFileName}-info.log"
                                             filePattern="${LOG_HOME}/${date:yyyy}/%d{MM}/%d{dd}/boy/${LOG_ARCHIVE_NAME}/${ctx:logFileName}-info-%i.log.gz"
                                             immediateFlush="false">
                        <Filters>
                            <MarkerFilter marker="boy" onMatch="ACCEPT" onMismatch="DENY"/>
                            <!--如果是error级别拒绝，设置 onMismatch="NEUTRAL" 可以让日志经过后续的过滤器-->
                            <ThresholdFilter level="${LOG_ERROR_LEVEL}" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <!--如果是info\warn输出-->
                            <ThresholdFilter level="${LOG_INFO_LEVEL}" onMatch="ACCEPT" onMismatch="NEUTRAL"/>
                        </Filters>
                        <PatternLayout pattern="${MQTT_LOG_PATTERN}"/>
                        <Policies>
                            <!--interval属性用来指定多久滚动一次，根据当前filePattern设置是1天滚动一次-->
                            <TimeBasedTriggeringPolicy interval="${TIME_BASED_INTERVAL}"/>
                            <SizeBasedTriggeringPolicy size="${LOG_MAX_SIZE}"/>
                        </Policies>
                        <!-- DefaultRolloverStrategy属性如不设置，则默认同一文件夹下最多保存7个文件-->
                        <DefaultRolloverStrategy max="${LOG_DAYS}"/>
                    </RollingRandomAccessFile>
                </Route>
            </Routes>
        </Routing>

        <Routing name="GirlRoutingAppender">
            <Routes pattern="${ctx:logFileName}">
                <Route>
                    <RollingRandomAccessFile name="RollingRandomAccessFileInfo2"
                                             fileName="${LOG_HOME}/${date:yyyy}/${date:MM}/${date:dd}/girl/${ctx:logFileName}-info.log"
                                             filePattern="${LOG_HOME}/${date:yyyy}/%d{MM}/%d{dd}/girl/${LOG_ARCHIVE_NAME}/${ctx:logFileName}-info-%i.log.gz"
                                             immediateFlush="false">
                        <Filters>
                            <MarkerFilter marker="girl" onMatch="ACCEPT" onMismatch="DENY"/>
                            <!--如果是error级别拒绝，设置 onMismatch="NEUTRAL" 可以让日志经过后续的过滤器-->
                            <ThresholdFilter level="${LOG_ERROR_LEVEL}" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <!--如果是info\warn输出-->
                            <ThresholdFilter level="${LOG_INFO_LEVEL}" onMatch="ACCEPT" onMismatch="NEUTRAL"/>
                        </Filters>
                        <PatternLayout pattern="${MQTT_LOG_PATTERN}"/>
                        <Policies>
                            <!--interval属性用来指定多久滚动一次，根据当前filePattern设置是1天滚动一次-->
                            <TimeBasedTriggeringPolicy interval="${TIME_BASED_INTERVAL}"/>
                            <SizeBasedTriggeringPolicy size="${LOG_MAX_SIZE}"/>
                        </Policies>
                        <!-- DefaultRolloverStrategy属性如不设置，则默认同一文件夹下最多保存7个文件-->
                        <DefaultRolloverStrategy max="${LOG_DAYS}"/>
                    </RollingRandomAccessFile>
                </Route>

            </Routes>
        </Routing>

        <Routing name="OtherRoutingAppender">
            <Routes pattern="${ctx:logFileName}">
                <Route>
                    <RollingRandomAccessFile name="RollingRandomAccessFileInfo2"
                                             fileName="${LOG_HOME}/${date:yyyy}/${date:MM}/${date:dd}/other/${ctx:logFileName}-info.log"
                                             filePattern="${LOG_HOME}/${date:yyyy}/%d{MM}/%d{dd}/other/${LOG_ARCHIVE_NAME}/${ctx:logFileName}-info-%i.log.gz"
                                             immediateFlush="false">
                        <Filters>
                            <MarkerFilter marker="other" onMatch="ACCEPT" onMismatch="DENY"/>
                            <!--如果是error级别拒绝，设置 onMismatch="NEUTRAL" 可以让日志经过后续的过滤器-->
                            <ThresholdFilter level="${LOG_ERROR_LEVEL}" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <!--如果是info\warn输出-->
                            <ThresholdFilter level="${LOG_INFO_LEVEL}" onMatch="ACCEPT" onMismatch="NEUTRAL"/>
                        </Filters>
                        <PatternLayout pattern="${MQTT_LOG_PATTERN}"/>
                        <Policies>
                            <!--interval属性用来指定多久滚动一次，根据当前filePattern设置是1天滚动一次-->
                            <TimeBasedTriggeringPolicy interval="${TIME_BASED_INTERVAL}"/>
                            <SizeBasedTriggeringPolicy size="${LOG_MAX_SIZE}"/>
                        </Policies>
                        <!-- DefaultRolloverStrategy属性如不设置，则默认同一文件夹下最多保存7个文件-->
                        <DefaultRolloverStrategy max="${LOG_DAYS}"/>
                    </RollingRandomAccessFile>
                </Route>

            </Routes>
        </Routing>

        <Routing name="RoutingAppender">
            <Routes pattern="${ctx:logFileName}">
                <Route>
                    <RollingRandomAccessFile name="RollingRandomAccessFileInfo"
                                             fileName="${LOG_HOME}/${date:yyyy}/${date:MM}/${date:dd}/${ctx:logFileName}-info.log"
                                             filePattern="${LOG_HOME}/${date:yyyy}/%d{MM}/%d{dd}/${LOG_ARCHIVE_NAME}/${ctx:logFileName}-info-%i.log.gz"
                                             immediateFlush="false">
                        <Filters>
                            <MarkerFilter marker="other" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <MarkerFilter marker="boy" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <MarkerFilter marker="girl" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <!--如果是error级别拒绝，设置 onMismatch="NEUTRAL" 可以让日志经过后续的过滤器-->
                            <ThresholdFilter level="${LOG_ERROR_LEVEL}" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <!--如果是info\warn输出-->
                            <ThresholdFilter level="${LOG_INFO_LEVEL}" onMatch="ACCEPT" onMismatch="DENY"/>
                        </Filters>
                        <PatternLayout pattern="${LOG_PATTERN}"/>
                        <Policies>
                            <!--interval属性用来指定多久滚动一次，根据当前filePattern设置是1天滚动一次-->
                            <TimeBasedTriggeringPolicy interval="${TIME_BASED_INTERVAL}"/>
                            <SizeBasedTriggeringPolicy size="${LOG_MAX_SIZE}"/>
                        </Policies>
                        <!-- DefaultRolloverStrategy属性如不设置，则默认同一文件夹下最多保存7个文件-->
                        <DefaultRolloverStrategy max="${LOG_DAYS}"/>
                    </RollingRandomAccessFile>
                </Route>

                <Route ref="STDOUT" key="${ctx:logFileName}"/>
            </Routes>
        </Routing>

        <!--只记录error级别以上的日志，与info级别的日志分不同的文件保存-->
        <RollingRandomAccessFile name="RollingRandomAccessFileError"
                                 fileName="${LOG_HOME}/${LOG_MODULE_NAME}-errorLog.log"
                                 filePattern="${LOG_ARCHIVE}/${LOG_MODULE_NAME}-errorLog-%d{yyyy-MM-dd}-%i.log.gz"
                                 immediateFlush="false">
            <Filters>
                <ThresholdFilter level="${LOG_ERROR_LEVEL}" onMatch="ACCEPT" onMismatch="DENY"/>
            </Filters>
            <PatternLayout pattern="${LOG_PATTERN}"/>
            <Policies>
                <TimeBasedTriggeringPolicy interval="${TIME_BASED_INTERVAL}"/>
                <SizeBasedTriggeringPolicy size="${LOG_MAX_SIZE}"/>
            </Policies>
            <DefaultRolloverStrategy max="${LOG_DAYS}"/>
        </RollingRandomAccessFile>
    </Appenders>

    <Loggers>
        <!-- 开发环境使用 -->
        <!--<Root level="${LOG_INFO_LEVEL}">
            <AppenderRef ref="STDOUT"/>
        </Root>-->

        <!-- 生产环境使用 -->
        <Root level="${LOG_INFO_LEVEL}" includeLocation="false">
            <AppenderRef ref="RoutingAppender"/>
            <AppenderRef ref="OtherRoutingAppender"/>
            <AppenderRef ref="BoyRoutingAppender"/>
            <AppenderRef ref="GirlRoutingAppender"/>
            <AppenderRef ref="RollingRandomAccessFileError"/>
        </Root>
    </Loggers>

</Configuration>
```

## 常见问题

### Multiple default routes. Route Route(type=dynamic - type=Route default) will be ignored

```xml
<Routes pattern="${ctx:logFileName}">
   	<Route>
                ...
    </Route>
    <Route>
                ...
    </Route>
</Routes> 
```

Routes 节点内有多个Route ,  且 Route 的 key 没有指定, 导致 logj4j 认为有多个默认的 Route

应该写成

```xml
<Routes pattern="${ctx:logFileName}">
   	<Route key="specialFileName01">
                ...
    </Route>
    <Route>
                ...
    </Route>
</Routes> 
```

### SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder / log4j:WARN No appenders could be found for logger

pom 中添加 log4j-slf4j-impl 依赖, 注意 scope

## 其他参考

1. How to write different logs in different files with log4j2 (MDC in xml)?
	- https://stackoverflow.com/questions/17827923/how-to-write-different-logs-in-different-files-with-log4j2-mdc-in-xml

2. How do I dynamically write to separate log files?

	- http://logging.apache.org/log4j/2.x/faq.html#separate_log_files

```xml
<Routing name="Routing">
  <Routes pattern="$${ctx:ROUTINGKEY}">
 
    <!-- This route is chosen if ThreadContext has value 'special' for key ROUTINGKEY. -->
    <Route key="special">
      <RollingFile name="Rolling-${ctx:ROUTINGKEY}" fileName="logs/special-${ctx:ROUTINGKEY}.log"
	filePattern="./logs/${date:yyyy-MM}/${ctx:ROUTINGKEY}-special-%d{yyyy-MM-dd}-%i.log.gz">
	<PatternLayout>
	  <pattern>%d{ISO8601} [%t] %p %c{3} - %m%n</pattern>
	</PatternLayout>
	<Policies>
	  <TimeBasedTriggeringPolicy interval="6" modulate="true" />
          <SizeBasedTriggeringPolicy size="10 MB" />
	</Policies>
      </RollingFile>
    </Route>
 
    <!-- This route is chosen if ThreadContext has no value for key ROUTINGKEY. -->
    <Route key="$${ctx:ROUTINGKEY}">
      <RollingFile name="Rolling-default" fileName="logs/default.log"
	filePattern="./logs/${date:yyyy-MM}/default-%d{yyyy-MM-dd}-%i.log.gz">
        <PatternLayout>
	  <pattern>%d{ISO8601} [%t] %p %c{3} - %m%n</pattern>
        </PatternLayout>
        <Policies>
          <TimeBasedTriggeringPolicy interval="6" modulate="true" />
          <SizeBasedTriggeringPolicy size="10 MB" />
        </Policies>
      </RollingFile>
    </Route>
 
    <!-- This route is chosen if ThreadContext has a value for ROUTINGKEY
         (other than the value 'special' which had its own route above).
         The value dynamically determines the name of the log file. -->
    <Route>
      <RollingFile name="Rolling-${ctx:ROUTINGKEY}" fileName="logs/other-${ctx:ROUTINGKEY}.log"
	filePattern="./logs/${date:yyyy-MM}/${ctx:ROUTINGKEY}-other-%d{yyyy-MM-dd}-%i.log.gz">
	<PatternLayout>
	  <pattern>%d{ISO8601} [%t] %p %c{3} - %m%n</pattern>
	</PatternLayout>
	<Policies>
	  <TimeBasedTriggeringPolicy interval="6" modulate="true" />
	  <SizeBasedTriggeringPolicy size="10 MB" />
	</Policies>
      </RollingFile>
    </Route>
  </Routes>
</Routing>
```




