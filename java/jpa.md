# JPA

http://blog.csdn.net/zhangjunjie789/article/details/45117913

http://www.cnblogs.com/je-ge/p/6143134.html

## JPA规范

JPA作为一种规范——也就说JPA规范中提供的只是一些接口，显然接口不能直接拿来使用。虽然应用程序可以面向接口编程，但JPA底层一定需要某种JPA实现，否则JPA依然无法使用。

## Hibernate

而Hibernate是它的一种实现。除了Hibernate，还有EclipseLink(曾经的toplink)，OpenJPA等可供选择，所以使用Jpa的一个好处是，可以更换实现而不必改动太多代码。

## JPA 和 hibernate 的关系

hibernate主要实现了jpa，但也在jpa的基础上增强了一些功能，如果觉得jpa不够用，就用hibernate提供的功能。

*参考：* [JPA 和 hibernate 的关系](http://blog.csdn.net/caiyanzhi123/article/details/50827819)

## Spring Data JPA

 Data Jpa能够方便大家在不同的ORM框架中间进行切换而不要更改代码。并且Spring Data Jpa对Repository层封装的很好，可以省去不少的麻烦。

我们都知道，在使用持久化工具的时候，一般都有一个对象来操作数据库，在原生的Hibernate中叫做Session，在JPA中叫做EntityManager，在MyBatis中叫做SqlSession，通过这个对象来操作数据库。我们一般按照三层结构来看的话，Service层做业务逻辑处理，Dao层和数据库打交道，在Dao中，就存在着上面的对象。那么ORM框架本身提供的功能有什么呢？答案是基本的CRUD，所有的基础CRUD框架都提供，我们使用起来感觉很方便，很给力，业务逻辑层面的处理ORM是没有提供的，如果使用原生的框架，业务逻辑代码我们一般会自定义，会自己去写SQL语句，然后执行。在这个时候，Spring-data-jpa的威力就体现出来了，ORM提供的能力他都提供，ORM框架没有提供的业务逻辑功能Spring-data-jpa也提供，全方位的解决用户的需求。使用Spring-data-jpa进行开发的过程中，常用的功能，我们几乎不需要写一条sql语句，至少在我看来，企业级应用基本上可以不用写任何一条sql，当然spring-data-jpa也提供自己写sql的方式，这个就看个人怎么选择，都可以。我觉得都行。




persistence.xml 配置

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
    version="2.0">
    <persistence-unit name="SimplePU" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.ejb.HibernatePersistence</provider>
        <class>com.chen.jpademo.UserInfo</class>
        <class>com.chen.jpademo.AccountInfo</class>
        <properties>
            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver" />
            <property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/jpadb" />
            <property name="hibernate.connection.username" value="root" />
            <property name="hibernate.connection.password" value="admin" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
            <property name="hibernate.use_sql_comments" value="false" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
        </properties>
    </persistence-unit>
</persistence>
```

















