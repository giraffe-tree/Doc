参考：https://zhidao.baidu.com/question/100647673.html

jeval.jar

```
public class CalTest {
        public static void main(String[] args) throws Exception {
                Evaluator evl = new Evaluator();
                String exp= "2 + (7-5) * 3.14159 * #{x} + sin(#{y})";
                
                evl.putVariable("x", 5);  
		                evl.putVariable("y", 30);
		                
		                double result = Double.parseDouble(evl.evaluate(exp));
                System.out.println(result );
        }
}

```

Fel是轻量级的高效的表达式计算引擎

参考：http://blog.csdn.net/howareyoutodaysoft/article/details/9058285

下载：https://code.google.com/archive/p/fast-el/downloads

安全管理器




