# log4j2

## maven 依赖

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

## 配置

在 classpath 下查找 log4j2.xml 的配置文件

配置示例

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

使用全局异步日志 log4j2.component.properties 放在 resources/log4j2.component.properties

```
# 设置异步日志系统属性
log4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
```


## 参考

### Java 日志框架与 log4j2

https://www.jianshu.com/p/1b04924d8a1f

在spring boot项目中使用Log4j2

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!-- 排除spring boot默认日志logback -->
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- 引入log4j2依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```






