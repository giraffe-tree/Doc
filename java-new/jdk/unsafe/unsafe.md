# Unsafe

## 1. 非系统类库获取 Unsafe

使用 ```Unsafe.getUnsafe()``` 会有 `java.lang.SecurityException: Unsafe` 异常, 原因是非系统类库不能获取 `Unsafe` 对象

```java
Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
// 设置field 权限, 否则会抛出 IllegalAccessException
theUnsafeField.setAccessible(true);
UNSAFE = (Unsafe) theUnsafeField.get(null);
```



