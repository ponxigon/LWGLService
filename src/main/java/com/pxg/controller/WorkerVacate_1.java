package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.BoosInformationService;
import com.pxg.service.VacateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//请假申请
@RestController
@RequestMapping("/vacate1")
public class WorkerVacate_1 {
    @Autowired
    private VacateService vacateService;
    @Autowired
    private BoosInformationService boosInformationService;

    @PostMapping
    Feedback vacate1(int workerId, String company, String vacateDate, String returnDate, String vacateCause) {
        HashMap<String, Object> hashMap = boosInformationService.inquireCompany(company);
        Feedback feedback = new Feedback();
        Boolean o = (Boolean) hashMap.get("结果");
        if (!o){
            feedback.setReminder(false);
        }else {
            int boosId = (int) hashMap.get("id");
            int i = vacateService.vacateInsert(boosId, workerId, vacateDate, returnDate, vacateCause);
            feedback.setReminder(i == 1);
        }

        return feedback;
    }
}
