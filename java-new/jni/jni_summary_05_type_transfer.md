# JNI 总结 05 Java 基本类型及 String 在 C++ 中的转换

<!-- MarkdownTOC autolink=true -->

- [目标](#%E7%9B%AE%E6%A0%87)
- [版本](#%E7%89%88%E6%9C%AC)
- [基本数据类型](#%E5%9F%BA%E6%9C%AC%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B)
    - [jint](#jint)
    - [jlong](#jlong)
    - [jbyte](#jbyte)
    - [jboolean 等其他](#jboolean-%E7%AD%89%E5%85%B6%E4%BB%96)
- [jstring](#jstring)
    - [jstring to string](#jstring-to-string)
    - [string to jstring](#string-to-jstring)
- [参考](#%E5%8F%82%E8%80%83)

<!-- /MarkdownTOC -->


## 目标

1. Java 基本类型在 C++ 中的转换

	- jint
	- jlong
	- jbyte
	- jboolean 等

2. String 转换

	- jstring to string
	- string to jstring

## 版本

1. java version

```sh
java version "1.8.0_161"
Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.161-b12, mixed mode)
```

## 基本数据类型

### jint

在`jni_md.h`中定义了 `typedef long jint;` 所以 `jint` 和 C++ 中的 `long`可以混用.

在我的平台上 64位win10, C++ 中的`long`, `int` 均为 4个字节, 所以`long`,`int`,`jint` 都可以混用.

如果需要转成 `uint16_t`这类的, 就像 `int` 一样操作 `jint`就可以了.
 
### jlong

在`jni_md.h`中定义了 `typedef __int64 jlong;`

### jbyte

在`jni_md.h`中定义了`typedef signed char jbyte;`

### jboolean 等其他

```cpp
// jni.h
typedef unsigned char   jboolean;
typedef unsigned short  jchar;
typedef short           jshort;
typedef float           jfloat;
typedef double          jdouble;
```

```cpp
#include "jni.h"

jboolean ToJBool(bool value) {
	return value ? JNI_TRUE : JNI_FALSE;
}

bool ToCppBool(jboolean value) {
	return value == JNI_TRUE;
}
```

## jstring 

### jstring to string

```cpp
// https://stackoverflow.com/questions/41820039/jstringjni-to-stdstringc-with-utf8-characters
std::string jstring2string(JNIEnv *env, jstring jStr) {
    if (!jStr)
        return "";

    const jclass stringClass = env->GetObjectClass(jStr);
    const jmethodID getBytes = env->GetMethodID(stringClass, "getBytes", "(Ljava/lang/String;)[B");
    const jbyteArray stringJbytes = (jbyteArray) env->CallObjectMethod(jStr, getBytes, env->NewStringUTF("UTF-8"));

    size_t length = (size_t) env->GetArrayLength(stringJbytes);
    jbyte* pBytes = env->GetByteArrayElements(stringJbytes, NULL);

    std::string ret = std::string((char *)pBytes, length);
    env->ReleaseByteArrayElements(stringJbytes, pBytes, JNI_ABORT);

    env->DeleteLocalRef(stringJbytes);
    env->DeleteLocalRef(stringClass);
    return ret;
}
```

### string to jstring

```cpp
jstring string2jstring(JNIEnv* env, const std::string& value) {
  return env->NewStringUTF(value.c_str());
}
```


## 参考

- jstring to string
- https://stackoverflow.com/questions/41820039/jstringjni-to-stdstringc-with-utf8-characters
- jstring, jbool
- https://blog.csdn.net/u014300915/article/details/52916086
- jint to int/uint16_t
- https://stackoverflow.com/questions/8012450/jni-converting-unsigned-int-to-jint




