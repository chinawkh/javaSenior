package com.kh.reflection2;

import com.kh.reflection1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wkh
 * @create 2021-08-08 16:32
 */
public class ReflectionTest {
    // 调用运行时类中指定的结构：属性、方法、构造器

    // 不推荐
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;

        // 创建运行时类的对象；
        Person p1 = (Person) clazz.newInstance();

        // 获取指定的属性(权限为public)
        // 通常不采用此方式
        Field id = clazz.getField("id");

        // 设置当前属性的值
        /*
           set(): 参数一：指明设置哪个对象   参数二：将此属性值设置为多少；
         */
        id.set(p1,1);

        /*
        get() ;  参数一：指明设置哪个对象
         */
        int pId = (int) id.get(p1);
        System.out.println(pId);
    }

    /*
    如何操作运行时类指定属性
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;

        // 创建运行时类的对象；
        Person p1 = (Person) clazz.newInstance();

        // 1.获取指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        // 2.设置可访问
        name.setAccessible(true);

        //3. 获取或设置指定对象的此属性值
        name.set(p1,"tom");
        String pName = (String) name.get(p1);
        System.out.println(pName);
    }

    @Test
    public void test3() throws Exception {

        Class clazz = Person.class;

        // 创建运行时类的对象；
        Person p1 = (Person) clazz.newInstance();

        //1.获取指定的某个方法
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.设置可访问
        show.setAccessible(true);

        // 3.调用invoke()   invoke()方法的返回值就是 show()方法的返回值，
        show.invoke(p1,"哈哈");

        System.out.println("如何调用静态方法");
        // 1.
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        // 2.
        showDesc.setAccessible(true);

        // 3.
        showDesc.invoke(Person.class);


    }

    @Test
    public void test4() throws Exception {

        Class clazz = Person.class;

        // 创建运行时类的对象；
//        Person p1 = (Person) clazz.newInstance();

        // 1.获取
        /*
        getDeclaredConstructor():
         */
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);


        // 2.设置可访问
        declaredConstructor.setAccessible(true);

        // 3.调用此构造器创建运行时类的对象
        Person person = (Person) declaredConstructor.newInstance("tom");
        System.out.println(person);

    }
}
