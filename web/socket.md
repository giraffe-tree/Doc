# socket


Socket是j2se在网络编程这块最基本的东西。把一系列网络io复杂性封装。但是光有io，光能传输数据，不足以完成标准化的网络通信。所以在这个基础上，加入了协议支持。比如web容器(tomcat等)加入了http协议的解析(所谓的协议，就是一系列带有标准格式的字符串)。而把里面可以独立给程序员的模型接口抽取出来，就是Servlet。所以，Servlet可以看做是web容器运行的一部分逻辑(请求和响应，即request和response其实可以看成是dto，最后执行完servlet.service方法后，由容器传递给socket类的outputstream，完成相关操作)。而Socket则是web容器的核心(负责交换协议)。


[socket到底是什么](https://www.zhihu.com/question/29637351)

Socket是进程通讯的一种方式，即调用这个网络库的一些API函数实现分布在不同主机的相关进程之间的数据交换。













