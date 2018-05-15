# Erlang

## 参考

https://www.w3cschool.cn/erlang/tohb1p5z.html

http://erlang.org/doc/reference_manual/data_types.html

## 入门

### 基础

#### 常识

- 结束符号 .
- 文件名 ```.erl```
- 定义模块名 ```-module(tut).```
- 输出可被外部调用的函数 ```-export([double/1]).```
- 列表 ```[E1, E2 | R] = [1,2,3,4,5,6,7].```

#### List

List还支持查询式

NewList = [Expression || GeneratorExp1, GeneratorExp2, ..., GeneratorExpN, Condition1, Condition2, ... ConditionM]

```
[{X,Y}||X<-[1,5],Y<-[6,7],(X+Y) rem 3 =:=0].
```




