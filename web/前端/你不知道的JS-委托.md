# JS 委托

## 概述

JS 原型链的本质就是对象之间的关联关系

## 委托

### 例

```js
let Task = {
    setID: function (ID) {
        this.id = ID;
    },
    outputID: function () {
        console.log(this.id);
    }
};
// 让 XYZ 委托 Task
let XYZ = Object.create(Task);
XYZ.prepareTask = function (ID, Label) {
    this.setID(ID);
    this.label = Label;
};
XYZ.outputTaskDetails = function () {
    this.outputID();
    console.log(this.label);
};
// ABC = Object.create( Task );
// ABC ... = ...

let x = Object.create(XYZ);
x.prepareTask(1,"chen");
x.outputTaskDetails();
```

相比于面向类（或者说面向对象），**作者(凯尔辛普森)**把这种编码风格称为“**对象关联”（OLOO，objects linked to other objects）**。我们真正关心的只是 XYZ 对象（和 ABC 对象）委托了Task 对象。

### 对象关联和类

#### 对象关联

> 使用类构造函数的话，你需要（并不是硬性要求，但是强烈建议）在同一个步骤中实现构造和初始化。然而，在许多情况下把这两步分开（就像对象关联代码一样）更灵活。
>
> 举例来说，假如你在程序启动时创建了一个实例池，然后一直等到实例被取出并使用时才执行特定的初始化过程。这个过程中两个函数调用是挨着的，但是完全可以根据需要让它们出现在不同的位置。
>
> **对象关联可以更好地支持关注分离（separation of concerns）原则**，创建和初始化并不需要
> 合并为一个步骤。

按照我的理解, 使用**类构造函数**比较**倾向于创建和初始化放在一起**, 当然我这不是绝对的, 很多时候创建和初始化是分开的, 也就是类似于**懒汉模式**, **延迟初始化**. 但是在**对象关联中, 作者更加倾向于分离创建和初始化**. 在一般情况下, 延迟初始化可能会提高一些启动速度, 特别是 java 这类需要虚拟机的语言. 但不可避免的是, 你总归要初始化, 初始化的时间消耗不可能被避免.









