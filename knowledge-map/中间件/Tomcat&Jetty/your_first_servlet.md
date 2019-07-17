# Servlet

## 下载 tomcat

### 目录

/bin：存放 Windows 或 Linux 平台上启动和关闭 Tomcat 的脚本文件。
/conf：存放 Tomcat 的各种全局配置文件，其中最重要的是 server.xml。
/lib：存放 Tomcat 以及所有 Web 应用都可以访问的 JAR 文件。
/logs：存放 Tomcat 执行时产生的日志文件。
/work：存放 JSP 编译后产生的 Class 文件。
/webapps：Tomcat 的 Web 应用目录，默认情况下把 Web 应用放在这个目录下。

## 编写 servlet 启动运行

### 编写一个继承 HttpServlet 的 Java 类

```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myAnnotationServlet")
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("AnnotationServlet process get...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.println("<strong>Annotation Servlet!</strong><br>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("AnnotationServlet process post...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.println("<strong>Annotation Servlet!</strong><br>");

    }
}  
```

编译, `servlet-api.jar` 来自tomcat的lib目录下

```sh
# 指定 utf-8 编码, 防止乱码
javac -encoding UTF-8 -cp ./servlet-api.jar AnnotationServlet.java
```

将编译好的 `AnnotationServlet.class` 放入下面的路径, 其中 webapps 是 tomcat 主路径下的一个子文件夹.

```
webapps/MyWebApp/WEB-INF/classes/AnnotationServlet.class
```

启动

```
startup.bat
```

打开链接: http://localhost:8080/MyWebApp/myAnnotationServlet

完成!

