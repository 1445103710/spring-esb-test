package com.yao.springbootdubbocustomer.controller;

import com.yao.po.Baby;
import com.yao.service.DubboServcie;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: spring-esb-test
 * @Package: com.yao.springbootdubbocustomer.controller
 * @ClassName: DubboController
 * @Description: java类作用描述
 * @Author: yaoyao
 * @CreateDate: 2019/4/13 0013 下午 05:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/13 0013 下午 05:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RequestMapping("/dubbo")
@RestController
@Slf4j
public class DubboController {
    @Reference(version = "1")
    private DubboServcie dubboServcie;

    @GetMapping("/invoke")
    public Baby invoke(@RequestParam String name){
        log.info("请求名称："+name);
        return dubboServcie.doService(name);
    }
}
