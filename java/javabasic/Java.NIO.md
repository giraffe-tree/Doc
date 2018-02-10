# Java.NIO

## Reference 

1. [Java Nio Read File Example](https://examples.javacodegeeks.com/core-java/java-nio-read-file-example/)



## 1. 概述

The NIO.2 API was introduced in Java 7 as a replacement for the java.io.File class. It provides a flexible, and intuitive API for use with files.

### 组成

1. Channels  通道
2. Buffers  缓冲
3. Selectors  选择器

### Channel 实现

1. FileChannel
2. DatagramChannel
3. SocketChannel
4. ServerSocketChannel

正如你所看到的，这些通道涵盖了UDP 和 TCP 网络IO，以及文件IO。

### Buffer 实现

1. ByteBuffer
2. CharBuffer
3. DoubleBuffer
4. FloatBuffer
5. IntBuffer
6. LongBuffer
7. ShortBuffer 
8. MappedByteBuffer

### Selector

Selector允许单线程处理多个 Channel。如果你的应用打开了多个连接（通道），但每个连接的流量都很低，使用Selector就会很方便

要使用Selector，得向Selector注册Channel，然后调用它的select()方法。这个方法会一直阻塞到某个注册的通道有事件就绪。一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新连接进来，数据接收等。

## 2. channels

FileChannel 从文件中读写数据。

DatagramChannel 能通过UDP读写网络中的数据。

SocketChannel 能通过TCP读写网络中的数据。

ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

## 3. buffer

### Buffer的基本用法

使用Buffer读写数据一般遵循以下四个步骤：

1. 写入数据到Buffer
2. 调用flip()方法
3. 从Buffer中读取数据
4. 调用clear()方法或者compact()方法

	- clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据


## Read File

### creating a nio Path

The easiest way to create a Path Object is to use the java.nio.files.Paths factory class. 

### reading files with the NIO API

```
try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){

    String currentLine = null;
    while((currentLine = reader.readLine()) != null{        
    	System.out.println(currentLine); 
	}
    
}catch(IOException ex){
    ex.printStackTrace(); //handle an exception here
}
```


#### try-with-resources statement

```try-with-resources statement``` ，它会自动关闭括号内的资源（resources），不用手动添加代码   ```xx.close();```  了。


### Using NIO API with streams  -- Java 8

```
Path path = Paths.get("src/main/java/com/chen/apidemo/nio/data/nio-data.txt");

try {
    Files.lines(path).forEach(System.out::println);
} catch (IOException ex) {
    ex.printStackTrace();//handle exception here
}
```

















