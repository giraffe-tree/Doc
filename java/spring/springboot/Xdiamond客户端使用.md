# Xdiamond 客户端使用指南

## 第一步 加入jar到pom中

1. 示例如下,请注意清除多余的依赖
2. 现在xdiamond的最新版本为1.0.4

```
        <dependency>
            <groupId>io.github.hengyunabc.xdiamond</groupId>
            <artifactId>xdiamond-client</artifactId>
            <version>1.0.4</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-context</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-test</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

```

## 第二步 注册 xDiamondConfigFactoryBean

通过实现```EnvironmentAware```接口获取远程配置中心的ip和端口

```
@Configuration
public class XdiamondConfig implements EnvironmentAware {

    private final static Logger LOGGER = LoggerFactory.getLogger(XdiamondConfig.class);

    private Environment environment;

    @Bean
    public XDiamondConfigFactoryBean xDiamondConfigFactoryBean() {

        XDiamondConfigFactoryBean xDiamondConfigFactoryBean = new XDiamondConfigFactoryBean();

        String groupid = environment.getProperty("xdiamond.client.groupid");
        String artifactid = environment.getProperty("xdiamond.client.artifactid");
        String version = environment.getProperty("xdiamond.client.version");
        String profile = environment.getProperty("xdiamond.client.profile");
        String secretkey = environment.getProperty("xdiamond.client.secretkey");

        //这里默认了获取不到就使用 http://localhost:5678,可以自行设置
        String host = environment.getProperty("xdiamond.server.host","localhost");
        String port = environment.getProperty("xdiamond.server.port","5678");

        LOGGER.info("\nXdiamondConfig: \n\t groupid=" + groupid + "\n\t artifactid=" + artifactid + "\n\t version="
                + version + "\n\t profile=" + profile + "\n\t host=" + host + "\n\t port=" + port);

        xDiamondConfigFactoryBean.setArtifactId(artifactid);
        xDiamondConfigFactoryBean.setGroupId(groupid);
        xDiamondConfigFactoryBean.setVersion(version);
        xDiamondConfigFactoryBean.setProfile(profile);
        xDiamondConfigFactoryBean.setSecretKey(secretkey);

        xDiamondConfigFactoryBean.setServerHost(host);
        xDiamondConfigFactoryBean.setServerPort(port);

        return xDiamondConfigFactoryBean;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
```


## 第三步  加入你的配置

### 方法一 在```application.yml```中配置

直接在 ```application.yml``` 中加入以下内容

- groupid: 项目的组名 groupid
- artifactid: 项目名称
- version: 版本号
- profile: 需要获哪个分支的配置 如 : test,dev,product等
- secretkey: 123456 密匙

```
server:
  prot: 8888
xdiamond:
  client:
    groupid: com.xxxxx
    artifactid: xxxxDemo
    version: 0.0.1-SNAPSHOT
    profile: dev
    secretkey: 123456
  server:
    host: localhost
    port: 5678
```

### 方法二 设置其他的配置文件

这里假设你在  ```src/main/resources``` 目录下有一个```xdiamond.yml```的配置文件

它的内容如下:

```
xdiamond:
  client:
    groupid: com.xxxxx
    artifactid: xxxxDemo
    version: 0.0.1-SNAPSHOT
    profile: dev
    secretkey: 123456
  server:
    host: localhost
    port: 5678
```

**首先**,你需要实现一个监听器,它需要实现```ApplicationListener<ApplicationEnvironmentPreparedEvent>```接口,示例如下:

```
public class LoadAdditionPropertiesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoadAdditionPropertiesListener.class);

    private ResourceLoader loader = new DefaultResourceLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        Resource resource = loader.getResource("classpath:xdiamond.yml");
        LOGGER.info("getResource from xdiamond.yml");
        PropertySource<?> propertySource;
        try {
            propertySource = new PropertySourcesLoader().load(resource);
            event.getEnvironment().getPropertySources().addLast(propertySource);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
```


**然后**,你需要告诉 springboot ,你有这个监听器,你要去调用它

主要步骤分三步:

1. 在 ```src/main/resources``` 目录下新建 ```META-INF``` 文件夹
2. 在第一步的目录下新建 ```spring.factories``` 文件
3. 在```spring.factories``` 文件注册你所需要的监听器

其中```spring.factories```文件的内容如下

```
org.springframework.context.ApplicationListener=com.motherboard.cilentDemo.config.LoadAdditionPropertiesListener
```

好了,现在你可以连上远程的配置中心了,去试试吧!
