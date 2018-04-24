# Linux command

## Tutorial 

### chapter 1 


```
ls 目录名
 
ls -a  查看全部

cd .  到达当前目录

cd .. 到达上一级目录

pwd  查看当前目录

mkdir  新建目录

touch  新建文件

```

### chapter 2

```
cp 源文件  目标目录

mv  file1 file2  可以用来 rename

rm  

rmdir  只能删除非空目录

clear  清屏

cat 查看文件内容

less 查看一页内容 空格 翻页  q  退出   /aaa  查找 aaa  n 查看下一个

head -6 a.txt  查看开头的6行

tail 查看末尾的几行

grep -i hello a.txt 在 a.txt 中查找 hello  , -i 为忽视大小写

grep -ivn 'hello world'  a.txt 使用 -v 显示不匹配的 lines  -n 显示行数

grep -ivc Hello a.txt  使用 -c 只显示行数

wc  -w a.txt 统计单词数  -l 统计行数

```

### chapter 3

```
cat > 文件名  新建(覆盖)文件 + 编辑

cat >> 文件名  追加

cat class.txt hello.txt > biglist.txt  合并文件

sort a.txt  顺序输出

% sort <  a.txt > b.txt  顺序输出,并存入文件

who    //To see who is on the system with you, type

who > names.txt 输出到 txt 中

who | sort -r   逆序输出 who

who | wc -l  查看 who 的行数

```

总结

```
command > file	redirect standard output to a file
command >> file	append standard output to a file
command < file	redirect standard input from a file
```

### chapter 4

```
ls *.txt   查看 txt 文件

ls abc?t.txt   其中 ? 代表一个字符   

man wc  查看 wc 命令的详情,用的是 less

whatis wc  给出一行的描述

apropos 命令名   // 如果不清楚使用哪个命令,则使用

```

### chapter 5 

```
[root@iZbp193yy46icaga1srlt6Z test]# ls -l
总用量 16
-rw-r--r-- 1 root root  122 2月  25 12:37 a.txt
-rw-r--r-- 1 root root  122 2月  25 13:37 b.txt
drwxr-xr-x 2 root root 4096 2月  25 12:02 doc
-rw-r--r-- 1 root root  112 2月  25 13:43 names.txt

```

10个字符,若为文件则为 ```-```开头,目录为```d```开头

其他9个字符,分为3组

> 第一组为 拥有该文件的用户的权限
> 
> 第二组为 拥有该文件的组的权限
> 
> 第三组为 其他用户的权限

权限:

> r allows users to list files in the directory;(读)

> w means that users may delete files from the directory or move files into it;(编辑/删除)

>x means the right to access files in the directory. This implies that you may read files in the directory provided you have read permission on the individual files. (执行文件)

#### chmod

Only the owner of a file can use chmod to change the permissions of a file. 

```
chmod go-rwx biglist //to remove read write and execute permissions on the file biglist for the group and others

chmod a+rw biglist  //To give read and write permissions on the file biglist to all

```

#### ps (process status)

To see information about your processes, with their associated PID and status

```
ps

sleep 1000 &   //休眠1000s

// crtl + z 挂起

bg  后台任务

jobs  

fg %1  重启 job

kill %1  // To kill a suspended or background process, type

```

进程拒绝关闭

```
// If a process refuses to be killed, uses the -9 option, i.e. type

kill -9 {process number}

```

### chapter 6 

#### find

```
find . -name "*.txt" -print  // 在该目录下,查看所有txt 文件

find . -size +1M -ls  //查看该目录下,所有大于1mb 的文件
```

####  history (show command history list)

```
!! (recall last command)

!-3 (recall third most recent command)

!5 (recall 5th command in list)

!grep (recall last command starting with grep)

```

### chapter 7

http://www.ee.surrey.ac.uk/Teaching/Unix/unix7.html

listener.tcp.default = 127.0.0.1:1883

ps -ef | grep beam.smp


# Common commands

## yum

### 查询

```
yum list 


```


## 文件

#### 文件夹 远程

```
scp -r /home/administrator/test/ root@192.168.1.100:/root/
```

#### 文件夹 创建

```
## 创建多级文件夹
mkdir -p data/2018/april/
```










