package com.yao.springbootkafkaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @className Produce
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/19 12:45
 */
@RestController
@RequestMapping(value = "kafka")
@Slf4j
public class Produce {

    @Resource
    KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "sendMsg")
    public Map sendMsg(@RequestBody String body){
        log.info("获取发送msg:{}",body);
        kafkaTemplate.send("msg",body);
        Map result = new HashMap();
        result.put("code","0");
        result.put("msg","success");
        return result;
    }

}
