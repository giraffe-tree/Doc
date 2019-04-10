# prisma

## 概述

什么是Prisma？
Prisma取代了传统的ORM并简化了数据库工作流程：

访问：使用自动生成的Prisma客户端进行类型安全的数据库访问（在JavaScript，TypeScript，Go中）
迁移：声明性数据建模和迁移（可选）
管理：使用Prisma Admin进行可视化数据管理
它用于构建GraphQL，REST，gRPC API等等。Prisma 目前支持 MySQL，PostgreSQL，MongoDB。

引入专用数据访问层（DAL），其抽象出数据库访问的复杂性。DAL的API由应用程序服务器使用，允许API开发人员简单地思考他们需要什么数据，而不必担心如何从数据库安全地和高效地检索它


Prisma允许您从一开始就使用干净的体系结构启动项目，并使您免于编写将数据库和应用程序服务器粘合在一起所需的样板。

这使您可以通过简单而现代的API与数据库通信，从而确保高性能和安全的数据库访问。

