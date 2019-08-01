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
		


