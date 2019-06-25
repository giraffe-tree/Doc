# JS function class

## 概述

## function

```js
console.log(foo);
if(true) {
    function foo(){

    }
}
```

function 在预处理阶段仍然发生了作用，在作用域中产生了变量，没有产生赋值，赋值行为发生在了执行阶段。

### 默认参数

```
function foo(a = 1, ...other) {
    console.log(a, other)
}
foo()
```

