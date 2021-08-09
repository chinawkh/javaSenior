package com.kh.daililei;

/**
 * @author wkh
 * @create 2021-08-08 21:50
 *
 * 静态代理：代理类和被代理类在编译期间被确定下来
 */

interface ClothFactory{
    void produceCloth();
}



//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;  // 用被代理类对象进行实例化

    public ProxyClothFactory() {
    }

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做准备工作");
        // 被代理类对象 来做一些事情
        factory.produceCloth();

        System.out.println("代理工厂来做收尾");
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产衣服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }

}
