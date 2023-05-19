package com.pxg.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.BoosDispatchWorkerIm;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.WorkerInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface WorkerInformationService extends IService<WorkerInformation> {

    int insert(int id);
    WorkerInformation workerselect(int id);

    int revamp(int id,String name,String age ,String identityCard,String bankId);

    Page<WorkerInformation> boosInquireWorker(String companyFront);

    String IdForName(int id);

    boolean JoinCompany(int id,String comopany);

    BoosDispatchWorkerIm workerDispatch(String company);

    //派遣管理
    Feedback BoosDispatchworker(int id, String companyrear, String operatingpost);
}
