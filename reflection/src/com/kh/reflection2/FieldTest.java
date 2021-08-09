package com.kh.reflection2;

import com.kh.reflection1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author wkh
 * @create 2021-08-07 18:25
 *
 * 获取运行时类的属性结构
 */
public class FieldTest {

    @Test
    public void test1(){
        Class clazz = Person.class;

        // 获取属性结构
        // getFields() ： 可获取当前运行时类public权限的属性
        Field[] fields = clazz.getFields();

        for (Field f : fields){
            System.out.println(f);
        }

        System.out.println("_------------");
        // getDeclaredFields(): 可获取当前运行时类所有权限的属性（不包含父类的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }

    // 权限修饰符  数据类型 变量名 = 。。。
    @Test
    public void test2(){
        Class clazz = Person.class;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field f : declaredFields){

            // 1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            // 2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            // 3.变量名
            String fName = f.getName();
            System.out.println(fName + "\t");
        }
    }
}
