package com.TreeSet.comparable;

/**
 * @author wkh
 * @create 2021-07-11 21:30
 */
public class Employee implements Comparable{
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myDate=" + myDate +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee employee = (Employee)o;
            return -this.name.compareTo(employee.name);
        }else {
            throw new RuntimeException("输入类型不匹配");
        }

    }
}
