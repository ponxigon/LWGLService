package com.pxg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.BoosJobMapper;
import com.pxg.pojo.BoosJob;
import com.pxg.service.BoosJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//boos工作内容
@Service
public class BoosJobServiceImpl extends ServiceImpl<BoosJobMapper, BoosJob> implements BoosJobService {

    @Autowired
    private BoosJobMapper boosJobMapper;
    @Override
    public boolean addJob(int id, String labourservice, String restservice,String advanceservice) {
        BoosJob boosJob = new BoosJob();
        boosJob.setId(id);
        boosJob.setLabourservice(labourservice);
        boosJob.setRestservice(restservice);
        boosJob.setAdvanceservice(advanceservice);
        int insert = boosJobMapper.insert(boosJob);
        return insert == 1;
    }

    @Override
    public BoosJob selectJob(int id) {
        return boosJobMapper.selectById(id);
     }


}
