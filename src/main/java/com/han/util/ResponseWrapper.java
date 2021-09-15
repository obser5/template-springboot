package com.han.util;


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
    private String code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 成功 状态码：200，状态信息：success
     *
     * @param data 数据
     * @return
     */
    public static ResponseWrapper markSuccess(Object data) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode("200");
        responseWrapper.setMsg("success");
        responseWrapper.setData(data);
        return responseWrapper;
    }

    /**
     * 失败 状态码：404，状态信息：fail
     *
     * @return
     */
    public static ResponseWrapper markError() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode("404");
        responseWrapper.setMsg("fail");
        responseWrapper.setData("");
        return responseWrapper;
    }
}
