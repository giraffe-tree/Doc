# JPA

http://blog.csdn.net/zhangjunjie789/article/details/45117913

http://www.cnblogs.com/je-ge/p/6143134.html

【原创】纯干货，Spring-data-jpa详解，全方位介绍。
http://www.cnblogs.com/dreamroute/p/5173896.html

## JPA规范

JPA作为一种规范——也就说JPA规范中提供的只是一些接口，显然接口不能直接拿来使用。虽然应用程序可以面向接口编程，但JPA底层一定需要某种JPA实现，否则JPA依然无法使用。

## Hibernate

而Hibernate是它的一种实现。除了Hibernate，还有EclipseLink(曾经的toplink)，OpenJPA等可供选择，所以使用Jpa的一个好处是，可以更换实现而不必改动太多代码。

## JPA 和 hibernate 的关系

hibernate主要实现了jpa，但也在jpa的基础上增强了一些功能，如果觉得jpa不够用，就用hibernate提供的功能。

*参考：* [JPA 和 hibernate 的关系](http://blog.csdn.net/caiyanzhi123/article/details/50827819)

## Spring Data JPA

 Data Jpa能够方便大家在不同的ORM框架中间进行切换而不要更改代码。并且Spring Data Jpa对Repository层封装的很好，可以省去不少的麻烦。

我们都知道，在使用持久化工具的时候，一般都有一个对象来操作数据库，在原生的Hibernate中叫做Session，在JPA中叫做EntityManager，在MyBatis中叫做SqlSession，通过这个对象来操作数据库。我们一般按照三层结构来看的话，Service层做业务逻辑处理，Dao层和数据库打交道，在Dao中，就存在着上面的对象。那么ORM框架本身提供的功能有什么呢？答案是基本的CRUD，所有的基础CRUD框架都提供，我们使用起来感觉很方便，很给力，业务逻辑层面的处理ORM是没有提供的，如果使用原生的框架，业务逻辑代码我们一般会自定义，会自己去写SQL语句，然后执行。在这个时候，Spring-data-jpa的威力就体现出来了，ORM提供的能力他都提供，ORM框架没有提供的业务逻辑功能Spring-data-jpa也提供，全方位的解决用户的需求。使用Spring-data-jpa进行开发的过程中，常用的功能，我们几乎不需要写一条sql语句，至少在我看来，企业级应用基本上可以不用写任何一条sql，当然spring-data-jpa也提供自己写sql的方式，这个就看个人怎么选择. 但是使用jpa在启动时会比 mybatis 慢一些.




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


## JPA 动态查询

https://docs.spring.io/spring-data/jpa/docs/1.11.7.RELEASE/reference/html/#specifications

[specification 详解](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-four-jpa-criteria-queries/)

## Querydsl and specification

http://blog.csdn.net/ro_wsy/article/details/51345875


## Specification

### Root

Root接口：代表Criteria查询的根对象

### CriteriaBulider

CriteriaBuilder接口：用来构建CritiaQuery的构建器对象

CriteriaBuilder也作为Predicate实例的工厂，通过调用CriteriaBuilder 的条件方法（ equal，notEqual， gt， ge，lt， le，between，like等）创建Predicate对象。


### CriteriaQuery

CriteriaQuery接口：代表一个specific的顶层查询对象，它包含着查询的各个部分，比如：select 、from、where、group by、order by等

调用CriteriaQuery的from方法可以获得Root实例


### 给findAll排序

```
  import org.springframework.data.domain.Sort;

   @Repository
   public class StudentServiceImpl implements StudentService {
       @Autowired
       private StudentDAO studentDao;

       @Override
       public List<Student> findAll() {
           return studentDao.findAll(sortByIdAsc());
       }

       private Sort sortByIdAsc() {
           return new Sort(Sort.Direction.ASC, "id");
       }
   } 

```
   
   
## 一. 动态查询

[spring-data-examples SpringJpa官方示例](https://github.com/spring-projects/spring-data-examples)

[Spring Data JPA Tutorial: Creating Database Queries With the JPA Criteria API](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-four-jpa-criteria-queries/)

[JpaSpecificationExecutor java api doc](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaSpecificationExecutor.html)

首先需要我们知道的是要使用动态查询必须要用到```JpaSpecificationExecutor ```接口

下面是这个接口的定义,已经我加上的英文注释(来自 api 文档)
```
public interface JpaSpecificationExecutor<T> {
    //Returns a single entity matching the given Specification or Optional.empty() if none found.
    T findOne(Specification<T> var1);
    
    //Returns all entities matching the given Specification.
    List<T> findAll(Specification<T> var1);
    
    //Returns a Page of entities matching the given Specification.
    Page<T> findAll(Specification<T> var1, Pageable var2);
    
    //Returns all entities matching the given Specification and Sort.
    List<T> findAll(Specification<T> var1, Sort var2);
    
    //Returns the number of instances that the given Specification will return.
    long count(Specification<T> var1);
}
```



# learn

## Java

### @RequestHeader的作用

http://blog.csdn.net/yhjyumi/article/details/48105331

### produces/consumes在@requestMapping中的使用方式和作用

1. ```produces="application/json"```


	```
    @GetMapping(path = "/titles/{titleid}", produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8;")
	```

2. ```consumes="application/json"```

### inner join

```
SELECT * FROM title_option as t1 inner join title on t1.title_id = title.id where title.type_id =1;
```


```
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private UserProfile userProfile;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
```

在profile的表中会多出现一个字段 ```user_id```


```
Hibernate: select user0_.id as id1_4_0_, user0_.email as email2_4_0_, user0_.first_name as first_na3_4_0_, user0_.last_name as last_nam4_4_0_, user0_.password as password5_4_0_, userprofil1_.id as id1_3_1_, userprofil1_.address1 as address2_3_1_, userprofil1_.address2 as address3_3_1_, userprofil1_.city as city4_3_1_, userprofil1_.country as country5_3_1_, userprofil1_.dob as dob6_3_1_, userprofil1_.gender as gender7_3_1_, userprofil1_.phone_number as phone_nu8_3_1_, userprofil1_.state as state9_3_1_, userprofil1_.street as street10_3_1_, userprofil1_.user_id as user_id12_3_1_, userprofil1_.zip_code as zip_cod11_3_1_ 

from users user0_ left outer join user_profiles userprofil1_ 
on user0_.id=userprofil1_.user_id 
where user0_.id=?

```


[参考](http://blog.csdn.net/JE_GE/article/category/6528500)


https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-one-mapping-example/

https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

关于fetchType

https://howtoprogramwithjava.com/hibernate-eager-vs-lazy-fetch-type/


- orphanRemoval:如：一级分类删除，是否自动删除和该一级分类外键的二级分类及关联的商品对象，true代表自动删除
- fetch:加载策略，如懒加载，因功能需要设置，如果我们需要查询一级分类的时候就把二级分类查出来，就不用懒加载

### java.lang.StackOverflowError

级联循环...然后堆栈溢出

### 


### mysql 常用配置

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb2?useSSL=false
    username: root
    password: admin
    driver-class-name: com.mysql.jdbc.Driver
  jpa:
      database: MYSQL
      properties:
        hibernate:
          format_sql: true
          show_sql: true
          hbm2ddl:
            auto: update
logging:
  level:
    org:
      hibernate:
        SQL: DEBUG
        type: TRACE

```


### 怎么样初始化懒加载的元素

很快地,我遇到一个问题,怎么去加载一个懒加载的元素.

原来我想到的方案是改变 fetchType ,从而改变加载,找了很久没有这个解决方案.

1. join fetch in JPQL

	[how to use fetch join in jpql](https://stackoverflow.com/questions/15359306/how-to-load-lazy-fetched-items-from-hibernate-jpa-in-my-controller/27879324)

2. join fetch in CriteriaQuery


3. named entity graph

4. dynamic entity graph





















