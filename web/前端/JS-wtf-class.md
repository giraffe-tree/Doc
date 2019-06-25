# JS class

## class

```
const a = 2;
if(true){
    console.log(a); // 抛错
    class a {

    }
}
```

class 最基本的用法只需要 class 关键字、名称和一对大括号。它的声明特征跟 const 和 let 类似，都是作用于块级作用域，预处理阶段则会屏蔽外部变量。

同理, 下面的代码也会有类似的错误

```
var c = 1;
function foo(){
    console.log(c);
    class c {}
}
foo();
```