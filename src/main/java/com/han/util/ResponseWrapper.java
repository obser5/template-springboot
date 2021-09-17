package com.han.util;


import com.han.enums.BusinessExceptionEnum;
import com.han.enums.ResponseEnum;

/**
 * 返回值包装类 {"code":int, "msg":String, "data":Object}
 *
 * @author hmj
 * @since 2021/9/9
 */
public class ResponseWrapper {
    /**
     * 状态码
     */
    private int code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private ResponseWrapper(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 成功
     *
     * @param data 数据
     * @return
     */
    public static ResponseWrapper markSuccess(Object data) {
        return new ResponseWrapper(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 服务异常
     *
     * @return
     */
    public static ResponseWrapper markServerException() {
        return new ResponseWrapper(ResponseEnum.FAILED.getCode(), ResponseEnum.FAILED.getMsg(), "");
    }

    /**
     * 服务异常，可打印异常信息
     *
     * @param exceptionMsg
     * @return
     */
    public static ResponseWrapper markServerException(String exceptionMsg) {
        return new ResponseWrapper(ResponseEnum.FAILED.getCode(), exceptionMsg, "");
    }
    /**
     * 业务异常
     *
     * @param businessExceptionEnum 业务异常枚举类
     * @return
     */
    public static ResponseWrapper markBusinessException(BusinessExceptionEnum businessExceptionEnum) {
        return new ResponseWrapper(businessExceptionEnum.getCode(), businessExceptionEnum.getMsg(), "");
    }
}
