package com.pxg.controller;

import com.pxg.pojo.UserResult;
import com.pxg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用户注册
@RestController
@RequestMapping("/user_login")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    UserResult userRegister(String number, String password, String account) {
        int register = userService.register(number, password, account);
        UserResult userResult = new UserResult();
        userResult.setZh(register);
        return userResult;
    }
}
