package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.WorkerManHour;

import java.io.Serializable;

public interface WorkerManHourService extends IService<WorkerManHour> {

    WorkerManHour selectManHour(Serializable id);

}
