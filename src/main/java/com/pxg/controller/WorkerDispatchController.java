package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workerDispatch")
public class WorkerDispatchController {
    @Autowired
    private WorkerInformationService workerInformationService;

    @PostMapping
    Feedback workerDispatch(int workerId,String companyrear,String operatingpost){
        return workerInformationService.BoosDispatchworker(workerId, companyrear, operatingpost);
    }
}
