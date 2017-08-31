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

### 3.1.6  注入集合、数组和字典

```
<bean id  = "hello2" class="com.chen.test.HelloList">
        <property name="strings">
        <list>
            <value>1</value>
            <value>2</value>
            <value>3</value>
        </list>
   </property>
```

map

```
   简写：<map>
             <entry key="键常量" value="值常量"/>
             <entry key-ref="键引用" value-ref="值引用"/>
            </map>
         全写：<map>
             <entry><key><value>键常量</value></key><value>值常量</value></entry>
             <entry><key><ref bean="键引用"/></key><ref bean="值引用"/></entry>
           </map>
```


### 3.1.7  引用其它Bean

```
    <bean id = "beanRef" class = "com.chen.bean.demo.HelloImpl"></bean>

    <bean id = "hello3" class = "com.chen.bean.demo.Hello1">
        <constructor-arg index="0" ref = "beanRef"></constructor-arg>
    </bean>
```

equals

```
<bean id = "beanRef" class = "com.chen.bean.demo.HelloImpl"></bean>

<bean id = "hello3" class = "com.chen.bean.demo.Hello1">
        <!-- <constructor-arg index="0" ref = "beanRef"></constructor-arg> -->
        <!-- <constructor-arg index="0" >
            <ref local="beanRef"/>
        </constructor-arg> -->
        <constructor-arg name="hello" >
            <ref local="beanRef"/>
        </constructor-arg>
    </bean>

```




### 引用父容器中的Bean
```
    @Test
    public void testParAndSon() {
        ApplicationContext parentBeanContext = new ClassPathXmlApplicationContext("chapter/helloParent.xml");

        // 初始化当前容器
        BeanFactory beanContext = new ClassPathXmlApplicationContext(new String[] { "chapter/hello.xml" },
                parentBeanContext);
        IHello bean1 = beanContext.getBean("bean1", IHello.class);
        bean1.hello();// 该Bean引用local bean
        IHello bean2 = beanContext.getBean("bean2", IHello.class);
        bean2.hello();// 该Bean引用parent bean
    }
```

### 3.1.8  内部Bean定义

内部Bean就是在<property>或<constructor-arg>内通过<bean>标签定义的Bean，该Bean不管是否指定id或name，该Bean都会有唯一的匿名标识符，而且不能指定别名，该内部Bean对其他外部Bean不可见


```
<bean id="bean3" class="com.chen.bean.demo.Hello1">
        <property name="hello">
            <bean id = "hello123" class="com.chen.bean.demo.HelloImpl">
                <property name="name" value="cc"></property>
            </bean>
        </property>
    </bean>
```

### 3.1.9  处理null值

Spring通过<value>标签或value属性注入常量值，所有注入的数据都是字符串，那如何注入null值呢？通过“null”值吗？当然不是因为如果注入“null”则认为是字符串。Spring通过<null/>标签注入null值。即可以采用如下配置方式

```
<bean id="bean3" class="com.chen.bean.demo.Hello1">
        <property name="hello">
            <bean id = "hello123" class="com.chen.bean.demo.HelloImpl">
                <property name="name" ><null/></property>
            </bean>
        </property>
    </bean>
```


## 3.2 循环依赖

 循环依赖就是循环引用，就是两个或多个Bean相互之间的持有对方，比如CircleA引用CircleB，CircleB引用CircleC，CircleC引用CircleA，则它们最终反映为一个环。


此处不是循环调用，循环调用是方法之间的环调用。  循环调用是无法解决的，除非有终结条件，否则就是死循环，最终导致内存溢出错误


### 构造器循环依赖：

表示通过构造器注入构成的循环依赖，此依赖是无法解决的，只能抛出BeanCurrentlyInCreationException异常表示循环依赖。

### setter循环依赖：

表示通过setter注入方式构成的循环依赖。对于setter注入造成的依赖是通过Spring容器提前暴露刚完成构造器注入但未完成其他步骤（如setter注入）的Bean来完成的，而且只能解决单例作用域的Bean循环依赖。


