package com.pxg.controller;

import com.pxg.pojo.BoosLabourResponse;
import com.pxg.pojo.LabourService;
import com.pxg.pojo.WorkerMessageLabour;
import com.pxg.service.LabourServiceBeanService;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//boos查看工人申请加入企业表单
@RestController
@RequestMapping("/booslabourService")
public class BoosLabourServiceController {
    @Autowired
    private WorkerInformationService workerInformationService;
    @Autowired
    private LabourServiceBeanService labourServiceBeanService;

    @GetMapping
    BoosLabourResponse getBoosJob(int boosId) {
        ArrayList<LabourService> labourServiceBeans = labourServiceBeanService.selectBean(boosId);
        WorkerMessageLabour[] regroup = regroup(labourServiceBeans);
        BoosLabourResponse response = new BoosLabourResponse();
        response.setWorkerMessageLabours(regroup);
        return response;
    }

    private WorkerMessageLabour[] regroup(ArrayList<LabourService> list) {
        ArrayList<WorkerMessageLabour> workerMessageLabours = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            WorkerMessageLabour labour = new WorkerMessageLabour();
            int workerId = list.get(i).getWorkerid();
            labour.setWorkerId(workerId);
            labour.setWorkerName(workerInformationService.IdForName(workerId));
            workerMessageLabours.add(labour);
        }

        WorkerMessageLabour[] workerMessageLabour = new WorkerMessageLabour[workerMessageLabours.size()];
        for (int i = 0; i < workerMessageLabours.size(); i++) {
            workerMessageLabour[i] = workerMessageLabours.get(i);
        }
        return workerMessageLabour;
    }
}
