package com.yao.springboottest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
//        String a= "23444444444\"444";
//        System.out.println(a);
//        String s = a.replaceAll("\"", "\\\\\"");
//        System.out.println(a);
//        System.out.println(s);


        List<TestPo> list = new ArrayList<TestPo>();

        for (int i = 0; i <3 ; i++) {
            TestPo testPo = new TestPo();
            testPo.setName("yy");
            testPo.setAge(i);
            list.add(testPo);
        }
        for (int i = 0; i <3 ; i++) {
            TestPo testPo = new TestPo();
            testPo.setName("tt");
            testPo.setAge(i);
            list.add(testPo);
        }
        System.out.println(list);
        Map<String, List<TestPo>> collect = list.stream().collect(Collectors.groupingBy(TestPo::getName));
        System.out.println(collect);
    }
}
