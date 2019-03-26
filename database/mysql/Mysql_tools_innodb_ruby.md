# Mysql innodb_ruby

## 概述

本文主要介绍 `innodb_ruby` 工具的使用

`innodb_ruby` 源码地址: `https://github.com/jeremycole/innodb_ruby/`

quick_start 参考: `https://github.com/jeremycole/innodb_ruby/wiki#quick-start`

1. https://blog.jcole.us/innodb/

## 安装

```shell
sudo gem install innodb_ruby
```

## 基本使用

### 实验环境

```shell
# CentOS 7 下使用 docker 镜像 mysql:5.7
# 具体如下:
root@b0e7fc2799b0:/# mysql --version
mysql  Ver 14.14 Distrib 5.7.25, for Linux (x86_64) using  EditLine wrapper
```

### mysql 文件目录

```shell
# 先看下文件目录
chen:mysql5.7# tree -d
.
|-- conf
|-- data
|   |-- mysql
|   |-- performance_schema
|   |-- sys
|   `-- test
`-- logs
```

### 1. 查看空表的 `space file `组成

```shell
# 比如我这里通过 mysql workbench 新建了一张 t6 的空表(在 `test` schema 下)
# 由于我这里设置了 innodb_file_per_table 所以在 mysql 的 data 目录下生成了 t6.ibd 和 t6.frm
# 我们进入到 mysql 的 data 目录下, 使用以下命令
# 需要注意的是这里要使用 root 权限才能进入 data/test 目录
chen:test# innodb_space -f t6.ibd space-page-type-regions
start       end         count       type
0           0           1           FSP_HDR
1           1           1           IBUF_BITMAP
2           2           1           INODE
3           3           1           INDEX
4           5           2           FREE (ALLOCATED)
```

### 2. `FSP header`

查看 `FSP header` 中 `extent` 的使用情况

```shell
chen:test# innodb_space -f t6.ibd space-lists
name                length      f_page      f_offset    l_page      l_offset
free                0           0           0           0           0
free_frag           1           0           158         0           158
full_frag           0           0           0           0           0
full_inodes         0           0           0           0           0
free_inodes         1           2           38          2           38
```

要看懂上面的表格需要知道两个东西



```
chen:test# innodb_space -f  t6.ibd -L free_frag space-list-iterate
start_page  page_used_bitmap
0           ####..
```



```
chen:test# innodb_space -f t6.ibd space-indexes
id    name    root    fseg    used        allocated   fill_factor
46    		  3     internal   1           1           100.00%
46            3       leaf     0           0           0.00%
```



```
chen:test# innodb_space -f t6.ibd -p 3 index-fseg-internal-lists
name                length      f_page      f_offset    l_page      l_offset
free                0           0           0           0           0
not_full            0           0           0           0           0
full                0           0           0           0           0
```



```
chen:test# innodb_space -f t6.ibd -p 3 index-fseg-internal-frag-pages
page        index   level   data    free    records
3           46      0       0       16252   0
```



