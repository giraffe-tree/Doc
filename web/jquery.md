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














