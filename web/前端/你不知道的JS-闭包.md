# JS 闭包

## 概述

自闭的闭...



## 闭包

### 函数的值传递

无论使用何种方式对函数类型的值进行传递，当函数在别处被调用时都可以观察到闭包。 

```
function foo() {
    var a = 2;
    function baz() {
        console.log(a); // 2
    }
    bar(baz);
}

function bar(fn) {
    var a= 3;
    fn(); // 妈妈快看呀，这就是闭包！
}

foo()
```

无论通过何种手段将内部函数传递到所在的词法作用域以外，它都会持有对原始定义作用域的引用，无论在何处执行这个函数都会使用闭包

本质上无论何时何地，如果将函数（访问它们各自的词法作用域）当作第一级的值类型并到处传递，你就会看到闭包在这些函数中的应用。比如: 无处不在的回调函数

### 我的理解

将函数作为值类型传递, 而调用时它的作用域和声明时的作用域不同时, 均采用声明时它的作用域

> 当函数可以记住并访问所在的词法作用域，即使函数是在当前词法作用域之外执行，这时就产生了闭包。

### 例1 每隔1s输出一个自增数

```
for (var i = 0; i < 5; i++) {
    setTimeout(function timer() {
        console.log(i);
    }, i * 1000);
}
// 会每隔1s输出一个6
// 为什么呢?
```

因为 `timer()` 声明时, 它所在的作用域是全局作用域

如果没有明白, 看看下面这段程序

```js
for (var i = 0; i < 5; i++) {
    setTimeout(function ti
               mer() {
        console.log(i);
    }, i * 1000);
}
i =10000;
```

它会怎么输出呢? 每隔1s 一个10000

最后, 我们想想怎么改正这个程序呢

更改作用域?

```js
// 方式1
for (var i = 0; i < 5; i++) {
    (function () {
        var j = i;
        setTimeout(function timer() {
            console.log(j);
        }, j * 1000);
    })();
}

// 方式2
for (var i = 1; i <= 5; i++) {
    (function (j) {
        setTimeout(function timer() {
            console.log(j);
        }, j * 1000);
    })(i);
}
```

还有其他更好的方法么?

```js
for (let i = 1; i <= 5; i++) {
    setTimeout(function timer() {
        console.log(i);
    }, i * 1000);
}
```

万恶之源的 `var` -.-

### 例2

















