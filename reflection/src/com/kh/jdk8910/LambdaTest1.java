package com.kh.jdk8910;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author wkh
 * @create 2021-08-09 14:13
 */
public class LambdaTest1 {

    /*
    1.举例：        （o1,o2） -> Integer.compare(o1,o2);
    2.格式：
            -> : lambda操作符 或箭头操作符
            左边： lambda形参列表（其实就是接口中的抽象方法的形参列表）
            右边： lambda体 （其实就是重写的抽象方法的方法体）


     3.lambda表达式的使用：六种形式

            总结：
            》左边：lambda形参列表类型可以省略；
            》右边：lambda体应该使用{}包裹；

     4.lambda表达式的本质：作为接口的实例（作为函数式接口的实例）

     5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口，可以用注解去标识
     */


    // 一：无参，无返回值
    @Test
    public void test1(){

        // 提供Runnable接口匿名实现类的对象；接口内部的这个run()方法是抽象方法，在接口内部是不能写方法体的，但是我们这里
        // 写了run()方法的方法体，说明我们的这个内部类不是接口Runnable, 而是一个实现了Runnable接口的实现类，
        // 但是又用多态的方式来表示这个实现类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111111");
            }
        };

        r1.run();

        Runnable r2 = () -> System.out.println("22222222222222222");
        r2.run();
    }

    @Test
    public void test2(){
        // 二：Lambda需要一个参数，但没有返回值
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("consumer");
        System.out.println("***********************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
            System.out.println("123121");
        };
        con1.accept("hahahaha");
    }

    // 三： 数据类型可以省略，因为可以由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
            System.out.println("123121");
        };
        con1.accept("hahahaha");
    }

    // 四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){

        Consumer<String> con1 = s -> {
            System.out.println(s);
            System.out.println("123121");
        };
        con1.accept("hahahaha");

    }

    // 五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        // Lambda
        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);

        };
        int compare = comparator1.compare(32, 21);
        System.out.println(compare);
    }


}
