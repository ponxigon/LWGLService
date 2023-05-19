package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.Vacate;
import com.pxg.pojo.VacateBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface VacateService extends IService<Vacate> {
    int vacateInsert(int boosId,int workerId,String vacateDate,String returnDate,String cause);

    VacateBean workerLookVacateState(int workerId);

    ArrayList<Vacate> boosLookVacate(int boosId);

    int replyVacate(int vacateid,boolean state);
}
