package com.yao.springbootcommand;

import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/11 10:08
 * @Description:
 * @see com.yao.springbootcommand
 */
public class TestMap {
    @Test
    public void testMap(){
        Map map = new HashMap();
        map.remove("aaa");
        map.put("111","2222");
        System.out.println(JSONObject.toJSONString(map));
    }
}
