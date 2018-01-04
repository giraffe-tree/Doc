# AJAX

## 使用

1. 创建 XMLHttpRequest 对象

	```
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	```

2.  向服务器发送请求

	```
	xmlhttp.open("GET","demo_get.asp",true);
	xmlhttp.send();
	```
	
	**open**: 规定请求的类型、URL 以及是否异步处理请求。

	- **method**：请求的类型；GET 或 POST
	- **url**：文件在服务器上的位置
	- **async**：true（异步）或 false（同步）

	或者你也可以使用 post 请求

	```
	xmlhttp.open("POST","ajax_test.asp",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("fname=Bill&lname=Gates");
	```
	
	使用```setRequestHeader(header,value)``` 向请求添加 HTTP 头。

	- **header**: 规定头的名称
	- **value**: 规定头的值

3. 服务器响应

	如需获得来自服务器的响应，请使用 XMLHttpRequest 对象的 responseText 或 responseXML 属性。
	
	- **responseText**	获得字符串形式的响应数据。
	- **responseXML**	获得 XML 形式的响应数据。

	```
	document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
	```


### 注意

AJAX 指的是异步 JavaScript 和 XML（Asynchronous JavaScript and XML）。

XMLHttpRequest 对象如果要用于 AJAX 的话，其 open() 方法的 async 参数必须设置为 true


### onreadystatechange 事件
 
1. readyState 属性存有 XMLHttpRequest 的状态信息。
2. 每当 readyState 改变时，就会触发 onreadystatechange 事件。

- onreadystatechange	
	- 存储函数（或函数名），每当 readyState 属性改变时，就会调用该函数。
- readyState	
	- 存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。
		- 0: 请求未初始化
		- 1: 服务器连接已建立
		- 2: 请求已接收
		- 3: 请求处理中
		- 4: 请求已完成，且响应已就绪
- status	
	- 200: "OK"
	- 404: 未找到页面


	```
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
	    }
	  }

	```

### callback 函数

callback 函数是一种以参数形式传递给另一个函数的函数。

经典示例

```
<script type="text/javascript">
var xmlhttp;
function loadXMLDoc(url,cfunc)
{
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=cfunc;
xmlhttp.open("GET",url,true);
xmlhttp.send();
}
function myFunction()
{
loadXMLDoc("/ajax/test1.txt",function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
  });
}
</script>

```












