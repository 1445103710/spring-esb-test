package com.yao.springboottest.java8.atomic;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTestYao {

    public static void main(String[] args) {
        try {
            //runSaynTest();
            AsayTestc("name");
            System.out.println("end time");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSaynTest()throws Exception{
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("run end");
        });

        System.out.println("end time");
        completableFuture.get();
    }

    public static void AsayTestc(String name)throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("run end");
            return name+":yaoyao";
        });
        future.complete("122222");

        System.out.println("end time1");
        String s = future.get();
        System.out.println(s);

        System.out.println("end time2");
    }
}
