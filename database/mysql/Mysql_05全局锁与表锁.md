# Mysql 全局锁与表锁

## 概述

### 目录

1. 全局锁
   - FTWRL
   - `mysqldump --single-transaction`
   - `realonly`
2. 表锁
3. 元数据锁 MDL
   - 作用
4. 疑问
   - `kill`
   - `readonly` 权限问题
   - 如何安全的给大表加字段

## 全局锁

### Flush tables with read lock (简称 FTWRL)

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

#### 备份如何拿到一致性的视图

`mysqldump --single-transaction database_name table_name`

例如: `mysqldump --single-transaction -r v_user_export.sql db_test v_user -uroot -p` 这里我导出了db_test` 库中`v_user`表的内容, 并写入了文件 `v_user_export.sql`

`mysqldump` 参数说明: [Mysqldump参数大全 参数来源于mysql5.5.19源码](https://www.cnblogs.com/qq78292959/p/3637135.html)

使用 `--single-transaction` 只适用于使用事务引擎的表, 如 `innodb`, 而 `myisam` 这类只能使用 `FTWRL`

#### 为什么不使用 `set global readonly=true`

1. 有些系统使用 `readonly` 来判断主库和备库, 并且 `global`的影响范围更大.
2. 异常处理机制不同. 当使用 `FTWRL` 时, 客户端异常断开, mysql 会自动放弃这个全局锁(在 mysql 5.7 中测试通过). 而`set global readonly=true` 后, 即使客户端异常断开, 数据库仍然保持`readonly` 状态. 

## 表级锁-表锁

```sql
lock tables  test_schema.v_user read;

unlock tables;
```

## 表级锁-元数据锁 MDL

MDL作用是 **防止DDL和DML并发的冲突**

1. MDL 不需要显式使用, 在访问一张表时, 会被自动加上.

2. 当对一个表做增删改查操作(DML)的时候，加 MDL 读锁；当要对表做表结构变更(DDL)时, 加 MDL 写锁

   事务中的MDL在语句执行开始时申请, 等到整个事务提交后才会释放. (当然如果没有 `begin` 事务开始, 在DDL结束之后就自动释放 MDL 读锁)

#### MDL 等待时间设置

1. `innodb_lock_wait_timeout` 事务锁等待时间 50s 

   - innodb 中行锁的等待超时时间

   - https://blog.csdn.net/wo541075754/article/details/50717842

2. `lock_wait_timeout`  MDL锁等待时间 31536000s 即默认1年
   - This timeout applies to all statements that use metadata locks. These include DML and DDL operations on tables, views, stored procedures, and stored functions, as well as LOCK TABLES, FLUSH TABLES WITH READ LOCK, and HANDLER statements
   - mysql timeout 参数详解: https://blog.csdn.net/sgbfblog/article/details/44262339

## 其他

### kill 正在执行的存储过程

```sql
show processlist;
# 找到 id, 如 id 为 3
kill 3;
# end
```

### 全局锁和表锁在 server 层实现

### 从库执行 readonly 会不会影响主从复制?

不会. 因为执行 binlog 的线程是 super 权限,  `readonly` 对 super 权限的用户无效.

### 如何安全的给大表加字段?

使用 `gh-ost`

参考: https://github.com/github/gh-ost




