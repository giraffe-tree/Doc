# Python

## 第一章 基础知识

导入模块

> import math

字符串

> str  repr

数字

> - floor
- ceil
- round


## 第二章 列表和元组

在idle中结束代码，执行，点两下enter

查找内建函数BIF
> dir(\_\_builtins\_\_)

帮助
> help(input)

### 2.2 序列的基本操作

- 索引 
	> 使用索引进行查找 
	
- 分片
	> 提取序列,可以使用步长,默认为1
	
- 加
- 乘
- 判断是否属于序列的成员
	> 使用 in 判断是否属于序列成员

- 计算序列长度
	> len()

- 找出最大/最小的元素
	> max,min 函数
	
- 迭代  TODO:
	

### 2.3 列表

- list 转换为 list
- del 
- 分片赋值

- 列表方法
	- append
	- count
	- extend
	- index
	- insert
	- pop
	- remove
	- reverse/reversed
	- sort/sorted

### 2.4 元组

- tuple 将序列转换为元组

- 分片
- max/min
- in
- len
- 乘法

#### 为什么元组不可替代/元组和列表的区别

[Python 列表和元组的区别是什么？](http://python.jobbole.com/86661/)


1. tuple 不可变, list 可变
2. tuple 通常由不同的数据，而 list 是相同类型的数据队列。
3. tuple 可以在映射中当做键使用, 而 list 是 unhashable type
4. tuple 比 list 快上那么一丢丢..

## 第三章 使用字符串


字符串不可变

> ```help(print)```

```
print(...)
    print(value, ..., sep=' ', end='\n', file=sys.stdout, flush=False)
    
    Prints the values to a stream, or to sys.stdout by default.
    
    Optional keyword arguments:
    file:  a file-like object (stream); defaults to the current sys.stdout.
    sep:   string inserted between values, default a space.
    end:   string appended after the last value, default a newline.
    flush: whether to forcibly flush the stream.
    
```



### 字符串格式化




### 字符串方法


- find
- join/spilt
- lower/title/string.capwords
- replace
- spilt
- strip/lstrip/rstrip
- translate/str.maketrans(from,to)



## 第四章 字典

### 创建字典

1 .  ```
ages = {'cc': 123, 'dd': 12, 'ee': 14}
```

2 . ```
items = [('cc', 12), ('dd', 15)]    
dict(items)
```

3 . ```dict(name='cc', age=14)
```

### 字典方法

- dict
- 字典的格式化字符串 :```print("%(Alice)s"%people)```
- del d[k]
- clear
- copy/deepcopy
- fromkeys
- get
- in
- items
- keys
- pop
- popitems
- setdefault
- update
- values

## 第五章 条件,循环和其他语句

### import

1. ```import math as ma```
2. ```from math import sqrt as sq```

### sequence unpacking

1. ```key,value =dict1.popitem()```
2. ```x,y,z = z,x,y```
3. ```*a, b, c = 1, 2, 3, 4, 5```

### chained assignment

```x = y = 3```

###  IF 语句

- else 
- elif
- a if b else c
- if not .. and .. or ..
- assert 

### 循环语句

 - while 
 - for 
 - range(10,0,-1)
 - break 
 - continue
 - while True/break
 - else
 - 列表推导式```z = [(x, y) for x in range(3) for y in range(8, 11)]```
 - pass
 - del 
 - exec
 - eval
	```
	eval(input('expression:'))
	expression:2+3
	5	
	```

### 其他函数

- enumerate(seq)
- zip(seq...)
- chr(数字)/ord(字符)
- reversed(seq)  返回迭代对象


## 第六章 抽象

























	
	












