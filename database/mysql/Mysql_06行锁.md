# Mysql 行锁

## 概述

### 知识点

1. 什么是两阶段锁协议? 
2. mysql 中如何产生死锁?
3. 死锁检查导致的高CPU占用怎么办?
4. innodb 行锁是如何实现的?

## 两阶段锁协议

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

1. 控制并发度, 对于相同行的更新, 在进入引擎之前先排队, 这样在 innodb 中就不会有大量的死锁检查了.
2. 将热更新的行数据拆分成逻辑上的多行来减少锁冲突，但是业务复杂度可能会大大提高。

#### 每条事务执行前都要检查死锁么?

1. 一致性读不会加锁，就不需要做死锁检测；

2. 并不是每次死锁检测都都要扫所有事务。比如某个时刻，事务等待状态是这样的：

> B在等A，
> D在等C，
> 现在来了一个E，发现E需要等D，那么E就判断跟D、C是否会形成死锁，这个检测不用管B和A

## 行锁

### innodb 行锁如何实现的?

`InnoDB` 行锁是通过给索引上的索引项加锁来实现的. 

需要注意的是: **只有通过索引条件检索数据，InnoDB才使用行级锁，否则，InnoDB将使用表锁！**

## 疑问

### `explain` 返回中的 `type ` 含义 ?

all,index,range,ref,eq_ref，const。

https://blog.csdn.net/dennis211/article/details/78170079

### `select ... for update  `

jpa 中如何使用 ? 

参考: 

1. https://blog.csdn.net/claram/article/details/54023216