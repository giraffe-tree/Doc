# 编码规范

 
 
 1. 【强制】所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较。
说明：对于 Integer var = ? 在-128 至 127 范围内的赋值，Integer 对象是在
IntegerCache.cache 产生，会复用已有对象，这个区间内的 Integer 值可以直接使用==进行
判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，
推荐使用 equals 方法进行判断。


2. 【强制】Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用
equals。
正例："test".equals(object);
反例：object.equals("test");
说明：推荐使用 java.util.Objects#equals（JDK7 引入的工具类）

3. 【强制】关于 hashCode 和 equals 的处理，遵循如下规则：
1） 只要重写 equals，就必须重写 hashCode。
2） 因为 Set 存储的是不重复的对象，依据 hashCode 和 equals 进行判断，所以 Set 存储的
对象必须重写这两个方法。
3） 如果自定义对象做为 Map 的键，那么必须重写 hashCode 和 equals。
说明：String 重写了 hashCode 和 equals 方法，所以我们可以非常愉快地使用 String 对象
作为 key 来使用。


4. 【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全
一样的数组，大小就是 list.size()。
说明：使用 toArray 带参方法，入参分配的数组空间不够大时，toArray 方法内部将重新分配
内存空间，并返回新数组地址；如果数组元素大于实际所需，下标为[ list.size() ]的数组
元素将被置为 null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集合元素
个数一致。
正例：
List<String> list = new ArrayList<String>(2);
list.add("guan");
list.add("bao");
String[] array = new String[list.size()];
array = list.toArray(array); 

反例：直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它
类型数组将出现 ClassCastException 错误。

5. 【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList
体现的是适配器模式，只是转换接口，后台的数据仍是数组。
 String[] str = new String[] { "you", "wu" };
 List list = Arrays.asList(str);
第一种情况：list.add("yangguanbao"); 运行时异常。
第二种情况：str[0] = "gujin"; 那么 list.get(0)也会随之修改。


6. 【强制】泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方
法，而<? super T>不能使用 get 方法，做为接口调用赋值时易出错。
说明：扩展说一下 PECS(Producer Extends Consumer Super)原则：第一、频繁往外读取内
容的，适合用<? extends T>。第二、经常往里插入的，适合用<? super T>。


7. 【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
方式，如果并发操作，需要对 Iterator 对象加锁。
正例：
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
String item = iterator.next();
if (删除元素的条件) {
iterator.remove();
}
}
反例：
List<String> list = new ArrayList<String>();
list.add("1");
list.add("2");
for (String item : list) {
if ("1".equals(item)) {
list.remove(item);
}
}
说明：以上代码的执行结果肯定会出乎大家的意料，那么试一下把“1”换成“2”，会是同样的
结果吗？

换成 条件换成 remove 2 
 java.util.ConcurrentModificationException


8. 

















