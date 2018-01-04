# JavaScript

## 使用

<script></script>

通常会把 js 脚本放在 head 标签中


## js的作用

更改标签

	```
	<p id="pid">hello p! </p>
    <script>
        document.getElementById("pid").innerHTML="hello world";
    </script>
	```
	
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





