package com.yao.springbootwebserviceclient.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className TestScript
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/11/01 15:43
 */
public class TestScript {
    @Test
    public void test(){
        Map map = new HashMap();
        JSONObject.toJSONString(map);
        JSONObject jsonObject = new JSONObject();
        JSON.toJSONString(map);

    }
}
