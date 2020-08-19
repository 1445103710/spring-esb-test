package com.yao.springboottest.hashCode;

import com.google.common.hash.HashCode;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/19 10:52
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(HashCode.fromInt(i));
        }
    }
}
