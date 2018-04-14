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







