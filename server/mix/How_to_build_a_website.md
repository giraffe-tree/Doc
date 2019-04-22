# 如何搭建一个博客网站 -- 给你一个路线图

## 前言

很多人都想搭建一个可以自己使用的非常酷炫的博客网站, 但常常会在搭建网站的过程中碰到一些问题, 或是由于对网站/协议的不了解, 或是碰到一些自己难以解决的技术问题, 而不了了之. 

下面我根据不同情况, 给你一张搭建网站的路线图

## 路线图

![如何搭建一个博客网站](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/April/%E5%A6%82%E4%BD%95%E6%90%AD%E5%BB%BA%E4%B8%80%E4%B8%AA%E5%8D%9A%E5%AE%A2%E7%BD%91%E7%AB%99.png)

1. **静态页面**
   - **如何生成静态页面**
     - 我们不需要写 `html/css` 代码, 只需要会一点 `markdown`语法, 由模板自动生成静态页面
     - **方法1 :** 通过 [jekyll](https://github.com/jekyll/jekyll)  生成
     - **方法2:**  通过 [hugo](https://github.com/gohugoio/hugo)  生成
     - **方法3:**  使用其他生成器, 或者自己写静态页面咯
2. 部署
   1. 托管网站部署
      - 所谓的托管网站部署, 就是你只需要将静态页面上传到托管网站的服务器, 就能部署成功
      - 托管网站的特点是
        1.  你可以免费拥有一个子域名, 托管网站一般都提供了 https 安全访问
        2.  免费部署你的网站, 你不需要负担服务器的费用
        3.  由于服务器可能间隔很远, 在国内访问比较慢
      - 常见的托管网站
        - [github pages](https://pages.github.com/)  github 页面托管, 相信很多人都很熟悉, 比如我的网站 [giraffe-tree.github.io](https://giraffe-tree.github.io/)
        - [netlify](https://netlify.com/) 一个先进的托管网站, 拥有很多cdn, 虽然在国内访问不一定快, 比如 我的网站 [giraffetree.netlify.com](https://giraffetree.netlify.com/)
        - [码云 gitee pages](http://git.mydoc.io/?t=154714#text_154714) 国内的托管网站, 我测试时它们使用的是 武汉的节点, 所以在国内访问最快点, 比如我的网站: [giraffetree.gitee.io](https://giraffetree.gitee.io/)
   2. 自建网站部署
      - 2.1 域名
        - 可以备案
          - 正常备案, 通过之后, 使用 dns 解析, 国内的话推荐使用阿里云的dns解析(非广告哦)
        - 不想备案, 也不想实名认证
          - 上 [godaddy](https://godaddy.com) , 阿里万网等找你想要的域名
            - 想使用国内的 `dns` (速度快)
              - 由于 `.com/.net/.cn/.xin/.top/.xyz/.vip/.club/.shop/.wang/.ren `等域名注册成功后必须进行域名实名认证, 参考: [阿里云实名认证](https://help.aliyun.com/knowledge_detail/41880.html)
              - 可以使用 `.me` 等域名, 不需要实名
            - 可以不使用国内 `dns` (速度慢)
              - 域名随便注册
      - 2.2 服务器
        - 购买服务器
          - 正常备案的
            - 使用国内的服务器就可以了
          - 未备案的
            - 购买海外的服务器
        - 安装 `nginx`
        - `https` 或者 `http/2`
          - 免费证书申请: [阿里云 SSL 证书文档](https://help.aliyun.com/document_detail/28535.html)
      - 2.3 cdn 加快访问, 减少服务器负担
        - 已经备案
          - 直接使用国内 cdn, 比如 阿里云cdn
        - 未备案
          - 使用国外的cdn, 比如 `google cloud cdn`



## 关于我的网站

1. 使用 `jekyll` 生成
2. 网站未实名/未备案
3. 使用 阿里云 dns
4. 使用 阿里云的 SSL 证书, 实现 `http/2`
5. 使用 `google cloud` 香港的服务器/负载均衡
6. 使用 `google cdn` 

链接: [giraffetree.me](https://giraffetree.me) , 欢迎交流 ~









