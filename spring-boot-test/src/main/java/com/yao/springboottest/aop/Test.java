package com.yao.springboottest.aop;

import com.yao.springboottest.aop.handle.DoHandle;
import com.yao.springboottest.aop.service.DoThing;
import com.yao.springboottest.aop.service.impl.DoThingImpl;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/12/20 15:52
 */
public class Test {
    public static void main(String[] args) {
        DoThing doThing = (DoThing)new DoHandle().getInstance(new DoThingImpl());
        doThing.doSome("xx");
    }
}
