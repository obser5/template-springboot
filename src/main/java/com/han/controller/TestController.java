package com.han.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.han.model.TestPojo;
import com.han.service.TestService;
import com.han.util.ResponseWrapper;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TestController，异常会被全局异常处理类捕获，日志被切面类打印，只需调用业务，默认成功返回结果
 *
 * @author hmj
 * @since 2021/9/27
 */

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final TestService m_testService;
    @Autowired
    public TestController(TestService testService) {
        // 构造器注入
        this.m_testService = testService;
    }

    /**
     * 通过用户名和msg模糊搜索Test
     *
     * @param username 用户名
     * @param msg 其它
     * @return
     */
    @PostMapping("/listTestLike")
    public Object listTestLike(@RequestParam("username") String username,
                               @RequestParam("msg") String msg) {
        List<TestPojo> testPojoList = m_testService.listTestLike(username, msg);
        return ResponseWrapper.markSuccess(testPojoList);
    }

    /**
     * 批量添加
     *
     * @param testList
     * @return
     */
    @PostMapping("/addTestList")
    public Object addTestList(@RequestParam("testList") String testList) {
        m_testService.addTestList(JSON.parseArray(testList, TestPojo.class));
        return ResponseWrapper.markSuccess();
    }

    /**
     * 通过用户名修改密码
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/alterTest")
    public Object alterTest(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        m_testService.alterPasswordTest(username, password);
        return ResponseWrapper.markSuccess();
    }

    /**
     * 通过guid删除Test
     *
     * @param guid 唯一标识
     * @return
     */
    @PostMapping("/deleteTest")
    public Object deleteTest(@RequestParam("guid") String guid) {
        m_testService.deleteTest(guid);
        return ResponseWrapper.markSuccess();
    }
}
