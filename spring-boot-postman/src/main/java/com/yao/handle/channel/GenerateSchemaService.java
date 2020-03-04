package com.yao.handle.channel;

import com.yao.handle.ability.AbilityModel;

/**
 * 报文转化方法
 */
public interface GenerateSchemaService<T> {

    /**
     * 根据请求报文类型转换报文成Schema文件
     * @param abilityModel
     * @param o
     */
    void invokGeenerateReqSchema(AbilityModel abilityModel,T o);

    /**
     * 根据请求报文类型转换报文成Schema文件
     * @param abilityModel
     * @param o
     */
    void invokGeenerateRspSchema(AbilityModel abilityModel,T o);
}
