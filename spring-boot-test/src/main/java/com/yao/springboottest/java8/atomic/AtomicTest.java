package com.yao.springboottest.java8.atomic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AtomicTest {

    private static final int THRED_COUNT = 20;

//    private static int count = 0;

    private static int count = 0;
    public static void create(){
        count++;
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
