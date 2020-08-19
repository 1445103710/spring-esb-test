package com.yao.springboottest.mail;

import java.util.HashMap;
import java.util.Map;

/**
 * @className ResultUtils
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/23 15:13
 */
public class ResultUtils {

    public static Map<String, Object> getFaildResultData(String o){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code",0);
        map.put("msg",o);
        return map;
    }

    public static Map<String, Object> getSuccessResultData(String o){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code",0);
        map.put("msg",o);
        return map;
    }
}
