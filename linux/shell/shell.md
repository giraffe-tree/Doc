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



