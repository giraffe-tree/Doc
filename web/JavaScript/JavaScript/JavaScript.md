# JavaScript 

## 第一章 JS 概要

### ECMAScript 标准

1995年, Netscape公司发明了 js

1997年, ECMAScript 第一版

### 不同浏览器对 js 有不同的实现方式

Chrome V8

FireFox  SpiderMokey

现在一般将苹果的浏览器、chrome浏览器、移动端的一些浏览器都成为webkit内核不做细分。

### js 代码的可移植性

影响可移植性的两点:

1. js 编程有一个很麻烦的问题,就是在不同的浏览器中其执行方式会有不同.
2. 渲染引擎的差别

对浏览器使用 Acid 测试,可以减少不同引擎之间执行方式的问题 

Acid : [acid3.acidtests.org](acid3.acidtests.org) 

### 对象

1. 本地对象

	js中的内部(本地)对象包括Array、Boolean、Date、Function、Global、Math、Number、Object、RegExp、String以及各种错误类对象，包括Error、EvalError、RangeError、ReferenceError、SyntaxError和TypeError。
	
	其中Global和Math这两个对象又被称为“内置对象”，这两个对象在脚本程序初始化时被创建，不必实例化这两个对象。

 
2. 宿主对象

	宿主对象就是执行JS脚本的环境提供的对象。对于嵌入到网页中的JS来说，其宿主对象就是浏览器提供的对象，所以又称为浏览器对象，如IE、Firefox等浏览器提供的对象。不同的浏览器提供的宿主对象可能不同，即使提供的对象相同，其实现方式也大相径庭！这会带来浏览器兼容问题，增加开发难度。
	
	浏览器对象有很多，如Window和Document等等。


3. 自定义对象

	顾名思义，就是开发人员自己定义的对象。JS允许使用自定义对象，使JS应用及功能得到扩充

### 源代码压缩

--------

## 第二章  js 基础

#### 解释型语言 vs 编译型语言

js -> 解释型语言

#### 动态语言

js 是不指定返回值类型的

### 变量

#### 隐式全局变量

通过隐式声明的变量均为全局变量,在函数外部通过 var 声明的变量也是全局变量

但应当尽可能避免使用隐式全局变量

### 常量

常量赋值 ```const x = 1;```,常量一旦被赋值,则不允许它的值发生改变








