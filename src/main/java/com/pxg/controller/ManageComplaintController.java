package com.pxg.controller;

import com.pxg.pojo.ManageComplaint;
import com.pxg.pojo.ManageComplaintWorkerBean;
import com.pxg.service.ManageComplaintService;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

//Manage查看投诉列表
@RestController
@RequestMapping("/manageComplaint")
public class ManageComplaintController {
    @Autowired
    private ManageComplaintService manageComplaintService;

    @Autowired
    private WorkerInformationService workerInformationService;

    @GetMapping
    ManageComplaintWorkerBean manageComplaint(int manageId){
        ManageComplaintWorkerBean workerBean = new ManageComplaintWorkerBean();
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

        ArrayList<ManageComplaint> manageComplaints = manageComplaintService.manageLookComplaint(manageId);
        for (ManageComplaint manageComplaint : manageComplaints) {
            HashMap<String, String> hashMap = new HashMap<>();
            int workerId = manageComplaint.getWorkerid();
            String workerName = workerInformationService.IdForName(workerId);
            hashMap.put("complaintId", String.valueOf(manageComplaint.getComplaintid()));
            hashMap.put("workerName", workerName);
            arrayList.add(hashMap);
        }
        workerBean.setWorkerNameList(arrayList);
        return workerBean;
    }

}
