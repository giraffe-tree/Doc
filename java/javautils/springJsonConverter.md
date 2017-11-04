
http://www.cnblogs.com/rodge-run/p/6545630.html

org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


java 中使用jackson 来进行对java对象的序列化

http://blog.csdn.net/zmx729618/article/details/52161069


## Json 注解


@JsonIgnore

- 此注解用于属性上，作用是进行JSON操作时忽略该属性。

@JsonFormat

- 此注解用于属性上，作用是把Date类型直接转化为想要的格式，如@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")。

@JsonProperty

- 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name，@JsonProperty("name")。

## Spring 中使用 Jackson












