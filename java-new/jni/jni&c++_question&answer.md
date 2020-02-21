# JNI & C++ - Q&A


1. `.so`,`.dll`

	- http://gernotklingler.com/blog/creating-using-shared-libraries-different-compilers-different-operating-systems/

2. C++ “std::string has not been declared” error
	
	- https://stackoverflow.com/questions/17040098/c-stdstring-has-not-been-declared-error
	- gcc用法以及静态/动态链接
	- https://www.jianshu.com/p/31b33e5c48d7 
	- linux jni
	- https://www.jianshu.com/p/e175d5417e05

3. jni 使用问题

	- 编译版本问题, C++ 代码在不同 VS 下表现不一致
	- Release/Debug 版本速度差异巨大, 30ms/5s
	- 文件编码问题 C/C++ -> 命令行 -> 其他选项 -> /utf-8 
	- 预编译头问题  C/C++ -> 预编译头 -> 不使用预编译头


4. winscp transfer file to local Windows

5. Dockerfile 详解

	- https://yeasy.gitbooks.io/docker_practice/image/build.html

6. AUFS 

	- advanced multi-layered unification filesystem，高级多层统一文件系统

7. Dockerfile 中的VOLUME 和 -v

8. `java [-options] -jar jarfile [args...]`

	- https://stackoverflow.com/questions/5045608/proper-usage-of-java-d-command-line-parameters

9. `undefined symbol: _Z11fullanalyseRSt6vectorIdSaIdEEiiiiii`

	- 乱码问题
	- `git config --global gui.encoding utf-8`

	- https://stackoverflow.com/questions/12573816/what-is-an-undefined-reference-unresolved-external-symbol-error-and-how-do-i-fix
	- https://stackoverflow.com/questions/28082675/undefined-reference-when-using-a-function-included-in-a-header-file

## 2018.12.13

1.  com.zaxxer.hikari.pool.PoolBase - Failed to validate connection com.mysql.jdbc.JDBC4Connection@5fde3a5e (No operations allowed after connection closed.
	
	- http://cmsblogs.com/?p=2522
	- https://stackoverflow.com/questions/41008350/no-operations-allowed-after-connection-closed-errors-in-slick-hikaricp

2. `cout’ is not a member of ‘std`

	-  `#include <iostream>`

3. `error: ‘>>’ should be ‘> >’ within a nested template argument list`
	
	- `vector<pair<string, int>> word;`  ->  `vector<pair<string, int> > word;`
	- https://blog.csdn.net/u011630575/article/details/45557573

4. `Sorry, unimplemented: 64 bit mode not compiled in`

	https://stackoverflow.com/questions/38589886/sorry-unimplemented-64-bit-mode-not-compiled-in


## 2019.7.31


1. `Can't find dependent libraries`

	- dependency walker
		
## 2020.02.20

1. 使用 docker openjdk:8 image 能运行 , 但使用 centos7 本地环境 openjdk 1.8.0181 报出 
	- ```java.lang.UnsatisfiedLinkError:/lib64/libstdc++.so.6: version `GLIBCXX_3.4.20' not found```
	- 解决方案
		- 升级 glibc 
		- https://blog.csdn.net/qq_20989105/article/details/90712139

2. emqx 共享订阅

	- https://docs.emqx.io/broker/latest/cn/guide.html#shared-subscription


## 2020.02.21

1. alpine 是什么?

2. docker 镜像中 运行时, 缺少 libm 怎么办

	- 查看 so 依赖
		- ```ldd xxx.so```
		- ```ldd: warning: you do not have execution permission for `./xxx.so' ```
		- ```./xxx.so: error while loading shared libraries: /lib64/libc.so: invalid ELF header```
		- 要解决 invalid elf header问题，首先要弄明白elf是什么。ELF(Executable and Linking Format)是一种对象文件的格式， 在linux平台上被广泛接受，作为缺省的二进制文件格式来使用
		- 原因是该路径下的.so文件与运行程序的环境不匹配，比如我在mac电脑上编译生成的.so文件，直接放到linux服务器上跑了，自然会有错误。解决的方法是在Linux环境中重新编译生成新的.so文件。


3. linux 下查看 .so 导出函数列表
		- `nm -D xxx.so`

4. undefined symbol

```
java.lang.UnsatisfiedLinkError: Error looking up function 'funcName': /root/.cache/JNA/temp/jna1727918695523262854.tmp: undefined symbol: funcName
	at com.sun.jna.Function.<init>(Function.java:252) ~[jna-5.3.1.jar!/:5.3.1 (b0)]
	at com.sun.jna.NativeLibrary.getFunction(NativeLibrary.java:594) ~[jna-5.3.1.jar!/:5.3.1 (b0)]
	at com.sun.jna.NativeLibrary.getFunction(NativeLibrary.java:570) ~[jna-5.3.1.jar!/:5.3.1 (b0)]
	at com.sun.jna.NativeLibrary.getFunction(NativeLibrary.java:556) ~[jna-5.3.1.jar!/:5.3.1 (b0)]
```

		- c++代码：注意加上extern “C”，否则无法找到c++方法。
		- https://www.cnblogs.com/LiuYanYGZ/p/6109579.html

5. ldd xxx.so `GLIBCXX_3.4.20` not found

```
src/xxx.so: /lib64/libstdc++.so.6: version `GLIBCXX_3.4.20' not found (required by src/xxx.so)
src/xxx.so: /lib64/libstdc++.so.6: version `GLIBCXX_3.4.21' not found (required by src/xxx.so)
```

6. springboot 获取资源文件
	- 例如: 文件路径 `resources/data/4.txt`
	-  `File file = ResourceUtils.getFile("classpath:data/4.txt");`

