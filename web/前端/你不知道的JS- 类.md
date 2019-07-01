# JS 类

## 概述



## 其他语言中的 类

### JAVA

在java核心技术(`卷1 P92`)中这样讲到: **类(class)是构造对象的模板或蓝图.**

按照我对 `java` 的理解, 所谓的类就是一种**用于描述对象的元对象**, 是一种对Object (对象)的抽象

## JS的类

### 类是什么?

JavaScript 开发者也想出了一个方法来**模拟类的复制行为**，这个方法就是混入。接下来我们会看到两种类型的混入：显式和隐式

### 显式混入

#### 显式混入

```js
// 你不知道的JS上卷 P135
function mixin(sourceObj, targetObj) {
    for (var key in sourceObj) {
        // 只会在不存在的情况下复制
        if (!(key in targetObj)) {
            targetObj[key] = sourceObj[key];
        }
    }
    return targetObj;
}
var vehicle = {
    engines: 1,
    ignition: function () {
        console.log("Turning on my engine.");
    },
    drive: function () {
        this.ignition();
        console.log("Steering and moving forward!");
    }
};
var car = mixin(vehicle, {
    wheels: 4,
    drive: function () {
        // 而不是 vehicle.drive()
        vehicle.drive.call(this);
        console.log(
            "Rolling on all " + this.wheels + " wheels!"
        );
    }
});

car.drive()
```

#### 寄生继承

显式混入模式的一种变体被称为“寄生继承”

目前没有明白这样做的意义

```js
//“传统的 JavaScript 类”Vehicle
function Vehicle() {
    this.engines = 1;
}
Vehicle.prototype.ignition = function () {
    console.log("Turning on my engine.");
};
Vehicle.prototype.drive = function () {
    this.ignition();
    console.log("Steering and moving forward!");
};

//“寄生类”Car
function Car() {
    // 首先，car 是一个 Vehicle
    var car = new Vehicle();
    // 接着我们对 car 进行定制
    car.wheels = 4;
    // 保存到 Vehicle::drive() 的特殊引用
    var vehDrive = car.drive;
    // 重写 Vehicle::drive()
    car.drive = function () {
        vehDrive.call(this);
        console.log(
            "Rolling on all " + this.wheels + " wheels!"
        );
    }
    return car;
}
var myCar = new Car();
myCar.drive();
```

### 隐式混入

```js
var Something = {
    cool: function () {
        this.greeting = "Hello World";
        this.count = this.count ? this.count + 1 : 1;
    }
};
Something.cool();
console.log(Something.greeting); // "Hello World"
console.log(Something.count); // 1
var Another = {
    cool: function () {
        // 隐式把 Something 混入 Another
        Something.cool.call(this);
    }
};
Another.cool();
console.log(Another.greeting); // "Hello World"
console.log(Another.count); // 1（count 不是共享状态）
```

### 用下来的感觉

虽然能解决一部分问题, 但是很丑陋, 抽象层次不够, 更改一个对象会导致另一个对象出现一些预料不到的异常情况

> 混入模式（无论显式还是隐式）可以用来模拟类的复制行为，但是通常会产生丑陋并且脆弱的语法，比如显式伪多态（OtherObj.methodName.call(this, ...)），这会让代码更加难懂并且难以维护。
>
> 总地来说，在 JavaScript 中模拟类是得不偿失的，虽然能解决当前的问题，但是可能会埋下更多的隐患。
>
> 来自 你不知道的JS 上卷 P140







