package com.siemens.brownfield.femanagement.common;

public enum CommonBusinessCode {
    FAIL("fail",999),
    INTERNAL_ERROR("internal error", 500);

    private String message;

    private Integer code;

    CommonBusinessCode(String message, Integer code){
        this.message = message;
        this.code = code;
    }
}
