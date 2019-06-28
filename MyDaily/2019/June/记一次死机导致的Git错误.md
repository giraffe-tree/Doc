# 记一次死机导致的 Git 错误

## 概述

事情是这样的, 那天快下班的时候, 准备提交下代码, 一共3个项目(A,B,C), 前两个项目都提交好了, 在提交第三个项目时,  不料隐疾发作, 一脚麒麟腿如雷鸣般轰出, 幸好四周空旷无边, 金精打造的地面也是坚固无比, 但由于内力太过雄厚, 这脚的劲风擦到了旁边的主机. 静止的屏幕和不再闪烁的鼠标, 仿佛在预示着一些不好的事情...

## 第二天

环境  `win7`, 版本`git version 2.15.1.windows.2` 

 ### 错误

> 项目A:  `git log` => `fatal: your current branch appears to be broken`, `git status` 正常
>
> 项目B 和项目A 同样的错误
>
> 项目C:  `git status` => `error: bad signature fatal: index file corrupt`, `git log` 正常

### fatal: your current branch appears to be broken

解决方案: 修复 `.git/refs/heads/分支名` , 例如: `.git/refs/heads/master`

#### 如何修复

1. 查找 `.git/logs/refs/heads/分支名`, 打开这个文件
2. 找到最后一次 commit 的 `commit-id`
    - 示例: 文件中最后一行如下, 第二个` commit-id` 就是最近一次的`commit-id`
    - `0b85220ef7d457319178dc960e04b209d7e5fba8 8dab031b8f57285fc403bb55eeced70b1176883f giraffetree <giraffetree1@gmail.com> 1561696990 +0800	commit: add: lala`
    - 这里的 `commit-id` 就是`8dab031b8f57285fc403bb55eeced70b1176883f ` 
3. 用文本打开 `./git/refs/heads/分支名` , 将 `commit-id` 覆盖写入该文件
4. 再次运行 `git log`, ok 正常了

#### 如何重现 your current branch appears to be broken

```shell
// 初始环境
// 提交了2次
git init
echo "hello" > hello.txt
git add .
git commit -m "init"
echo "lala" >> hello.txt
git add .
git commit -m "add: lala"
```

现在我们修改下 `./git/refs/heads/master` 文件

```shell
$ cat ./.git/refs/heads/master
8dab031b8f57285fc403bb55eeced70b1176883f
$ echo "haha you are broken" > ./.git/refs/heads/master
$ git log
fatal: your current branch appears to be broken
```

重复下 `如何修复` 中的步骤

```shell
## 下面这个脚本的含义就是 找到最后一行中的第二个 commit-id 然后写入 ./.git/refs/heads/master中
$ tail -n 1 ./.git/logs/refs/heads/master | awk '{print $2}' > ./.git/refs/heads/master
$ git log
commit 8dab031b8f57285fc403bb55eeced70b1176883f (HEAD -> master)
Author: giraffetree <giraffetree1@gmail.com>
Date:   Fri Jun 28 12:43:10 2019 +0800

    add: lala

commit 0b85220ef7d457319178dc960e04b209d7e5fba8
Author: giraffetree <giraffetree1@gmail.com>
Date:   Fri Jun 28 12:37:43 2019 +0800

    init
## 正常咯~
```

### error: bad signature fatal: index file corrupt

#### 如何修复

1. 删除 `.git/index` 文件
2. `git reset` 这个命令在执行过程中, 会重建 index 文件, 就正常啦

#### 如何重现 bad signature fatal: index file corrupt

```shell
## 输入 460 个第0位字符到 index 文件中
$ printf '%.s\x00' {1..460} > ./.git/index
$ git status
error: bad signature
fatal: index file corrupt
```







