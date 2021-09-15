package com.han.controller;

import com.han.model.MyUser;
import com.han.service.IMyUserService;
import com.han.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * 测试controller
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
        return "success";
    }

    @PostMapping("/listAllMyUsers")
    public Object listAllMyUsers() {
        try {
            List<MyUser> myUserList = myUserService.listAllMyUsers();
            if (myUserList != null) {
                return ResponseWrapper.markSuccess(myUserList);
            }
        } catch (Exception e) {
            logger.error("服务错误：", e);
        }
        return ResponseWrapper.markError();
    }

    @PostMapping("/getMyUserById_1")
    public Object getMyUserById_1(HttpServletRequest request) {
        try {
            String idStr = request.getParameter("id").trim();
            int id;
            if (idStr == null || idStr.equals("")) {
                id = 0;
            } else {
                id = Integer.parseInt(idStr);
            }
            MyUser myUserById = myUserService.getMyUserById(id);
            if (myUserById != null) {
                return ResponseWrapper.markSuccess(myUserById);
            }
        } catch (Exception e) {
            logger.error("服务错误：", e);
        }
        return ResponseWrapper.markError();
    }

    @PostMapping("/getMyUserById_2")
    public Object getMyUserById_2(@RequestParam("id") int id) {
        try {
            MyUser myUserById = myUserService.getMyUserById(id);
            if (myUserById != null) {
                return ResponseWrapper.markSuccess(myUserById);
            }
        } catch (Exception e) {
            logger.error("服务错误：", e);
        }
        return ResponseWrapper.markError();
    }

    @PostMapping("/getMyUserById_3/{id}")
    public Object getMyUserById_3(@PathVariable("id") int id) {
        try {
            MyUser myUserById = myUserService.getMyUserById(id);
            if (myUserById != null) {
                return ResponseWrapper.markSuccess(myUserById);
            }
        } catch (Exception e) {
            logger.error("服务错误：", e);
        }
        return ResponseWrapper.markError();
    }

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return "上传失败，请选择文件！";
        }
        String fileName = file.getOriginalFilename();
        // 指定存放位置
        String filePath = "C:\\Users\\96176\\Desktop\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功！");
            return "上传成功！";
        } catch (Exception e) {
            logger.error("服务错误：", e);
        }
        return "上传失败！";
    }
}