出现循环依赖是设计上的问题，一定要避免！



## 3.3 更多的DI 


### 3.3.1  延迟初始化Bean

延迟初始化也叫做惰性初始化，指不提前初始化Bean，而是只有在真正使用时才创建及初始化Bean。

配置方式很简单只需在<bean>标签上指定 “lazy-init” 属性值为“true”即可延迟初始化Bean。

延迟初始化的Bean通常会在第一次使用时被初始化；或者在被非延迟初始化Bean作为依赖对象注入时在会随着初始化该Bean时被初始化，因为在这时使用了延迟初始化Bean。

容器管理初始化Bean消除了编程实现延迟初始化，完全由容器控制，只需在需要延迟初始化的Bean定义上配置即可，比编程方式更简单，而且是无侵入代码的。

```
<bean id="helloApi"  
class="cn.javass.spring.chapter2.helloworld.HelloImpl"  
lazy-init="true"/>  

```

### 3.3.2  使用depends-on


depends-on是指指定Bean初始化及销毁时的顺序，使用depends-on属性指定的Bean要先初始化完毕后才初始化当前Bean，由于只有“singleton”Bean能被Spring管理销毁，所以当指定的Bean都是“singleton”时，使用depends-on属性指定的Bean要在指定的Bean之后销毁。


- 在 decorator bean初始化之前要先初始化 HelloWorld 
- 在销毁 HelloWorld 前，要先销毁 decorator

```
  <bean id="HelloWorldDecorator" class="com.chen.spring.HelloWorldDecorator" depends-on="HelloWorld">
        <property name="iHello" ><ref bean="HelloWorld"></ref> </property>
</bean>
```

destroy-method="destroy"：指定销毁方法，只有“singleton”作用域能销毁，“prototype”作用域的一定不能，其他作用域不一定能

```
 <bean id="HelloWorldDecorator" class="com.chen.spring.HelloWorldDecorator" depends-on="HelloWorld"
          init-method="init" destroy-method="destroy" scope="singleton">
        <property name="iHello">
            <ref bean="HelloWorld"></ref>
        </property>
    </bean>
```

```
 @Test
    public void testDecorator(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter2/helloworld.xml");
        IHello iHello = context.getBean("HelloWorldDecorator", IHello.class);

        iHello.sayHello();
         //一点要注册销毁回调，否则我们定义的销毁方法不执行  
        context.registerShutdownHook();

    }
```

output:

```
HelloWorld init....
HelloWorldDecorator init....
==========装饰一下===========
hello world 
==========装饰一下===========
八月 31, 2017 11:02:52 下午 org.springframework.context.support.ClassPathXmlApplicationContext doClose
信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@449b2d27: startup date [Thu Aug 31 23:02:51 CST 2017]; root of context hierarchy
HelloWorldDecorator destroy...
HelloWorld destroy...
```

### 3.3.3  自动装配

自动装配的好处是减少构造器注入和setter注入配置，减少配置文件的长度。自动装配通过配置<bean>标签的“autowire”属性来改变自动装配方式。接下来让我们挨着看下配置的含义。



       一、default：表示使用默认的自动装配，默认的自动装配需要在<beans>标签中使用default-autowire属性指定，
       其支持“no”、“byName ”、“byType”、“constructor”四种自动装配，如果需要覆盖默认自动装配，请继续往下看；
 
       二、no：意思是不支持自动装配，必须明确指定依赖。
 
       三、byName：通过设置Bean定义属性autowire="byName"，意思是根据名字进行自动装配，只能用于setter注入。比如我们有方法“setHelloApi”，则“byName”方式Spring容器将查找名字为helloApi的Bean并注入，如果找不到指定的Bean，将什么也不注入。     


#### ByName 

HelloWorldDecorator 中 有参数 iHello
 
