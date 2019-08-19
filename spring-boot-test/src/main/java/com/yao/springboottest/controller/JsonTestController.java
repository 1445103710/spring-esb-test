package com.yao.springboottest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/29 14:54
 * @Description:
 * @see com.yao.springboottest.controller
 */
@RequestMapping("/test")
@RestController
@Slf4j
public class JsonTestController {
    @RequestMapping(value = "/a")
    public String getJson(HttpServletRequest request, HttpServletResponse response){
        String pathInfo = request.getPathInfo();
        String queryString = request.getQueryString();
        log.info("pathInfo:"+pathInfo);
        log.info("queryString:"+queryString);
        return queryString;
    }
}
