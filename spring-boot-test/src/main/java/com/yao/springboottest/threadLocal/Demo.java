package com.yao.springboottest.threadLocal;

/**
 * @className Demo
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/14 23:11
 */
public class Demo {
    static ThreadLocal<String> threadLocal = new ThreadLocal();
    static void print(String str){
        System.out.println(str+"..."+threadLocal.get());
        threadLocal.remove();
    }

    public static void main(String[] args) {
        new Thread(()->{
            threadLocal.set("aaa");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("thread1");
            System.out.println("11after remove : " + threadLocal.get());
        }).start();
        new Thread(()->{
            threadLocal.set("bbb");
            print("thread2");
            System.out.println("22after remove : " + threadLocal.get());
        }).start();
    }
}
