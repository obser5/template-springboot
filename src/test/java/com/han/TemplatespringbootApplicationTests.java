package com.han;

import com.han.mapper.MyUserMapper;
import com.han.model.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplatespringbootApplicationTests {
    @Autowired
    private MyUserMapper myUserMapper;

    @Test
    void contextLoads() {
        for (MyUser myUser : myUserMapper.listAllMyUsers()) {
            System.out.println(myUser);
        }
    }
}
