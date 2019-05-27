# 2-3 Tree

## 参考

1. [wiki: 2–3_tree](https://en.wikipedia.org/wiki/2%E2%80%933_tree)
2. **Algorithms fourth edition** **3.3.1节 2-3查找树**

## 2-3树

### 需要掌握的

1. 向一个2-节点插入新key
2. 向一个 3- 节点插入新key
3. 向一个父节点为 2-节点的3-节点插入新 key (**2-3树动态变化的核心**)
   - 使用中键插入父节点
4. 向一个父节点为 3-节点的3-节点插入新key
5. 分解根节点

### 结论

1. 2-3 树插入算法的根本在于这些变化都是局部的
   - 所谓的局部变化不会影响树的全局有序性和平衡性
2. 只有根节点分解时, 所有空链接到根节点的路径才会加 1
3. 2-3树的生长是由下向上的

### 插入图示

图片来自于 [2–3_tree wiki](https://en.wikipedia.org/wiki/2%E2%80%933_tree)



![https://upload.wikimedia.org/wikipedia/commons/4/44/2-3_insertion.svg](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/img/2019/May/2-3_insertion.svg)

