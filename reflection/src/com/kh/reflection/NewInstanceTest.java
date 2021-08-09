package com.kh.reflection;

import org.junit.Test;

/**
 * @author wkh
 * @create 2021-08-06 21:56
 */
public class NewInstanceTest {
    // 通过
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;
        /*
        newInstance():调用此方法，创建运行时类的对象
         */
        Person p1 = clazz.newInstance();

        System.out.println(p1);


    }
}
