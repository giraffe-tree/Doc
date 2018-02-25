# MQTT

## 参考链接

http://dataguild.org/?p=6817

### 入门

start

```
mosquitto -c /etc/mosquitto/mosquitto.conf
```


```
mosquitto_sub -d -t 'floor-5/temperature'
```

查看端口

```
lsof -i:8000
```

#### QOS

qos quality of service 服务质量










