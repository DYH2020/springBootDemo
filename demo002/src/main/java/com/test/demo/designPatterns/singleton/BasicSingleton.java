package com.test.demo.designPatterns.singleton;

/**
 * 饿汉式，一进来就创建对象实例
 * 优点：最容易实现，也不会出现并发问题
 * 缺点：单例创建时机不可控，即类加载时 自动创建 单例
 */
public class BasicSingleton {

    private static BasicSingleton singleton = new BasicSingleton();

    /**
     * 私有构造函数，表示不能被外界实例化
     */
    private BasicSingleton() {
        System.out.println("hello BasicSingleton ~");
    }

    public static BasicSingleton getSingleton() {
        return singleton;
    }

}
