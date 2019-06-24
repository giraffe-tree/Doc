# JS this

## 概述

没有明白 js 中的 this



## this

[mdn]([https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/this#%E8%AF%AD%E6%B3%95](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/this#语法)) 中定义的 this 值是: **当前执行代码的环境对象**

主要分为

### 全局模式

### 普通函数中的 this

取决于函数的调用方式

如果不指定 this 对象, 则函数中的 this 默认指向全局对象 Global

在函数内部，`this`的值取决于函数被调用的方式。

```js
// 测试1: 检查 函数中的 this 是否指向 全局对象 Global
function f1() {
    return this;
}
//在Node中, out: true
console.log(f1() === global);

// 测试2: 键

var obj = {
    a: 'Custom'
};

function whatsThis() {
    return this.a; // this的值取决于函数的调用方式
}

console.log(whatsThis()); // 'Global'
console.log(whatsThis.call(obj)); // 'Custom'
console.log(whatsThis.apply(obj)); // 'Custom'
```





### 箭头函数中的 this

箭头函数的 this 始终指向函数定义时的 this，而非执行时。

> 箭头函数中没有 this 绑定，必须通过查找作用域链来决定其值，如果箭头函数被非箭头函数包含，则 this 绑定的是最近一层非箭头函数的 this，否则，this 为 undefined。





### read-more

https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/this

