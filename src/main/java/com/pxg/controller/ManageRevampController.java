package com.pxg.controller;

import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.ManageInformation;
import com.pxg.service.ManageInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manageRevamp")
public class ManageRevampController {
    @Autowired
    private ManageInformationService manageInformationService;

    @PostMapping
    Feedback revamp(int id, String name, String city) {
        int revamp = 0;
        int examineTable = examineTable(id);
        if (examineTable==1){
            revamp = manageInformationService.revamp(id, name, city);
        } else if (examineTable==-1) {
            manageInformationService.insert(id);
            revamp = manageInformationService.revamp(id, name, city);
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
        ManageInformation manageselect = manageInformationService.manageselect(id);
        int a;
        if (manageselect == null) {
            a = -1;
        } else {
            a = 1;
        }
        return a;
    }
}
