# jquery

## 引入

### 网络库

```
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
```

### 本地库

```
<head>
<script src="jquery.js"></script>
</head>
```

## 语法

jQuery 语法是为 HTML 元素的选取编制的，可以对元素执行某些操作。

基础语法是：```$(selector).action()```

### 隐藏

1. ```$(this).hide()```

	- 演示 jQuery hide() 函数，隐藏当前的 HTML 元素。

2. ```$("#test").hide()```
	
	- 演示 jQuery hide() 函数，隐藏 id="test" 的元素。

3. ```$("p").hide()```
	
	- 演示 jQuery hide() 函数，隐藏所有 <p> 元素。

4. ```$(".test").hide()```

	- 演示 jQuery hide() 函数，隐藏所有 class="test" 的元素。


### ready 文档就绪函数


```
$(document).ready(function(){
--- jQuery functions go here ----

});
```


这是为了防止文档在完全加载（就绪）之前运行 jQuery 代码。

如果在文档没有完全加载之前就运行函数，操作可能失败。下面是两个具体的例子：

1. 试图隐藏一个不存在的元素 
2. 获得未完全加载的图像的大小

### 选择器

jQuery **元素选择器**和**属性选择器**允许您通过标签名、属性名或内容对 HTML 元素进行选择。

#### 元素选择器

选择器允许您对 HTML 元素组或单个元素进行操作。

1. ```$("p")``` 选取 ```<p>``` 元素。
2. ```$("p.intro")``` 选取所有```class="intro"``` 的 ```<p>```元素。
3. ```$("p#demo")``` 选取所有 ```id="demo"``` 的 ```<p>``` 元素。


#### jQuery 属性选择器

jQuery 使用 XPath 表达式来选择带有给定属性的元素。

1. ```$("[href]")``` 选取所有带有 href 属性的元素。

2. ```$("[href='#']")``` 选取所有带有 href 值等于 ```"#" ```的元素。

3. ```$("[href!='#']")``` 选取所有带有 href 值不等于 ```"#"``` 的元素。

4. ```$("[href$='.jpg']")``` 选取所有 href 值以 ```".jpg" ```结尾的元素。


### 事件

|函数|解释|
|---|---|
|$(document).ready(function)|	将函数绑定到文档的就绪事件（当文档完成加载时）|
|$(selector).click(function)|	触发或将函数绑定到被选元素的点击事件|
|$(selector).dblclick(function)|	触发或将函数绑定到被选元素的双击事件|
|$(selector).focus(function)|	触发或将函数绑定到被选元素的获得焦点事件|
|$(selector).mouseover(function)|	触发或将函数绑定到被选元素的鼠标悬停事件|















