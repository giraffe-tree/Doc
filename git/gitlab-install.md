# gitlab 安装使用

## 参考

http://blog.csdn.net/michael_base/article/details/77966647

https://hub.docker.com/r/beginor/gitlab-ce/

## 命令

```
docker run \
    --detach \
    --hostname 192.168.1.6 \
    --publish 8000:80 \
    --name gitlab1.2 \
    --restart unless-stopped \
    --volume /mnt/sda1/gitlab/etc:/etc/gitlab \
    --volume /mnt/sda1/gitlab/log:/var/log/gitlab \
    --volume /mnt/sda1/gitlab/data:/var/opt/gitlab \
    registry.cn-hangzhou.aliyuncs.com/lab99/gitlab-ce-zh
```

注意，每次修改gitlab.rb配置文件之后，或者在容器里执行

```gitlab-ctl reconfigure```

命令，或者重启容器以让新配置生效。

```docker exec -it gitlab update-permissions```


```
docker run \
    --detach \
    --publish 8000:80 \
    --name gitlab1.1 \
    --restart unless-stopped \
    --volume /mnt/sda1/gitlab/etc:/etc/gitlab \
    --volume /mnt/sda1/gitlab/log:/var/log/gitlab \
    --volume /mnt/sda1/gitlab/data:/var/opt/gitlab \
    beginor/gitlab-ce:10.4.3-ce.0
```

关于更改端口, 迁移 gitlab

https://stackoverflow.com/questions/19335444/how-do-i-assign-a-port-mapping-to-an-existing-docker-container



