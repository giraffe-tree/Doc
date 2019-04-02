# Cmake 使用

## 安装 cmake

https://cmake.org/download/

使用msi, 并将命令加入系统环境变量目录

### 加入了path却无法使用命令

当时我把cmake的bin目录加入了 path 中, 但是我使用 bash/cmd 都不能使用命令 cmake, 猜测可能是因为 path 中的有些目录存在cmake这个文件, 没有访问到最后的cmake bin目录. 我将 cmake bin目录的位置调整到最前面, 就可以在 bash/cmd 中使用了

win10 可能遇到的问题 [Win10 设置了环境变量，但是没有用](https://www.zhihu.com/question/31459186)

## 入门

### 1.CMake编译原理

CMake是一种跨平台编译工具，比make更为高级，使用起来要方便得多。CMake主要是编写CMakeLists.txt文件，然后用cmake命令将CMakeLists.txt文件转化为make所需要的makefile文件，最后用make命令编译源码生成可执行程序或共享库（so(shared object)）。因此CMake的编译基本就两个步骤：

1. cmake
2. make

https://www.cnblogs.com/cv-pr/p/6206921.html

#### 在cmake之后没有makefile

`cmake -G "Unix Makefiles" ..`

> https://stackoverflow.com/questions/39643291/make-without-makefile-after-cmake


#### cmake generate so

> https://stackoverflow.com/questions/17511496/how-to-create-a-shared-library-with-cmake
> https://stackoverflow.com/questions/11293572/cmake-create-a-shared-object

#### CMake link to external library (so)

https://stackoverflow.com/questions/8774593/cmake-link-to-external-library


#### Link .so file to .cpp file via g++ compiling

https://stackoverflow.com/questions/27208932/link-so-file-to-cpp-file-via-g-compiling#comment42899795_27208932

#### cmake tutorial

https://github.com/Campanula/CMake-tutorial

### 一些小技巧

#### 在执行前打印命令

```
make VERBOSE=1

// set(CMAKE_VERBOSE_MAKEFILE on)

```

https://stackoverflow.com/questions/4808303/making-cmake-print-commands-before-executing
