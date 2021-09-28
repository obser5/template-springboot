package com.han.exception;

import com.han.enums.ServerExceptionEnum;

/**
 * 服务异常类
 *
 * @author hmj
 * @since 2021/9/27
 */
public class ServerException extends RuntimeException {
    private ServerExceptionEnum m_serverExceptionEnum;

    public ServerExceptionEnum getM_serverExceptionEnum() {
        return m_serverExceptionEnum;
    }

    public void setM_serverExceptionEnum(ServerExceptionEnum m_serverExceptionEnum) {
        this.m_serverExceptionEnum = m_serverExceptionEnum;
    }

    public ServerException(ServerExceptionEnum serverExceptionEnum) {
        super(serverExceptionEnum.getMsg());
        this.m_serverExceptionEnum = serverExceptionEnum;
    }
}
