package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.BoosInformationService;
import com.pxg.service.LabourServiceBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//工人加入企业
@RestController
@RequestMapping("/labourService")
public class WorkerLabourServiceController {
    private Feedback feedback = new Feedback();

    @Autowired
    private BoosInformationService boosInformationService;
    @Autowired
    private LabourServiceBeanService labourServiceBeanService;

    @PostMapping
    Feedback labourService(int id, String company) {
        HashMap<String, Object> hashMap = boosInformationService.inquireCompany(company);
        if ((boolean) hashMap.get("结果")) {
            int boosId = (int) hashMap.get("id");
            boolean b = labourServiceBeanService.MessageInsert(boosId, id);
            feedback.setReminder(b);
        } else {
            feedback.setReminder(false);
        }
        return feedback;
    }
}
