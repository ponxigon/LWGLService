package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.ManageImMapper;
import com.pxg.mapper.UserMapper;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.ManageInformation;
import com.pxg.pojo.User;
import com.pxg.service.ManageInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageInformationServiceImpl extends ServiceImpl<ManageImMapper, ManageInformation> implements ManageInformationService {
    @Autowired
    private ManageImMapper manageImMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ManageInformation manageselect(int id) {
        return manageImMapper.selectById(id);
    }

    @Override
    public int insert(int id) {
        ManageInformation manageInformation = new ManageInformation();
        manageInformation.setId(id);
        return manageImMapper.insert(manageInformation);
    }

    @Override
    public int revamp(int id, String name, String city) {
        ManageInformation manageInformation = new ManageInformation();
        manageInformation.setId(id);
        manageInformation.setName(name);
        manageInformation.setCity(city);
        return manageImMapper.updateById(manageInformation);
    }

    //根据账号查id
    @Override
    public int getManageId(String number) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getNumber,number);
        return userMapper.selectList(wrapper).get(0).getId();
    }

}
