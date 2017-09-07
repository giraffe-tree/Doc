# LOG 日志

## 常用日志框架

[常用的日志框架](http://blog.csdn.net/k1280000/article/details/65511531)

### log4j

Log4j应该是出现比较早而且最受欢迎的java日志，Log4j可以允许你非常便捷地自定义日志格式和日志等级，可以帮助开发人员全方位的掌控自己的日志信息。

### Logback

Logback是由Log4j创始人设计的另一个开源日志组件，也是作为Log4j的替代者出现的。而且官方是建议和Slf4j一起使用，你们一定不知道Logback、slf4j、Log4j都是出自同一个人吧。 Logback是在Log4j的基础上做的改进版本，而Slf4j又是同一个人设计的，所以默认就对Slf4j无缝结合。

## 统一日志模块


### SLF4j

SLF4j（Simple Logging Facade For Java）是基于API的java日志框架，SLF4j提供了一个简单统一的日 
志记录接口，开发者在配置和部署时，只需要实现这个接口就可以实现日志功能。可以说，它并不是一个具体的日志解决方案，它只是服务于各种各样的日志系统，允许最终用户在部署应用上使用自己常用的日志系统


### Commons-Logging

Common-logging 为众多具体的日志实现库提供了一个统一的接口，和SLF4j的作用类似，它允许在运行时绑定任意的日志库； 

这里其实有个小故事，当年apache说服Log4j以及其他的日志框架按照Commons-Logging的标准来编写，但是由于Commons-Logging的类加载有点问题，实现起来不友好。因此Log4j的作者就创作了Slf4j，也因此与Commons-Logging两份天下


## Logback + slf4j 配置

[配置详解](http://blog.csdn.net/claram/article/details/48066395)

[多个日志体系的使用](http://www.ixirong.com/2016/03/13/intro-to-java-log/)














