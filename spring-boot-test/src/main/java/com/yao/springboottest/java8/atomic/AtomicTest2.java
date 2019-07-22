package com.yao.springboottest.java8.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicTest2 {

    private static final int THRED_COUNT = 20;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void create(){
        count.incrementAndGet();
        log.info("count:"+count);
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THRED_COUNT];
        for (int i = 0; i < THRED_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        create();
                    }
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount()>1){
//            Thread.yield();
//            log.info("走到这里了");
//        }

        System.out.println(count);
    }

}
