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

注意，每次修改gitlab.rb配置文件之后，或者在容器里执行
gitlab-ctl reconfigure

命令，或者重启容器以让新配置生效。


http://blog.csdn.net/michael_base/article/details/77966647
