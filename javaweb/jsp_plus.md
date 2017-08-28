# JSP番外篇

## JSTL标签库

JSTL标签库的使用是为弥补html标签的不足，规范自定义标签的使用而诞生的。使用JSLT标签的目的就是不希望在jsp页面中出现java逻辑代码

**分类**

- 核心标签(用得最多)
- 国际化标签(I18N格式化标签)
- 数据库标签(SQL标签，很少使用)
- XML标签(几乎不用)
- JSTL函数(EL函数)

### JSTL 核心标签库标签

一共有13个

- （1）表达式控制标签：out标签、set标签、remove标签、catch标签。
- （2）流程控制标签：if标签、choose标签、when标签、otherwise标签。
- （3）循环标签：forEach标签、forTokens标签。
- （4）URL操作标签：import标签、url标签、redirect标签、param标签。

在JSP页面引入核心标签库的代码为：

```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

#### 表达式控制标签 - out 标签

```
<c:out value=”字符串”>
<c:out value=”EL表达式”>
```

**属性**

> value 指定要输出的内容
> 
> escapeXml  Boolean值 默认为true 指定是否将一些括号、&等进行html编码后输出 
> 
> default  当value值为null时输出default值


#### set 标签

```<c:set>```标签用于把某一个对象存在指定的域范围内，或者将某一个对象存储到Map或者JavaBean对象中。

**属性**

> **value** 指定属性值
> 
> **var**	要设置的web域的属性名称
> 
> **scope**	指定属性所在的web域
> 
> **target**	用于指定要设置的对象，这个对象必须是javaBean或者Map对象
> 
> **property**	用于指定当前为对象设置的属性名称

**示例**

```
<c:set var="data1" value="xdp" scope="page"/>
<h1>${data1}</h1>

<c:set value="cc" property="name" target="${user}"/>
<h1><c:out value="${user.name}"/></h1>

<%
    Map map = new HashMap();
    request.setAttribute("map",map);
%>
<%--将data1/data2对象的值存储到map集合中 --%>

<c:set property="data1" value="map data1 test" target="${map}"/>
<c:set property="data2" value="map data2 test" target="${map}"/>

<h2>${map.data1}</h2>
<h2>${map.data2}</h2>
```

#### remove标签

```<c:remove>```标签主要用来从指定的JSP范围内移除指定的变量。

> ```
> <c:remove var=”变量名” [scope=”page|request|session|application”]/>
> 
> ```
> 
> 其中var属性是必须的，scope可以以省略。


**示例：**

```
<c:remove var="user"/>

<h1><c:out value="${user}" default="user is null"/></h1>

```

#### catch 标签

　　```<c:catch>```标签用于捕获嵌套在标签体中的内容抛出的异常。

**属性**

> var属性用于标识<c:catch>标签捕获的异常对象，它将保存在page这个Web域中。

**示例：**

把容易产生异常的代码放在<c:catch></c:catch>中，可以自定义一个变量errorInfo用于存储异常信息

```
<c:catch var="errorInfo">

    <%--实现了一段异常代码，向一个不存在的JavaBean中插入一个值--%>
    <c:set target="person" property="hao"></c:set>

</c:catch>

异常：<c:out value="${errorInfo}" /><br />

errorInfo.getMessage：<c:out value="${errorInfo.message}" /><br />
errorInfo.getCause：<c:out value="${errorInfo.cause}" /><br />
errorInfo.getStackTrace：<c:out value="${errorInfo.stackTrace}" />


```

#### 流程控制标签 - if标签

<c:if>标签和程序中的if语句作用相同，用来实现条件控制。


**属性**

- test属性用于存放判断的条件，一般使用EL表达式来编写。
- var属性用来存放判断的结果，类型为true或false。
- scopes属性用来指定var属性存放的范围。


**示例：**

```
<c:if test="${param.uname=='admin'}" var="adminchock" scope="session">
 
    <%--可以把adminchock的属性范围设置为session，
    这样就可以在其他的页面中得到adminchock的值，
    使用<c:if text=”${adminchock}”><c:if>判断，
    实现不同的权限。 --%>
 
    <c:out value="管理员欢迎您！"/>

</c:if>
<%--使用EL表达式得到adminchock的值，如果输入的用户名为admin将显示true。 --%>

${adminchock}

```

#### 流程控制标签——choose标签、when标签、otherwise标签











