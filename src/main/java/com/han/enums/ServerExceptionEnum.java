package com.han.enums;

/**
 * 服务异常枚举类
 *
 * @author hmj
 * @since 2021/9/27
 */
public enum ServerExceptionEnum {
    /**
     * 文件为空
     */
    FILE_EMPTY(50001, "文件为空"),
    /**
     * 数据库不存在此guid
     */
    DB_GUID_NONE(50002, "数据库不存在此guid");

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

    ServerExceptionEnum(int code, String msg) {
        // 枚举类构造器默认修饰符为private
        this.code = code;
        this.msg = msg;
    }
}
