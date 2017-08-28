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

###


## servlet 域

1. servletContext
2. request
3. session
4. pageContext




## 注意要点

1. jsp 文件放在WEB-INF 文件夹下是不允许直接访问的。
2.



## 记录一些奇葩的错误

### A child container failed during start
>最后发现是filter中配置错了，当value和urlPatterns同时出现时就会出错。。。然后tomcat怎么也启动不起来，各种子容器启动失败。解决：只要在value和urlPatterns中去掉一个就好

