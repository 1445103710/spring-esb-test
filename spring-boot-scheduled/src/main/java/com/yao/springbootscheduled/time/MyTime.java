package com.yao.springbootscheduled.time;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @className MyTime
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/29 18:35
 */
public class MyTime {
    public static void main(String[] args) {
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("task1运行："+ LocalTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("task2运行："+ LocalTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        Timer timer2 = new Timer();
        timer.schedule(task1,0,1000);
        timer2.schedule(task2,0,1000);
    }
}
