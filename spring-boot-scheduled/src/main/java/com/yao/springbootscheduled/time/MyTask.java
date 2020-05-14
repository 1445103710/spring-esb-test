package com.yao.springbootscheduled.time;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * @className MyTask
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/29 18:18
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("我是一个timeTask");
        System.out.println(Thread.currentThread().getName()+":"+ LocalTime.now());
    }
}
