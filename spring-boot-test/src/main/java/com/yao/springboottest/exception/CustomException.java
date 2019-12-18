package com.yao.springboottest.exception;

import lombok.Getter;

/**
 * @className CustomException
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/11/04 17:11
 */
@Getter
public class CustomException extends RuntimeException {
    private int code;
    private String message;

    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
    }
}
