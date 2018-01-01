# SpringBoot-Redis

本文主要对springboot 中使用redis进行一定的总结

## 首先

1. 你需要先安装redis到本地
2. 你可能需要知道一些redis的基本操作,数据结构

## 本文的目标

使用redis来管理数据库的缓存

## 具体步骤

1. 在pom文件中引入

    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-redis</artifactId>
    </dependency>
    ```

2. 配置redis

    参数解释:

    1. host: redis数据库地址
    2. port: redis数据库端口
    3. password: 数据库密码
    4. timeout: 连接超时时间
    5. database: 默认的redis数据库分为16个,索引为0-15,你可以选取任何一个
    6. pool: 连接池
    7. max-active: 连接池最大连接数
    8. max-wait: 连接池最大等待时间
    9. max-idle: 连接池最大空闲连接
    10. min-idle: 连接池最小空闲连接

    ```
    spring:
        redis:
            host: 127.0.0.1
            port: 6379
            password: 123456
            timeout: 0
            database: 0
            pool:
                max-active: 8
                max-wait: -1
                max-idle: 500
                min-idle: 0
        cache:
            type: REDIS
    ```

3. redis 的javaconfig配置

    ```
    /**
     - 配置参考:
     - http://blog.csdn.net/yy756127197/article/details/75092236
     */
    @Configuration
    @EnableCaching
    public class RedisConfig extends CachingConfigurerSupport {

        private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

        @Value("${spring.redis.host}")
        private String host;
        @Value("${spring.redis.port}")
        private Integer port;
        @Value("${spring.redis.password}")
        private String password;

        @Bean
        public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
            RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
            redisCacheManager.setDefaultExpiration(60);
            return redisCacheManager;
        }

        @Bean
        public RedisTemplate<Serializable, Serializable> redisTemplate(JedisConnectionFactory redisConnectionFactory) {
            RedisTemplate<Serializable, Serializable> template = new RedisTemplate<>();
            template.setConnectionFactory(redisConnectionFactory);
            return template;
        }

        @Bean
        public JedisConnectionFactory redisConnectionFactory() {
            JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
            redisConnectionFactory.setHostName(host);
            redisConnectionFactory.setPort(port);
    //        redisConnectionFactory.setPassword(password);
            LOGGER.info("JedisConnectionFactory initial at " + host + ":" + port);
            return redisConnectionFactory;
        }

        @Bean
        public KeyGenerator keyGenerator() {
            LOGGER.info("keyGenerator load ...");
            return new KeyGenerator() {
                @Override
                public Object generate(Object target, Method method, Object... params) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(target.getClass().getName());
                    stringBuilder.append(method.getName());
                    for (Object obj : params) {
                        stringBuilder.append(obj.toString());
                    }
                    LOGGER.info("keyGenerator = " + stringBuilder.toString());
                    return stringBuilder.toString();
                }
            };
        }

    }
    ```

4. 缓存注解

    1. @Cacheable: 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
    2. @CachePut 作用和配置方法,和 @Cacheable 不同的是，它每次都会触发真实方法的调用
    3. @CacheEvict  主要针对方法配置，能够根据一定的条件对缓存进行清空

    示例:

    ```
    @Service
    @CacheConfig(cacheNames = "account")
    public class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountReposiory accountReposiory;


        @Override
        @Cacheable(value = "accountInfo", key = "#p0")
        public Account findById(Long id) {

            Account one = accountReposiory.findOne(id);
            return one;
        }

        @Override
        public Account deleteById(Long id) {
            return null;
        }

        @Override
        public Account updateAccount(Account account) {
            return null;
        }

        @Override
        @CachePut(value = "accountInfo", key = "#p0")
        public Account updateMoney(Long id, Double money) {
            Account account = findById(id);
            if (account == null) {
                return null;
            }
            if (account.getMoney().equals(money)) {
                return account;
            }
            account.setMoney(money);
            Account save = accountReposiory.save(account);
            return save;
        }
    }

    ```


## 参考

#### spring data redis quick start

http://projects.spring.io/spring-data-redis/#quick-start

#### 异步社区 redis in action

http://www.epubit.com.cn/book/onlinechapter/33966

#### spring boot + redis

1. 关于为什么要继承CachingConfigurerSupport

    http://blog.csdn.net/u011851478/article/details/70239722

2. 默认配置redis

    http://blog.csdn.net/tianyaleixiaowu/article/details/70314277

3. 继承CachingConfigurerSupport的具体实现

    http://www.ityouknow.com/springboot/2016/03/06/springboot(%E4%B8%89)-Spring-Boot%E4%B8%ADRedis%E7%9A%84%E4%BD%BF%E7%94%A8.html

    http://blog.csdn.net/forezp/article/details/70991675

#### redis 数据库缓存

https://www.zhihu.com/search?type=content&q=springboot%20redis%E7%BC%93%E5%AD%98

#### Spring Boot + Mybatis + Redis二级缓存

http://www.roncoo.com/article/detail/131302

#### springboot 泥瓦匠demos

https://github.com/JeffLi1993/springboot-learning-example



