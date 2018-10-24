# tensorboard http

## 在局域网内连接

```
tensorboard --host server.address --logdir='path/to/log'
# 示例
# tensorboard --host 192.168.2.112 --logdir='logs/'
```

## 内网穿透

从网上下载内网穿透工具, 如(我用的是花生壳),直接远程 http 访问 tensorboard

## ssh 转发

https://blog.csdn.net/zhaokx3/article/details/70994350

https://stackoverflow.com/questions/38513333/is-it-possible-to-see-tensorboard-over-ssh

