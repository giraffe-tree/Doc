# Mysql 全局锁与表锁

## 概述

### 目录

1. 全局锁
2. 

## 全局锁

### Flush tables with read lock

数据更新语句（数据的增删改）、数据定义语句（包括建表、修改表结构), 更新类事务语句.

```
# 当我们`Flush tables with read lock`, 然后执行一条更新语句时, 会出现以下错误.
Can't execute the query because you have a conflicting read lock
```

`FTWRL` 会确保没有其他线程对数据库做更新. 这样的做法通常用在**全库备份**, 比如`MySIAM`这种不支持事务的引擎.

```sql
# 解锁
UNLOCK TABLES;
```

## 表级锁-表锁

```sql
lock tables  test_schema.v_user read;

unlock tables;
```


## 表级锁-元数据锁 MDL

1. MDL 不需要显式使用, 在访问一张表时, 会被自动加上.

2. 当对一个表做增删改查操作的时候，加 MDL 读锁；当要对表做表结构变更时, 加 MDL 写锁

   事务中的MDL在语句执行开始时申请, 等到整个事务提交后才会释放.

3. 



## 其他

### kill 正在执行的存储过程

```sql
show processlist;
# 找到 id, 如 id 为 3
kill 3;
# end
```

