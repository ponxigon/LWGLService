package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.BoosJob;
import org.springframework.stereotype.Service;

@Service
public interface BoosJobService extends IService<BoosJob> {

    boolean addJob(int id, String labourservice, String restservice,String advanceservice);

    BoosJob selectJob(int id);
}
