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

相比于面向类（或者说面向对象），作者(凯尔辛普森)把这种编码风格称为“**对象关联”（OLOO，objects linked to other objects）**。我们真正关心的只是 XYZ 对象（和 ABC 对象）委托了Task 对象。







