package com.pxg.controller;

import com.pxg.pojo.BoosDispatchWorkerIm;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Boos查看派遣情况列表
@RestController
@RequestMapping("/dispatch")
public class BoosDispatchController {
    @Autowired
    private WorkerInformationService workerInformationService;

    @GetMapping
    BoosDispatchWorkerIm dispatch(String company){
        return workerInformationService.workerDispatch(company);
    }
}
