## 6.1. Permissions 权限


## Wildcard Permissions


在这个例子中的冒号是一个特殊字符，它用来分隔权限字符串的下一部件。

```
printer:print
printer:manage
printer:print,query

printer:*

*:view
```

#### 另一种常见的通配符权限用法是塑造实例级的访问控制列表。

第一个是域，第二个是操作，第三个是被付诸实施的实例。


```
printer:query:lp7200
printer:print:epsoncolor
```

同

```
if ( SecurityUtils.getSubject().isPermitted("printer:query:lp7200") {
    // 返回ID lp7200 的打印机的当前任务
}
```

这是体现权限的一个极为有效的方法。但同样，为所有的打印机定义多个实例ID 能很好的扩展，尤其是当新的打印机添加到系统的时候。你可以使用通配符来代替：

```
printer:print:*

printer:*:*

printer:query, print:lp7200

```


```printer:print```等价于```printer:print:*```

```printer```等价于```printer:*:*```



## 7. Realms

Realm 是可以访问程序特定的安全数据如用户、角色、权限等的一个组件。Realm 会将这些程序特定的安全数据转换成一种 Shiro 可以理解的形式，Shiro 就可以依次提供容易理解的 Subject 程序API而不管有多少数据源或者程序中你的数据如何组织。

Realm 实质上就是一个特定安全的 DAO
















