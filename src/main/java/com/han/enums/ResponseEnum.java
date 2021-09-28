package com.han.enums;

/**
 * response枚举类
 *
 * @author hmj
 * @since 2021/9/16
 */
public enum ResponseEnum {
    /**
     * 成功
     */
    SUCCESS(1, "success"),
    /**
     * 失败
     */
    FAILED(0, "failed");

    /**
     * 状态码
     */
    private int code;
    /**
     * 状态信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
