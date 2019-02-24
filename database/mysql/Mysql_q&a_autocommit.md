# Mysql autocommit 详解

## 概述

1. `autocommit` 如何设置?
2. `autocommit` 是什么作用?

## autocommit 

### `autocommit `如何设置?

```sql
# 查询
select @@global.autocommit;
select @@session.autocommit;

## 设置当前 session 的 autocommit
set autocommit=0;

## 设置全局的 autocommit
set global autocommit=0;
```

### `autocommit` 是什么作用?

#### 默认下 autocommit =1 

`autocommit` 为 1 时, 事务需要显式启动, 如:

```sql
begin;
update v_user set school_index = 2 where id =1;
commit;
```

好处是, 在开发过程中可以明确哪些地方用了事务.

#### autocommit =0 

`autocommit` 为 1 时, 当前 session 中, 事务不需要显式启动, 如:

```sql
update v_user set school_index = 2 where id =1;
commit;
```

但是, 这种方式在实际情况中, 会导致查询时在一个事务中, 无法获取到其他 session 更新后的内容, 并且可能会导致**长事务**.

总结以上 , 建议使用 `autocommit=1`

## 疑问

####  在`mysql` 命令行中更新了数据, 但在 workbench 中没有看到更新 ? 

















