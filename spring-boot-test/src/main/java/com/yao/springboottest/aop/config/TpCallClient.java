package com.yao.springboottest.aop.config;

/**
 * @className TpCallClient
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/12/20 15:25
 */

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface TpCallClient {
    String value() default "";
}
