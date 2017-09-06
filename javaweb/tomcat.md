

当tomcat启动spring项目时

```
九月 06, 2017 9:05:12 上午 org.apache.catalina.core.ApplicationContext log
信息:Spring WebApplicationInitializers detected on classpath
九月 06, 2017 9:05:12 上午 org.apache.catalina.core.ApplicationContext log
信息: Initializing Spring root WebApplicationContext

...

九月 06, 2017 9:05:25 上午 org.apache.catalina.core.ApplicationContext log
信息: Initializing Spring FrameworkServlet 'dispatcher'

```


解决：

facet 配置

tomcat clean ，重启


