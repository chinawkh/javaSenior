package com.kh.reflection;

/**
 * @author wkh
 * @create 2021-08-06 18:18
 */
public class Person {
    private String name;
    public int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void show(){
        System.out.println("person");
    }

    private String showNation(String nation){
        System.out.println("国籍是"+nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
