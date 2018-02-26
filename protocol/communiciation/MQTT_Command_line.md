# MQTT Command line

## 入门

start

```
mosquitto -c /etc/mosquitto/mosquitto.conf
```

```
mosquitto_sub -d -q 2 -t 'floor-5/temp'

mosquitto_pub -d -q 2 -t 'floor-5/temp' -m '15' -u user -P password
```

查看端口

```
lsof -i:8000
```
