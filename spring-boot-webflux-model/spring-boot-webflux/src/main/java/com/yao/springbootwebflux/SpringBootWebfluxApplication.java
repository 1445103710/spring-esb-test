package com.yao.springbootwebflux;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.WebFilter;

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
