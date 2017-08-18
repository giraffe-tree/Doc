# Maven

## 常用命令

- mvn clean

> 清理项目产生的临时文件，一般是模块下的target目录

- mvn package

> 项目打包工具，会在target目录生成jar、war等文件

- mvn test

> 测试命令，执行src/test/java 下的Junit 的测试用例

- mvn install

>  模块安装命令，将打包的jar/war 文件 复制到你的本地仓库，供其他模块使用
>  Dmaven.test.skip=true 跳过测试(同时会跳过test compile)

- mvn deploy

>  发布命令 将打包的文件发布到远程参考,提供其他人员进行下载依赖



