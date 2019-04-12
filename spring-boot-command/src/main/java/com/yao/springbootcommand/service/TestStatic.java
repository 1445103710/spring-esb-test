package com.yao.springbootcommand.service;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/11 12:31
 * @Description:
 * @see com.yao.springbootcommand.service
 */
public class TestStatic {
    static {
        System.out.println("初始化静态");
        age = 2;
    }
    public static int age = 0;
    public TestStatic(){
        System.out.println("初始化类");
    }
    public static void main(String[] args) {
        TestStatic testStatic = new TestStatic();
        TestStatic testStatic1 = new TestStatic();
        System.out.println(TestStatic.age);
    }
}
