package com.yao.springboottest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @className ResultStatusEnum
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/11/04 17:12
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResultStatusEnum {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功！"),

    /**
     * 密码错误
     */
    PASSWORD_NOT_MATCHING(400, "密码错误");

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;
}