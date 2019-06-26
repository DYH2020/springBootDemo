package com.test.demo.designPatterns.singleton;

import java.io.Serializable;

/**
 * 序列化下的单例模式，一定要实现readResolve方法，不然就会有问题
 *
 */
public class SerializableSingleton implements Serializable {
    // 使用volatile关键字保其可见性, 通过 Volatile 避免指令重排序
    //指令重排参考文章：https://www.infoq.cn/article/double-checked-locking-with-delay-initialization/
    private volatile static SerializableSingleton singleton = null;

    private SerializableSingleton(){
        System.out.println("hello SerializableSingleton ~");
    }

    public static SerializableSingleton getInstance(){
        if (singleton == null){
            synchronized (SerializableSingleton.class){
                if (singleton == null){
                    singleton = new SerializableSingleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve(){
        return singleton;
    }

}
