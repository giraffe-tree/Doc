# MYSQL page, extent, segment, tablespace

## 本节你可以学到

1. 在 mysql 的磁盘结构中 `page, extent, segment, tablespace` 分别是什么
2. `page, extent, segment, tablespace` 之间的关系

使用版本: `mysql5.7`

## `page, extent, segment, tablespace` 之间的关系

下面这张图给出了它们之间大致的关系, 我们先有个整体的概念

![](http://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/Mar/IMG_0017.PNG)

1. 对于当 ` innodb_page_size` 为`16KB`及以下时,  `extent` 始终为 `1MB`. 对于`32KB`的页面大小，范围大小为`2MB`。对于`64KB`的页面大小，范围大小为`4MB`. 而对于 mysql 默认的 `innodb_page_size=16K` 而言,  64个 `page` 组成一个`extent`
2. `segment` 最少拥有的 `extent` 我并没有查到相关文档, 但我这里认为它最少拥有 1个`extent`.  而在插入和删除数据时，`segment`会增长和缩小。当一个 `segment`在表空间内增长时，`InnoDB` 一次分配前32个`page`。之后，`InnoDB`开始将整个`extent`分配给`segment`。`InnoDB` 最多可以向一个`segment`添加4个`extent`。这里官方文档中有两种说法, 我更倾向于这种.
3. `tablespace` 由多个`segment` 组成, 但根据 5.7官方文档描述, `Some pages in the tablespace contain bitmaps of other pages, and therefore a few extents in an `InnoDB` tablespace cannot be allocated to segments as a whole, but only as individual pages.` 所以存在一些独立于 `segment` 的文件空间, 所以上图中准确来说 `1 tablespace = 几个 segment + 一些 individual pages`

## page

`page` 是所有 mysql 磁盘存储的最底层格式

这里引用下 [jeremycole](https://github.com/jeremycole/innodb_diagrams/blob/master/images/InnoDB_Structures/Basic%20Page%20Overview.png) 的图

![](https://raw.githubusercontent.com/jeremycole/innodb_diagrams/master/images/InnoDB_Structures/Basic%20Page%20Overview.png)





## extent

`InnoDB` features such as **segments**, **read-ahead** requests and the **doublewrite buffer** use I/O operations that read, write, allocate, or free data one extent at a time.

