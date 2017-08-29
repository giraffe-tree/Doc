# shiro
参考：

- http://blog.csdn.net/ityouknow/article/details/73836159

## shiro 架构

** 以用户登录为例 **

1. 使用用户的登录信息创建令牌token
	- 登录过程被抽象为shiro验证令牌是否具有合法身份以及相关权限
2. 执行登录的动作

> SecurityUtils.setSecurityManager(securityManager); // 注入SecurityManager
Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
subject.login(token); // 登陆

- SecurityUtils对象，本质上就是一个工厂类似Spring中的ApplicationContext。
- Shiro的核心部分是SecurityManager，它负责安全认证与授权
通过令牌（token）与项目（subject）的登陆（login）关系，Shiro保证了项目整体的安全。

3. 判断用户
用户具有角色和权限两种最基本的属性
用户与角色之前的关系为多对多，角色与权限之间的关系也是多对多
在数据库中需要因此建立5张表，分别是用户表（存储用户名，密码，盐等）、角色表（角色名称，相关描述等）、权限表（权限名称，相关描述等）、用户-角色对应中间表（以用户ID和角色ID作为联合主键）、角色-权限对应中间表（以角色ID和权限ID作为联合主键）


#### 实现Realm
- 缓存机制，散列算法，加密算法

-用户注册
数据库中的密码是用户的密码进行散列加密后的字符串

- 匹配
CredentialsMatcher是一个接口
功能就是用来匹配用户登录使用的令牌和数据库中保存的用户信息是否匹配。

- AuthenticationInfo代表了用户的角色信息集合
- AuthorizationInfo代表了角色的权限信息集合
realm就是提供这两个对象的地方。


### RBAC 基于角色的访问控制（Role-Based Access Control ）
在 RBAC 中，权限与角色相关联，用户通过成为适当角色的成员而得到这些角色的权限。

### Shiro 配置
Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。

- ShiroFilterFactoryBean
- HashedCredentialsMatcher
- MyShiroRealm
	- PrincipalCollection --> AuthorizationInfo
	- AuthenticationToken --> AuthenticationInfo
- SecurityManager
- AuthorizationAttributeSourceAdvisor
- SimpleMappingExceptionResolver

> filterChainDefinitionMap.put("/static/**", "anon");

- anon:所有url都都可以匿名访问
- authc: 需要认证才能进行访问
- user:配置记住我或认证通过可以访问

Shiro的认证过程最终会交由Realm执行，这时会调用Realm的dogetAuthenticationInfo(token)方法

1. 检查提交的进行认证的令牌信息
2. 根据令牌信息从数据源(通常为数据库)中获取用户信息
3. 对用户信息进行匹配验证。
4. 验证通过将返回一个封装了用户信息的AuthenticationInfo实例,如 SimpleAuthenticationInfo
5. 验证失败则抛出AuthenticationException异常信息。

shiro的权限授权是通过继承AuthorizingRealm抽象类

- doGetAuthenticationInfo 登录认证实现
- doGetAuthorizationInfo 链接权限的实现



## 概念

### subject 主体

代表了当前“用户”

- 所有Subject都绑定到SecurityManager，与Subject的所有交互都会委托给SecurityManager 安全管理器
- 可以把Subject认为是一个门面；SecurityManager才是实际的执行者；



### SecurityManager

- 所有与安全有关的操作都会与SecurityManager交互；且它管理着所有Subject
- 它是Shiro的核心，它负责与后边介绍的其他组件进行交互
- 相当于 springMVC 的 DispatcherServlet
- Shiro 的 SecurityManager 的实现和其所依赖的组件都是 JavaBean，所以可以用多种形式对 Shiro 进行配置,不管是xml，yml，ini，json都可以。
- Shiro SecurityMangger 本质上是一个由一套安全组件组成的对象模块视图（graph），因为与 JavaBean兼容，所以可以对所有这些组件调用的 getter 和 setter 方法来配置SecurityManager 和它的内部对象视图。



### Realm 域
- Shiro从从Realm获取安全数据（如用户、角色、权限），
- 就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；
- 也需要从Realm得到用户相应的角色、权限进行验证用户是否能进行操作；
- 可以把Realm看成DataSource，即安全数据源
- Realm 本质上是一个特定的安全 DAO：它封装与数据源连接的细节，得到Shiro 所需的相关的数据。在配置 Shiro 的时候，你必须指定至少一个Realm 来实现认证（authentication）和/或授权（authorization）。

Shiro不提供维护用户/权限，而是通过Realm让开发人员自己注入。

其他组件

