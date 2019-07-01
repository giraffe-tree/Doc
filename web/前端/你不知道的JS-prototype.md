# JS prototype

## 概述



## prototype

### 例子 Obejct.create

查找对象中的属性名或者 prototype 链, 直到查找到属性名, 或者 prototypoe 为 null

```js
var anotherObject = {
    a: 2
};
// 创建一个关联到 anotherObject 的对象
var myObject = Object.create(anotherObject);
myObject.a; // 2

for (var k in myObject) {
    console.log("found: " + k);
}
// found: a
console.log("a" in myObject); // true
```

### 给对象赋值

#### 3种情况

奇葩的情况2:

`myObject2` 对象会因为其他对象中有一个只读 a 就不能包含 a 属性。更奇怪的是，这个限制只存在于 = 赋值中，使用` Object.defineProperty(..) `并不会受到影响。

```js
let anotherObject = {
    a: 2
};
// 创建一个关联到 anotherObject 的对象
let myObject = Object.create(anotherObject);
console.log(myObject.a); // 2

// 情况1 
// 如果在 [[Prototype]] 链上层存在名为 foo 的普通数据访问属性（参见第 3 章）并且没有被标记为只读（writable:false
// 会直接在 myObject 中添加一个 a 的新属性
myObject.a = 3;
console.log(myObject.a); // 3
console.log(anotherObject.a); // 2

// 情况2
// prototype 中的属性被标记为只读
// 则 赋值语句会被忽略
Object.defineProperty(anotherObject,"a",{
    writable: false
})
let myObject2 = Object.create(anotherObject);
myObject2.a = 4;
console.log(myObject2.a); // 2 

// 情况3
// 如果在 [[Prototype]] 链上层存在 a 并且它是一个 setter, 则会调用这个 setter
// 这里和书上讲的不一样, 实际执行下来, 和情况1 一致, 不会改变 prototype 中的属性
let xObject = {
    _a: undefined,
    set a(a){
        this._a = a;
    },
    get a(){
        return this._a;
    }
}

let myObject3 = Object.create(xObject);
myObject3.a = 4;
console.log(myObject3.a); // 4
console.log(xObject.a); // undefined
// myObejct3 中会多一个 _a 的属性
console.log(myObject3._a); // 4
```

#### 其他的情况 a++

```js
var anotherObject = {
    a: 2
};
var myObject = Object.create(anotherObject);
anotherObject.a; // 2
myObject.a; // 2

anotherObject.hasOwnProperty( "a" ); // true
myObject.hasOwnProperty("a"); // false
myObject.a++; // 隐式屏蔽！
anotherObject.a; // 2
// myObject 拥有了自己的 a !!!!
// 其实相当于 于 myObject.a = myObject.a + 1
myObject.a; // 3
myObject.hasOwnProperty("a"); // true
```

### constructor

任何函数的 prototype 中都有一个 constructor 的属性 

原理未知



### 原型继承

JavaScript 会在两个对象之间创建一个关联，这样一个对象就可以通过委托访问另一个对象的属性和函数。  ---- 委托

```js
function Foo(name) {
    this.name = name;
}
Foo.prototype.myName = function () {
    return this.name;
};

function Bar(name, label) {
    Foo.call(this, name);
    this.label = label;
}
// 我们创建了一个新的 Bar.prototype 对象并关联到 Foo.prototype
// 我的理解是, Bar.prototype 就是一个新的"类" (class), 当然不能用引用
// 方法1 ES6 之前需要抛弃默认的 Bar.prototype
// Bar.prototype = Object.create(Foo.prototype);
// 方法2 ES6 后使用, 但我调试时发现, Bar.prototype 比方法1多了一个 constructor 属性
Object.setPrototypeOf( Bar.prototype, Foo.prototype );

// 注意方法1中没有 Bar.prototype.constructor 了
// 如果你需要这个属性的话可能需要手动修复一下它
Bar.prototype.myLabel = function () {
    return this.label;
};
var a = new Bar("a", "obj a");

console.log(a.myName()); // "a"
console.log(a.myLabel()); // "obj a"

Foo.prototype.myName = function () {
    return this.name + "hello";
};

console.log(a.myName()); // "a"
```

#### instanceof

```js
function Foo(name) {
    this.name = name;
}
Foo.prototype.myName = function () {
    return this.name;
};

function Bar(name, label) {
    Foo.call(this, name);
    this.label = label;
}

Object.setPrototypeOf( Bar.prototype, Foo.prototype );

Bar.prototype.myLabel = function () {
    return this.label;
};
var a = new Bar("a", "obj a");
console.log(a.myName());

console.log(a instanceof Foo);
console.log(a instanceof Bar);
```

#### isPrototypeOf








#### protorype 的尽头

看到这么多函数, 总是令人沮丧 =.= 

`Object.prototype`

> `Object.prototype.constructor`
>    特定函数，用于创建一个函数的原型
>
> [`Object.prototype.__defineGetter__()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/__defineGetter__)
> 关联一个函数到一个属性,访问该函数时，执行该函数并返回其返回值。
>
> [`Object.prototype.__defineSetter__()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/__defineSetter__)
> 关联一个函数到一个属性。 设置该函数的时候，执行该修改函数。
>
> [`Object.prototype.__lookupGetter__()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/__lookupGetter__)
> 返回使用 _ *defineGetter* _定义的方法函数
>
> [`Object.prototype.__lookupSetter__()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/__lookupSetter__)
> 返回使用 _ *defineSetter* _定义的方法函数
>
> `Object.prototype.hasOwnProperty()`
> 返回一个布尔值，表示某个对象是否含有指定的属性，而且此属性非原型链继承的。
>
> `Object.prototype.isPrototypeOf()`
> 返回一个布尔值，表示指定的对象是否在本对象的原型中。
>
> `Object.prototype.propertyIsEnumberable()`
> 判断指定属性是否可枚举。
>
> `Object.prototype.toLocaleString()`
> 直接调用toString()方法
>
> `Object.prototype.valueOf()`
> 返回指定对象原始值











