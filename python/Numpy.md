# Numpy

参考:

> [https://docs.scipy.org/doc/numpy-1.13.0/user/quickstart.html](https://docs.scipy.org/doc/numpy-1.13.0/user/quickstart.html)

## 基础和通用函数

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

11. ndarray: sum,max,min,cumsum

	> cumsum: cumulative sum along each row 沿行累计和
	
	> axis=0 一列一列算 axis=1 一行一行算
	
	```
	a = np.arange(0, 15).reshape((3, 5))
	print(a)
	# [[ 0  1  2  3  4]
 	#  [ 5  6  7  8  9]
  	#  [10 11 12 13 14]]
	
	print(a.max(axis=1))
	# [ 4  9 14]
	
	print(a.min(axis=0))
	# [0 1 2 3 4] 
	
	print(a.sum(axis=0))
	# [15 18 21 24 27]
	
	print(a.sum(axis=1))
	# [10 35 60]
	
	print(a.cumsum(axis=1))
	# [10 21 33 46 60]]
	
	```

12. Universal Functions (ufunc)

	> sin cos exp sqrt add dot
	


	
##  Indexing, Slicing and Iterating 索引切片和迭代

1. 一维 索引/分片/迭代

	> One-dimensional arrays can be indexed, sliced and iterated over, much like lists and other Python sequences.
	
	
	```
	# 索引
	print(a[8])
	# 8
	
	# 分片
	a = np.arange(10)
	# [0 1 2 3 4 5 6 7 8 9]
	
	print(a[1:7:2])
	# [1 3 5]
	
	print(a[::-2])
	# [9 7 5 3 1]
	```


	```
	<!--迭代-->
	for i in a:
   		print(i**2,end=" ")	
   	
   	# 0 1 4 9 16 25 36 49 64 81
	```

	```
	# 赋值
	a[:6:2] = -10
	# [-10   1 -10   3 -10   5   6   7   8   9]
	
	```


2. 多维数组

	> Multidimensional arrays can have one index per axis. These indices are given in a tuple separated by commas:


	```
	
	def lin(x, y):
    	return 10 * x + y
	b = np.fromfunction(lin,(5,4),dtype=int)
	
	#  [[ 0  1  2  3]
	#   [10 11 12 13]
	#   [20 21 22 23]
	#   [30 31 32 33]
	#   [40 41 42 43]]
	
	```

	```
	print(b[2,3])
	# 23
	
	print(b[0:3,2])
	# [2 12 22]
	
	print(b[:,1])
	# [ 1 11 21 31 41]
		
	print(b[1:3,1:3])
	#[[11 12]
 	# [21 22]]
	```
	
	> 当使用 b[i]时会被当做 b[i,:]
	
	> 当使用 ```...``` 时会代表许多行
	
	> The dots (...) represent as many colons as needed to produce a complete indexing tuple. 
	
	```
	print(b[-1])
	# [40 41 42 43]
		
	print(b[-2,...])
	# [30 31 32 33]
	
	```
	
	```
	x[1,2,...] is equivalent to x[1,2,:,:,:],
	x[...,3] to x[:,:,:,:,3] and
	x[4,...,5,:] to x[4,:,:,5,:].

	```

3.  三维数组

	```
	c = np.array([[[0,1,2],[10,12,13]],
               [[100,101,102],[110,112,113]]])
	c.shape
	# (2,2,3)
	
	```
	
	```
	# c
	[[[  0   1   2]
	  [ 10  12  13]]
	
	 [[100 101 102]
	  [110 112 113]]]
	
	```
	
	
	```
	# 分片
	print(c[0,...])
	print(" - - - - - - - - ")
	print(c[:,0,:])
	print(" - -- -- - -- --  ")
	print(c[:,:,0])
	
	print(' -- - - - --  --  ')
	print(c[...,2])
	
	```
	
	```
	# 结果
	[ 0  1  2]
	 [10 12 13]]
	 - - - - - - - - 
	[[  0   1   2]
	 [100 101 102]]
	 - -- -- - -- --  
	[[  0  10]
	 [100 110]]
	 -- - - - --  --  
	[[  2  13]
	 [102 113]]
	```

	```
	# 遍历,迭代
	for element in c.flat:
    	print(element,end=" ")
	
	# 0 1 2 10 12 13 100 101 102 110 112 113 
	```
	
## Shape Manipulation 操作形状


1. 创建随机数组

	```
	# 注意这里 3,4 外的括号要加上
	a = np.floor(10*np.random.random((3,4)))

	```

	```
	# such as 由于是随机数组每次生成的数组都不一样
	[[ 6.  4.  9.  0.]
 	[ 1.  2.  7.  0.]
 	[ 9.  9.  1.  8.]]
	
	```


2. 返回改变的数组,不改变原数组

	> The shape of an array can be changed with various commands. Note that the following three commands all return a modified array, but do not change the original array:
	
	1. ravel

		>  returns the array, flattened

		```
		print(a.ravel())
		# such as ... 
		#  [ 3.  6.  1.  3.  2.  0.  2.  8.  2.  1.  9.  3.]
		```
		
		> The order of the elements in the array resulting from ravel() 		is normally “C-style”, that is, the rightmost index “changes 		the fastest”, so the element after a[0,0] is a[0,1]. If the 		array is reshaped to some other shape, again the array is 		treated as “C-style”. NumPy normally creates arrays stored in 		this order, so ravel() will usually not need to copy its 		argument, but if the array was made by taking slices of another 		array or created with unusual options, it may need to be 		copied. The functions ravel() and reshape() can also be 		instructed, using an optional argument, to use FORTRAN-style 		arrays, in which the leftmost index changes the fastest.



	2.  reshape
		
		> returns the array with a modified shape
		
		```
		x = a.reshape(6,2)
		print(x)
		
		# such as ...
		# [[ 8.  2.  0.  2.  8.  2.]
		#	[ 4.  4.  8.  0.  0.  0.]]
		
		```
	
	3. T 转置矩阵

		> returns the array, transposed
		
		```
		print(a.T)
		# [[ 2.  4.  5.]
			[ 6.  5.  8.]
			[ 8.  3.  9.]
			[ 0.  1.  1.]]
		
		```

3. 改变原数组

	1. resize 

		> the ndarray.resize method modifies the array itself:
		
		> 如果给定的形状过大,会用0填充,过小,则舍去剩余元素 
		
		```
		a = np.floor(10*np.random.random((3,4)))
		x = a.resize((6,2))

		print("\n - -- - -- - - \n")
		print(x)
		print(a)
		
		```

		```
		# 输出:
		None
		[[ 4.  2.]
		 [ 2.  3.]
		 [ 3.  8.]
		 [ 4.  8.]
		 [ 1.  6.]
		 [ 4.  3.]]
		
		```

4. 堆叠矩阵  Stacking together different arrays

	1. vstack,hstack 

		> 不改变原来的 array

		```
		a = np.floor(10 * np.random.random((2, 2)))
		b = np.floor(10 * np.random.random((2, 2)))
		
		x = np.vstack((a,b))
		print(x.shape)
		print(x)
				
		y = np.hstack((a,b))
		print(y.shape)
		print(y)
		```
		
		```
		# output:
		(4, 2)
		[[ 2.  5.]
		 [ 8.  7.]
		 [ 1.  0.]
		 [ 5.  5.]]
		(2, 4)
		[[ 2.  5.  1.  0.]
		 [ 8.  7.  5.  5.]]
		
		```
		
		```
    	vstack: Stack arrays in sequence vertically (row wise) 
		vstack(tup)
			tup : sequence of ndarrays
		
		hstack: Stack arrays in sequence horizontally (column wise).
		hstack(tup)
			tup : sequence of ndarrays
		```

	2. column_stack

		> The function column_stack stacks 1D arrays as columns into a 			2D array. It is equivalent to hstack only for 2D arrays:
		
		```
		q = np.array([1,2])
		p = np.array([3,4])
		
		qp = np.column_stack((q,p))
		print(qp)
		
		```
		
		```
		output:
		[[1 3]
		 [2 4]]
		```
		
		but use hstack()
		
		```
		print(np.hstack((q,p)))
		```
		
		```
		output:
		[1 2 3 4]
		```
		
		other 第二种和第三种一样
		
		```
		print(q[:,np.newaxis])
		
		test = np.column_stack((q[:,np.newaxis],p[:,np.newaxis]))
		print(test)
		
		print(np.hstack((a[:,newaxis],b[:,newaxis])))
		```
		
		```
		# output:
		
		[[1]
 		 [2]]
 		# 分割线...... 
 		[[1 3]
 		 [2 4]]
		# 分割线......
 		[[1 3]
		 [2 4]]
		```
		
	3. row_stack

		> On the other hand, the function **row_stack** is equivalent 		to **vstack** for any input arrays. In general, for arrays of 		with more than two dimensions, hstack stacks along their second 		axes, vstack stacks along their first axes, and concatenate 		allows for an optional arguments giving the number of the axis 		along which the concatenation should happen.
		
		
	4.  concatenate

		```
		a = np.array([[1, 2], [3, 4]])
		b = np.array([[5, 6]])
		
		x = np.concatenate((a, b), axis=0)
		print(x)
		
		y  = np.concatenate((a, b.T), axis=1)
		print(y)
		```
		
		```
		output:
		[[1 2]
		 [3 4]
		 [5 6]]
		[[1 2 5]
		 [3 4 6]]
		
		```
		
	5. r_ and c_
		
		
		```
		a = np.r_[1:4,0,4]
		print(a)		
		
		b = np.c_[np.array([1,2,3]), np.array([4,5,6])]
		print(b)
		
		c = np.c_[np.array([1,2,3])]
		print(c)

		# 注意这里多了个方括号
		d = np.c_[np.array([[1, 2, 3]]), 0, 0, np.array([[4, 5, 6]])]
		print(d)
		```
		
		```
		output:
		# 分割线 a:
		[1 2 3 0 4]
		# 分割线 b:
		[[1 4]
		 [2 5]
		 [3 6]]
		 # 分割线 c:
		[[1]
		 [2]
		 [3]]
		 # 分割线 d:
		 [[1 2 3 0 0 4 5 6]]
		```
	
5. 分割矩阵 Splitting one array into several smaller ones
	
	
	
	
	
		
		
		
		

