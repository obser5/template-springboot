package com.han.service.impl;

import com.han.mapper.MyUserMapper;
import com.han.model.MyUser;
import com.han.service.IMyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author hmj
 * @since 2021/9/10
 */
@Service
@Transactional(rollbackFor = Exception.class) // 非运行时异常时也可回滚
public class MyUserImpl implements IMyUserService {
    /**
     * 构造器注入
     */
    private final MyUserMapper myUserMapper;
    @Autowired
    public MyUserImpl(MyUserMapper myUserMapper) {
        Assert.notNull(myUserMapper, "myUserMapper must not by null!");
        this.myUserMapper = myUserMapper;
    }

    @Override
    public List<MyUser> listAllMyUsers() {
        return myUserMapper.listAllMyUsers();
    }

    @Override
    public MyUser getMyUserById(int id) {
        return myUserMapper.getMyUserById(id);
    }
}
