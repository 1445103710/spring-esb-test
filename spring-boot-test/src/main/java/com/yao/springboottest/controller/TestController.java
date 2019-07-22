package com.yao.springboottest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/29 15:57
 * @Description:
 * @see com.yao.springboottest.controller
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/modle")
    public Map getSomeThing(@RequestBody String body, @RequestHeader HttpHeaders headers){
        log.info(body);
        log.info(headers.toString());
        Map map = new HashMap();
        map.put("key","vlue");
        return map;
    }
}
