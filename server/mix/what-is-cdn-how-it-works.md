# What is cdn? How it works

## CDN

cdn 即 Content delivery networks. 

## 步骤

在实际使用cdn服务时, 一般来讲需要和 dns解析 共同使用

将需要进行 cdn 加速的网站, 通过 dns 解析指向对应 cdn 的域名 

## 流程

原始域名 A1  
cdn 权威dns服务器 B1 
cdn 全局负载均衡器 B2

一般来讲它们是这样的关系: `A1 -> B1 -> B2`, 里面箭头的意思就是 A1 有一条 `cname` 记录指向 B1 , 简单理解就是 A1 这个域名指向了 B1 这个域名






