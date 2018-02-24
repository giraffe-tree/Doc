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

	> js中的内部(本地)对象包括Array、Boolean、Date、Function、Global、Math、Number、Object、RegExp、String以及各种错误类对象，包括Error、EvalError、RangeError、ReferenceError、SyntaxError和TypeError。
	
	其中Global和Math这两个对象又被称为“内置对象”，这两个对象在脚本程序初始化时被创建，不必实例化这两个对象。

 
2. 宿主对象

	> 宿主对象就是执行JS脚本的环境提供的对象。对于嵌入到网页中的JS来说，其宿主对象就是浏览器提供的对象，所以又称为浏览器对象，如IE、Firefox等浏览器提供的对象。不同的浏览器提供的宿主对象可能不同，即使提供的对象相同，其实现方式也大相径庭！这会带来浏览器兼容问题，增加开发难度。
	
	浏览器对象有很多，如Window和Document等等。


3. 自定义对象

	> 顾名思义，就是开发人员自己定义的对象。JS允许使用自定义对象，使JS应用及功能得到扩充

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

	> 
	```
	var x = 'abcde';
	console.log(x.charAt(1)); // b
	```

2. String

	> 
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

### 遍历 js 对象

```
var value = {x: 'aa', y: 'cc'};
console.log(value);
for (var k in value) {
    console.log(value[k]);
    document.write(value[k]);
}
```

### 异常

js 中, catch 子句 不能根据异常的类型不同判断是否捕获异常,一个 try 语句只能使用一个 catch 子句.

### debug

```
debugger; // 运行会在此处暂停
```

### == 和 ===

```
	var x = {k: 1}; 
    var y = {k: 2};
    var z = x;
    z.k = 2;
    console.log(x.k);  // 2
    console.log(z.k);  // 2
    console.log(x==y);  // false
    console.log(x===y);  // false
    console.log(x==z);  // true
    console.log(x===z);  // true

    console.log('- -- -- - -- - --- ');
    
    var str1 = 'abc';
    var str2 = 'abc';
    var str3 = str2;
    
    console.log(str1==str2);  // true
    console.log(str1===str2);  // true
    console.log(str1==str3);  // true
    console.log(str1===str3);  // true

    console.log();
    str3 = 'efg';
    console.log(str1);  // abc
```

### 比较

```
	var x = '100';
    var y = '99';
    var z = 99;
    console.log(x>y);  // false  字符串比较, 9 的编码值 比 1 大
    console.log(x>z); // true  数字比较
```

### in / instanceof


### 赋值 

在 if 中赋值

```
var x = 1;
var y;
if(y=x) {
    console.log('y='+y);   // x = 1时输出  y=1
}else {
    console.log('else: y='+y); // x = 0时输出  else: y=0
}
```

### 逗号

逗号操作符用于: 依次对其左操作数,右操作数求值

## 第五章 变量与对象

### 5.1 变量的声明

如果 a 已经具有某个值了(某个可以为 true 的值),则继续使用,否则 a=7

```
var a = a || 7;
```

### 5.3 变量和属性

#### 全局变量 / 局部变量

	全局变量: 最外层代码中声明的变量
	
	局部变量: 在函数内部声明的变量

全局变量是全局对象的属性

### 5.6 对象

js 通过基于原型的形式来实现继承

#### 函数中的对象

函数接受对象,并提供默认值

```
// var x = {a: 1, b: 2};
var x;
console.log(x);
console.log(sqrt(x));
function sqrt(x) {
    x = x || {a: 0, b: 0};
    return x.a * x.a + x.b *x.b;
}
```

也可以返回一个对象

```
function get() {
    return {name: 'cc', age: '18'};
}
console.log(get());
```

返回一个函数,也可以把函数放在对象中

```
function getFnc() {
    return function (x, y) {
        return x + y;
    }
}
console.log(getFnc()(1,2));
```

#### 构造函数

1. 构造函数与普通函数声明形式相同
2. 构造函数通过 new 来调用
3. 构造函数的 new 表达式的值为 (被新生成的)对象的引用

```
function ObjectFunction(x,y) {
    this.x = x;
    this.y = y;
}

var obj1= new ObjectFunction(1, 2);
console.log(obj1);
```

#### 构造函数注意

1. 任意函数都可以作为构造函数,使用 new 调用.
2. 构造函数的名称一般以大写字母开头.
3. 构造函数在最后会隐式地执行 ```return this```,如果使用 return 返回,可能会出错.

	 - 返回 基本类型 --> 依旧会 ```return this```
	 - 返回 其他对象 --> 返回 其他对象 

#### 构造函数和类

