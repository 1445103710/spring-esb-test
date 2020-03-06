package com.yao.handle.channel.impl;

import com.yao.handle.ability.AbilityModel;
import com.yao.handle.channel.GenerateSchemaService;
import com.yao.handle.postman.PostmanItem;


/**
 * @className GenerateSchemaFromRawServiceImpl
 * @description: 用于转换schema文件
 * @author: yaoyao
 * @create: 2020/03/04 13:10
 */
public class GenerateSchemaFromUnknownServiceImpl implements GenerateSchemaService<PostmanItem> {

    @Override
    public void invokGeenerateSchema(AbilityModel abilityModel, PostmanItem postmanItem) {
        abilityModel.setFlag(false);
    }
}
