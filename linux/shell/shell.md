# shell 

## reference

http://www.runoob.com/linux/linux-shell.html

## 入门示例

### hello world

```#!``` 告诉系统其后路径所指定的程序即是解释此脚本文件的 Shell 程序。

```
#!/bin/bash
echo "Hello World !"
```

需要更高权限

```
chmod +x ./test.sh  #使脚本具有执行权限
```

### 列出 目录下所有文件

```
#!/bin/bash
echo "hello world !"
name="cc"
for file in $(ls /etc); do
    echo $file
done

```

### 只读变量

```
echo "hello world !"
name="cc"
readonly name
echo $name

# name="chen" 这里会提示 This variable is read only.
```

### 删除变量

```
unset name
```

注意: ```unset``` 不能删除只读变量

## 简单实用

### 字符串

#### 单引号字符串的限制：

1. 单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的；
2. 单引号字串中不能出现单引号（对单引号使用转义符后也不行）。

#### 双引号

```
your_name='qinjx'
str="Hello, I know your are \"$your_name\"! \n"
```

双引号的优点：

1. 双引号里可以有变量
2. 双引号里可以出现转义字符

#### 获取字符串长度

```
string="abcd"
echo ${#string} #输出 4
```

#### 提取子字符串

从序号 1 开始, 截取 3个 

```
string="chen"
echo ${string:1:3} # output -> hen 
```

#### 执行命令

```
#!/bin/bash
str='dax asdxvs cc dsdasd'

echo `expr index "$str" cc`
```

注意: 这里的```echo```后用的是反引号 ``` ` ```

### shell 数组

示例

```
array1=(1,2,3)
echo $array1
echo $arrya1[1]
```

### 传参

#### ```$# $*  $@```

```
echo "参数个数:$#"
echo "$*"

echo "-- \$* 每个参数分别 ---"
for i in "$*"; do
    echo $i
done

echo "-- \$@ 全部参数,一次性 ---"
for i in "$@"; do
    echo $i
done
```

### 运算

#### 加减乘除

以下使用了 类似```expr 1 + 2```,```expr 2 \* 3```的命令

```
#!/bin/bash
# author:菜鸟教程
# url:www.runoob.com

a=10
b=20

val=`expr $a + $b`
echo "a + b : $val"
```

#### 关系运算符

关系运算符只支持数字，不支持字符串，除非字符串的值是数字。

```
-eq	检测两个数是否相等，相等返回 true。	
-ne	检测两个数是否相等，不相等返回 true。
-gt	检测左边的数是否大于右边的，如果是，则返回 true。
-lt	检测左边的数是否小于右边的，如果是，则返回 true。
-ge	检测左边的数是否大于等于右边的，如果是，则返回 true。
-le	检测左边的数是否小于等于右边的，如果是，则返回 true。
```

示例

```
#!/bin/bash

val=`expr $1 + $2`
echo " 前两数相加为: $val"
if [ $1 -eq $2 ]
then
    echo "$1 等于 $2"
else
    echo "$1 不等于 $2"
fi

```

#### 或 与

```
-o	或运算，有一个表达式为 true 则返回 true。	[ $a -lt 20 -o $b -gt 100 ] 返回 true。
-a	与运算，两个表达式都为 true 才返回 true。	[ $a -lt 20 -a $b -gt 100 ] 返回 false。
```


#### && ||

```
if [[ $1>10 && $2>10 ]]
then
    echo " 两个数都大于10"
fi
```

#### 字符串运算符

```
=	检测两个字符串是否相等，相等返回 true。	[ $a = $b ] 返回 false。
!=	检测两个字符串是否相等，不相等返回 true。	[ $a != $b ] 返回 true。
-z	检测字符串长度是否为0，为0返回 true。	[ -z $a ] 返回 false。
-n	检测字符串长度是否为0，不为0返回 true。	[ -n $a ] 返回 true。
str	检测字符串是否为空，不为空返回 true。	[ $a ] 返回 true。
```

#### 文件运算

