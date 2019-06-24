# JS Completion

## 概述



## Completion

### 语句的分类

![](assets/98ce53be306344c018cddd6c083392d5.jpg)



Completion Record 表示一个语句执行完之后的结果，它有三个字段：

- [[type]] 表示完成的类型，有 break continue return throw 和 normal 几种类型；
- [[value]] 表示语句的返回值，如果语句没有，则是 empty；
- [[target]] 表示语句的目标，通常是一个 JavaScript 标签（标签在后文会有介绍）。



![img](assets/7760027d7ee09bdc8ec140efa9caf1d3.png)



