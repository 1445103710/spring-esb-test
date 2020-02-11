package com.yao.springboottest.aop.service.impl;

import com.yao.springboottest.aop.service.DoThing;
import lombok.extern.slf4j.Slf4j;

/**
 * @className DoThingImpl
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/12/20 15:30
 */
@Slf4j
public class DoThingImpl implements DoThing {
    @Override
    public String doSome(String things) {
        log.info("开始调用>>>"+things);
        log.info("结束调用<<<");
        return "啦啦啦";
    }
}
