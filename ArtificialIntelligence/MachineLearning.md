# Machine Learning

一个多月前就买了周志华这本 机器学习 ,但是一直没有读.今天下班回来,正好拿来看看.--2017.12.7


## 第一章 绪论

### 主要讲了一些基本的术语

- 数据集
- 训练样本->训练集->假设->真相
- label 标记 -> 标记空间
- 预测的是离散值:分类 classification
- 预测的是连续值:回归 regression
- 对于只涉及两个类别的任务时(binary classification),一个为正类,一个为反类(负类)
- 学得模型后,需要测试,被预测的样本成为:测试样本 testing sample
- 还可以做聚类,将训练集中的项分为若干个组,每个组成为一个簇(cluster)
- 根据是否拥有标记信息,学习任务可以分为两大类:
	
	- 监督学习 supervised learning 如 分类,回归
	- 非监督学习 unsupervised learning  如:聚类

-  归纳 induction 演绎 deduction
- 归纳学习:从样例中学习,归纳
- 布尔学习: 对表示0/1这样的目标概念的学习
- 所有假设 -> 假设空间
- 现实中我们常常会面临很大的假设空间,学习过程是基于有限的样本训练集进行的
- 若多个假设和训练集一致,这些假设的集合 --> 版本空间 version space
- 机器学习算法在学习过程中对某种类型假设的偏好,称为 归纳偏好 inductive bias
-  奥卡姆剃刀 Occam's razor : 切勿浪费较多东西去做，用较少的东西，同样可以做好的事情

	- 若有多个假设与观察一致,则选最简单的那个

- 学习算法的期望性能都是一致的,只有在面对不同问题的时候有所区分

	- 如果一个算法在某类问题上表现良好，那么在所有剩下的问题集合上性能就会下降。
	-  if an algorithm performs well on a certain class of problems then it necessarily pays for that with degraded performance on the set of all remaining problems.

### 发展历史


连接注主义,符号主义,统计学习

支持向量机 SVM Support Vector Machine 

深度学习: 很多层的神经网络

机器学习 云计算 众包

## 第二章 模型评估与选择

### 2.1 经验误差与过拟合



