package com.yao.springboottest.design.single;

/**
 * @className Demo
 * @description: 双层检查单例
 * @author: yaoyao
 * @create: 2020/04/14 21:11
 */
public class Demo {
    private static volatile Demo instance;
    public static Demo getInstance(){
        if (instance==null){
            synchronized (Demo.class){
                if (instance==null){
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    instance = new Demo();
                }
            }
        }
        return instance;
    }

    private Demo(){
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Demo.getInstance().hashCode());
            }).start();
        }
    }
}
