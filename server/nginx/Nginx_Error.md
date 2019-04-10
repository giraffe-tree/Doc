# Nginx Error 


####  nginx: [error] open() "/var/run/nginx.pid" failed (2: No such file or directory)

1. 之前尝试的方法

```
[root@TEST nginx]# sudo nginx -c /etc/nginx/nginx.conf
[root@TEST nginx]# nginx -s reload
```

2. 最近使用的方法

```shell
ps -ef | grep nginx
# 找到 nginx master 进程, 杀死它
kill -TERM 27046
# 再次启动nginx
nginx
```

#### 配置转发端口

主配置文件：

```
	location /snore/{
		proxy_pass http://localhost:8801/;
	}
```

子配置文件：

```
server {
        listen 80;
        server_name 47.97.xxx.xxx;
        # root         /usr/share/nginx/html;

        # location / {
        # }

        location /snore/ {
            proxy_pass http://localhost:8801/;
        }

}
```
