package com.pxg.controller;

import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.WorkerInformation;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//工人资料修改
@RestController
@RequestMapping("/workerRevamp")
public class WorkerRevampController {
    @Autowired
    WorkerInformationService workerInformationService;

    @PostMapping
    Feedback revamp(int id, String name, String age, String identityCard, String bankId) {
        int revamp = 0;
        int examineTable = examineTable(id);
        if (examineTable == 1) {
            revamp = workerInformationService.revamp(id, name,age, identityCard, bankId);
        } else if (examineTable == -1) {
            workerInformationService.insert(id);
            revamp = workerInformationService.revamp(id, name,age , identityCard, bankId);
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
        WorkerInformation workerselect = workerInformationService.workerselect(id);
        int a;
        if (workerselect == null) {
            a = -1;
        } else {
            a = 1;
        }
        return a;
    }
}
