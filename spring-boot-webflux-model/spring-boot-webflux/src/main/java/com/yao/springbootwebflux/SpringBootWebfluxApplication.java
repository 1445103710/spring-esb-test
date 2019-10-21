package com.yao.springbootwebflux;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxApplication.class, args);
    }
//    @Bean
//    @Order(-1)
//    public WebFilter bodyWebFilter() {
//        return new BodyWebFilter();
//    }
}
