package com.yao.springboottest.java8.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @className Demo01
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/23 19:52
 */
public class Demo01 {
    List list = new ArrayList();
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo01.add(i);
                System.out.println("add:"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"yaoyao1").start();
        new Thread(()->{
            while (true){
                if (demo01.getSize()==5){
                    System.out.println("获取到了");
                    break;
                }
            }
            System.out.println("线程2结束");
        },"yaoyao2").start();
    }

    public void add(Object s){
        list.add(s);
    }
    public int getSize(){
        return list.size();
    }
}
