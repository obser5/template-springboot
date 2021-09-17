package com.han.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * controller层切面类，用来打印请求和响应日志
 *
 * @author hmj
 * @since 2021/9/14
 */
@Aspect
@Component // 不想用的话把@Component注释掉就可以
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    // 切入点，扫描controller包下的类的所有方法
    @Pointcut("execution(* com.han.controller..*.*(..))")

    public void webLog() {}

    /**
     * 切入点之前织入
     *
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        logger.info("========================================== Request ============================================");
        // 打印请求url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用controller的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", JSONObject.toJSON(request.getParameterMap()));
    }

    /**
     * 切入点之后织入
     */
    @After("webLog()")
    public void doAfter() {
        logger.info("");
    }

    /**
     * 环绕织入
     *
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        logger.info("========================================== Response ===========================================");
        // 打印出参
        logger.info("Response Args  : {}", JSONObject.toJSON(result));
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        logger.info("");
        return result;
    }
}
