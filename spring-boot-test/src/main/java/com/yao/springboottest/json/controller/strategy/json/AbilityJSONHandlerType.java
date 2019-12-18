package com.yao.springboottest.json.controller.strategy.json;

import java.lang.annotation.*;

/**
 * @className AbilityJSONHandlerType
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/05/22 13:43
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AbilityJSONHandlerType {
    String value();
}
