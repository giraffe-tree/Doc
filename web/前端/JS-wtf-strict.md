# JS use strict

## 概述

## use strict

```
"use strict";
function f(){
    console.log(this);
};
f.call(null);
// out: null
```

`"use strict"`是 JavaScript 标准中规定的唯一一种指令序言，但是设计指令序言的目的是，留给 JS 的引擎和实现者一些统一的表达方式，在静态扫描时指定 JS 代码的一些特性。



