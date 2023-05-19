package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.BoosJob;
import com.pxg.pojo.ManageJob;
import org.springframework.stereotype.Service;

@Service
public interface ManageJobService extends IService<ManageJob> {
    boolean addJob(int id, String complaintservice);

    ManageJob selectJob(int id);
}
