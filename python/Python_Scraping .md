# Python Scraping 

**主要内容来自图灵出版的 "python 网络数据采集"**

**该书的源码github网址:** [REMitchell/python-scraping](https://github.com/REMitchell/python-scraping)

**以下是我的个人总结:**


## 第一章 初见网络爬虫

### 获取 html 标签内容

```
from urllib.request import urlopen
from bs4 import BeautifulSoup

html = urlopen("http://pythonscraping.com/pages/page1.html")
bsObj = BeautifulSoup(html.read())

print(bsObj.h1)

print(bsObj.html.body.h1)
```

### 你可能会遇到的问题

Q1. 

```
No parser was explicitly specified, so I'm using the best
available HTML parser for this system ("html.parser"). This usually isn't a
problem, but if you run this code on another system, or in a different
virtual environment, it may use a different parser and behave differently.

To get rid of this warning, change this:

 BeautifulSoup([your markup])
```

> **使用**: ```bsObj = BeautifulSoup(html.read(),"html.parser")```
> 
> **参考**: [How to get rid of BeautifulSoup user warning?](https://stackoverflow.com/questions/33511544/how-to-get-rid-of-beautifulsoup-user-warning)


Q2.

你可能会发现,使用形如```bsObj.h1```这类的操作,仅仅会找到页面中的第一个标签,而其他标签都被遗漏了.那么,如何找到所有的标签信息呢?

我们可以使用```findAll(...)```,不过具体的使用我们之后再讲


### 处理常见的异常

我们会遇到的异常:

1. 当我们访问网站失败时的异常会出现```HTTPError/URLError```

	- ```HTTPError```是```URLError```的子类，它抛出的异常是更为具体地指向HTTP URLs,可以通过```e.code```获取状态码
	- 参考:[关于URLError和HTTPError](http://blog.csdn.net/whd526/article/details/52279103)

2. 当获取节点失败时,会有```AttributeError```

下面是案例:

```
from urllib.request import urlopen
from bs4 import BeautifulSoup
from urllib.error import HTTPError, URLError


def getTitle(url):
    try:
        html = urlopen(url)
    except (HTTPError, URLError) as e:
        # print(e.code)
        return None
    try:
        bsObj = BeautifulSoup(html.read(), "html.parser")
        title = bsObj.body.h1
    except AttributeError as e:
        return None
    return title


title = getTitle("http://pythonscraping.com/pages/page1.html")

if title == None:
    print("title could not be found")
else:
    print(title)

```


## 第二章 复杂 HTML 解析

### 如何处理复杂的网页

当我们遇到一些复杂网页时,往往会产生一长串的获取节点的代码, 而且当网站修改节点时,我们的爬取程序也要重新写过.那我们应该怎么做呢?


#### 去除标签信息

当我们获取上面示例程序的 title ,会有一个烦人的点,就是标签中的```<h1></h1>```始终保留,那么怎么去除它们呢? 

很简单,使用``` get_text()```方法

如```title.get_text()```

但是需要注意的是,当我们处理数据的时候,应当尽量保留数据中的节点信息,以备之后使用,仅当你需要打印/存储/操作数据时,再去除标签信息

#### 使用 find/findAll


```
def find(self, name=None, attrs={}, recursive=True, text=None,
             **kwargs)
```


```
def find_all(self, name=None, attrs={}, recursive=True, text=None,
                 limit=None, **kwargs)
```















