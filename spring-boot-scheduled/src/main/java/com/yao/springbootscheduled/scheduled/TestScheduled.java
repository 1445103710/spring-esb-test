package com.yao.springbootscheduled.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @className TestScheduled
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/15 11:08
 */
@EnableScheduling
@Configuration
public class TestScheduled {
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    public void test1(){
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");
        System.err.println("执行静态定时任务开始时间: " + LocalDateTime.now());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("执行静态定时任务结束时间: " + LocalDateTime.now());
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");

    }

    //3.添加定时任务
//    @Scheduled(fixedRate = 5000)
    public void test2(){
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");
        System.err.println("执行静态定时任务开始时间: " + LocalDateTime.now());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("执行静态定时任务结束时间: " + LocalDateTime.now());
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");

    }
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    public void test3(){
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");
        System.err.println("执行静态定时任务开始时间: " + LocalDateTime.now());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("执行静态定时任务结束时间: " + LocalDateTime.now());
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");

    }
    //3.添加定时任务
//    @Scheduled(fixedRate = 5000)
    public void test4(){
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");
        System.err.println("执行静态定时任务开始时间: " + LocalDateTime.now());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("执行静态定时任务结束时间: " + LocalDateTime.now());
        System.out.println("######################"+Thread.currentThread().getName()+"##########################");

    }
    //3.添加定时任务
    @Scheduled(fixedRate = 5000)
    public void test5(){
        new Thread(()->{
            System.out.println("######################"+Thread.currentThread().getName()+"##########################");
            System.err.println("执行静态定时任务开始时间: " + LocalDateTime.now());
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("执行静态定时任务结束时间: " + LocalDateTime.now());
            System.out.println("######################"+Thread.currentThread().getName()+"##########################");

        }).start();
    }

}
