package com.han.service;

import com.han.model.MyUser;

import java.util.List;


/**
 * @author hmj
 * @since 2021/9/10
 */
public interface IMyUserService {
    /**
     * 查找所有MyUser
     *
     * @return
     */
     List<MyUser> listAllMyUsers();

    /**
     * 通过id查找MyUser
     *
     * @param id t_myuser主键
     * @return
     */
     MyUser getMyUserById(int id);
}
