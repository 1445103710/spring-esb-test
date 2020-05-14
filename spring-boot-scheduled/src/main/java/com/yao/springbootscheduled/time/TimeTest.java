package com.yao.springbootscheduled.time;

import java.util.Timer;

/**
 * @className TimeTest
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/29 18:18
 */
public class TimeTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTask myTask = new MyTask();

        timer.scheduleAtFixedRate(myTask,10000L,1000L);
    }
}
