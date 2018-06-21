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


