git 使用总结

###git官网
> https://git-scm.com/
###参考网址,也是本片总结主要来源
> https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000

###查看自己的用户名和邮箱地址：
>　$ git config user.name
　　$ git config user.email

###修改自己的用户名和邮箱地址：
>　$ git config --global user.name "xxx"
　　$ git config --global user.email "xxx"

###查看修改
> git diff 命令
如：git diff readme.txt

> cat readme.txt 查看内容

###查看历史
git log
git log --pretty=oneline
前面的一长串数字是版本号
	> 60c0d737d91df700aa7dd8f2f3cbf8c5b53de6e4 (HEAD -> master) new
c9bb20f865d7c808fcb6c5f26aa4db7a472bbf8f add distributed
507be92991da4dd6d812967bee428de0518d7eaf wrote a readme file

###回退版本
head 表示当前版本
head^ 上个版本
head^^ 上上个版本
head~100 上100个版本

git reset --hard head^  回到前面一个版本
git reset --hard 60c0d  找一个版本，60c0d 为某一版本的前几位版本号

git reflog 记录了你的每一次的命令

###工作区和暂存区
Git的版本库里存了很多东西，其中最重要的就是称为stage（或者叫index）的暂存区，
还有Git为我们自动创建的第一个分支master，以及指向master的一个指针叫HEAD。

- 第一步是用git add把文件添加进去，实际上就是把文件修改添加到暂存区；
- 第二步是用git commit提交更改，实际上就是把暂存区的所有内容提交到当前分支。
	因为我们创建Git版本库时，Git自动为我们创建了唯一一个master分支，所以，现在，git commit就是往master分支上提交更改。
简单的理解就是：需要提交的文件修改通通放到暂存区，然后，一次性提交暂存区的所有修改。

一旦提交后，如果你又没有对工作区做任何修改，那么工作区就是“干净”的：
> nothing to commit (working directory clean)
	nothing to commit, working tree clean

###为什么Git比其他版本控制系统设计得优秀?
- 因为Git跟踪并管理的是修改，而非文件。

###撤销修改

1.当工作区提交，还没有add到暂存区时，
git checkout -- readme.txt
或者 git checkout readme.txt
		正确的做法是使用 --，这样它后面的字符串不会当做“树”，而认为是文件路径。
> 命令git checkout -- readme.txt
意思就是，把readme.txt文件在工作区的修改全部撤销，这里有两种情况：
一种是readme.txt自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；
一种是readme.txt已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。
总之，就是让这个文件回到最近一次git commit或git add时的状态。

2.当你 add到了暂存区，想撤回时
use "git reset HEAD <file>..." to unstage
- ① git reset HEAD readme.txt
Git同样告诉我们，用命令git reset HEAD file可以把暂存区的修改撤销掉（unstage），重新放回工作区.
然后再使用
- ② git checkout -- readme.txt，清除工作区修改

> 或者一步到位
   git reset --hard head

###删除文件
假如现在你在文件服务器删除了一个文件
1.你要从版本库中也删掉这个文件
git rm test.txt
git commit -m "remove test.txt"
因为使用了git rm test.txt，
是同时删除了工作区的test.txt文件，并且将删除的动作提交到了暂存区。
2.要撤回删除
git checkout HEAD -- test.txt
或者
git checkout HEAD test.txt


###创建SSH KEY
ssh-keygen -t rsa -C "youremail@example.com"
将本地仓库与远程仓库关联
-  git remote add origin https://github.com/xxxx.git
- git remote add origin https://github.com/cc19941109/Doc.git
- 添加后,远程库的名字就是origin
查看当前所有远程仓库：git remote -v
解除其中一个远程仓库: git remote rm <远程库名>
本地多个ssh
- http://blog.csdn.net/chaihuasong/article/details/37886139


###推送
- git push -u origin master
> 把本地库的内容推送到远程，用git push命令，实际上是把当前分支master推送到远程。
由于第一次推送远程库是空的，我们第一次推送master分支时，加上了-u参数，Git不但会把本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来，在以后的推送或者拉取时就可以简化命令。

> 从现在起，只要本地作了提交，就可以通过命令：
$ git push origin master

###从远程库克隆
git clone https://github.com/cc19941109/testRepository.git
git clone git@github.com:cc19941109/testRepository.git
> GitHub给出的地址不止一个，还可以用https://github.com/cc19941109/testRepository.git这样的地址。实际上，Git支持多种协议，默认的git://使用ssh，但也可以使用https等其他协议。
git支持多种协议，包括https，但通过ssh支持的原生git协议速度最快。
使用https除了速度慢以外，还有个最大的麻烦是每次推送都必须输入口令，但是在某些只开放http端口的公司内部就无法使用ssh协议而只能用https.

