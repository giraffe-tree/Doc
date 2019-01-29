# Mysql 索引

## 概述

为了提高数据查询的效率

索引时在存储引擎层实现的



## 疑问



1. 请问没有主键的表, 是怎么查询的?

   -  作者回复: 没有主键的表，innodb会给默认创建一个Rowid做主键

2. 访问磁盘和内存索引涉及磁盘(sata，ssd，nvm)读写性能，以及内存读写性能，可否给一些数值方便直观认识?

   - T his group of numbers is from a presentation Jeff Dean gave at a Engineering All-Hands Meeting at Google.

   - L1 cache reference 0.5 ns
     Branch mispredict 5 ns
     L2 cache reference 7 ns
     Mutex lock/unlock 100 ns
     Main memory reference 100 ns
     Compress 1K bytes with Zippy 10,000 ns
     Send 2K bytes over 1 Gbps network 20,000 ns
     Read 1 MB sequentially from memory 250,000 ns
     Round trip within same datacenter 500,000 ns
     Disk seek 10,000,000 ns
     Read 1 MB sequentially from network 10,000,000 ns
     Read 1 MB sequentially from disk 30,000,000 ns
     Send packet CA->Netherlands->CA 150,000,000 ns

3. 一个innoDB引擎的表，数据量非常大，根据二级索引搜索会比主键搜索快，文章阐述的原因是主键索引和数据行在一起，非常大搜索慢，但通过普通索引找到主键ID后，同样要跑一边主键索引 . 为什么二级索引要快 ?

4. `B+树` 是怎么实现的 ?

5. 为什么使用 `B+树`

6. 为什么要使用 `N叉树` 

7. “N叉树”的N值在MySQL中是可以被人工调整的么？

8. `lsm 树` 是什么















