# JS 提升

## 概述

无论作用域中的声明出现在什么地方，都将在代码本身被执行前首先进行处理。可以将这个过程形象地想象成**所有的声明（变量和函数）都会被“移动”到各自作用域的最顶端**，这个过程被称为**提升**。

##  示例

### var 提升

```js
// 原始

console.log( a );
var a = 2;
// 实际执行
var a;
console.log( a );
a = 2;
```

变量函数声明从它们在代码中出现的位置被“移动” 到了最上面。这个过程就叫作提升。 

### 函数优先

#### 正常

```js
// 
foo();
function foo() {
    console.log( 2 ); 
}
```

#### 函数和 var

从下面的例子中可以看出, 函数总是被最先声明, 然后是才是变量

```js
foo(); // 3
function foo() {
    console.log(1);
}
// foo 的定义被函数表达式覆盖
var foo = function () {
    console.log(2);
};

function foo() {
    console.log(3);
}
foo();  //2
```

#### if else 中的函数

不要写下面的这种定义方式, 在不同环境会产生不同后果

比如: node 环境下, 会抛出 `TypeError: foo is not a function`

并且 `eslint` 也会提示你 `Move function declaration to program root`

```
foo(); // "b"
var a = true;
if (a) {
    function foo() {
        console.log("a");
    }
} else {
    function foo() {
        console.log("b");
    }
}
```
















