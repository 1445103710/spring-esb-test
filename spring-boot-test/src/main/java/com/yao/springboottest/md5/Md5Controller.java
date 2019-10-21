package com.yao.springboottest.md5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yao.springboottest.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/29 15:57
 * @Description:
 * @see com.yao.springboottest.controller
 */
@RestController
@RequestMapping("/md5")
@Slf4j
public class Md5Controller {

    @RequestMapping("/json")
    public Map getSomeThing(@RequestBody String body, @RequestHeader HttpHeaders headers) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        log.info(body);
        log.info(headers.toString());

        JSONObject jsonObject = JSON.parseObject(body);
        String appCode = jsonObject.getString("appCode");

        String transId = jsonObject.getString("transId");

        String timestamp = String.valueOf(System.currentTimeMillis());

        String appSecret = jsonObject.getString("appSecret");

        TreeMap<String, String> paramTreeMap = new TreeMap<>();
        paramTreeMap.put("appCode", appCode);
        paramTreeMap.put("transId", transId);
        paramTreeMap.put("timestamp", timestamp);
        paramTreeMap.put("appSecret", appSecret);

        String sign = MD5Util.sign(paramTreeMap);

        Map map = new HashMap();
        map.put("code", 0);
        map.put("token", sign);
        map.put("map", paramTreeMap);
        return map;
    }
}
