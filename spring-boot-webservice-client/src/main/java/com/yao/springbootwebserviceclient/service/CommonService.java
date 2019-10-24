package com.yao.springbootwebserviceclient.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @className CommonService
 * @description: WebService接口
 * @author: yaoyao
 * @create: 2019/10/22 14:57
 */

@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://www.WebService.demo.example.com")   //命名空间,一般是接口的包名倒序
public interface CommonService {
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    public String HelloWorld(@WebParam(name = "HelloName") String name);
}
