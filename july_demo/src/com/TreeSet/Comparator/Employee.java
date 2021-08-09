package com.TreeSet.Comparator;

import com.TreeSet.comparable.MyDate;

/**
 * @author wkh
 * @create 2021-07-11 21:30
 */
public class Employee{
    private String name;
    private int age;
    private MyDate myDate;

    public Employee() {
    }

    public Employee(String name, int age, MyDate myDate) {
        this.name = name;
        this.age = age;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myDate=" + myDate +
                '}';
    }
}
