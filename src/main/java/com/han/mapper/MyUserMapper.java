package com.han.mapper;

import com.han.model.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 测试Mapper
 *
 * @author hmj
 * @since 2021/9/9
 */
@Mapper
public interface MyUserMapper {
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
