
# yaml

[yaml教程](http://www.ruanyifeng.com/blog/2016/07/yaml.html?f=tt)

[yaml官方文档](https://bitbucket.org/asomov/snakeyaml/wiki/Documentation)

## 规则

### 规则一：缩进

- yaml使用一个固定的缩进风格表示数据层结构关系，
- 大小写敏感
- 使用缩进表示层级关系
- 缩进时不允许使用Tab键，只允许使用空格。
- 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可

### 规则二：冒号

```
  yaml:
  mykey: my_value
```
  每个冒号后面一定要有一个空格（以冒号结尾不需要空格，表示文件路径的模版可以不需要空格）

### 规则三：短横线

 想要表示列表项，使用一个短横杠加一个空格。多个项使用同样的缩进级别作为同一个列表的一部分

### 注释

```#
```
表示注释，从这个字符一直到行尾，都会被解析器忽略。


## YAML 支持的数据结构有三种

- 对象：键值对的集合
- 数组：一组按次序排列的值，又称为序列（sequence） / 列表（list）
- 纯量（scalars）：单个的、不可再分的值


YAML 允许使用两个感叹号，强制转换数据类型。

```
e: !!str 123
f: !!str true
```

多行字符串可以使用|保留换行符，也可以使用>折叠换行。

```
this: |
  Foo
  Bar
that: >
  Foo
  Bar
```

即

```
{ this: 'Foo\nBar\n', that: 'Foo Bar\n' }
```


## 引用











