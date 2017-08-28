
### 常用元素

- <context-param> </context-param>
<!--context-param元素声明应用范围内的初始化参数-->

-  <listener></listener>
事件监听程序在建立、修改和删除会话或servlet环境时得到通知。
Listener元素指出事件监听程序类

-  <filter>
        <filter-name>Filter</filter-name>
        <filter-class>xx.xx.Filter</filter-class>
        <async-supported>true</async-supported>
</filter>
<!--过滤器元素将一个名字与一个实现javax.servlet.Filter接口的类相关联-->


-  <filter-mapping></filter-mapping>
 <!--一旦命名了一个过滤器，就要利用filter-mapping元素把它与一个或多个servlet或JSP页面相关联-->

**例如**
>   <filter>
        <filter-name>CharacterSetEncoding Filter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <async-supported>true</async-supported>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterSetEncoding Filter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

- <servlet></servlet>
 <!--在向servlet或JSP页面制定初始化参数或定制URL时，必须首先命名servlet或JSP页面。
 Servlet元素就是用来完成此项任务的-->

**例如**
 >  <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:x.xx.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>

-   <servlet-mapping></servlet-mapping>

 **例如**
 >  <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/web/*</url-pattern>
    </servlet-mapping>




### spring.xml
- <!-- applicationContext.xml文件中使用import的方式导入有模块配置文件 -->
<import resource=""/>

- <!-- 创建类 -->
<bean id="xxxx" class="x.xx.xxx.xxxx">
    <property name="xxxxsetting" value="xxxx" />
</bean>

-<context:component-scan base-package=""></context:component-scan>
> <context:component-scan base-package="com.chen.example">
        <context:exclude-filter type="regex"
            expression=".*\.[^.]*Controller" />
    </context:component-scan>











