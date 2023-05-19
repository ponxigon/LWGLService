package com.pxg.controller;

import com.pxg.pojo.VacateBean;
import com.pxg.service.VacateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workerLookVacate")
public class WorkerVacate_2 {
    @Autowired
    private VacateService vacateService;
    @GetMapping
    VacateBean getVacate(int workerId){
        return vacateService.workerLookVacateState(workerId);
    }
}
