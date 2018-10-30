# Tensorflow 总结八 : 使用 PTB 数据集

## 安装 models, 导入数据

如果直接使用 `from tensorflow.models.rnn.ptb import reader` 会报错 ` No module named 'tensorflow.models'` 的错误.

这是由于最新版的 tensorflow 已经将 models 视为第三方包, 需要我们自己去下载.

下载地址为`https://github.com/tensorflow/models`, 可以直接下载`zip`文件, 可以科$学%上网的开下全局代理, 不然下载会很慢.

下载完之后, 放入你的python目录下, `Lib\site-packages\tensorflow`中. 例如我的路径为`D:\env\python36\Lib\site-packages\tensorflow`

在引用`from tensorflow.models.tutorials.rnn.ptb import reader`之前, 需要修改`tensorflow.models.tutorials.rnn.ptb.__init__.py` 否则会有以下报错:

```
Traceback (most recent call last):
  File "try_myself/practice/ptb/try_ptb_first.py", line 2, in <module>
    from tensorflow.models.tutorials.rnn.ptb import reader
  File "D:\env\python36\lib\site-packages\tensorflow\models\tutorials\rnn\ptb\__init__.py", line 21, in <module>
    import reader
ModuleNotFoundError: No module named 'reader'

```

只要把 `__init.py` 中

```
import reader
import util
```

改为

```
from tensorflow.models.tutorials.rnn.ptb import reader
from tensorflow.models.tutorials.rnn.ptb import util
```

运行以下程序

```python
import tensorflow as tf
from tensorflow.models.tutorials.rnn.ptb import reader

DATA_PATH = "datasets/PTB_data"
train_data, valid_data, test_data, _ = reader.ptb_raw_data(DATA_PATH)
print(len(train_data))  

# output:
# 929589
```


