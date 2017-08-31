# Spring3 学习

主要出自：[Spring3 学习](http://jinnianshilongnian.iteye.com/category/206533)

## 2.1 IOC DI

![1.1 正转](http://sishuok.com/forum/upload/2012/2/19/a02c1e3154ef4be3f15fb91275a26494__1.JPG)
![1.2 反转](http://sishuok.com/forum/upload/2012/2/19/6fdf1048726cc2edcac4fca685f050ac__2.JPG)

## 2.2 IOC 容器

IoC容器就是具有依赖注入功能的容器，IoC容器负责实例化、定位、配置应用程序中的对象及建立这些对象间的依赖。

Spring IoC容器如何知道哪些是它管理的对象呢？这就需要配置文件，Spring IoC容器通过读取配置文件中的配置元数据，通过元数据对应用中的各个对象进行实例化及装配。一般使用基于xml配置文件进行配置元数据，而且Spring与配置文件完全解耦的，可以使用其他任何可能的方式进行配置元数据，比如注解、基于java文件的、基于属性文件的配置都可以。


### 2.2.2 Bean

由IoC容器管理的那些组成你应用程序的对象我们就叫它Bean， Bean就是由Spring容器初始化、装配及管理的对象


xml:

```
<bean id="hello" class="cn.javass.spring.chapter2.helloworld.HelloImpl"></bean>
```

test:
```
  @Test
       public void testHelloWorld() {
             //1、读取配置文件实例化一个IoC容器
             ApplicationContext context = new ClassPathXmlApplicationContext("helloworld.xml");
             //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
              HelloApi helloApi = context.getBean("hello", HelloApi.class);
              //3、执行业务逻辑
              helloApi.sayHello();
       }
```

### 读取配置文件

• XmlBeanFactory：BeanFactory实现，提供基本的IoC容器功能，可以从classpath或文件系统等获取资源；

• ClassPathXmlApplicationContext：ApplicationContext实现，从classpath获取配置文件；

• FileSystemXmlApplicationContext：ApplicationContext实现，从文件系统获取配置文件。


### ApplicationContext接口获取Bean

### IOC容器如何工作

一、准备配置文件：就像前边Hello World配置文件一样，在配置文件中声明Bean定义也就是为Bean配置元数据。
二、由IoC容器进行解析元数据： IoC容器的Bean Reader读取并解析配置文件，根据定义生成BeanDefinition配置元数据对象，IoC容器根据BeanDefinition进行实例化、配置及组装Bean。
三、实例化IoC容器：由客户端实例化容器，获取需要的Bean。


## 2.3 IOC 配置使用

```
<beans>
    <import resource=”resource1.xml”/>
    <bean id=”bean1” class=””></bean>
    <bean id=”bean2” class=””></bean>
<bean name=”bean2” class=””></bean>
    <alias alias="bean3" name="bean2"/>
    <import resource=”resource2.xml”/>
</beans>
```



1. <bean> 标签主要用来进行Bean定义；

2. alias用于定义Bean别名的；
3. import用于导入其他配置文件的Bean定义，这是为了加载多个配置文件，当然也可以把这些配置文件构造为一个数组（new String[] {“config1.xml”, config2.xml}）传给ApplicationContext实现进行加载多个配置文件，那一个更适合由用户决定；这两种方式都是通过调用Bean Definition Reader 读取Bean定义，内部实现没有任何区别。<import>标签可以放在<beans>下的任何位置，没有顺序关系。

### 2.3.2  Bean的配置

Spring IoC容器目的就是管理Bean，这些Bean将根据配置文件中的Bean定义进行创建，而Bean定义在容器内部由BeanDefinition对象表示

### 2.3.3    Bean的命名


每个Bean可以有一个或多个id（或称之为标识符或名字），在这里我们把第一个id称为“标识符”，其余id叫做“别名”；这些id在IoC容器中必须唯一。如何为Bean指定id呢，有以下几种方式；


一、  不指定id，只配置必须的全限定类名，由IoC容器为其生成一个标识，客户端必须通过接口“T getBean(Class<T> requiredType)”获取Bean

二、指定id，必须在Ioc容器中唯一；

三、指定name，这样name就是“标识符”，必须在Ioc容器中唯一；

四、指定id和name，id就是标识符，而name就是别名，必须在Ioc容器中唯一；

五、指定多个name，多个name用“，”、“；”、“ ”分割，第一个被用作标识符，其他的（alias1、alias2、alias3）是别名，所有标识符也必须在Ioc容器中唯一；

六、使用<alias>标签指定别名，别名也必须在IoC容器中唯一

```
<bean name="bean" class="cn.javass.spring.chapter2.helloworld.HelloImpl"/>
<alias alias="alias1" name="bean"/>
```

### 2.3.4  实例化Bean

xml:

```
<bean name="bean2" class="com.chen.test.HelloImpl2">
        <!-- 指定构造器参数 -->
        <constructor-arg index="0" value="Li Ming" />
    </bean>

```

java:

```
 BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter/helloworld.xml");
         HelloApi helloApi = beanFactory.getBean("bean2",HelloApi.class);
         helloApi.sayHello();
```


静态工厂模式实例化

```
<!-- 使用静态工厂方法 -->
<bean id="bean3" class="cn.javass.spring.chapter2.HelloApiStaticFactory" factory-method="newInstance">
     <constructor-arg index="0" value="Hello Spring!"/>
</bean>
```

实例工厂方法实例化

```
<!—1、定义实例工厂Bean -->
<bean id="beanInstanceFactory"
class="cn.javass.spring.chapter2.HelloApiInstanceFactory"/>
<!—2、使用实例工厂Bean创建Bean -->
<bean id="bean4"
factory-bean="beanInstanceFactory"
     factory-method="newInstance">
 <constructor-arg index="0" value="Hello Spring!"></constructor-arg>
</bean>
```

## 3.1 DI

Spring IoC容器的依赖有两层含义：Bean依赖容器和容器注入Bean的依赖资源：

Bean依赖容器：

> 也就是说Bean要依赖于容器，这里的依赖是指容器负责创建Bean并管理Bean的生命周期，正是由于由容器来控制创建Bean并注入依赖，也就是控制权被反转了，这也正是IoC名字的由来，此处的有依赖是指Bean和容器之间的依赖关系。

容器注入Bean的依赖资源：

> 容器负责注入Bean的依赖资源，依赖资源可以是Bean、外部文件、常量数据等，在Java中都反映为对象，并且由容器负责组装Bean之间的依赖关系，此处的依赖是指Bean之间的依赖关系，可以认为是传统类与类之间的“关联”、“聚合”、“组合”关系。

### 3.1.2  构造器注入

使用构造器注入通过配置构造器参数实现，构造器参数就是依赖。除了构造器方式，还有静态工厂、实例工厂方法可以进行构造器注入

使用配置注入

一、根据参数索引注入，使用标签“<constructor-arg index="1" value="1"/>”来指定注入的依赖

二、根据参数类型进行注入，使用标签“<constructor-arg type="java.lang.String" value="Hello World!"/>”来指定注入的依赖

三、根据参数名进行注入，使用标签“<constructor-arg name="message" value="Hello World!"/>”来指定注入的依赖，其中“name”表示需要匹配的参数名字，“value”来指定注入的常量值


```
<bean id="bean4" factory-bean="bean3" factory-method="newInstance">
        <!-- <constructor-arg index="0" value="giraffe"></constructor-arg> -->
        <!-- <constructor-arg name="name" value="giraffe tree"></constructor-arg> -->
        <constructor-arg type="java.lang.String" value="type string value is giraffe "></constructor-arg>
    </bean>
```

### 3.1.3  setter注入

要使用JavaBean:无参构造器，set/get方法，private

### 3.1.4  注入常量

property 的“value”中指定的全是字符串，由Spring容器将此字符串转换成属性所需要的类型，如果转换出错，将抛出相应的异常

Spring类型转换系统对于boolean类型进行了容错处理，除了可以使用“true/false”标准的Java值进行注入，还能使用“yes/no”、“on/off”、“1/0”来代表“真/假”，所以大家在学习或工作中遇到这种类似问题不要觉得是人家配置错了，而是Spring容错做的非常好。

```
<bean id="hello" class="com.chen.test.HelloImpl3">
        <property name="name" value="cc"/>
        <property name="info" value = "tset this bean" ></property>
        <property name="live" value = "on"></property>
    </bean>
```

### 3.1.5    注入Bean ID

```<idref local="……"/>
```
是校验发生在XML解析式而非容器初始化时，且只检查当前配置文件中是否存在相应的Bean。

```
<bean id="casdfgasd" class="java.lang.String">
        <constructor-arg index="0" value="test" />
    </bean>
    <bean id="hello" class="com.chen.test.HelloImpl3">
        <property name="name" value="cc" />
        <property name="info" value="tset this bean"></property>
        <property name="live" value="on"></property>
        <property name="id">
            <idref local="casdfgasd" />
        </property>
    </bean>
```







