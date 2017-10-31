# Numpy


## 基础

1. 创建 N-dimensional array (ndarray)

	```
	import numpy as np

	a = np.array([[1,2],
	             [3,4]])
	
	b = np.array([[0,1],
	             [2,0]])
	             
	x = np.arange(15).reshape(3, 5)
	
	# [[ 0  1  2  3  4]
	#  [ 5  6  7  8  9]
	#  [10 11 12 13 14]]
	
	```
	
2. 属性
	
	> shape 维度
	> ndim 秩
	> dtype 数组元素的类型 int64 即64位int,float64即64位 float, 均为8字节
	> itemsize 每个元素的字节大小 
	> size 元素的总个数
	
	```
	a = np.arange(15).reshape(3, 5)
	
	print(a.shape)
	print(a.ndim)
	print(a.dtype.name)
	print(a.itemsize)
	print(a.size)
	
	# (3, 5)  2  int64  8  15 
	```
	
3. zeros,ones,empty
	
	> **返回** ```ndarray```
	
	> **默认** ```dtype``` **为** ```float64```
	
	> empty_like(),ones_like(),zeros_like() 
	
	> 比如 zeros_like(a, dtype=None, order='K', subok=True)
	
	```
	# zeros(shape, dtype=float, order='C')
	# dtype 其实是 float64
	
	s = (2,2)
	np.zeros(s)
   # array([[ 0.,  0.],
   #        [ 0.,  0.]])
	```

	```
	y = np.ones([3,2],dtype=np.int64)
	
	# [[1 1]
	#  [1 1]
	#  [1 1]]
	```	
	
	```
	# np.empty()
	#  Return a new array of given shape and type, without initializing entries.
	
	z = np.empty([3,4])
	
	```


4. arange

	```
	# arange([start,] stop[, step,], dtype=None)
	# return  Array of evenly spaced values.
	
	x = np.arange(0, 150, 2,dtype=np.float64)
	
	# 禁用自动省略
	# np.set_printoptions(threshold=np.nan)
	
	```

5. dot 

	```
	b = np.array([[1,2],[2,3]])
	print(b**2)
	
	#[[1 4]
 	  [4 9]]
	```
	
	> 点积
	
	```
	a = np.array([[1,2],
             [3,4]])

	b = np.array([[0,1],
	             [2,0]])
	
	print(a*b)
	# [[0 2]
	#  [6 0]]
	
	x = np.dot(a,b)
	print(x)
	# [[4 1]
 	#  [8 3]]
	
	```

6. dtype = complex

	> 默认 complex128

	```
	c = np.array([1+1.j, 2-2.3j], [3, 4]], dtype=complex)
	print(c)
	
	# [[ 1.+1.j   2.-2.3j]
 	#  [ 3.+0.j    4.+0.j]]
	```

7. strides

	```
	a = np.array([[1, 2, 3], [4, 5, 6]], dtype=np.int64, order='c')
	print(a.strides)
	
	b = np.array([[1, 2, 3], [4, 5, 6]], dtype=np.int64, order='f')
	print(b.strides)
	
	c = np.array([[1, 2, 3,4], [4, 5, 6,7]], dtype=np.int64, 	order='f')
	print(c.strides)
	
	# (24, 8)
	# (8, 16)
	# (8, 16)
	```

8. *= +=

	```
	a = np.ones((2,3), dtype=int)
	b = np.random.random((2,3))
	
	a *=3
	#  a 变成全是3 的矩阵
	
	b +=a
	# b 的每个元素加3
	
	a+=b
	# TypeError: Cannot cast ufunc add output from dtype('float64') 
	# to dtype('int64') with casting rule 'same_kind'

	```


9. exp

	> 欧拉公式e^(ix)=cosx+isinx

	```
	a = np.ones((3,4))
	x = np.exp(a)-1
	print(x)
	# 每个元素 均为 e-1
	
	y = np.exp(a*2)
	print(y)
	# 每个元素 =  e 的(2*原始元素)次方
	
	z = np.exp(a*1j)
	# 这里要使用欧拉公式
	```

10. linspace

	> linspace(start, stop, num=50, endpoint=True, retstep=False, dtype=None)
	
	> Return evenly spaced numbers over a specified interval.

	```
	start : scalar
        The starting value of the sequence.
    stop : scalar
        The end value of the sequence, unless `endpoint` is set to False.
        In that case, the sequence consists of all but the last of ``num + 1``
        evenly spaced samples, so that `stop` is excluded.  Note that the step
        size changes when `endpoint` is False.
    num : int, optional
        Number of samples to generate. Default is 50. Must be non-negative.
    endpoint : bool, optional
        If True, `stop` is the last sample. Otherwise, it is not included.
        Default is True.
    retstep : bool, optional
        If True, return (`samples`, `step`), where `step` is the spacing
        between samples.
    dtype : dtype, optional
        The type of the output array.  If `dtype` is not given, infer the data
        type from the other input arguments.		
	```

	```
	a = np.linspace(0,np.pi,4)
	print(a)
	# [ 0.          1.04719755  2.0943951   3.14159265]

	b = np.linspace(0,np.pi,3,endpoint=False)
	print(b)
	# [ 0.          1.04719755  2.0943951 ]

	```






