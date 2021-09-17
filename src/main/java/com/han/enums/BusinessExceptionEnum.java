package com.han.enums;

/**
 * 业务异常枚举类
 *
 * @author hmj
 * @since 2021/9/16
 */
public enum BusinessExceptionEnum {
    /**
     * 用户名或密码错误
     */
    LOGIN_FAILED(1001, "用户名或密码错误"),
    /**
     * 网络连接失败
     */
    CONNECT_FAILED(1002, "网络连接失败"),
    /**
     * 数据查询失败
     */
    DB_FAILED(1003, "数据查询失败"),
    /**
     * 文件上传失败
     */
    FILE_UPLOAD_FAILED(1004, "文件上传失败");

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
