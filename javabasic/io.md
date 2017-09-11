# JAVA 的 IO 系统

参见：《java编程思想》第18章

[java中的IO整理](http://www.cnblogs.com/rollenholt/archive/2011/09/11/2173787.html)



## IO 中的路径

表示当前项目路径，属于相对路径
```
File file = new File(".");
```

表示当前项目的上一层，属于相对路径
```
File file = new File(".");
```

还可以这样用
```
File file = new File(".\\src\\main\\java");
```













