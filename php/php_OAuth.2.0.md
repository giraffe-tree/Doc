# php OAuth.2.0

## OAuth

开放式授权 -- open authorization,OAuth2.0 始于2010年.

## 登录步骤

####  请求 OAuth 登录页

request token url 

回调地址

#### 用户使用 qq 号登录 

$_GET['code']

code 是一个在规定时间内(10s 左右)有效,并只能使用一次的令牌信息.

#### 返回登录结果

user authorization url 用户授权的令牌请求服务地址

用户 qq 登录后要请求一个带有特定参数的 url

在 url 中带有 appid,appsecret 和 上一步骤用到的 code

#### access_token 和 refresh token

access_token 具有较长的生命周期.

qq: need_refresh_token=true 可以刷新 access_token  生命周期更长

















