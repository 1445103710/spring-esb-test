package com.yao.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ProjectName: spring-esb-test
 * @Package: com.yao.springbootdubbocustomer.service
 * @ClassName: DubboServiceImpl
 * @Description: java类作用描述
 * @Author: yaoyao
 * @CreateDate: 2019/4/13 0013 下午 05:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/13 0013 下午 05:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service(version = "1")
@Slf4j
public class DubboServiceImpl implements DubboServcie {
    @Override
    public String doService(String name) {
        log.info("调用名称:"+name);
        return "yaoyao";
    }
}
