package io.wkh.test;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author wkh
 * @create 2021-07-28 21:23
 */
public class OtherStreamTest {

    @Test
    public void test1(){
        System.out.println(12312);

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (!("e".equals(str)) && !("exit".equals(str)) ) {
            str = sc.next();
        }

        System.exit(0);
    }

    @Test
    public void test2(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);

        sc.close();
    }

    public static void main(String[] args) throws IOException {
        // 方式一：
//        System.out.println(12312);
//
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        while (!("e".equals(str)) && !("exit".equals(str)) ) {
//            str = sc.next();
//        }
//
//        System.exit(0);
        // 方式二：
        // 1.使用转换流
        InputStreamReader isr = new InputStreamReader(System.in);
        // 2. 使用缓冲流去接受一下输入的数据
        BufferedReader br = new BufferedReader(isr);

        while (true){
            String str = br.readLine();
            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)){
                break;
            }

            String toUpperCase = str.toUpperCase();
            System.out.println(toUpperCase);
        }
        br.close();
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();

        list.add(12);
        list.add(113);
        list.add(21);
        list.add(new Person("tom",12));
        Person tom = new Person("tom", 12);


        // 此时会这样
        /**
         * tom.equals(obj);
         * 也即是使用传入的这个对象中重写的equals()方法去和集合的元素进行判断，直到找到相同的对象结束；
         * 比较次数为集合中此相同元素前面的元素个数加一；
         *
         */
        boolean contains = list.contains(tom);
        System.out.println(contains);

        System.out.println("*********************");
        list.remove((Integer) 21);
        list.remove(21);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }


    }



}
