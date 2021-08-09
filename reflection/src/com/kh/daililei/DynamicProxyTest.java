package com.kh.daililei;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wkh
 * @create 2021-08-08 22:03
 *
 * 动态代理：
 */

interface Human{

    String getBelief();

    void eat(String food);

}

class HumanUtil{
    public void m1(){
        System.out.println("11111111111111111");
    }
    public void m2(){
        System.out.println("22222222222222222");
    }
}



// 被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        System.out.println("拯救世界！");
        return "拯救世界！";
    }

    @Override
    public void eat(String food) {
        System.out.println("superman----eat  "+food);
    }
}

/*
要实现动态代理，要解决的问题？
一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
二：当通过代理类的对象调用方法a时，如何动态的调用被代理类中的同名方法a。
 */
class ProxyFactory{
    // 调用此方法，返回一个代理类的对象，解决一。
    public static Object getProxyInstance(Object obj){  // obj:被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        // obj.getClass().getInterfaces(): 看一下被代理类实现了什么接口，然后造一个类并实现同样的接口，相当于
        // 造这个类和被代理类是同级关系
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}


class MyInvocationHandler implements InvocationHandler {


    private Object obj; // 赋值时，需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    // 将被代理类要执行的方法a 功能就声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.m1();

        // method:即为代理类对象调用的方法，此 方法也就作为了被代理类对象要调用的方法
        // obj:被代理类的对象
        // 利用反射调用的，此处的方法是不确定的
        Object returnValue = method.invoke(obj, args);

        util.m2();

        //上述方法的返回值就作为当前类中invoke()方法的返回值。
        return returnValue;
    }
}

public class DynamicProxyTest {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        // proxyInstance：是代理类对象，此时为多态形式的赋值
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        // 当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("棒棒糖");


        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyCloth = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyCloth.produceCloth();

    }

}
