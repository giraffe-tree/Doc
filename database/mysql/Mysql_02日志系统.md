# Mysql  日志系统

## 概述

### 版本

MySQL 版本:  `8.0.11`

### 主要内容

1. `redo log` **重做日志**
2. `binlog` **归档日志**

`redo log` 属于`InnoDB` 引擎特有的 , `binlog` 为 mysql 的 server 层实现的, 所有引擎都可以使用

## WAL

https://www.jianshu.com/p/46515825366c

先写日志，再写磁盘

## redo log

### redo log 记录了什么

`redo log`不是记录数据页“更新之后的状态”，而是记录这个页 “做了什么改动”

### redo 配置

`redo log` 为固定大小的, 通过 `innodb_log_file_size` 控制单个文件大小, `mysql 8.0` 中默认 `48M`,  通过 `innodb_log_files_in_group` 控制文件的个数, 默认为 `2` . 

`InnoDB 引擎`会循环写这几个文件, 且 `innodb_log_file_size * innodb_log_files_in_group` 不能超过`略小于512GB` 的最大值

参考: [mysql  sysvar_innodb_log_file_size](https://dev.mysql.com/doc/refman/8.0/en/innodb-parameters.html#sysvar_innodb_log_file_size) 

### redo log 实现

`redo log` 通过两个指针记录写/可擦除的位置:

1. `write pos` 是当前记录的位置, 一边写一边后移(循环)
2. `checkpoint` 是当前要擦除的位置, 擦除记录前要把记录更新到数据文件

通过 `redo log` InnoDB 保证了数据库发生异常重启时, 之前提交的记录都不会丢失, `crash safe`

## binlog

### binlog 的作用

`bin log` 即 binary log

`bin log`用于记录了完整的逻辑记录，所有的逻辑记录在 bin log 里都能找到，所以在备份恢复时，是以 `bin log` 为基础，通过其记录的完整逻辑操作，备份出一个和原库完整的数据。

### 写入 redo log 成功, 写入 binlog 失败的情况

因为是两阶段提交的, 若 `redo log` 写入成功, 而 `binlog` 写入失败, 则 事务应当回滚

### binlog 存储

`Binlog` 有两种模式，`statement` 格式的话是记sql语句，`row` 格式会记录行的内容，记两条，更新前和更新后都有。

`binlog` 是归档存储, 可以持久保存, 而 `redo log` 是循环写, 不能持久保存

### 二阶段提交

跨系统维持数据逻辑一致性

### 崩溃时的处理

1. prepare阶段  写 `redo log`
2. 写 `binlog` 
3. commit

当在2之前崩溃时
- 重启恢复：后发现没有commit，回滚。
- 备份恢复：没有binlog 。

当在3之前崩溃

- 重启恢复：虽没有 commit，但满足 `redo log`和 `binlog` 完整，所以重启后会自动commit。
- 备份：有 `binlog` 一致

##  优化 InnoDB 重做日志

关于如何优化, 主要参考了 [mysql 8.0 官方参考手册](https://dev.mysql.com/doc/refman/8.0/en/optimizing-innodb-logging.html)

1. 增大重做日志(`redo log`) , 原因在于当 `redo log` 写满之后, 引擎必须将日志中的内容写入数据文件,  `redo log` 过小会导致很多过早/不必要的磁盘写入. 
2. 增加日志缓冲区大小 [innodb_log_buffer_size](https://dev.mysql.com/doc/refman/8.0/en/innodb-parameters.html#sysvar_innodb_log_buffer_size) ( 默认 16M)
3. 配置 `innodb_log_write_ahead_size`, 这个地方我还不怎么了解(todo)
4. Optimize the use of spin delay by user threads waiting for flushed redo.(todo)

### 其他参数

####  innodb_flush_log_at_trx_commit

建议设置为 `1` , 表示每次事务的 `redo log` 都直接持久化到磁盘, 保证 mysql 异常重启后数据不丢失

#### sync_binlog

建议设置为`1`, 表示每次事务的 `binlog` 都持久化到磁盘, 保证mysql 异常重启后 `binlog` 不丢失

### 生产中如何恢复

凌晨的全量备份，只提取了改表的ibd文件，然后在本地做了一个一样的空表，释放该表空间，加载 提取后的ibd文件，提取昨天零晨到九点的binlog文件 筛选改表这个时段的操作记录 增量更新到本地导出csv 导入线上 。



## 疑问

1. `redo log` 是物理日志, 记录的是在某个数据页上做了什么修改, `binlog` 是逻辑日志 , 记录的是这个语句的原始逻辑
2. `MDL` 即` metadata lock`, 用来保证 DDL 和 DML 操作的一致性
   - 参考: http://www.cnblogs.com/zengkefu/p/5690385.html
3. `ibd` 文件是什么, 怎么查看, 恢复 ? 

### 检验

1. redo log的概念是什么? 为什么会存在.

   - 保证 crash-safe , 即使数据库异常重启, 之前的提交记录也不会丢失

2. 什么是WAL(write-ahead log)机制, 好处是什么.

   - 提高更新效率

3. redo log 为什么可以保证crash safe机制.

4. binlog的概念是什么, 起到什么作用, 可以做crash safe吗? 

   - 归档, 备份; 不能

5. binlog和redolog的不同点有哪些? 

6. 物理一致性和逻辑一致性各应该怎么理解? 

7. 执行器和innoDB在执行update语句时候的流程是什么样的?

   - 比如: `update T set c=c+1 where ID=2;`

   - innoDB: 查询 innodb 缓存
   - server层: 将这行的值加 `1`
   - innoDB: 将新行更新到内存, 写入 `redo log`
   - server层: 写入 `binlog`
   - innoDB: 提交事务

8. 如果数据库误操作, 如何执行数据恢复?

9. 什么是两阶段提交, 为什么需要两阶段提交, 两阶段提交怎么保证数据库中两份日志间的逻辑一致性(什么叫逻辑一致性)?

10. 如果不是两阶段提交, 先写redo log和先写bin log两种情况各会遇到什么问题?

11. 数据库备份, 一周一备 / 一天一备 有什么优劣 

    - 一天一备好处在于 "最长恢复时间" 更短, 坏处就是消耗更多的存储空间