- SessionManager 用于管理session的生命周期
- SessionDao  用于保存session
- CacheManager 用来管理用户，角色，权限的缓存，以提高访问的性能
- Cryptography 密码模块，一些常见的加密组件

**Authenticator：**

> 认证器，负责主体认证的，这是一个扩展点，如果用户觉得Shiro默认的不好，可以自定义实现；其需要认证策略（Authentication Strategy），即什么情况下算用户认证通过了


**Authrizer：**

> 授权器，或者访问控制器，用来决定主体是否有权限进行相应的操作；即控制着用户能访问应用中的哪些功能


## Shiro 验证过程


在shiro中，用户需要提供principals （身份）和credentials（证明）给shiro，从而应用能验证用户身份：

principals：
> 身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可。一个主体可以有多个principals，但只有一个Primary principals，一般是用户名/手机号。

credentials：

> 证明/凭证，即只有主体知道的安全值，如密码/数字证书等。


### 一个简单的验证过程

```
 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        System.out.println(token.toString());
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            System.out.println("身份验证失败");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();

```

#### securityManager设置

```
    //1.
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    //2.
    SecurityManager securityManager = factory.getInstance();
    //3.
    SecurityUtils.setSecurityManager(securityManager);

```

#### 得到subject

在几乎所有的环境中，你可以通过如下语句得到当前用户的信息：

```
Subject currentUser = SecurityUtils.getSubject();
```
> 在一个独立的程序中调用 getSubject() 会在程序指定位置返回一个基于用户数据的 Subject，在服务器环境（如 web 程序）中，它将获取一个和当前线程或请求相关的基于用户数据的 Subject。

#### 得到session

```
Session session = currentUser.getSession();
session.setAttribute( "someKey", "aValue" );
```

#### 登录

```
   UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

    //支持'remember me' (无需配置，内建的!):
    token.setRememberMe(true);

    currentUser.login(token);
```

#### 常见异常

- UnknownAccountException
- IncorrectCredentialsException
- LockedAccountException
- AuthenticationException

#### 常用验证

```
 currentUser.isPermitted( "lightsaber:weild" )
```


#### 登出

```
currentUser.logout();
```

### 配置

#### DefaultSecurityManager 创建

```
Realm realm = //实例化或获得一个Realm的实例。我们将稍后讨论Realm。
SecurityManager securityManager = new DefaultSecurityManager(realm);
//使SecurityManager实例通过静态存储器对整个应用程序可见：
SecurityUtils.setSecurityManager(securityManager);
```

#### SessionDAO

使用这些函数，你可以配置 SecurityManager 视图（graph）中的任何一部分。

```
DefaultSecurityManager securityManager = new DefaultSecurityManager(realm);
SessionDAO sessionDAO = new CustomSessionDAO();
((DefaultSessionManager)securityManager.getSessionManager()).setSessionDAO(sessionDAO);
```

#### 通过INI配置创建SecurityManager

可以直接使用路径创建

```
Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
SecurityManager securityManager = factory.getInstance();
SecurityUtils.setSecurityManager(securityManager);
```

也可以通过org.apache.shiro.config.Ini 类用程序方式创建

```
Ini ini = new Ini();
//populate the Ini instance as necessary
Factory<SecurityManager> factory = new IniSecurityManagerFactory(ini);
SecurityManager securityManager = factory.getInstance();
SecurityUtils.setSecurityManager(securityManager);
```

**注意**

*INI* 基于文本配置，在独立命名的区域内通过成对的键名/键值组成。键名在每个区域内必须唯一，但在整个配置文件中并不需要这样（这点和JDK的Properties不同），每一个区域（section）可以看作是一个独立的Properties 定义。

注释行可以用“#”或“;”标识。


```
# =======================
# Shiro INI configuration
# =======================

[main]
# Objects and their properties are defined here,
# Such as the securityManager, Realms and anything
# else needed to build the SecurityManager

[users]
# The 'users' section is for simple deployments
# when you only need a small number of statically-defined
# set of User accounts.

[roles]
# The 'roles' section is for simple deployments
# when you only need a small number of statically-defined
# roles.

[urls]
# The 'urls' section is used for url-based security
# in web applications.  We'll discuss this section in the
# Web documentation
```


#### main

