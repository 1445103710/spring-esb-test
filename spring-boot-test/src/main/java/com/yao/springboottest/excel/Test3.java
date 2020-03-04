package com.yao.springboottest.excel;

/**
 * @className Test3
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/04 14:53
 */
public class Test3 {
    public static void main(String[] args) {
        int c = 10;
        for (int i = 0; i <c ; i++) {
            System.out.println(i);

            if (i==5||i==7){
                i= 5-1;
                c= c-1;

            }
        }
    }
}
