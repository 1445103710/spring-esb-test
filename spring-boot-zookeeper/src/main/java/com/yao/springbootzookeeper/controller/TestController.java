package com.yao.springbootzookeeper.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.springbootzookeeper.config.RegistryCenterProperties;
import com.yao.springbootzookeeper.config.ZookeeperClient;

import org.apache.zookeeper.CreateMode;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/03 16:52
 * @Description:
 * @see com.yao.springbootzookeeper.controller
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    ZookeeperClient zookeeperClient;
    @Resource
    private RegistryCenterProperties registryCenterProperties;


    @RequestMapping("create")
    public void createNode(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject data = jsonObject.getJSONObject("data");
        String path = jsonObject.getString("path");
        Map result = new HashMap(16);
        result.put("code","0000");
        result.put("desc","创建节点成功");
        try {
            zookeeperClient.createNode(registryCenterProperties.getListenerNode()+path, data.toJSONString(), CreateMode.EPHEMERAL);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","9999");
            result.put("desc",e.toString());
        }
    }
}
