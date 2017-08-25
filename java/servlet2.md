## servlet3.0 注解

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
2.

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

