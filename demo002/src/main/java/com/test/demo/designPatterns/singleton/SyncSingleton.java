package com.test.demo.designPatterns.singleton;

/**
 * 多线程下的单例模式(双重验证，也有可以直接在外面 getInstance 加 singleton的，但那样一进来就锁住，并不是很友好)
 *
 */
public class SyncSingleton {
    // 使用volatile关键字保其可见性, 通过 Volatile 避免指令重排序
    //指令重排参考文章：https://www.infoq.cn/article/double-checked-locking-with-delay-initialization/
    private volatile static SyncSingleton singleton = null;

    private static Object obj = new Object();

    private SyncSingleton(){
        System.out.println("hello SyncSingleton ~");
    }

    public static SyncSingleton getInstance(){
        if (singleton == null){
            synchronized (obj){
                if (singleton == null){
                    singleton = new SyncSingleton();
                }
            }
        }
        return singleton;
    }
}
