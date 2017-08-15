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

## 概念
subject 主体 代表了当前“用户”
> - 所有Subject都绑定到SecurityManager，与Subject的所有交互都会委托给SecurityManager
SecurityManager安全管理器
- 所有与安全有关的操作都会与SecurityManager交互；且它管理着所有Subject
- 相当于 springMVC 的 DispatcherServlet 

Realm 域
> - Shiro从从Realm获取安全数据（如用户、角色、权限），
- 就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；
- 也需要从Realm得到用户相应的角色、权限进行验证用户是否能进行操作；
- 可以把Realm看成DataSource，即安全数据源

其他组件

- SessionManager 用于管理session的生命周期
- SessionDao  用于保存session
- CacheManager 用来管理用户，角色，权限的缓存，以提高访问的性能
- Cryptography 密码模块，一些常见的加密组件



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

























