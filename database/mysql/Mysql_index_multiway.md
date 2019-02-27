# Mysql InnoDB 索引是几叉树?

## 概述

前两天, 在一篇 mysql 文章中看到, InnoDB 的索引是一个`B+ Tree` , 那么这个 `B+ tree` 的 `degree` 是由什么决定的? 文章中写是由 `page` 大小和 键值决定的. 我们知道 `InnoDB` 的 `page` 大小由` innodb_page_size` 决定, 对于我们平常使用的默认配置中, 这个值为 `16384` , 即 `16KB`, 文中也提到了当 `innodb_page_size` 为 `16KB` ,且 主键为 4字节 int 类型时,  每个 `non-leaf page` 可以存储 `1203 `个记录. 也就是说这个主键索引为 `1203` 叉树

本文主要探究的是,`1203` 这个数字是怎么的出来的

###  工具

在开始之前先介绍下我用的工具

1. `innodb_ruby` https://github.com/jeremycole/innodb_ruby
   - 主要用来查看索引内部存储结构

另外需要说明的是, 我这里测试的数据库是 `mysql5.7`, 由于 `mysql8`中的存储结构发生了一定的变化, 在 mysql8 上测试可能并不会产生相同的结果, 特此说明.

## Content

下图中就是一个索引页的结构

在`User Records` 部分, 就是在主键索引中 , 存储主键的地方.

这里我们只讨论非叶子节点的情况, 一个记录= 5(header) + 4(假定主键为4个字节)+4(子页的序号) = 13

在innodb 中page 是由一个 4字节的 int 来编号的 (上面公式中的子叶序号就是一个 page_number), 所以想想看 mysql 最多能存多少?  大概是 `2^32 * 16*1024 B=  64 TB`

![Index Overview](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/Feb/IMG_0009.PNG)

### 表结构

```sql
## 在 database test 中
CREATE TABLE `t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `t2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

```

创建完成后, 我向`t`表中插入了 `1803093` 行数据, 

在 `t2`表中插入了 `891107` 行数据,我们来看一下索引情况

```shell
## 在当前数据量时,  -l 1 为非叶子节点, -l 0 为叶子节点
chen:data# innodb_space -s ibdata1 -T test/t -I PRIMARY -l 1 index-level-summary
page    index   level   data    free    records min_key
36      41      1       7813    8139    601     id=1
37      41      1       15639   15      1203    id=344688
38      41      1       15639   15      1203    id=1035210
39      41      1       1755    14433   135     id=1725732
chen:data# innodb_space -s ibdata1 -T test/t2 -I PRIMARY -l 1 index-level-summary
page    index   level   data    free    records min_key
36      42      1       7888    8132    464     id=1
37      42      1       15776   14      928     id=231287
38      42      1       6715    9343    395     id=694359
```

可以看 `records` 一列, 在 `t` 表中, 最大为 `1203` 条, 在 `t2` 表中, 最大为 `928` 条

我们来计算下

```
## t表中 header 5B  主键 4B  page_num 4B
1203 * (5+4+4) = 15639
## t2表中 主键 8B
928 * (5+8+4) = 15776
```

可以大概猜测下, 算一下 `PAGE DIRECTORY`的大小

```
## t 表中 free 15B  FIL trailer 8B
16384 - 120 - 15639 - 15 -8  = 602
## t2 表中 free 14B  FIL trailer 8B
16384 - 120 - 15776 - 14 -8  = 466
```

看下实际

```shell
innodb_space -s ibdata1 -T test/t -p 38 page-illustrate
innodb_space -s ibdata1 -T test/t2 -p 37 page-illustrate
```

计算正确!

![](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/Feb/t_illustrate.png)

![](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/Feb/t2_illustrate.png)



## 感谢

感谢 [Jeremy Cole](https://blog.jcole.us/) 的博客提供了大量的帮助 https://blog.jcole.us/innodb/