```
[main]
sha256Matcher = org.apache.shiro.authc.credential.Sha256CredentialsMatcher

myRealm = com.company.security.shiro.DatabaseRealm

myRealm.connectionTimeout = 30000
#myRealm.setConnectionTimeout(30000);

myRealm.username = jsmith
#myRealm.setUsername("jsmith");

myRealm.password = secret

myRealm.credentialsMatcher = $sha256Matcher

securityManager.sessionManager.globalSessionTimeout = 1800000
#转换逻辑为（通过BeanUtils）：
#securityManager.getSessionManager().setGlobalSessionTimeout(1800000);
```
怎么做到的呢？它假定所有对象都是兼容 JavaBean 的 POJO。在设置这些属性时，Shiro 默认使用 Apache 通用的 BeanUtils 来完成这项复杂的工作，所以虽然 INI 值是文本，BeanUtils 知道如何将这些字符串值转换为适合的原始值类型并调用合适的 JavaBeans 的 setter 方法。


如果你想设置的值并不是一个原始值，而是另一个对象怎么办呢？你可以使用一个 $ 符来引用一个之前定义的实例

```myRealm.credentialsMatcher = $sha256Matcher
```

> 这定义了名为 sha256Matcher 的对象并且使用 BeanUtils 将其设置到myRealm 的实例中（通过调用 myRealm.setCredentialsMatcher(sha256Matcher) 方法）。

列表（Lists）、集合（Sets）、图（Maps）可以像其它属性一样设置--直接设置或者像嵌套属性一样，对于列表和集合，只需指定一个逗号分割的值集或者对象引用集。

```
sessionListener1 = com.company.my.SessionListenerImplementation
sessionListener2 = com.company.my.other.SessionListenerImplementation
securityManager.sessionManager.sessionListeners = $sessionListener1, $sessionListener2

```


对于图（Maps），你可以指定以逗号分割的键-值对列表，每个键-值之间用冒号分割

```
object1 = com.company.some.Class
object2 = com.company.another.Class
...
anObject = some.class.with.a.Map.property

anObject.mapProperty = key1:$object1, key2:$object2

anObject.map = $objectKey1:$objectValue1, $objectKey2:$objectValue2
```


#### 顺序问题

每一个对象实例以及每一个指定的值都将按照其在 [main] 区域中产生的顺序的执行，这些行最终转换为 JavaBeans 的 getter/setter 方法调用，这些方法按同样的顺序调用。

#### securityManager 实例化的问题

因为securityManager实例是特殊的--它已经为你实例化过了并且准备好了，所以你并不需要知道指定的实例化SecurityManager的实现类，自动会产生Default SecurityManager

但你也可以指定securityManager

```
securityManager = com.company.security.shiro.MyCustomSecurityManager
```

当然，很少需要这样--Shiro 的 SecurityManager 实现可以按需求进行定制，你可能要问一下自己（或者用户群）你是否真的需要这样做。


#### users


[users]区域允许你定义一组静态的用户帐号，这对于那些只有少数用户帐号并且用户帐号不需要在运行时动态创建的环境来说非常有用。下面是一个例子：

```
[users]
admin = secret
lonestarr = vespa, goodguy, schwartz
darkhelmet = ludicrousspeed, badguy, schwartz
```

- 等号左边的值是用户名；
- 等号右侧第一个值是用户密码，密码是必须的；
- 密码之后用逗号分割的值是赋予用户的角色名，角色名是可选的。

它会自动生成IniRealm

#### Encrypting Passwords 密码加密

reference：

- [Shiro 的 Command Line Hasher](http://shiro.apache.org/command-line-hasher.html)

> - 它可以加密密码和其它类型的资源，尤其使给 INI[user] 密码加密变得非常简单。

如果你不希望[users]区域下的密码以明文显示

你要指定了加密后的密码值，你必须告诉 shiro 它们是加密的，你可以通过配置配置在[main]隐含创建的iniRealm相应的CredentialsMatcher 实现来告知你使用的哈希算法：

```
sha256Matcher = org.apache.shiro.authc.credential.Sha256CredentialsMatcher

iniRealm.credentialsMatcher = $sha256Matcher
```


#### roles

```
[roles]
# 'admin' role has all permissions, indicated by the wildcard '*'
admin = *
# The 'schwartz' role can do anything (*) with any lightsaber:
schwartz = lightsaber:*
# The 'goodguy' role is allowed to 'drive' (action) the winnebago (type) with
# license plate 'eagle5' (instance specific id)
goodguy = winnebago:drive:eagle5

```

format:

```
rolename = permissionDefinition1, permissionDefinition2, ..., permissionDefinitionN
```


















------------------
## 源码

```
String getName(); //返回一个唯一的Realm名字
boolean supports(AuthenticationToken token); //判断此Realm是否支持此Token
AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
 throws AuthenticationException;  //根据Token获取认证信息
```































