package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "/com.test.demo")//配置扫描的范围，如果不配置，那自动扫描同级以及同级下面的所有类
//@SpringBootApplication    //作用相当于上面的两个，可点击进去查看
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

}
