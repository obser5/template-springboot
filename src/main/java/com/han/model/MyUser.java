package com.han.model;

import lombok.Data;
import lombok.ToString;

/**
 * 测试pojo类
 *
 * @author hmj
 * @since 2021/9/9
 */
@Data
@ToString
public class MyUser {
    private int id;
    private String username;
    private String password;
    private String token;
}
