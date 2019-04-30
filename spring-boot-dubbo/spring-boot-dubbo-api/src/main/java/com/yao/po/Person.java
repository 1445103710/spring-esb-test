package com.yao.po;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/18 12:28
 * @Description:
 * @see com.yao.po
 */
@Data
public class Person {

    @JSONField(name="ATTRS")
    String ATTRS;
}
