package com.yao.springboottest.java8.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * @className Test01
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/23 23:03
 */
public class Test01 {
    static L l = new L();
    public static void main(String[] args) {
        System.out.println("开始");
        System.out.println(Integer.toHexString(l.hashCode()));
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        String[] i = new String[]{"1","2","3"};
        System.out.println(ClassLayout.parseInstance(i).toPrintable());
    }
}
