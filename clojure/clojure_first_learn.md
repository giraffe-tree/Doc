# clojure learn

## 参考

https://www.clojure.org/guides/learn/syntax

## vector & list

[clojure vector & list diff](https://stackoverflow.com/questions/11504236/as-a-data-container-what-are-the-main-differences-between-vector-and-list)

vector 可以近似理解为 ArrayList, 随机访问 O(log32)N 的复杂度, 在 java 的 int 范围内近似为 O(1)

list 可以近似理解为 LinkedList

[vector /  list分别在什么情况下使用](https://stackoverflow.com/questions/1147975/in-clojure-when-should-i-use-a-vector-over-a-list-and-the-other-way-around)

## clojure 的集合

```clojure
'(1 2 3)     ; list
[1 2 3]      ; vector
#{1 2 3}     ; set
{:a 1, :b 2} ; map
```

## clojure cheatsheet

https://clojure.org/api/cheatsheet

## pst

打印 `exception` 的 `stack trace`






