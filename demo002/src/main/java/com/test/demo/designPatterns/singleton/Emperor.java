package com.test.demo.designPatterns.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 有连接池的雏形
 */
public class Emperor {

    //定义最多能产生的实列数量
    private static int maxNum = 2;
    //每个皇帝都有名字，使用一个ArrayList来容纳，每个对象的私有属性
    private static List<String> nameList = new ArrayList<>();
    //定义一个列表，容纳所有皇帝的数量
    private static List<Emperor> emperorList = new ArrayList<>();
    //当前皇帝实例号
    private static int countNumOfEmperor = 0;
    // 产生所有的对象
    static {
        for (int i = 0; i<maxNum;i++ ){
            emperorList.add(new Emperor("皇"+(i+1)+"帝"));

        }
    }

    private Emperor(){
        //世俗和道德约束，就是为了不产生第二个皇帝
    }

    //传入皇帝名称，建立一个皇帝对象
    private Emperor(String name){
        nameList.add(name);
    }
    //随机获得一个皇帝对象
    public static Emperor getInstance(){
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNum);
        return emperorList.get(countNumOfEmperor);
    }

    //皇帝发话了
    public static void say(){
        System.out.println(nameList.get(countNumOfEmperor));
    }



}
