# Clojure Function

## 函数

### 创建函数

```clojure
;; 单个参数
(defn greet  [name]  (str "Hello, " name) )
;; 重载
(defn messenger
  ([]     (messenger "Hello world!"))
  ([msg]  (println msg)))
;; 可变参数函数
(defn hello [greeting & who]
  (println greeting who))

```



