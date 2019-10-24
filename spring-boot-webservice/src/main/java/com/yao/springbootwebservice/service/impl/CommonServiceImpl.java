package com.yao.springbootwebservice.service.impl;

import com.yao.springbootwebservice.service.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @className CommonServiceImpl
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/10/22 14:58
 */
@WebService(serviceName = "CommonService",//与前面接口一致
        targetNamespace = "http://www.WebService.demo.example.com",  //与前面接口一致
        endpointInterface = "com.yao.springbootwebservice.service.CommonService")  //接口地址
@Component
public class CommonServiceImpl implements CommonService {
    @Override
    public String HelloWorld(String name) {
        return "Hello World!!! --->"+name;
    }
}
