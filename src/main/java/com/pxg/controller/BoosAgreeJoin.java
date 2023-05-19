package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.LabourServiceBeanService;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//boos审核加入企业
@RestController
@RequestMapping("/boosagree")
public class BoosAgreeJoin {
    @Autowired
    private WorkerInformationService workerInformationService;

    @Autowired
    private LabourServiceBeanService labourServiceBeanService;

    @PostMapping
    Feedback joinCompany(int workerId, String company, boolean auditResult){
        Feedback feedback = new Feedback();
        if (auditResult){
            feedback.setPremise(true);
            feedback.setReminder(workerInformationService.JoinCompany(workerId, company));
            labourServiceBeanService.deleteRecord(workerId);
        }else {
            feedback.setPremise(false);
            feedback.setReminder(labourServiceBeanService.deleteRecord(workerId));
        }
        return feedback;
    }
}
