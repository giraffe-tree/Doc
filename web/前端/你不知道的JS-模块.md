# JS 模块

## 概述



## 模块

### 模块模式

```js
function foo() {
    var something = "cool";
    var another = [1, 2, 3];
	
    function doSomething() {
        console.log(something);
    }

    function doAnother() {
        console.log(another.join(" ! "));
    }
    return {
        doSomething: doSomething,
        doAnother: doAnother
    };
}

let x = foo() // 创建一个模块实例
x.doSomething() // cool
x.doAnother() // 1 ! 2 ! 3
```

模块模式需要具备两个必要条件

1. 必须有外部的封闭函数，该函数必须至少被调用一次（每次调用都会创建一个新的模块实例）。 

2. 封闭函数必须**返回至少一个内部函数**，这样内部函数才能在私有作用域中形成闭包，并且可以访问或者修改私有的状态。 

### 模块 -> 单例模式

一个简单的单例模式, 通过 IIFE 实现

```js
var foo = (function CoolModule() {
    var something = "cool";
    var another = [1, 2, 3];

    function doSomething() {
        console.log(something);
    }

    function doAnother() {
        console.log(another.join(" ! "));
    }
    return {
        doSomething: doSomething,
        doAnother: doAnother
    };
})();
foo.doSomething(); // cool
foo.doAnother(); // 1 ! 2 ! 3
```





