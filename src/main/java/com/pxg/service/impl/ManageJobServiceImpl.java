package com.pxg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.ManageJobMapper;
import com.pxg.pojo.ManageJob;
import com.pxg.service.ManageJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageJobServiceImpl extends ServiceImpl<ManageJobMapper, ManageJob> implements ManageJobService {

    @Autowired
    private ManageJobMapper manageJobMapper;
    @Override
    public boolean addJob(int id, String complaintservice) {
        ManageJob manageJob = new ManageJob();
        manageJob.setId(id);
        manageJob.setComplaintservice(complaintservice);
        int insert = manageJobMapper.insert(manageJob);
        return insert == 1;
    }

    @Override
    public ManageJob selectJob(int id) {
        return manageJobMapper.selectById(id);
    }
}
