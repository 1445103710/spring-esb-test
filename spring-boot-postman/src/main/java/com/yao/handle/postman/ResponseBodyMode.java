package com.yao.handle.postman;

public enum ResponseBodyMode {

    URL_ENCODED("urlencoded"),
    FILE("file"),
    RAW("raw"),
    FORM_DATA("formdata"),
    EMPTY("empty");

    private String mode;

     ResponseBodyMode(String mode) {
        this.mode = mode;
    }

    public String getMode(){
        return this.mode;
    }
}
