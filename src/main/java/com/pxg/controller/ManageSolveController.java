package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.ManageComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//manage处理投诉
@RestController
@RequestMapping("/manageSolve")
public class ManageSolveController {
    @Autowired
    private ManageComplaintService manageComplaintService;

    @PostMapping
    Feedback manageSolve(int complaintId){
        boolean b = manageComplaintService.manageSolve(complaintId);
        Feedback feedback = new Feedback();
        feedback.setReminder(b);
        return feedback;
    }
}
