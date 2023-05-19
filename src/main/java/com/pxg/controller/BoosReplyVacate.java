package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.VacateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//boos审核请假结果
@RestController
@RequestMapping("/boosReplyVacate")
public class BoosReplyVacate {
    @Autowired
    private VacateService vacateService;

    @PostMapping
    Feedback boosReplyVacate(int vacateId,boolean reply){
        System.out.println("vacateid的情况："+vacateId);
        int i = vacateService.replyVacate(vacateId, reply);
        Feedback feedback = new Feedback();
        feedback.setReminder(i==1);
        return feedback;
    }
}
