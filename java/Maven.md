# Maven

主要参考来自:许晓斌的 maven实战

## 第三章 maven 使用入门


 如果不声明依赖的范围,那么默认就是 compile

![](gif/add_junit.gif)

 
- mvn clean compile 形成classes
- mvn clean test 测试
- mvn clean package 打包

	- 借助 shade-plugin 将类信息添加到 manifest 中

- mvn clean install 把 jar 包放入本地仓库
- java -jar 
 
 	- 执行```java -jar target/spring_11_29-1.0-SNAPSHOT.jar```

- mvn archetype:generate


### 使用 eclipse 

在 eclipse 中安装 m2elcipse

当需要的命令没有时,使用 ```run as maven build```

在 ```goals```中输入命令就可以了,这里需要省去```mvn```

例如:
	
> 我们仅仅需要在 ```goals```中输入```clean test```就可以了

