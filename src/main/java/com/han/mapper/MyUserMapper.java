package com.han.mapper;

import com.han.model.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author hmj
 * @since 2021/9/9
 */
@Mapper
public interface MyUserMapper {
    /**
     * 查询所有MyUser
     *
     * @return
     */
    List<MyUser> listAllMyUsers();

}
