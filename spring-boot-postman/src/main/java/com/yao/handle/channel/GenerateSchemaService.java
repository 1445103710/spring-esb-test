package com.yao.handle.channel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yao.handle.ability.AbilityModel;

/**
 * 报文转化方法
 */
public interface GenerateSchemaService<T> {

    /**
     * 根据报文类型转换报文成Schema文件
     * @param abilityModel
     * @param o
     */
    void invokGeenerateSchema(AbilityModel abilityModel,T o) throws JsonProcessingException;
}
