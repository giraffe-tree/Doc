## 深入解析 Hello World


### 参考



```

Classfile /D:/2018/may/java/Hello.class
  Last modified 2018-5-16; size 631 bytes
  MD5 checksum abb85cbc3e14ef616c9ec9e7c7bde0a8
  Compiled from "Hello.java"
public class Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #12.#21        // java/lang/Object."<init>":()V
   #2 = Fieldref           #22.#23        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Class              #24            // java/lang/StringBuilder
   #4 = Methodref          #3.#21         // java/lang/StringBuilder."<init>":()V
   #5 = String             #25            // Hello
   #6 = Methodref          #3.#26         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #7 = Methodref          #3.#27         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   #8 = String             #28            // !
   #9 = Methodref          #3.#29         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #10 = Methodref          #30.#31        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #11 = Class              #32            // Hello
  #12 = Class              #33            // java/lang/Object
  #13 = Utf8               <init>
  #14 = Utf8               ()V
  #15 = Utf8               Code
  #16 = Utf8               LineNumberTable
  #17 = Utf8               main
  #18 = Utf8               ([Ljava/lang/String;)V
  #19 = Utf8               SourceFile
  #20 = Utf8               Hello.java
  #21 = NameAndType        #13:#14        // "<init>":()V
  #22 = Clalss              #34            // java/lang/System
  #23 = NameAndType        #35:#36        // out:Ljava/io/PrintStream;
  #24 = Utf8               java/lang/StringBuilder
  #25 = Utf8               Hello
  #26 = NameAndType        #37:#38        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #27 = NameAndType        #37:#39        // append:(I)Ljava/lang/StringBuilder;
  #28 = Utf8               !
  #29 = NameAndType        #40:#41        // toString:()Ljava/lang/String;
  #30 = Class              #42            // java/io/PrintStream
  #31 = NameAndType        #43:#44        // println:(Ljava/lang/String;)V
  #32 = Utf8               Hello
  #33 = Utf8               java/lang/Object
  #34 = Utf8               java/lang/System
  #35 = Utf8               out
  #36 = Utf8               Ljava/io/PrintStream;
  #37 = Utf8               append
  #38 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #39 = Utf8               (I)Ljava/lang/StringBuilder;
  #40 = Utf8               toString
  #41 = Utf8               ()Ljava/lang/String;
  #42 = Utf8               java/io/PrintStream
  #43 = Utf8               println
  #44 = Utf8               (Ljava/lang/String;)V
{
 public Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=2, args_size=1
         0: iconst_1
         1: istore_1
         2: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         5: new           #3                  // class java/lang/StringBuilder
         8: dup
         9: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
        12: ldc           #5                  // String Hello
        14: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        17: iload_1
        18: invokevirtual #7                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        21: ldc           #8                  // String !
        23: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        26: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        29: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        32: return
      LineNumberTable:
        line 3: 0
        line 4: 2
        line 5: 32
}
SourceFile: "Hello.java"

```


