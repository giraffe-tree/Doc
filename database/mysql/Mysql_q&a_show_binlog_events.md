# Mysql show binary logs

## 概述

1. `show binary logs` 是什么?
2. `show binlog events` 是什么? 有什么作用?
3. `binlog` 三种模式之间的区别

## show binary logs

### 示例

```sql
mysql> show binary logs;
+------------------+-----------+
| Log_name         | File_size |
+------------------+-----------+
| mysql-bin.000001 |       177 |
| mysql-bin.000002 |       523 |
| mysql-bin.000003 |       177 |
...
| mysql-bin.000027 |  22832346 |
+------------------+-----------+
27 rows in set (0.01 sec)
```

文档参考: https://dev.mysql.com/doc/refman/8.0/en/show-binary-logs.html


## show binlog events

###  `show binlog events` 如何使用? 

```sql
SHOW BINLOG EVENTS
   [IN 'log_name']
   [FROM pos]
   [LIMIT [offset,] row_count]
```

#### 示例

```sql
mysql> show binlog events in 'mysql-bin.000027' limit 224980,10;
+------------------+----------+----------------+-----------+-------------+----------------------------------------------------------------------------+
| Log_name         | Pos      | Event_type     | Server_id | End_log_pos | Info                                                                       |
+------------------+----------+----------------+-----------+-------------+----------------------------------------------------------------------------+
| mysql-bin.000027 | 22832026 | Anonymous_Gtid |         1 |    22832091 | SET @@SESSION.GTID_NEXT= 'ANONYMOUS'                                       |
| mysql-bin.000027 | 22832091 | Query          |         1 |    22832176 | BEGIN                                                                      |
| mysql-bin.000027 | 22832176 | Query          |         1 |    22832315 | use `db_test`; update v_user set school_index = school_index+1 where id =1 |
| mysql-bin.000027 | 22832315 | Xid            |         1 |    22832346 | COMMIT /* xid=149415 */                                                    |
+------------------+----------+----------------+-----------+-------------+----------------------------------------------------------------------------+
4 rows in set (0.11 sec)
```

上面这个 binlog 记录了更新一次事务的业务逻辑.

###  `show binlog events` 有什么作用?

查看 `binlog` , 验证执行的 sql 是否正确

#### binlog 的作用

- 复制：MySQL Replication在Master端开启binlog，Master把它的二进制日志传递给slaves并回放来达到master-slave数据一致的目的
- 数据恢复：通过mysqlbinlog工具恢复数据
- 增量备份

#### binlog 三种模式的区别

- Row level: 仅保存记录被修改细节，不记录sql语句上下文相关信息优点：能非常清晰的记录下每行数据的修改细节，不需要记录上下文相关信息，因此不会发生某些特定情况下的procedure、function、及trigger的调用触发无法被正确复制的问题，任何情况都可以被复制，且能加快从库重放日志的效率，保证从库数据的一致性
  缺点:由于所有的执行的语句在日志中都将以每行记录的修改细节来记录，因此，可能会产生大量的日志内容，干扰内容也较多；比如一条update语句，如修改多条记录，则binlog中每一条修改都会有记录，这样造成binlog日志量会很大，特别是当执行alter table之类的语句的时候，由于表结构修改，每条记录都发生改变，那么该表每一条记录都会记录到日志中，实际等于重建了表。
  tip: - row模式生成的sql编码需要解码，不能用常规的办法去生成，需要加上相应的参数(--base64-output=decode-rows -v)才能显示出sql语句; - 新版本binlog默认为ROW level，且5.6新增了一个参数：binlog_row_image；把binlog_row_image设置为minimal以后，binlog记录的就只是影响的列，大大减少了日志内容
- Statement level: 每一条会修改数据的sql都会记录在binlog中优点：只需要记录执行语句的细节和上下文环境，避免了记录每一行的变化，在一些修改记录较多的情况下相比ROW level能大大减少binlog日志量，节约IO，提高性能；还可以用于实时的还原；同时主从版本可以不一样，从服务器版本可以比主服务器版本高
  缺点：为了保证sql语句能在slave上正确执行，必须记录上下文信息，以保证所有语句能在slave得到和在master端执行时候相同的结果；另外，主从复制时，存在部分函数（如sleep）及存储过程在slave上会出现与master结果不一致的情况，而相比Row level记录每一行的变化细节，绝不会发生这种不一致的情况
- Mixedlevel level: 以上两种level的混合使用经过前面的对比，可以发现ROW level和statement level各有优势，如能根据sql语句取舍可能会有更好地性能和效果；Mixed level便是以上两种leve的结合。不过，新版本的MySQL对row level模式也被做了优化，并不是所有的修改都会以row level来记录，像遇到表结构变更的时候就会以statement模式来记录，如果sql语句确实就是update或者delete等修改数据的语句，那么还是会记录所有行的变更；因此，现在一般使用row level即可。

以上区别来自 https://zhuanlan.zhihu.com/p/33504555

参考:

1. https://blog.csdn.net/keda8997110/article/details/50895171
2. https://zhuanlan.zhihu.com/p/33504555
3. 包含了所有 statement 和 row 的比较 : https://www.databasejournal.com/features/mysql/article.php/3922266/Comparing-MySQL-Statement-Based-and-Row-Based-Replication.htm

## 疑问

### SET @@SESSION.GTID_NEXT= 'ANONYMOUS' 是什么?

参考: https://www.cnblogs.com/zhoujinyi/p/4717951.html

