package com.test.demo.designPatterns.singleton;

/**
 * 懒汉式，等需要用到的时候才实例化
 * 优点：等需要用到的时候才加载
 * 缺点：在并发的情况下，可能会生成多个
 */
public class LazyBasicSingleton {

    private static LazyBasicSingleton singleton;

    private LazyBasicSingleton(){
        System.out.println("hello LazyBasicSingleton ~");
    }

    public static LazyBasicSingleton getInstance(){
        if (singleton == null){
            singleton = new LazyBasicSingleton();
        }
        return singleton;
    }

}
