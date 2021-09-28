package com.han.controller;

import com.alibaba.fastjson.JSON;
import com.han.model.TestPojo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hmj
 * @since 2021/9/27
 */
@RestController
public class JsonController {

    /**
     * fastjson用法
     *
     * @param jsonArrayStr
     * @param jsonObjectStr
     */
    @PostMapping("/testJson")
    public void testJson(@RequestParam(value = "jsonArrayStr", required = false) String jsonArrayStr,
                         @RequestParam(value = "jsonObjectStr", required = false) String jsonObjectStr) {
        // String转JSONArray
        JSON.parseArray(jsonArrayStr);
        // String转JSONObject
        JSON.parseObject(jsonObjectStr);
        // String转java对象
        JSON.parseObject(jsonObjectStr, TestPojo.class);
        // String转java List
        JSON.parseArray(jsonArrayStr, TestPojo.class);
    }
}