###分支管理
 - 其他版本控制系统如SVN等都有分支管理，但是用过之后你会发现，这些版本控制系统创建和切换分支比蜗牛还慢，简直让人无法忍受，结果分支功能成了摆设，大家都不去用。
但Git的分支是与众不同的，无论创建、切换和删除分支，Git在1秒钟之内就能完成！无论你的版本库是1个文件还是1万个文件。
- HEAD指向的当前分支就是当前版本

####创建分支
git checkout -b dev
> git checkout命令加上-b参数表示创建并切换，相当于以下两条命令：
- git branch dev  创建分支
- git checkout dev  切换分支

####合并分支
- git checkout master  切换分支
- git merge dev 合并指定分支到当前分支
git 会提示 Fast-forward 快进模式
	也就是直接把master指向dev的当前提交，所以合并速度非常快。
-git branch -d dev  删除分支

- 分支合并冲突
> Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.

- git status
> Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)
You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)
Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   README.md
no changes added to commit (use "git add" and/or "git commit -a")

####查看分支情况
git log --graph --pretty=oneline --abbrev-commit

###分支管理策略
--no-ff指的是强行关闭fast-forward方式
> $ git merge --no-ff -m "merge with no-ff" dev
- Merge made by the 'recursive' strategy.
 readme.txt |    1 +
 1 file changed, 1 insertion(+)

recursive 递归
查看分支历史： git log --graph --pretty=oneline --abbrev-commit
合并分支时，加上--no-ff参数就可以用普通模式合并，合并后的历史有分支，能看出来曾经做过合并，而fast forward合并就看不出来曾经做过合并。

###stash BUG分支
> Git还提供了一个stash功能，
可以把当前工作现场“储藏”起来，等以后恢复现场后继续工作：
$ git stash
Saved working directory and index state WIP on dev: 6224937 add merge
HEAD is now at 6224937 add merge

> 刚才的工作现场存到哪去了？用git stash list命令看看：
工作现场还在，Git把stash内容存在某个地方了，但是需要恢复一下，有两个办法：
一是用git stash apply恢复，但是恢复后，stash内容并不删除，你需要用git stash drop来删除；
二是用git stash pop，恢复的同时把stash内容也删了：

> 修复bug时，我们会通过创建新的bug分支进行修复，然后合并，最后删除；
当手头工作没有完成时，先把工作现场git stash一下，然后去修复bug，修复后，再git stash pop，回到工作现场。

###feature 分支
开发一个新feature，最好新建一个分支；
如果要丢弃一个没有被合并过的分支，可以通过git branch -D <name>强行删除。

###多人协作
- 查看远程库的信息，用git remote
	用git remote -v显示更详细的信息
- 推送分支
> $ git push origin master
如果要推送其他分支，比如dev，就改成：
$ git push origin dev

- 问题，两个人同时推送
因为你的小伙伴的最新提交和你试图推送的提交有冲突，解决办法也很简单，Git已经提示我们，先用git pull把最新的提交从origin/dev抓下来，然后在本地合并，解决冲突，再推送

- 多人协作的工作模式通常是这样：
首先，可以试图用git push origin branch-name推送自己的修改；
如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
如果合并有冲突，则解决冲突，并在本地提交；
没有冲突或者解决掉冲突后，再用git push origin branch-name推送就能成功！
如果git pull提示“no tracking information”，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream branch-name origin/branch-name。
这就是多人协作的工作模式，一旦熟悉了，就非常简单。

在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；
从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。

###tag
命令git tag <name>用于新建一个标签，默认为HEAD，也可以指定一个commit id；
- git tag v1.0
- git tag v0.9 6224937
git tag -a <tagname> -m "blablabla..."可以指定标签信息；
用命令git tag查看所有标签
命令git tag可以查看所有标签
命令git show <tagname>可以看到说明文字
创建带有说明的标签，用-a指定标签名，-m指定说明文字：
- $ git tag -a v0.1 -m "version 0.1 released" 3628164

###删除，推送

删除：
> git tag -d v0.1
推送某个标签到远程
> git push origin <tagname>
一次性推送全部尚未推送到远程的本地标签
> git push origin --tags
如果标签已经推送到远程，要删除远程标签就麻烦一
> 1.先从本地删除：
$ git tag -d v0.9
2.然后，从远程删除。
$ git push origin :refs/tags/v0.9






