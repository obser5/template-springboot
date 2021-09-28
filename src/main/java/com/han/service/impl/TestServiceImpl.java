package com.han.service.impl;

import com.han.enums.BusinessExceptionEnum;
import com.han.enums.ServerExceptionEnum;
import com.han.exception.BusinessException;
import com.han.exception.ServerException;
import com.han.mapper.TestMapper;
import com.han.model.TestPojo;
import com.han.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 业务层代码将自定异常抛到controller层
 *
 * @author hmj
 * @since 2021/9/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestMapper m_testMapper;

    @Override
    public List<TestPojo> listTestLike(String username, String msg) {
        return m_testMapper.listTestLike(username, msg);
    }

    @Override
    public int addTestList(List<TestPojo> testPojoList) {
        for (TestPojo testPojo : testPojoList) {
            if (m_testMapper.getTestByUsername(testPojo.getUsername()) != null) {
                throw new BusinessException(BusinessExceptionEnum.USERNAME_EXIST);
            } else {
                testPojo.setGuid(UUID.randomUUID().toString());
            }
        }
        return m_testMapper.addTestList(testPojoList);
    }

    @Override
    public int alterPasswordTest(String username, String password) {
        if (m_testMapper.getTestByUsername(username) == null) {
            throw new BusinessException(BusinessExceptionEnum.USERNAME_NONE);
        }
        return m_testMapper.alterPasswordTest(username, password);
    }

    @Override
    public int deleteTest(String guid) {
        if (m_testMapper.getTestByGuid(guid) == null) {
            throw new ServerException(ServerExceptionEnum.DB_GUID_NONE);
        }
        return m_testMapper.deleteTest(guid);
    }
}
