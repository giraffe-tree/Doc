# Node.js

## HelloWorld

新建一个文件 ```server.js```,写入以下内容

```js
// create by Giraffe Tree
var http = require('http');

http.createServer(function (request, response) {
    response.writeHead(200, {'Content-type': 'text/plain'});
    response.end('Hello world');
}).listen(8000);

console.log("server running at http://localhost:8000");
```

启动

```
node server.js
```

访问 ```http://localhost:8000``` 即可看到 ```Hello world```

## 文件结构

### 结构

https://blog.csdn.net/lu1024188315/article/details/51986224

1. node_modules文件夹
    
    - 这文件夹就是在创建完项目后，cd到项目目录执行npm install后生成的文件夹，下载了项目需要的依赖项。
    
2. package.json文件
     
     - 此文件是项目的配置文件（可定义应用程序名，版本，依赖项等等）。node_modules文件夹下的依赖项是从哪里知道的呢？原因就是项目根目录下的这个package.json文件，执行npm install时会去找此文件中的dependencies，并安装指定的依赖项。
     
3. public文件夹(包含images、javascripts、stylesheets)
     
     -  这个文件夹做过Web开发的应该一看就知道，为了存放图片、脚本、样式等文件的。
      
4. routes文件夹
    
     -  用于存放路由文件。

5. views文件夹
    
    -   存放视图。

## 基础

### 为什么要用模块

1. 为了命名空间不冲突 exports

2. 重用

### 事件发射器

### content-length

使用```content-length```会禁用 Node 的块编码,因为要传输的数据更少,所以提升性能.









