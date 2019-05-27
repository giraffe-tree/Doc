# Red black tree

## 参考

1. **Algorithms fourth edition** **3.3.2节 红黑二叉查找树**
2. [教你透彻了解红黑树](https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.01.md) 一般思路, 可以参考, 但图有点错误, 没有讲清来龙去脉

## 红黑树

红黑二叉查找树的基本思想是用 **标准的二叉查找树** 和**一些额外信息(代替 3 -节点) **来表示 **2-3 树**

所以要看红黑树, 请 **先掌握 2-3 树**, 否则下面的就不要看啦 =.=

### 本节看完需要掌握以下的知识点

1. 旋转(左旋和右旋)
2. 

### 红黑树如何转为2-3树

将一颗红黑树中的红链接画平

![画图不易请注明出处 giraffetree.me](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/May/redblacktreeTo23tree.png?x-oss-process=style/default)

### 表面上的性质

感觉这个理解了也没啥用..

1. 每个结点要么是红的，要么是黑的。  
2. 根结点是黑的。  
3. 每个叶结点（叶结点即指树尾端NIL指针或NULL结点）是黑的。  
4. 如果一个结点是红的，那么它的俩个儿子都是黑的。  
5. 对于任一结点而言，其到叶结点树尾端NIL指针的每一条路径都包含相同数目的黑结点。  



