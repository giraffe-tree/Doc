# JS var

js 的 var 真是..................................好难用啊

## 违反

### 最少授权

var 违反了最少授权原则

块作用域是一个用来对之前的最小授权原则进行扩展的工具，将代码从在函数中隐藏信息扩展为在块中隐藏信息。 

var

### 题1

```js
var a = 1;
function foo() {
    // undefined
    console.log(a);
    var a = 2;
}
foo();
```

### 题2

```js
var a = 1;

function foo() {
    console.log(a);
    if(false) {
        var a = 2;
    }
}

foo();

```

### 题3

```js
var a = 1;

function foo() {
    var o= {a:3}
    with(o) {
        var a = 2;
    }
    console.log(o.a);
    console.log(a);
}

foo();
```

var 的作用能够穿透一切语句结构，它只认脚本、模块和函数体三种语法结构。

题3中, 感觉上好像声明与实际执行的不一致?

### 答案

1. `undefined`
2. `undefined`
3. `2`, `undefined`

