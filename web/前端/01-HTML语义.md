# HTML 语义

## 概述

## 语义类标签的作用

1. 用在自然语言表达时的补充, 比如加强语气(`<em>` 加重语气), 消除歧义
2. 作为标题摘要 `h1`, `section`
3. 作为整体结构的语义类标签, 适合机器阅读的整体结构



## 示例

### aside

aside元素代表跟文档的主内容区相关，但它又独立于主内容区，并且可以被单独拆分出来，而不会对整体内容产生影响。

aside通常表现为侧边栏、说明、提示、引用、附加注释、广告等。如，在经典的页面布局中，页面被分为 header、main、aside、footer 四个部分：

```
<body>
    <header>
        <nav>
            ……
        </nav>
    </header>
    <aside>
        <nav>
            ……
        </nav>
    </aside>
    <section>……</section>
    <section>……</section>
    <section>……</section>
    <footer>
        <address>……</address>
    </footer>
</body>
```

### blockquote, q, cite

1. `blockquote`
   - 表示段落级引述内容
2. `q`
   - 行内的引述内容
3. `cite`
   - 引述的作品名

### figure, figcaption

图片和文字结合

```html
<figure>
 <img src="https://.....440px-NeXTcube_first_webserver.JPG"/>
 <figcaption>The NeXT Computer used by Tim Berners-Lee at CERN.</figcaption>
</figure>
```

### dfn

定义

```
The terms Internet and World Wide Web are often used without much distinction. However, the two are not the same. 
The <dfn>Internet</dfn> is a global system of interconnected computer networks.
In contrast, the <dfn>World Wide Web</dfn> is a global collection of documents and other resources, linked by hyperlinks and URIs. 
```

### nav, ol, ul

导航栏, 有序列表, 无序列表

```
<nav>
  <h2>Contents</h2>
  <ol>
    <li><a href="...">History</a></li>
    <li><a href="...">Function</a>
      <ol>
        <li><a href="...">Linking</a></li>
        <li><a href="...">Dynamic updates of web pages</a></li>
        ...
      </ol>
    </li>
    ...
  </ol>
</nav>
```

### pre, samp,code

```
<pre><code>
&lt;html&gt;
  &lt;head&gt;
    &lt;title&gt;Example.org – The World Wide Web&lt;/title&gt;
  &lt;/head&gt;
  &lt;body&gt;
    &lt;p&gt;The World Wide Web, abbreviated as WWW and commonly known ...&lt;/p&gt;
  &lt;/body&gt;
&lt;/html&gt;
</code></pre>
```





