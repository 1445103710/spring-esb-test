package com.yao.springboottest.java8.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className Test02
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/08 11:36
 */
public class Test02 {
    public static void main(String[] args) {
        int z = 50;

        for (int i = 0; i <100 ; i++) {
            if (z==i){
                continue;
            }
            System.out.println(i);
        }
        System.out.println("结束了");
    }
}
