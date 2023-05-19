package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.BoosImMapper;
import com.pxg.mapper.UserMapper;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.User;
import com.pxg.service.BoosInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//企业资料
@Service
public class BoosInformationServiceImpl extends ServiceImpl<BoosImMapper, BoosInformation> implements BoosInformationService {

    @Autowired
    private BoosImMapper boosImMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public BoosInformation boosselect(int id) {
        return boosImMapper.selectById(id);
    }

    @Override
    public int insert(int id) {
        BoosInformation boosInformation = new BoosInformation();
        boosInformation.setId(id);
        return boosImMapper.insert(boosInformation);
    }

    @Override
    public int revamp(int id, String name, String company, String city) {
        BoosInformation boosInformation = new BoosInformation();
        boosInformation.setId(id);
        boosInformation.setName(name);
        boosInformation.setCompany(company);
        boosInformation.setCity(city);
        return boosImMapper.updateById(boosInformation);
    }

    @Override
    public Page<BoosInformation> manageInquireBoos(String city) {
        QueryWrapper<BoosInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city", city);
        IPage<BoosInformation> page = new Page<>(1, 50);
        return (Page<BoosInformation>) boosImMapper.selectPage(page, queryWrapper);
    }

    //查询企业是否存在
    @Override
    public HashMap<String, Object> inquireCompany(String company) {
        LambdaQueryWrapper<BoosInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BoosInformation::getCompany, company);
        List<BoosInformation> list = boosImMapper.selectList(wrapper);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("结果", list.size() != 0);
        if (list.size() != 0) {
            hashMap.put("id", list.get(0).getId());

        }
        return hashMap;
    }

    //根据账号查id
    @Override
    public int getBoosId(String number) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getNumber,number);
        return userMapper.selectList(wrapper).get(0).getId();
    }

    @Override
    public String getBoosCity(String company) {
        LambdaQueryWrapper<BoosInformation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BoosInformation::getCompany,company);
        List<BoosInformation> boosInformations = boosImMapper.selectList(queryWrapper);
        String city;
        if (boosInformations.size()!=0){
            city = boosInformations.get(0).getCity();
        }else {
            return null;
        }
        return city;
    }

}
