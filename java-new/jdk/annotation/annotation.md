# Java Annotation

## 参考

注解基础知识

- https://www.zhihu.com/question/36486629

注解字节码实现

- https://www.zhihu.com/question/24401191


## 元注解 

1. @Target,
2. @Retention,
3. @Documented,
4. @Inherited

## @Target

说明了Annotation所修饰的对象范围

ElementType.ANNOTATION_TYPE

1. CONSTRUCTOR:用于描述构造器
2. FIELD:用于描述域
3. LOCAL_VARIABLE:用于描述局部变量
4. METHOD:用于描述方法
5. PACKAGE:用于描述包
6. PARAMETER:用于描述参数
7. TYPE:用于描述类、接口(包括注解类型) 或enum声明

## @Retention

@Retention定义了该Annotation被保留的时间长短

RetentionPolicy.RUNTIME

1. SOURCE:在源文件中有效（即源文件保留）
2. CLASS:在class文件中有效（即class保留）
3. RUNTIME:在运行时有效（即运行时保留）

## @Documented 

注解是否将包含在JavaDoc中

## @Inherited 

是否允许子类继承该注解


