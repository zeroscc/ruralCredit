package com.zeroscc.ruralcredit;

import com.zeroscc.ruralcredit.modules.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
            userMapper.selectList(null).forEach(System.out::println);
    }

}
