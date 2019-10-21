package com.yao.springboottest.java8.test;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLOutput;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/08/19 17:19
 */
@Data
@Slf4j
public class Test<T> {
    private String a;

    public static void main(String[] args) {
        Test test = new Test();
        test.setA("yaoyao1");
        test.eat(()-> "xxxxx"+test.toString());
    }

    public void eat(Supplier<? super T> supplier){
            if ("yaoyao".equals(a)){
                System.out.println(supplier.get());
            }else {
                System.out.println("niubi"+supplier.get());
            }

    }

}
