# JWT

JSON WEB TOKEN


## 内容

{base64(header)}.{base64(payload)}.{Signature}

### header


```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

### payload

官方定义

- iss (issuer)：签发人
- exp (expiration time)：过期时间
- sub (subject)：主题
- aud (audience)：受众
- nbf (Not Before)：生效时间  实施者可以提供一些小的余地，通常不超过几分钟，以解决时钟偏差。
- iat (Issued At)：签发时间
- jti (JWT ID)：编号

```json
{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}
```

### signature


计算方式

```
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  secret)
```


## 参考

1. http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html
2. rfc7519 https://tools.ietf.org/html/rfc7519


