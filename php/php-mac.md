# php-mac

## 命令

sudo apachectl start/restart 

本地端口: 7890

sudo php -v

### 静态方法

```
class Test{
     public static $test = 1;
    public static function test(){
    }
}

```

可以不用实例化对象直接使用 Test::$test 来取得$test属性的值

静态方法调用也同理Test::test(); 直接调用静态方法test

```
class myGlobals {

   static $myVariable;

}

function a() {

  print myGlobals::$myVariable;

}
```


