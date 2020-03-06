package com.yao.handle.channel.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yao.handle.ability.AbilityModel;
import com.yao.handle.channel.GenerateSchemaService;
import com.yao.handle.postman.PostmanItem;
import com.yao.util.SchemaUtil;
import com.yao.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @className GenerateSchemaFromRawServiceImpl
 * @description: 用于转换schema文件
 * @author: yaoyao
 * @create: 2020/03/04 13:10
 */
@Slf4j
public class GenerateSchemaFromRawServiceImpl implements GenerateSchemaService<PostmanItem> {

    @Override
    public void invokGeenerateSchema(AbilityModel abilityModel, PostmanItem postmanItem) throws JsonProcessingException {
        String value = postmanItem.getRequest().getBody().getRaw().getValue();
        if (value != null) {
            if (value.startsWith("{")) {
                abilityModel.setReqJsonschema(SchemaUtil.json2Schema(value));
                abilityModel.setInputProtocal(Arrays.asList("json"));
                abilityModel.setOutputProtocal("json");
            } else if (value.startsWith("<")) {
                abilityModel.setReqJsonschema(SchemaUtil.json2Schema(XmlUtil.convertXmlToJson(value)));
                abilityModel.setInputProtocal(Arrays.asList("xml"));
                abilityModel.setOutputProtocal("xml");
            } else {
                abilityModel.setError("请求报文为空");
            }
        } else {
            abilityModel.setError("请求报文格式不支持解析");
        }
        abilityModel.setRspJsonschema("1122");

    }


}
