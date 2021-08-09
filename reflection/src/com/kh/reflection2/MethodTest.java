package com.kh.reflection2;

import com.kh.reflection1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author wkh
 * @create 2021-08-07 18:48
 * 获取运行时类的方法结构
 */
public class MethodTest {

    @Test
    public void test1(){
        Class clazz = Person.class;


        // getMethods():获取当前运行时类及其所有父类中权限声明为public方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("*********************************");

        //getDeclaredMethods()：获取当前运行时类中声明的所有方法（不包含父类方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    @Test
    public void test2(){
        /*
        @Xxxx
        权限修饰符  返回值类型  方法名（参数类型1 形参名，.......） throw  XxxException{}
         */

        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();


        for (Method m : declaredMethods) {
            // 1.获取方法（method）声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annos : annotations){
                System.out.print(annos + "\t");
            }

            // 2.权限修饰符
            int modifier = m.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            // 3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            // 4.方法名
            String name = m.getName();
            System.out.print(name);
            System.out.print("(");
            // 5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length ==0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == (parameterTypes.length -1)){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                    }else{
                        System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                    }

                }
            }

            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();

            if (exceptionTypes.length > 0){
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length -1){
                        System.out.print(exceptionTypes[i].getName());
                    }else {
                        System.out.print(exceptionTypes[i].getName() + ",");
                    }


                }
            }
            System.out.println();
        }
    }



}
