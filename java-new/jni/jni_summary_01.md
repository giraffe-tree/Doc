# JNI 总结 01  概述

## 前言

这几天忙着把 C++算法 集成到服务器上, 趁着现在有点时间赶紧总结下. 先说下我 C++ 从没学过, 所以但 JNI 调用肯定会用到一些 C++ 的语法, 所以其实这两天碰到了一系列的问题, 不仅是语法上, 环境上, 还有一些其他的问题. 因此, 我把我遇到的问题都写成了一份文档, 虽然不能把我遇到的所有问题都一一列举, 但我希望我的这些记录能够稍微帮助一些纯 java 的程序员少踩一些 C++ 的坑.

## 过程

整个项目主要分为三部分

1. 本地调试时, `Java` 程序调用`.dll`
2. 部署到 `CentOS7`服务器上时, 调用 `.so`
3. 部署到 `docker` 中, 调用 `.so`

## JNI 

1. HelloWorld

2. Signiture JAVA 类型标识符

3. Java 基本类型与 C++ 中的转换

4. 返回 NULL

5. Exception

6. jintArray 遍历

7. jobjectArray

	- 设置 index, 值
	- https://stackoverflow.com/questions/11666821/array-of-object-array-2d-arrays-jni

8. jclass / jobject 
	
	- static 方法 -> jclass
	- 非静态方法 -> jobject
	- https://blog.csdn.net/CV_Jason/article/details/80026265

