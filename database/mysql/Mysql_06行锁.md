# Mysql 行锁

## 概述

### 知识点

1. 什么是两阶段锁协议? 
2. mysql 中如何产生死锁?
3. 死锁检查导致的高CPU占用怎么办?
4. innodb 行锁是如何实现的?

## 两阶段锁协议 

即 `two-phase locking protocol`

在 InnoDB 事务中，行锁是在需要的时候才加上的, 在事务结束才能释放.

### 这对事务有什么影响呢?

为了尽可能提高并发, 我们需要把最有可能造成锁冲突的锁往后放.

## 死锁与死锁检查

### 示例

| 执行顺序 |                  事务 A                  |                  事务 B                  |
| :------: | :--------------------------------------: | :--------------------------------------: |
|    1     |                 `begin;`                 |                                          |
|    2     | `update table_1 set age=1 where id = 1;` |                                          |
|    3     |                                          |                 `begin;`                 |
|    4     |                                          | `update table_1 set age=2 where id = 2;` |
|    5     | `update table_1 set age=2 where id = 2;` |                                          |
|    6     |                                          | `update table_1 set age=1 where id = 1;` |

事务 A 在等待事务 B 释放 id=2 的行锁，而事务 B在等待事务A 释放id=1的行锁. 这两个语句要加锁相同的资源，但是加锁顺序相反。当这两条语句并发执行的时候，就可能出现死锁。

我们来具体分析下上面执行时, mysql 会产生什么错误?

第一种情况,  步骤5执行时间超过 `innodb_lock_wait_timeout` , 且 步骤6未执行, 则**事务A**中,  mysql 会产生 `ERROR 1205 (HY000): Lock wait timeout exceeded; try restarting transaction`, 超时.

第二种情况, 步骤5执行时间小于 `innodb_lock_wait_timeout`, 且`innodb_deadlock_detect=1`, 在步骤6执行过程中, 事务B会产生 `ERROR 1213 (40001): Deadlock found when trying to get lock; try restarting transaction`, 即死锁.

### innodb_lock_wait_timeout

Innodb 行锁等待时间, 默认为 50秒, 如果超时太短的话, 容易出现误伤. 

### innodb_deadlock_detect

主动死锁检查, 默认为 1 ,打开主动死锁检查.

虽然死锁检查能够在一定程度上避免死锁, 但是也容易耗费CPU资源.

假设有 1000 个并发线程要同时更新同一行，那么死锁检查操作就是` 1,000,000 `这个级别的. 虽然最终检测的结果是没有死锁，但是这期间要消耗大量的 CPU. 

#### 如何避免死锁检查导致的高CPU

这里不考虑关闭 `innodb_deadlock_detect` 的情况

1. 控制并发度, 对于相同行的更新, 在进入引擎之前先排队, 这样在 innodb 中就不会有**大量的死锁检查**了.
2. 将热更新的行数据拆分成逻辑上的多行来减少锁冲突，但是业务复杂度可能会大大提高。

#### 每条事务执行前都要检查死锁么?

1. 一致性读不会加锁，就不需要做死锁检测；

2. 并不是每次死锁检测都都要扫所有事务。比如某个时刻，事务等待状态是这样的：

> B在等A，
> D在等C，
> 现在来了一个E，发现E需要等D，那么E就判断跟D、C是否会形成死锁，这个检测不用管B和A


#### 死锁回滚算法

Innodb 目前处理死锁的方法是, 将持有最少行级排他锁的事务进行回滚

实际测试`mysql 5.7`, 我感觉逻辑是这样的, 在每次事务申请一个写-行锁(排他锁)时, 会去检查死锁, 如果存在死锁, 则会去将持有最少行级排他锁的事务进行回滚;

下面是我做个一个测试:

| 时刻 |         事务A         |             事务B              |        事务C        |
| ---- | :-------------------: | :----------------------------: | :-----------------: |
| T1   | 持有 id= 1,2,3 的行锁 |       持有 id= 4 的行锁        | 持有 id= 5,6 的行锁 |
| T2   |   申请 id=4 等待...   |                                |                     |
| T3   |                       |       申请 id=5  等待...       |                     |
| T4   |                       |                                |      申请 id=1      |
| T5   |                       | mysql 发现死锁, 将其  rollback |                     |
| T6   |  id=4 的行锁申请成功  |                                |                     |

重点讲 T4 时刻后, 发生了什么!

1. 事务C申请 id =1 的行锁, mysql 进行死锁检查, 发现死锁了! 
2. 这时查询到 事务B持有的行级排他锁最少, 所以将事务B回滚
   - 事务B中显示下面语句 `ERROR 1213 (40001): Deadlock found when trying to get lock; try restarting transaction`
3. 事务B回滚后, 事务A申请的 id=4 的行锁申请成功, 并持有 id=4的行锁直至事务结束

#### 如何找到持有最少行级排他锁的事务?

```sql
SELECT * FROM INFORMATION_SCHEMA.INNODB_TRX\G
*************************** 1. row ***************************
                    trx_id: 60440
                 trx_state: RUNNING
               trx_started: 2019-02-13 22:47:04
     trx_requested_lock_id: NULL
          trx_wait_started: NULL
                trx_weight: 5
       trx_mysql_thread_id: 54
                 trx_query: NULL
       trx_operation_state: NULL
         trx_tables_in_use: 0
         trx_tables_locked: 1
          trx_lock_structs: 3
     trx_lock_memory_bytes: 1136
           trx_rows_locked: 6
         trx_rows_modified: 2
   trx_concurrency_tickets: 0
       trx_isolation_level: REPEATABLE READ
         trx_unique_checks: 1
    trx_foreign_key_checks: 1
trx_last_foreign_key_error: NULL
 trx_adaptive_hash_latched: 0
 trx_adaptive_hash_timeout: 0
          trx_is_read_only: 0
trx_autocommit_non_locking: 0
```

可以看到上面的返回中, 包含了 `trx_weight` 字段, 它指的是事务的权重（但不一定是确切的计数），反映了一个事务修改和锁住的行数, innodb存储引擎会选择该值最小的事务进行回滚。

官方文档参考: https://dev.mysql.com/doc/refman/8.0/en/innodb-trx-table.html


## 行锁

### innodb 行锁如何实现的?

`InnoDB` 行锁是通过给索引上的索引项加锁来实现的. 

需要注意的是: **只有通过索引条件检索数据，InnoDB才使用行级锁，否则，InnoDB将使用表锁！**

## 疑问

### 1. `explain` 返回中的 `type ` 含义 ?

all,index,range,ref,eq_ref，const。

https://blog.csdn.net/dennis211/article/details/78170079

### 2. `select ... for update  `

jpa 中如何使用 ? 

参考: 

1. https://blog.csdn.net/claram/article/details/54023216

