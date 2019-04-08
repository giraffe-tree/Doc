# 使用 jupyter/tensorflow-notebook 时缺失pydot, graphviz 的解决方案( jupyter  pydot, graphviz in docker )

## 概述

我在使用 `jupyter/tensorflow-notebook` 时, 使用到了 `keras.utils.vis_utils` 这里面的 `plot_model`, 但这个工具依赖了 `pydot`, 在我使用的镜像中没有默认安装, 并且`pydot` 还依赖了 `graphviz`. 

本篇文章主要解决了以下问题

1. 缺失依赖 `pydot`, `graphviz` 

   - ```
     `pydot` failed to call GraphViz.Please install GraphViz (https://www.graphviz.org/) and ensure that its executables are in the $PATH.
     ```

2. 在`docker` 容器内部权限不足的问题

## 解决

### 主要步骤

1. 在容器中拥有`root`权限
   - 需要在容器启动时指定为 `root` 用户, 如何指定请查看下面的详细步骤
   - 关于为什么要使用`root`用户呢? 因为在之后的安装中仅使用 `jovyan` 用户会有权限不足的情况
2. 安装
   - `sudo apt-get install -y graphviz libgraphviz-dev`
   - `pip install pydot graphviz`

### 详细步骤

这里先介绍下我的`image`和启动命令

```
docker run -d -p 8888:8888 -v /Users/chencheng/2019/Mar/jupyter:/home/jovyan/ --user root -e GRANT_SUDO=yes --name notebooks jupyter/tensorflow-notebook start-notebook.sh --NotebookApp.token=''
```

说明下重要参数

> `--user root` 指定用户, 确保你在容器内为`root` 用户
>
> `-e GRANT_SUDO=yes` 为`jovyan`用户提供无密码`sudo`功能。用于安装OS软件包。要使此选项生效，必须运行容器`--user root`。
>
> `--NotebookApp.token=''` 用过`jupyter` 的人都知道, 在进入`jupyter`网页时, 它会要求你输入登录密码, 因为我在自己本地跑的, 我觉得这很麻烦, 所以这里我设置成没有密码直接登录了.
>
> 如果你想了解其他参数 ->  https://github.com/Paperspace/jupyter-docker-stacks/tree/master/tensorflow-notebook

然后

```sh
# 首先你需要进入容器
docker exec -it notebooks /bin/bash
# 更新下 apt-get, 否则你可能会遇到一些问题
sudo apt-get update
# 等待安装吧
sudo apt-get install -y graphviz libgraphviz-dev
pip install pydot graphviz
```

最后你需要重启`jupyter`的`kernel`, 享受这个util给你带来的便捷了.

### 你可能遇到的问题

### Unable to locate package graphviz

你可能遇到了下面的问题, 不用担心, `sudo apt-get update` 更新完成即可使用

```
root@b46c3d4ef520:~# sudo apt-get install -y graphviz libgraphviz-dev
Reading package lists... Done
Building dependency tree
Reading state information... Done
E: Unable to locate package graphviz
E: Unable to locate package libgraphviz-dev
```

### Could not open lock file /var/lib/dpkg/lock-frontend - open (13: Permission denied)

没错, 你可能没有`root` 权限, 你需要在容器启动时设定使用 `root`, 看看启动 `docker` 容器时的命令有没有错

```
jovyan@868296237e8b:/lib$ apt-get install graphviz

E: Could not open lock file /var/lib/dpkg/lock-frontend - open (13: Permission denied)
E: Unable to acquire the dpkg frontend lock (/var/lib/dpkg/lock-frontend), are you root?
```

### 查看当前用户

```shell
whoami
```

