package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.LabourServiceMapper;
import com.pxg.pojo.LabourService;
import com.pxg.service.LabourServiceBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Worker申请加入企业
@Service
public class LabourServiceBeanServiceImpl extends ServiceImpl<LabourServiceMapper, LabourService> implements LabourServiceBeanService {
    @Autowired
    private LabourServiceMapper beanMapper;

    @Override
    public boolean MessageInsert(int boosId, int workerId) {
        LabourService labourServiceBean = new LabourService();
        labourServiceBean.setBoosid(boosId);
        labourServiceBean.setWorkerid(workerId);
        int insert = beanMapper.insert(labourServiceBean);
        return insert == 1;
    }

    @Override
    public ArrayList<LabourService> selectBean(int boosId) {
        LambdaQueryWrapper<LabourService> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LabourService::getBoosid, boosId);
        return (ArrayList<LabourService>) beanMapper.selectList(wrapper);
    }

    //拒绝加入企业，删除记录
    @Override
    public boolean deleteRecord(int workerId) {
        LambdaQueryWrapper<LabourService> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LabourService::getWorkerid,workerId);
        int delete = beanMapper.delete(wrapper);
        return delete != 0;
    }


}
