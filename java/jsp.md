# Jsp

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



























