package com.han.util;


import com.han.enums.ResponseEnum;

/**
 * 返回值包装类
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
     * @return
     */
    public static ResponseWrapper markSuccess() {
        return new ResponseWrapper(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), "");
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
     * 失败
     *
     * @return
     */
    public static ResponseWrapper markFailed() {
        return new ResponseWrapper(ResponseEnum.FAILED.getCode(), ResponseEnum.FAILED.getMsg(), "");
    }

    /**
     * 失败
     *
     * @return
     */
    public static ResponseWrapper markFailed(Object data) {
        return new ResponseWrapper(ResponseEnum.FAILED.getCode(), ResponseEnum.FAILED.getMsg(), data);
    }

}
