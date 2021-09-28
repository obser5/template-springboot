package com.han.service;

import com.han.model.TestPojo;

import java.util.List;

/**
 * Test业务层接口
 *
 * @author hmj
 * @since 2021/9/27
 */
public interface TestService {
    /**
     * 获取Test（模糊搜索），当字符串为空时搜索全部
     *
     * @param username 用户名
     * @param msg      其它
     * @return
     */
    List<TestPojo> listTestLike(String username, String msg);

    /**
     * 批量添加Test
     *
     * @param testPojoList
     * @return
     */
    int addTestList(List<TestPojo> testPojoList);

    /**
     * 修改密码
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    int alterPasswordTest(String username, String password);

    /**
     * 删除Test
     *
     * @param guid 唯一标识
     * @return
     */
    int deleteTest(String guid);
}