```
  <bean id="iHello" class="com.chen.spring.HelloWorld" init-method="init" destroy-method="destroy">
    </bean>
    <bean id="HelloWorldDecorator" class="com.chen.spring.HelloWorldDecorator" depends-on="iHello"
          autowire="byName">
    </bean>
```

在根据名字注入时，将把当前Bean自己排除在外


#### ByType

通过设置Bean定义属性autowire="byType"，意思是指根据类型注入，用于setter注入，比如如果指定自动装配方式为“byType”，而“setHelloApi”方法需要注入HelloApi类型数据，则Spring容器将查找HelloApi类型数据

如果找到一个则注入该Bean，如果找不到将什么也不注入，如果找到多个Bean将优先注入<bean>标签“primary”属性为true的Bean，否则抛出异常 NoUniqueBeanDefinitionException 来表明有个多个Bean发现但不知道使用哪个.

- 使用“primary”属性为true来指定某个Bean为首选Bean(只有这种方法才是绝对指定，其他方法均有可能报错 NoUniqueBeanDefinitionException)
- 通过设置Bean定义的“autowire-candidate”属性为false来把指定Bean后自动装配候选者中移除

#### constructor

#### 不是所有类型都能自动装配

不能自动装配的数据类型：Object、基本数据类型

自动装配注入方式能和配置注入方式一同工作吗？当然可以，大家只需记住配置注入的数据会覆盖自动装配注入的数据。

### 3.3.4  依赖检查

依赖检查：用于检查Bean定义的属性都注入数据了，不管是自动装配的还是配置方式注入的都能检查，如果没有注入数据将报错，从而提前发现注入错误，只检查具有setter方法的属性。

- none：默认方式，表示不检查；
- objects：检查除基本类型外的依赖对象
- simple：对基本类型进行依赖检查，包括数组类型，其他依赖不报
- all：对所以类型进行依赖检查，配置方式为：dependency-check="all"


```
<bean id="helloApi" class="cn.javass.spring.chapter2.helloworld.HelloImpl"/>  
<!-- 注意我们没有注入helloApi，所以测试时会报错 -->  
<bean id="bean"  
     class="cn.javass.spring.chapter3.bean.HelloApiDecorator"  
     dependency-check="objects">  
<property name="message" value="Haha"/>  
</bean>  
```

### 3.3.5 方法注入

所谓方法注入其实就是通过配置方式覆盖或拦截指定的方法，通常通过代理模式实现。

因为Spring是通过CGLIB动态代理方式实现方法注入，也就是通过动态修改类的字节码来实现的，本质就是生成需方法注入的类的子类方式实现。

[3.3.5 方法注入](http://jinnianshilongnian.iteye.com/blog/1415461)

## 3.4  Bean的作用域 scope

### 3.4.1  基本的作用域

Spring提供“singleton”和“prototype”两种基本作用域，另外提供“request”、“session”、“global session”三种web作用域；Spring还允许用户定制自己的作用域。

#### singleton

- **singleton**：指“singleton”作用域的Bean只会在每个Spring IoC容器中存在一个实例，而且其完整生命周期完全由Spring容器管理。对于所有获取该Bean的操作Spring容器将只返回同一个Bean。

1. 通过在类上定义静态属性保持该实例(侵入式，spring不使用这种方法)
2.  通过注册表方式

注册表实现了Spring接口“SingletonBeanRegistry”，该接口定义了操作共享的单例对象，Spring容器实现将实现此接口；所以共享单例对象通过“registerSingleton”方法注册，通过“getSingleton”方法获取，消除了编程方式单例，注意在实现中不考虑并发

Spring是注册表单例设计模式的实现，在Spring容器中如果没指定作用域默认就是“singleton”

Spring不仅会缓存单例对象，Bean定义也是会缓存的，对于惰性初始化的对象是在首次使用时根据Bean定义创建并存放于单例缓存池。

#### prototype

**prototype**即原型，指每次向Spring容器请求获取Bean都返回一个全新的Bean，相对于“singleton”来说就是不缓存Bean，每次都是一个根据Bean定义创建的全新Bean。

 












