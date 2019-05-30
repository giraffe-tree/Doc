# 自平衡树历史小结

## 概述



## 历史

### 1962 AVL 树

AVL 树得名于它的发明者[G. M. Adelson-Velsky](https://zh.wikipedia.org/wiki/格奥尔吉·阿杰尔松-韦利斯基) 和 [Evgenii Landis](https://zh.wikipedia.org/w/index.php?title=Evgenii_Landis&action=edit&redlink=1)，他们在1962年的论文《An algorithm for the organization of information》. 没错, 论文使用 俄语写的, 一点都看不懂....

### 1970 2-3树

2–3树由[约翰·霍普克洛夫](https://zh.wikipedia.org/wiki/約翰·霍普克洛夫特)特于1970年发明

### 1972 B 树

发明者:  [Rudolf Bayer](https://zh.wikipedia.org/wiki/Rudolf_Bayer), [Edward M. McCreight](https://zh.wikipedia.org/w/index.php?title=Edward_M._McCreight&action=edit&redlink=1)  出自论文[organization and maintenance of large ordered indices](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/pdf/datastructure/organization%20and%20maintenance%20of%20large%20ordered%20indices.pdf)

我找到的论文是 1970 年的, 但是很多书上写的是 1972 年

### 1972 红黑树

它在1972年由 [鲁道夫·贝尔 Rudolf Bayer](https://zh.wikipedia.org/wiki/鲁道夫·贝尔) 发明，被称为"对称二叉B树" 出自论文 [symmetric binary b-trees data structure and maintenance algorithms](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/pdf/datastructure/Symmetric%20Binary%20B-Trees_%20Data%20Structure%20and%20Algorithms%20for%20Rando.pdf)

它现代的名字源于Leo J. Guibas 和[Robert Sedgewick](https://zh.wikipedia.org/wiki/Robert_Sedgewick)于[1978年](https://zh.wikipedia.org/wiki/1978年)写的一篇论文 - `A dichromatic framework for balanced trees` 

### 2-3-4 tree

https://en.wikipedia.org/wiki/2%E2%80%933%E2%80%934_tree

### 1993 AA树

AA树是红黑树的变体，是一种二元搜索树形式，支持有效添加和删除条目。与红黑树不同，AA树上的红色节点只能作为右子项添加。换句话说，没有红色节点可以是左子子节点。

它模拟了 2-3树而不是2-3-4树，这极大地简化了维护操作。红黑树的维护算法需要考虑七种不同的形状, AA树只需要考虑两种形状，因为严格要求只有正确的链接可以是红色的

以它的发明者[Arne Andersson](https://en.wikipedia.org/w/index.php?title=Arne_Andersson_(computer_science)&action=edit&redlink=1)命名。出自论文 [balanced search trees made simple](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/pdf/datastructure/balanced%20search%20trees%20made%20simple.pdf)


### 1996 Treap

https://en.wikipedia.org/wiki/Treap

作者 Seidel 和 Aragon 出自论文 [randomized search trees](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/pdf/datastructure/randomized%20search%20trees.pdf)

### 2008 LLRB

在 algorithms 第四版中, 红黑树的实现来自于 Robert Sedgewick 在 2008 年的论文 [Left-leaning Red-Black Trees](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/pdf/datastructure/LLRB.pdf)

看到 Robert Sedgewick 的名字有没有感觉很熟悉呢 =.= 没错, 他就是 Algorithms 的作者, 也是红黑树的命名者 =.=

## 其他变种

### 加权平衡树 weight-balanced tree

https://en.wikipedia.org/wiki/Weight-balanced_tree

### K 近邻树  K-d tree

https://en.wikipedia.org/wiki/K-d_tree

### 替罪羊树

这么好玩的名字, 没有兴趣学一下么 =.=

https://zhuanlan.zhihu.com/p/21263304

https://en.wikipedia.org/wiki/Scapegoat_tree

### 伸展树 Splay tree

https://en.wikipedia.org/wiki/Splay_tree

### 跳表 skip list

这货也算树么 =.=

https://en.wikipedia.org/wiki/Skip_list
