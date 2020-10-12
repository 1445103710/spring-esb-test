package com.yao.springboottest.controller;

import com.yao.springboottest.mail.MailTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

    AtomicInteger atomicInteger = new AtomicInteger(0);

    @RequestMapping("/modle")
    public Map getSomeThing(@RequestBody Test2 body, @RequestHeader HttpHeaders headers){
        log.info(body.toString());
        log.info(body.toString());
        log.info(headers.toString());

        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("休息10秒钟");
        Map map = new HashMap();
        map.put("key","vlue");
        map.put("bay","vlue");
        map.put("ask",body.toString());
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
        return map;
    }
    @RequestMapping("/modle2")
    public Map getSomeThing2(@RequestBody Test2 body, @RequestHeader HttpHeaders headers){
        log.info(body.toString());
        log.info(body.toString());
        log.info(headers.toString());
        Map map = new HashMap();
        map.put("key","vlue");
        map.put("bay","vlue");
        map.put("ask",body.toString());
        log.info("结束请求modle2");
        return map;
    }
    @RequestMapping("/modle3")
    public Map getSomeThing3(@RequestBody String body, @RequestHeader HttpHeaders headers,@RequestParam(value = "test",required = false) String test){
        log.info(body);
        log.info(headers.toString());
        log.info("#########"+test);
        Map map = new HashMap();
        map.put("key","vlue");
        map.put("bay","vlue");
        map.put("ask",body.toString());
        log.info("结束请求modle3");
        return map;
    }

    @RequestMapping("/modle4")
    public Map getSomeThing4(@RequestBody String body, @RequestHeader HttpHeaders headers,@RequestParam(value = "jjj",required = false) String test,@RequestParam(value = "bbb",required = false) String test1){
        log.info(body);
        log.info(headers.toString());
        log.info("#########"+test);
        log.info("#########"+test1);
        Map map = new HashMap();
        map.put("key",test);
        map.put("bay",test1);
        map.put("ask",body.toString());
        log.info("结束请求modle3");
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



    @RequestMapping("/dol")
    public String dol(@RequestBody String body, @RequestHeader HttpHeaders headers, @RequestParam(value = "ceshi") String ceshi,@RequestParam(value = "niubi",required = false) String niubi) throws InterruptedException {
        log.info(headers.toString());
//        Thread.sleep(10000);
//        log.info("休息10秒钟");
        System.out.println("收到参数:"+ceshi);
        System.out.println("收到的报文:"+body);
        String s = LocalTime.now().toString();
        return s;
    }


    @RequestMapping("/xxl")
    public String xxl(@RequestHeader HttpHeaders headers, @RequestParam(value = "ceshi") String ceshi,@RequestParam(value = "niubi",required = false) String niubi) throws InterruptedException {
        log.info(headers.toString());
//        Thread.sleep(10000);
//        log.info("休息10秒钟");
        System.out.println("收到参数:"+ceshi);
        System.out.println("收到参数:"+niubi);
        String s = LocalTime.now().toString();
        return s;
    }

    @GetMapping("/mail")
    public String xxxxxl() throws InterruptedException, IOException {
        System.out.println("开始发送");
        String s = LocalTime.now().toString();
        MailTool.mail();
        return s;
    }
}
