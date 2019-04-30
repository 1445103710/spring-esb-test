package com.yao.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

import lombok.Data;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/18 13:51
 * @Description:
 * @see com.yao.po
 */
@Data
public class Baby implements Serializable {
    String Name;

    String AGE;

    String CA_LL;

    String cA_Baby;

    Person person;

}
