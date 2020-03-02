package com.yao.springboottest.java8.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @className Demo04
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/26 17:46
 */
public class Demo04 {
    public static void main(String[] args) {
        Object o = new Object();
        Map<Object,String> map = new HashMap<>();
        map.put(o,"aa");
        String s = map.get(o);
        System.out.println(s);
    }
}
