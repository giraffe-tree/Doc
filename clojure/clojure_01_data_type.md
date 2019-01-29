# Clojure 基本数据类型

## 目标

1. 学习 clojure 的基本数据类型表示
2. clojure 的基本数据类型和 java 基本数据类型有什么关联

## 基本数据类型表示

下面给出了官网上对字面量中基本数据类型的一些例子. 

```clojure
;; Numeric types
42              ; Long - 64-bit integer (from -2^63 to 2^63-1)
6.022e23        ; Double - double-precision 64-bit floating point
42N             ; BigInt - arbitrary precision integer
1.0M            ; BigDecimal - arbitrary precision fixed-point decimal
22/7            ; Ratio

;; Character types
"hello"         ; String
\e              ; Character

;; Other types
nil             ; null value
true            ; Boolean (also, false)
#"[0-9]+"       ; Regular expression
:alpha          ; Keyword
:release/alpha  ; Keyword with namespace
map             ; Symbol
+               ; Symbol - most punctuation allowed
clojure.core/+  ; Namespaced symbol
```

## clojure 的基本数据类型和 java 有什么关联

## clojure 的基本数据类型和 java 中表示有什么不同

### 有理数

例如`11/7`

### 符号

`(def pi 22/7)`

### 关键字

以`:`开头, 使用`::`来创建命名空间限定关键字。

[关键字和符号 / 关键字的命名空间 ](https://codeday.me/bug/20170607/23321.html)





