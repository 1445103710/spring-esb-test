package com.yao.handle.channel.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yao.handle.ability.AbilityModel;
import com.yao.handle.channel.GenerateSchemaService;
import com.yao.handle.postman.PostmanItem;
import lombok.extern.slf4j.Slf4j;

import static com.yao.util.SchemaUtil.json2Schema;

/**
 * @className GenerateSchemaFromRawServiceImpl
 * @description: 用于转换schema文件
 * @author: yaoyao
 * @create: 2020/03/04 13:10
 */
@Slf4j
public class GenerateSchemaFromRawServiceImpl implements GenerateSchemaService<PostmanItem> {

    @Override
    public void invokGeenerateSchema(AbilityModel abilityModel, PostmanItem postmanItem) {
        try {
            abilityModel.setFlag(true);
            String value = postmanItem.getRequest().getBody().getRaw().getValue();
            abilityModel.setReqJsonschema(json2Schema(value));
        } catch (JsonProcessingException e) {
            abilityModel.setFlag(false);
            abilityModel.setMsg("报文解析失败！！！");
        }

    }


}
