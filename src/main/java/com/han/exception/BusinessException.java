package com.han.exception;

import com.han.enums.BusinessExceptionEnum;

/**
 * 业务异常类
 *
 * @author hmj
 * @since 2021/9/16
 */
public class BusinessException extends RuntimeException{

    private BusinessExceptionEnum businessExceptionEnum;

    public BusinessExceptionEnum getBusinessExceptionEnum() {
        return businessExceptionEnum;
    }

    public void setBusinessExceptionEnum(BusinessExceptionEnum businessExceptionEnum) {
        this.businessExceptionEnum = businessExceptionEnum;
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getMsg());
        this.businessExceptionEnum = businessExceptionEnum;
    }
}
