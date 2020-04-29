package com.yao.springbootscheduled.thread;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @className Demo
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/16 17:28
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        Callable<String> callable = () -> {
            System.out.println("开始异步处理");
            Thread.sleep(5000);
            System.out.println("结束异步处理");
            return "我搞定了";
        };

        FutureTask<String> future = new FutureTask<String>(callable);
        new Thread(future).start();
        System.out.println("干其他事情");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("干完成其他事情");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("全部都干完了");
        System.out.println(LocalTime.now());
    }
}
