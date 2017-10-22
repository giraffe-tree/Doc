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

- 列表生成式  ```[x for x in range(100)]```


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

1 .  
```
ages = {'cc': 123, 'dd': 12, 'ee': 14}
```

2 . 
```
items = [('cc', 12), ('dd', 15)]    
dict(items)
```

3 .
```
dict(name='cc', age=14)
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

### 创建函数

- def
- 文档化函数,在函数的第一行写字符串, func.__doc__


### 值传递

### 关键字参数

- 清晰
- 可以提供函数默认值
- 位置参数,关键字参数

### 全局变量和局部变量

- locals
- globals
- vars
- 函数内函数
- 闭包


### 其他

- 递归
- 二分查找((bisect)
- filter
- map
- functools.reduce
- 函数式编程


## 第七章 更加抽象


### 多态

让用户在不知道是什么对象类型的对象进行方法调用


### 封装


#### 特性(attribute)

特性作为变量构成对象的一部分

#### 继承


### 类

- 超类/子类
- 重写(override)
- 方法 : 必须要有 self 参数
- 类:命名空间 class namespace
- 私有 :使用__,但实际上只是改变了名字
- issubclass(子类,父类)	返回 True
- isinstance(实例,类名)	返回 True 
	- ```isinstance('s',str) ```
	- ```'s'.__class__```
	- ```type('s')```
- 多重继承	
	- 有两种情况:1.父类中有相同名字的方法  2. 继承的多个父类继承了同一个超类,且重写了相同的方法  这两种情况都会造成调用顺序可能出错
	- 多个父类中相同名称的方法,先继承的覆盖后面所有的,所以一定要注意顺序
	- 这里会出现一个问题,当继承的父类1,2,有共同的父类0,当父类1,2都重写了父类0中的方法时,子类中调用的方法一定是顺序前面的那个
- __dict__: 查看对象中所有存储的值
- 接口: 未定义完全的类


## 第八章 异常

- traceback
- raise
- 自定义异常
- try  except  else  finally
- 多使用 try except ,可以略微提升性能


-------
-------

# 以下为 python编程:从入门到实践 的内容

-------
-------

## 第九章 类


- super().__init_(...)
- from ...  import  ...	
	- 需要从一个模块中导入很多类时，最好导入整个模块，并使用 module_name.class_name 语法来访问类
	- from module_name import *


## 第十章 文件与异常


### 文件

- with 关键字,会在不再需要访问文件后将文件关闭
- rstrip()  删除(剥除)字符串末尾的空白  lstrip() / strip()
- int() / float() 将字符串转换为整形/浮点型

#### 读取文件

```
with open(path) as file:
	contents = file.read()
	lines = file.readlines()
```

#### 写入文件

```open()```

- 省略实参,则默认以只读模式打开
- 'r'	读取模式
- 'w'	写入模式,如果写入文件不存在,则自动创建,若已经存在,则会清空该文件
- 'a'	附加模式,在文件后面添加内容
- 'r+'	读写模式

### 异常


### Json

- json.dump(data,file) 向文件放入数据
- json.load(file) 从文件读取数据


## 函数式编程

函数式编程的一个特点就是，允许把函数本身作为参数传入另一个函数，还允许返回一个函数！

把函数作为参数传入，这样的函数称为高阶函数，函数式编程就是指这种高度抽象的编程范式。

### higher-order function

即在函数中使用函数作为参数,都属于高阶函数
如: map/reduce,filter,sorted


### lambda

例一:

```
func1 = lambda: 123
func1()
# return 123

func2 = lambda x: x + 1
func2(100) 
# return 101

```

### map

在 bulitins.py 中


### reduce

```
from functools import reduce
result3 = reduce(lambda x,y:x+y,[1,2,3,4])

```

### filter

```
x = filter(lambda x:x%2==0, [1, 2, 3, 4, 5, 6, 7])
```

### sorted

经过 sorted 排序的原序列不变,且返回的是一个新的列表

```
s1 = sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower, reverse=True)

s2 = sorted([36, 5, -12, 9, -21], key=abs)

s3 = sorted([36, 5, -12, 9, -21], key=lambda x:x**2+20*x)

```

### 返回函数

```
def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum

x =lazy_sum(1,2,3,4,5,5)
print(x())

```


## 第 15 章 生成数据

### matplotlib

使用的是两个列表,组成点的集合

- plot 绘制线条
- scatter 绘制点
- c ,cmap 绘制颜色不同的点

```
import matplotlib.pyplot as plt

values= [0,1,2,3,4,5]
squares = [0,1,4,9,16,25]

plt.plot(values,squares,linewidth = 5)
plt.title("Square Numbers",fontsize = 24)
plt.xlabel("value",fontsize = 14)
plt.ylabel("Square of value",fontsize = 14)

plt.tick_params(axis='both',which = 'major',labelsize = 14)

plt.scatter(values,squares,s=150)


plt.show()

```

### pygal

使用一个列表

- pygal.Bar() 柱状图
- hist.render_to_file('die_visual2.svg') 保存 svg 图片,使用浏览器打开


```
frequencies = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
hist = pygal.Bar()

hist.title = 'Results of rolling D6 and D10 50000 times'
hist.x_labels = ['2', '3', '4', '5', '6','7', '8', '9', '10', '11', '12','13','14','15','16']
hist.x_title = 'result'.title()
hist.y_title = 'frequency of result'.title()

hist.add('D6+D10', frequencies)
hist.render_to_file('die_visual2.svg')

```

## 第16章 下载数据


### csv

### json











	












