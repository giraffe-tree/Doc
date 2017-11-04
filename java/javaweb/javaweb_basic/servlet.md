*参考：*
> [web.xml详解](http://blog.csdn.net/believejava/article/details/43229361)

> [web.xml详解](http://www.cnblogs.com/hellojava/archive/2012/12/28/2835730.html)

[servlet工作原理解析](https://www.ibm.com/developerworks/cn/java/j-lo-servlet/)

#Servlet



## servlet  初始化

**load-on-startup**属性
1. load-on-startup元素标记容器是否在启动的时候就加载这个servlet(实例化并调用其init()方法)。
2. 它的值必须是一个整数，表示servlet应该被载入的顺序
3. 当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；
4. 当值小于0或者没有指定时，则表示容器在该servlet被选择(访问时)才会去加载。
5. 正数的值越小，该servlet的优先级越高，应用启动时就越先加载。
6. 当值相同时，容器就会自己选择顺序来加载

## servletConfig

**init-param**
当servlet配置了初始化参数init-param后，web容器在创建servlet实例对象时，会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，将ServletConfig对象传递给servlet。

## servletContext

可以再web.xml为context配置初始化参数

　　WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。ServletConfig对象中维护了ServletContext对象的引用,一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯.
　　
#### 利用ServletContext对象读取资源文件



## servlet 响应请求的过程

>

1. 浏览器连接web服务器，向Servlet容器发出Http请求；
2. Servlet容器解析Web客户想访问的主机，想访问的web应用，想访问的web资源；
3. Servlet容器创建一个HttpRequest对象，在这个对象中封装Http请求信息；
4. Servlet容器创建一个HttpResponse对象；
5. Servlet容器调用Servlet中的service方法，把HttpRequest和HttpResponse对象作为service方法的参数传给HttpServlet对象；
6. Servlet调用HttpRequest的有关方法，获取HTTP请求信息；
7. Servlet调用HttpResponse的有关方法，生成响应数据；
8. Servlet容器把Servlet的响应结果传给Web客户。

创建servlet对象 init srevice

### 多线程响应

线程不安全，如果使用锁则可能会导致多个人排队等待，不可取。

使用singleThreadModel 接口

- singleThreadModel接口 ：它本身是个空接口，它保证一个特定的servlet实例的service方法在一个时刻技能被一个线程执行。servlet2.4已经将SingleThreadModel标记为Deprecated。

对于实现了SingleThreadModel接口的Servlet，Servlet引擎仍然支持对该Servlet的多线程并发访问，其采用的方式是产生多个Servlet实例对象，并发的每个线程分别调用一个独立的Servlet实例对象。

#### 实例数量

对于默认servlet，servlet容器对每一个servlet声明必须且只能产生一个实例



### 生命周期

Servlet是按照一个严格定义的生命周期被管理，该生命周期规定了Servlet如何被加载、实例化、初始化、处理客户端请求，以及何时结束服务

所有Servlet必须直接或间接的实现GenericServlet或HttpServlet抽象类。

## servlet接口

## ServlerContext

默认的servletContext是非分布式的且仅存在于一个JVM中

#### 方法

1.  getInitParameter / getInitParameterNames 初始化参数

## Listener

空接口 EventListener

主要分为两类事件

1. 由某个操作事件触发 EvenListeners
    - servletContextAttributeListener
        > servletContext.setAttribute/removeAttribute 调用时触发

    - servletRequestAttributeListener
        > 在request.setAttribute/removeAttribute 调用时触发

    - servletRequestListener
        > 在request初始化，被销毁时调用
    - HttpSessionAttributeListener
        > sessionsetAttribute/removeAttribute 调用时触发


2. 由生命周期中的不同状态触发 LifecycleListeners
    - ServletContextListener
        > context 容器初始化、被销毁时调用
    - HttpSessionListener
        > session 被创建，失效时调用

## Filter

过滤器是一种代码重用的技术，它可以改变HTTP请求的内容，响应，及header信息.

filter提供了request，response，FilterChain对象

**接口：**

Filter：

- init(FilterConfig) 初始化filter时调用
- doFilter(ServletRequest,ServletRespnse)
- destory

FilterConfig

- 可以得到初始化参数名称
- 可以得到容器环境类ServletContext
- 可以得到filter名称


**FilterChain：**
tomcat内部过滤器采用了 **责任链** 的设计模式

> 当Wrapper执行FilterChain的doFilter(request,response)方法时，FilterChain首先调用第一个Filter的doFilter(request,response,filterchain)方法，当第一个filter做完过滤操作后，它又会调用filterchain的doFilter方法，此时filterchain的当前filter已变为第二个filter，第二个filter又执行dofilter方法，依此类推，直至所有过滤器都执行完毕。

FilterChain中只有一个方法 doFilter(ServletRequest,ServletRespnse) ，实现类为 ApplicationFilterChain

ApplicationFilterChain在ApplicationFilterConfig[] 数组中 保存了到最终servlet的所有filter对象，

## 读取资源文件

[读取资源文件](http://blog.csdn.net/mr_li13/article/details/48598361)

**读取资源文件的三种方式**

- 利用properties.load(servletContext.getResourceAsStream(path));
> 特点：读取应用中任何文件。只能在Web环境下用。*可以读取任何路径下的propertist文件
- 利用ResourceBundle读取配置文件
>特点：可以用在非web环境下。*但是只能读取类路径中的properties文件
- 利用类加载器读取配置文件（专业）
> 特点：可以用在非web环境下。*可以读取类路径下的任何文件。

## servlet3.0 注解

### web.xml配置
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                      http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
  version="3.0">
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

### @WebServlet
```
@WebServlet(name = "TestServlet", value = "/TestServlet", initParams = { @WebInitParam(name = "name", value = "cc"),
        @WebInitParam(name = "test", value = "testInitParam") },asyncSupported = false)
```

> 1.   asyncSupported  声明Servlet是否支持异步操作模式
2.  description Servlet的描述信息
3.  displayName Servlet的显示名称
4.   initParams  Servlet的初始化参数
5.  name    Servlet的名称
6.   urlPatterns Servlet的访问URL
7.   value   Servlet的访问URL



## servlet 域

1. servletContext
2. request
3. session
4. pageContext


## 注意要点

1. jsp 文件放在WEB-INF 文件夹下是不允许直接访问的。


## 记录一些奇葩的错误

### A child container failed during start
>最后发现是filter中配置错了，当value和urlPatterns同时出现时就会出错。。。然后tomcat怎么也启动不起来，各种子容器启动失败。解决：只要在value和urlPatterns中去掉一个就好



>
>

 -------------------

## servlet

javax-servlet
了解listener，filter，servlet机制
了解servletcontext，整个servlet 包的机制

=======
## servlet

### servlet 整体架构  依赖包含

### servlet 的执行流程  ————将servlet 发布到tomcat中执行实验

### 重点理解 listener ，filter，servlet，servletcontext 方法
### 理解 httpserletrequest，httpservletresponse 等基于http协议的方法、类


### 补充了解 http协议，200,301,302,400,403,405,500
### 了解http协议响应机制，了解tcp/  ip 协议族

tomcat中有多层容器的结构，一层一层地从大到小初始化，直到初始化到context容器（在tomcat中context容器对应一个web应用），当context初始化中，会先初始化contextConfig类，它会解析web.xml配置，读取host，还有自身的一些配置文件，然后，context容器会执行startInternal方法，会创建读取资源文件的对象，启动log，resource等辅助类，再进行子容器的初始化，最后初始化相应的servlet。

