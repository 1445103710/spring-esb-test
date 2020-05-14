package com.yao.springboottest.controller;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/09/10 10:12
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        long startTime = System.currentTimeMillis();
//        Thread.sleep(10000);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            public void run() {
//                System.out.println("auto clean temporary file");
//            }
//        }));
        String a= "23444444444\"444";
        System.out.println(a);
        String s = a.replaceAll("\"", "\\\\\"");
        System.out.println(a);
        System.out.println(s);
    }
}
