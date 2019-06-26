package com.test.demo.designPatterns.singleton;

import com.test.demo.designPatterns.singleton.BasicSingleton;
import com.test.demo.designPatterns.singleton.Emperor;
import com.test.demo.designPatterns.singleton.LazyBasicSingleton;
import com.test.demo.designPatterns.singleton.SyncSingleton;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializableSingletonTest();
    }

    /**
     * 单例模式序列化测试
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void serializableSingletonTest() throws IOException, ClassNotFoundException {

        SerializableSingleton singleton = null;
        SerializableSingleton singleton_new = null;

        singleton = SerializableSingleton.getInstance();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(singleton);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        singleton_new = (SerializableSingleton) ois.readObject();

        System.out.println(singleton == singleton_new);
    }

    private void basicSingtonTest() {
        BasicSingleton singleton = BasicSingleton.getSingleton();
    }

    private void lazyBasicSingletonTest() {
        LazyBasicSingleton lazyBasicSingleton = LazyBasicSingleton.getInstance();

    }

    private static void threadSingletonTest() {
        for (int i = 0; i < 200; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(this.getName());
                    try {
                        long lo = new Double(Math.random() * 10).longValue();
                        Thread.sleep(lo);
                        // System.out.println(lo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SyncSingleton syncSingleton = SyncSingleton.getInstance();
                    BasicSingleton basicSingleton = BasicSingleton.getSingleton();

                }
            }.start();
        }
    }

    private static void EmperorTest() {
        int maxNum = 5;
        for (int i = 0; i < maxNum; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + (i + 1) + "个大臣参拜的是：");
            emperor.say();
        }
    }

}
