## 钉钉扫码登录

https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.qnyMTL&treeId=168&articleId=104882&docType=1

https://g.alicdn.com/dingding/opendoc/docs/_server/tab12.html#获取用户授权的个人信息

### 获取appid,appsecret

钉钉开发者平台 => 左侧菜单-自助申请 => appId , appSecret



## 普通用户扫码登录

### 获取 accesstoken 

get:

	https://oapi.dingtalk.com/sns/gettoken?appid=APPID&appsecret=APPSECRET

返回
	
	{
    "access_token": "070c171a26d633d1b631dxxxxxxxx",
    "errcode": 0,
    "errmsg": "ok"
	}
	


### 获取用户的持久授权码
	
post: 

	{
    "tmp_auth_code": "23152698ea18304da4d0ce1xxxxx"
	}

 	https://oapi.dingtalk.com/sns/get_persistent_code?access_token=ACCESS_TOKEN

return:

	{
    "errcode": 0,
    "errmsg": "ok",
    "openid": "liSii8KCxxxxx",
    "persistent_code": "dsa-d-asdasdadHIBIinoninINIn-ssdasd",
    "unionid": "7Huu46kk"
	}




### 获取该用户授权的SNS_TOKEN

post: 

	{
    "openid": "liSii8KCxxxxx",
    "persistent_code": "dsa-d-asdasdadHIBIinoninINIn-ssdasd"
	}

	https://oapi.dingtalk.com/sns/get_sns_token?access_token=ACCESS_TOKEN

return :

	{
    "errcode": 0,
    "errmsg": "ok",
    "expires_in": 7200,
    "sns_token": "c76dsc87ds6c876sd87csdcxxxxx"
	}

### 获取用户授权的个人信息

get:

	https://oapi.dingtalk.com/sns/getuserinfo?sns_token=SNS_TOKEN

return : 

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


## 企业用户登录


### 获取access_token

get:

	https://oapi.dingtalk.com/sns/gettoken?appid=APPID&appsecret=APPSECRET

返回
	
	{
    "access_token": "070c171a26d633d1b631dxxxxxxxx",
    "errcode": 0,
    "errmsg": "ok"
	}
	

### 获取 JSticket

	企业应用如果配置了IP白名单，则请求域名的地址必须在IP白名单里面，且2小时之内通过接口重新请求的jsticket值都会变。如果企业没有配置IP白名单，则2小时之内通过接口重新请求的jsticket值不会变，只是jsticket值的生命周期重新延长2小时。

	通过调用获取jsticket的接口获取企业的jsticket。

get 
	
	https://oapi.dingtalk.com/get_jsapi_ticket?access_token=ACCESS_TOKE

return 
	
	{
    "errcode": 0,
    "errmsg": "ok",
    "ticket": "dsf8sdf87sd7f87sd8v8ds0vs09dvu09sd8vy87dsv87",
    "expires_in": 7200
	}

### 获取签名参数

在前端进行免登鉴权之前，我们要先拿到一些免登鉴权的参数，主要有’url’，‘nonceStr’，‘agentId’，‘timeStamp’，‘corpId’


### 计算签名信息

...

--------------------------



### auth.php

- doku.php
	- init.php
		- inc/load.php
			- auth.php
				- auth_setup()函数  在init 224行调用






















