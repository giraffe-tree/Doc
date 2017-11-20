# http

参考:

[通过HTTP请求响应过程了解HTTP协议*](http://www.cnblogs.com/YeChing/p/6337378.html)

[http协议入门————版本更替介绍](http://www.ruanyifeng.com/blog/2016/08/http.html)


1. 域名解析
2. 发起TCP的3次握手
3. 建立TCP连接后发起http请求
4. 服务器端响应http请求，浏览器得到html代码
5. 浏览器解析html代码，并请求html代码中的资源
6. 浏览器对页面进行渲染呈现给用户

## http请求


### PUT POST

举一个简单的例子，假如有一个博客系统提供一个Web API，模式是这样http://superblogging/blogs/post/{blog-name}，很简单，将{blog-name}替换为我们的blog名字，往这个URI发送一个HTTP PUT或者POST请求，HTTP的body部分就是博文，这是一个很简单的REST API例子。我们应该用PUT方法还是POST方法？取决于这个REST服务的行为是否是idempotent的，假如我们发送两个http://superblogging/blogs/post/Sample请求，服务器端是什么样的行为？如果产生了两个博客帖子，那就说明这个服务不是idempotent的，因为多次使用产生了副作用了嘛；如果后一个请求把第一个请求覆盖掉了，那这个服务就是idempotent的。前一种情况，应该使用POST方法，后一种情况，应该使用PUT方法。

## http响应

## Http Status Code

1** 信息，服务器收到请求，需要请求者继续执行操作
2** 成功，操作被成功接收并处理
3** 重定向，需要进一步的操作以完成请求
4** 客户端错误，请求包含语法错误或无法完成请求
5** 服务器错误，服务器在处理请求的过程中发生了错误

- 200 - 请求成功
- 301 - 资源（网页等）被永久转移到其它URL
- 404 - 请求的资源（网页等）不存在
- 500 - 内部服务器错误

[HTTP状态码](http://www.runoob.com/http/http-status-codes.html)

- 200 Ok 请求成功
- 201 请求成功,并已创建新资源
- 301 Moved Permanently 永久移动
- 400 Bad Request 客户端请求的语法错误，服务器无法理解
- 401 要求用户身份认证
- 404 服务器无法找到客户端请求的资源
- 405 客户端请求中的方法被禁止
- 415 服务器无法处理请求附带的媒体格式
- 500 服务器内部错误，无法完成请求





