# ArrayList

## 结构


## 内部持有的对象/常量

```
// 序列化id
private static final long serialVersionUID = 8683452581122892189L;
// 默认容量为10
private static final int DEFAULT_CAPACITY = 10;
// 
private static final Object[] EMPTY_ELEMENTDATA = {};

private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
// 数组最大的长度,但某些虚拟机会在数组中保留一些头信息.
// 如果尝试去分配更大的数组,可能会导致OutOfMemoryError,超出VM的数组限制
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
// 不可序列化的数据数组,
transient Object[] elementData;
// 元素个数
private int size;
// The number of times this list has been structurally modified
// list 更改结构的次数
protected transient int modCount = 0;
```









