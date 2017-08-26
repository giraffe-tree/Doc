# Jsp

> 主要参考：[孤傲苍狼JavaWeb总结](http://www.cnblogs.com/xdp-gacl/tag/JavaWeb%E5%AD%A6%E4%B9%A0%E6%80%BB%E7%BB%93/)

## 原理

jsp翻译成的servlet继承 HttpJspBase，
HttpJspBase类(抽象类)是继承HttpServlet，并实现了HttpJspPage的部分方法

**JspPage** *extends Servle*
> public interface JspPage extends Servlet {
> 
> void jspInit();
> 
> void jspDestroy();
> 
> }

**HttpJspPage** *extends JspPage*
> public interface HttpJspPage extends JspPage {
> 
> void _jspService(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException;
>
> }



**HttpJspBase** *extends HttpServlet implements HttpJspPage*
> public abstract class HttpJspBase 
    extends HttpServlet 
    implements HttpJspPage {   
}

**例如：**
> index.jsp 转换为 index_jsp.java

> index_jsp.java(index_jsp这个类是继承 org.apache.jasper.runtime.HttpJspBase这个类)

> 然后编译得到.class 文件

Web服务器在调用jsp时，会给Jsp提供如下的8个java对象
> - PageContext pageContext;
- HttpSession session;
- ServletContext application;
- ServletConfig config;
- JspWriter out;
- Object page = this;
- HttpServletRequest request, 
- HttpServletResponse response



## 语法

#### JSP脚本表达式（expression）

-  <%= 变量或表达式 %>

#### JSP脚本片断

-  <% 多行java代码 %>

>  - JSP脚本片断中只能出现java代码，不能出现其它模板元素
> - 在一个JSP页面中可以有多个脚本片断，在两个或多个脚本片断之间可以嵌入文本、HTML标记和其他JSP元素
> - 单个脚本片断中的Java语句可以是不完整的，但是，多个脚本片断组合后的结果必须是完整的Java语句

#### JSP声明

- <%! java代码 %>

> JSP声明可用于定义JSP页面转换成的Servlet程序的静态代码块、成员变量和方法 

#### JSP注释
 
 - 显式注释：直接使用HTML风格的注释：<!- - 注释内容- ->
 - 隐式注释：直接使用JAVA的注释：//、/*……*/
 - JSP自己的注释：<%- - 注释内容- -%>

> HTML的注释在浏览器中查看源文件的时候是可以看得到的，而JAVA注释和JSP注释在浏览器中查看源文件时是看不到注释的内容的，这就是这三种注释的区别。

## JSP指令

**JSP指令（directive）是为JSP引擎而设计的，它们并不直接产生任何可见输出，而只是告诉引擎如何处理JSP页面中的其余部分。**

#### 三个指令：

- page指令
- Include指令
- taglib指令

#### 用法
　　
JSP指令的基本语法格式：

> **<%@ 指令 属性名="值" %>**

多个指令

> 例如：<%@ page contentType="text/html;charset=gb2312" import="java.util.Date"%>


### Page指令

 page指令用于定义JSP页面的各种属性，无论page指令出现在JSP页面中的什么地方，它作用的都是整个JSP页面，为了保持程序的可读性和遵循良好的编程习惯，page指令最好是放在整个JSP页面的起始位置。


**导包**
> 导入多个包：
> 
> <%@ page import="java.util.*,java.io.*,java.sql.*"%>


#### errorpage

> 为整个web应用设置错误处理页面
> 
> ```
  <error-page>
      <error-code>404</error-code>
      <location>/jsp/error.jsp </location>
  </error-page>
```


> 为单个页面设置错误处理
> 
> ```
<%@ page language="java" import="java.util.*" errorPage="/jsp/error.jsp" pageEncoding="UTF-8"%>
```

> 使用page指令的的isErrorPage属性显式声明页面为错误页面
>
> ``` 
> <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
> ```

> 将error.jsp页面显式声明为错误处理页面后，有什么好处呢，好处就是Jsp引擎在将jsp页面翻译成Servlet的时候，在Servlet的 _jspService方法中会声明一个exception对象，然后将运行jsp出错的异常信息存储到exception对象中
> 
> - 如果没有设置isErrorPage="true"，那么在jsp页面中是无法使用exception对象的，因为在Servlet的_jspService方法中不会声明一个exception对象


### include 指令

在JSP中对于包含有两种语句形式：

- @include 指令
- \<jsp:include\> 指令

include指令用于引入其它JSP页面，如果使用include指令引入了其它JSP页面，那么JSP引擎将把这两个JSP翻译成一个servlet。所以include指令引入通常也称之为静态引入。



**语法：**

```
<%@ include file="relativeURL"%>
```
*例如：*
 
> <%@include file="/jsp/jspf/end.jspf" %>

**include指令细节注意问题：**

1. 被引入的文件必须遵循JSP语法。
2. 被引入的文件可以使用任意的扩展名，即使其扩展名是html，JSP引擎也会按照处理jsp页面的方式处理它里面的内容，为了见明知意，JSP规范建议使用.jspf（JSP fragments(片段)）作为静态引入文件的扩展名。
3. 由于使用include指令将会涉及到2个JSP页面，并会把2个JSP翻译成一个servlet，所以这2个JSP页面的指令不能冲突（除了pageEncoding和导包除外）。
4. jspf文件最好加上文件编码，否则可能会出现乱码(或者也filter中统一处理编码)


**jsp:include**

```
<jsp:include page="head.jsp"/>
```

jsp:include指令为动态包含，如果被包含的页面是JSP，则先处理之后再将结果包含，生成两个servlet，通过request和reponse进行的通信。而如果包含的是非*.jsp文件，则只是把文件内容静态包含进来，功能与@include类似。


\<%@include%\>：页面请求之前预编译，所有代码包含进来之后，一起进行处理，把所有代码合在一起，编译成一个servlet
\<jsp:include\>：所有代码分别处理，在页面被请求的时候才编译，被编译成多个servlet，页面语法相对独立，处理完成之后再将代码的显示结果（处理结果）组合进来。

### JSP中的九个内置对象


1.	**pageContext**	- javax.servlet.jsp.PageContext
2.	**request** - 	javax.servlet.http.HttpServletRequest
3.	**response**	- javax.servlet.http.HttpServletResponse
4.	**session**	- javax.servlet.http.HttpSession
5.	**application** - 	javax.servlet.ServletContext
6.	**config**	- javax.servlet.ServletConfig
7.	**out**	 - javax.servlet.jsp.JspWriter
8.	**page**	- java.lang.Object
9.	**exception**	- java.lang.Throwable


#### page 对象

page对象表示当前一个JSP页面，可以理解为一个对象本身，即：把一个JSP当作一个对象来看待。page对象在开发中几乎不用，了解一下即可



