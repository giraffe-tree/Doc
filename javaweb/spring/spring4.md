# Spring 4

#  5 Spring web

## 5.1 Spring MVC 起步

### 5.1.1 跟踪 Spring MVC 的请求

dispatcherServlet

### tomcat 如何启动spring？

servlet 3.0 环境中，容器会在类路径下查找ServletContainerInitializer的实现类，如果能发现的话，就会用它来配置servlet容器。

spring提供了这个接口的实现 SpringServletContainerInitializer

```
@HandlesTypes(WebApplicationInitializer.class)
public class SpringServletContainerInitializer implements ServletContainerInitializer {}
```

SpringServletContainerInitializer 的 onStartup（）方法里面有这样一段代码
```
if (webAppInitializerClasses != null) {
    //webAppInitializerClasses 指的是所有类路径下的类
            for (Class<?> waiClass : webAppInitializerClasses) {
                // Be defensive: Some servlet containers provide us with invalid classes,
                // no matter what @HandlesTypes says...
                //isInterface 检查是否是接口，getModifiers 检查是否是抽象类
                //isAssignableFrom 检测是否是它的子类或者实现类
                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                        WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
                    try {
                        initializers.add((WebApplicationInitializer) waiClass.newInstance());
                    }
                    catch (Throwable ex) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
                    }
                }
            }
        }

```

这个 SpringServletContainerInitializer 又会去找 WebApplicationInitializer 的实现类

```
public interface WebApplicationInitializer {
    void onStartup(ServletContext servletContext) throws ServletException;
}

```

spring 提供了 WebApplicationInitializer 的基础实现 AbstractAnnotationConfigDispatcherServletInitializer ，它是个抽象类，我们可以通过继承这个抽象类来扩展它，并让tomcat发现。

就像下面一样

```
public class WebApplicationInitializerImpl extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[]{"/"};
    }
}

```

AbstractAnnotationConfigDispatcherServletInitializer 会同时创建 dispatcherservlet 和 contextLoaderListener 。





# 7 spring mvc高级技术

[最简配置](http://blog.csdn.net/u012578322/article/details/61936505)

以往都是通过配置web.xml文件来关联spring配置的，那这里的web.xml文件里面没有配置，是怎么拉起spring的呢？原因就在于这个AppInitalizer类了，继承了AbstractAnnotationConfigDispatcherServletInitializer的AppInitalizer的作用就类似以前的spring-context.xml，并且会在web项目运行初始化被自动发现并加载，这就是java config的魅力所在了，不管在哪里声明了配置了，只要继承了AbstractAnnotationConfigDispatcherServletInitializer，它就可以被自动加载。


## 11.2 Spring 与 JPA

### 11.2.1 配置实体管理器工厂

实体管理器主要分为两种类型

- 应用程序管理类型
- 容器管理类型

不管是哪种spring都会负责对它进行管理

由 PersistencePrivider 通过不同的方法创建两种 entityManagerFactory，而entityManagerFactory 创建 entityManager(实体管理器)

这两种实体管理器工厂分别由对应的spring工厂bean创建

- LocalEntityManagerFactoryBean
- LocalContainerEntityManagerFactoryBean


#### 应用程序管理类型

在 META-INF/persistence.xml 中进行配置

在不通过spring时，完全通过应用程序本身来获取EntityManager

但借助于spring对JPA的支持，我们完全可以使用容器管理类型的JPA


#### 容器管理类型

使用容器管理的 JPA 可以将数据源信息配置在spring应用上下文中，而不是在 persistence.xml 中。

因为 ```persistence.xml``` 文件的主要作用在于是被持久化单元中的实体类，但在spring3.1 之后，我们可以在 ```LocalContainerEntityManagerFactoryBean``` 中直接设置```packagesToScan``` ，它会自动查找指定位置的```@Entity``` 注解的类，而 ```datasource``` 也是注入到 ```LocalContainerEntityManagerFactoryBean``` 中了，所以 ```persistence.xml ```完全没有必要存在了，我们可以让 ```LocalContainerEntityManagerFactoryBean``` 来处理这些事情。




#### 从 JNDI 获取实体管理器工厂

TODO:


### 11.2.2 编写基于JPA的Repository

TODO:


## 11.3 借助spring data 实现自动化的JPA Repository

参考：[基于javaconfig配置](https://www.java-success.com/spring-javaconfig-configuration-and-transactionmanager/)

```
<jpa:repositories base-package="com.chen.rep" />

```

这个配置，会扫描扩展了 spring data jpa Repository 接口的所有接口。它会自动生成这个接口的实现。


Repository 的实现 是在spring应用启动时创建的，一共有18个方法

### 11.3.1 定义查询方法

四个动词：*get*,*read* ,*find* 和 *count*

Distinct 在生成查询记录时会确保在结果集中不包含重复记录

IgnoringCase/IgnoresCase 不考虑大小写

包含一些创建时使用到的**断言**


### 11.3.2 声明自定义查询 ———— @Query




### 11.3.3 混合自定义的功能


新建立接口，放在让 repository 继承，然后实现。

需要注意命名，加上impl即可，如果想使用其他后缀，则需要配置

spring data JPA 将实现类和接口关联起来是基于接口名字的。


### 排除依赖

```
<dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>commons-logging</groupId>
                    <artifactId>commons-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```






## 注解大全

### @PostConstruct

通过 @PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作


###  @Qualifier

@Autowired是根据类型进行自动装配的。如果当spring上下文中存在不止一个UserDao类型的bean时，就会抛出BeanCreationException异常;如果Spring上下文中不存在UserDao类型的bean，也会抛出BeanCreationException异常。我们可以使用@Qualifier配合@Autowired来解决这些问题。

```
@Qualifier("userServiceImpl")
@Autowired(required = false)
```

参考:[spring @Qualifier注解](http://blog.csdn.net/clerk0324/article/details/25198457)







