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

import lombok.extern.slf4j.Slf4j;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/03 16:52
 * @Description:
 * @see com.yao.springbootzookeeper.controller
 */
@RestController
@RequestMapping("zookeeper")
@Slf4j
public class ZookeeperController {

    @Resource
    ZookeeperClient zookeeperClient;


    @RequestMapping("create")
    public Map createNode(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject data = jsonObject.getJSONObject("data");
        String path = jsonObject.getString("path");
        Map result = new HashMap(16);
        log.info(path);
        try {
            zookeeperClient.createNode(path, data.toJSONString(), CreateMode.PERSISTENT);
            log.info("创建节点"+path+",写入数据"+data.toJSONString()+",创建节点为"+CreateMode.PERSISTENT);
            result.put("code","0000");
            result.put("desc","创建节点成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("update")
    public Map update(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject data = jsonObject.getJSONObject("data");
        String path = jsonObject.getString("path");
        Map result = new HashMap(16);
        log.info(path);
        try {
            zookeeperClient.updateNode(path, data.toJSONString());
            log.info("更新节点"+path+",更新数据"+data.toJSONString()+",更新节点为"+ZookeeperClient.NodeTypeEnum.LISTENERNODE);
            result.put("code","0000");
            result.put("desc","更新节点成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("delete")
    public Map delete(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject data = jsonObject.getJSONObject("data");
        String path = jsonObject.getString("path");
        Map result = new HashMap(16);
        log.info(path);
        try {
            zookeeperClient.deleteNode(path);
            log.info("删除节点"+path+",删除数据"+data.toJSONString()+",删除节点为"+ZookeeperClient.NodeTypeEnum.LISTENERNODE);
            result.put("code","0000");
            result.put("desc","删除节点成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
}
