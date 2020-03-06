package com.yao.handle.channel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 用于postman转json方法
 */
@RequiredArgsConstructor
@Getter
public enum GenetateSchemaEnum {

    URL_ENCODED("urlencoded"),
    FILE("file"),
    RAW("raw"),
    FORM_DATA("formdata"),
    EMPTY("empty");

    private final String code;

}
