# C++ 

## 简介

C++ 是 C 的一个超集，事实上，任何合法的 C 程序都是合法的 C++ 程序。

参考:

- https://www.runoob.com/cplusplus

### 标准的 C++ 由三个重要部分组成：

核心语言，提供了所有构件块，包括变量、数据类型和常量，等等。
C++ 标准库，提供了大量的函数，用于操作文件、字符串等。
标准模板库（STL），提供了大量的方法，用于操作数据结构等。

## 编译器

g++

> 程序 g++ 是将 gcc 默认语言设为 C++ 的一个特殊的版本，链接时它自动使用 C++ 标准库而不用 C 标准库。通过遵循源码的命名规范并指定对应库的名字，用 gcc 来编译链接 C++ 程序是可行的，如下例所示： `gcc main.cpp -lstdc++ -o main`

```sh
g++ helloworld.cpp
g++ helloworld.cpp -o helloworld
g++ -g -Wall -std=c++11 main.cpp
g++ -g -Wall -std=c++14 main.cpp -o main
```

### g++ 常用命令选项

```
-ansi	只支持 ANSI 标准的 C 语法。这一选项将禁止 GNU C 的某些特色， 例如 asm 或 typeof 关键词。
-c	只编译并生成目标文件。
-DMACRO	以字符串"1"定义 MACRO 宏。
-DMACRO=DEFN	以字符串"DEFN"定义 MACRO 宏。
-E	只运行 C 预编译器。
-g	生成调试信息。GNU 调试器可利用该信息。
-IDIRECTORY	指定额外的头文件搜索路径DIRECTORY。
-LDIRECTORY	指定额外的函数库搜索路径DIRECTORY。
-lLIBRARY	连接时搜索指定的函数库LIBRARY。
-m486	针对 486 进行代码优化。
-o	FILE 生成指定的输出文件。用在生成可执行文件时。
-O0	不进行优化处理。
-O	或 -O1 优化生成代码。
-O2	进一步优化。
-O3	比 -O2 更进一步优化，包括 inline 函数。
-shared	生成共享目标文件。通常用在建立共享库时。
-static	禁止使用共享连接。
-UMACRO	取消对 MACRO 宏的定义。
-w	不生成任何警告信息。
-Wall	生成所有警告信息。
```

## C++ 基本语法

### 关键字


![](https://www.runoob.com/wp-content/uploads/2018/06/20130806104900234.jpg)

与java不一样的有:

- asm
- auto
- const
- const_cast 
	- 常量指针被转化成非常量指针，并且仍然指向原来的对象；常量引用被转换成非常量引用，并且仍然指向原来的对象；常量对象被转换成非常量对象。
- delete
	- delete（删除）释放程序动态申请的内存空间。delete 后面通常是一个指针或者数组 []，并且只能 delete 通过 new 关键字申请的指针，否则会发生段错误。
- dynamic_cast
	- 允许在运行时刻进行类型转换
	- 把基类指针转换成派生类指针，或者把指向基类的左值转换成派生类的引用。
- explicit 显式的
	- explicit关键字用来修饰类的构造函数，被修饰的构造函数的类，不能发生相应的隐式类型转换，只能以显示的方式进行类型转换。
	- 作用于单个参数的构造函数。
- export
	- 为了访问其他编译单元（如另一代码文件）中的变量或对象，对普通类型（包括基本数据类、结构和类），可以利用关键字 extern，来使用这些变量或对象时；但是对模板类型，则必须在定义这些模板类对象和模板函数时，使用标准 C++ 新增加的关键字 export（导出）。
- extern
	- 第一个,当它与"C"一起连用时，如: extern "C" void fun(int a, int b);则告诉编译器在编译fun这个函数名时按着C的规则去翻译相应的函数名而不是C++的
	- 第二，当extern不与"C"在一起修饰变量或函数时，如在头文件中: extern int g_Int; 它的作用就是声明函数或全局变量的作用范围的关键字，其声明的函数和变量可以在本模块活其他模块中使用，记住它是一个声明不是定义!也就是说B模块(编译单元)要是引用模块(编译单元)A中定义的全局变量或函数时，它只要包含A模块的头文件即可,在编译阶段，模块B虽然找不到该函数或变量，但它不会报错，它会在连接时从模块A生成的目标代码中找到此函数。
	- https://www.cnblogs.com/yuxingli/p/7821102.html
- inline
	- 内联
- mutable
	- mutable 是用来修饰一个 const 示例的部分可变的数据成员的。如果要说得更清晰一点，就是说 mutable 的出现，将 C++ 中的 const 的概念分成了两种。
	- https://liam.page/2017/05/25/the-mutable-keyword-in-Cxx/
- namespace
	- 用于在逻辑上组织类，是一种比类大的结构。
- operator
	- 操作符重载
- register
	- register（寄存器）声明的变量称着寄存器变量
- reinterpret_cast
	- 可以把一个指针转换成一个整数，也可以把一个整数转换成一个指针（
- signed/unsigned
	- 有/无符号数
- sizeof
	- 由于 C++ 每种类型的大小都是由编译器自行决定的，为了增加可移植性，可以用 sizeof 运算符获得该数据类型占用的字节数。
	- 是返回一个对象或类型所占的内存字节数。
- static_cast
- struct
	- struct（结构）类型，类似于 class 关键字，与 C 语言兼容（class 关键字是不与 C 语言兼容的），可以实现面向对象程序设计。
- template（模板）
	- C++ 中泛型机制的实现。
- this
	- this 返回调用者本身的指针。
- typedef  类型 定义名;
	- 定义了一个数据类型的新名字而不是定义一种新的数据类型。定义名表示这个类型的新名字。
- typeid 操作符
	-  typeid(变量).name()
	- 和 RTTI（Run-Time Type Identification)-运行时类型识别
