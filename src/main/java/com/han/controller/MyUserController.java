package com.han.controller;

import com.han.enums.BusinessExceptionEnum;
import com.han.exception.BusinessException;
import com.han.model.MyUser;
import com.han.service.IMyUserService;
import com.han.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * MyUser测试
 *
 * @author hmj
 * @since 2021/9/10
 */
@RestController
public class MyUserController {
    private static final Logger logger = LoggerFactory.getLogger(MyUserController.class);

    /**
     * 构造器注入，可使注入更安全
     */
    private final IMyUserService myUserService;
    @Autowired
    public MyUserController(IMyUserService myUserService) {
        Assert.notNull(myUserService, "myUserService must not be null!");
        this.myUserService = myUserService;
    }

    @GetMapping("/test")
    public Object test() {
        return ResponseWrapper.markSuccess("This is test");
    }

    @PostMapping("/test1")
    public Object test1() {
        // by zero
        int i = 1/0;
        return ResponseWrapper.markSuccess("This is test1");
    }

    @PostMapping("/test2")
    public Object test2(@RequestParam("id") int id) {
        if (id != 1) {
            // 自定义异常
            throw new BusinessException(BusinessExceptionEnum.CONNECT_FAILED);
        }
        return ResponseWrapper.markSuccess("This is test2");
    }

    @PostMapping("/test3")
    public Object test3() {
        MyUser myUser = null;
        // NullPointerException
        myUser.getUsername();
        return ResponseWrapper.markSuccess("This is test3");
    }

    @PostMapping("/listAllMyUsers")
    public Object listAllMyUsers() {
        List<MyUser> myUserList = myUserService.listAllMyUsers();
        if (myUserList == null) {
            throw new BusinessException(BusinessExceptionEnum.DB_FAILED);
        }
        return ResponseWrapper.markSuccess(myUserList);
    }

    /**
     * 没有全局异常处理类 GlobalExceptionHandler 时一般这么写
     *
     * @return
     */
    @PostMapping("/listAllMyUsers1")
    public Object listAllMyUsers1() {
        try {
            List<MyUser> myUserList = myUserService.listAllMyUsers();
            if (myUserList == null) {
                throw new BusinessException(BusinessExceptionEnum.DB_FAILED);
            }
            return ResponseWrapper.markSuccess(myUserList);
        } catch (BusinessException e) {
           logger.error("业务异常：", e);
            return ResponseWrapper.markBusinessException(BusinessExceptionEnum.DB_FAILED);
        } catch (Exception e) {
            logger.error("服务异常：", e);
            return ResponseWrapper.markServerException();
        }
    }

    @PostMapping("/getMyUserById")
    public Object getMyUserById(HttpServletRequest request) {
        String idStr = request.getParameter("id").trim();
        int id;
        if (idStr == null || idStr.equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(idStr);
        }
        MyUser myUserById = myUserService.getMyUserById(id);
        return ResponseWrapper.markSuccess(myUserById);
    }

    @PostMapping("/getMyUserById1/{id}")
    public Object getMyUserById1(@PathVariable("id") int id) {
        MyUser myUserById = myUserService.getMyUserById(id);
        return ResponseWrapper.markSuccess(myUserById);
    }
}
