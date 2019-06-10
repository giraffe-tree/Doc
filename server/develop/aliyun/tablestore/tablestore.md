# tablestore 使用注意

## 思考

### nosql 和 关系型数据库 表设计时, 有什么区别, 需要怎么做?

我尝试参考 google 的 bigtable , aws 的 dynamoDB, 阿里云的 tablestore , 他们都是基于google论文bigtable的 nosql 的解决方案

在 dynamoDB 的文档中提到:

> 作为一般规则，应在 DynamoDB 应用程序中保留尽可能少的表。如之前所强调的，大多数精心设计的应用程序只需要一个表，除非出于特定理由要使用多个表。
> 例外是涉及大量时间序列数据的情况或具有明显不同的访问模式的数据集 — 但这些都是例外。具有反向索引的单个表通常可启用简单查询来创建和检索应用程序所需的复杂层次数据结构。



### 其他

#### 黑

从使用者角度, 整理上看下来, 阿里云的 tablestore 和 dynamoDB 差距还是挺大的, dynamoDB 拥有很多 tablestore 没有的特性, 其中我比较看中的一点就是 sql 访问. sql 规范了数据访问的方式, 简单通用, 清晰明了, 在后端上还能做各种优化. 而阿里云 tablestore sdk 中各种复杂的api操作, 写个10行代码才能对应到 1 条 sql 的功能, 效率太低了! 

#### 基于文档的 nosql 数据库

google 于2017年推出的 firestore [Cloud Firestore 数据模型](https://firebase.google.com/docs/firestore/data-model)

轻量级 JSON 记录。



#### 参考的文档

1. [面向 DynamoDB 的 NoSQL 设计](https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/bp-general-nosql-design.html)

2. [dynamoDB 产品 pdf](https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/dynamodb-dg.pdf)

3. [google bigtable 中文 pdf](http://blog.bizcloudsoft.com/wp-content/uploads/Google-Bigtable%E4%B8%AD%E6%96%87%E7%89%88_1.0.pdf)

4. [google bigtable docs overview](https://cloud.google.com/bigtable/docs/overview)

## 使用注意

### 分区键的使用

https://help.aliyun.com/document_detail/27356.html

保证分区均匀

### 自增列使用

若设置某一列主键为自增列，在写入一行数据时，这一列主键无需填值，表格存储会自动生成这一主键列的值。该值在分区键上保证唯一，且严格递增。

目前看起来这个自增列没什么用

### 唯一键

如果要想在插入时唯一, 必须将其设置为主键, 但缺点很明显, 在查询时, 需要指定这个唯一键




