# Tensorflow 总结二 : 在windows上使用tensorflow-gpu

## 参考

https://www.tensorflow.org/install/gpu

## 下载软件

1. NVIDIA® GPU drivers —CUDA 9.0 requires 384.x or higher.

	- https://www.nvidia.com/Download/index.aspx?lang=en-us
	- 大约 500M 多一点

2. CUDA® Toolkit —TensorFlow supports CUDA 9.0.
	
	- https://developer.nvidia.com/cuda-zone
	- 2G 左右
	- 依赖 visual stdio
	- 可以使用命令 `nvcc -V` 查看cuda版本

3. cuDNN SDK (>= 7.2)
	
	- 需要注册 nvidia 用户

## 添加到环境变量

Add the CUDA, CUPTI, and cuDNN installation directories to the %PATH% environmental variable. For example, if the CUDA Toolkit is installed to C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v9.0 and cuDNN to C:\tools\cuda, update your %PATH% to match:

```
SET PATH=C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v9.0\bin;%PATH%
SET PATH=C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v9.0\extras\CUPTI\libx64;%PATH%
SET PATH=C:\tools\cuda\bin;%PATH%
```

## 安装完配置完

```python
from tensorflow.python.client import device_lib
print(device_lib.list_local_devices())
```

输出:

```
[name: "/device:CPU:0"
device_type: "CPU"
memory_limit: 268435456
locality {
}
incarnation: 293956486851505770
]
```

发现并没有成功, 检查了下版本, 我下载了默认的 cuda10.0, 看tensorflow的文档, 感觉可能是 cuda10.0 不支持, 就换回了 cuda9.0
​	
	- 我这边直接下载的 9.0, 并没有下载新的 9.2, 怕不兼容
	- 下载地址如下: 
	- https://developer.nvidia.com/cuda-90-download-archive?target_os=Windows&target_arch=x86_64&target_version=10

## 尝试

我重启了 win10, 检查了所有的环境变量, 都是 cuda9.0的, 包括cuDDN也使用了相应的版本. 我尝试着运行了类似以下程序

```python
import tensorflow as tf
# Creates a graph.
a = tf.constant([1.0, 2.0, 3.0, 4.0, 5.0, 6.0], shape=[2, 3], name='a')
b = tf.constant([1.0, 2.0, 3.0, 4.0, 5.0, 6.0], shape=[3, 2], name='b')
c = tf.matmul(a, b)
# Creates a session with log_device_placement set to True.
sess = tf.Session(config=tf.ConfigProto(log_device_placement=True))
# Runs the op.
print(sess.run(c))
```

日志打印类似以下:

```
# 该日志来源于: https://stackoverflow.com/questions/44829085/tensorflow-not-running-on-gpu
# 有兴趣可以看看
MatMul: (MatMul): /job:localhost/replica:0/task:0/cpu:0
2017-06-29 17:09:38.783183: I c:\tf_jenkins\home\workspace\release-win\m\windows\py\35\tensorflow\core\common_runtime\simple_placer.cc:847] MatMul: (MatMul)/job:localhost/replica:0/task:0/cpu:0
b: (Const): /job:localhost/replica:0/task:0/cpu:0
2017-06-29 17:09:38.784779: I c:\tf_jenkins\home\workspace\release-win\m\windows\py\35\tensorflow\core\common_runtime\simple_placer.cc:847] b: (Const)/job:localhost/replica:0/task:0/cpu:0
a: (Const): /job:localhost/replica:0/task:0/cpu:0
2017-06-29 17:09:38.786128: I c:\tf_jenkins\home\workspace\release-win\m\windows\py\35\tensorflow\core\common_runtime\simple_placer.cc:847] a: (Const)/job:localhost/replica:0/task:0/cpu:0
[[ 22.  28.]
 [ 49.  64.]]
```

很显然的是, 我仍然使用的是 cpu

## 切换到 `tensorflow-gpu`

原先使用 `pipenv` 下载了 `tensorflow-gpu` 的依赖, 但我使用的时候应该是出了点问题.上网查了查, 可能是依赖缺失

	- 参考了以下链接
	- https://stackoverflow.com/questions/41402409/tensorflow-doesnt-seem-to-see-my-gpu

我重新安装了 `tensorflow-gpu`, 注意将`tensorflow` `uninstall`

