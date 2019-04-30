package com.yao.springbootwebflux.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.springbootwebflux.util.GsonUtils;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/19 11:15
 * @Description:
 * @see com.yao.springbootwebflux.controller
 */
@RestController
@RequestMapping("/ceshi")
@Slf4j
public class TestController {
    @RequestMapping("/test")
    public Mono<Object> ceshi(@RequestBody String y){

        log.info(y);
        Map map = new HashMap();
        map.put("test","测试");

        return Mono.just(map);
    }

    @RequestMapping("/test2")
    public Mono<Object> ceshi2(@RequestBody String y){

        log.info(y);
        JSONObject json = new JSONObject();
        json.put("yy","yaoyao");
        json.put("xx","xiaoxiao");

        return Mono.just(json);
    }
    @RequestMapping("/test3")
    public Mono<Object> ceshi3(@RequestBody String y){

        log.info(y);
        JSONObject json = new JSONObject();
        json.put("yy","yaoyao");
        json.put("xx","xiaoxiao");

        return Mono.just(json.toJSONString());

    }
    @RequestMapping("/test4")
    public Mono<String> ceshi4(@RequestBody String y){

        log.info(y);
        JSONObject json = new JSONObject();
        json.put("yy","yaoyao");
        json.put("xx","xiaoxiao");

        return Mono.just(json.toJSONString());
    }
}
