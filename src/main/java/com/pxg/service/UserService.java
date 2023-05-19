package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {

    int user(String number, String password);

    User sel(String number);

    int register(String number,String password,String account);

    int revamp(User user);

}
