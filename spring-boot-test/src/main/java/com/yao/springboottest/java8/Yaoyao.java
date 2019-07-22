package com.yao.springboottest.java8;

import lombok.ToString;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

/**
 * @className Yaoyao
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/07/19 11:38
 */
@ToString
public class Yaoyao {

    private String name;

    private int age;

    private Boolean clever;


    public static class Builder{

        private String name;

        private int age;

        private Boolean clever = true;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }


        public Builder clever(Boolean clever){
            this.clever = clever;
            return this;
        }

        public Yaoyao build(){
            return new Yaoyao(this);
        }

    }
    public Yaoyao(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.clever = builder.clever;
    }


    public static void main(String[] args) {
        Yaoyao yaoyao = new Builder().name("yaoyao").age(12).build();
        System.out.println(yaoyao);
    }
}
