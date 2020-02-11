package com.yao.springboottest.aop.handle;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @className DoHandle
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/12/20 15:35
 */
@Slf4j
public class DoHandle implements InvocationHandler {
    private Object aproxy;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("调用代理开始"+method);
        if (args!=null&&args.length>0){
            System.out.println(args[0]);
        }
        Object invoke = method.invoke(this.aproxy, args);
        log.info("调用代理结束"+method);
        return invoke;
    }

    public Object getInstance(Object aproxy){
        this.aproxy = aproxy;
        Class clazz = aproxy.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
}