```
function MyClass(name,age) {
    this.name = name;
    this.age = age;
    this.show = function () {
        console.log('hello, i am '+name+". i am "+age +' years old');
    }
}

var people = new MyClass('chen', 19);
people.show(); // hello, i am chen. i am 19 years old
```

1. 所有实例都是赋值了同一个方法所定义的实体,所以效率(内存效率&执行效率)低下
2. 无法对属性进行访问控制(private,protected)

第一个问题可以通过原型继承来解决,第二个问题可以通过闭包来解决.

#### 访问对象的属性

1. 用点运算符  -> 比较方便
2. 使用中括号  -> 比较通用 如 属性名为'foo-bar',使用点运算符会出错

```
var x = {name:1};
console.log(x.name);
console.log(x['name]);
```

#### 属性枚举

属性可以分为直接属性以及继承于原型的属性

```
var obj = {name: 'cc', age : 18};
for(var key in obj) {
    console.log(key,obj[key]);
}

delete obj.name;
console.log(obj.name); // undefined
```

#### 原型继承

一种对象继承其他对象的属性并将其作为自身的属性

```
function HisClass(){}

HisClass.prototype.name = 'chen';
var obj = new HisClass();
console.log(obj.name); // chen 

delete obj.name;
console.log(obj.name); // chen 通过原型继承的属性无法被 delete
```

#### 原始对象

```
var x = {};
console.log('toString' in x); // true 

for(var value in x) {
    console.log(value);  // but nothing out 
}
```

虽然对象有 ```toString```方法,但是 ```for in``` 并不能枚举出来

即使用 in 检测关联数组(对象) 的键是否存在,就会发生与原型继承而来的属性相关的问题.

我们可以通过 ```hasOwnProperty```来判断,这更加安全

```
var x ={};
console.log(x.hasOwnProperty('toString'));  // false
```

#### 属性的属性

1. **value :**	The property's value.  
2. **writable :**	When true, the property's value can be changed.
3. **enumerable :**	When true, the property shows in some loop constructs, such as for-in Loop. [see JS: Access Property]
4. **configurable :**	If false, attempts to delete the property, change the property to be an accessor property, or change its attributes (other than [[Value]], or changing [[Writable]] to false) will fail.
5. **get**
6. **set**

**中文:**

1. **writable**  可以改写属性
2. **enumerable** 可以通过 for in 语句枚举
3. **configurable** 可以改变属性的属性,可以删除属性


```
var x = {name:'chen'};
Object.defineProperty(x, 'name', {
    enumerable:false,
    writable:false,
    configurable:false
});

console.log(x.name); // chen
x.name = 'cc';
console.log(x.name); // chen  不可改变
```


### 5.11 垃圾回收

不再使用的对象的内存将会自动回收

### 5.12 不可变对象
 
1. 通过改变 enumerable / writable / configurable
2. ```preExtensions```方法,不能新增属性,可以删除,修改

	>
	```
	 var x = {name: 'chen', age: 18};
    Object.preventExtensions(x);
    x.school = 'HelloWorldSchool';
    x.age = 20;
    delete x.name;
    for(var value in x) {
        console.log(x[value]);  // out: 20
    }
	```
	
3. ```seal``` 方法,不能新增/删除,可以更改
4. ```freeze```方法,不能新增/删除/更改

	>
	```
	var y = {name: 'chen', age: 18};
    Object.freeze(y);
    y.age  = 20;
    delete y.name;
    for(var value in y) {
        console.log(y[value]);  // out: chen  18
    }
	```

最后,建议尽可能不使用 ```不可变对象```,尽可能减少开销.

### 5.13 方法

### 5.14 this 引用

#### this 引用规则

1. 在最外层代码, this 引用的是全局对象
2. 在函数内, this 引用根据函数调用方式的不同而有所不同

	>
	|调用方式|this 所引用对象|
	| --- |---|
	|构造函数调用|所生成对象|
	|方法调用|接收方对象|
	|apply或 call 调用|有 apply 或 call 的参数指定的对象|
	|其他方式的调用|全局对象|


	>  apply / call 用于显式指定接收方对象
	
	下面是一些注意点及示例:	
	
	-  示例1
	
		> ```
		var obj = {
		    name: 'chen',
		    doit: function () {
		        console.log('hello ' + this.name);
		    }
		};
		obj.doit(); // hello chen
		```
		> 这里的 this 引用了接收方对象
	
	- 续示例1
	
		> ```
		var fn = obj.doit;
	    fn(); // hello
	    var name = "cc";
	    fn(); // hello cc
		```
		
		> 这里的 this 引用的是全局变量
		
	- 在 java 中常常可以省略 this, 因为在查找方法内的名称时,总是会在同一个类的域名与方法名中搜索.而 js 中就不能省略 this 了,因为省略之后,默认查找 全局变量中的值
	
	- 方法内部调用方法
	
		> 也需要加 this
	
