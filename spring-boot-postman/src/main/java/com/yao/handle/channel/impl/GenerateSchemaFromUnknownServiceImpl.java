package com.yao.handle.channel.impl;

import com.yao.handle.ability.AbilityModel;
import com.yao.handle.channel.GenerateSchemaService;
import org.springframework.stereotype.Service;

/**
 * @className GenerateSchemaFromRawServiceImpl
 * @description: 用于转换schema文件
 * @author: yaoyao
 * @create: 2020/03/04 13:10
 */
@Service(value = "generateSchemaFromUnknown")
public class GenerateSchemaFromUnknownServiceImpl<String> implements GenerateSchemaService<String> {

    @Override
    public void invokGeenerateReqSchema(AbilityModel abilityModel, String o) {

    }

    @Override
    public void invokGeenerateRspSchema(AbilityModel abilityModel, String o) {

    }
}
