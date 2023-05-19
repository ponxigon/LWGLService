package com.pxg.service;

import com.pxg.controller.BoosRevampController;
import com.pxg.mapper.UserMapper;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.User;
import com.pxg.pojo.WorkerInformation;
import com.pxg.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BoosInformationService boosInformationService;

    @Autowired
    private WorkerInformationService workerInformationService;
    @Test
    void ss(){
        User user = userMapper.selectById("17607092997");
        System.out.println(user);
    }

    @Test
    void qw(){
        User sel = userService.sel("17607092997");
        System.out.println(sel);
    }

    @Test
    void zhuce(){
        int register = userService.register("111111", "222222", "工人");
        System.out.println(register);
    }

//    @Test
//    void xiugai(){
//        workerInformationService.revamp(1,"李佳功","999999999","88888888");
//    }

    @Test
    void selworker(){
        WorkerInformation workerselect = workerInformationService.workerselect(0);
        System.out.println("工人的信息"+workerselect);
    }

//    @Test
//    void dsad(){
////        int revamp = boosInformationService.revamp(0, "法国电视", "的撒旦");
////        System.out.println(revamp);
//    }

    @Test
    void fds(){
        BoosInformation boosselect = boosInformationService.boosselect(0);
        System.out.println(boosselect);
    }
}
