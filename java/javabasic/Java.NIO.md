# Java.NIO

## Reference 

1. [Java Nio Read File Example](https://examples.javacodegeeks.com/core-java/java-nio-read-file-example/)

## 0. 快速入门 Read File

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

## 3. Buffer

### Buffer的基本用法

使用Buffer读写数据一般遵循以下四个步骤：

1. 写入数据到Buffer
2. 调用flip()方法
3. 从Buffer中读取数据
4. 调用clear()方法或者compact()方法

	- clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据

### 属性

 A Buffer has content, a position, a limit and capacity.








## WHY 为什么要用NIO

BIO 是一个一连接一线程的模型,它可以解决单线程同步阻塞，cpu资源占用的问题。

但在解决了，cpu资源占用的问题后，新的问题又出现了。BIO 严重依赖线程，而在线程创建，销毁和切换的成本都很高，另外一个原因就是，一旦线程数很高时，连接数过多时，BIO的模型就很难有效传递数据。





# Commons IO

## IOUtils

## FileUtils

FileUtils类包含用于处理File对象的实用程序方法。这些包括阅读，写作，复制和比较文件。

```

File file = new File("/commons/io/project.properties");
List<String> lines = FileUtils.readLines(file, "UTF-8");

```

## FileNameUtils

FilenameUtils类包含用于使用文件名而不使用File对象的实用程序方法。该类旨在使Unix和Windows保持一致，以帮助在这些环境之间进行转换

```
 String filename = "C:/commons/io/../lang/project.xml";
 String normalized = FilenameUtils.normalize(filename);
```

## FileFilterUtils


## Line iterator

```
 LineIterator it = FileUtils.lineIterator(file, "UTF-8");
 try {
   while (it.hasNext()) {
     String line = it.nextLine();
     /// do something with line
   }
 } finally {
   LineIterator.closeQuietly(iterator);
 }
```






