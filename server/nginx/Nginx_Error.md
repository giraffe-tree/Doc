# Nginx Error 


####  nginx: [error] open() "/var/run/nginx.pid" failed (2: No such file or directory)

[root@TEST nginx]# sudo nginx -c /etc/nginx/nginx.conf
[root@TEST nginx]# nginx -s reload

#### 配置转发端口

```
	location /snore/{
		proxy_pass http://localhost:8801/;
	}

```