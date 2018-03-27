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

```
if (bindingResult.hasErrors()) {
            return RetObj.fail(bindingResult.getFieldError().getDefaultMessage());
        }
```

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

4. 这步还没有验证要不要做

```
@Configuration
public class ValidationConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
```


### cacheput 中 使用unless

```
@Cacheable(value = "snoreUser",key = "'snore_user_'+#username",unless = "#result == null")
public User findUserByUsername(String username) {
    return userRepository.findByUserName(username);
}
```

###  排序

```
Pageable pageable = new PageRequest(page - 1, pageSize, new Sort(new Sort.Order(Sort.Direction.DESC, "reportStartTime")));
```

### 分页缓存

TODO:

### redis 缓存 LocalDate/LocalDateTime

config 


```
server:
  port: 8801

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/snore?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&useSSL=false
    username: root
    password: 
    driver-class-name: com.mysql.jdbc.Driver
  jpa:
      database: MYSQL
      properties:
        hibernate:
          format_sql: false
          show_sql: true
          dialect: org.hibernate.dialect.MySQL5Dialect
          hbm2ddl:
            auto: none
  redis:
    database: 8
    host: 
    password: 
    pool:
      max-active: 1000
      max-idle: 20
      max-wait: -1
      min-idle: 5
    port: 6379
    timeout: 0

```

### @RequestParam 接受localdatetime

参考: [Spring Boot LocalDateTime格式处理](http://blog.csdn.net/junlovejava/article/details/78112240)

```
@GetMapping("date")
public Object date(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
    return date;
}
```

### 设置 jackson bean 改变 responseBody 

### redis 序列化错误

```
Could not read JSON: Can not construct instance of com.xxx.xxx.controller.TestObj: no suitable constructor found, can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?)
```

解决:

1. 在序列化的对象中,需要加入无参构造器
2. 其他配置

```
@Bean
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
      RedisTemplate<Object, Object> template = new RedisTemplate<>();
      template.setConnectionFactory(factory);

      Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
              Object.class);
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
      om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

      om.registerModule(new ParameterNamesModule())
              .registerModule(new Jdk8Module())
              .registerModule(new JavaTimeModule()); // new module, NOT JSR310Module
      om.findAndRegisterModules();

      om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

      jackson2JsonRedisSerializer.setObjectMapper(om);

      template.setKeySerializer(new GenericToStringSerializer<>(Object.class));
      template.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));

      template.setValueSerializer(jackson2JsonRedisSerializer);

      template.afterPropertiesSet();
      return template;
  }
```


### 数据库使用 localdatetime  精度丢失

mysql 中使用 datetime(3) 或者 timestamp(3),精确到秒后3位

@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)

### 多线程处理


1. 配置线程池

```
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService getThreadPool() {
        // return Executors.newFixedThreadPool(5);
        return Executors.newCachedThreadPool();
    }
}

```

2. 使用```ExecutorService```

  ```
  @Autowired
  private ExecutorService executorService;

  public void test(){

    executorService.execute(() -> {
                //更新
                testService.update();
            });
  }
  ```

注意: 在高并发情况下会出问题,重复写

### 部署

1、mvn clean
2、mvn -f prod_pom.xml package
3、scp target/snore-0.0.1-SNAPSHOT.war root@192.2.1.109:/project/2018/mar/snore/snore.jar

### Spring Data Redis - Could not safely identify store assignment for repository candidate interface com.proton.snoreorigin.dao.UserSessionRepository.


### left join ,  group by 

```
select u.id,u.realname,u.created,reportCount,model from ecg.v_user as u 
left join ecg.v_session as s on s.uid = u.id 
left join (
  select count(*) as reportCount ,r.creator as u1 from ecg.u_report as r group by r.creator 
) as result1  on result1.u1 = s.uid
where  u.realname like '%%' and u.mobile like '%15%' and u.created > '2018-1-1' and u.created < '2018-3-1'
    and s.model like '%iPhone%'
order by u.created desc limit 1,10;
```

```
select * from ecg.v_user as u 
left join (select count(*) as c1 ,r.creator as u1 from ecg.u_report as r group by r.creator ) as result1 
on result1.u1 = u.id 
where mobile like "%1%"; 
```

spring data jpa 1.9

Cannot use native queries with dynamic sorting and/or pagination in method

```
@Query(value = "select u.id,u.realname,u.created,reportCount,model from ecg.v_user as u \n" +
      "left join ecg.v_session as s on s.uid = u.id \n" +
      "left join (\n" +
      "select count(*) as reportCount ,r.creator as u1 from ecg.u_report as r group by r.creator \n" +
      ") as result1  on result1.u1 = s.uid\n" +
      "where  u.realname like %:realname% and u.mobile like %:mobile% and u.created > :startTime and u.created < :endTime \n" +
      "and s.model like '%iPhone%' limit :sindex,:eindex;")
  List<Object[]> findCustom(@Param("realname")String realname,
                   @Param("mobile")String mobile,
                   @Param("startTime")Date startTime,
                   @Param("endTime")Date endTime,
                @Param("sindex")int start,
                @Param("eindex")int end
                  );
```

### kafka java

```
spring:
  kafka:
    consumer:
      bootstrap-servers: 47.97.199.139:9092,47.97.199.139:9093,47.97.199.139:9094
      group-id: 1
      client-id: 1
    producer:
      bootstrap-servers: 47.97.199.139:9092,47.97.199.139:9093,47.97.199.139:9094
      key-serializer: org.apache.kafka.common.serialization.IntegerDeserializer
      value-serializer: org.apache.kafka.common.serialization.StringDeserializer
```