- typename
	- 当用于泛型编程时是另一术语"class"的同义词。
	- https://zh.wikipedia.org/wiki/Typename
	- http://feihu.me/blog/2014/the-origin-and-usage-of-typename/
- union
	- union 可以用于所有类型，并且其占用空间是随着实际类型大小变化的。
- using
	- 表明使用 namespace。
- virtual
	- C++ 中用来实现多态机制。
- volatile
	- 和 java 中含义不同
- wchar_t
	- wchar_t 是宽字符类型，每个 wchar_t 类型占 2 个字节，16 位宽。

## 注释

```C++
/* 这是注释 */
 
/* C++ 注释也可以
 * 跨行
 */
```

## C++ 数据类型

### 7种数据类型

七种基本的 C++ 数据类型：

> 布尔型	bool	1
> 字符型	char	1
> 整型	int 	4
> 浮点型	float	4	1位符号，8位指数，23位小数。
> 双浮点型	double		8	1位符号，11位指数，52位小数。
> 无类型	void
> 宽字符型	wchar_t		2/4字节

### 类型修饰符

signed
unsigned
short
long

### 组合

![](https://open-chen.oss-cn-hangzhou.aliyuncs.com/open/2019/12/C%2B%2B_data_type.jpg)

### enum


```c++
#include <iostream>

using namespace std;

enum Color { green , yellow=5 , red};

int main() {

    Color c = red;
    cout << c << endl;
    // out: 2
    return 0;
}
```

## 变量类型

### 定义

```C++
int    i, j, k;
char   c, ch;
float  f, salary;
double d;
cout << i << endl;
// out: 0
```

### 函数声明

```C++
// 函数声明
int func();
 
int main()
{
    // 函数调用
    int i = func();
}
 
// 函数定义
int func()
{
    return 0;
}
```

## C++ 变量作用域

## C++ 常量

常量是固定值，在程序执行期间不会改变。这些固定的值，又叫做字面量。常量就像是常规的变量，只不过常量的值在定义后不能进行修改。

整数常量可以是十进制、八进制或十六进制的常量。前缀指定基数：0x 或 0X 表示十六进制，0 表示八进制，不带前缀则默认表示十进制。

整数常量也可以带一个后缀，后缀是 U 和 L 的组合，U 表示无符号整数（unsigned），L 表示长整数（long）。后缀可以是大写，也可以是小写，U 和 L 的顺序任意。

```C++
85         // 十进制
0213       // 八进制 
0x4b       // 十六进制 
30         // 整数 
30u        // 无符号整数 
30l        // 长整数 
30ul       // 无符号长整数

3.14159       // 合法的 
314159E-5L    // 合法的 

```

### 定义常量

在 C++ 中，有两种简单的定义常量的方式：

- 使用 #define 预处理器。
	- `#define identifier value`
- 使用 const 关键字。

## C++ 修饰符类型

### C++ 中的类型限定符

- const	
	- const 类型的对象在程序执行期间不能被修改改变。
- volatile	
	- 修饰符 volatile 告诉编译器不需要优化volatile声明的变量，让程序可以直接从内存中读取变量。对于一般的变量编译器会对变量进行优化，将内存中的变量值放在寄存器中以加快读写效率。

## C++ 存储类

定义 C++ 程序中变量/函数的范围（可见性）和生命周期。这些说明符放置在它们所修饰的类型之前。

从 C++ 17 开始，auto 关键字不再是 C++ 存储类说明符，且 register 关键字被弃用。


### static

static 存储类指示编译器在程序的生命周期内保持局部变量的存在，而不需要在每次它进入和离开作用域时进行创建和销毁。因此，使用 static 修饰局部变量可以在函数调用之间保持局部变量的值。

```C++
#include <iostream>
 
// 函数声明 
void func(void);
static int count = 10; /* 全局变量 */
int main()
{
    while(count--)
    {
       func();
    }
    return 0;
}
// 函数定义
void func( void )
{
    static int i = 5; // 局部静态变量
    i++;
    std::cout << "变量 i 为 " << i ;
    std::cout << " , 变量 count 为 " << count << std::endl;
}
```

### extern

extern 存储类用于提供一个全局变量的引用

extern 是用来在另一个文件中声明一个全局变量或函数, extern 修饰符通常用于当有两个或多个文件共享相同的全局变量或函数的时候

- https://www.runoob.com/cplusplus/cpp-storage-classes.html


### mutable 存储类

mutable 说明符仅适用于类的对象

### thread_local

使用 thread_local 说明符声明的变量仅可在它在其上创建的线程上访问。

```
static thread_local std::string s;
```

## 运算符

- 逗号运算符
	- 会顺序执行一系列运算。整个逗号表达式的值是以逗号分隔的列表中的最后一个表达式的值。
- 指针运算符 `&` 
	- 返回变量的地址。例如 &a; 将给出变量的实际地址。
- 指针运算符 `*`
	- 指向一个变量。例如，`*var;` 将指向变量 `var`。

## 循环

- while
- for 
- do ...while

```C++
int my_array[5] = {1, 2, 3, 4, 5};
// 每个数组元素乘于 2
for (int &x : my_array)
{
    x *= 2;
    cout << x << endl;  
}
// auto 类型也是 C++11 新标准中的，用来自动获取变量的类型
for (auto &x : my_array) {
    x *= 2;
    cout << x << endl;  
}
```

## 判断

- if else
- switch
- ?

## 函数

记得要先进行函数声明

```
return_type function_name( parameter list )
{
   body of the function
}
```

### 传参方式

当调用函数时，有三种向函数传递参数的方式：

- 传值调用 默认调用方式
- 指针调用
- 引用调用

### 默认值

```C++
int sum(int a, int b=20)
{
  int result;
 
  result = a + b;
  
  return (result);
}
```

### Lambda 函数与表达式

Lambda 表达式把函数看作对象。Lambda 表达式可以像对象一样使用，比如可以将它们赋给变量和作为参数传递，还可以像函数一样对其求值。

格式如下

```
// 有返回值
[capture](parameters)->return-type{body}

// 没有返回值
[capture](parameters){body}
```

举例

```C++
// 指明返回类型
auto add = [](int a, int b) -> int { return a + b; };
// 自动推断返回类型
auto multiply = [](int a, int b) { return a * b; };

int sum = add(2, 5);   // 输出：7
int product = multiply(2, 5);  // 输出：10

```

#### 方括号的含义


参考来源: [C++ lambda表达式与函数对象](https://www.jianshu.com/p/d686ad9de817)

> 大家可能会想lambda表达式最前面的方括号的意义何在？其实这是lambda表达式一个很要的功能，就是闭包。这里我们先讲一下lambda表达式的大致原理：每当你定义一个lambda表达式后，编译器会自动生成一个匿名类（这个类当然重载了()运算符），我们称为闭包类型（closure type）。那么在运行时，这个lambda表达式就会返回一个匿名的闭包实例，其实一个右值。所以，我们上面的lambda表达式的结果就是一个个闭包。闭包的一个强大之处是其可以通过传值或者引用的方式捕捉其封装作用域内的变量，前面的方括号就是用来定义捕捉模式以及变量，我们又将其称为lambda捕捉块。看下面的例子：

- https://stackoverflow.com/questions/15559658/c11-lambdas-and-the-square-brackets
- https://stackoverflow.com/questions/7627098/what-is-a-lambda-expression-in-c11

> 方括号指定lambda“捕获”了哪些变量，以及如何捕获（通过值或引用）。
> 捕获意味着您可以从lambda内部引用lambda外的变量。如果按值捕获，则将在创建lambda时获取变量的值-类似于按值将参数传递给函数。如果通过引用捕获，则将在lambda之外引用实际变量（并且需要确保它仍在范围内）。
> 请注意，在类内部可以捕获“ this”，然后像在类方法中一样调用类方法

```
[&epsilon] capture by reference
[&] captures all variables used in the lambda by reference
[=] captures all variables used in the lambda by value
[&, epsilon] captures variables like with [&], but epsilon by value
[=, &epsilon] captures variables like with [=], but epsilon by reference

[]      // 沒有定义任何变量。使用未定义变量会引发错误。
[x, &y] // x以传值方式传入（默认），y以引用方式传入。
[&]     // 任何被使用到的外部变量都隐式地以引用方式加以引用。
[=]     // 任何被使用到的外部变量都隐式地以传值方式加以引用。
[&, x]  // x显式地以传值方式加以引用。其余变量以引用方式加以引用。
[=, &z] // z显式地以引用方式加以引用。其余变量以传值方式加以引用。
[this]  // 通过引用捕获当前对象（其实是复制指针）；
[*this] // 通过传值方式捕获当前对象；
```

对于[=]或[&]的形式，lambda 表达式可以直接使用 this 指针。但是，对于[]的形式，如果要使用 this 指针，必须显式传入：


```C++
[this]() { this->someFunc(); }();
```

capture 示例

```C++
void testLambdaCapture() {
    int x = 10;

    auto add_x = [x](int a) { return a + x; };  // 复制捕捉x
    auto multiply_x = [&x](int a) { return a * x; };  // 引用捕捉x

    cout << add_x(10) << " " << multiply_x(10) << endl;
    // out：20 100

    x = 20;
    cout << add_x(5) << " "<< multiply_x(4) << endl;
    // out: 15 80
}
```


#### 使用 lambda 过滤 list 中的元素

- https://www.jianshu.com/p/d686ad9de817

> todo: 待完成 vector

## 定义数字

### cmath

使用 cmath 库

```c++
#include <cmath>
void testCmath() {
    double x = sin(30 * PI / 180);
    cout << x << endl;
    // out: 0.5
    double result = sqrt(4);
    cout << result << endl;
    // out: 2

}
```

### 随机数

```C++
#include <ctime>
#include <cstdlib>
void testRandom() {
    srand(time(NULL));
    cout << rand() << endl;

}
```

## C++ 数组

```C++
void testArray() {
//    double balance[5] = {1000.0, 2.0, 3.4, 7.0, 50.0};
    double balance[] = {1000.0, 2.0, 3.4, 7.0, 50.0};

    double salary = balance[3];
    for (int i = 0; i < 5; ++i) {
        cout << balance[i] << endl;
    }
}
```

## C++ 字符串

C++ 提供了以下两种类型的字符串表示形式：

- C 风格字符串
- C++ 引入的 string 类类型

### C string

```
#include <cstring>


序号	函数 & 目的
1	strcpy(s1, s2);
复制字符串 s2 到字符串 s1。
2	strcat(s1, s2);
连接字符串 s2 到字符串 s1 的末尾。
3	strlen(s1);
返回字符串 s1 的长度。
4	strcmp(s1, s2);
如果 s1 和 s2 是相同的，则返回 0；如果 s1<s2 则返回值小于 0；如果 s1>s2 则返回值大于 0。
5	strchr(s1, ch);
返回一个指针，指向字符串 s1 中字符 ch 的第一次出现的位置。
6	strstr(s1, s2);
返回一个指针，指向字符串 s1 中字符串 s2 的第一次出现的位置。
```

### C++ 中的 String 类

`#include <string>`

```C++
#include <string>
void testString() {
    string str1 = "Hello";
    string str2 = "World";
    string str3;
    int len;

    // 复制 str1 到 str3
    str3 = str1;
    cout << "str3 : " << str3 << endl;

    // 连接 str1 和 str2
    str3 = str1 + str2;
    cout << "str1 + str2 : " << str3 << endl;

    // 连接后，str3 的总长度
    len = str3.size();
    cout << "str3.size() :  " << len << endl;
    cout << str1.size() << endl;
}
```

## 指针

指针是一个变量，其值为另一个变量的地址，即，内存位置的直接地址。

指针变量声明的一般形式为：

```C++
type *var-name;
```

`&(取址运算符)和*(间接访问运算符/解引用指针)`

在这里，type 是指针的基类型，它必须是一个有效的 C++ 数据类型，var-name 是指针变量的名称。用来声明指针的星号 * 与乘法中使用的星号是相同的。但是，在这个语句中，星号是用来指定一个变量是指针。以下是有效的指针声明：

```
int    *ip;    /* 一个整型的指针 */
double *dp;    /* 一个 double 型的指针 */
float  *fp;    /* 一个浮点型的指针 */
char   *ch;    /* 一个字符型的指针 */
```

```C++
void testPoint() {

    int a = 123;
    int *p;
    p = &a;
    cout << p << endl; // 0xffffcbdc
    cout << *p << endl; // 123

    int *q = &a;
    cout << q << endl; // 0xffffcbdc
    cout << *q << endl; // 123

    p = NULL;
    cout << p << endl; // 0
}

```

### NULL 指针

```C++
define NULL 0
```

### C++ 指针的算术运算

在程序中**使用指针代替数组**，因为变量指针可以递增，而数组不能递增，因为数组是一个**常量指针**。


```C++
void testPointAdd() {
    int a[] = {123, 234, 344, 455, 523};
    // a 是常量指针, 可以使用下面的方法新建一个变量指针
//    int *p = a;
    int *p = &a[0];
    int i = 0;
    while (i < 5) {
        cout << *p << endl;
        p++;
        i++;
    }
}
```

##### 指针的比较

### C++ 指针 vs 数组

`int[] array = {1,2,3};`

可以通过数组的指针直接修改数组内的值 `*array=44`, 而不需要使用 `array[]`

```C++
#include <iostream>
 
using namespace std;
const int MAX = 3;
 
int main ()
{
   int  var[MAX] = {10, 100, 200};
 
   for (int i = 0; i < MAX; i++)
   {
      *var = i;    // 这是正确的语法
      var++;       // 这是不正确的
   }
   return 0;
}
```

### C++ 指针数组

```C++
const char *names[MAX] = {
        "Zara Ali",
        "Hina Ali",
        "Nuha Ali",
        "Sara Ali"
};

for (int i = 0; i < MAX; i++) {
    cout << "Value of names[" << i << "] = ";
    cout << names[i] << endl;
}
```

### 指向指针的指针（多级间接寻址）

```C++
int a = 123;
int *p = &a;
int **q = &p;
int ***w = &q;

cout << "a 的值" << endl;
cout << a << endl;
cout << *p << endl;
cout << **q << endl;
cout << ***w << endl;

cout << "a 的地址" << endl;
cout << &a << endl;
cout << p << endl;
cout << *q << endl;
cout << **w << endl;

cout << "p 的地址" << endl;
cout << &p << endl;
cout << q << endl;
cout << *w << endl;
```


### 传递指针给函数

```C++
void testPointParam(int *a, int *b, int bSize) {
    cout << *a << endl;
    for (int i = 0; i < bSize; ++i) {
        cout << b[i] << endl;
    }
}
int main(){
    int a = 23;
    int b[] = {1, 2, 3};
    testPointParam(&a, b, 3);

    return 0;
}

```

### 从函数返回指针

C++ 不支持在函数外返回局部变量的地址，除非定义局部变量为 static 变量。

```C++
int *testPointArrayReturn(){
    static int a = 132;
    return &a;
}
int main(){
    int *p = testPointArrayReturn();
    cout << *p << endl;


    return 0;
}

```







