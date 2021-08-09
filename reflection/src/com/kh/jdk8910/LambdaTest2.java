package com.kh.jdk8910;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author wkh
 * @create 2021-08-09 18:02
 */
public class LambdaTest2 {

    /*
    java内置的四大核心函数式接口

    消费型接口  Consumer<T> void accept(T t)
    供给型接口  Supplier<T> T get()
    函数型接口  Function<T,R>  R apply(T t)
    断定型接口  Predicate<T>   boolean test(T t)
     */

    // 消费型接口  Consumer<T> void accept(T t)
    @Test
    public void test1(){

        // 参数一：500； 参数二：Consumer接口的匿名实现类
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("test1-->happy-->accept"+aDouble);
            }
        });

        System.out.println("***************");

        happyTime(400, (money) -> System.out.println("test1-->happy-->accept"+money));
    }

    public void happyTime(double money, Consumer<Double> con){
        // 所调用的accept()方法，为实现类中重写的方法
        con.accept(money);
    }


    // 断定型接口  Predicate<T>   boolean test(T t)
    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京","南京","东京","南昌");

        // 参数二：Predicate接口的实现类对象，并且该匿名实现类重写了test()方法
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        System.out.println("***************");
        // s -> s.contains("京"); 左边:参数，右边:重写方法的方法体
        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);

    }
    // 根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s :
                list) {
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }




}
