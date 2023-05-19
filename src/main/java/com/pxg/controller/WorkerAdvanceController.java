package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.AdvanceService;
import com.pxg.service.BoosInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/workerAdvance")
public class WorkerAdvanceController {
    @Autowired
    private AdvanceService advanceService;
    @Autowired
    private BoosInformationService boosInformationService;

    @PostMapping
    Feedback workerAdvance(int workerId, String company, String money) {
        HashMap<String, Object> hashMap = boosInformationService.inquireCompany(company);
        Feedback feedback = new Feedback();
        Boolean o = (Boolean) hashMap.get("结果");
        if (o) {
            int boosId = (Integer) hashMap.get("id");
            int mon = Integer.parseInt(money);
            int i = advanceService.AdvanceInsert(boosId, workerId, mon);
            feedback.setReminder(i == 1);
        } else {
            feedback.setReminder(false);
        }
        return feedback;
    }

}
