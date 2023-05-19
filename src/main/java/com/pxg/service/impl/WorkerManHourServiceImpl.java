package com.pxg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.WorkerManHourMapper;
import com.pxg.pojo.WorkerManHour;
import com.pxg.service.WorkerManHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class WorkerManHourServiceImpl extends ServiceImpl<WorkerManHourMapper, WorkerManHour> implements WorkerManHourService {
    @Autowired
    private WorkerManHourMapper workerManHourMapper;

    @Override
    public WorkerManHour selectManHour(Serializable id) {
        return workerManHourMapper.selectById(id);
    }
}
