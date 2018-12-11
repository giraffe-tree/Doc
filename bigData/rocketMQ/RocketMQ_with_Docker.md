# RocketMQ with Docker

## centos7

先配置下`git`

```sh
git config --global user.name GiraffeTree
git config --global user.email giraffetree1@gmail.com
ssh-keygen -t rsa -C "giraffetree1@gmail.com"
```

## 下载

```sh
wget https://github.com/apache/rocketmq-externals/archive/master.zip
unzip master.zip
cd rocketmq-externals-master/rocketmq-docker/4.3.0/
./play-docker.sh
```

`git clone`太慢了, 所以这里直接下载了压缩包. README 文档见: (Quick start: Build and run RocketMQ with a single instance
)[https://github.com/apache/rocketmq-externals/blob/master/rocketmq-docker/README.md]

## 结束了么???

```sh
docker ps
out:
d0f3f1e41cc1        apache/rocketmq-broker:4.3.0    "/bin/sh -c 'cd ${RO…"   5 seconds ago       Up 5 seconds        0.0.0.0:10909->10909/tcp, 0.0.0.0:10911->10911/tcp                                                                                              rmqbroker
5fe13a55b08c        apache/rocketmq-namesrv:4.3.0   "/bin/sh -c 'cd ${RO…"   6 seconds ago       Up 5 seconds        0.0.0.0:9876->9876/tcp                                                                                                                          rmqnamesrv
```

OK,结束了. 感叹一句, docker 真的强大, 啥都没干就搭好了.

## 




