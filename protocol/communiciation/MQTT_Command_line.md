# MQTT Command line

## 入门

start

```
mosquitto -c /etc/mosquitto/mosquitto.conf
```

```
mosquitto_sub -d -q 2 -t 'floor-5/temp'

mosquitto_pub -d -q 2 -t 'Temperature' -m '15' -u proton -P proton123
```

查看端口

```
lsof -i:8000
```

```
ps aux|grep vernemq


vi /etc/vernemq/vernemq.conf

log.console.file = /var/log/vernemq/console.log

tail -10 /var/log/vernemq/console.log

vmq-admin listener show

vmq-admin listener start address=47.97.199.139 port=1884 --mountpoint /test --nr_of_acceptors=10 --max_connections=1000

vernemq config effective

// 服务器重新初始化
ssh-keygen -R 服务器端的ip地址

vmq-passwd [-c | -D] passwordfile username

```




