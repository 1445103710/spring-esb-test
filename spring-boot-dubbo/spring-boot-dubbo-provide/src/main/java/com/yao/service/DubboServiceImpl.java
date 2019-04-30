package com.yao.service;

import com.alibaba.fastjson.JSON;
import com.yao.po.Baby;
import com.yao.po.Person;

import lombok.extern.slf4j.Slf4j;

import org.apache.dubbo.config.annotation.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
@Service(version = "2",group = "xsad")
@Slf4j
public class DubboServiceImpl implements DubboServcie {
    @Override
    public Baby doService(String name) {
        log.info("调用名称:"+name);
        Map map = new HashMap<>();
        map.put("123","234");
        map.put("date",new Date());
        map.put("Long",1232132322222L);
        map.put("INT",1);
        Baby baby = new Baby();
        baby.setCA_Baby("12132");
        Person person = new Person();
        person.setATTRS("123");
        baby.setPerson(person);
        baby.setCA_LL("12321sas");
        baby.setAGE("2132132");
        baby.setName("yai");
        map.put("baby",baby);
        System.out.println(baby);
        return baby;
    }
}
