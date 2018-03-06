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


### lazy load 异常

If you would like to keep Lazy Load and you are using Spring Boot, just add the config below in your application.properties:

```
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
```

### @lob


### 多外键问题

PropertyReferenceException: No property typeId found for type Title! 

可能是由于repository 初始化的问题


### how to order join fetch

@OrderBy("optionOrder asc ")

https://stackoverflow.com/questions/5903774/ordering-a-join-fetched-collection-in-jpa-using-jpql-hql

### how to rename json objectsvariables name in springboot

https://stackoverflow.com/questions/38635472/how-to-rename-json-objectsvariables-name-in-spring-boot

```@JsonProperty("type_id")```


### update

TODO:

1. 查询更新
2. 使用@query, @modify,update...

### how to convert page to list 

```
Page<Video> videos = videoRepository.findAllVideos(new PageRequest(1, 50));
List<Video> videosList = videos.getContent();
```

### how to get page count

```
Page<Industry> industries = industryRepository.findAll(pageable);
int totalPages = industries.getTotalPages();
```

### mysql 跳过

```
SELECT * FROM foo LIMIT 10, 50
```

### java调用 C

TODO:

### Spring MVC 中 HandlerInterceptorAdapter的使用


### 验证 属性

@vaild bindresult

### caching is not working in spring interceptor

另外添加到一个service中

### interceptor 返回false

可以设置```contentType```,返回json:

```
response.getWriter()
          .print()
```

### right join

```
SELECT a.`nickname`,b.view_wx_id,b.countBless  FROM  `act_wxuser` as a RIGHT JOIN (SELECT view_wx_id ,COUNT(*) as countBless FROM `vcare`.`act_bless`  GROUP BY  view_wx_id ) as b on a.`id` = b.view_wx_id  order by b.countBless;
```

### postman mockserver

postman mockserver  用来测试api，大量(并发)

### 登录 linux

ssh -l root -p 22 ip地址

### commons 常用配置

```
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
</dependency>
<dependency>
  <groupId>commons-collections</groupId>
  <artifactId>commons-collections</artifactId>
</dependency>
```

### hibernate - java8 

```
<dependency>  
    <groupId>org.hibernate</groupId>  
    <artifactId>hibernate-java8</artifactId>  
    <version>5.1.2.Final</version>  
</dependency>  
```

### dozer bean转化

支持 localdatetime

```
<dependency>
    <groupId>io.craftsman</groupId>
    <artifactId>dozer-jdk8-support</artifactId>
    <version>1.0.2</version>
</dependency>
```


### RequestRaram 参数验证

1. controller 加上```@Validated```注解

```
@RestController
@Validated
public class UserController {

  ... 
}
```

2. 在参数中加上验证注解

比如: ```@NotBlank``` ,```@Size```,```@Length```

```
  @PostMapping(path = "user/login")
  public RetObj loginIn(@NotBlank(message = "用户名不能为空") @RequestParam(value = "username") String userName,
                        @NotBlank(message = "密码不能为空") @RequestParam(value = "password") String password) {

}
```


3. 配置全局异常捕获

```
@ControllerAdvice
@Component
public class GlobalExceptionHander {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RetObj paramErrorHandler(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage()).append(";");
        }
        return RetObj.fail(strBuilder.toString());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RetObj jsonErrorHandler(HttpServletRequest req, Exception e) {
        return RetObj.fail("服务器内部错误");
    }
}

```




