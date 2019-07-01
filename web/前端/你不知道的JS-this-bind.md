# JS 中的 this 绑定

## 概述

## 概述



## this

### 为什么

函数可以自动引用合适的上下文对象, 这个上下文对象就是 this

简单来说, 为了方便

### this 的误解

1. 把 `this` 理解成指向函数自身
2. 把`this`  理解成函数的作用域

### this 是什么

1. this 是在运行时进行绑定的
2. 当一个函数被调用时，会创建一个活动记录（有时候也称为执行上下文）。这个记录会包含函数在哪里被调用（调用栈）、函数的调用方法、传入的参数等信息。this 就是记录的其中一个属性，会在函数执行的过程中用到。

## 绑定的类别

**运行环境** : `node v10.11.0`

### 1.  默认绑定

```js
function foo(){
    // 这里的 this 默认绑定到 gloabl
    console.log(this.a);
}
var  a = 2;

foo(); // undefined
```

```js
function foo(){
	// 使用严格模式, this 为 undefined
    "use strict"
    console.log(this.a);
}
var  a = 2;

foo();  // 抛出错误 Cannot read property 'a' of undefined
```

虽然 this 的绑定规则完全取决于调用位置，但是只有 foo() 运行在非 strict mode下时，默认绑定才能绑定到全局对象；严格模式下与 foo() 的调用位置无关

这里运行出来和书上的结果不一致, 可能是环境原因导致的, 我以实际运行的结果为准.

### 2. 隐式绑定

另一条需要考虑的规则是调用位置是否有上下文对象，或者说是否被某个对象拥或者包含

```
function foo() {
    console.log(this.a);
}
// obj 包含函数引用 foo
var obj = {
    a: 2,
    foo: foo
};
obj.foo(); // 2
```

### 3. 显式绑定

1. 硬绑定

```js
function foo() {
    console.log(this.a);
}
var obj = {
    a: 2
};
// 在某个对象上强制调用函数
foo.call(obj);// 2	
```

```js
// 创建一个包裹函数，传入所有的参数并返回接收到的所有值
function foo(something) {
    console.log(this.a, something);
    return this.a + something;
}
var obj = {
    a: 2
};
var bar = function xxx() {
    // arguments 为数组?
    return foo.apply(obj, arguments);
};
var b = bar(3); // 2 3
console.log(b); // 5

// 其实Javascript并没有重载函数的功能，
// 但是Arguments对象能够模拟重载。
// Javascrip中每个函数都会有一个Arguments对象实例arguments，
// 它引用着函数的实参，可以用数组下标的方式"[]"引用arguments的元素。
// arguments.length为函数实参个数，arguments.callee引用函数自身。
```

```js
// 或者创建一个辅助函数 

function foo(something) {
    console.log(this.a, something);
    return this.a + something;
}
// 简单的辅助绑定函数
function bind(fn, obj) {
    return function () {
        return fn.apply(obj, arguments);
    };
}
var obj = {
    a: 2
};
var bar = bind(foo, obj);
var b = bar(3); // 2 3
console.log(b); // 5
```

```js
// ES5 中的内置方法 Function.prototype.bind
function foo(something) {
    console.log(this.a, something);
    return this.a + something;
}
var obj = {
    a: 2
};
var bar = foo.bind(obj);
var b = bar(3); // 2 3
console.log(b); // 5

var obj2 = {
    a :3
}
var bar2 = foo.bind(obj2)
console.log(bar2(3));
```

2. api 调用时指定上下文

```js
function foo(el) {
console.log( el, this.id );
}
var obj = {
id: "awesome"
};
// 调用 foo(..) 时把 this 绑定到 obj
[1, 2, 3].forEach( foo, obj );
// 1 awesome 2 awesome 3 awesome
```

### 4. new 绑定

JS中, **构造函数 **只是一些使用 **new 操作符时被调用的函数**。它们并不会属于某个类，也不会实例化一个类。包括内置对象函数在内的所有函数都可以用 new 来调用，这种函数调用被称为**构造函数调用**。

1. 创建（或者说构造）一个全新的对象。
2. 这个新对象会被执行 [[ 原型 ]] 连接。
3. 这个新对象会绑定到函数调用的 this。
4. 如果函数没有返回其他对象，那么 new 表达式中的函数调用会自动返回这个新对象。

```js
function foo(a) {
    this.a = a;
}
var bar = new foo(2);
console.log(bar.a); // 2
```



## 绑定的优先级

### 显式绑定 > 隐式绑定

