# Mysql MVCC

## 概述

Multiversion concurrency control

## MVCC

### MVCC 是什么?

当MVCC数据库需要更新一段数据时，它不会用新数据覆盖原始数据项，而是创建数据项的较新版本。因此存储了多个版本

### MVCC 的优点

```
Trx id counter 2568
Purge done for trx's n:o < 2566 undo n:o < 0 state: running but idle
History list length 3
LIST OF TRANSACTIONS FOR EACH SESSION:
---TRANSACTION 421164805986144, not started
0 lock struct(s), heap size 1136, 0 row lock(s)
```

### MVCC 的缺点

相对的是, MVCC引入了如何删除过时且永远不会被读取的版本的挑战。在某些情况下，实现了定期扫描和删除过时版本的过程。这通常是一个遍历全局的进程，遍历整个表并使用每个数据项的最后一个版本重写它。PostgreSQL采用这种方法及其VACUUM流程。 其他数据库将存储块拆分为两部分：数据部分和撤消日志。数据部分始终保留最后提交的版本。撤消日志可以重新创建旧版本的数据。后一种方法的主要固有限制是，当存在更新密集型工作负载时，撤消日志部分用尽空间，然后由于无法为其创建快照而中止事务。 (翻译自: https://en.wikipedia.org/wiki/Multiversion_concurrency_control)

## undolog

### 先简单的了解下 undolog 是什么

在` Innodb` 中 undolog 是为了用来实现 **MVCC** .













### 参考

1. innodb 多版本控制 https://dev.mysql.com/doc/refman/8.0/en/innodb-multi-versioning.html
2. 源码 https://github.com/mysql/mysql-server/blob/8.0/storage/innobase/include/read0types.h









