package com.han;

import com.han.mapper.TestMapper;
import com.han.model.TestPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class TemplateSpringbootApplicationTests {
    @Autowired
    private TestMapper m_testMapper;

    @Test
    void listTest() {
        System.out.println("");
    }
}
