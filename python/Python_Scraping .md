# Python Scraping 


## 1 






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




