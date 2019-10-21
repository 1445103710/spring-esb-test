package com.yao.springboottest.controller;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/09/10 10:12
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(10);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }
}
