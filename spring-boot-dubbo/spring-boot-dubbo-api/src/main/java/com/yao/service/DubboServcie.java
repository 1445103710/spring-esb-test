package com.yao.service;

import com.yao.po.Baby;
import com.yao.po.Person;

import java.util.Map;

/**
 * @ProjectName: spring-esb-test
 * @Package: com.yao.service
 * @ClassName: DubboServcie
 * @Description: java类作用描述
 * @Author: yaoyao
 * @CreateDate: 2019/4/13 0013 下午 04:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/13 0013 下午 04:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
    public interface DubboServcie {

    public Baby doService(String name);

}
