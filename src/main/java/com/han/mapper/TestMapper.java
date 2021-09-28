package com.han.mapper;

import com.han.model.TestPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Test Mapper 多参数需要@Param对应，单参数不需要
 *
 * @author hmj
 * @since 2021/9/27
 */
@Mapper
public interface TestMapper {
    /**
     * 获取所有Test
     *
     * @return
     */
    List<TestPojo> listTest();

    /**
     * 获取Test（模糊搜索），当字符串为空时搜索全部
     *
     * @param username 用户名
     * @param msg      其它
     * @return
     */
    List<TestPojo> listTestLike(@Param("username") String username, @Param("msg") String msg);

    /**
     * 通过用户名获取Test
     *
     * @param username 用户名
     * @return
     */
    TestPojo getTestByUsername(String username);

    /**
     * 通过guid获取Test
     *
     * @param guid 唯一标识
     * @return
     */
    TestPojo getTestByGuid(String guid);

    /**
     * 添加Test
     *
     * @param testPojo
     * @return
     */
    int addTest(TestPojo testPojo);

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
    int alterPasswordTest(@Param("username") String username, @Param("password") String password);

    /**
     * 删除Test
     *
     * @param guid 唯一标识
     * @return
     */
    int deleteTest(String guid);
}
