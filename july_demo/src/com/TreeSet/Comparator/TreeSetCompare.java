package com.TreeSet.Comparator;

import com.TreeSet.comparable.Employee;
import com.TreeSet.comparable.MyDate;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author wkh
 * @create 2021-07-11 21:23
 */
public class TreeSetCompare {

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
                public int compare(Object o1, Object o2) {
                if (o1 instanceof com.TreeSet.Comparator.Employee && o2 instanceof com.TreeSet.Comparator.Employee){
                    com.TreeSet.Comparator.Employee emp1 = (com.TreeSet.Comparator.Employee)o1;
                    com.TreeSet.Comparator.Employee emp2 = (com.TreeSet.Comparator.Employee)o2;

                    MyDate b1 = emp1.getMyDate();
                    MyDate b2 = emp2.getMyDate();

                    int minusYear = b1.getYear() - b2.getYear();
                    if (minusYear!=0){
                        return minusYear;
                    }

                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if (minusMonth!=0){
                        return minusMonth;
                    }

                    return b1.getDay() - b2.getDay();

                }
                return 0;
            }
        });

        MyDate m1 = new MyDate(1998,9,10);
        MyDate m2 = new MyDate(1999,10,10);
        MyDate m3 = new MyDate(1997,1,14);
        MyDate m4 = new MyDate(1996,2,15);
        MyDate m5 = new MyDate(1995,3,17);


        com.TreeSet.Comparator.Employee e1 = new com.TreeSet.Comparator.Employee("zhang1",23,m1);
        com.TreeSet.Comparator.Employee e2 = new com.TreeSet.Comparator.Employee("zhang2",22,m2);
        com.TreeSet.Comparator.Employee e3 = new com.TreeSet.Comparator.Employee("zhang3",24,m3);
        com.TreeSet.Comparator.Employee e4 = new com.TreeSet.Comparator.Employee("zhang4",25,m4);
        com.TreeSet.Comparator.Employee e5 = new com.TreeSet.Comparator.Employee("zhang5",26,m5);





        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
