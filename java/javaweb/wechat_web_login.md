# 微信网页授权

## 两种scope

1、以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid的，并且是静默授权并自动跳转到回调页的。用户感知的就是直接进入了回调页（往往是业务页面）

2、以snsapi_userinfo为scope发起的网页授权，是用来获取用户的基本信息的。但这种授权需要用户手动同意，并且由于用户同意过，所以无须关注，就可在授权后获取该用户的基本信息。



## 第一步

```
https://open.weixin.qq.com/connect/oauth2/authorize?
appid=APPID
&redirect_uri=REDIRECT_URI
&response_type=code
&scope=SCOPE
&state=STATE#wechat_redirect 
```

若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。


如果用户同意授权，页面将跳转至 ```redirect_uri/?code=CODE&state=STATE```

## 第二步：通过code换取网页授权access_token



获取code后，请求以下链接获取access_token：  

```
https://api.weixin.qq.com/sns/oauth2/access_token?
appid=APPID
&secret=SECRET
&code=CODE
&grant_type=authorization_code
```

返回

```
{ "access_token":"ACCESS_TOKEN",
"expires_in":7200,
"refresh_token":"REFRESH_TOKEN",
"openid":"OPENID",
"scope":"SCOPE" }
```

## 第四步：拉取用户信息(需scope为 snsapi_userinfo)

http：GET（请使用https协议） 

```
https://api.weixin.qq.com/sns/userinfo?
access_token=ACCESS_TOKEN
&openid=OPENID
&lang=zh_CN
```

返回

```
{    
"openid":" OPENID",
" nickname": NICKNAME,
"sex":"1",
"province":"PROVINCE"
"city":"CITY",
"country":"COUNTRY",
"headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
"privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
"unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
}

```


## 检验授权凭证（access_token）是否有效


http：GET（请使用https协议）

```
https://api.weixin.qq.com/sns/auth?
access_token=ACCESS_TOKEN
&openid=OPENID
```

返回

```
{ "errcode":0,"errmsg":"ok"}
```



