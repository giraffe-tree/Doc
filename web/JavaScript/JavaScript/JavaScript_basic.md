# JavaScript

## 基础

1. js顺序执行
2. js标识符 $,_,字母 开头
3. 对大小写敏感
4. 注释 //  /*  */

### 数据类型

1. string
2. number
3. boolean
4. array

	```
	var arr1 = new Array("hello","hello2");
	arr[0] = "hello update";
	document.write(arr[0]);
	```

5. object
6. null

	```
	var nuVar = null;
	document.write(nuVar);// 输出 null
	```
	
7. 未定义 undefined

	```
	var unDefinedVar ;
	document.write(unDefinedVar);//输出 undefined
	```


8. 可以通过赋值为 null 来清除变量

### 变量

var 


```
var i = 10;
var j = 11;
var m = i+j;
document.write(m);
	
```

### 运算符

运算符:

- 算数运算 

	```+ - * / % ++ --```

-  赋值运算

	```=  +=  -=  *=  /=  %=```

- 字符串比较

	任何类型和字符串相加,都会转换成字符串

- 比较运算

	```==  ===  !=  !==  >  <  >=  <= ```

- 逻辑运算

	```&&  ||  !```

- 条件运算

	``` ? :```

#### 需要注意的是 

1. == 比较的是值
2. === 比较的是值和类型

	```
	document.write("1"==1);
	document.write("1"===1);
	```

### if else

### for 循环

```
var arr = [1,3,45,6,76];
for(var a in arr){
    document.write(arr[a]+"<br>");
    if(a ==1){
    	break;
    }
}

```

### while 循环

```
var x = 0;

while(x<10){
    x++;
    document.write(x+"<br>");
}
```

### 函数

函数是有事件驱动或者当它被调用时执行的可重复使用的代码块.

```
function add(x,y) {
        return x+y;
    }
document.write(add(1,2))
```

#### 函数调用

```
<form>
    <input type="button" value="按钮" onclick="add(1,2)">
</form>

<button onclick="add(1,2)">get</button>

<script>
   function add(x,y) {
        document.write(x+y);
    }
</script>

```

#### 含有参数的函数

```
function add(x,y) {
        return x+y;
    }
```

### 全局变量&局部变量

```
function add(x,y) {
        z =10; //全局变量
        var a = 0 ; //局部变量

        return x+y+a;
    }

    document.getElementById("pid").innerHTML =add("hello"," cc");
    document.write(z);
```

需要注意的是:只有在```add(x,y)```函数执行后,```z```才能变成全局变量


### 引入 js 文件

```<script type="text/javascript" src="static/js/myjs.js"></script>```


### 异常

#### try catch 

模板:

```
try{
	代码块;
}catch(err){
	异常处理;
}

```

示例:

```
function demo() {
            try {
                alert(str);
            }catch(err){
                alert(err);
            }
        }
        demo();
```

会产生: ```ReferenceError: str is not defined``` 的提示

#### throw 

```
try{
        var e = document.getElementById("txt").value;
        if(e==""){
            throw "请输入"
        }
    }catch(err) {
        alert(err)
    }
```


### 事件

事件是可以被 js 侦测到的一些行为

#### 常用事件

- onClick 单击事件 
- onMouseOver  鼠标经过
- onMouseOut   鼠标移出
- onChange   文本内容改变
- onSelect   文本框选中
- onFouse    光标聚集
- onBlur    移开光标
- onLoad    网页加载
- onUnload   关闭网页

#### onclick

```
<button type="button" onclick="demo()">按钮1</button>
<script>

    function demo() {
        alert("hello");
    }
</script>
```

#### onMouseOut / onMouseOver

```
<link rel="stylesheet" type="text/css" href="static/js/style.css">

<div class="my" onmouseout="onOut(this)" onmouseover="onOver(this)"></div>

<script>
    function onOver(obj) {
        obj.innerHTML="hello";
    }
    function onOut(obj) {
        obj.innerHTML="world";
    }
</script>
```

css

```
.my{
    width: 200px;
    height: 200px;
    background-color: bisque;
}
```

#### onchange

```
<form>
    <input type="text" onchange=" changeDemo(this)">
</form>

<script>
    function changeDemo(bg) {
        alert("内容改变")
    }
</script>

```

#### onSelect

选中文本执行函数

```
<form>
    <input type="text"  onselect="onSelect(this)">
</form>

<script>
function onSelect(bg) {
        bg.style.background="red";
    }
</script>
```

## js 的 dom 对象

dom: document object model

html dom : 当网页被加载时,浏览器会创建页面的文档对象模型

