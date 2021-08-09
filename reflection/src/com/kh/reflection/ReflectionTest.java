package com.kh.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author wkh
 * @create 2021-08-06 18:18
 */
public class ReflectionTest {

    // 反射之前：对person类的操作
    @Test
    public void test1(){
        // 1.
        Person p1 = new Person("tom",12);

        // 2.
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在person类外部，不可以通过person对象调用其内部的私有结构
        // 比如：name; showNation() 方法 及私有构造器
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;   // Class是反射的源头
        // 1.通过反射创建person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("tom", 12);  // 一个多态的形式

//        Constructor cons = clazz.getConstructor();
//        Object obj = cons.newInstance();


        Person p = (Person) obj;
        System.out.println(p.toString());

        // 2.通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        // 调用方法   F2 查看具体方法    泛化
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(p);
        System.out.println("**********************");
        // 通过反射：可以调用私有结构
        // 调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object o1 = cons1.newInstance("jack");
        Person p1 = (Person) o1;
        System.out.println(p1);
        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"kangkang");
        System.out.println(p1);
        // 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"China");  // 相当于p1.showNation("China")
        System.out.println(nation);

    }
    // 什么时候用？反射方式  反射的特性：动态性
    // 疑问？  通过直接new的方式或反射方式都可以调用公共结构，开发中用哪个？  建议 new
    // 疑问？  反射机制与面向对象中的封装性是否矛盾？  如何看待两个技术
    // 不矛盾。

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件（ .class结尾）。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
     */
    @Test
    public void test3() throws ClassNotFoundException {
     // 获取Class的实例的方式；
     // 一；调用运行时类的属性:".class"
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 二：通过运行时类的对象,调用getClass()方法
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.kh.reflection.Person");
    //    clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }

    @Test
    public void test4() throws IOException {

        Properties pros = new Properties();
        // 此时文件在当前module下
        // 读取配置文件的方式一：
        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
        pros.load(fis);

        // 读取配置文件的方式二：使用ClassLoader
        // 配置文件默认识别为：当前module的src下
//        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
//        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println(user+"---"+password);
    }




}
