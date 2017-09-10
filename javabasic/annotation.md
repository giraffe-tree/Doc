# 自定义注解

java还提供了4中注解，专门负责新注解的创建:

## @Target：
表示该注解可以用于什么地方，可能的ElementType参数有：

> - CONSTRUCTOR：构造器的声明
- FIELD：域声明（包括enum实例）
- LOCAL_VARIABLE：局部变量声明
- METHOD：方法声明
- PACKAGE：包声明
- PARAMETER：参数声明
- TYPE：类、接口（包括注解类型）或enum声明

**例如：**

```@Target(ElementType.FIELD)```

## @Retention

表示需要在什么级别保存该注解信息。可用于描述注解的生命周期,即：被描述的注解在什么范围内有效.

- SOURCE：注解在源文件中有效，但将被编译器丢弃
- CLASS：注解在class文件中可用，保留在class文件中，但会被VM丢弃
- RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息

**例如：**

```@Retention(RetentionPolicy.RUNTIME)
```

## @Document

将注解包含在Javadoc中

Documented是一个标记注解，没有成员。

## @Inherited
　
@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。

如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。


### 读取annotation

```
public class AnnoUtil {
    public static void getInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Anno.class) == true) {
                Anno anno = field.getAnnotation(Anno.class);
                System.out.println(anno.name());
                System.out.println(anno.id());
            }
        }
    }
}
```


## Type

简单来说：Type是所有类型的父接口, 如原始类型(raw types 对应 Class)、 参数化类型(parameterized types 对应 ParameterizedType)、 数组类型(array types 对应 GenericArrayType)、 类型变量(type variables 对应 TypeVariable )和基本(原生)类型(primitive types 对应 Class),。















