# docker 部署 Spring Boot Jar

## 文件传输

 scp -P 22 snore-origin-0.0.1-SNAPSHOT.jar root@47.97.xxx.xxx:/project/2018/mar/snore2

## 编写 Dockerfile

在```/project/2018/mar/snore2```下，新建 Dockerfile，编辑

```
FROM java
ADD ./snore-origin-0.0.1-SNAPSHOT.jar  /snore.jar
EXPOSE 8801
CMD ["java","-jar","/snore.jar"]
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
```

## java

拉取java镜像

docker pull java

## 建立镜像

```
docker build -t snore:1.1 .
```

返回：

```
Step 1/6 : FROM java
 ---> d23bdf5b1b1b
Step 2/6 : ADD ./snore-origin-0.0.1-SNAPSHOT.jar  /snore.jar
 ---> Using cache
 ---> 9c04e7cccc26
Step 3/6 : EXPOSE 8801
 ---> Using cache
 ---> d3c9edc9a7b7
Step 4/6 : CMD ["java","-jar","/snore.jar"]
 ---> Using cache
 ---> 2fb7e1f2e520
Step 5/6 : ENV TZ=Asia/Shanghai
 ---> Running in d5b621cb526e
Removing intermediate container d5b621cb526e
 ---> 24a60bc3c4f6
Step 6/6 : RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
 ---> Running in 7938a37f2a1f
Removing intermediate container 7938a37f2a1f
 ---> 8ebbcf82b942
Successfully built 8ebbcf82b942
Successfully tagged snore1.1:latest
```

## 运行

docker run -d -p 8801:8801 --name snore1.1 snore:1.1

## 其他命令

docker ps

docker logs -f --tail 200 snore1.1.0