```
-b file	检测文件是否是块设备文件，如果是，则返回 true。	[ -b $file ] 返回 false。
-c file	检测文件是否是字符设备文件，如果是，则返回 true。	[ -c $file ] 返回 false。
-d file	检测文件是否是目录，如果是，则返回 true。	[ -d $file ] 返回 false。
-f file	检测文件是否是普通文件（既不是目录，也不是设备文件），如果是，则返回 true。	[ -f $file ] 返回 true。
-g file	检测文件是否设置了 SGID 位，如果是，则返回 true。	[ -g $file ] 返回 false。
-k file	检测文件是否设置了粘着位(Sticky Bit)，如果是，则返回 true。	[ -k $file ] 返回 false。
-p file	检测文件是否是有名管道，如果是，则返回 true。	[ -p $file ] 返回 false。
-u file	检测文件是否设置了 SUID 位，如果是，则返回 true。	[ -u $file ] 返回 false。
-r file	检测文件是否可读，如果是，则返回 true。	[ -r $file ] 返回 true。
-w file	检测文件是否可写，如果是，则返回 true。	[ -w $file ] 返回 true。
-x file	检测文件是否可执行，如果是，则返回 true。	[ -x $file ] 返回 true。
-s file	检测文件是否为空（文件大小是否大于0），不为空返回 true。	[ -s $file ] 返回 true。
-e file	检测文件（包括目录）是否存在，如果是，则返回 true。	[ -e $file ] 返回 true。
```

### echo

1. ```-e``` 开启转义字符 --> ```\n 换行 \c 不换行```
2. ```read value_name``` 读取输入

#### 显示结果定向至文件

这会将文件重写,覆盖

```
echo "It is a test" > myfile
```


### 控制流程

#### if else

```
if condition1
then
    command1
elif condition2 
then 
    command2
else
    commandN
fi
```

示例

```
#!/bin/bash

echo $1
echo $2

if [ $1 -gt $2 ]
then
    echo "第一个数比较大"
elif [ $1 == $2 ]
then
    echo "两个数字一样大"
else
    echo "第二个数比较大"
fi
```

#### for 循环

```
#!/bin/bash

for x in 1 2 3 4 5
do
    echo $x
done

```

#### while

```
#!/bin/bash

echo '按下 <CTRL-D> 退出'
echo -n '输入你最喜欢的网站名: '
while read FILM
do
    echo "是的！$FILM 是一个好网站"
done
```

#### until 

```
until condition
do
    command
done
```

#### case

1. 使用 * 号 匹配全部
2. 需要一个esac（就是case反过来）作为结束标记

```
#!/bin/bash

echo '输入 1 到 4 之间的数字:'
echo '你输入的数字为:'
read aNum
case $aNum in
    1)  echo '你选择了 1'
    ;;
    2)  echo '你选择了 2'
    ;;
    3)  echo '你选择了 3'
    ;;
    4)  echo '你选择了 4'
    ;;
    *)  echo '你没有输入 1 到 4 之间的数字'
    ;;
esac

```


### 自定义函数

1. 函数返回值在调用该函数后通过 $? 来获得。
2. 所有函数在使用前必须定义。这意味着必须将函数放在脚本开始部分，直至shell解释器首次发现它时，才可以使用。调用函数仅使用其函数名即可。

```
#!/bin/bash

echo -n "输入你的名称:"
read name

demoFun(){
    echo "这是我的第一个 shell 函数!"
    echo "hello $1"
    return 1
}
echo "-----函数开始执行-----"
demoFun $name

echo "return $?"
echo "-----函数执行完毕-----"
```

参数处理:

```
$#	传递到脚本的参数个数
$*	以一个单字符串显示所有向脚本传递的参数
$$	脚本运行的当前进程ID号
$!	后台运行的最后一个进程的ID号
$@	与$*相同，但是使用时加引号，并在引号中返回每个参数。
$-	显示Shell使用的当前选项，与set命令功能相同。
$?	显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。
```

### 文件

```
command > file	将输出重定向到 file。
command < file	将输入重定向到 file。
command >> file	将输出以追加的方式重定向到 file。
n > file	将文件描述符为 n 的文件重定向到 file。
n >> file	将文件描述符为 n 的文件以追加的方式重定向到 file。
n >& m	将输出文件 m 和 n 合并。
n <& m	将输入文件 m 和 n 合并。
<< tag	将开始标记 tag 和结束标记 tag 之间的内容作为输入。
```

### 文件包含

Shell 也可以包含外部脚本。这样可以很方便的封装一些公用的代码作为一个独立的文件


```
. filename   
source filename
```