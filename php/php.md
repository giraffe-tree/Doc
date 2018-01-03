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