1. js 改变页面的 html 元素
2. js 改变页面的 html 属性
3. js 改变页面的 css 样式
4. js 对页面上的事件作出反应

### js 改变页面的 html 元素

1. 改变 html 输出流
2. 根据 html 元素的 id/标签名, 改变它的内容
3. 改变 html 的内容 ```innerHTML```
4. 改变 html 的属性 

注意:

	不要在网页加载完成之后,使用``` document.write(" ... ")```,它会覆盖整个网页


#### 根据 id 找到元素

```
    function demo() {
        var x = document.getElementById("pid");
        x.innerHTML= "world..."
    }
```

#### 根据标签名

```
    function demo() {
        document.getElementsByTagName("p").item(0).innerHTML="world.!"
    }
```

#### 更改属性

```
<a id="aid" href="http://baidu.com">hello</a>
<button type="button" onclick="demo()">bilibili</button>

<script>
    function demo() {
        document.getElementById("aid").href="http://bilibili.com";
    }
</script>

```

#### dom 事件

dom eventListener

1. addEventListener()
2. removeEventListener()

为句柄添加多个事件,不会覆盖,即 dom 2 级事件处理

```
<script>
    var x = document.getElementById("btn");
    x.addEventListener("click",hello);
    x.addEventListener("click",world);
    function hello() {
        alert("hello");
    }
    function world() {
        alert("world");
    }
</script>
```

#### 事件流

1. 事件流,在页面中接受事件的顺序
2. 事件冒泡,由最具体的元素接受,然后逐级向上传播至最不具体的元素的节点
3. 事件捕获,最不具体的节点先接受事件,而最具体的节点应该最后接受事件

#### 事件的处理

1. html 事件处理

	```
	<button id="btn" onclick="hello()">hello</button>
	```

2. ie 事件处理程序

	- attachEvent
	- detachEvent


3. dom 0 级事件处理

	- 把一个函数赋值给一个事件处理程序属性
	- 会被覆盖

	```
		<button id="btn">hello</button>
	<script>
	
	    var btn1 = document.getElementById("btn");
	    btn1.onclick = function (ev) { alert("hello world dom 0 级") }
	    btn1.onclick = function (ev) { alert("前面的事件,被覆盖了") }
	    
	</script>
	```

4. dom 2 级事件处理

	- addEventListener(事件名,函数名,布尔值)
	- true 事件捕获
	- false 事件冒泡
	- removeEventListener


### 对象

#### 创建对象

1. new Object()

	```
	 people = new Object();
    people.name = "chen";
    people.age = "23";
    document.write("name:"+people.name);
	```

2. obj={ ... }


	```
	people ={name:"chen",age:"dasd"};

    document.write("name:"+people.name);
	```

3. 函数创建

	```
	function people(name,age) {
        this.name = name;
        this.age = age;
    }

    son = new people("chen",12);
    document.write(son.name+" "+son.age);
	```

### string对象

1. 可以使用单引号/双引号
2. 方法/属性

	- str.length 
	- indexOf(searchString: string, position?: number): number;
	- match(regexp: string | RegExp): RegExpMatchArray | null;
	- replace(searchValue: string | RegExp, replacer: (substring: string, ...args: any[]) => string): string;
	- toUpperCase(): string;
	- split(separator: string | RegExp, limit?: number): string[];


### 时间对象

创建时间

	```
	var x = new Date();
    document.write(x);
    var y = x.setFullYear(2018,1,1);
    document.write(x);
	```
	
定时,显示当前时间	
	
	```
	 function startTime() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        checkTime(h);
        checkTime(m);
        checkTime(s);
        document.getElementById("timeid").innerHTML = h+":"+m+":"+s;
        t = setTimeout(function () {
            startTime();
        },500);

    }
	```

### 数组对象

1. array 对象

	```
	var x = ["cc","dd","ee"];
	```
	
2. 使用下标访问数组
3. 数组方法

	 - concat() 合并数组 concat(...items: (T | ReadonlyArray<T>)[]): T[];
	 - sort() 排序 sort(compareFn?: (a: T, b: T) => number): this;

		```
		y = [1,3,4,2,7,9,5];
    document.write(y.sort(function (a,b) { return b-a }));

		```
	 
	 - push 末尾添加 push(...items: T[]): number; 返回长度 
	 - reverse 反转 everse(): T[]; 返回数组

### Math 对象

#### 常见方法

1. Math.round() 四舍五入

2. Math.random() 从0到1
	
	- parseInt

3. Math.max()/min()/abs()


### 事件对象

1. type 事件类型
2. target 事件目标
3. stopPropagation() 阻止事件冒泡
4. preventDefault() 阻止默认行为










	
	
	
	

