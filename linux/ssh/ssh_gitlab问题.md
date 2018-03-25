## ssh gitlab 问题

ssh-keygen -t rsa -f ~/.ssh/gitlab_rsa -P '' -C "15355498770@163.com"

ssh-agent bash && ssh-add  ~/.ssh/gitlab_rsa

ssh git@你的GIT服务器地址

git@47.97.199.139:giraffe/test.git

ssh -T git@github.com



查看磁盘使用: df -hl

docker exec -it gitlab update-permissions

gitlab-ctl reconfigure

https://www.dwhd.org/20160718_081032.html

## gitlab github ssh key 共存问题

https://www.w3ctech.com/topic/2040