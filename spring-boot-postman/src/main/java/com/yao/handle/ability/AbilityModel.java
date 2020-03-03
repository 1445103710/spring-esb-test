package com.yao.handle.ability;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className AbilityModel
 * @description: 通过导出的字段生成能力相关信息
 * @author: yaoyao
 * @create: 2020/03/03 15:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbilityModel {
    /**
     * 能力名
     */
    private String abilityName;

    /**
     * 能力英文名
     */
    private String abilityEname;

    /**
     * 能力版本号
     */
    private String abilityVersion;

    /**
     * 接入协议 0 json、1 xml、2 ws，可复选要求逗号（,）分割
     */
    private List<String> inputProtocal;

    /**
     * 接出协议 0 json、1 xml、2 ws 、3 hsf等，只能单选
     */
    private String outputProtocal;

    /**
     * 备注
     */
    private String remark;

    /**
     * appCode路径
     */
    private String appCodePath;

    /**
     * 入参jsonSchema
     */
    private String reqJsonschema;

    /**
     * 出参jsonSchema
     */
    private String rspJsonschema;

    /**
     * 判断能力是否解析成功
     */
    private Boolean flag;

    /**
     * 能力解析失败原因
     */
    private String msg;
}
