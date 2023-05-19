package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.LabourService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface LabourServiceBeanService extends IService<LabourService> {
    boolean MessageInsert(int boosId,int workerId);

    ArrayList<LabourService> selectBean(int boosId);

    boolean deleteRecord(int workerId);
}
