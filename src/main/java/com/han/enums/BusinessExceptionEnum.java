package com.han.enums;

/**
 * 业务异常枚举类
 *
 * @author hmj
 * @since 2021/9/16
 */
public enum BusinessExceptionEnum {
    /**
     * 用户名重复
     */
    USERNAME_EXIST(40001, "用户名重复"),
    /**
     * 用户名不存在
     */
    USERNAME_NONE(40002, "用户名不存在");

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    BusinessExceptionEnum(int code, String msg) {
        // 枚举类构造器默认修饰符为private
        this.code = code;
        this.msg = msg;
    }
}
