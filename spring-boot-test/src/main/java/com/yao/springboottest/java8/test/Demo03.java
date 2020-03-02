package com.yao.springboottest.java8.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @className Demo01
 * @description: latch 门阀
 * @author: yaoyao
 * @create: 2020/02/23 19:52
 */
public class Demo03 {
    volatile List list = new ArrayList();

    public static void main(String[] args) {
        Demo03 demo01 = new Demo03();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("线程2启动");
            if (demo01.getSize() != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程2结束");
        }, "yaoyao2").start();

        new Thread(() -> {
            System.out.println("线程1开始");
            for (int i = 0; i < 10; i++) {
                demo01.add(i);
                System.out.println("add:" + i);
                if (demo01.getSize()==5){
                    countDownLatch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程1结束");
        }, "yaoyao1").start();
    }

    public void add(Object s) {
        list.add(s);
    }

    public int getSize() {
        return list.size();
    }
}
