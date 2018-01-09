# apache 和 php 安装,启动

### php 实现使用钉钉账号登录

http://g.alicdn.com/dingding/opendoc/docs/_identityverify/tab5.html?t=1467363848064

### apache 安装

关于apache下启动php的最重要的一点

**apache和php的VC版本要保持一致!**


1. http://blog.csdn.net/caoshangpa/article/details/52943672
2. 报错：the requested operation has failed 
	
	http://blog.csdn.net/wobeatit/article/details/75212419

### 使用钉钉二维码登录

	https://oapi.dingtalk.com/connect/qrconnect?appid=APPID&response_type=code&scope=snsapi_login&state=STATE&redirect_uri=REDIRECT_URI

### apache 启动

1.  no installed service named "Apache2.4"

	```
	httpd.exe -k start
	```

2. systax error on line 181 of D:/...../conf/httpd.conf: cannot load php安装目录/php7apache2_4.dll into server

	```
	httpd.exe -w -n "Apache2.4" -k start 
	```

	httpd.exe 启动参数:

	```
	https://www.cnblogs.com/azhw/p/6170949.html
	```


3. 卸载


	```
	sc delete apache
	```
	


# 基础

## PHP 有三种不同的变量作用域：

1. local（局部）
2. global（全局）
3. static（静态）


	函数之外声明的变量拥有 Global 作用域，只能在函数以外进行访问。
	函数内部声明的变量拥有 LOCAL 作用域，只能在函数内部进行访问。

###  $GLOBALS[index] 

PHP 同时在名为 $GLOBALS[index] 的数组中存储了所有的全局变量。下标存有变量名。这个数组在函数内也可以访问，并能够用于直接更新全局变量。


## echo 和 print 之间的差异：

1. echo - 能够输出一个以上的字符串
2. print - 只能输出一个字符串，并始终返回 1
3. echo 比 print 稍快，因为它不返回任何值。

## PHP 数据类型

字符串、整数、浮点数、逻辑、数组、对象、NULL。

### 字符串函数

1. strlen()  
	
	返回字符串的长度

2. strpos()

	检索字符串内指定的字符或文本。

其他string 函数

	http://www.w3school.com.cn/php/php_ref_string.asp

### 字符串运算符

	```
	$string1 = "abc";
	$string2 = "def";

	$txt1 = $string1.$string2;

	echo $txt1;
	```


## 常量

常量类似变量，但是常量一旦被定义就无法更改或撤销定义。

	```
	define("GREETING", "Welcome to W3School.com.cn!",true);
	echo GREETING;
	```

	true :对大小写不敏感
	false: 对大小写敏感


## 比较

运算符	|名称	|例子	|结果
----
==	|等于|	$x == $y	|如果 $x 等于 $y，则返回 true。
===	|全等（完全相同）|	$x === $y	|如果 $x 等于 $y，且它们类型相同，则返回 true。
!=	|不等于|	$x != $y	|如果 $x 不等于 $y，则返回 true。
<>	|不等于	|$x <> $y	|如果 $x 不等于 $y，则返回 true。
!==	|不全等|（完全不同）	|$x !== $y	如果 $x 不等于 $y，或它们类型不相同，则返回 true。
>	|大于|	$x > $y	|如果 $x 大于 $y，则返回 true。
<	|大于	|$x < $y|	如果 $x 小于 $y，则返回 true。
>=	|大于或等于|	$x >= $y	|如果 $x 大于或者等于 $y，则返回 true.
<=	|小于或等于	|$x <= $y|	如果 $x 小于或者等于 $y，则返回 true。


## 逻辑运算符

	and && 
	or ||
	xor 
	!

## 数组运算

	+ 
	 == 
	===  
	!=  <> 
	!==

## switch 

	实质是用 == 进行的比较

## foreach 循环

foreach 循环只适用于数组，并用于遍历数组中的每个键/值对。

	```
	$colors = array("red","green","blue","yellow"); 

	foreach ($colors as $value) {
	  echo "$value <br>";
	}

	```


## 在 PHP 中，有三种数组类型：

1. 索引数组 - 带有数字索引的数组
2. 关联数组 - 带有指定键的数组
3. 多维数组 - 包含一个或多个数组的数组


### 数组长度

count() 函数用于返回数组的长度（元素数）：

### 数组排序

sort

	当排序关联数组时,使用的是value排序

	```
	$age=array("Bill"=>"35","Steve"=>"31","Peter"=>"43");

	foreach($age as $x=>$x_value) {
	  echo "Key=" . $x . ", Value=" . $x_value;
	  echo "<br>";
	}

	sort($age);

	foreach($age as $x=>$x_value) {
	  echo "Key=" . $x . ", Value=" . $x_value;
	  echo "<br>";
	}
	```

rsort()

	对数组进行降序排序,把值从大到小排序

asort()

	根据值对关联数组排序,从小到大,升序
	根据值对数组进行降序排序 - arsort()

ksort()

	根据键对数组进行升序排序 - ksort()
	根据键对数组进行降序排序 - krsort()

## 超全局变量

PHP 中的许多预定义变量都是“超全局的”，这意味着它们在一个脚本的全部作用域中都可用。在函数或方法中无需执行 global $variable; 就可以访问它们。

	$GLOBALS
	$_SERVER
	$_REQUEST
	$_POST
	$_GET
	$_FILES
	$_ENV
	$_COOKIE
	$_SESSION

```PHP $_REQUEST``` 收集html表单提交的数据

 $_POST 广泛用于收集提交 method="post" 的 HTML 表单后的表单数据。$_POST 也常用于传递变量。


## include 

include （或 require）语句会获取指定文件中存在的所有文本/代码/标记，并复制到使用 include 语句的文件中。
包含文件很有用，如果您需要在网站的多张页面上引用相同的 PHP、HTML 或文本的话。


### include / require 

通过 include 或 require 语句，可以将 PHP 文件的内容插入另一个 PHP 文件（在服务器执行它之前）。

include 和 require 语句是相同的，除了错误处理方面：

	require 会生成致命错误（E_COMPILE_ERROR）并停止脚本
	include 只生成警告（E_WARNING），并且脚本会继续


	```
	include 'filename';
	require 'filename';
	```



### @

@是可以屏蔽函数执行过程中遇到问题而产生的一些错误、警告信息，这样用户就看不到程序的出错信息。这样除了用户界面会友好一些外，更重要的是安全性，因为屏蔽了出错文件的路径等信息。


### 传址调用


### php 不支持 curl 的终极解决方案

[ php 不支持 curl 的终极解决方案](http://blog.csdn.net/etongs/article/details/73321929)


## http请求


### GET

```
require_once(__DIR__. "/../action.php");

$url='http://localhost:8888/user/1';
//$html = file_get_contents($url);
//$user = json_decode($html);

$action1 = new Action();
$html =  $action1->curl_get($url);
$user = json_decode($html);

echo $user -> name;

```


### POST


### 回调函数

