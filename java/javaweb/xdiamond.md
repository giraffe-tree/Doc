# XDiamond

## 发布

1. 将```mvn package```将项目打成war包
2. 将项目放入tomcat 的webApps文件夹下
3. 修改conf文件夹下的server.xml,更改host标签[参考](https://www.cnblogs.com/hihtml5/p/5741179.html)/或者复制webApps
4. 启动tomcat 使用dev环境```JAVA_OPTS="$JAVA_OPTS  -Dspring.profiles.active=product"```

## 入门

### 数据库

以下为表名,以及它们的作用

- config :

- dependency : 记录项目之间的依赖
- profile:
- project:

- group :id+组名
- group_roles :组和角色关联
- role:角色
- role_permissions:
- permission:
- user:
- user_groups
- user_roles:

### tomcat 启动参数配置


### 权限相关

Group里的用户有access等级，分别为：owner, master, developer, reporter, guest。 只有owner/master的用户才可以查看修改product环境下的配置。

项目的profile都有access级别。

项目都有一个ownerGroup，据用户在ownerGroup里的access，则可以访问相应级别的profile。


