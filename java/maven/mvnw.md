# mvnw 的作用

## 参考:

https://stackoverflow.com/questions/47240546/should-the-mvnw-files-be-added-to-the-repository

## 作用

mvnw是一个maven wrapper script,它可以让你在没有安装maven或者maven版本不兼容的条件下运行maven的命令.

## 原理

1. 它会寻找maven在你电脑环境变量path中的路径
2. 如果没有找到这个路径它就会自动下载maven到一个默认的路径下,之后你就可以运行maven命令了
3. 有时你会碰到一些项目的peoject和你本地的maven不兼容,它会帮你下载合适的maven版本,然后运行

