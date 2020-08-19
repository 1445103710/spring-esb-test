package com.yao.springboottest.thread;

/**
 * @className ThreadGroupDemo
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/10 17:08
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("当前线程名称:" + Thread.currentThread().getName());
            System.out.println("当前线程组名称:" + Thread.currentThread().getThreadGroup().getName());
        });
        thread.start();
        System.out.println("main:"+Thread.currentThread().getName());
    }
}
