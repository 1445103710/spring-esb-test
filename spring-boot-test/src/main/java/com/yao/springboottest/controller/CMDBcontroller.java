package com.yao.springboottest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className CMDBcontroller
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/07/11 17:11
 */

@RestController
public class CMDBcontroller {

    @RequestMapping("/app/projectManager/selectAll")
    public String get1(String json){
        String a =  "{\n" +
                "  \"code\": 0,\n" +
                "  \"message\": \"\",\n" +
                "  \"data\": {\n" +
                "    \"rows\": [\n" +
                "      {\n" +
                "        \"projectId\": 28,\n" +
                "        \"projectName\": \"昊天平台资源管控\",\n" +
                "        \"projectDesc\": \"节点测试用\",\n" +
                "        \"personName\": \"王宇\",\n" +
                "        \"createTime\": \"2019-04-23 10:46:58\",\n" +
                "        \"modifyTime\": \"2019-04-23 10:46:58\",\n" +
                "        \"forShort\": \"资源管控\",\n" +
                "        \"englishName\": \"ziyuangunakong\",\n" +
                "        \"callCircuit\": \"中台\",\n" +
                "        \"englishShort\": \"CMDB\",\n" +
                "        \"APPId\": \"HAOTIAN-CMDB\",\n" +
                "        \"groupId\": \"HAOTIAN\",\n" +
                "        \"artifactId\": \"CMDB\",\n" +
                "        \"serverCount\": 0,\n" +
                "        \"serverCloudType\": 1,\n" +
                "        \"hireId\": 1\n" +
                "      }\n" +
                "    ],\n" +
                "    \"recordsTotal\": 1\n" +
                "  }\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(a);
        return jsonObject.toString();
    }


    @RequestMapping("/app/envManager/selectAll")
    public String get2(String json){
        String a =  "{\n" +
                "  \"code\": 0,\n" +
                "  \"message\": \"\",\n" +
                "  \"data\": {\n" +
                "    \"rows\": [\n" +
                "      {\n" +
                "        \"serverCount\": 1,\n" +
                "        \"projectId\": 28,\n" +
                "        \"projectName\": \"西安跑一次\",\n" +
                "        \"envId\": 13,\n" +
                "        \"envName\": \"高新测试\",\n" +
                "        \"envDesc\": \"西安最多跑一次高新测试环境\",\n" +
                "        \"createTime\": \"2019-04-24 17:10:57\",\n" +
                "        \"modifyTime\": \"2019-04-24 17:10:57\",\n" +
                "        \"serverCloudType\": 0,\n" +
                "        \"hireId\": 1\n" +
                "      }]\n" +
                "}\n" +
                "}";
        System.out.println(a);
        JSONObject jsonObject = JSONObject.parseObject(a);
        return jsonObject.toString();
    }



    @RequestMapping("/app/clusterManager/selectAll")
    public String get3(String json){
        String a =  "{\n" +
                "  \"code\": 0,\n" +
                "  \"message\": \"\",\n" +
                "  \"data\": {\n" +
                "    \"rows\": [\n" +
                "      {\n" +
                "        \"projectName\": \"昊天平台资源管控\",\n" +
                "        \"projectId\": 28,\n" +
                "        \"envId\": 13,\n" +
                "        \"envName\": \"测试环境\",\n" +
                "        \"clusterId\": 125,\n" +
                "        \"clusterName\": \"节点测试集群\",\n" +
                "        \"clusterDesc\": \"节点测试用\",\n" +
                "        \"createTime\": \"2019-04-23 11:25:49\",\n" +
                "        \"modifyTime\": \"2019-05-06 16:27:56\",\n" +
                "        \"isparticulars\": 1,\n" +
                "        \"slbAddress\": \"120.32.225.254\",\n" +
                "        \"downState\": \"\",\n" +
                "        \"cluType\": 2\n" +
                "      }\n" +
                "    ],\n" +
                "    \"recordsTotal\": 1\n" +
                "  }\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(a);
        return jsonObject.toString();
    }
}