```js
// 比较显式绑定和隐式绑定的优先级

function foo() {
    console.log(this.a);
}
var obj1 = {
    a: 2,
    foo: foo
};
var obj2 = {
    a: 3,
    foo: foo
};
obj1.foo(); // 2
obj2.foo(); // 3
obj1.foo.call(obj2); // 3
obj2.foo.call(obj1); // 2
```

### new > 隐式绑定

```js
function foo(something) {
    this.a = something;
}
var obj1 = {
    foo: foo
};
var obj2 = {};
obj1.foo(2);
console.log(obj1.a); // 2
obj1.foo.call(obj2, 3);
console.log(obj2.a); // 3
var bar = new obj1.foo(4);
console.log(obj1.a); // 2
console.log(bar.a); // 4
```

### new > 显式绑定

```js
function foo(something) {
this.a = something;
}
var obj1 = {};
var bar = foo.bind( obj1 );
bar( 2 );
console.log( obj1.a ); // 2
var baz = new bar(3);
console.log( obj1.a ); // 2
console.log( baz.a ); // 3
```

### 柯里化

bind(..) 的功能之一就是可以把除了第一个参数（第一个参数用于绑定 this）之外的其他参数都传给下层的函数（这种技术称为“部分应用”，是“柯里化”的一种）。

在计算机科学中，柯里化（Currying）是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数的技术。

```js
// 相当于增加了 默认参数
function foo(p1, p2) {
    this.val = p1 + p2;
}
// 之所以使用 null 是因为在本例中我们并不关心硬绑定的 this 是什么
// 反正使用 new 时 this 会被修改
var bar = foo.bind(null, "p1");
var baz = new bar("p2");
baz.val; // p1p2
```

## 绑定例外

### 被忽略的 this

```js
function foo() {
    console.log(this.a);
}
var a = 2;
foo.call(null); // 实际运行: undefined; 书上的: 2
```

这里的 this 在运行时, 实际上是 global 对象, 而 a 没有定义在 global 中, 所以是 undefined

这时, 如果我们想在 `foo.call(null)` 的时候, 也能正常运行, 应该怎么做呢

```js
function foo(a, b) {
    console.log("a:" + a + ", b:" + b);
}
// 使用 bind(..) 进行柯里化
// 指定后面的参数
// 这里的null是个类似占位符的作用 ,会使用默认绑定规则, 建议尽量不要使用这种方式
var bar = foo.bind(null,0);

bar(5); // a:0, b:5
```

更好的方式, 更加安全

```js
function foo(a, b) {
    console.log("a:" + a + ", b:" + b);
}
// 我们的 DMZ 空对象
var emptyObj = Object.create(null);
// 把数组展开成参数
foo.apply(emptyObj, [2, 3]); // a:2, b:3

// 使用 bind(..) 进行柯里化
// 这里会使用硬绑定(显式绑定)
var bar = foo.bind(emptyObj, 2);
bar(3); // a:2, b:3
```

### 间接引用

间接引用可能会应用默认绑定规则, 导致一些难以发现的错误 

```js
function foo() {
    console.log(this.a);
}
var a = 2;
var o = {
    a: 3,
    foo: foo
};
var p = {
    a: 4
};
o.foo(); // 3
// 赋值表达式 p.foo = o.foo 的返回值是目标函数的引用，因此调用位置是 foo() 而不是
// p.foo() 或者 o.foo()。根据我们之前说过的，这里会应用默认绑定。
(p.foo = o.foo)(); // undefined
```

### 软绑定

没看懂=.=

```js
if (!Function.prototype.softBind) {
    Function.prototype.softBind = function (obj) {
        var fn = this;
        // 捕获所有 curried 参数
        var curried = [].slice.call(arguments, 1);
        var bound = function () {
            return fn.apply(
                // (!this || this === (window || global)) ?  obj : this,
                (!this || this === global) ?  obj : this,
                curried.concat.apply(curried, arguments)
            );
        };
        bound.prototype = Object.create(fn.prototype);
        return bound;
    };
}


function foo() {
    console.log("name: " + this.name);
}
var obj = {
        name: "obj"
    },
    obj2 = {
        name: "obj2"
    },
    obj3 = {
        name: "obj3"
    };
var fooOBJ = foo.softBind(obj);
fooOBJ(); // name: obj
obj2.foo = foo.softBind(obj);
obj2.foo(); // name: obj2 <---- 看！！！
fooOBJ.call(obj3); // name: obj3 <---- 看！

setTimeout(obj2.foo, 10);
// name: obj <---- 应用了软绑定  这里实际运行结果为 undefined
```

## this词法

#### 箭头函数

箭头函数的绑定无法被修改, 它根据当前的词法作用域来决定this

感觉我应该只是用词法作用域, 完全抛弃this





