### 5.15 apply & call

#### apply

```
function f(a,b) {
    console.log('hello ',this.name,a+b);
}

var obj1 = {name: 'cc'};
f.apply(obj1,[1,2]);  // hello  cc 3
```

apply 中第一个参数为 被传递的对象 ,第二个参数为函数的参数数组

#### call

```
f.call(obj1, 'hello', 'world'); // hello  cc helloworld
```

call 中第一个参数为 被传递的对象, 第二个参数及以后为函数的参数

### 5.16 原型继承

```
function FirstClass(x,y) {
    this.x = x;
    this.y = y;
    this.see = function () {
        console.log('hello',this.x,this.y);
    }
}

var a1 = new FirstClass(1, 2);

function SecondClass(x,y) {
    this.x = x;
    this.y = y;
}
SecondClass.prototype.see = function () {
    console.log('hello',this.x,this.y);
};

var a2 = new SecondClass(1, 2);
a1.see();  // hello 1 2
a2.see();  // hello 1 2
```

```a2```的```see```方法是从 ```SecondClass.prototype``` 的属性中继承过来的

#### 原型链

使用原型链有两个条件

1. 所有函数/对象都具有名为 prototype 的属性

2. 所有对象都含有一个隐藏的连接,用以指向在对象生成过程中所使用的构造函数

```
function AClass() {
}
AClass.prototype.z = 'chen';

// 1
var proto = AClass.prototype;
var obj = new AClass();
// 2
var proto2 = Object.getPrototypeOf(obj);
// 3
console.log(obj.__proto__);
```

#### 原型对象 

```__proto__```

### 5.17 对象与数据类型

#### constructor 

可以通过 ```obj.constructor```,经过原型链,找到构造函数.


#### 数据类型的判定

通过 **instance**  或 **isPrototypeOf** 判断

```
var d = new Date();
console.log(d.constructor);

console.log(d instanceof Date);  
```

#### 继承 ??

```
function FatherClass() {}
function SonClass() {}

SonClass.prototype = new FatherClass();

var obj = new SonClass();
console.log(obj instanceof FatherClass);  // true

console.log(SonClass.prototype.isPrototypeOf(obj)); // true
console.log(FatherClass.prototype.isPrototypeOf(obj)); // true
console.log(Object.prototype.isPrototypeOf(obj)); // true
```

#### 鸭子类型 --> 数据类型判断

即直接通过分析对象的操作,以判断其类型的方法  --> 俗称:鸭子类型判断

如: 使用 in 操作

#### 枚举直接属性

```
var x = {age: 18};
for(var key in obj ) {
    if(obj.hasOwnProperty(key)) {
        console.log(key);
    }
}
```

#### getOwnPropertyNames

```
console.log(Object.getOwnPropertyNames(Object.prototype));
```

return : 

```
["constructor", "__defineGetter__", "__defineSetter__", "hasOwnProperty", "__lookupGetter__", "__lookupSetter__", "isPrototypeOf", "propertyIsEnumerable", "toString", "valueOf", "__proto__", "toLocaleString"]
```

### 5.18 Object 类

#### create  

继承..

```
var x = Object.create(Object.prototype);  // 同 var x = {};
x.name = 'chen';
console.log(x); 

var y = Object.create(x);
console.log(y.name);  // chen
```

other:

```
var a1 = {q: 1, p: 2};
var a2 = Object.create(Object.prototype,
    {
        q: {value: 1, writable: false, enumerable: true, configurable: true},
        p: {value: 2, writable: true, enumerable: true, configurable: true}
    }
);

console.log(a1.q);  // 1
a1.q = 'hello';
console.log(a1.q);  // hello

console.log(a2.q);  // 1
a2.q = 'hello';
console.log(a2.q); // 1  ,由于 writable 设置为 false ,所以不可更改
```


#### 访问器 

只要将 get/set 属性指定为相应函数,就可以定义一个只能够通过访问器```getter/setter``` 来访问值得属性

只要能写出正确的 getter/setter 访问器函数,就能以此为基础设计出一个不可变对象

```
var obj = Object.create(Object.prototype,
    {x:{get:function () {
                return 18;
            },
        set: function () {
        }},
    }
);

console.log(obj.x); // 18
obj.x = 20;
console.log(obj.x);  // 18   --> x的值没有变化
```






















