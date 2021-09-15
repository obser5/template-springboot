package com.han;

import com.han.mapper.MyUserMapper;
import com.han.model.MyUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateSpringbootApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(TemplateSpringbootApplicationTests.class);

    @Autowired
    private MyUserMapper myUserMapper;

    @Test
    void myUserTest() {
        for (MyUser myUser : myUserMapper.listAllMyUsers()) {
            logger.info("测试成功！");
            System.out.println(myUser);
        }
    }
}
