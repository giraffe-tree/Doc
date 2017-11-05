# Numpy exercises

参考网址:

- 含 tips 的 [100 numpy exercises with hint](https://github.com/rougier/numpy-100/blob/master/100%20Numpy%20exercises%20with%20hint.md)
- 含 答案 的 [100 numpy exercises with answers](https://github.com/rougier/numpy-100/blob/master/100%20Numpy%20exercises.md)
- 其他 numpy 知识 [numpy Reference](https://docs.scipy.org/doc/numpy-1.13.0/reference/index.html#reference)
- numpy 函数 [numpy func index](https://docs.scipy.org/doc/numpy/genindex.html)

## something diff

1.  Find indices of non-zero elements from [1,2,0,0,4,0]. (★☆☆)

	```
	def q10():
   
	    x = np.array([1,2,0,0,4,0])
	    y = np.where(x!=0)
    	 print(y)	
    ```
	
	other answer
	
	```
	nz = np.nonzero([1,2,0,0,4,0])
	print(nz)
	```

2. Create a 3x3x3 array with random values (★☆☆)

	```
	def q12():
	    x = np.random.random(27).reshape(3,3,3)
	    print(x)
	    pass
	```

	other answer
	
	```
	Z = np.random.random((3,3,3))
	# Z = np.random.random([3,3,3])
	print(Z)
	```

3. Create a 10x10 array with random values and find the minimum and maximum values (★☆☆)
	
	```
	def q13():

	    x = np.random.random((10,10))
	    num_max = np.max(x)
	    num_min = np.min(x)
	    print(num_max)
	    print(num_min)
	
	    pass
	```
	
	other answer
	
	```
	Z = np.random.random((10,10))
	Zmin, Zmax = Z.min(), Z.max()
	print(Zmin, Zmax)
	```

4. Create a 2d array with 1 on the border and 0 inside (★☆☆)
	
	- ndarray 转成 list ==> ```ndarray.tolist()```

		
	```
	def q15(high):
	    
	    x = np.zeros((high,high))
	    x[0,:]=1
	    x[:,0]=1
	    x[high-1,:]=1
	    x[:,high-1]=1
	    print(x)

    	pass
	```	 
	
	other answer
	
	```
	Z = np.ones((10,10))
	Z[1:-1,1:-1] = 0
	print(Z)
	```

5.  How to add a border (filled with 0's) around an existing array? (★☆☆)


	other answer 1
	
	```
	Z = np.ones((5,5))
	Z = np.pad(Z, pad_width=1, mode='constant', constant_values=0)
	print(Z)
	
	```
	
	other answer 2
	
	```
	def padwithtens(vector, pad_width, iaxis, kwargs):
	    vector[:pad_width[0]] = 0
	    vector[-pad_width[1]:] = 0
	    return vector
	
	
	def q16_test():
	    a = np.arange(12).reshape(3, 4)
	
	    y = np.lib.pad(a, 1, padwithtens)
	    print(y)
   		pass
	```



6. Create a 5x5 matrix with values 1,2,3,4 just below the diagonal (★☆☆)

	other answer
	
	```
	def q18():
    '''18. Create a 5x5 matrix with values 1,2,3,4 just below the diagonal (★☆☆)'''
	    Z = np.diag(np.arange(1,5), k=-1)
	    print(Z)
	    pass
	
	q18()
	
	# output
	[[0 0 0 0 0]
	 [1 0 0 0 0]
	 [0 2 0 0 0]
	 [0 0 3 0 0]
	 [0 0 0 4 0]]
	```

7.  Create a 8x8 matrix and fill it with a checkerboard pattern (★☆☆)

	other answer
	
	```
	Z = np.zeros((8,8),dtype=int)
	Z[1::2,::2] = 1
	Z[::2,1::2] = 1
	print(Z)
	```
	


8. Consider a (6,7,8) shape array, what is the index (x,y,z) of the 100th element?

	**unravel_index** :
	
	- Converts a flat index or array of flat indices into a tuple of coordinate arrays.
	- **return :**  Each array in the tuple has the same shape as the indices array.
	
	
	```
	# e.g.
   x = np.unravel_index([1,1,2], (6,7,8))
    print(x)
    y = np.unravel_index([22, 41, 37], (7, 6))
    print(y)

    z1 = np.unravel_index(22,(7,6))
    print(z1)

    z2 = np.unravel_index(41,(7,6))
    print(z2)

    z3 = np.unravel_index(37,(7,6))
    print(z3)
	
	# output:
	(array([0, 0, 0]), array([0, 0, 0]), array([1, 1, 2]))
	(array([3, 6, 6]), array([4, 5, 1]))
	(3, 4)
	(6, 5)
	(6, 1)
	```

	other answer
	
	```
	print(np.unravel_index(100,(6,7,8)))

	```
    


9. Create a checkerboard 8x8 matrix using the tile function (★☆☆)

	- np.tile
		-  Construct an array by repeating A the number of times given by reps.
		- 构造重复元素的数组
	
	other answer:
	
	```
	Z = np.tile( np.array([[0,1],[1,0]]), (4,4))
	print(Z)
	```

10. 矩阵点乘的两种方法

	```
	def q24():
	    a = np.arange(15).reshape(5,3)
	    b= np.arange(6).reshape(3,2)
	
	    x = np.dot(a,b)
	    print(x)
	    print(' -- - - - -- ')
	
	    y = a @ b
	    print(y)
   
	```


11. Given a 1D array, negate all elements which are between 3 and 8, in place. (★☆☆)


	```
	 Z = np.arange(11)
    Z[(3 < Z) & (Z <= 8)] *= -1
    print(Z)
	
	```

12. 关于 >> 和 <<

	```
	 Z = np.arange(1,5)
    print(Z)
    
    # 2 左移动1位,2位,3位,4位
    print(2 << Z )
    
    # 1,2,3,4 右移动2位
    print(Z >> 2)

    print(2 << Z >> 2)
	
	# output:
	[1 2 3 4]
	[ 4  8 16 32]
	[0 0 0 1]
	[1 2 4 8]

	```

13. astype

	```
	 x = np.array([1.,2.5,-1.5,3.5,-2.5,-0.5,3.8,2.9])
    print(x)
    y = x.astype(int)
    print(y)
    
    print(x)
    # x 本身不改变
  
  
	# output
	# 正取小,负取大
	[ 1.   2.5 -1.5  3.5 -2.5 -0.5  3.8  2.9]
	[ 1  2 -1  3 -2  0  3  2]
	[ 1.   2.5 -1.5  3.5 -2.5 -0.5  3.8  2.9]
	
	```


14. ceil floor round

	向上取整ceil 向下取整floor 四舍五入round
	
	```
	 a =np.random.uniform(-10,10,10)
    print(a)
    print( '\n -- ceil-- -')
    print(np.ceil(a))
    print( '\n -- floor-- -')
    print(np.floor(a))
    print( '\n -- round-- -')
    print(np.round(a))
	```
	
	```
	output :
		[-3.86595503  6.57210444 -3.8408293   1.34876732  8.60997263  3.12067361
	  5.24999694 -0.08659399 -8.54137953 -8.14687557]
	
	 -- ceil-- -
	[-3.  7. -3.  2.  9.  4.  6. -0. -8. -8.]
	
	 -- floor-- -
	[-4.  6. -4.  1.  8.  3.  5. -1. -9. -9.]
	
	 -- round-- -
	[-4.  7. -4.  1.  9.  3.  5. -0. -9. -8.]
	```
	
	**round 0.5时**
	
	```
	 a = np.array([3.5,2.5,1.5,0.5,-1.5,-2.5,-0.5])
    print(np.round(a))
    
    # output:
    [ 4.  2.  2. 0. -2. -2. -0.]
    
	```
	
	

15. copysign(b,a)

	把 a 的符号赋给 b
	
	```
	a = np.random.uniform(-1,1,10)
    b = np.arange(10)

    x = np.copysign(b,a)

    print(x)
    
    # output:
    [ 0.  1. -2. -3. -4.  5.  6.  7. -8. -9.]
	```

16. intersect1d  在两个数组中找到公共值
	
	```
	 a = np.arange(1,8)
    b = np.arange(5,10)

    x =np.intersect1d(a,b)
    print(x)
    
    # output:
    [5,6,7]
	```

17.


