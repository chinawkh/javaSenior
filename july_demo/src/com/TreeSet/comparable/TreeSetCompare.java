package com.TreeSet.comparable;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author wkh
 * @create 2021-07-11 21:23
 */
public class TreeSetCompare {

    public static void main(String[] args) {
        MyDate m1 = new MyDate(1998,9,10);
        MyDate m2 = new MyDate(1999,10,10);
        MyDate m3 = new MyDate(1997,1,14);
        MyDate m4 = new MyDate(1996,2,15);
        MyDate m5 = new MyDate(1995,3,17);


        Employee e2 = new Employee("zhang2",22,m2);
        Employee e1 = new Employee("zhang1",23,m1);
        Employee e5 = new Employee("zhang5",26,m5);
        Employee e4 = new Employee("zhang4",25,m4);
        Employee e3 = new Employee("zhang3",24,m3);

        TreeSet treeSet = new TreeSet();
        treeSet.add(e3);
        treeSet.add(e1);
        treeSet.add(e5);
        treeSet.add(e2);
        treeSet.add(e4);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
