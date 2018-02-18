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

若声明时,不对常量进行赋值,则默认它的值为 undifined,和变量相同

### 函数

#### 匿名函数

```
var sum  = function (a,b) {
        return Number(a) + Number(b);
    };
sum(1, 2);
```

变量存在的意义就是调用没有名称的对象,函数名存在的意义就是调用没有名称的函数.

函数是一种包含了可执行代码,并能够被其他代码调用的特殊的对象

### 对象

#### 对象的定义

java 中的对象可以认为是类的一种实例化的结果,而 js 中并没有类这样的语言构造.

js 中的对象是一个名称与值配对的集合.(这与 java 中的 map 相似)

1. js 对象的属性值可以由函数指定
2. js 具备一种原型链的构造,通过这一个构造 js 对象实现了类似于类的继承的能力.


#### 属性

```
var x = {name: 'chen', age: 1};
console.log(x.name);
console.log(x['name']);
document.write(typeof x.name);

x.sum = function (a,b) {
        return a+b;
    }
```

JSON(JavaScript Object Notation, JS 对象标记)

另外对象的属性,也可以是函数

#### new

```
var obj  = new Object();
```

调用构造函数

#### 类功能的整理

1. 类的属性: java 中的静态方法/ static 域
2. prototype : 相当于 java 中的实例方法
3. 实例属性: 相当于 java 中的实例属性

### 数组

数组是一种用于表达有顺序关系的值得集合的语言结构,在 js 中,并非是一种内建类型

js 支持 array 类,数组能够以 array 类示例的实例实现.

```
var array1 = [1, 2, 3, 45, 5];
console.log(array1[0]); // out: 1
```


------

## 第 3 章  js 数据类型

### 数据类型的定义

js 中有 5 种基本数据类型

- 字符串型
- 数值型
- 布尔型
- null 型
- undifined 型

这五种基本数据类型之外的都被成为 object 类型.

5种基本数据类型的实例都被称为 值.

### 与 java 的比较

#### 动态数据类型 / 静态数据类型

|java | js |
|---|---|
|变量有数据类型|变量没有数据类型|
|静态类型语言|动态类型语言|

#### 基于类 / 基于原型

### 内建数据类型 built-in type

内建数据类型 built-in type ,分为5种基本数据类型以及 object 类型. 

#### js 字符串

js 中的字符串为基本数据类型.

在 js 中,字符串值会被隐式地转换为字符串对象类型.

js 中,不存在字符类型,如果要表达某个字符,则使用长度为1的字符串值

#### js 数值类

js 只有一种数值类的数据类型,其内部构造为64位浮点小数.

### 字符串

#### null / undefined

1. null表示"没有对象"，即该处不应该有值。
2. undefined表示"缺少值"，就是此处应该有一个值，但是还没有定义。

#### 字符串传递

```
var x = 'cc';
var y = x;
console.log('x='+x+';y='+y); //x=cc;y=cc
y = 'dd';
console.log('x='+x+';y='+y); //x=cc;y=dd
x = 'ee';
console.log('x='+x+';y='+y);//x=ee;y=dd
y = 'ff';
console.log('x='+x+';y='+y);//x=ee;y=ff
```

#### 比较

若两个字符串a, b内容相同,则a==b,a===b;

字符串类和字符串比较

```
var a = new String('abd');
var b = 'abd';
var c = new String('abd');

console.log(b == a); // true
console.log(b === a); // false
console.log(c == a); // false 
console.log(c === a); // false


//经过计算,字符串类自动转为字符串
console.log((a + '') == (c + '')); // true
console.log((a + '') === (c + '')); // true

```

#### 字符串类

js 中的字符串和字符串类的关系,就像 java 中的 int 和 Integer 的关系.

字符串和字符串类支持隐式类型转换

```
console.log('abc'.length);
```

字符串```abc```,首先被转换为字符串对象,然后再读取字符串对象的 length 属性

可以使用 typeof 判断是字符串类(object),还是字符串(string)

#### 避免使用字符串对象

积极地使用隐式类型转换.

#### 函数

1. charAt

	```
	var x = 'abcde';
	console.log(x.charAt(1)); // b

	```

2. String

	```
	var y = new String('adc');
    console.log(typeof y);  // object
    
    var z = String('adc');
    console.log(typeof z); // string
    
    console.log('abc'[1]); // b 包含了隐式类型转换
	```

### 数值型

在 js 中,数值的内部结构为64位浮点小数

#### 数值类

Number 类,和字符串类相似.

#### 数值 < -- > 字符串

```
var x1 = (1).toString();
console.log(typeof x1);
```

```
var n1 = Number('1');
console.log(typeof n1); // number
```

若 ```字符串->数字``` 转换失败,则返回 NaN (not a number)

#### 特殊值

```
console.log(Number.POSITIVE_INFINITY);
console.log(Number.NEGATIVE_INFINITY);
console.log(Number.NaN);
```

NaN

```
console.log(NaN == NaN); // false
console.log(NaN === NaN); // false
```

Finite

```
console.log(isFinite(1)); // true
```


### 布尔型

布尔类是布尔型的包装类型.

### null 型 / Undefined 型

```
var x = null;
console.log(typeof x); // object
```

### function

```
var y = function (a,b) {
        return a+b;
    }
console.log(typeof y); // function
```


### 数据类型转换

```
console.log(parseInt('12x')); // 12
console.log(parseInt('0x12')); // 12
console.log('100'-1); // 99
console.log('100'-'1'); // 99
```

以下均会输出 Boolean类: false

```
console.log(new Boolean(''));
console.log(new Boolean(NaN));
console.log(new Boolean(0));
console.log(new Boolean(null));
console.log(new Boolean(undefined));
```

或者输出 false

```
console.log(!!undefined);
```


## 第四章 语句,表达式和运算符

### switch-case 语句

switch-case 语句是通过 ```===```判断的.

```
var s = '1';
switch (s) {
    case 1:
        console.log('1');
        break;
    case 2:
        console.log('2');
        break;
    default:
        console.log('default');
}
```


































