package com.kh.reflection2;

import com.kh.reflection1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wkh
 * @create 2021-08-07 19:37
 */
public class OtherTesst {

    /*
    获取构造器结构
     */

    @Test
    public void test1(){

        Class clazz = Person.class;

        //
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println();
        // 当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    @Test
    public void test2(){
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    @Test
    public void test3(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();

        System.out.println(genericSuperclass);
    }

    /*
    代码：  逻辑性代码  vs 功能性代码
     */

    @Test
    public void test4(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();

        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        // 获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        System.out.println(((Class)actualTypeArguments[0]).getTypeName());
    }

    @Test
    public void test5(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();

        for (Class c :
                interfaces) {
            System.out.println(c);
        }

        System.out.println();

        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c :
                interfaces1) {
            System.out.println(c);
        }
    }

    @Test
    public void test6(){
        Class clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    // 获取运行时类声明的注解
    @Test
    public void test7(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
        }
    }

}
