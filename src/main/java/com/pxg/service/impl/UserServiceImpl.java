package com.pxg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.UserMapper;
import com.pxg.pojo.User;
import com.pxg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BoosJobService boosJobService;
    @Autowired
    private ManageJobService manageJobService;
    @Autowired
    private BoosInformationService boosInformationService;
    @Autowired
    private ManageInformationService manageInformationService;

    @Override
    public int user(String number, String password) {
        boolean inquire = inquire(number);
        int zh = 0;
        if (inquire) {
            User user = userMapper.selectById(number);
            if (verify(user.getNumber(), user.getPassword(), number, password)) {
                zh = 1;
            } else {
                zh = -1;
            }
        }
        return zh;
    }

    //查询返回用户体
    @Override
    public User sel(String number) {
        return userMapper.selectById(number);
    }

    //用户注册
    @Override
    public int register(String number, String password, String account) {
        boolean inquire = inquire(number);
        int result;
        if (inquire) {
            System.out.println("失败");
            result = -1;
        } else {
            System.out.println("成功");
            User user = new User();
            user.setNumber(number);
            user.setPassword(password);
            user.setAccount(account);
            userMapper.insert(user);
            result = 1;
            if (account.equals("企业")) {
                initBoosJob(number);
            } else if (account.equals("管理部门")) {
                initManageJob(number);
            }
        }
        return result;
    }

    //初始化BoosJob表单
    private void initBoosJob(String number) {
        int boosId = boosInformationService.getBoosId(number);
        boosJobService.addJob(boosId, boosId + "_labourservice",boosId+"_restservice",boosId+"_advanceservice");
    }

    //初始化manageJob表单
    private void initManageJob(String number){
        int manageId = manageInformationService.getManageId(number);
        manageJobService.addJob(manageId,manageId+"_complaintservice");
    }

    //修改账号密码
    public int revamp(User user) {
        return userMapper.updateById(user);
    }

    //查询账号是否存在
    private boolean inquire(String number) {
        User user = userMapper.selectById(number);
        return user != null;
    }

    //验证密码是否正确
    private boolean verify(String num, String psd, String number, String password) {
        boolean ver = false;
        if (number.equals(num) && password.equals(psd))
            ver = true;
        return ver;
    }
}
