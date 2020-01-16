package com.czk.hope.util.enums;

import lombok.Getter;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/15 16:14
 */
@Getter
public enum ResultEnum {
    OTP_ERROR(10000, "短信验证码错误"),
    OTPCODE_GET_FREQUENTLY(10002, "验证码获取次数过多,请稍后再试"),
    ;

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
