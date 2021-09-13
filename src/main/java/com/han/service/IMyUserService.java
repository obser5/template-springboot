package com.han.service;

import com.han.model.MyUser;

import java.util.List;


/**
 * @author hmj
 * @since 2021/9/10
 */
public interface IMyUserService {
    /**
     * 查询所有MyUser
     *
     * @return
     */
     List<MyUser> listAllMyUsers();
}
