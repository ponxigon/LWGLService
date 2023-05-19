package com.pxg.controller;

import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.Feedback;
import com.pxg.service.BoosInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//boos修改资料
@RestController
@RequestMapping("/boosRevamp")
public class BoosRevampController {
    @Autowired
    private BoosInformationService boosInformationService;


    @PostMapping
    Feedback revamp(int id, String name, String company, String city) {
        int revamp = 0;
        int examineTable = examineTable(id);
        if (examineTable == 1) {
            revamp = boosInformationService.revamp(id, name, company, city);
        } else if (examineTable == -1) {
            boosInformationService.insert(id);
            revamp = boosInformationService.revamp(id, name, company, city);
        }
        return verify(revamp);
    }

    private Feedback verify(int revamp) {
        Feedback feedback = new Feedback();
        if (revamp == 1) {
            feedback.setReminder(true);
        } else if (revamp == -1) {
            feedback.setReminder(false);
        }
        return feedback;
    }

    //检测是否有表
    int examineTable(int id) {
        BoosInformation boosselect = boosInformationService.boosselect(id);
        return boosselect == null ? -1 : 1;
    }
}
