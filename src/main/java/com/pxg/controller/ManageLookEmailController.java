package com.pxg.controller;

import com.pxg.pojo.ComplaintEmail;
import com.pxg.service.ManageComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//manage查看邮件内容
@RestController
@RequestMapping("/manageLookMail")
public class ManageLookEmailController {
    @Autowired
    private ManageComplaintService manageComplaintService;
    @GetMapping
    ComplaintEmail manageLookMail(int complaintid){
        return manageComplaintService.manageLookEmail(complaintid);
    }
}
