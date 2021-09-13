package com.han.controller;

import com.han.model.MyUser;
import com.han.service.IMyUserService;
import com.han.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *
 * @author hmj
 * @since 2021/9/10
 */
@RestController
public class MyUserController {
    private final IMyUserService myUserService;
    @Autowired
    public MyUserController(IMyUserService myUserService) {
        // 构造方式注入
        this.myUserService = myUserService;
    }

    @PostMapping("/listAllMyUsers")
    public Object listAllMyUsers() {
        List<MyUser> myUserList = myUserService.listAllMyUsers();
        if (myUserList != null) {
            return ResponseWrapper.markSuccess(myUserList);
        } else {
            return ResponseWrapper.markError();
        }
    }
}
