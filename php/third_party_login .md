# third party login 

## 具体步骤

### 1. 跳转链接

#### 直接使用钉钉的登录页面


GET: 

```
https://oapi.dingtalk.com/connect/qrconnect
?appid=APPID&response_type=code
&scope=snsapi_login&state=STATE&redirect_uri=REDIRECT_URI
```

在钉钉用户扫码登录并确认后，会302到你指定的redirect_uri，**并向url参数中追加临时授权码code及state两个参数**。

例如:

```
http: //114.215.148.161/os/login.html
?fromUrl=dingtalk
&code=c90034e9e40c351f870d4f3ef969e154
&state=STATE
```

### 2. 获取用户授权的持久授权码

原理: 用第一步中的临时的 code 以及 access_token 换取 **持久授权码** 即  persistent_code

POST: 

```
https://oapi.dingtalk.com/sns/get_persistent_code
?access_token=ACCESS_TOKEN
```

post 正文:

```
{
    "tmp_auth_code": "23152698ea18304da4d0ce1xxxxx"
}
```

return:

```
{
    "errcode": 0,
    "errmsg": "ok",
    "openid": "liSii8KCxxxxx",
    "persistent_code": "dsa-d-asdasdadHIBIinoninINIn-ssdasd",
    "unionid": "7Huu46kk"
}
```


### 3. 获取用户授权的SNS_TOKEN

POST:

```
https://oapi.dingtalk.com/sns/get_sns_token
?access_token=ACCESS_TOKEN
```

POST 正文:

```
{
    "openid": "liSii8KCxxxxx",
    "persistent_code": "dsa-d-asdasdadHIBIinoninINIn-ssdasd"
}
```

return:

```
{
    "errcode": 0,
    "errmsg": "ok",
    "expires_in": 7200,
    "sns_token": "c76dsc87ds6c876sd87csdcxxxxx"
}
```

### 4. 获取用户授权的个人信息

GET:

```
https://oapi.dingtalk.com/sns/getuserinfo
?sns_token=SNS_TOKEN
```

return:

```
{ 
    "errcode": 0,
    "errmsg": "ok",
    "user_info": {
        "maskedMobile": "130****1234",
        "nick": "张三",
        "openid": "liSii8KCxxxxx",
        "unionid": "7Huu46kk",
        "dingId": "dingId"
    }
}
```



### 内嵌二维码

1. 页面引入

	```
	<script src="//g.alicdn.com/dingding/dinglogin/0.0.5/ddLogin.js"></script>
	```

2. 实例以下 js 对象

	```
	var obj = DDLogin({
     id:"login_container",
     //这里需要你在自己的页面定义一个HTML标签并设置id，
     //例如<div id="login_container"></div>
     //或<span id="login_container"></span>
     goto: "",
     style: "border:none;background-color:#FFFFFF;",
     width : "365",
     height: "400"
 });

	```

	其中goto参数需要这样构造：
	
	```
	https://oapi.dingtalk.com/connect/oauth2/sns_authorize
	?appid=APPID&response_type=code
	&scope=snsapi_login&state=STATE&redirect_uri=REDIRECT_URI
	```
	
	并且要将goto参数urlencode编码

3. 获取 login_tmp_code

	```
		var hanndleMessage = function (event) {
	        var origin = event.origin;
	        console.log("origin", event.origin);
	        if( origin == "https://login.dingtalk.com" ) { 
	        	//判断是否来自ddLogin扫码事件。
	            var loginTmpCode = event.data; 
	            //拿到loginTmpCode后就可以在这里构造跳转链接进行跳转了
	            console.log("loginTmpCode", loginTmpCode);
	        }
	 
	};
	 
	if (typeof window.addEventListener != 'undefined') {
	    window.addEventListener('message', hanndleMessage, false);
	} else if (typeof window.attachEvent != 'undefined') {
	    window.attachEvent('onmessage', hanndleMessage);
	}
	```

	通过JS获取到loginTmpCode后，需要由你构造并跳转到如下链接：
	
	```
	https://oapi.dingtalk.com/connect/oauth2/sns_authorize
	?appid=APPID
	&response_type=code
	&scope=snsapi_login
	&state=STATE
	&redirect_uri=REDIRECT_URI
	&loginTmpCode=loginTmpCode

	```
	
	此链接处理成功后，会302到你goto参数指定的redirect_uri，**并向url参数中追加临时授权码code及state两个参数**。



