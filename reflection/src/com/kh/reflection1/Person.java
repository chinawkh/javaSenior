package com.kh.reflection1;

import java.nio.channels.Pipe;

/**
 * @author wkh
 * @create 2021-08-07 18:08
 */

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id ;

    public Person(){};
    @MyAnnotation(value = "121")
    private Person(String name){
        this.name = name;
    }
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("person国籍"+nation);
        return nation;
    }

    public String display(String interests,int age) throws NullPointerException,ClassNotFoundException{
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("person-----");
    }

    private static void showDesc(){
        System.out.println("staticm");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
