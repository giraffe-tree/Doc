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

本质上

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

 



## 参考

1. https://www.cnblogs.com/xbj-2016/p/5903611.html