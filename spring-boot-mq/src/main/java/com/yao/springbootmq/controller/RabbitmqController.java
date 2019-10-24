package com.yao.springbootmq.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @className RabbitmqController
 * @description: rabbitMq的实现
 * @author: yaoyao
 * @create: 2019/10/23 20:57
 */
@RestController
@RequestMapping("/rabbitMq")
@Slf4j
public class RabbitmqController {

    @RequestMapping(value = "/mq")
    public Map putMq(@RequestBody String test){
        log.info("入参>>>"+test);
        Map<String,String>map = Maps.newHashMap();
        map.put("code","0");
        map.put("desc","成功");
        log.info("出参>>>"+map);
        return map;
    }
}
