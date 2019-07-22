package com.yao.springboottest.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MYThread extends Thread {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    public static void main(String[] args) {
        new MYThread().start();
        new MYThread().start();
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"时间："+simpleDateFormat.format(new Date()));
        }

    }
}
