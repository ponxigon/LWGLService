package com.pxg;

import com.pxg.mapper.UserMapper;
import com.pxg.pojo.User;
import com.pxg.service.UserService;
import com.pxg.service.UserServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LwglServerApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userMapper.selectList(null);
    }

    @Test
    void TestDao(){
        User user = new User();
        user.setNumber("17607092997");
        user.setPassword("19971122pxg");
        user.setAccount("企业");
        userMapper.insert(user);
    }

    @Test
    void getById(){
        int user = userService.user("17607092997", "19971122pxg");
        System.out.println(user);
    }

}
