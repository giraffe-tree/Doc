# JS 函数声明与函数表达式

## 概述

## 函数声明与函数表达式的区别

1. 函数声明(Function Declaration);

```
funDeclaration("Declaration");//=> true
// 函数声明
function funDeclaration(type){
    return type==="Declaration";
}
```

​    2. 函数表达式(Function Expression)。

```
funExpression("Expression");//=>error 
// 函数表达式
var funExpression = function(type){
    return type==="Expression";
}
```

#### 区别

区分函数声明和表达式最简单的方法是看 function 关键字出现在声明中的位置（不仅仅是一行代码，而是整个声明中的位置）。如果 **function 是声明中 的第一个词**，那么就是一个**函数声明**，否则就是一个函数表达式。

#### 提升

实际运行中: 


```
// 代码1段JS函数等同于：
// 提升
    function funDeclaration(type){
        return type==="Declaration";
    }
    funDeclaration("Declaration");//=> true

// 代码2段JS函数等同于：
// 提升
    var funExpression; 
    funExpression("Expression");//==>error
    funExpression = function(type){
        return type==="Expression";
    }
```

 ## 本质

函数声明和函数表达式之间最重要的区别是它们的**名称标识符**将会绑定在何处。

这里所谓的名称标识符, 即指的是 **命名空间**

```js
(function foo(){ 
	var a = 3;
	console.log( a );
})(); 
```

上面这段代码, 实际上是一个**函数表达式** (IIFE 立即执行函数表达式), 但它**没有绑定到全局作用域**

而下面这段代码, 是一个**函数声明**, 它绑定到了**全局作用域**中

```js
function foo(){ 
	var a = 3;
	console.log( a );
}
```

### 其他

### IIFE 

#### IIFE 的两种形式

第一种形式中函数表达式被包含在` ( )` 中，然后在后面用另一个 `() `括号来调用。第二种形式中用来调用的` () `括号被移进了用来包装的` ( ) `括号中。 

这两种形式在功能上是一致的。**选择哪个全凭个人喜好**。

```
// 1
(function foo() {
    var a = 3;
    console.log(a); // 3
})();

// 2
(function foo() {
    var a = 3;
    console.log(a); // 3
}());
```





#### 最佳实践

始终给函数表达式命名是一个最佳实践

1. 匿名函数调试困难
2. 

## 参考

1. https://www.cnblogs.com/xbj-2016/p/5903611.html