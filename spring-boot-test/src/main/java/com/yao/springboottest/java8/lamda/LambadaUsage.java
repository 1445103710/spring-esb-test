package com.yao.springboottest.java8.lamda;

import sun.applet.AppletResourceLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambadaUsage {


    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple a : source) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> resource, LongPredicate longPredicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple a : resource) {
            if (longPredicate.test(a.getWeight())) {
                result.add(a);
            }
        }
        return result;

    }

    private static List<Apple> filterByBi(List<Apple> resource, BiPredicate<String, Long> biPredicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple a : resource) {
            if (biPredicate.test(a.getColor(), a.getWeight())) {
                result.add(a);
            }
        }
        return result;

    }

    private static void simpleTestConsumer(List<Apple> resource, Consumer<Apple> consumer) {

        List<Apple> result = new ArrayList<>();
        for (Apple a : resource) {
            consumer.accept(a);
        }
    }

    private static String testFunction(Apple apple,Function<Apple, String> fun) {
        return fun.apply(apple);
    }

    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    public static void main(String[] args) {

//        Runnable r1 = ()-> System.out.println("hello");
//
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello2");
//            }
//        };
//
//        process(r1);
//        process(r2);
//        process(()-> System.out.println("hello"));


        List<Apple> list = Arrays.asList(new Apple("green", 12L), new Apple("blue", 13L));

        List<Apple> green = filter(list, (apple) -> apple.getColor().equals("green"));
        System.out.println(green);
        System.out.println("-----------------------------");
        List<Apple> listweight = filterByWeight(list, (weight) -> weight >= 12);
        System.out.println(listweight);

        System.out.println("-----------------------------");
        List<Apple> listBi = filterByBi(list, (a, b) -> a.equals("green") && b >= 12);
        System.out.println(listBi);

        System.out.println("-----------------------------");
        simpleTestConsumer(list, apple -> System.out.println(apple));


        System.out.println("-----------------------------");
        String green1 = testFunction(new Apple("green", 100L), (apple) -> {
                    apple.setWeight(apple.getWeight() * 10);
                    return apple.toString();
        });
        System.out.println(green1);
    }

    public static void process(Runnable r) {
        r.run();
    }
}