```sh
pip3 uninstall tensorflow
pip3 uninstall tensorflow-gpu
pip3 install tensorflow-gpu
```

需要注意的是, 虽然我安装的是`tensorflow-gpu`, 但程序中仍然是 `import tensorflow as tf`, 这里是不用变化的

重新执行以下程序

```python
import tensorflow as tf

# Creates a graph.
a = tf.constant([1.0, 2.0, 3.0, 4.0, 5.0, 6.0], shape=[2, 3], name='a')
b = tf.constant([1.0, 2.0, 3.0, 4.0, 5.0, 6.0], shape=[3, 2], name='b')
c = tf.matmul(a, b)
# Creates a session with log_device_placement set to True.
sess = tf.Session(config=tf.ConfigProto(log_device_placement=True))
# Runs the op.
print(sess.run(c))
```

在第一次使用时, 大约需要几分钟初始化(我大约等了3分钟), 之后执行就很快了.

输出:

```
2018-10-23 00:09:18.071663: I tensorflow/core/platform/cpu_feature_guard.cc:141] Your CPU supports instructions that this TensorFlow binary was not compiled to use: AVX2
2018-10-23 00:09:18.455997: I tensorflow/core/common_runtime/gpu/gpu_device.cc:1411] Found device 0 with properties:
name: GeForce GTX 1060 5GB major: 6 minor: 1 memoryClockRate(GHz): 1.759
pciBusID: 0000:09:00.0
totalMemory: 5.00GiB freeMemory: 4.12GiB
2018-10-23 00:09:18.456462: I tensorflow/core/common_runtime/gpu/gpu_device.cc:1490] Adding visible gpu devices: 0
2018-10-23 00:12:56.027567: I tensorflow/core/common_runtime/gpu/gpu_device.cc:971] Device interconnect StreamExecutor with strength 1 edge matrix:
2018-10-23 00:12:56.028080: I tensorflow/core/common_runtime/gpu/gpu_device.cc:977]      0
2018-10-23 00:12:56.028349: I tensorflow/core/common_runtime/gpu/gpu_device.cc:990] 0:   N
2018-10-23 00:12:56.041123: I tensorflow/core/common_runtime/gpu/gpu_device.cc:1103] Created TensorFlow device (/job:localhost/replica:0/task:0/device:GPU:0 with 3854 MB memory) -> physical GPU (device: 0, name: GeForce GTX 1060 5GB, pci bus id: 0000:09:00.0, compute capability: 6.1)
2018-10-23 00:12:56.229140: I tensorflow/core/common_runtime/direct_session.cc:291] Device mapping:
/job:localhost/replica:0/task:0/device:GPU:0 -> device: 0, name: GeForce GTX 1060 5GB, pci bus id: 0000:09:00.0, compute capability: 6.1

2018-10-23 00:12:56.231970: I tensorflow/core/common_runtime/placer.cc:922] MatMul: (MatMul)/job:localhost/replica:0/task:0/device:GPU:0
2018-10-23 00:12:56.232362: I tensorflow/core/common_runtime/placer.cc:922] a: (Const)/job:localhost/replica:0/task:0/device:GPU:0
2018-10-23 00:12:56.232670: I tensorflow/core/common_runtime/placer.cc:922] b: (Const)/job:localhost/replica:0/task:0/device:GPU:0
[[22. 28.]
 [49. 64.]]
Device mapping:
/job:localhost/replica:0/task:0/device:GPU:0 -> device: 0, name: GeForce GTX 1060 5GB, pci bus id: 0000:09:00.0, compute capability: 6.1
MatMul: (MatMul): /job:localhost/replica:0/task:0/device:GPU:0
a: (Const): /job:localhost/replica:0/task:0/device:GPU:0
b: (Const): /job:localhost/replica:0/task:0/device:GPU:0

```

另外提供一个程序, 用于检查 gpu 是否能够使用

```

```

输出如下:

```
[
name: "/device:CPU:0"
device_type: "CPU"
memory_limit: 268435456
locality {
}
incarnation: 5996780936386827671
, 
name: "/device:GPU:0"
device_type: "GPU"
memory_limit: 4041408512
locality {
  bus_id: 1
  links {
  }
}
incarnation: 5806263935802981584
physical_device_desc: "device: 0, name: GeForce GTX 1060 5GB, pci bus id: 00009:00.0, compute capability: 6.1"
]
```



