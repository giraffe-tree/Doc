# JS var

js 的 var 真是..................................好难用啊



## var

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

### 答案

1. `undefined`
2. `undefined`
3. `2`, `undefined`

