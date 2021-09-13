package com.han.util;

import lombok.Data;
import lombok.ToString;

/**
 * 返回值包装类
 *
 * @author hmj
 * @since 2021/9/9
 */
@Data
@ToString
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
