##oracle学习笔记
###0.Oracle预备制作时候
oracle database server由实例和数据库两个主要组件构成。
- 实例组件:指在启动时初始化的一组操作系统进程和内存结构
- 数据库组件：数据存储和数据库操作的物理文件
oracle universal installer
- 用于安装和删除oracle
oracle configuration assistant
- 用于创建、修改、删除数据库
oracle sqlplus
- 编写，执行sql语句
sql developer
- oracle database 图形化界面


###1.SQL基础
- sqlplus system/admin

####实例：
是一个非固定的、基于内存的基本进程与内存结构，它暂时存在于RAM,CPU中。当服务器关闭后，实例也就不存在了。实例的生命周期也就是它在内存中存在的时间。
- 构成实例的进程————后台进程
数据库：固定的、基于磁盘的数据文件、控制文件、日志文件、参数文件和归档日志文件等。
一般情况下，Oracle数据库都是一个数据库对应一个实例。
####SGA 系统全局区(system global area)
SGA即操作系统提供的共享内存实现的内存结构
####物理结构
构成oracle的物理结构是数据文件，重做日志和控制文件
####体系结构
用户--用户进程--服务器进程--实例--数据库
      生成SQL    执行SQL

####数据类型


####创建数据库
> 使用 database configuration assistant
>testdb
>
####查询

####插入
####更新

####删除
####合并

###2.SQL执行
###3.访问和联结方法
###4.SQL是关于集合的
###5.关于问题
###6. SQL执行计划
###7.高级分组
###8.分析函数
###9.Model子句
###10.子查询因子化
###11.半联结和反联结
###12.索引
###13.select 以外的内容
###14.事物处理





<meta http-equiv="refresh" content="0.4">
