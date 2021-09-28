package com.han.exception;

import com.han.enums.BusinessExceptionEnum;

/**
 * 业务异常类
 *
 * @author hmj
 * @since 2021/9/16
 */
public class BusinessException extends RuntimeException{

    private BusinessExceptionEnum m_businessExceptionEnum;

    public BusinessExceptionEnum getM_businessExceptionEnum() {
        return m_businessExceptionEnum;
    }

    public void setM_businessExceptionEnum(BusinessExceptionEnum m_businessExceptionEnum) {
        this.m_businessExceptionEnum = m_businessExceptionEnum;
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getMsg());
        this.m_businessExceptionEnum = businessExceptionEnum;
    }
}
