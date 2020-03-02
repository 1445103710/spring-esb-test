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

    int i = 0;

    @RequestMapping("/modle")
    public Map getSomeThing(@RequestBody String body, @RequestHeader HttpHeaders headers){
        log.info(body);
        log.info(headers.toString());
        Map map = new HashMap();
        map.put("key","vlue");
        map.put("bay","vlue");
        map.put("ask",body);
        return map;
    }


    @RequestMapping("/oauth2")
    public String oauth2(@RequestBody String body, @RequestHeader HttpHeaders headers){
        log.info(body);
        log.info(headers.toString());
        System.out.println("收到请求:"+body);
        String s = "{\"success\":true,\"resultMessage\":\"\",\"resultCode\":\"0000\",\"result\":{\"uid\":\"7856508607\",\"refresh_token_expires\":1567388177887,\"time\":1551663377887,\"expires_in\":86400,\"refresh_token\":\"refresh_token\",\"access_token\":\""+(i++)+"\"}}";
        return s;
    }
}
