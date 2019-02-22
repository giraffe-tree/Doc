# JPA 中使用中的一些问题

## 概述

### JPA SQL 不兼容

1. 使用 `nativeQuery = true`
2. 继承已有的 `Dialect`, 自行扩展对应数据库函数

### 返回对象不能自动映射构造

1. `@Query("select new com.xxx.to.SimpleTO(r.id,r.createdTime) from Report r")`


### 数据表表名或字段名为SQL关键字

1. `@Column(name = "[DESC]", nullable = false)`
2. `@Column(name = "`DESC`", nullable = false)`



