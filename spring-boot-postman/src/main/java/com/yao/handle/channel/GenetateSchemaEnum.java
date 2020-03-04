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

    URL_ENCODED("urlencoded","generateSchemaFromUnknown"),
    FILE("file","generateSchemaFromUnknown"),
    RAW("raw","generateSchemaFromRaw"),
    FORM_DATA("formdata","generateSchemaFromUnknown"),
    EMPTY("empty","generateSchemaFromUnknown");

    private final String code;

    private final String name;

    public static String getServiceName(String code) {
        return Arrays.asList(GenetateSchemaEnum.values())
                .stream()
                .filter(a -> a.getCode().equals(code))
                .findFirst()
                .orElse(GenetateSchemaEnum.EMPTY)
                .getName();
    }

}
