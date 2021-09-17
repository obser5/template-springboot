package com.han.exception;

import com.han.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * controller层异常处理器，可捕获controller层抛出的运行时和非运行异常，也可在controller层自行try catch处理
 *
 * @author hmj
 * @since 2021/9/16
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Object serverExceptionHandler(HttpServletRequest request, Exception e) {
        logger.info("========================================== Exception ==========================================");
        logger.error("服务异常 接口：" + request.getRequestURL().toString() + " 错误信息：" + e.getMessage());
        logger.error("堆栈简要信息：" + e.getStackTrace()[0].toString() + "...");
        // 不返回 null
        String exceptionMsg = e.getMessage();
        if (exceptionMsg == null) {
            exceptionMsg = "";
        }
        return ResponseWrapper.markServerException(exceptionMsg);
    }

    @ExceptionHandler(BusinessException.class)
    public Object businessExceptionHandler(HttpServletRequest request, BusinessException businessException) {
        logger.info("========================================== Business Exception =================================");
        logger.error("业务异常 接口：" + request.getRequestURL().toString() + " 错误码：" + businessException.getBusinessExceptionEnum().getCode() + " 错误信息：" + businessException.getBusinessExceptionEnum().getMsg());
        logger.error("堆栈简要信息：" + businessException.getStackTrace()[0].toString() + "...");
        return ResponseWrapper.markBusinessException(businessException.getBusinessExceptionEnum());
    }
}
