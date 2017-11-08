# Pandas

## 入门


### Series

有索引的一维数组

### dataFrame

表格型的数据结构, 可以看做由 Series 组成的字典


## 创建

### 创建 Series

```
s = pd.Series([1, 23, 4, 46, 7, np.nan])

out:
0     1.0
1    23.0
2     4.0
3    46.0
4     7.0
5     NaN
```

### 创建 DataFrame

#### 第一种方式 通过 ndarray 创建

**这里先建立一个 index **

```
#  Return a fixed frequency DatetimeIndex 返回固定频率的时间index
dates = pd.date_range('20130101', periods=6)
print(dates)

# output:
DatetimeIndex(['2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04',
               '2013-01-05', '2013-01-06'],
              dtype='datetime64[ns]', freq='D')
```

**通过 ndarray 创建**

```
# 从正态分布返回结果 通过 ndarray 创建,with a datetime index and labeled columns:
df = pd.DataFrame(np.random.randn(6, 4), index=dates, columns=list('ABCD'))
print(df)

# output:
                  A         B         C         D
2013-01-01  0.443262 -0.972230  1.303489 -0.880484
2013-01-02  0.500429 -0.415385 -0.530789  1.942610
2013-01-03 -0.642731 -0.307271  0.117926 -0.436084
2013-01-04  0.302558 -0.540955  1.122264  0.055569
2013-01-05 -0.096519  0.291640 -0.506511  2.351696
2013-01-06 -2.119624 -1.993998 -0.382961 -1.009017

```

#### 第二种方式, 通过字典创建

```
# 例如: 通过字典创建
df2 = pd.DataFrame({'A': 1.,
                    'B': pd.Timestamp('20130102'),
                    'C': pd.Series(1, index=list(range(4)), dtype='float32'),
                    'D': np.array([3] * 4, dtype='int32'),
                    'E': pd.Categorical(["test", "train", "test", "train"]),
                    'F': 'foo'})
print(df2)
```


## View 查看

1. **dtypes** 

	```
	df.dtypes
	
	# output:
	A    float64
	B    float64
	C    float64
	D    float64
	dtype: object
	```

2. **head() / tail()**

	查看开始的几行或者最后的几行, 可以指定查看的行数,不指定则默认为5行
	
	> See the top & bottom rows of the frame . The default number of elements to display is five. 

3. **index**

	

	```
	# 例如:
	DatetimeIndex(['2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04',
               '2013-01-05', '2013-01-06'],
              dtype='datetime64[ns]', freq='D')

	```

4. **columns**

	```
	# 例如:
	Index(['A', 'B', 'C', 'D'], dtype='object')

	```

5. **values**

	return:   ```<class 'numpy.ndarray'>```

6. **describe()**


	```
	# 例如:
	             A         B         C         D
	count  6.000000  6.000000  6.000000  6.000000
	mean  -0.052528  0.026794 -0.375102 -0.172018
	std    1.109063  1.558546  0.504371  1.063755
	min   -1.627172 -2.959138 -1.140742 -1.759241
	25%   -0.667449 -0.035760 -0.611272 -0.660150
	50%    0.015054  0.505806 -0.398306 -0.261549
	75%    0.464234  0.797524  0.043293  0.633499
	max    1.562886  1.429809  0.178512  1.111402
	```

## 转置 和 排序

### 转置

```dataFrame.T```

### 排序

1. **给 index/columns 排序**

	>原 dataFrame 不变,0 给index名字排序, 1给 column名字排序

	```
	# 例如: 给 column名字排序 ,升序
	df_sort = df.sort_index(axis=1, ascending= True)
	```

2. **给数据排序**

	```
	# 例如: 给 B 列排序降序
	df_sort2 = df.sort_values(by='B',ascending=False)
	```

## 查询 select

1. 查找列 ```df['A']```
2. 查找指定行 ```df[:5:2]```
3. 指定日期(行) ``` df['20130102':'20130104'] ``` 或者你也可以 ```df['20130102':'20130105':2]```
4. 使用loc  

	
	> 注意: ```df.loc[dates[0]] ```等同于 ```df.loc['20130101',:]```

	```
	# df.loc[dates[0]] 等同于 df.loc['20130101',:]
	# 例: 输出为
	A    0.384885
	B    0.249399
	C   -0.247128
	D   -0.548576
	Name: 2013-01-01 00:00:00, dtype: float64
	```
	
	```
	# df.loc['20130103','A']
	# output: 
	
	-0.715343656199
	```
	
	
	```
	# df.loc['20130101',['A','C']]
	# output: 
	
	A    0.721214
	C    0.644558
	```

	```
	# df.loc['20130102':'20130104',['A','B']]
	# output:
	                   A         B
	2013-01-02 -0.376103 -1.373135
	2013-01-03  0.112897 -0.272932
	2013-01-04 -0.523336  0.039817	
	
	```

5. 使用 iloc

	使用位置信息查找  Selection by Position

	1. ```df.iloc[0]```等同于```df.loc[dates[0]]```

		```
		# output: 
		A   -1.508724
		B    0.974697
		C   -0.622888
		D    0.304138
		Name: 2013-01-01 00:00:00, dtype: float64
		```

	2. ```x1 = df.iloc[3:5,0:2]```

		```
		# output:
		                   A         B
		2013-01-04 -0.409623 -0.353747
		2013-01-05 -0.304705  0.478402
		```

	3. 其他的 iloc 操作

		> ``` df.iloc[[1,2,4],[0,2]] ```
		
		> ``` df.iloc[1:3,:] ```

		> ``` df.iloc[1,1] ```


6. 使用判断筛选  Boolean Indexing











