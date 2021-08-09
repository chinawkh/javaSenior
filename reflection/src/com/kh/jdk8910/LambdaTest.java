package com.kh.jdk8910;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author wkh
 * @create 2021-08-09 11:30
 */
public class LambdaTest {

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

        // Comparator是一个接口，也是造了一个匿名实现类的对象
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = comparator.compare(12, 21);
        System.out.println(compare1);
        // Lambda
        Comparator<Integer> comparator1 = (o1,o2) -> Integer.compare(o1,o2);
        int compare = comparator1.compare(32, 21);
        System.out.println(compare);

        // 方法引用
        Comparator<Integer> comparator2 = Integer::compare;
        int compare2 = comparator2.compare(21, 12);
        System.out.println(compare2);




    }
}
